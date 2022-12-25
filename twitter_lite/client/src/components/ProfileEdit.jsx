import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'
import loc from '../components/img/location-icon.png'
import cal from '../components/img/calendar-icon.png'

const ProfileEdit = () => {
    
    const {id} = useParams()
    const [user, setUser] = useState([])
    const [following, setFollowing] = useState([])
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [username, setUsername] = useState('')
    const [bio, setBio] = useState('')
    const [location, setLocation] = useState('')
    const [password, setPassword] = useState('')
    const [confirmPassword, setConfirmPassword] = useState('')
    
    useEffect(() => {
        axios.get(`http://localhost:8080/api/users/${id}`)
        .then((res) => {
            console.log(res.data)
            setUser(res.data)
            setFirstName(res.data.firstName)
            setLastName(res.data.lastName)
            setUsername(res.data.username)
            setEmail(res.data.email)
            setBio(res.data.bio)
            setLocation(res.data.location)
            setFollowing(res.data.followings)
        })
        .catch((err) => console.log(err))
    }, [id])


    const updateUser = (e) => {
        e.preventDefault()


        axios.put(`http://localhost:8080/api/users/edit/${id}`,
            {firstName,
            lastName,
            email,
            username,
            bio,
            location,
            password}
        )
        .then((res) => {
            console.log(res.data)
        })
        .catch((err) => console.log(err))
    }

    const checkIfLoggedIn = () => {
        if (sessionStorage.getItem('loggedIn') === user.email) {
            return true
        } else {
            return false
        }
    }

  return (
    <div>
    <div id='profile-header'>
        <span>{firstName} {lastName}</span>
        <span style={{color: 'pink', marginBottom: '1em'}}>@{username}</span>
        {user.bio ? <p style={{fontStyle: 'oblique', float: 'left', fontSize: 'small'}}>{bio} </p> : null}
        <div style={{fontSize: 'x-small'}}>
        <img src={loc} style={{filter: 'invert(.9)'}} height='10px' alt='loc'/>
            {location ?  <span>{location}</span> : null} // 
            <img src={cal} style={{filter: 'invert(.9)', marginRight: '3px'}} height='10px'/>
            <span >Joined {`${new Date(user.createdAt).toLocaleDateString('default', {day: 'numeric', year: 'numeric', month:'short'})} `}</span>
        </div>
        <span>
            {following.length} Following 
        </span>
    </div>
    <hr/>
    {checkIfLoggedIn() ? <div>
        <form className='editForm' onSubmit={updateUser}>
            <div className='row'>
                <div>
                    <p>First Name</p>
                    <input type={'text'} value={firstName} onChange={(e) => setFirstName(e.target.value)}/>
                </div>
                <div>
                <p>Last Name</p>
                    <input type={'text'} value={lastName} onChange={(e) => setLastName(e.target.value)}/>
                </div>
                <div>
                <p>@username</p>
                    <input type={'text'} value={username} onChange={(e) => setUsername(e.target.value)}/>
                </div>
            </div>
            <div>
                <p>
                    Bio
                </p>
                <textarea value={bio} rows={'4'} cols={'58'} style={{resize: 'none'}} onChange={(e) => setBio(e.target.value)}/>
            </div>
            <div className='row'>
                <div>
                    <p>Location</p>
                    <textarea value={location} rows={'1'} cols={'25'} style={{resize: 'none'}} onChange={(e) => setLocation(e.target.value)}/>
                </div>
                <div>
                    <p>Email</p>
                    <textarea value={email} rows={'1'} cols={'26'} style={{resize: 'none'}} onChange={(e) => setEmail(e.target.value)}/>
                    </div>
            </div>
            <div className='row'>
                <div>
                    <p>Member Since</p>
                    <input type={'text'} value={`${new Date(user.createdAt).toLocaleDateString('default', {day: 'numeric', year: 'numeric', month:'short'})} `} disabled/>
                </div>
                <div>
                    <p>New Password</p>
                    <input type={'password'} value={password}  onChange={(e) => setPassword(e.target.value) }/>
                </div>
                <div>
                    <p>New Password x2</p>
                    <input type={'password'} value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)}/>
                </div>
            </div>
            <div className='editForm'>
                <span>error 1 // if no errors, submit button</span>
                <button type={'submit'}>Update</button>
            </div>
            {password === confirmPassword ? <span>ok</span> : null}
        </form>
    </div> : null}
    </div>
  )
}

export default ProfileEdit