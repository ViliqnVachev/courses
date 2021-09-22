CREATE DATABASE test;
USE test;
CREATE TABLE pictures(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`path` VARCHAR(255) NOT NULL,
`size` DECIMAL(10,2) NOT NULL
);

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(30) NOT NULL,
profile_picture_id INT
);

CREATE TABLE posts(
id INT PRIMARY KEY AUTO_INCREMENT,
caption VARCHAR(255) NOT NULL,
user_id INT NOT NULL,
picture_id INT NOT NULL
);

CREATE TABLE comments(
id INT PRIMARY KEY AUTO_INCREMENT,
content VARCHAR(255) NOT NULL,
user_id INT NOT NULL,
post_id INT NOT NULL
);

CREATE TABLE users_followers(
user_id INT ,
follower_id INT
);

ALTER TABLE users
ADD CONSTRAINT fk_pictures_users 
FOREIGN KEY users(profile_picture_id)
REFERENCES pictures(id);

ALTER TABLE posts
ADD CONSTRAINT fk_users_posts
FOREIGN KEY posts(user_id)
REFERENCES users(id);

ALTER TABLE posts
ADD CONSTRAINT fk_pictures_posts
FOREIGN KEY posts(picture_id)
REFERENCES pictures(id);

ALTER TABLE comments
ADD CONSTRAINT fk_users_comments
FOREIGN KEY comments(user_id)
REFERENCES users(id);

ALTER TABLE comments
ADD CONSTRAINT fk_post_comments
FOREIGN KEY comments(post_id)
REFERENCES posts(id);

ALTER TABLE users_followers
#ADD CONSTRAINT pk_users_followers
#PRIMARY KEY (user_id,follower_id),
ADD CONSTRAINT fk_users_followers_users
FOREIGN KEY users_followers (user_id)
REFERENCES users (id),
ADD CONSTRAINT fk_users_followers_follower
FOREIGN KEY users_followers(follower_id)
REFERENCES users (id);

SELECT id,username
FROM users
ORDER BY id;

SELECT uf.user_id,u.username
FROM users_followers uf
JOIN users u
ON uf.user_id=u.id
WHERE user_id= follower_id
ORDER BY user_id;

SELECT id,path,size
FROM pictures
WHERE size>50000 AND (path LIKE '%jpeg%' OR path LIKE '%png%')
ORDER BY size DESC;

SELECT c.id, concat(u.username,' : ',c.content)
FROM comments c
JOIN users u
ON c.user_id=u.id
ORDER BY c.id DESC;

SELECT u.id,u.username,concat(p.size,'KB') AS 'size',u.profile_picture_id
FROM users u
JOIN pictures p 
ON u.profile_picture_id=p.id
where u.profile_picture_id in (Select u2.profile_picture_id
						from users u2
                        GROUP BY (u.profile_picture_id)having count(*) > 1)
ORDER BY u.id;

SELECT p.id,p.caption,COUNT(c.post_id) as 'comments'
FROM posts p
LEFT JOIN comments c 
ON p.id=c.post_id
GROUP BY p.id
ORDER BY COUNT(c.post_id) DESC, p.id
LIMIT 5;

SELECT u.id, u.username, count_posts.posts, count_followers.followers
FROM users u 
JOIN (
		SELECT p.user_id, COUNT(p.id) as `posts`
		FROM posts p
		GROUP BY p.user_id) as `count_posts`
ON u.id=count_posts.user_id
JOIN (
		SELECT uf.user_id, COUNT(uf.follower_id) `followers`
		FROM users_followers uf
		GROUP BY uf.user_id
	) `count_followers`
ON u.id=count_followers.user_id
ORDER BY followers DESC
LIMIT 1;





SELECT user_id,COUNT(id)
from posts
group by user_id;

SELECT COUNT(user_id)
from comments
GROUP BY post_







INSERT INTO issues(title,issue_status,repository_id, assignee_id)
  SELECT (concat('Critical Problem With ',f.name,'!')),issue_status='open',
  (cail(f.id*2/3)),(c.contributor_id)
  FROM files f
  JOIN commits c
  ON c.id=f.commit_id
  WHERE f.id BETWEEN 46 AND 50 ;







