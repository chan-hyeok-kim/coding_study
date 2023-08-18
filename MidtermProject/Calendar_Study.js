
let cho = document.getElementById("choice")

    
    cho.addEventListener("click", function() {
				let calendarEl = document.getElementById('calendar');
				let calendar = new FullCalendar.Calendar(calendarEl, {
					initialView : 'dayGridMonth',

					selectable: true,
                    locale: 'ko',
                    dateClick: function(info) {
                        alert('예약하실 날짜는 '+info.dateStr+'입니다')
                        let str = '<div id="time">';
                        str = str+'<input type="time" min="00:00" step="900" name="startTime">';
                        str = str+'<input type="time">';
                        str = str+ '</div>';
                        
                        $('#calendar').after(str);

                      
                
                        
                        
                        // 클릭시에 이용시간 관련 텍스트가 뜨면서
                        // 이벤트 위임을 해야됨
                    }
				});
				calendar.render();
			});
        
			

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

