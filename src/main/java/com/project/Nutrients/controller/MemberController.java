package com.project.Nutrients.controller;

import com.project.Nutrients.dto.MemberDto;
import com.project.Nutrients.entity.Member;
import com.project.Nutrients.repository.MemberRepository;
import com.project.Nutrients.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @Autowired
//    private MemberRepository memberRepository;

    // 아이디 전체 조회
    @GetMapping("/members")
    public ArrayList<Member> index() {
        return memberService.index();
    }

    // 아이디 조회
    @GetMapping("/members/{id}")
    public Member show(@PathVariable Long id) {
        return memberService.show(id);
    }

    // 아이디 생성
    @PostMapping("/members")
    public ResponseEntity<Member> create(@RequestBody MemberDto dto) {
        Member created = memberService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    // 닉네임 및 비밀번호 변경.
    @PatchMapping("/members/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id,
                         @RequestBody MemberDto dto) {
        Member updated = memberService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 아이디 삭제
    @DeleteMapping("/members/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id) {
        Member deleted = memberService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
