import React, { Component } from 'react';

//params(key,value) key==name of set, value==set of term/definition pairs that corresponds to the set of key's name
export const SetDisplay = (key,value) => (
    <div>
        <h3>{key}</h3>
        <button>Study This Set</button>
        <ul>{Object.entries(value).map(([key,value]) => (<li>{key} -- {value}</li>))}</ul>
    </div>
);

export const header = (
    <div className="header">
      <h1>StudyUp</h1>
      <h2>Sponsored by Blizzard T. Husky</h2>
    </div>
  );

export const setList = (sets) => (
    <div>
        <h3>My Sets</h3>
        <ul>
            {Object.entries(sets)==0? <p>you have no sets</p>: Object.entries(sets).map(([key,value]) => (<li>{key}</li>))}
        </ul>
        <button>+ Create Set</button>
        <p>Select a set to view it and study</p>
    </div>
    );

export const newSet = (
    <div>

    </div>
    );

export const flashcards = (
    <div></div>
    );

export const footer = (
    <div></div>
    );

