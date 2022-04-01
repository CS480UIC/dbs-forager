use forager;

--SIMPLE QUERIES
------------------------------
SELECT * 
FROM interaction 
WHERE from_id = 5667 
ORDER BY timestamp;


SELECT * 
FROM donor 
ORDER BY avg_rating_received DESC;


CREATE VIEW proteinPicker AS
SELECT * 
FROM food 
WHERE food_type LIKE ("%Dairy%" OR "%Protein%") 
ORDER BY calorie_tracker;


SELECT username
FROM user
WHERE last_name = 'Joey';


--AGGREGATE QUERIES
---------------------------------
CREATE VIEW avgCalorieTracker AS
SELECT food_type, AVG(calorie_tracker) 
FROM food 
GROUP BY food_type 
HAVING AVG(calorie_tracker)>50.0;


SELECT address, food_type, CONCAT(food_type, ' ', address) AS foodtype_address 
FROM restaurant 
ORDER BY full_name;


SELECT * 
FROM interaction 
WHERE date_created < NOW();


SELECT location, MAX(location_radius)
FROM volunteer
GROUP BY location
HAVING MAX(location_radius) > 20.0;


--COMPLEX QUERIES
-----------------------------------
SELECT * 
FROM resturants r 
INNER JOIN user u ON r.restaurant_id = u.org_id;


CREATE VIEW  AS maxVeggieCalorieTracker
SELECT food_name 
FROM food main 
WHERE calorie_tracker IN (
  SELECT MAX(calorie_tracker) 
  FROM food sub 
  WHERE main.food_type 
  LIKE "%Veggies%");


SELECT * 
FROM donor
WHERE not EXISTS (
    SELECT * 
    FROM receiver 
    WHERE receiver.user_id != donor.user_id);
    
    
SELECT  volunteer_name
FROM volunteer v
WHERE EXISTS(
  SELECT *
  FROM user
  WHERE ID=v.user_id AND first_name = 'John');
