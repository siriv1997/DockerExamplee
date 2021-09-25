const express = require("express");
const app = express();
const moment = require('moment')
const path = require('path')
let date = moment().format("MMM Do YY");

// DB
var MongoClient = require('mongodb').MongoClient;
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(3010, function () {
console.log("listening on 3010");
});

app.get("/", (req, res) => {
// res.send(`Users Shown ${date} modified` );
    res.sendFile(path.join(__dirname,'index.html'))
});

app.get("/delete", (req, res) => {
res.send("Delete User");
});

app.get("/update", (req, res) => {
res.send("Update User");
});

app.get("/insert", (req, res) => {
    var data = req.body;
    MongoClient.connect('mongodb://admin:password@localhost:27017',(err,client) =>{
        if(err) throw err;
        var db = client.db('user-account');
        console.log('successfully connected');
        db.collection('users').insertOne(data,{upsert:true},(err,res)=>{
            if(err) throw err;
            console.log(res);
            client.close()
        });
    })
// res.send("Insert User");
});