// JS는 문자열 문자 타입 따로 구분하지 않아서
//   "" or '' 중에서 자유롭게 쓰면 됨

console.log('hello');

let n1=1;
let n2='1';

console.log(n1==n2);
console.log(n1===n2);
console.log(n1+n2);
console.log(n1*n2);
console.log(n1!=n2);
console.log(n1!==n2);
console.log(typeof n1);
console.log(typeof n2);


let ar = [1,2,3];

for(let i=0; i<3; i++){
    console.log(ar[i]);
}

for(n of ar){
    console.log(n);
}

console.log('===================')

ar = [];

ar.push('a');
ar.push(2);
ar.push(false);

let result = ar.pop();
console.log(result);
for(n of ar){
    console.log(n);
}

console.log('===================')

ar.forEach(function(v, i, ar){
   console.log(v);
   console.log(i);
});