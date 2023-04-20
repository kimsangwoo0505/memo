package com.sparta.hanghaememo.entity;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.repository.MemoRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(MemoRequestDto requestDto) {
            this.username = requestDto.getUsername();
            this.contents = requestDto.getContents();
    }//메모 생성하기 9(from MemoService)(이후 MemoService로 이동)

    //서비스의 크리에이트 메모때매 만들어준 생성자

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }//메모 수정하기 4(from MemoService)//이후 MemoService로 이동 
}