import React, { Component } from 'react';
import root from './index.js';
import style from './style.css';
//import {confirmUserAPI,createUser,addTerm,createStudySet, getTermsData, showSetsData, ShowUsersData, allSetsForUser} from "./apiFunctions";

const emptySampleData = {};
const sampleData = {User:{username:"hanbyian",password:"Test123!",firstName:"ian",lastName:"Hanby"},sets:{germanSet:{one:"eins",two:"zwei",three:"drei",four:"vier"},spanishSet:{"one":"uno","two":"dos","three":"tres","four":"quatro"}, japaneseSet:{"one":"ichi","two":"ni","three":"san","four":"yon"}}};//test data until we can setup connection with database
export const flashcards = (
    <div></div>
    );

export const footer = (
    <div></div>
    );
export class LoginPage extends React.Component{
    constructor(props){
        super(props);
        this.state = {showLogin:true}
        this.handleLoginSignup = this.handleLoginSignup.bind(this);
    }
    handleLoginSignup(){
        this.setState({showLogin:(!this.state.showLogin)});
    }
    async confirmUser(){
        let tempData = 0;
        let userID = document.getElementById("loginUsername").value;
        let passID = document.getElementById("loginPassword").value;
        console.log(passID);
        console.log(userID);
        try{
            fetch("http://54.211.204.247:8080/StudyUp2/users/showusers").then(response=>response.JSON()).then(data=>tempData=data);
            console.log(tempData);
            for(let i = 0;i<tempData.length;i++){
                if(userID===tempData[i][1] && passID===tempData[i][2])root.render(<HomePage username={userID}/>);
            }
        }
        catch(e){
            console.log(e);
            console.log("failed");
        }
    }
    registerUser(){

    }
    render(){
        let login = (
        <div className="signInForm alignc"><br></br>
            <form onSubmit={this.confirmUser}>
                <input type="text" className="inputtext " placeholder="username" id="loginUsername"></input>
                <input type="text" className="inputtext" placeholder="password" id ="loginPassword"></input><br></br>
                <button type="submit" className="smallcaps button1">Log In</button>
            </form>
            <button className="smallcaps button1" onClick={this.handleLoginSignup}>Sign Up</button>
        </div>);
        let signup = (
        <div className="loginForm alignc"><br></br>
            <form onSubmit={this.registerUser}>
                <input type="text" className="inputtext" placeholder="select a username"></input>
                <input type="text" className="inputtext" placeholder="select a password"></input><br></br>
                <button type="submit" className="smallcaps button1">Sign Up</button>
            </form>
            <button className="smallcaps button1" onClick={this.handleLoginSignup}>Log In</button>
        </div>);
        let showing = <div></div>;
        if(this.state.showLogin){
            showing = login;
        }else{
            showing = signup;
        }
        return (
            <div>
                {showing}
            </div>
        );
    }
}
export class HomePage extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            username:this.props.username,
            viewingSet:0,
            viewState:0,
            newSet:[],
            newSetCount:0
        };
        let userSets = allSetsForUser(this.state.username);
        this.setState({allSets:userSets});

        this.handleCreating = this.handleCreating.bind(this);
        this.handleViewingSet = this.handleViewingSet.bind(this);
        this.addTerm = this.addTerm.bind(this);
        this.pushSet=this.pushSet.bind(this);
        this.handleStudyingFlashcards = this.handleStudyingFlashcards.bind(this);
    }
    handleCreating(){
        this.setState({viewState:1});
    }
    handleViewingSet(newViewingSet){
        this.setState({viewingSet:newViewingSet});
        
    }
    handleStudyingFlashcards(){
        this.setState({viewState:2});
    }
    addTerm(){
        let nextTerm = (
            <div className="set element" id={this.state.newSet.length}>
                <input placeholder="term" id={this.state.newSet.length+"term"}></input>
                <input placeholder="definition" id={this.state.newSet.length+"definition"}></input>
            </div>
        );
        this.setState({newSetCount:this.state.newSet.push(nextTerm)});
    }
    pushSet(){
        let currentSet={};
        for(var i = 0;i<(this.state.newSetCount);i++){
            let term = document.getElementById(i+"term").value;
            let definition = document.getElementById(i+"definition").value;
            console.log(term);
            console.log(definition);
            currentSet[term]=definition.toString();
        }
        let setName = document.getElementById("newSetName").value.toString();
        let emptySet = {};emptySet[setName.toString()]=currentSet;
        this.state.allSets[setName]=currentSet;
        this.setState({newSetCount:this.state.newSetCount});
    }
    render() {
        let setView;
        if(this.state.viewState == 1){/* viewState=1 is set creation mode*/
            let firstTerm = (
            <div className="set element" id={this.state.newSet.length} >
                <input placeholder="term" id={this.state.newSet.length+"term"}></input>
                <input placeholder="definition" id={this.state.newSet.length+"definition"}></input>
            </div>
            );
            if(this.state.newSet.length==0)this.state.newSet.push(firstTerm)
            setView=(
            <div className="newSet">
                <input type="text" placeholder="Name of Study Set" id="newSetName"></input>
                <div className="memberList" id="createSet">
                    {this.state.newSet}
                </div>
                <button className="smallcaps button1" onClick={this.addTerm}>+ Add new term</button>
                <button className="smallcaps button1" onClick={this.pushSet}>Finish Making Set</button>
            </div>);
        }else if(this.state.viewState==0){/* viewState=0 is viewing a specific set */
            //setView for the currently selected set(stored in state) which shows the terms and has study button
            setView=
            (<div>
                <h3 className="smallcaps">{this.state.viewingSet}</h3>
                <ul className="smallcaps"></ul>
                <button onClick={this.handleStudyingFlashcards}>Study This Set</button>
            </div>);//need to map list here
        } else if(this.state.viewState==2){/* viewState=2 is studying a set mode  */
            //do da flashcard ting
            setView=(<div>
                <p>lol you thought</p>
            </div>)
        }
        return (
            <div>
            <div className="header">
                <h1 className="studyupheader">StudyUp</h1>
                <h2 className="studyupblizz">Sponsored by Blizzard T. Husky</h2>
            </div>
            {setView}
            <div>
                <h3 className="smallcaps">My Sets</h3>
                <ul className="smallcaps">
                    {this.state.allSets.length==0? <p>you have no sets</p>: this.state.allSets.map(e => (<li key={e[0]}><button onClick = {ee => this.handleViewingSet(e[0])}>{e[1]}</button></li>))}
                </ul>
                <button className="smallcaps" onClick={this.handleCreating}>+ Create Set</button>
                <p className="smallcaps">Select a set to view it and study</p>
            </div>
            </div>
        );
    }
}

