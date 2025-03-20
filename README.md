World Currency Converter API

This project provides a RESTful API for currency conversion using Java, Spring Boot, and the FCS API to retrieve the latest conversion rates for world currencies.
Technologies Used

  Java: The core language for the application.
  Spring Boot: For building the RESTful API and handling the backend logic.
  FCS API: Provides real-time currency conversion rates.

Features

  Converts between multiple world currencies.
  Retrieves real-time exchange rates from the FCS API.
  API exposes endpoints for:
        Conversion between two currencies.

Getting Started

Prerequisites

Before you begin, ensure you have the following installed on your machine:

   Java 11 or later
   Maven 
   Spring Boot (automatically set up with the project)

Setup

  Clone the repository:

    git clone https://github.com/ecarmona235/UnitConverter/tree/main/WorldCurrencyConverter
    
    cd WorldCurrencyConverter

Install dependencies:

    mvn install

Configure your FCS API key:

  Go to FCS API to get your API key.
  
  Open the src/main/java/com/CurrencyConverter/WorldCurrencyConverter/Service/GetRates.java and set your API key:
  
    String key = "YOUR-API-KEY";

Running the Application

  Run the application using Maven:

    mvn spring-boot:run

  The application will start, and you can access the API at:

    http://localhost:8080

vailable Endpoints

  Convert Currency

        Endpoint: /?source=USD&target=EUR&total=200

    Method: GET

  Parameters:
       source: The source currency (e.g., USD).
       target: The target currency (e.g., EUR).
       total: The total to convert.

  Example Request:

    GET http://localhost:8080/?source=USD&target=EUR&total=100
    
