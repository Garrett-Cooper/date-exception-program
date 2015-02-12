/**
 * CIT 111 Intro to Programming 
 * Assignment 9 
 * 11/12/2014 
 * Author: Garrett Cooper
 * Exceptional Dates Program -> IllegalYearException Class
 */


package exceptionaldates;

// Created exception for 'try/catch' functionality in Exceptional Dates program
// This particular exception extends NumberFormatException, and throws
// an exception for a bad year.
public class IllegalYearException extends NumberFormatException {

    public IllegalYearException() {
        super("The year value is incorrect. Only dates between 1000 "
                + "and 3000 are permitted. \nPlease try again. ");
    }
    
}
   
