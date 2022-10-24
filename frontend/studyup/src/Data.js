import React, { Component } from 'react';
import root from './index.js';

export class Data extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            items: []
        }
    }

    componentDidMount() {
        fetch("")
    }
}