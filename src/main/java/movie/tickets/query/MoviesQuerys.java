package movie.tickets.query;

public class MoviesQuerys {
    public final static String GET_ALL_MOVIES = "SELECT * FROM movies";
    public final static String GET_ALL_ORDERED_MOVIES_BY_DATE = "SELECT * FROM movies ORDER BY start ASC";
    public final static String GET_ALL_ORDERED_MOVIES_BY_NAME = "SELECT * FROM movies ORDER BY title ASC";
    public final static String GET_MOVIES_BY_DATE = "SELECT * FROM movies WHERE start = ?";
    public final static String ADD_JUST_MOVIE_SQL = "INSERT INTO movies (id,title,genre,director,start,time) values (:id,:title,:genre,:director,:start,:time)";
    public final static String DELETE_MOVIE_SQL = "DELETE FROM movies where title = ?";
    public final static String DELETE_MOVIE_ON_DATE_SQL = "DELETE FROM movies where title = ? and start = ?";
    public final static String CONNECT_MOVIES_TO_CIMENAS = "INSERT INTO movie_showings (id,cinema_id,movie_id) values (NLUL,?,?)";

}
