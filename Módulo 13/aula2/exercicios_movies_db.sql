-- 1)
-- Serve para elimtar redundâncais e garantir consistência dos dados do banco de dados.

-- 2)
INSERT INTO movies (title, rating, awards, length, release_date) VALUES ('Monstros SA', 8.8, 4, 127, '2000-01-01');

-- 3)
INSERT INTO genres (name, ranking, active) VALUES ('Desenho', '13', 1);

-- 4)
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- 5)
UPDATE actors SET favorite_movie_id = 22 WHERE id = 1;

-- 6)
CREATE TEMPORARY TABLE temporary_movies SELECT * FROM movies;

-- 7)
DELETE FROM temporary_movies WHERE awards < 5;

-- 8)
SELECT DISTINCT g.name
FROM movies m
JOIN genres g
	ON g.id = m.genre_id
ORDER BY g.name;

-- 9)
SELECT DISTINCT CONCAT(a.first_name, ' ', a.last_name) AS fullName, m.title
FROM actors a
JOIN movies m
	ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 10)
EXPLAIN SELECT * FROM movies;
EXPLAIN DELETE FROM temporary_movies WHERE awards < 5;

-- 11)
-- Para otimizar as consultas :)

-- 12)
CREATE INDEX idx_movies_title ON movies (title);

-- 13)
SELECT DISTINCT table_name, index_name
FROM information_schema.statistics
WHERE table_schema = 'movies_db'
AND index_name = 'idx_movies_title';
