const MovieList = function({movieId,title,alt,url,genre}) {
    function myevent(event) {
        event.preventDefault()
        alert(title)
    }
    return (
        <div className="col-3" onClick={myevent}>
            <p>{title}</p>
            <img src={url} alt={alt}/>
            <p>{genre}</p>
        </div>

    )
}

export default MovieList