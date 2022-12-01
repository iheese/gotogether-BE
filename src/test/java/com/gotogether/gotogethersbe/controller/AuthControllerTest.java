package com.gotogether.gotogethersbe.controller;

import com.gotogether.gotogethersbe.dto.LoginDto;
import com.gotogether.gotogethersbe.dto.TokenDto;
import com.gotogether.gotogethersbe.service.AuthService;
import com.gotogether.gotogethersbe.web.api.DefaultRes;
import com.gotogether.gotogethersbe.web.api.ResponseMessage;
import com.gotogether.gotogethersbe.web.api.StatusCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.google.gson.Gson;

@ContextConfiguration(classes = AuthController.class)
@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AuthControllerTest {

    @MockBean
    private AuthService authService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("로그인 테스트")
    @Test
    void loginTest() throws Exception {
        //given
        LoginDto.LoginRequest request = loginRequest();
        TokenDto tokenDto = tokenResponse();
        when(authService.login(request)).thenReturn(tokenDto);

        //when
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(request))
                )

        //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(200))
                .andExpect(jsonPath("$.responseMessage").value("로그인 성공"))
                .andExpect(jsonPath("$.data.accessToken").value("Issue acessToken!"))
                .andExpect(jsonPath("$.data.refreshToken").value("Issue refreshToken"))
                .andDo(print());

    }

    private LoginDto.LoginRequest loginRequest(){
        return LoginDto.LoginRequest.builder()
                .email("user")
                .password("password")
                .build();
    }

    private TokenDto tokenResponse(){
        return TokenDto.builder()
                .accessToken("Issue acessToken!")
                .refreshToken("Issue refreshToken")
                .build();
    }
}
