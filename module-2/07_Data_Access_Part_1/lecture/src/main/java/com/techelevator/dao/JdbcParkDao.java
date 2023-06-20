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
        return 0;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        return null;
    }
    
    @Override
    public double getAvgParkArea() {
        double averageParkArea = 0;
        String sql = "SELECT AVG(area) AS avg_area FROM park";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        if (rows.next()) {
            averageParkArea = rows.getDouble("avg_area");
        }


        return averageParkArea;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> listOfParkNames = new ArrayList<>();

        String sql = "SELECT park_name FROM park;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()){
            String parkName = rows.getString("park_name");
            listOfParkNames.add(parkName);
        }

        return listOfParkNames;
    }
    
    @Override
    public Park getRandomPark() {
        String sql = "SELECT park_id, park_name, date_established FROM park ORDER BY RANDOM() LIMIT 1;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()){
            Park park = new Park();
            park.setParkId(rows.getInt("park_id"));
            park.setParkName(rows.getString("park_name"));

            if ( rows.getDate("date_established") != null){
                park.setDateEstablished(rows.getDate("date_established").toLocalDate());
            }
        }
        return new Park();
    }

    @Override
    public List<Park> getParksWithCamping() {

        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {
        return new Park();
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<>();
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        return new Park();
    }
}
