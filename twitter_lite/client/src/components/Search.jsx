import React, { useState } from 'react'

const Search = () => {

    const [searchFor, setSearchFor]= useState('')
    
    const search = (e) => {
        setSearchFor(e.target.value)
    }
  return (
    <div>
        <textarea placeholder='Search Twitter.lite' onChange={ search } rows={'2'} cols={'20'} style={{resize: 'none'}} />
        <div id='search-results'>
            {searchFor}
        </div>
    </div>
  )
}

export default Search