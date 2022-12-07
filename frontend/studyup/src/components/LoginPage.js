import React, { useEffect } from "react";
import root from '../index.js';
import {confirmUserAPI,createUser,addTerm,createStudySet, getTermsData, showSetsData, ShowUsersData, allSetsForUser} from "../apiFunctions";
import HomePage from "./HomePage.js";
import { Link, useNavigation } from "react-router-dom";

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
            if(confirmUserAPI(userID,passID)===true){
                window.location("/home");
            }
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
        <div className="signInForm alignc"><br></br>
            <form onSubmit={this.confirmUser} action="/home">
                <input type="text" className="inputtext " placeholder="username" id="loginUsername"></input>
                <input type="text" className="inputtext" placeholder="password" id ="loginPassword"></input><br></br>
                <button type="submit" className="smallcaps button1">Log In</button>
            </form>
            <button className="smallcaps button1" onClick={this.handleLoginSignup}>Sign Up</button>
        </div>);
        let signup = (
        <div className="loginForm alignc"><br></br>
            <form onSubmit={this.registerUser}>
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