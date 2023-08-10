

$("#btn").click(function(){
    // fetch("https://dummyjson.com/products?skip=0&limit=1",{
    //     method:"get"
    // }).then( (result)=> {return result.json()})
    // .then((r)=>{})

    // $.get("https://dummyjson.com/products?skip=0&limit=1", function(result){
    //     console.log(result);
    //     console.log(result.products[0].title);
    // });

    // $.post("url", {kdy1:"", kdy2:""}, function(result){  })
    // post는 body에 파라미터를 담고,
    // get은 head에 담는다.

    $.ajax({
        type:'GET',
        url : "https://dummyjson.com/products",
        data:{
            skip:0,
            limit:1
        },
        success: function(result){
            console.log(result);
            
        },
        error: function(){
            console.log('에러 발생')
        }
        


    })
})