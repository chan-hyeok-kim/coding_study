


$('.tB1').each(function(i,e){
  $(e).click(function(){
    if($(e).css('background')==('rgb(127, 255, 212) none repeat scroll 0% 0% / auto padding-box border-box')){
        $(e).css('background','gainsboro');
    }else{
        $(e).css('background','aquamarine');
    }

    alert("최소 3시간 이상 예약하셔야 합니다")
 

  })
})

// $('.timeBlock').each(function(i,e){
// $(e).mouseover(function(){
//     $('.tB1').each(function(i,e1){
//         $(e1).css('background','black');
        
//     })
// })
// })