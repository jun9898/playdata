import MovieList from "./MovieList"

const Movie = function(props) {
    return (
        <div className="row">
            {props.list.map((row) =>
                <MovieList 
                    key={row.movieId} 
                    title={row.title}
                    url={row.url} 
                    alt={row.alt} 
                    genre={row.genre}>
                </MovieList>
            )}
        </div>
    )
}

export default Movie