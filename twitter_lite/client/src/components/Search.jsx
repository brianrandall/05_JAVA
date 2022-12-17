import React, { useState } from 'react'

const Search = () => {

    const [searchFor, setSearchFor]= useState('')
    
    const search = (e) => {
        setSearchFor(e.target.value)
    }
  return (
    <div>
        <textarea placeholder='Search Twitter.lite' onChange={ search } />
        <div id='search-results'>
            {searchFor}
        </div>
    </div>
  )
}

export default Search