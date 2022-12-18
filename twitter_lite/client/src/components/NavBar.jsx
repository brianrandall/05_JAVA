import React, { useState } from 'react'
import axios from 'axios'

const NavBar = () => {

const [username, setUsername] = useState('')
const [firstName, setFirstName] = useState('')

const logout = () => {
    sessionStorage.removeItem('user')
    //refresh the page
    window.location.href = '/'
}

axios.get(`http://localhost:8080/api/users/email/${sessionStorage.getItem('loggedIn')}`)
    .then((res) => {
        console.log(res.data)
        setUsername(res.data.username)
        setFirstName(res.data.firstName)
        
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
    <a href='/profile'>Profile</a>
    <a href='/editprofile' style={{borderBottom: '1px solid #828282', paddingBottom: '5px'}}>Settings</a>
    <button onClick={logout} >Logout</button> 
</div>
)
}

export default NavBar