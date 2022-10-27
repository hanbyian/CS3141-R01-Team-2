import React, { Component } from 'react';
import root from './index.js';
import style from './style.css';

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
        <div className="signInForm alignc"><br></br>
            <form onSubmit={this.confirmUser}>
                <input className="inputtext" type="text" placeholder="username"></input>
                <input className="inputtext" type="text" placeholder="password"></input><br></br>
                <button className="smallcaps button1" type="submit">Log In</button>
            </form>
            <button className="smallcaps button1" onClick={this.handleLoginSignup}>Sign Up</button>
        </div>);
        let signup = (
        <div className="loginForm alignc"><br></br>
            <form onSubmit={this.registerUser}>
                <input className="inputtext" type="text" placeholder="select a username"></input>
                <input className="inputtext" type="text" placeholder="select a password"></input><br></br>
                <button className="smallcaps button1" type="submit">Sign Up</button>
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
        this.state = {viewingSetKey:this.props.setKey, viewingSetValue:this.props.setValue, allSets:this.props.sets, isCreating:false, newSet:[], newSetCount:0};
        this.handleCreating = this.handleCreating.bind(this);
        this.handleViewingSet = this.handleViewingSet.bind(this);
        this.addTerm = this.addTerm.bind(this);
        this.pushSet=this.pushSet.bind(this);
    }
    handleCreating(){
        this.setState({isCreating:true});
    }
    handleViewingSet(newViewingKey, newViewingValue){
        this.setState({viewingSetKey:newViewingKey, viewingSetValue:newViewingValue, isCreating:false});
        
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
        //this.setState({allSets:emptySet});
        this.state.allSets[setName]=currentSet;
        this.setState({newSetCount:this.state.newSetCount});
    }
    render() {
        let setView;
        if(this.state.isCreating){
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
        }else{
            //setView for the currently selected set(stored in state) which shows the terms and has study button
            setView=
            (<div>
                <h3 className="smallcaps">{this.state.viewingSetKey}</h3>
                <ul className="smallcaps">{Object.entries(this.state.viewingSetValue).map(([key,value]) => (<li>{key} -- {value}</li>))}</ul>
                <button className="smallcaps button1">Study This Set</button>
            </div>);
        }
        return (
            <div>
            <div className="header">
                <h1 className="studyupheader">StudyUp</h1>
                <h2 className="studyupblizz">Sponsored by Blizzard T. Husky</h2>
                <hr></hr>
            </div>
            {setView}
            <div>
                <h3 className="smallcaps">My Sets</h3>
                <ul className="smallcaps">
                    {this.state.allSets.length==0? <p className="smallcaps">you have no sets</p>: Object.entries(this.state.allSets).map(([key,value]) => (<li><button className="button1" onClick = {(e) => this.handleViewingSet(key,value,e)}>{key}</button></li>))}
                </ul>
                <button className="smallcaps button1" onClick={this.handleCreating}>+ Create Set</button>
                <p className="smallcaps">Select a set to view it and study</p>
            </div>
            </div>
        );
    }
}

