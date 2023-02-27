package auction.carrot.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberRepository repository;

    @PostMapping
    public ResponseEntity<List<Member>> createMember() {
        Member member1 = new Member("example1.com");
        Member member2 = new Member("example2.com");
        Member member3 = new Member("example3.com");
        Member m1 = repository.save(member1);
        Member m2 = repository.save(member2);
        Member m3 = repository.save(member3);

        List<Member> members = new ArrayList<>();
        members.add(m1);
        members.add(m2);
        members.add(m3);
        return ResponseEntity.ok().body(members);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = repository.findAll();
        return ResponseEntity.ok().body(members);
    }
}
