import React, { useState } from 'react'
import axios from 'axios'



const NewPost = () => {

const [username, setUsername] = useState('')
const [count, setCount] = useState(0)

const charCount = (e) => {
    setCount(e.target.value.length)
}

// const newPost = {
//     username: username,
//     content: content,
//     date: new Date()
// }


// const handlePost = (e) => {
//     e.preventDefault()
//     fetch('http://localhost:8080/api/users/register', {
//         method: "POST",
//         headers: { "Content-Type": "application/json" },
//         body: JSON.stringify(newPost)
//         }).then((response) => {
//         console.log(response)
//         console.log("new post been posted")
//         sessionStorage.setItem('user', firstName)
//         nav('/home')
//         }).catch(error => {
//         console.log(error)
//     })  
// }

axios.get(`http://localhost:8080/api/users/email/${sessionStorage.getItem('user')}`)
.then((res) => {
    console.log(res.data)
    setUsername(res.data.username)
})
  return (
    <div id='newPost'>
        <div>
            <code style={{float: 'left'}}>@{username}</code>
            {count > 139 ? <span style={{float: 'right', fontSize: 'x-small', color: 'red'}}>{count}/139</span> : <span style={{float: 'right', fontSize: 'x-small'}}>{count}/139</span>}
        </div>
        <form id='compose' >
            <textarea placeholder='What are you thinking?' rows={'5'} cols={'40'} style={{resize: 'none'}} onChange={ charCount }/>
            {count > 139 ? <button type='submit' disabled style={{width: '80px', alignSelf: 'center'}} >Post</button> : <button type='submit' style={{width: '80px', alignSelf: 'center'}}>Post</button>}
        </form>
    </div>
  )
}

export default NewPost