-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'.
-- Order the results from the highest movie count to the lowest.
-- (19 rows, the highest expected count is around 400).
SELECT COUNT(title) AS num_of_movies, genre_name
FROM genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie on movie_genre.movie_id = movie.movie_id
GROUP BY genre.genre_name
ORDER BY num_of_movies DESC;
