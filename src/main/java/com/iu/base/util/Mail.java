package com.iu.base.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.iu.base.member.MemberDAO;
import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Mail {

	 	@Autowired
	    private JavaMailSender javaMailSender;
	 	
	 	@Autowired
	 	private MemberDAO memberDAO;

	    public void sendMail() throws Exception{
	        
	        // 수신 대상을 담을 ArrayList 생성
	        ArrayList<String> toUserList = new ArrayList<>();
	        
	        // 수신 대상 추가
	       
	        for(MemberVO memberVO : memberDAO.getBirth()) {
	        	log.error("========={}=========",memberVO.getEmail());
	        	toUserList.add(memberVO.getEmail());
	        }
	        log.error("========={}=========",toUserList.size());
	        // 수신 대상 개수
	        int toUserSize = toUserList.size();
	        
	        for(String m : toUserList) {
	        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
	        SimpleMailMessage simpleMessage = new SimpleMailMessage();
	        
	        // 수신자 설정
	        simpleMessage.setTo(m);
	        
	        // 메일 제목
	        simpleMessage.setSubject("생일입니다");
	        
	        // 메일 내용
	        simpleMessage.setText("생일 쿠폰 등장");
	        
	        // 메일 발송
	        javaMailSender.send(simpleMessage);
	        }
	    }
		public void sendMail(MemberVO memberVO) throws Exception{
			        
			        // 수신 대상을 담을 ArrayList 생성
			       
			        // 수신 대상 개수
			        
			        
			        
			        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
			        SimpleMailMessage simpleMessage = new SimpleMailMessage();
			        
			        // 수신자 설정
			        simpleMessage.setTo("tmdals7871@gmail.com");
			        
			        // 메일 제목
			        simpleMessage.setSubject("비밀번호 발송");
			        
			        // 메일 내용
			        simpleMessage.setText("비밀번호는 "+memberVO.getPassword()+" 입니다");
			        
			        // 메일 발송
			        javaMailSender.send(simpleMessage);
			        
			    }
//	    public void sendMail() {
//	        
//	        // 수신 대상을 담을 ArrayList 생성
//	        ArrayList<String> toUserList = new ArrayList<>();
//	        
//	        // 수신 대상 추가
//	        toUserList.add("수신대상1@gmail.com");
//	        toUserList.add("수신대상2@naver.com");
//	        
//	        // 수신 대상 개수
//	        int toUserSize = toUserList.size();
//	        
//	        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
//	        SimpleMailMessage simpleMessage = new SimpleMailMessage();
//	        
//	        // 수신자 설정
//	        simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
//	        
//	        // 메일 제목
//	        simpleMessage.setSubject("Subject Sample");
//	        
//	        // 메일 내용
//	        simpleMessage.setText("Text Sample");
//	        
//	        // 메일 발송
//	        javaMailSender.send(simpleMessage);
//	    }
	}
	

