//object. 프론트언어에서 {}는 객체
let obj = {
    num1:10, 
    num2:20, 
    method1:function(){
        alert("method")
    }
};

obj.num1 = 20;
obj.num3 = 50;
obj.method1();
console.log(obj.num1);
console.log(obj.num2);
console.log(obj.num3);


