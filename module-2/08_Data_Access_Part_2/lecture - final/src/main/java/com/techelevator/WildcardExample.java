package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;

public class WildcardExample {

    public static void main(String[] args) {

//        String wildcardValue = "C";
//
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres1");
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//        String sql = "SELECT FROM city WHERE city_name LIKE ?";
//        String parameter = "%" + wildcardValue + "%";
//
//        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, parameter);
//
//        while (rows.next()) {
//            System.out.println( rows.getString("city_name") );
//
//            int population = rows.getInt("population");
//
//
//        }
//
//
//        String secondWildcard = "O";
//        String sql2 = "SELECT * FROM city WHERE city_name LIKE ? OR state_abbreviation LIKE ?";
//        SqlRowSet moreRows = jdbcTemplate.queryForRowSet(sql2, "%" + wildcardValue + "%",
//                "%" + secondWildcard + "%");



        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setUrl("jdbc:postgresql://localhost:5432/MovieDB");
        dataSource2.setUsername("postgres");
        dataSource2.setPassword("postgres1");

        JdbcTemplate movieJdbcTemplate = new JdbcTemplate(dataSource2);

        String movieSql = "SELECT * FROM movie WHERE movie_id = 101";

        SqlRowSet movieRows = movieJdbcTemplate.queryForRowSet(movieSql);

        while (movieRows.next()) {
            int collectiionId = movieRows.getInt("collection_id");
            System.out.println(collectiionId);

            if (movieRows.getDate("release_date") != null) {
                LocalDate releaseDate = movieRows.getDate("release_date").toLocalDate();
            }
        }

    }


}
