import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let post = '강남 우동 맛집';
  //서버에서 가져온 데이터라 가정
  let [글제목, titleUpdate] = useState(['남자 코트 추천','아주 맑음','점심 메뉴 알려줘']);
  let [좋아요, 좋아요변경] = useState(0);

  
  return (
    <div className="App">
      <div className="black-nav">
         <h4 style={{color: 'red', fontSize: '16px'}}>블로그임</h4>
      </div>
      <div className='list'>

       <button onClick={()=>{
            let titleList=[...글제목];
            titleList=titleList.reverse();
            console.log(titleList);
            titleUpdate(titleList);
       }}>
        가나다순정렬
       </button>

      <div style={ {textAlign:'center'} }>
       <button onClick={()=>{
        let copy=[...글제목];
        copy[0]='여자 코트 추천';
        titleUpdate(copy
       )}}> 글수정</button>
       </div>

      <h4>{ 글제목[0] } 
      <span onClick={()=>{ 좋아요변경(좋아요+1) }}>👍</span> {좋아요} </h4>
      <p>10월 15일 발행</p>
      </div>

      <div className='list'>
      <h4>{ 글제목[1] }</h4>
      <p>10월 15일 발행</p>
      </div>

      <div className='list'>
      <h4>{ 글제목[2] }</h4>
      <p>10월 15일 발행</p>
      </div>

      
    <Modal></Modal>


    </div>

    
  );
}

function Modal(){
  return(
    <>
    <div className='modal'>
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
    </>
  )
}

export default App;
