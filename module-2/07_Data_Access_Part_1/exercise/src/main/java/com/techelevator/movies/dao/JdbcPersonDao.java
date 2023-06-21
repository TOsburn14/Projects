package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> person = new ArrayList<>();
        String sql = "SELECT * FROM person";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            person.add(mapRowToPerson(result));
        }
        return person;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        String sql = "SELECT * FROM person WHERE person_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        while (result.next()) {
            person = mapRowToPerson(result);
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> person = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE person_name ILIKE ?";
        String entry = name;
        if (useWildCard){
            entry = "%" + name + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,entry);
        while (result.next()){
            person.add(mapRowToPerson(result));
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> person = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE person_id IN (SELECT actor_id FROM movie_actor WHERE movie_id IN (SELECT movie_id FROM movie WHERE collection_id = (SELECT collection_id FROM collection WHERE collection_name ILIKE ?)))";
        String entry = collectionName;
        if (useWildCard){
            entry = "%" + collectionName + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,entry);
        while (result.next()){
            person.add(mapRowToPerson(result));
        }
        return person;
    }

    private Person mapRowToPerson(SqlRowSet sqlRowSet) {
        Person person = new Person();
        person.setId(sqlRowSet.getInt("person_id"));
        person.setName(sqlRowSet.getString("person_name"));
        person.setBiography(sqlRowSet.getString("biography"));
        if (sqlRowSet.getDate("birthday") != null) {
            person.setBirthday(sqlRowSet.getDate("birthday").toLocalDate());
        }
        if (sqlRowSet.getDate("deathday") != null) {
            person.setDeathDate(sqlRowSet.getDate("deathday").toLocalDate());
        }
        person.setHomePage(sqlRowSet.getString("home_page"));
        person.setProfilePath(sqlRowSet.getString("profile_path"));
        return person;
    }
}
