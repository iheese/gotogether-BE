package com.gotogether.gotogethersbe.service;

import com.gotogether.gotogethersbe.config.auth.TokenManager;
import com.gotogether.gotogethersbe.domain.Member;
import com.gotogether.gotogethersbe.dto.MemberDto;
import com.gotogether.gotogethersbe.repository.MemberRepository;
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

    /*
    * 회원가입시 요청 객체 생성하여 저장된 값과 응답값이 같은지 테스트
    * */
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
}
