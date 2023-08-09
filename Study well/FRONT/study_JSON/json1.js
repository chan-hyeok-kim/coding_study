
let text = '{"k1":"abc","k2":2}';

let j = JSON.parse(text);

console.log(j);
alert(j);

console.log(j.k1);
console.log(j.k2+3);

text= '[{"k1":"abc","k2":2}, {"k1":"efg","k2":7}]';
// key의 앞뒤에는 반드시 ""나 ''이 들어감
//  밖은 반대로

j = JSON.parse(text);
console.log(j[0]);
console.log(j[0].k1);

for(a of j){
    console.log(a.k2+10);
}

text = '{"f1":[{"k1": [{"k1":"abc","k2":2}, {"k1":"efg","k2":7}],"k2":2}, {"k1":"efg","k2":7}]}';

j = JSON.parse(text);
console.log(j.f1[1].k2);

console.log(typeof j);

j = JSON.stringify(j);

console.log(typeof j);