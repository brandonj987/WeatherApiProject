# WeatherApiProject
This project is a testing framework to test the Open Weather Map API. The framework is only focused on the Current Weather section of the Api

## About
Main points of the project are:
- **The API used: https://openweathermap.org/current**
- **The framework will be made using JUnit and Jackson.**
- **Agile Framework: Scrum**

## The Team
- **Brandon Johnson - Test Team**
- **Autumn Peles- Test Team**
- **Ben Wong - Development Team**
- **Antony Ademefun - Development Team**
- **Natasha Reilly - Scrum Master**

## Project Architecture
This project will follow a Service Object Model:
DTO: Classes that represent the different types of responses that can be called.
ConnectionManager: A class which handles the connection to the live system and collecting the response.
Injector: A class responsible for injecting the JSON response into a weather DTO.
