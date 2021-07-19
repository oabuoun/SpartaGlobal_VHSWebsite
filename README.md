# SpartaGlobal_VHSWebsite

VHS Website Documentation.

We were given a project by Justin Time, the proud owner of ‘Press Play Video Store’ a VHS rental store with branches across the UK. We were tasked to create a website that follows :
  - A home page that allows the customer to see a selection of the movies available to rent
      - Only movies that are available and not out of stock.
  - A customer should be able to search by title, genre or actor. Along with an additional search filters that can be used to narrow down the search even further.
  - Only 1 copy of each movie. No duplicates allowed.
  - The Customer and Employee should be able to sign in and arrive at different pages
  - The customer should be able to:
    - Rent movies
    - See What movies they are currently renting and how much time is left until they need to return it.
    - See a history of the movies they have rented.
  - The employee should be able to:
    - Add a new user
    - Add a new employee
    - Add new movies to be rented
    - Mark movies as rented
    - Mark movies as returned

User Guide

When the page is first opened, you are greeted by a home page that shows the most popular movies (aggregated from the number of rentals done in the previous year), Recently Added and recently returned. Each of these can be cycled through giving different movies to the user to look through. Each box shows the movie’s title and description to the user.

At the nav bar, the user is giving a number of options. There is the home page, which can be accessed from any page on the website. There is the ‘About’ page that allows the user to read a short description of the history of the company as well as a large image of the ‘Press Play Video Store’ Bee mascott. Next, is the log in page.

The login page allows the user to sign whether they are a customer or an employee, leading each type to a different page. If signing in as a customer, the customer is lead to a page that allows them to see their past history of rentals as well as any rentals they current have and how long until they need to return it.

The employee after logging in is sent to the employee page that gives the employee various buttons to allow for the creation of new employee and customer users. As well as add or remove movies as well as marking movies as rented or returned.

At the very right of the nav bar is a search bar that allows movies to be searched for, whether by title, actor or genre. Once searched, the user is sent to the results page that shows all the movies that qualify for the search (with partial searches allowed). If a movie is already rented, i.e. out of stock, then it will deemed to be so in the results page. This page also allows the user to rent particular movies, with the user sent to the log in page if they are not already logged in. In the result page, the user can also filter the results even further with additional filtering of actor, genre or title. (this filtering will take into account the initial search, filtering the results further)

# Running using Docker and Docker-Compose
This is a dockerized version and it was tested on Kali (Debian) Linux.

This version will create the MySQL database server, phpMyAdmin (to manage the server) and SpartaGlobal VHSWebsite App.

You only need to install Docker and Docker-Compose and run the following commands

1.  Clone the repository

```bash
git clone https://github.com/oabuoun/SpartaGlobal_VHSWebsite.git
cd SpartaGlobal_VHSWebsite
```

2.  Add your SQL files (if you want to initialise the database) under the folder `init-sql`.

***Don't delete the 00-grant-access.sql***

3.  If you are using a username other than `root` to access the database, edit `00-grant-access.sql` and change `root` to `YOUR_MYSQL_SERVER_USERNAME`

4.  Create a file `application.properties` in `SpartaGlobal_VHSWebsite` as follows:
```
spring.datasource.url=jdbc:mysql://mysql_dbms:3306/sakila
spring.datasource.username=YOUR_MYSQL_SERVER_USERNAME
spring.datasource.password=YOUR_MYSQL_SERVER_PASSWORD
spring.jpa.hibernate.ddl-auto= update
spring.jpa.show-sql= true
```
Change the parameters (in capitals letters) to match your installation settings

5.  Create a file `.mysql_password` in `SpartaGlobal_VHSWebsite` as follows:

```
YOUR_MYSQL_SERVER_PASSWORD
```
***Don't add any newline at the end of the password***

6.  Run the following commands to start the
```bash
./launch.sh
```

7.  Open your browser and navigate to `http://localhost:8080`

8.  To show the logs:
```bash
docker-compose logs -f
```

9.  To stop all containers:
```bash
./stop.sh
```

10.  To destroy the installation (including the data in the database and all settings):
```bash
./destroy.sh
```

11.  Enjoy !
