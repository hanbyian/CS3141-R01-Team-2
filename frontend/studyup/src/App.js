import './App.css';
import {React, Component} from 'react';
import { LoginPage,HomePage } from './groups.js';
let testedPost = false;
function testAPI(){
  try{
    console.log(fetch("http://54.146.234.48:8080/StudyUp2/studyset/showSets"));
  }
  catch(e){
    console.log(e);
    console.log("test 1 did not work");
  }
  try{
    console.log(fetch("http://54.146.234.48:8080/StudyUp2/users/showusers"));
  }
  catch(e){
    console.log(e);
    console.log("test 2 did not work");
  }
  try{
    let data = {setName:"mySet", setOwner:"ian hanby"};

    fetch("http://54.146.234.48:8080/StudyUp2/studyset/createStudySet", {
      method: "POST",
      headers: {'Content-Type': 'application/json'}, 
      body: JSON.stringify(data)
    }).then(res => {
      console.log("Request complete! response:", res);
    });
  }
  catch(e){
    console.log(e);
    console.log("test 3 did not work");
  }
}
function App(){
    testAPI();
    return (
      <div>
        <LoginPage/>
      </div>
    );
  }

export default App;
