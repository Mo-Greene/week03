package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
//new memo 컨트롤러를 따로 만들필요가 없음
@RestController
public class MemoController {
    // CRUD를 위해선 리포지토리가 필요함!!
    private final MemoRepository memoRepository;
    private final MemoService memoService;


    @PostMapping("/api/memos")
    // 왜 리퀘스트바디냐면 우리가 arc에서 포스트를 할때 바디칸으로 가서 하기때문이지
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }

}

