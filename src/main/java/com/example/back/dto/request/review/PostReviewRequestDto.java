package com.example.back.dto.request.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostReviewRequestDto {
    @NotBlank
    private String content;
    @NotBlank
    private String userId;
    @NotNull
    private String productId;
}
