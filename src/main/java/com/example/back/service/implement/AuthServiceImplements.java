package com.example.back.service.implement;

import com.example.back.dto.request.auth.SignInRequestDto;
import com.example.back.dto.request.auth.SignUpRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.auth.SignInResponseDto;
import com.example.back.dto.response.auth.SignUpResponseDto;
import com.example.back.entity.CertificationEntity;
import com.example.back.entity.UserEntity;
import com.example.back.provider.EmailProvider;
import com.example.back.provider.JwtProvider;
import com.example.back.repository.CertificationRepository;
import com.example.back.repository.UserRepository;
import com.example.back.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplements  implements AuthService {
    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final JwtProvider jwtProvider;
    private final EmailProvider emailProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto){
        try{
            String userId = dto.getUserId();
            boolean isExistId = userRepository.existsByUserId(userId);
            if(isExistId) return SignUpResponseDto.duplicateId();

            String email = dto.getEmail();
            boolean isExistEmail = userRepository.existsByEmail(email);
            if(isExistEmail) return SignUpResponseDto.duplicatedEmail();

            String nickname = dto.getNickname();
            boolean isExistNickname = userRepository.existsByNickname(nickname);
            if(isExistNickname) return SignUpResponseDto.duplicatedNickname();

            String certificationNumber = dto.getCertificationNumber();
            CertificationEntity certificationEntity = certificationRepository.findByUserId(userId);
            boolean isMatched = certificationEntity.getEmail().equals(email) &&
                    certificationEntity.getCertificationNumber().equals(certificationNumber);
            if (!isMatched) return SignUpResponseDto.certificationFail();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            certificationRepository.deleteByUserId(userId);


        } catch (Exception exception){
            exception.printStackTrace();
            return SignUpResponseDto.databaseError();
        }
        return SignUpResponseDto.success();



    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto){
        String token = null;
        try{
            String userId = dto.getUserId();
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity == null) return SignInResponseDto.SignInFail();

            String password = dto.getPassword();
            String encodePassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password,encodePassword);
            if(!isMatched) return SignInResponseDto.SignInFail();

            token = jwtProvider.create(userId);

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();

        }
        return SignInResponseDto.success(token);
    }
    private String getCertificationNumber(){
        String certificationNumber = "";
        for(int count = 0; count <4; count ++) certificationNumber += (int)(Math.random() * 10);
        return certificationNumber;
    }




}
