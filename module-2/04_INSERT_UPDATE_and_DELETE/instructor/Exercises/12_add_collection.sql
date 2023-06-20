-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

1. Create a collection
    - INSERT into the collection table
2. Update Bill Murray Movies to be in that collection
    - UPDATE every movie that has bill murray as an actor in that movie 
      WHERE the collection id equals the new collection

UPDATE movie
SET collection_id = ( subquery that returns our collection id by selecting by name )
WHERE movie_id IN ( subquery that selects all the movie ids where bill murrary is an actor  - hint this requires a join )

