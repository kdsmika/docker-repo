# docker-repo
Please use below step to build and run the Services.

1. Navigate to the backend-project directory:
   cd application_rest_backend
2. Build and Start All Services in background:
   docker-compose up -d --build
3. Verify Running Containers:
   docker ps
4. Access the Applications:
  UI Application: http://localhost:8484
5. Verify Services:
  Check if MySQL is running with:
    docker exec -it mysql mysql -uroot -proot
  Test Redis functionality:
    docker exec -it redis redis-cli
6. In mysql containter, run below command to create author for creating book alongwith author.
   docker exec -it mysql mysql -uroot -proot
  use rest_db;
  insert into author value(1, 'Kapil');
  insert into author value(2, 'Root');
  insert into author value(3, 'Author');
8. Stop Containers: To stop and clean up all containers, use:
  docker-compose down
