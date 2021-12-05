package alone.spring.repository;
import alone.spring.domain.Member;
import java.util.List;
import java.util.Optional;
public interface MemberRepository {
        Member save(Member member); //Optional은 Null값을 처리해주는 방식
        Optional<Member> findById(Long id);
        Optional<Member> findByName(String name);
        List<Member> findAll();

}
