package com.sparta.hanghaememo.repository;


import com.sparta.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();//메모 생성하기 4(from MemoService)//(이후 MemoService로 이동)
    //내림차순설정

}//JpaRepository를 상속받아 데이터베이스와 연결하도록 할 수 있음