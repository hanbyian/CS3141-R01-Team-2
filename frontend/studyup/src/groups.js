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
        //const tempData = await ShowUsersData();
        //const userID = document.getElementById("loginUsername").value;
        //const passID = document.getElementById("loginPassword").value;
        const toRender = <HomePage username="ijhanby"/>;//this works
        root.render(toRender);
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
            newSetCount:0,
            allSets:[]
        };
        //userSets = allSetsForUser(this.state.username);

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
        let currentSet=[];
        for(var i = 0;i<(this.state.newSetCount);i++){
            let term = document.getElementById(i+"term").value;
            let definition = document.getElementById(i+"definition").value;
            currentSet[i]=[term.toString(),definition.toString()];
        }
        let setName = document.getElementById("newSetName").value.toString();
        let emptySet = {};emptySet[setName.toString()]=currentSet;
        this.state.allSets[this.state.allSets.length]=currentSet;
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
//onClick = {ee => this.handleViewingSet(e[0])}