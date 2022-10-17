import React, { Component } from 'react';
import root from './index.js';

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
        root.render(<HomePage setKey={Object.keys(sampleData.sets)[0]} setValue={Object.entries(sampleData.sets)[0][1]} sets={sampleData.sets}/>);
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
        this.state = {viewingSetKey:this.props.setKey, viewingSetValue:this.props.setValue, allSets:this.props.sets, isCreating:false}
        this.handleCreating = this.handleCreating.bind(this);
        this.handleViewingSet = this.handleViewingSet.bind(this);
    }
    handleCreating(){
        this.setState({isCreating:true});
    }
    handleViewingSet(newViewingKey, newViewingValue){
        this.setState({viewingSetKey:newViewingKey, viewingSetValue:newViewingValue, isCreating:false});
        
    }
    render() {
        let setView;
        if(this.state.isCreating){
            setView=(
            <div>
                <p>Create Set here</p>
            </div>);
        }else{
            //setView for the currently selected set(stored in state) which shows the terms and has study button
            setView=
            (<div>
                <h3>{this.state.viewingSetKey}</h3>
                <ul>{Object.entries(this.state.viewingSetValue).map(([key,value]) => (<li>{key} -- {value}</li>))}</ul>
                <button>Study This Set</button>
            </div>);
        }
        //returns header, then either creating view or set view then all sets box
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
                    {Object.entries(this.state.allSets)==0? <p>you have no sets</p>: Object.entries(this.state.allSets).map(([key,value]) => (<li><button onClick = {(e) => this.handleViewingSet(key,value,e)}>{key}</button></li>))}
                </ul>
                <button onClick={this.handleCreating}>+ Create Set</button>
                <p>Select a set to view it and study</p>
            </div>
            </div>
        );
    }
}

