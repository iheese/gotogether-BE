package com.gotogether.gotogethersbe.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat
public enum Religion {

    JESUS("하나님과 함께하는 여행"),
    BUDDHA("부처님의 발자취를 찾아"),
    NO_MATTER("상관 없음");

    @JsonValue
    private final String koreanName;
}
