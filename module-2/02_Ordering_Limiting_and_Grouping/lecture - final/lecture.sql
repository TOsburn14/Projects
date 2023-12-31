-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT population, state_name
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, population, area, census_region
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT *
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT ((CURRENT_DATE - date_established) / 365) AS age, park_name
FROM park
ORDER BY age DESC, park_name ASC
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ' (' || state_abbreviation || ')') AS city_and_state
FROM city
ORDER BY city_name;

-- The all parks by name and date established.
SELECT ('Name: ' || park_name || ' Date Established: ' || date_established) AS park_and_established_date
FROM park
ORDER BY park_name;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT (census_region || ': ' || state_name) AS region_and_state
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY region_and_state;

-- NUMERIC FUNCTIONS
SELECT *, round(area / population, 6)
FROM city;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS west_south_population
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(population)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS row_count
FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS cities, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;

SELECT has_camping, round(AVG(area), 0) AS avg_park_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS sum_of_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_population
FROM city
GROUP BY state_abbreviation;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
LIMIT 5 OFFSET 5


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(city_name) AS cities, (
	SELECT state_name 
	FROM state 
	WHERE state.state_abbreviation = city.state_abbreviation
)
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;


-- Include the names of the smallest and largest parks
SELECT park_name, area
FROM park p,
	(SELECT MIN(area) AS smallest, MAX(area) AS largest
	 FROM park
	 WHERE area > 0 ) AS s
WHERE p.area = s.smallest OR p.area = s.largest;



-- List of all the cities in the Northeast census region.
SELECT *
FROM city
WHERE state_abbreviation IN ( SELECT state_abbreviation
							  FROM state
							  WHERE census_region = 'Northeast' );

-- List the capital cities for the states in the Northeast census region.
SELECT * 
FROM city 
WHERE city_id IN (SELECT capital
				  FROM state
				  WHERE census_region = 'Northeast');
				  
				  
-- List the capital cities for the states in the Northeast census region with the full statename
SELECT city_name, (SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation) 
FROM city 
WHERE city_id IN (SELECT capital
				  FROM state
				  WHERE census_region = 'Northeast');