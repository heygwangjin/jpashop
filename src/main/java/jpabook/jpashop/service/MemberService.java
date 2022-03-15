package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true) // 조회 메서드에 적용된다.
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional // DB 상태 변경되는 메서드에 적용
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    //특정 회원 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}