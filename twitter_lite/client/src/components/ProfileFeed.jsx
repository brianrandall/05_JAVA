import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'
import Linkify from 'linkify-react'
import 'linkify-plugin-mention'
import { Link } from 'react-router-dom'
import like from '../components/img/like-icon.png'
import liked from '../components/img/liked-icon.png'
import { render } from '@testing-library/react'

const Profile = () => {
    const {username} = useParams()
    const [post, setPost] = useState([])
    const [favorites, setFavorites] = useState([])
    const [comments, setComments] = useState([])

    useEffect(() => {
        axios.get(`http://localhost:8080/api/posts/${username}`)
        .then((res) => {
            console.log(res.data)
            setPost(res.data)
            setFavorites(res.data.users_who_favorited)
            setComments(res.data.comments)
            
        })
        .catch((err) => console.log(err))
    }, [])

    post.sort((a, b) => {
        return new Date(b.createdAt) - new Date(a.createdAt)
    })

    const mention = {
        formatHref: {
            mention: (href) => '/profile' + href,
        },
    }

    const postHasLikes = () => {
        if (favorites !== 0) {
            return true
        } else {
            return false
        }
    }

    const likePost = (id) => {
        axios.post(`http://localhost:8080/api/posts/like/${id}`, sessionStorage.getItem('id'))
        .then((res) => {
            console.log(res.data)
        })
        .catch((err) => console.log(err))
    }

    const unlikePost = (id) => {
        axios.post(`http://localhost:8080/api/posts/unlike/${id}`, sessionStorage.getItem('id'))
        .then((res) => {
            console.log(res.data)
        })
        .catch((err) => console.log(err))
    }

    return (
    <div>
        <div className='tweets'>
            {post.map((p, i) => {
                return (
                    
                    <div className='tweet' key={i}>
                        <div>
                        <code style={{float: 'left', fontSize: 'small'}}>
                            @{username}{' // '}
                            {`${new Date(p.createdAt).toLocaleDateString('default', {day: 'numeric', year: 'numeric', month:'short'})} `}{' // '}
                            <Link to={`/post/${username}/${p.id}`}>  
                                {p.comments.length === 1 ? <span>{p.comments.length} comment</span> : null}
                                {p.comments.length === 0 ? <span>comment</span> : null} 
                                {p.comments.length > 1 ? <span>{p.comments.length} comments</span> : null} 
                            </Link>{' // '}
                            {postHasLikes() ? <img src={liked} style={{marginBottom: '-5px', height: '17px'}} alt='liked' /> : <img src={like} style={{marginBottom: '-5px', height: '17px'}} alt='like'/> } </code>  
                        </div>
                        <p>
                            <Linkify options={mention}>{p.content}</Linkify>
                        </p>
                        
                    </div>
                )

            }
            )}
        </div>
    </div>
    )
}


export default Profile






// {orderedPost.comments.length === 1 ? <Link to={'/'}>1 comment</Link> : <Link to={'/'}> comment</Link> } 

// <Link to={'/'}>  {orderedPost.comments.length !== 0 ? <span>{orderedPost.comments.length} comments</span> : <span>comment</span>}  </Link>