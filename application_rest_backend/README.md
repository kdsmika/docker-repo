
Run mySql Container from docker image
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=rest_db mysql

Go to inside the container 
docker exec -it mysql mysql -uroot -proot

Execute below command to save date into author table

For Author

// insert into author value(1, 'Kapil');
// insert into author value(2, 'Root'); 
// insert into author value(3, 'Author'); 
