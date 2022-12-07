import React from 'react';
/*
order matters on params of the json given to post method
URLs
baseURL - http://54.211.204.247:8181/StudyUp

terms URL - http://54.211.204.247:8181/StudyUp/terms
user URL - http://54.211.204.247:8181/StudyUp/users
set URL - http://54.211.204.247:8181/StudyUp/studyset

GET allSetsForUser - http://54.211.204.247:8181/StudyUp/studyset/showSetsForUser/{username}
GET getTerms - http://54.211.204.247:8181/StudyUp/terms/getTerms
GET showSets - http://54.211.204.247:8181/StudyUp/studyset/showSets
GET showusers - http://54.211.204.247:8181/StudyUp/users/showusers

POST createStudySet - http://54.211.204.247:8181/StudyUp/studyset/createStudySet
POST createUser - http://54.211.204.247:8181/StudyUp/users/createUser
POST addTerm - http://54.211.204.247:8181/StudyUp/terms/addTerm
*/
/*
functions needed:
on signup call createUser(u,p,e,n);
on login - 

*/
export async function allSetsForUser(U){
  let tempData;
  await fetch("http://54.211.204.247:8181/StudyUp/studyset/showSetsForUser/"+U).then(response =>response.json()).then(data=>tempData=data);
  return tempData;
}
export async function getTermsData(){
    let tempData;
    await fetch("http://54.211.204.247:8181/StudyUp/terms/getTerms").then(response=>response.json()).then(data=> tempData = data);
    return tempData;
}
export async function showSetsData(){
    let tempData;
    await fetch("http://54.211.204.247:8181/StudyUp/studyset/showSets").then(response=>response.json()).then(data=>  tempData = data);
    return tempData;
}
export async function ShowUsersData(){
    let tempData;
    const cringe = (data) =>{
      tempData = data;
    }
    await fetch("http://54.211.204.247:8181/StudyUp/users/showusers").then(response=>response.json()).then(data=>cringe(data));
    return tempData;

}
export async function confirmUserAPI(U,P){
  let tempData;
    try{
        let postData = {};
        postData.username = U;
        postData.password = P;
        //let data = {"setName":"mySet", "setOwner":"ijhanby"};setOwner has to be a username in users dataset
        //mode:no-cors,
        await fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(postData)
        }).then(res => {
            console.log("Request complete! response:", res);
            if(res.status === 200){
                window.location.replace("/home")
                return;
            }

        });
    }
    catch(e){
        console.log(e);
        console.log("did not work for: " + U);
    }
  return;
}
export async function createStudySet( SN, SO){
    try{
        let postData = {};
        postData.setName = SN;
        postData.setOwner = SO;
        //let data = {"setName":"mySet", "setOwner":"ijhanby"};setOwner has to be a username in users dataset
        //mode:no-cors,
        await fetch("http://54.211.204.247:8181/StudyUp/studyset/createStudySet", {
          method: "POST",
          headers: {'Content-Type': 'application/json'}, 
          body: JSON.stringify(postData)
        }).then(res => {
          console.log("Request complete! response:", res);
        });
      }
      catch(e){
        console.log(e);
        console.log("creating set did not work for setName:" + SN);
      }
}
export async function addTerm(SSID, T, D){
    try{
        //post empty set, then get sets to get setID, then use setID and add each term(individually or at once)
        let postData = {};
        postData.term = T;
        postData.definition = D;
        postData.parentSetID = SSID;
        //let termsData = {term:"ethan", definition:"jones",studySetID:1};
    
        await fetch("http://54.211.204.247:8181/StudyUp/terms/addTerm", {
          method: "POST",
          headers: {'Content-Type': 'application/json'}, 
          body: JSON.stringify(postData)
        }).then(res => {
          console.log("Request complete! response:", res);
        });
      }
      catch(e){
        console.log(e);
        console.log("add term did not work for setID:"+SSID + "and term:"+T);
      }
}
  
export async function createUser(U, P, E, N){
    try{
        let postData = {};
        postData.username = U;
        postData.password = P;
        postData.email = E;
        postData.name = N;
        //let userData = {username: 'ighanby', password: 'test', email: 'ighanby@mtu.edu', name: 'ian yerd'};

        await fetch("http://54.211.204.247:8181/StudyUp/users/createUser", {
        method: "POST",
        headers: {'Content-Type': 'application/json'}, 
        body: JSON.stringify(postData)
        }).then(res => {
        console.log("Request complete! response:", res);
        });
    }
    catch(e){
        console.log(e);
        console.log("create function did not work for username:"+U);
    }
}