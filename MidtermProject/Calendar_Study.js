
// let cho = document.getElementById("choice")

    
//     cho.addEventListener("click", function() {
// 				let calendarEl = document.getElementById('calendar');
// 				let calendar = new FullCalendar.Calendar(calendarEl, {
// 					initialView : 'dayGridMonth',
// 					selectable: true,
//                     locale: 'ko',


//                     dateClick: function(info) {
//                         alert('예약하실 날짜는 '+info.dateStr+'입니다')
    
//                         let str='<div id="timepicker">';
//                         str=str+'시작시간<input type="text">';
//                         str=str+'종료시간<input type="text">';
//                         str=str+'</div>';
//                         $('#calendar').append(str);

                      
                
                        
                        
//                         // 클릭시에 이용시간 관련 텍스트가 뜨면서
//                         // 이벤트 위임을 해야됨
//                     }
// 				});
// 				calendar.render();
// 			});
        
			

        // $.ajax({
        //     type: "post",
        //     url: "time",
        //     data: {
                
        //     } ,
        //     success: function(result){},
        //     error: function(){
        //         console.log("error입니다");
        //     }
    // })



$('#time').click(function(){
				console.log("잘되");
			})

			$('.opt-1').each(function(i,e){
				console.log($(e).val());
			  $('.opt-2').each(function(j,e1){
			  	$(this).click(function(){
			  	 console.log($(e1).val());
			  })
				
			})
		   })