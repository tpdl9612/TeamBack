package com.example.back.service;

import com.example.back.dto.request.auth.SignInRequestDto;
import com.example.back.dto.request.auth.SignUpRequestDto;
import com.example.back.dto.response.auth.SignInResponseDto;
import com.example.back.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);


}
