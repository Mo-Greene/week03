package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
        //다찾아라 순서대로 정렬해라 수정된날짜를 기준으로 내림차순
    List<Memo> findAllByOrderByModifiedAtDesc();
}