package com.Converter;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TemperatureConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            try {
                // Ask the user to enter the temperature value
                System.out.print("Enter the temperature value: ");
                double temperature = scanner.nextDouble();

                // Ask the user to choose the type of conversion
                System.out.print("Enter 'F' to convert from Fahrenheit to Celsius or 'C' to convert from Celsius to Fahrenheit: ");
                char conversionType = scanner.next().charAt(0);

            
                if (conversionType == 'F' || conversionType == 'f') {
                    double celsius = TempratureConverter.fahrenheitToCelsius(temperature); // Call method from conversion class
                    System.out.println("The temperature " + temperature + " Fahrenheit is equal to " + celsius + " Celsius.");
                } else if (conversionType == 'C' || conversionType == 'c') {
                    double fahrenheit = TempratureConverter.celsiusToFahrenheit(temperature); // Call method from conversion class
                    System.out.println("The temperature " + temperature + " Celsius is equal to " + fahrenheit + " Fahrenheit.");
                } else {
                    System.out.println("Invalid input. Please enter 'F' or 'C'.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the temperature.");
                scanner.next(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            // Ask the user if they want to continue
            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Do you want to continue? (yes/no): ");
                String userResponse = scanner.next().toLowerCase();
                if (userResponse.equals("yes")) {
                    validResponse = true;
                } else if (userResponse.equals("no")) {
                    continueConversion = false;
                    validResponse = true;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }


        // Close the scanner
        scanner.close();
        System.out.println("Program End.");
    }
}
