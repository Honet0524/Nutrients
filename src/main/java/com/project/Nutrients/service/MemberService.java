package com.project.Nutrients.service;

import com.project.Nutrients.dto.MemberDto;
import com.project.Nutrients.entity.Member;
import com.project.Nutrients.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public ArrayList<Member> index() {
        return memberRepository.findAll();
    }

    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member create(MemberDto dto) {
        Member member = dto.toEntity();
        log.info(member.toString());
        if (member.getId() != null) {
            return null;
        }
        if (member.getName() == null) {
            log.info("이름을 입력해주세요.");
            return null;
        }
        if (member.getMemberId() == null) {
            log.info("사용하실 아이디를 입력해주세요.");
            return null;
        }
        if (member.getMemberPassword() == null) {
            log.info("사용하실 패스워드를 입력해주세요.");
            return null;
        }
        if (member.getBirth() == null) {
            log.info("생년월일을 입력해주세요.");
            return null;
        }
        return memberRepository.save(member);
    }

    public Member update(Long id, MemberDto dto) {
        Member member = dto.toEntity();
        log.info(member.toString());
        Member target = memberRepository.findById(id).orElse(null);
        if (target == null || id != member.getId()) {
            log.info("잘못된 요청! member: {}", member.toString());
        }
        target.patch(member);
        Member updated = memberRepository.save(target);
        return updated;
    }

    public Member delete(Long id) {
        Member target = memberRepository.findById(id).orElse(null);
        log.info(target.toString());
        if (target == null) {
            return null;
        }
        memberRepository.delete(target);
        return target;
    }
}
