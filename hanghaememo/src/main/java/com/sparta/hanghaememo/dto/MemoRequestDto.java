package com.sparta.hanghaememo.dto;

import lombok.Getter;

@Getter//메모생성하기 3(Getter도 추가해야함)
public class MemoRequestDto {
    private String username;
    private String contents;//클라이언트에서 넘어오는 username과 contents를 이 객체를 통해서 받아올 수 있음
}//메모생성하기 3(from MemoController)//이후 다시 MemoController로 가서 리턴만들어 주기
