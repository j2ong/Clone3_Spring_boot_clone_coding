package alone.spring.controller;
import alone.spring.domain.Member;
import alone.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
private final MemberService memberService;
@Autowired
public MemberController(MemberService memberService) {


        this.memberService = memberService;
        }

        @GetMapping("/members/new")
        public String CreateForm(){
                return "members/createMemberForm";
        }

        @PostMapping("/members/new") //createMemberForm.html에서 post된 결과를 맵핑함, (url 같음)
        public String create(MemberForm form) { //memberForm Class의 값으로 들어감
                Member member = new Member();
                member.setName(form.getName()); //인자로 form이 MemberForm에 들어갔었음. form.getName()으로 꺼냄

                memberService.join(member);

                return "redirect:/"; //회원가입 후, 홈으로 돌려보냄
        }

        @GetMapping("/members")
        public String list(Model model){
                List<Member> members = memberService.findMembers();
                model.addAttribute("members", members); //members 전체를 모델에 담은다음, 리스트로 넘김
                return "members/memberList";
        }
}