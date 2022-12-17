import React from 'react'
import NavBar from '../components/NavBar'
import NewPost from '../components/NewPost'
import Feed from '../components/Feed'
import Search from '../components/Search'

const Home = () => {



  return (
    <div id='home'>
        <div id='home-left'>
            <NavBar />
        </div>
        <div id='home-center'>
            <NewPost />
            <Feed />
        </div>
        <div id='home-right'>
            <Search />
        </div>
    </div>
  )
}

export default Home