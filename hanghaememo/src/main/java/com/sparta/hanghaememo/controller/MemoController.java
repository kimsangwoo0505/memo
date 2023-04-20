package com.sparta.hanghaememo.controller;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.service.MemoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Scanner;

@RestController//해당 클래스가 웹 애플리케이션에서 RESTful 웹 서비스 컨트롤러 역할을 한다는 것을 나타냄(?)//@RestController 어노테이션이 적용된 클래스에서는, 메서드에 @ResponseBody 어노테이션을 추가하지 않아도 메서드의 반환 값이 자동으로 HTTP 응답 본문으로 변환(?)
@RequiredArgsConstructor//Lombok 라이브러리에서 제공하는 어노테이션으로, 클래스에 대해 final 또는 @NonNull로 표시된 필드를 인자로 받는 생성자를 자동으로 생성(?)
public class MemoController {

    private  final MemoService memoService;//메모 생성하기 6(from MemoService)(데이터베이스와 연결을 도와줌 2(?)(MemoService도 연결(?)))//이후 createMemo로 감(같은 페이지)

    @GetMapping("/")//메인 페이지 반환 1
    public ModelAndView home() {
        return new ModelAndView("index");
    }//ModelAndView라는 객체를 생성해서 반환할 html파일이름을 적으면,템플릿에 있는 index.html을 반환해줌(?)


    @PostMapping("/api/memos")//메모 생성하기 2(from html)//이후 MemoRequestDto로 이동해 객체 생성//메모 생성하기 4(return 생성(from MemoRequestDto))//이후 MemoService로 이동//
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){

        return memoService.createMemo(requestDto);//메모 생성하기 7(from 같은 페이지)(클라이언트에서 가지고온 requestDto값을 사용할것이므로 파라미터에 넣어줌)//이후 MemoService로 이동
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoService.getMemos();
    }//메모 조회하기 2(from html)(이후 MemoService에 getMemos생성하기 위해 이동)

    @PutMapping("/api/memos/{id}")//메모 수정하기 2(from index)//이후 memoService로 이동
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);//필요한 값을 넣어줌(id, requestDto)
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deletMemo(@PathVariable Long id){
        return memoService.deleteMemo(id);
    }//메모 삭제하기 2(from index)//이후 MemoService로 이동


}
