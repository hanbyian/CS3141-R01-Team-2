import React, { Component } from 'react';
import root from './index.js';

export class Flashcards extends React.Component{
    constructor(props){
        super(props);
        this.state={
            set:this.props.set,
            currentIndex:0,
            showingTerm:1
        };
        this.handleNext = this.handleNext.bind(this);
        this.handlePrevious = this.handlePrevious.bind(this);
        this.handleShowingTerm = this.handleShowingTerm.bind(this);
    }
    handleShowingTerm(){
        if(this.state.showingTerm===1)this.setState({showingTerm:0});
        else{this.setState({showingTerm:1});}
    }
    handleNext(){
        let size = this.state.set.length;
        if(this.state.currentIndex+1===size)this.setState({currentIndex:0});
        else{this.setState({currentIndex:this.state.currentIndex+1});}
    }
    handlePrevious(){
        if(this.state.currentIndex===0)this.setState({currentIndex:this.state.set.length-1});
        else{this.setState({currentIndex:this.state.currentIndex-1});}
    }
    render(){
            return (<div>
                <div id="flashcard">
                <h1 className="alignc">{this.state.set[this.state.currentIndex][this.state.showingTerm]}</h1>
                </div><br></br>
                <div className="alignc" id="buttons">
                    <button className="smallcaps button54" onClick={this.handlePrevious}>Previous</button>
                    <button className="smallcaps button54" onClick={this.handleShowingTerm}>Flip flashcard</button>
                    <button className="smallcaps button54" onClick={this.handleNext}>Next</button>
                </div>
            </div>);
    }
}