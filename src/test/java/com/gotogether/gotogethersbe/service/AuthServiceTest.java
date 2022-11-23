package com.gotogether.gotogethersbe.service;

import com.gotogether.gotogethersbe.config.auth.TokenManager;
import com.gotogether.gotogethersbe.config.common.exception.CustomException;
import com.gotogether.gotogethersbe.domain.Member;
import com.gotogether.gotogethersbe.dto.MemberDto;
import com.gotogether.gotogethersbe.repository.MemberRepository;
import com.gotogether.gotogethersbe.web.api.ResponseMessage;
import com.gotogether.gotogethersbe.web.api.StatusCode;
import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@Transactional
@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private TokenManager tokenManager;
    @Mock
    private RedisTemplate redisTemplate;

    @DisplayName("회원가입 테스트")
    @Test
    void signupTest(){
        //given
        MemberDto.MemberRequest request= signupRequest();
        when(memberRepository.existsByEmail(request.getEmail())).thenReturn(false);
        Member member = request.toMember(passwordEncoder);
        when(memberRepository.save(member)).thenReturn(member);

        //when
        MemberDto.MemberResponse response = authService.signup(request);

        //then
        assertThat(response.getName()).isEqualTo(request.getName());
        assertThat(response.getEmail()).isEqualTo(request.getEmail());

        //verify
        verify(memberRepository, times(1)).save(any(Member.class));
    }

    private MemberDto.MemberRequest signupRequest(){
        return MemberDto.MemberRequest.builder()
                .email("test@test.com")
                .password("testPassword")
                .name("testman")
                .birth(LocalDate.parse("2022-11-23"))
                .build();
    }

    @DisplayName("이메일 유효성 검사 예외 테스트")
    @Test
    void checkEmailTest(){
        //given
        MemberDto.emailRequest emailRequest = emailRequest();
        CustomException customException = new CustomException(ResponseMessage.CHECK_EMAIL_FAIL, StatusCode.BAD_REQUEST);
        when(memberRepository.existsByEmail(anyString())).thenReturn(true);

        //when

        //then
        assertThatThrownBy(() -> {authService.checkEmail(emailRequest);})
                .isInstanceOf(CustomException.class);
    }

    private MemberDto.emailRequest emailRequest(){
        return MemberDto.emailRequest.builder()
                .email("test@test.com")
                .build();
    }

}
