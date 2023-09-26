# Watchlist App

## Project Overview

The **Watchlist App** is a Java-based web application designed to help users manage their movie watchlists. It utilizes a technology stack comprising Java, Spring Boot, Spring MVC, Thymeleaf, and MySQL database. The app consists of four primary layers, and it allows users to add new movies, update and delete existing movies, and integrates with the IMDb API to fetch movie ratings. Additionally, it implements validation to ensure data integrity.

## Tech Stack

The Watchlist App leverages the following technologies:

- **Java:** The core programming language used for the project.
- **Spring Boot:** Provides a robust application framework, simplifying the development of Java applications.
- **Spring MVC:** Facilitates building web-based applications, handling HTTP requests, and managing the model-view-controller architecture.
- **Thymeleaf:** A templating engine used for rendering dynamic HTML pages.
- **MySQL:** A relational database management system used for storing movie and watchlist data.

## Project Structure

The Watchlist App adopts a layered architecture with the following critical layers:

1. **Presentation Layer:** This layer is responsible for user interactions and rendering web pages using Thymeleaf templates.

2. **Controller Layer:** Controllers handle incoming HTTP requests, process data, and send responses back to the client.

3. **Service Layer:** The service layer contains the business logic for managing movies and watchlists.

4. **Repository Layer:** This layer interacts with the MySQL database to perform CRUD (Create, Read, Update, Delete) operations on movie and watchlist data.

## Pages and Functionality

The Watchlist App includes four main pages, each with its own set of features:

1. **Add New Movie:**
   - Allows users to add new movies to their watchlist.
   - Captures movie details such as title, release year, and genre.

2. **Watchlist:**
   - Displays the user's watchlist, including all added movies.
   - Provides options to update and delete movies from the watchlist.

3. **IMDb API Integration:**
   - Integrates with the IMDb API to fetch movie ratings.
   - When a user adds or updates a movie, the app sends a request to the IMDb API with the movie title and retrieves the rating in response.
   - The retrieved rating is stored alongside other movie details in the database and displayed to the user.

## Validation

To ensure data accuracy and user-friendly interactions, the Watchlist App incorporates validation in several areas:

1. **Form Validation:**
   - Form validation is applied to fields like movie title, release year, and genre during movie addition or update.
   - Invalid input is detected, and appropriate error messages guide the user.

2. **API Response Validation:**
   - The application validates responses from the IMDb API to ensure they contain the expected data.
   - If the API response is incomplete or invalid, the app handles it gracefully with appropriate error handling.

3. **Database Constraints:**
   - The application enforces database constraints to maintain data consistency and integrity.
   - For example, unique constraints are applied to movie titles to prevent duplicate entries.


```bash
mvn clean install
mvn spring-boot:run
