package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movie = new ArrayList<>();
        String sql = "SELECT * FROM movie";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            movie.add(mapRowToMovie(result));
        }
        return movie;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = null;
        String sql = "SELECT * FROM movie WHERE movie_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);
        while(result.next()){
            movie = mapRowToMovie(result);
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movie = new ArrayList<>();
        String sql = "SELECT * FROM movie WHERE title ILIKE ?";
        String entry = title;
        if (useWildCard){
            entry = "%" + title + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,entry);
        while (result.next()){
            movie.add(mapRowToMovie(result));
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear,
           int endYear, boolean useWildCard) {
        List<Movie> movie = new ArrayList<>();
        String sql = "SELECT * FROM movie WHERE director_id = (SELECT person_id FROM person WHERE person_name ILIKE ?) AND release_date BETWEEN ? AND ?";
        String entry = directorName;
        if (useWildCard){
            entry = "%" + directorName + "%";
        }
        LocalDate startDate = LocalDate.of(startYear - 1, 12, 31);
        LocalDate endDate = LocalDate.of(endYear + 1, 1, 1);
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,entry,startDate,endDate);
        while (result.next()){
            movie.add(mapRowToMovie(result));
        }
        return movie;
    }
    private Movie mapRowToMovie(SqlRowSet sqlRowSet){
        Movie movie = new Movie();
        movie.setCollectionId(sqlRowSet.getInt("collection_id"));
        movie.setDirectorId(sqlRowSet.getInt("director_id"));
        movie.setHomePage(sqlRowSet.getString("home_page"));
        movie.setId(sqlRowSet.getInt("movie_id"));
        movie.setLengthMinutes(sqlRowSet.getInt("length_minutes"));
        movie.setOverview(sqlRowSet.getString("overview"));
        movie.setPosterPath(sqlRowSet.getString("poster_path"));
        movie.setTitle(sqlRowSet.getString("title"));
        movie.setTagline(sqlRowSet.getString("tagline"));
        if (sqlRowSet.getDate("release_date") != null){
            movie.setReleaseDate(sqlRowSet.getDate("release_date").toLocalDate());
        }
        return movie;
    }
}
