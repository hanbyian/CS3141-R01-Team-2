import logo from './logo.svg';
import './App.css';
import ReactDOM from 'react-dom/client';
import React, { Component } from 'react';

function App() {
  function SignIn(){
    function confirmUser(){//TODO: Hunter to api call
      //props.password and props.username using props param instead?
      //this function calls api to confirm username and password signin, if signin is a good account then render home page.
      const data = {};//data is what we get from api call
      root.render(main({name:"Ian Hanby"}));
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
 
  const header = (
    <div className="header">
      <h1>StudyUp</h1>
      <h2>Sponsored by Blizzard T. Husky</h2>
    </div>
  );

  //navBar div just has sample stuff for now, need to finish later
  const navBar = (
    <div className="navBar">
      
      <button>My Sets</button>
      <button>Create New Set</button>
    </div>
  );
  const main =(props)=>(
    <div>
      {header}
      <User name={props.name}/>
      {navBar}
    </div>
  );
  const container = document.getElementById('root');
  const root = ReactDOM.createRoot(container);
  const signInPage = <SignIn/>;
  root.render(signInPage);
  return (
    <div className="App">
      <div id="root">

      </div>
    </div>
  );
}

export default App;
