import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Linkify from 'linkify-react'
import 'linkify-plugin-mention'
import { Link } from 'react-router-dom'
import like from '../components/img/like-icon.png'
import liked from '../components/img/liked-icon.png'

const Feed = () => {

  const id =  sessionStorage.getItem('id')
  const [post, setPost] = useState([])
  
  useEffect(() => {
  axios.get(`http://localhost:8080/api/posts/all/${id}/following`)
  .then((res) => {
      setPost(res.data)
      console.log(post)
  })
  .catch((err) => console.log(err))
  }, [])

  const mention = {
    formatHref: {
        mention: (href) => '/profile' + href,
    },
}

  post.sort((a, b) => {
    return new Date(b.createdAt) - new Date(a.createdAt)
  })

  return (
    <div>
      <div className='tweets'>
            {post.map((p, i) => {
                return (
                    
                    <div className='tweet' key={i}>
                        <div>
                        <code style={{float: 'left', fontSize: 'small'}}>
              
                            <Link to={`/profile/${p.poster.username}`}>@{p.poster.username}</Link>{' // '}
                            {`${new Date(p.createdAt).toLocaleDateString('default', {day: 'numeric', year: 'numeric', month:'short'})} `}{' // '}
                            <Link to={`/post/${p.poster.username}/${p.id}`}>  
                                {p.comments.length === 1 ? <span>{p.comments.length} comment</span> : null}
                                {p.comments.length === 0 ? <span>comment</span> : null} 
                                {p.comments.length > 1 ? <span>{p.comments.length} comments</span> : null} 
                            </Link>{' // '}
                             {p.users_who_favorited.length > 0 ? <img src={liked} style={{marginBottom: '-5px', height: '17px'}} alt='liked' /> : <img src={like} style={{marginBottom: '-5px', height: '17px'}} alt='like'/> } 
                            </code> 
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

export default Feed