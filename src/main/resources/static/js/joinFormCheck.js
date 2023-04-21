/**
 * 
 */

let check =true;
let check2 =false;

 $("#userName").blur(idCheck);
 
 
 function idCheck(){
	 console.log("id중복체크 실행");
	 
	 $.ajax({
		 type : "get",
		 url : "./idDuplicateCheck",
		 data :{
			 userName : $('#userName').val()
		 },
		 success :function(result){
			 if(result){
				  console.log('사용가능')
			 }else{
				 console.log('사용불가')
			 }
		 },
		 error:function(){
			 console.log('error')
		 }
	 })
 }
 $("#passwordCheck").blur(function(){
	 if($("#password").val() == $(this).val()){
		 check2 = true;
		 console.log("같다");
	 }else{
		 console.log("다르다");
	 }
 })
 $("#password").change(function(){
	 if($("#password").val() != $(this).val()){
		 check2 = false;
		 console.log("비번 바뀜");
	 }else{
		 console.log("아니죠");
	 }
 })
 $("#submitButton").click(function(){
	 $(".check").each(function(index,item){
		console.log("item :",$(item).val());
		 if($(item).val() == ''){
			 check = false;
			 return;
		 }else{
			 check=true;
		 }
	 })
	 if(check && check2){
		 console.log("체크 성공");
		 $("#contactForm").submit();
	 }else{
		 console.log("체크 실패");
	 }
 })