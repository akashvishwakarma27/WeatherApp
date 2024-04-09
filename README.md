# WeatherApp

# Weather Forecast API with User Registration

## Description

This project is a simple Spring Boot application that provides APIs for user registration and weather forecast retrieval. Users can register with their name, email, and password, and then log in to receive a JWT token, and then users can retrieve weather forecasts for specific locations.

## Features

1. **User Registration**: Users can register by providing their name, email, and password.
2. **User Authentication**: After registration, users can log in to receive a JWT token.
3. **Weather Forecast Retrieval**: Users can retrieve weather forecasts for specific locations.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- RESTful APIs
- JSON Web Tokens (JWT)
- Spring Security
- BCryptPasswordEncoder
- OpenWeatherMap API

## Project Structure

- **MyUser**: Entity class representing user details.
- **UserRepository**: Interface extending JpaRepository for user CRUD operations.
- **UserService**: Interface defining user service methods.
- **UserServiceImpl**: Implementation of UserService.
- **WeatherService**: Interface providing methods to retrieve weather forecasts.
- **WeatherServiceImpl**: Implementation of WeatherService using OpenWeatherMap API.
- **GlobalExceptionHandler**: Controller advice handling exceptions globally.
- **UserController**: REST controller for user registration and login.
- **WeatherController**: REST controller for weather forecast retrieval.
- **Config**: Configuration class for Spring Security and CORS.
- **SecurityFilterChain**: Configuration for security filters.
- **Password Encoding**: BCryptPasswordEncoder used for password hashing.

## Usage

1. **User Registration**:

   - Endpoint: `POST /users/register`
   - Request body: JSON containing user details (name, email, password).
   - Response: Returns the registered user details.

2. **User Login**:

   - Endpoint: `GET /users/signin`
   - Request: Basic Authentication with email and password.
   - Response: Returns a JWT token upon successful login.

3. **Weather Forecast Retrieval**:
   - Endpoints:
     - `GET /Location/summary?city={city}`
     - `GET /Location/hourly?city={city}`
   - Parameters: `city` - The name of the city for which weather forecast is requested.
   - Response: Returns weather forecast data for the specified location.

## ScreenShot

## Home

![Home](https://github.com/akashvishwakarma27/WeatherApp/blob/main/WeatherApp/src/main/resources/static/home.png)

## Register New User

![Register](https://github.com/akashvishwakarma27/WeatherApp/blob/main/WeatherApp/src/main/resources/static/register.png)

## Location Summary

![Location Summary](https://github.com/akashvishwakarma27/WeatherApp/blob/main/WeatherApp/src/main/resources/static/summary.png)

## Location Hourly Data

![Location Hourly Data](https://github.com/akashvishwakarma27/WeatherApp/blob/main/WeatherApp/src/main/resources/static/hourly.png)

## Contact

For any inquiries or issues, please contact akashvish4masai@gmail.com.
