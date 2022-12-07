import React, { useEffect } from "react";
import root from '../index.js';
import {confirmUserAPI,createUser,addTerm,createStudySet, getTermsData, showSetsData, ShowUsersData, allSetsForUser} from "../apiFunctions";
import HomePage from "./HomePage.js";
import { Link, useNavigation } from "react-router-dom";
import '../login.css';

class LoginPage extends React.Component{
    constructor(props){
        super(props);
        this.state = {showLogin:true, loggedIn: false}
        this.handleLoginSignup = this.handleLoginSignup.bind(this);
    }
    handleLoginSignup(){
        this.setState({showLogin:(!this.state.showLogin)});
    }
    async confirmUser(){
        if(document.getElementById("loginUsername")!=null){
            const userID = document.getElementById("loginUsername").value;
            const passID = document.getElementById("loginPassword").value;
            confirmUserAPI(userID, passID);

            //let toRender = <HomePage username="ijhanby"/>;
            //root.render(toRender);
            //await fetch("http://54.211.204.247:8181/StudyUp/users/showusers").then(response=>response.json()).then(data=>data.map(e=>
            //{
            //    console.log(e[1] + ":" + e[2]);
            //    console.log(userID + ":" + passID);
            //    if((userID==e[1] && passID==e[2])){
            //        this.setState({loggedIn:true});
            //    }
            //}));
        }
    }
    async registerUser(){
        const username = document.getElementById("signupUser").value;
        const password = document.getElementById("signupPass").value;
        const email = document.getElementById("signupEmail").value;
        const name = document.getElementById("signupName").value;
        if(username!=''&&password!=''&&email!=''&&name!='')await createUser(username,password,email,name);
    }
    render(){

        let login = (
        <div id="background" className="signInForm loginform">
            <form classnName="form" onSubmit={this.confirmUser}>
                    <input type="text" className="inputtext " placeholder="Username" id="loginUsername"></input>
                    <br/>
                    <input type="text" className="inputtext" placeholder="Password" id ="loginPassword"></input>
                
                <br></br>
                <button id="btn" type="submit" className="smallcaps button1">Log In</button>
            </form>
            <button id="btn" className="smallcaps button1" onClick={this.handleLoginSignup}>Sign Up</button>
        </div>);
        let signup = (
        <div id="backgrad" className="loginForm alignc"><br></br>
            <form className="form" onSubmit={this.registerUser}>
                <input type="text" className="inputtext" placeholder="enter a username" id="signupUser"></input>
                <input type="text" className="inputtext" placeholder="enter a password" id="signupPass"></input>
                <input type="text" className="inputtext" placeholder="enter an email" id="signupEmail"></input>
                <input type="text" className="inputtext" placeholder="enter your name" id="signupName"></input><br></br>
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
        if(this.state.loggedIn){
            return <HomePage username="ijhanby"/>;
        }
        return (
            <div>
                {showing}
            </div>
        );
    }
}

export default LoginPage;