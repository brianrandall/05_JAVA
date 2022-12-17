import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

const Register = () => {

    const nav = useNavigate();

    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [username, setUsername] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [passwordConfirmation, setPasswordConfirmation] = useState('')
    const [firstNameError, setFirstNameError] = useState('')
    const [lastNameError, setLastNameError] = useState('')
    const [usernameError, setUsernameError] = useState('')
    const [emailError, setEmailError] = useState('')
    const [usernameExists, setUserNameExists] = useState('')
    const [passwordError, setPasswordError] = useState('')
    const [passwordConfirmationError, setPasswordConfirmationError] = useState('')
    const [validationCount, setValidationCount] = useState(0)
    const [fnx, setFnx] = useState(false)
    const [lnx, setLnx] = useState(false)
    const [unx, setUnx] = useState(false)
    const [emx, setEmx] = useState(false)
    const [pwx, setPwx] = useState(false)
    const [pcx, setPcx] = useState(false)


    const firstNameValidations = (e) => {
        setFirstName(e.target.value)
        if(e.target.value.length < 2){
            setFirstNameError('First name must be at least 2 characters')
            
        } else {
            setFirstNameError('')
            setFnx(true)
        }
    }

    const lastNameValidations = (e) => {
        setLastName(e.target.value)
        if(e.target.value.length < 2){
            setLastNameError('Last name must be at least 2 characters')
            setValidationCount(validationCount - 1)
        } else {
            setLastNameError('')
            setLnx(true)
        }
    }

    const usernameValidations = (e) => {
        setUsername(e.target.value)
        if(e.target.value.length < 2){
            setUsernameError('Username must be at least 2 characters')
        } else {
            setUsernameError('')
            setUnx(true)
        }
    }

    const emailValidations = (e) => {
        setEmail(e.target.value)
        if(e.target.value.length < 2){
            setEmailError('Email must be at least 2 characters')
        }
        else {
            setEmailError('')
            setEmx(true)
        }
    }

    const passwordValidations = (e) => {
        setPassword(e.target.value)
        if(e.target.value.length < 2){
            setPasswordError('Password must be at least 2 characters')
        } else {
            setPasswordError('')
            setPwx(true)
        }
    }

    const passwordCompare = (e) => {
        setPasswordConfirmation(e.target.value)
        if(e.target.value !== password){
            setPasswordConfirmationError('Passwords do not match')
        } else {
            setPasswordConfirmationError('')
            setPcx(true)
        }
    }

    const registerNewUser = (e) => {

        e.preventDefault()
        const newUser = {
            firstName,
            lastName,
            username,
            email,
            password,
            passwordConfirmation
        }

        axios.get(`http://localhost:8080/api/users/username/${username}`)
            .then((res) => {
                if (res.data.username === username) {
                    setUserNameExists('username already exists')
                } else {
                    setUserNameExists('')
                    fetch('http://localhost:8080/api/users/register', {
                        method: "POST",
                        headers: { "Content-Type": "application/json" },
                        body: JSON.stringify(newUser)
                    }).then((response) => {
                        console.log(response)
                        console.log("new user added")
                        sessionStorage.setItem('user', firstName)
                        nav('/home')
                    }).catch(error => {
                        console.log(error)
                    })
                }
            })
            .catch((err) => console.log(err))
    }


  return (
    <div className='middleOfPage'>
        <h3>join us </h3>
        <form onSubmit={registerNewUser} >
            
            <input type="text" placeholder="first name" required={true} name='firstName' onChange={ firstNameValidations } /><br/>
            {firstNameError ? <p className='error-text'>{firstNameError}</p> : ''}
            <input type="text" placeholder="last name" required={true} name='lastName' onChange={ lastNameValidations } /><br/>
            {lastNameError ? <p className='error-text'>{lastNameError}</p> : ''}
            <input type="text" placeholder="username" required={true} onChange={ usernameValidations } /><br/>
            {usernameError ? <p className='error-text'>{usernameError}</p> : ''}
            {usernameExists ? <p className='error-text'>{usernameExists}</p> : ''}
            <input type="text" placeholder="email" required={true} onChange={ emailValidations } /><br/>
            {emailError ? <p className='error-text'>{emailError}</p> : ''}
            <input type="password" placeholder="password" required={true} onChange={ passwordValidations } /><br/>
            {passwordError ? <p className='error-text'>{passwordError}</p> : ''}
            <input type="password" placeholder="confirm password" required={true} onChange={ passwordCompare }/><br/>
            {passwordConfirmationError ? <p className='error-text'>{passwordConfirmationError}</p> : ''}
            {fnx === true && lnx === true && unx === true && emx === true && pwx === true && pcx === true
            ?
            <button type="submit" style={{marginTop: '10px'}}>Register</button>
            :
            <button type="submit" style={{marginTop: '10px'}} disabled>Register</button>}
        </form>
        {password}<br/>
        {passwordConfirmation}
    </div>
  )
}

export default Register