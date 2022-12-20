import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'
import Linkify from 'linkify-react'
import 'linkify-plugin-mention'
import { Link } from 'react-router-dom'
import like from '../components/img/like-icon.png'
import liked from '../components/img/liked-icon.png'

export const Post = () => {
    const {id, username} = useParams()
    const [post, setPost] = useState([])
    const [comments, setComments] = useState([])
    const [content, setContent] = useState('')
    const [favorites, setFavorites] = useState([])

    const nav = useNavigate()
    useEffect(() => {
        axios.get(`http://localhost:8080/api/posts/one/${id}`)
        .then((res) => {
            setPost(res.data)
            setComments(res.data.comments)
            setFavorites(res.data.users_who_favorited)
        })
        .catch((err) => console.log(err))
    }, [comments])

    const addComment = (e) => {
        e.preventDefault()
    
        axios.post(`http://localhost:8080/api/posts/${id}/comment/`, {
        content, 
        post_id: id,
        username: sessionStorage.getItem('loggedInUsername')
    })
        .then((res) => {
            console.log(res.data)
            setContent('')
        })
        .catch((err) => console.log(err))
    }

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

    favorites.map((favorite) => {
        if (favorite.username === sessionStorage.getItem('loggedInUsername')) {
            return true
        } else {
            return false
        }
    })

    comments.sort((a, b) => {
        return new Date(b.createdAt) - new Date(a.createdAt)
    })

    function timeSince(date) {
        var seconds = Math.floor((new Date() - date) / 1000);
      
        var interval = seconds / 31536000;
      
        if (interval > 1) {
        Math.floor(interval)
            if (Math.floor(interval) === 1) {
                return Math.floor(interval) + " year ago";
            }
            return Math.floor(interval) + " years ago";
        }
        interval = seconds / 2592000;
        if (interval > 1) {
        Math.floor(interval)
            if (Math.floor(interval) === 1) {
                return Math.floor(interval) + " month ago";
            }
            return Math.floor(interval) + " months ago";
        }
        interval = seconds / 86400;
        if (interval > 1) {
        Math.floor(interval)
            if (Math.floor(interval) === 1) {
                return Math.floor(interval) + " day ago";
            }
            return Math.floor(interval) + " days ago";
        }
        interval = seconds / 3600;
        if (interval > 1) {
          Math.floor(interval)
            if (Math.floor(interval) === 1) {
                return Math.floor(interval) + " hour ago";
            }
            return Math.floor(interval) + " hours ago";
        }
        interval = seconds / 60;
        if (interval > 1) {
        Math.floor(interval)
            if (Math.floor(interval) === 1) {
                return Math.floor(interval) + " minute ago";
            }
            return Math.floor(interval) + " minutes ago";
        }
        if (Math.floor(seconds) === 1) {
            return Math.floor(seconds) + " second ago";
        }
        if (Math.floor(seconds) === 0) {
            return 'just now'
        }
        return Math.floor(seconds) + " seconds ago";
      }
  
    return (
    <div>
        <div className='tweets'>
            <div className='tweet'>
                <div>
                <code style={{float: 'left', fontSize: 'small'}}>
                    @{username}{ ' // ' }
                    {`${new Date(post.createdAt).toLocaleDateString('default', {day: 'numeric', year: 'numeric', month:'short'})} `}{ ' // ' }
                    <Link to={`/post/${post.id}`}>
                        {comments.length === 0 ? <span>comment</span> : null}
                        {comments.length == 1 ? <span>{comments.length} comment</span> : null}
                        {comments.length > 1 ? <span>{comments.length} comments</span> : null}
                    </Link>{ ' // ' }
                    {postHasLikes() ? <img src={liked} style={{marginBottom: '-5px', height: '17px'}} alt='liked' /> : <img src={like} style={{marginBottom: '-5px', height: '17px'}} alt='like'/> }
                </code>  
                </div>
                <p>
                    <Linkify options={mention}>{post.content} </Linkify>
                </p>
            </div>
            <form onSubmit={ addComment }>
                <input type='text' placeholder='comment' onChange={(e) => setContent(e.target.value)} />
                <code onClick={addComment} style={{cursor: 'pointer'}}> post </code>
            </form>
            {comments.map((comment, i) => {
                    return (
                        <div key={i}>
                            <code>
                            <div style={{fontSize: 'small'}}>
                            <p>
                                <Link to={`/profile/${comment.username}`}>@{comment.username}</Link> {timeSince(new Date(comment.createdAt))}
                            </p> 
                            <p>
                                {'>>'} {comment.content}
                            </p>
                            </div>
                            </code>
                        </div>
                    )
                })
                }
        </div>
    </div>
  )
}

export default Post