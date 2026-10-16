USER DETAILS PORTAL — SPRING TOOL SUITE (STS)
===============================================

Requirements
------------
- Java 21
- Spring Tool Suite (STS) with Maven support
- PostgreSQL installed and running

IMPORT INTO STS
---------------
1. Extract UserDetailsPortal.zip to a folder.
2. Open STS.
3. Choose File > Import.
4. Choose Maven > Existing Maven Projects > Next.
5. Browse to the extracted UserDetailsPortal folder.
6. Select the pom.xml project and click Finish.
7. Wait for Maven dependencies to download.

SET UP POSTGRESQL
-----------------
1. Open pgAdmin or psql.
2. Run: CREATE DATABASE userdb;
3. Connect to userdb and run the SQL in database/setup.sql, starting at CREATE TABLE.
   (Do not run CREATE DATABASE while connected to a transaction.)
4. Open src/main/resources/application.properties.
5. Set spring.datasource.username and spring.datasource.password to your local PostgreSQL credentials.
   Replace CHANGE_ME. Do not commit real credentials to a public repository.

RUN
---
1. In STS, right-click UserDetailsPortalApplication.java.
2. Choose Run As > Spring Boot App.
3. Check the STS Console for "Started UserDetailsPortalApplication".

TEST
----
By user ID:
GET http://localhost:8080/api/users/id/1

By username:
GET http://localhost:8080/api/users/username/prasanna

Example response:
{
  "userId": 1,
  "username": "prasanna",
  "email": "prasanna@example.com"
}

The API returns a DTO containing only userId, username, and email. It does not return password.
A missing user returns HTTP 404.

IMPORTANT SECURITY NOTES
------------------------
- This starter project does not include login/authentication or authorization.
- Do not expose user lookup endpoints publicly. Add authentication and role/ownership checks before production.
- Store password hashes (e.g. BCrypt), not plaintext passwords.
- Change the demo password value in your database setup to a valid hash if using a real authentication system.
- Never put actual database credentials in source control.
