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
        if(this.state.showingTerm==1)this.setState({showingTerm:0});
        else{this.setState({showingTerm:1});}
    }
    handleNext(){
        this.setState({currentIndex:this.state.currentIndex+1});
    }
    handlePrevious(){
        this.setState({currentIndex:this.state.currentIndex-1});
    }
    render(){
            return (<div >
                <h1>{this.state.set[this.state.currentIndex][this.state.showingTerm]}</h1>
                <div id="buttons">
                    <button onClick={this.handlePrevious}>Previous</button>
                    <button onClick={this.handleShowingTerm}>Flip flashcard</button>
                    <button onClick={this.handleNext}>Next</button>
                </div>
            </div>);
    }
}