/*
order matters on params of the json given to post method
URLs
baseURL - http://54.211.204.247:8080/StudyUp2

terms URL - http://54.211.204.247:8080/StudyUp2/terms
user URL - http://54.211.204.247:8080/StudyUp2/users
set URL - http://54.211.204.247:8080/StudyUp2/studyset

GET allSetsForUser - http://54.211.204.247:8080/StudyUp2/studyset/showSetsForUser/{username}
GET getTerms - http://54.211.204.247:8080/StudyUp2/terms/getTerms
GET showSets - http://54.211.204.247:8080/StudyUp2/studyset/showSets
GET showusers - http://54.211.204.247:8080/StudyUp2/users/showusers

POST createStudySet - http://54.211.204.247:8080/StudyUp2/studyset/createStudySet
POST createUser - http://54.211.204.247:8080/StudyUp2/users/createUser
POST addTerm - http://54.211.204.247:8080/StudyUp2/terms/addTerm
*/
/*
functions needed:
on signup call createUser(u,p,e,n);
on login - 

*/
export function allSetsForUser(U){
    let tempData;
    fetch("http://54.211.204.247:8080/StudyUp2/studyset/showSetsForUser/"+U).then(response =>response.json()).then(data=>tempData=data);
    return tempData;
  }
  export function getTermsData(){
      let tempData;
      fetch("http://54.211.204.247:8080/StudyUp2/terms/getTerms").then(response=>response.json()).then(data=> tempData = data);
      return tempData;
  }
  export function showSetsData(){
      let tempData;
      fetch("http://54.211.204.247:8080/StudyUp2/studyset/showSets").then(response=>response.json()).then(data=>  tempData = data);
      return tempData;
  }
  export function ShowUsersData(){
      let tempData;
      fetch("http://54.211.204.247:8080/StudyUp2/users/showusers").then(response=>response.json()).then(data=>tempData = data);
      return tempData;
  
  }
  export function confirmUserAPI(U,P){
    let tempData = 
      fetch("http://54.211.204.247:8080/StudyUp2/users/showusers").then(response=>response.json()).then(data=>data.map(e=>
      {
          console.log(e[1] + ":" + e[2]);
          if(U==e[1] && P==e[2])return true;
    }));
      console.log(tempData);
    return false;
  }
  export function createStudySet( SN, SO){
      try{
          let postData;
          postData.setName = SN;
          postData.setOwner = SO;
          //let data = {"setName":"mySet", "setOwner":"ijhanby"};setOwner has to be a username in users dataset
      
          fetch("http://54.211.204.247:8080/StudyUp2/studyset/createStudySet", {
            method: "POST",
            headers: {'Content-Type': 'application/json'}, 
            body: JSON.stringify(postData)
          }).then(res => {
            console.log("Request complete! response:", res);
          });
        }
        catch(e){
          console.log(e);
          console.log("creating set did not work for setName:" + SN);
        }
  }
  export function addTerm(SSID, T, D){
      try{
          //post empty set, then get sets to get setID, then use setID and add each term(individually or at once)
          let postData;
          postData.term = T;
          postData.definition = D;
          postData.parentSetID = SSID;
          //let termsData = {term:"ethan", definition:"jones",studySetID:1};
      
          fetch("http://54.211.204.247:8080/StudyUp2/terms/addTerm", {
            method: "POST",
            headers: {'Content-Type': 'application/json'}, 
            body: JSON.stringify(postData)
          }).then(res => {
            console.log("Request complete! response:", res);
          });
        }
        catch(e){
          console.log(e);
          console.log("add term did not work for setID:"+SSID + "and term:"+T);
        }
  }
    
  export function createUser(U, P, E, N){
      try{
          let postData;
          postData.username = U;
          postData.password = P;
          postData.email = E;
          postData.name = N;
          //let userData = {username: 'ighanby', password: 'test', email: 'ighanby@mtu.edu', name: 'ian yerd'};
  
          fetch("http://54.211.204.247:8080/StudyUp2/users/createUser", {
          method: "POST",
          headers: {'Content-Type': 'application/json'}, 
          body: JSON.stringify(postData)
          }).then(res => {
          console.log("Request complete! response:", res);
          });
      }
      catch(e){
          console.log(e);
          console.log("create function did not work for username:"+U);
      }
  }