package com.example.back.service;


import com.example.back.dto.response.user.GetSignInUserResponseDto;
import com.example.back.dto.response.user.GetUserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<? super GetUserResponseDto> getUser(String userId);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);
}
