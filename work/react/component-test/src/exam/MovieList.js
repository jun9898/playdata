const MovieList = function(props) {
    return (
        <div className="col-3">
            <p>{props.title}</p>
            <img src={props.url}></img>
            <p>{props.genre}</p>
        </div>

    )
}

export default MovieList