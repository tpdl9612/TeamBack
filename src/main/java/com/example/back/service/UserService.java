package com.example.back.service;


import com.example.back.dto.request.user.ChangePasswordRequestDto;
import com.example.back.dto.request.user.PatchNicknameRequestDto;
import com.example.back.dto.response.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<? super GetUserResponseDto> getUser(String userId);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);
    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String userId);
    ResponseEntity<? super ChangePasswordResponseDto> changePassword(ChangePasswordRequestDto dto, String userId);
    ResponseEntity<? super WithdrawalUserResponseDto> withdrawalUser(String userId);
}
