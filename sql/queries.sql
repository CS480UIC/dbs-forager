use forager;

--SIMPLE QUERIES
------------------------------
CREATE VIEW importantInteraction AS
SELECT * 
FROM interaction 
WHERE from_id = 5667 
ORDER BY timestamp;

CREATE VIEW highestRatedDonor AS
SELECT * 
FROM donor 
ORDER BY avg_rating_received DESC;


CREATE VIEW proteinPicker AS
SELECT * 
FROM food 
WHERE food_type LIKE ("%Dairy%" OR "%Protein%") 
ORDER BY calorie_tracker;


CREATE VIEW userJoey AS
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


CREATE VIEW alphabeticalRestaurants AS
SELECT address, food_type, CONCAT(food_type, ' ', address) AS foodtype_address 
FROM restaurant 
ORDER BY full_name;


CREATE VIEW showPrevInteractions AS
SELECT * 
FROM interaction 
WHERE date_created < NOW();


CREATE VIEW closestRadius AS
SELECT location, MAX(location_radius)
FROM volunteer
GROUP BY location
HAVING MAX(location_radius) > 20.0;


--COMPLEX QUERIES
-----------------------------------
CREATE VIEW restaurantsAsUser AS
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


CREATE VIEW nonReceiverDonor AS
SELECT * 
FROM donor
WHERE not EXISTS (
    SELECT * 
    FROM receiver 
    WHERE receiver.user_id != donor.user_id);
    
    
CREATE VIEW voulnteerJohn AS
SELECT  volunteer_name
FROM volunteer v
WHERE EXISTS(
  SELECT *
  FROM user
  WHERE ID=v.user_id AND first_name = 'John');
  
  
  
  
  
  
  --Karthik quries
  
  
DROP TABLE interaction;
DROP TABLE message;
DROP TABLE restaurant;



Select * from interaction where from_id = 5667 order by timestamp;


select count(*) from restaurant;
select address, food_type, CONCAT(food_type, ' ',   address) as foodtype_address FROM  restaurant ORDER BY full_name;
SELECT * from interaction where date_created < NOW();
select  food_type , count(*) as num_of_restaurants from restaurant group by food_type Having address LIKE '%Chicago%';



select * from resturants r inner join user u on r.restaurant_id = u.org_id;
select * FROM interaction WHERE  (SELECT reply_of FROM interaction WHERE id = 1);
select * FROM restaurant WHERE CAST(safety_rating as int) > (SELECT avg(CAST(safety_rating as int)) FROM restaurant);
select * FROM interaction WHERE EXISTS (SELECT reply_of FROM interaction WHERE id = 1);


CREATE INDEX index_1
ON restaurant (safety_rating);

CREATE UNIQUE INDEX index_2
ON interaction (to_id,from_id,date_created);
  
  
