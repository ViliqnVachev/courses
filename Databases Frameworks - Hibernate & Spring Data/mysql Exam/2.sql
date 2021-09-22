# 4
SELECT card_number,job_during_journey
FROM travel_cards
ORDER BY card_number ASC;

#5
SELECT  id, concat(first_name,' ', last_name)as'full_name',ucn
FROM colonists
ORDER BY first_name,last_name,id;

#6
SELECT id,journey_start,journey_end
FROM journeys
WHERE purpose='Military'
ORDER BY journey_start ASC;

#7
SELECT c.id, concat(c.first_name,' ',c.last_name)as'full_name'
FROM colonists c
JOIN travel_cards tc
ON tc.colonist_id=c.id AND tc.job_during_journey='Pilot'
ORDER BY c.id ASC;


#8
SELECT COUNT(tc.colonist_id) as 'count'
FROM colonists c
LEFT JOIN travel_cards tc
ON tc.colonist_id=c.id
LEFT JOIN journeys j 
ON tc.journey_id=j.id
WHERE j. purpose='Technical'
GROUP BY j.purpose;

#9
SELECT (s.name) as 'spaceship_name', (sp.name) as 'spaceport_name'
FROM spaceships s
JOIN journeys j 
ON j.spaceship_id=s.id
JOIN spaceports sp 
ON sp.id=j.destination_spaceport_id
GROUP BY s.id
ORDER BY MAX(light_speed_rate)DESC
LIMIT 1;
#WHERE s.light_speed_rate=;

#10
SELECT s.name,s.manufacturer
FROM spaceships s 
JOIN journeys j
ON s.id=j.spaceship_id
JOIN travel_cards tc
ON j.id=tc.journey_id
JOIN colonists c
ON tc.colonist_id=c.id
WHERE c.birth_date BETWEEN '1989-02-01' AND '2019-01-01'

GROUP BY s.id;


#11
SELECT p.name as 'planet_name',sp.name as 'spaceport_name'
FROM planets p
JOIN spaceports sp 
ON p.id=sp.planet_id
JOIN journeys j 
ON j.destination_spaceport_id=sp.id
WHERE j.purpose='Educational'
ORDER BY sp.name DESC;

#12
SELECT p .name as 'planet_name' , COUNT(j.id)as'journey_count'
FROM planets p 
RIGHT JOIN spaceports sp 
ON sp.planet_id=p.id
JOIN journeys j 
ON j.destination_spaceport_id=sp.id
GROUP BY sp.planet_id
ORDER BY journey_count DESC, p.name ASC;
# TRY WIT LEFT/RIGHT JOIN OR GROUP BY 

SELECT id
From planets;


#14
SELECT tc.job_during_journey as 'job_name',COUNT(tc.colonist_id)
FROM travel_cards tc
JOIN journeys j 
ON tc.journey_id=j.id
GROUP BY tc.job_during_journey
HAVING MAX(TIME(journey_end- journey_start))
ORDER BY COUNT(tc.colonist_id) ASC;


SELECT * , MAX(TIME(journey_end- journey_start))
FROM journeys


















