DELIMITER //

CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30)) 
RETURNS INT
BEGIN
	DECLARE result INT;
    
    
    
END;

//

SELECT COOUNT(c.id)
FROM colonists 
JOIN travel_cards tc
ON tc.colonist_id=id
JOIN journeys j 
ON j.id=tc.jorney_id
JOIN spaceports sp
ON sp.id=j.destination_spaceport_id
JOIN planets p
ON p.id=sp.planet_id
GROUP BY tc.colonist_id