package com.project.Nutrients.controller;

import com.project.Nutrients.dto.MemberDto;
import com.project.Nutrients.entity.Member;
import com.project.Nutrients.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public ArrayList<Member> index() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @PostMapping("/members")
    public Member create(@RequestBody MemberDto dto) {
        Member member = dto.toEntity();
        log.info(member.toString());
        return memberRepository.save(member);
    }
}
