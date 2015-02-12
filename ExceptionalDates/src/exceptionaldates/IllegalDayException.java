/**
 * CIT 111 Intro to Programming 
 * Assignment 9 
 * 11/12/2014 
 * Author: Garrett Cooper
 * Exceptional Dates Program -> IllegalDayException Class
 */


package exceptionaldates;
// Created exception for 'try/catch' functionality in Exceptional Dates program
// This particular exception extends NumberFormatException, and throws
// an exception for a bad day.
public class IllegalDayException extends NumberFormatException {

    public IllegalDayException() {
        super("The day value is incorrect. Please try again. ");
    }
    
}
    