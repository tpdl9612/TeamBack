package com.example.back.dto.request.Answer;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequestDto {
    @NotBlank
    private String content;
    @NotBlank
    private String userId;
}
