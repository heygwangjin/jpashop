package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // Test 케이스에 있으면 기본적으로 Rollback 시킨다.
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        Member member = Member.builder()
                .name("김광진")
                .address(Address.builder().city("서울특별시 강남구").street("테헤란로 142").zipcode("06236").build())
                .build();

        //when
        Long savedId = memberService.join(member);

        //then
        assertThat(member.getId()).isEqualTo(savedId);
    }
    
    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member memberA = Member.builder()
                .name("김광진")
                .address(Address.builder().city("서울특별시 강남구").street("테헤란로 142").zipcode("06236").build())
                .build();

        Member memberB = Member.builder()
                .name("김광진")
                .address(Address.builder().city("서울특별시 서초구").street("몰라로 142").zipcode("06231").build())
                .build();

        //when
        Long savedIdA = memberService.join(memberA);

        //then
        assertThrows(IllegalStateException.class,
                () -> memberService.join(memberB));
    }
}