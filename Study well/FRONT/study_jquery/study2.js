


$('#all').click(function () {
    // console.log($('#all').prop("checked"))
    $('.ch1').each(function (i, e) {
        $(e).prop("checked", $('#all').prop("checked"));

    })
})

$('.ch1').click(function () {
    let check = true;
    $('.ch1').each(function (i, e) {
        if (!$(e).prop("checked")) {
            check = $(e).prop("checked");
            return check;
        }
    })
    $('#all').prop("checked", check);
})

//--------------------------------------------

$("#btn").click(function(){
    // let i = document.createElement("input")
    // let a = document.createAttribute("type");
    // a.value = "text";
    // i.setAttributeNode(i);

    // $("#d1").html(i);

    // row 100개, td가 3개의 table
    let r = "<div>";
    // r = r+'<input type="text">'
    // r = r+'<button class="d">CLICK</button>'
    // r = r+'</div>'
   
    r = r.concat('<input type="text">');
    r = r.concat('<button class="d">CLICK</button>');
    r = r.concat('</div>');

    $("#d1").append(r);
    
    
});

// 제이쿼리 이벤트 등록 2가지 방법
// 1. 선택자.이벤트명()
// 2. 선택자.on("이벤트명", 콜백함수)
// 2번째 방식은 한번에 이벤트를 여러개 걸 수 있음

//  선택자.on({
//     이벤트명1:콜백 함수,
//     이벤트명2:콜백함수
//  })

$("#d1").on({
    "click":function(){},
    "blur":function(){}
})


// 이벤트 위임
$("#d1").on("click",".d", function(){
    console.log("click");
    console.log($(this));
    $(this).parent().remove();
})

$("#del").click(function(){
r='<input type="text" class="test">'
$("#d1").after(r);
})

$("#del").on("click",".test",function(){
    console.log(this);
    // $("#d1").html("");
    
})




// java
// concat() 문자열 2개 합하는거
// stringbuffer문자열 여러개

