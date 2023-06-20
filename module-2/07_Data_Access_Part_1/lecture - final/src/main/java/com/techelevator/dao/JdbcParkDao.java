package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
     }


    @Override
    public int getParkCount() {
        String sql = "SELECT COUNT(*) as number_of_parks FROM park;";
        int count = 0;

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        if (rows.next()) {
            count = rows.getInt("number_of_parks");
        }

        return count;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        String sql = "SELECT MIN(date_established) AS earliest_park FROM park";
        LocalDate earliestDateEstablished = null;

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        if (rows.next()) {
            earliestDateEstablished = rows.getDate("earliest_park").toLocalDate();
        }

        return earliestDateEstablished;
    }
    
    @Override
    public double getAvgParkArea() {
        double averageParkArea = 0;

        // STEP 1: SQL as a String
        String sql = "SELECT AVG(area) AS avg_area FROM park";

        // STEP 2: Define a SqlRowSet variable
        // STEP 3: call queryForRowSet() and pass it the SQL string
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        // STEP 4: Check if a next() row exists - Repeat until next() returns false
        while ( rows.next() ) {
            // STEP 5: Get the data from the row by specifying the column
            averageParkArea = rows.getDouble("avg_area");
        }

        return averageParkArea;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> listOfParkNames = new ArrayList<String>();

        String sql = "SELECT park_name FROM park;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()) {
            String parkName = rows.getString("park_name");
            listOfParkNames.add(parkName);
        }
        return listOfParkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park ORDER BY RANDOM() LIMIT 1;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()) {
            park = mapRowToPark( rows );
        }

        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> listOfParks = new ArrayList<Park>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park WHERE has_camping = true";

        SqlRowSet rows = jdbcTemplate.queryForRowSet( sql );

        while ( rows.next() ) {
            listOfParks.add( mapRowToPark(rows ) );
        }

        return listOfParks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, parkId);

        while ( rows.next() ) {
            park = mapRowToPark( rows );
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {

        List<Park> parks = new ArrayList<Park>();

        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE park_state.state_abbreviation = ?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        while (rows.next()) {
            parks.add( mapRowToPark(rows) );
        }

        return parks;
    }

    private Park mapRowToPark(SqlRowSet rows) {
        Park park = new Park();
        park.setParkId( rows.getInt("park_id") );
        park.setParkName( rows.getString("park_name") );
        park.setHasCamping( rows.getBoolean("has_camping") );
        park.setArea( rows.getDouble("area") );

        if ( rows.getDate("date_established") != null ) {
            park.setDateEstablished(rows.getDate("date_established").toLocalDate());
        }
        return park;
    }
}
