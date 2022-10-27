import React, { Component } from 'react';
import root from './index.js';

const axios = require('axios');
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
    confirmUser(){
        root.render(<HomePage setKey={Object.entries(sampleData.sets)[0][0]} setValue={Object.entries(sampleData.sets)[0][1]} sets={sampleData.sets}/>);
    }
    registerUser(){

    }
    render(){
        let login = (
        <div className="signInForm">
            <form onSubmit={this.confirmUser}>
                <input type="text" placeholder="username"></input>
                <input type="text" placeholder="password"></input>
                <button type="submit">Log In</button>
            </form>
            <button onClick={this.handleLoginSignup}>Sign Up</button>
        </div>);
        let signup = (
        <div className="loginForm">
            <form onSubmit={this.registerUser}>
                <input type="text" placeholder="select a username"></input>
                <input type="text" placeholder="select a password"></input>
                <button type="submit">Sign Up</button>
            </form>
            <button onClick={this.handleLoginSignup}>Log In</button>
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
        this.state = {viewingSetKey:this.props.setKey, viewingSetValue:this.props.setValue, allSets:this.props.sets, isCreating:false, viewState:0, newSet:[], newSetCount:0};
        this.handleCreating = this.handleCreating.bind(this);
        this.handleViewingSet = this.handleViewingSet.bind(this);
        this.addTerm = this.addTerm.bind(this);
        this.pushSet=this.pushSet.bind(this);
        this.handleStudyingFlashcards = this.handleStudyingFlashcards.bind(this);
    }
    handleCreating(){
        this.setState({viewState:1});
    }
    handleViewingSet(newViewingKey, newViewingValue){
        this.setState({viewingSetKey:newViewingKey, viewingSetValue:newViewingValue, viewState:0});
        
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
                <button onClick={this.addTerm}>+ Add new term</button>
                <button onClick={this.pushSet}>Finish Making Set</button>
            </div>);
        }else if(this.state.viewState==0){/* viewState=0 is viewing a specific set */
            //setView for the currently selected set(stored in state) which shows the terms and has study button
            setView=
            (<div>
                <h3>{this.state.viewingSetKey}</h3>
                <ul>{Object.entries(this.state.viewingSetValue).map(([key,value]) => (<li>{key} -- {value}</li>))}</ul>
                <button onClick={this.handleStudyingFlashcards}>Study This Set</button>
            </div>);
        } else if(this.state.viewState==2){/* viewState=2 is studying a set mode  */
            //do da flashcard ting
            setView=(<div>
                <p>lol you thought</p>
            </div>)
        }
        return (
            <div>
            <div className="header">
                <h1>StudyUp</h1>
                <h2>Sponsored by Blizzard T. Husky</h2>
            </div>
            {setView}
            <div>
                <h3>My Sets</h3>
                <ul>
                    {this.state.allSets.length==0? <p>you have no sets</p>: Object.entries(this.state.allSets).map(([key,value]) => (<li><button onClick = {(e) => this.handleViewingSet(key,value,e)}>{key}</button></li>))}
                </ul>
                <button onClick={this.handleCreating}>+ Create Set</button>
                <p>Select a set to view it and study</p>
            </div>
            </div>
        );
    }
}

