

// const id1 = document.getElementById("id1");
// const btn = document.getElementById("btn");
// const result = document.querySelector("#result");


// btn.addEventListener("click", ()=>{
//     result.innerHTML=id1.value;
// })

// jquery문법
// 선택자는 css 선택자와 같음
// $('선택자').함수호출()

// data가져오기 
// 함수호출(가져올 속성명)



$('#btn').click(()=>{
    let v = $('#id1').val();
    let num = $('#id1').attr("data-num");
  
    $('#result').html(v);
})


// $('#id1').blur(()=>{

//     alert("blur");
// })


$('#btn2').click(()=>{
    let p1 = $('#p').html();
    let t = $('#p').text();
    console.log(p1);
    console.log(t);
})


$('.btns').click(function(){
   let n = $(this).attr("data-nums");
   console.log(n);
})

// $('.c2')자체는 배열임

$('#btn3').click(function(){
    $('.c2').each(function(i, e){
        console.log("Index: ", i);
        console.log("Value: ", $(e).html());

    });
    
})



