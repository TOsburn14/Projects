package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collection";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Collection collection = new Collection();
            collection.setId(results.getInt("collection_id"));
            collection.setName(results.getString("collection_name"));
            collections.add(collection);
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collection = null;
        String sql = "SELECT collection_id FROM collection WHERE collection_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        while (results.next()){
        collection = results.getObject("collection_id",id);

        }
        return new Collection(-1, "Not implemented yet");
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        return null;
    }
}
