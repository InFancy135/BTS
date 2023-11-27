package com.example.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.model.member.Member;
import com.example.board.repository.BoardMapper;
import com.example.board.repository.MemberMapper;
import com.example.board.util.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class MemberService {
	
	//데이터베이스 접근을 위한 BoardMapper 필드 선언
  private final FileService fileService;
  private final MemberMapper memberMapper;
  
  public Member findMember(String member_id) {
  	return memberMapper.findMember(member_id);
  	
  }
  
  @Transactional
	public void saveMember(Member member) {
		memberMapper.saveMember(member);
		
	}
	
	
	
	
	
	
	
	
}
