/**
 * board Form 유효성 검사
 */

 const submitButton=document.getElementById("submitButton");
 const writer=document.getElementById("writer");
 const title=document.getElementById("title");
 const contents=document.getElementById("contents");
 
 let a =[false,false,false]
 submitButton.addEventListener("click",function(){
	 console.log("성공");
	 
	 if(writer.value!=''){
		 a[0] = true;
	 }
	 if(title.value!=''){
		 a[1] = true;
	 }
	 if(contents.value!=''){
		 a[2] = true;
	 }
	 
	 
	 if(!a.includes(false)){
		document.getElementById("contactForm").submit();	 
	 }else{
		 alert("모든정보 입력");
		 return;
		 
	 }
	 
 })
 $("#submitButton").click(function(){
	 console.log("jquery");
 })