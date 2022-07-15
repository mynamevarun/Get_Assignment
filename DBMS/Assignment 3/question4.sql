/*Consider a form where providing a Zip Code populates associated City and State.
    Create appropriate tables and relationships for the same and write a SQL
    query for that returns a Resultset containing Zip Code, City Names and
    States ordered by State Name and City Name.
*/

use storefront;

CREATE TABLE state(
    state_id INTEGER AUTO_INCREMENT,
    state_name VARCHAR(20),
    PRIMARY KEY (state_id)
);

CREATE TABLE city(
    city_id INTEGER AUTO_INCREMENT,
    city_name VARCHAR(20),
    state_id INTEGER,
    PRIMARY KEY (city_id),
    FOREIGN KEY (state_id)
        REFERENCES state (state_id)
);
    
CREATE TABLE zipcode(
    zipcode_id CHAR(6),
    city_id INTEGER,
    PRIMARY KEY (zipcode_id),
    FOREIGN KEY (city_id)
        REFERENCES city (city_id)
);


INSERT INTO state (state_name)
VALUES  ("Rajasthan"),
        ("Haryana"),
        ("Uttar Pradesh"),
        ("Madhya Pradesh");
        
INSERT INTO city(city_name, state_id)
VALUES  ("Udaipur", 1),
        ("Jaipur", 1),
        ("Faridabad", 2),
        ("Rohtak", 2),
        ("Agra", 3),
        ("Jhansi", 3),
        ("Shahdol", 4),
        ("Gwalior", 4);

INSERT INTO zipcode(zipcode_id,city_id)
VALUES  ("313002", 1),
        ("313003", 1),
        ("302020", 2),
        ("302023", 2),
        ("121003", 3),
        ("124001", 4),
        ("124021", 4),
        ("223007", 5),
        ("282005", 5),
        ("284001", 6),
        ("284002", 6),
        ("484001", 7),
        ("474005", 8);
        
        
SELECT 
    z.zipcode_id, c.city_name, s.state_name
FROM
    state s
        INNER JOIN
    city c ON s.state_id = c.state_id
        INNER JOIN
    zipcode z ON c.city_id = z.city_id
ORDER BY s.state_name,c.city_name;