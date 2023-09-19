package dat3.cars.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import dat3.cars.entity.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    
    @BeforeEach
    void setUp() {
        Member m1 = new Member("member1", "test123", "member1@testmail.com", "Anders", "Holm", "astreet", "acity", "2000");
        memberRepository.save(m1);
    }
    @Test
    void findMembersByZip() {
        List<Member> members = memberRepository.findMembersByZip("2000");
        assertEquals(1, members.size());
        assertEquals("2000", members.get(0).getZip());
    }
}