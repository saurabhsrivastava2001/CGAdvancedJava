package service;

import java.util.List;

import org.springframework.stereotype.Service;
import model.Member;
import repository.MemberRepository;

@Service
public class MemberService {

    private MemberRepository repo;
    int initialID=1;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public void registerMember(String name, String email) {
        Member member =
            new Member((long)initialID++,
                       name, email);
        repo.save(member);
        System.out.println("Member Registered Successfully");
    }

    public List<Member> getAllMembers() {
        return repo.findAll();
    }
}