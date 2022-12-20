import React, { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

const NavBar = () => {

const [username, setUsername] = useState('')
const [firstName, setFirstName] = useState('')
const [id, setId] = useState('')

const logout = () => {
    sessionStorage.removeItem('loggedIn')
    //refresh the page
    window.location.href = '/'
}

axios.get(`http://localhost:8080/api/users/email/${sessionStorage.getItem('loggedIn')}`)
    .then((res) => {
        console.log(res.data)
        setUsername(res.data.username)
        setFirstName(res.data.firstName)
        setId(res.data.id)
        sessionStorage.setItem('id', res.data.id)
        sessionStorage.setItem('loggedInUsername', res.data.username)
        
    })
    .catch((err) => console.log(err))


return (
<div id='nav'>
    
    <code>twitter.lite</code>
    <span>......</span>
    <span style={{fontStyle:"oblique"}}>Hello {firstName}</span>
    <span>@{username}</span>
    <span>......</span>
    <a href='/home'>Home</a>
    <Link to={`/profile/${username}`}>Profile</Link>
    <span style={{borderBottom: '1px solid #828282', paddingBottom: '5px'}}>
        <Link to={`/profile/${id}/edit`}>Settings</Link>
    </span>
    <button onClick={logout} >Logout</button> 
</div>
)
}

export default NavBar