package com.project.Nutrients.controller;

import com.project.Nutrients.dto.MemberDto;
import com.project.Nutrients.dto.MemberRequest;
import com.project.Nutrients.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/member")
    public String signup(@RequestBody MemberDto request) {
        memberService.save(request);
        return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberRequest request) {
        memberService.login(request);
        return "login";
    }

}
