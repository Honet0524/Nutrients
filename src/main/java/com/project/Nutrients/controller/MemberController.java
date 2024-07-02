package com.project.Nutrients.controller;

import com.project.Nutrients.dto.MemberDto;
import com.project.Nutrients.entity.Member;
import com.project.Nutrients.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // 아이디 전체 조회
    @GetMapping("/members")
    public ArrayList<Member> index() {
        return memberRepository.findAll();
    }
    
    // 아이디 조회
    @GetMapping("/members/{id}")
    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
    
    // 아이디 생성
    @PostMapping("/members")
    public Member create(@RequestBody MemberDto dto) {
        Member member = dto.toEntity();
        log.info(member.toString());
        if (member.getId() != null) {
            return null;
        }
        return memberRepository.save(member);
    }
    
    // 닉네임 및 비밀번호 변경.
    @PatchMapping("/members/{id}")
    public Member update(@PathVariable Long id,
                                         @RequestBody MemberDto dto) {
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
}
