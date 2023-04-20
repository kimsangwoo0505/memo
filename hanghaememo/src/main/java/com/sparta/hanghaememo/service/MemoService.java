package com.sparta.hanghaememo.service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//메모 생성하기 5-1//해당 클래스가 서비스 계층(Service layer)의 구성 요소임을 나타냅니다(?). 서비스 계층은 주로 비즈니스 로직을 구현하고, 데이터 액세스 계층(Repository)과 프레젠테이션 계층(Controller) 사이에서 데이터를 처리하는 데 사용(?)
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;//메모 생성하기 5-2(데이터베이스와 연결을 도와줌 1(?)(from MemoController))(MemoRepository를 사용할 수 있게함)(메모생성하기 하고 만들었으며 이후 다시 MemoController로 감)

    @Transactional//메모 생성하기 8((from MemoController)메모 객체를 만들어 주고 생성자를 생성해 값을 넣어주게 함)//이후 entity의 Memo로 이동
    public Memo createMemo(MemoRequestDto requestDto) {
     Memo memo = new Memo(requestDto);
     memoRepository.save(memo);//메모 생성하기 10(from entity의 Memo)(+로  @Transactional도 생성)
     //자동으로 쿼리가 생성되며 데이터베이스에 연결되며 저장됨
     return memo;
    }//@Entity어노테이션이 걸려있는 Memo클래스를 인스턴스로 만들어서 그값을 사용해서 저장해야함
//트랜잭션의 범위를 지정하는 데 사용(?),트랜잭션은 데이터베이스 연산을 수행하는 일련의 작업 단위로, 모든 작업이 성공적으로 완료되거나 아무 것도 수행되지 않도록 보장(?)



    @Transactional(readOnly = true)//메모 조회하기 3(from MemoController)(이후 MemopRepository로 이동)
    public List<Memo> getMemos() {
        return  memoRepository.findAllByOrderByModifiedAtDesc();
    }//메모 조회하기 5(from MemoRepository)(return  memoRepository.findAllByOrderByModifiedAtDesc();만들고  @Transactional(readOnly = true)생성

    @Transactional////메모 수정하기 5-2(from Memo)
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        memo.update(requestDto);
        return memo.getId();//메모 수정하기 5-1(from Memo)
    }//메모 수정하기 3(from MemoController)//이후 Memo로 이동

    //(수정해야할 메모가 있는지 확인)(가지고온 데이터 변경은 Memo entity에서 함)

    @Transactional//메모 삭제하기 3-2(from MemoController)
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);//어떤 메모를 삭제할지 알려줌(?)
        return id;
    }//메모 삭제하기 3-1(from MemoController)//
}
