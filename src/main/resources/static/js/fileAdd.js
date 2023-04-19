/**
 * 
 */

let clickCount=0;
let max=5;
let idx=0;

$("#btn").click((e)=>{
    

    if(clickCount>=max){
                alert("파일 추가는"+max+"만큼만 가능합니다");
                return;
                
        }
            
    clickCount++;
    let child ='<div class="mb-3 input-group" id="del'+idx+'">';
    child=child+'<input type="file" name="boardFiles">'
    child=child+'<button type="button" class="del btn btn-outline-danger" data-id="del'+idx+'">X</button></div>'
    $("#fileList").append(child);

    idx++;
});

$("#fileList").on("click",".del",function(){
    clickCount--;
    $(this).parent().remove();
    // let id=$(this).attr('data-id');
    // $("#"+id).remove();
    // $('#'+$(this).attr("data-id")).remove();
}) 


