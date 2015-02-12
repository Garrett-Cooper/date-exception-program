/**
 * CIT 111 Intro to Programming 
 * Assignment 9 
 * 11/12/2014 
 * Author: Garrett Cooper
 * Exceptional Dates Program -> IllegalMonthException Class
 */

package exceptionaldates;

// Created exception for 'try/catch' functionality in Exceptional Dates program
// This particular exception extends NumberFormatException, and throws
// an exception for a bad month.
public class IllegalMonthException extends NumberFormatException {

    public IllegalMonthException() {
        super("The month value is incorrect. Please try again. ");
    }
    
}
    