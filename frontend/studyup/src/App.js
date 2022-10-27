import './App.css';
import {React, Component} from 'react';
import { LoginPage,HomePage } from './groups.js';
function testAPI(){
  try{
    console.log(fetch("http://54.146.234.48:8080/StudyUp2/studyset/showSets"));
  }
  catch(e){
    console.log(e);
    console.log("test 1 did not work");
  }
  try{
    console.log(fetch("http://54.146.234.48:3000/StudyUp2/studyset/showSets"));
  }
  catch(e){
    console.log(e);
    console.log("test 2 did not work");
  }
  try{
    console.log(fetch("http://54.146.234.48:8080/StudyUp2/users/showusers"));
  }
  catch(e){
    console.log(e);
    console.log("test 3 did not work");
  }
  try{
    console.log(fetch("http://54.146.234.48:3000/StudyUp2/users/showusers"));
  }
  catch(e){
    console.log(e);
    console.log("test 4 did not work");
  }
  try{
    console.log(fetch("http://54.146.234.48:8080/StudyUp2/studyset/showSetsForUser/wmisip"));
  }
  catch(e){
    console.log(e);
    console.log("test 5 did not work");
  }
  try{
    console.log(fetch("http://54.146.234.48:3000/StudyUp2/studyset/showSetsForUser/wmisip"));
  }
  catch(e){
    console.log(e);
    console.log("test 5 did not work");
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
