package com.iu.base.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	//page 번호 담을 변수
	private Long page;
	
	//한 페이지에 보여줄 글의 갯수
	private Long perPage;
	
	
	//시작 index 번호
	private Long startRow;
	
	private String search;
	private Long totalPage;
	
	private Long perBlock;

	private Boolean before;
	private Boolean after;
	private Long totalBlock;
	
	private Long startNum;
	private Long lastNum;
	
	private String kind;
	
	//시작 index 번호를 계산하는 메서드
	
	public void makeStartRow() {
		
		//page =1 , startRow=0
		//page =2 , startRow=10
		//page =3 , startRow=20
		this.startRow=(this.getPage()-1)*this.getPerPage();
		
	}
	public Long getPage() {
		if(this.page ==null || this.page == 0) {
			this.page=1L;
		}
		return this.page;
	}
	
	public Long getPerPage() {
		if(this.perPage ==null || this.perPage == 0) {
			this.perPage=10L;
		}
		return this.perPage;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return this.search;
	}
	public Long getPerBlock() {
		if(this.perBlock == null) {
			this.perBlock=5L;
		}
		return this.perBlock;
	}
	public void makeNum(Long totalCount) {
		//1.전체 row의 갯수 구하기
				//2.총 page의 갯수 구하기 
				this.totalPage=totalCount/this.getPerPage();
				if(totalCount%this.getPerPage() !=0) {
					this.totalPage ++;
				}
				
				//3. 한블럭에 출력할 번호의 갯수 
				
				
				//4. 총 블럭의 수 구하기 
				this.totalBlock=this.totalPage/this.getPerBlock();
				if(this.totalPage%this.perBlock !=0) {
					this.totalBlock++;
				}
				
				//5. page 번호로 현재 블록 번호 구하기 
				//page 1-5 curBlock 1
				//page 6-10 curBlock 2
				//page 11-15 curBlock 3 ...
				
				Long curBlock=this.getPage()/this.getPerBlock();
				if(this.getPage()%this.getPerBlock() !=0) {
					curBlock++;
				}
				//6. 현재 블록번호의 시작번호와 끝번호를 계산하기
				//curblock  startNum lastNum
				// * 1         1        5
				this.startNum=(curBlock-1)*this.getPerBlock()+1;
				this.lastNum=(curBlock*this.getPerBlock());
				
				
				if(curBlock == 1) {
					this.before=true;
				}
				if(curBlock==totalBlock) {
					this.lastNum = totalPage;
					this.after=true;
				}
		
		
	}
}
