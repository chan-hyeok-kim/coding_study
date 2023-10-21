import React from "react";
import TodoItem from "./TodoItem";

function TodoBoard(){
    
    return(
        <div>
          <h1>Todo list</h1>
          <TodoItem/>
          <TodoItem/>
          <TodoItem/>
          <TodoItem/>
          <TodoItem/>
        </div>
    )
}

export default TodoBoard