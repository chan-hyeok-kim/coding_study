let idx = 0;
let count=0;



let r = '<div class="input-group" id="file'+idx+'">'
r = r+'<input type="file" aria-lable="upload" name="photos" id="photos" class="form-control">';
r = r+'<span class="df" data-id="file'+idx+'">삭제</span>'
r = r+'</div>'

$("#btn1").click(function(){
    
    if(count>=5){
        alert("5개까지입니다");
        return;
    }
    count++;
    $('#fileList').append(r); 
    idx++;
    
  })

// $("#btn1").click(function(){
    
//     if(count>=5){
//         alert("5개까지입니다");
//         return;
//     }
//     count++;
    
//     $('#btn1').after(div1); 
//     $('#file0').append(input1); 
//     $('#file0').append(span1);
//     idx++;
    
//   })

  $('#fileList').on("click",".df",function(){
    console.log(this);
    $(this).parent().remove();
    count--;
  })
  
//   $('#fileList').on("click",".df",function(){
//     let deleteId= $(this).attr("data-id");
//     $("#"+deleteId).remove();
//     count--;
//   })