package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//필요한 정보를 물고다니는 녀석
@Getter
@RequiredArgsConstructor
public class MemoRequestDto {
    private final String username;
    private final String contents;
}

