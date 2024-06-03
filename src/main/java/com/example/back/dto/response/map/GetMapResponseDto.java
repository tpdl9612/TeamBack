package com.example.back.dto.response.map;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMapResponseDto extends ResponseDto{
    private List<Place> data;

    public GetMapResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    @Getter
    @Setter
    public static class Place {
        private String name;
        private double lat;
        private double lng;
    }
}
