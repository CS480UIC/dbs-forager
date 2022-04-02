use forager;

--PROCEDURES

CREATE Procedure PeakOrderTime(OUT peakTime DATETIME)
	SELECT MAX(COUNT(pick_up_time)) 
  INTO peakTime
  FROM food_order 
  GROUP BY pick_up_time;


CREATE PROCEDURE RestaurantParticipation(OUT number INT)
	SELECT COUNT(*)
	INTO number
	FROM user
	WHERE org_id IS NOT NULL;

CREATE PROCEDURE HighestDonor(OUT name varchar(50))
	SELECT username 
  INTO name
	FROM user
	WHERE id = (SELECT user_id 
              FROM donor 
	      WHERE no_of_times_donated = MAX(no_of_times_donated));


--FUNCTIONS

CREATE FUNCTION MostCommonReceiverType()
  RETURNS VARCHAR(50)
  READS SQL DATA
BEGIN
	DECLARE max_receiver_type varchar(50);

	SELECT receiver_type 
  INTO max_receiver_type
	FROM receiver
	GROUP BY receiver_type
	ORDER BY COUNT(*) DESC
	LIMIT 1;

	RETURN max_receiver_type;
END ;

CREATE FUNCTION dairyFoodCount()
  RETURNS INT
  READS SQL DATA
BEGIN
	DECLARE dairyCount INT;
    
	SELECT Count(*)
        INTO dairyCount
        FROM food
        WHERE food_type LIKE "%Dairy%";
   
        RETURN dairyCount;
   
END;


CREATE FUNCTION DedicatedVolunteers ( Location VARCHAR(30))
	RETURNS INT
	DETERMINISTIC
BEGIN
	DECLARE peopleCount VARCHAR(3)
	RETURN
		SELECT COUNT(*)
		INTO peopleCount
		FROM Volunteer
		WHERE preferred_location = Location AND location_radius > 20;
    
END;
