import React, { useState } from 'react'

const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [tryagain, setTryagain] = useState('')
    const userLogin = {
        email,
        password
    }

    const loginUser = (e) => {
        e.preventDefault()
        console.log(userLogin)
        fetch('http://localhost:8080/api/users/login', {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userLogin),
            ResponseType: JSON
        })
        .then((response) => {
            console.log(response)
            if (response.status === 200) {
                console.log('login successful')
                window.location.href = '/home'
                sessionStorage.setItem('loggedIn', email)
            }
            else {
                console.log(response.data)
                setTryagain('try again')
            }
        })
    }
    //make the twitter bird fly around the page


  return (
    <div className='middleOfPage'>
        
        <h3>Welcome to Twitter lite</h3>
        <form onSubmit={loginUser}>
            <input type="text" placeholder="email" onChange={(e) => setEmail(e.target.value)} /><br/>
            <input type="password" placeholder="password" onChange={(e) => setPassword(e.target.value)} /><br/>
            {tryagain ? <p style={{color: 'red'}}>{tryagain}</p> : ''}
            <button type="submit" style={{marginTop: '10px'}}>Login</button>
        </form>
        

        <div>
            <p>New User? <a href="/register" style={{fontStyle: 'oblique'}}>Sign up</a></p>
        </div>
    </div>
  )
}

export default Login