package com.gotogether.gotogethersbe.controller;

import com.gotogether.gotogethersbe.dto.LoginDto;
import com.gotogether.gotogethersbe.dto.MemberDto;
import com.gotogether.gotogethersbe.dto.TokenDto;
import com.gotogether.gotogethersbe.service.AuthService;
import com.gotogether.gotogethersbe.web.api.DefaultRes;
import com.gotogether.gotogethersbe.web.api.ResponseMessage;
import com.gotogether.gotogethersbe.web.api.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    //회원가입
    @PostMapping("/members")
    public DefaultRes signup(@RequestBody MemberDto.MemberRequest request){
        authService.signup(request);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.CREATED_USER);
    }

    //로그인
    @PostMapping("/login")
    public DefaultRes<TokenDto> login(@RequestBody LoginDto.LoginRequest request){
        return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, authService.login(request));
    }

    //토큰 재발급
    @PostMapping("/reissue")
    public DefaultRes<TokenDto> reissue(@RequestBody TokenDto tokenRequestDto) {
        return DefaultRes.res(StatusCode.OK, ResponseMessage.REISSUE_SUCCESS,authService.reissue(tokenRequestDto));
    }

}
