# Module 2 Review - BarterTown

BarterTown is a community bartering application that allows users to send and recieve.  To keep trades fair BarterTown works with a system of credits.  A user can always send an item, but must have at least 1 credit to recieve one.  Each item sent increases the users
Barter Credits by 1 and each item recieved reduces their credits by 1.  

## Use cases

### Required use cases

You should attempt to complete all of the following required use cases.

1. **[COMPLETE]** As a user of the system, I need to be able to register myself with a username and password.
   1. A new registered user starts with 10 initial barter credits.
   2. The ability to register has been provided in your starter code.
2. **[COMPLETE]** As a user of the system, I need to be able to log in using my registered username and password.
   1. Logging in returns an Authentication Token. I need to include this token with all my subsequent interactions with the system outside of registering and logging in.
   2. The ability to log in has been provided in your starter code.
3. As an authenticated user of the system, I need to see my remaining barter credits on the main menu.
4. As an authenticated user of the system, I need to be able to *send* an item a another registered user.
   1. I should be able to choose from a list of users who I can send an item to.
   2. I must not be allowed to send an item to myself.
   3. A transfer includes the User IDs of the from and to users and the item.
   4. The receiver's barter credits are reduced by 1.
   5. The sender's barter credits are increased by 1.
   6. I can't send an item to a user than has 0 barter credits remaining and should not be shown as an available user.
   7. I can't send an item that is just blank text.
   8. For version 1 the offer will have an initial status of *Accepted*.
5. As an authenticated user of the system, I need to be able to see a list of items I have recieved.
6. As an authenticated user of the system, I need to be able to see a history of items I have sent or received.

## Sample screens


### Use case 4: Send Item
```
-------------------------------------------
Users who can recieve items
-------------------------------------------
1) Bernice
2) Larry

Select the user to send an item to (0 to cancel):
Enter the name of the item:
```

### Use case 6: View Items Recieved
```

Items Recieved
From         Status      Item             
-------------------------------------------
Larry        Accepted    Clean Code

```


### Use case 6: View Barter History
```
-------------------------------------------------------
Items Sent
ID          To          Status       Item
-------------------------------------------------------
3002        Bernice     Accepted      Head First Java

Items Recieved
ID          From         Status       Item
-------------------------------------------------------
3003        Larry        Accepted      Clean Code

```

## How to set up the database

Create a new Postgres database called `bartertown`. Run the `database/bartertown.sql` script in pgAdmin to set up the database.

### Datasource

A Datasource has been configured for you in `/src/resources/application.properties`.

```
# datasource connection properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bartertown
spring.datasource.name=bartertown
spring.datasource.username=postgres
spring.datasource.password=postgres1
```

### JdbcTemplate

If you look in `/src/main/java/com/techelevator/dao`, you'll see `JdbcUserDao`. This is an example of how to get an instance of `JdbcTemplate` in your DAOs. If you declare a field of type `JdbcTemplate` and add it as an argument to the constructor, Spring automatically injects an instance for you:

```java
@Service
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
```

## Testing


### DAO integration tests

`com.techelevator.dao.BaseDaoTests` has been provided for you to use as a base class for any DAO integration test. It initializes a Datasource for testing and manages rollback of database changes between tests.

`com.techelevator.dao.JdbUserDaoTests` has been provided for you as an example for writing your own DAO integration tests.

Remember that when testing, you're using a copy of the real database. The schema and data for the test database are defined in `/src/test/resources/test-data.sql`. The schema in this file matches the schema defined in `database/bartertown.sql`.


## Authentication

The user registration and authentication functionality for the system has already been implemented. If you review the login code, you'll notice that after successful authentication, an instance of `AuthenticatedUser` is stored in the `currentUser` member variable of `App`. The user's authorization token—meaning JWT—can be accessed from `App` as `currentUser.getToken()`.

When the use cases refer to an "authenticated user", this means a request that includes the token as a header. You can also reference other information about the current user by using the `User` object retrieved from `currentUser.getUser()`.
