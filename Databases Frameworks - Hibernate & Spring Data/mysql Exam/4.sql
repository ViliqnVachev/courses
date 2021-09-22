DELIMITER //
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
BEGIN

DECLARE spaceship_id INT; 

IF 1 <> (SELECT COUNT(*) FROM spaceships WHERE spaceships.name=spaceship_name)
THEN
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
END IF ;


	SET spaceship_id:=(
			SELECT s.id
			FROM spaceships s
			WHERE s.name=spaceship_name
						);
                        
		UPDATE spaceships
        SET light_speed_rate=light_speed_rate+light_speed_rate_increse
        WHERE spaceship_id=id;
                        
END
//


CALL udp_modify_spaceship_light_speed_rate ('Anarchy', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'Anarchy';

SELECT *
FROM spaceships
WHERE id=2;