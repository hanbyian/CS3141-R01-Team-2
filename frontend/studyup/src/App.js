import './App.css';
import ReactDOM from 'react-dom/client';
import render from 'react-dom';
import React, { Component } from 'react';
import { setList, SetDisplay, header } from './groups.js';

function App() {
  const container = document.getElementById('root');
  const root = ReactDOM.createRoot(container);
  const emptySampleData = {};
  const sampleData = {User:{username:"hanbyian",password:"Test123!",firstName:"ian",lastName:"Hanby"},sets:{germanSet:{one:"eins",two:"zwei",three:"drei",four:"vier"},spanishSet:{"one":"uno","two":"dos","three":"tres","four":"quatro"}, japaneseSet:{"one":"ichi","two":"ni","three":"san","four":"yon"}}};//test data until we can setup connection with database
  function SignIn(){
    function confirmUser(){//TODO: Hunter to api call
      //props.password and props.username using props param instead?
      //this function calls api to confirm username and password signin, if signin is a good account then render home page.
      const data = {};//data is what we get from api call
      root.render(setList(emptySampleData));
      return;
    }
    return(
      <div className="signInForm">
        <form onSubmit={confirmUser}>
          <input type="text" placeholder="username"></input>
          <input type="text" placeholder="password"></input>
          <button type="submit">Log In</button>
        </form>
      </div>
    );
  }
  class User extends React.Component {
    
    render(){
      return <h3>Hello, {this.props.name}</h3>//use: <User name="Ian Hanby"/>
    }
  }
  return (
    <div>
      <SignIn/>
    </div>
  );
}

export default App;
