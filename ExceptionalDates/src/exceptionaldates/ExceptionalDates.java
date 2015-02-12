/**
 * CIT 111 Intro to Programming 
 * Assignment 9 
 * 11/12/2014 
 * Author: Garrett Cooper
 * Exceptional Dates Program
 */

package exceptionaldates;

//  Imports Scanner and StringTokenizer classes from Java Utilities package.
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExceptionalDates {

    public static void main(String[] args) {

        // Creates 3 arrays that hold months as strings, and the maximum days...
        // for each month depending if it is a leap year (+1 days in Feb) or not.
        // Also note the use of parallel arrays for 'MONTH_NAMES' and 'MAX_MONTH_DAYS'
        // This will enable us to determine the maximum number of days for a given month..
        // for a leap year or non-leap year.
        final String[] MONTH_NAMES = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
        final int[] MAX_MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int[] MAX_MONTH_DAYS_LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Sets 'goodDate' to 'false' and is used in the inner 'do/while loop'.
        boolean goodDate = false;
        
        // Declares a string variable 'cont', which is used in the outer 'do/while loop'.
        String cont;

        // Declares and instantiates three string variables that will be used...
        // to hold the parsed string values for month, day, and year.
        String sMonth ="";
        String sDay = "";
        String sYear = "";
  
        // Declares and instantiates three integer variables that will be used...
        // to hold the parsed interger values, after they are converted from...
        // the above string integers. 
        int iMonth =0;
        int iDay = 0;
        int iYear = 0;
        
        // Prints out program header
        System.out.println("\nCIT111 Fall 2014, Assignment 9");
        System.out.println("Garrett Cooper");
        System.out.println("Exceptional Dates Program 1.4");   
   
    // Outer 'do/while loop' while keep the program running until the user opts out ("Yes/No").    
    do {
        // Declares variable 'console' using the scanner class.
        Scanner console = new Scanner(System.in);

        System.out.print("\nPlease enter a date in the format mm dd yyyy: ");
  
        // Delares inner 'do/while loop' that will keep running if an improper date...
        // is passed to the scanner.
        do {    
       
            // 'Try/Catch' statement, which tries to correctly parse the string...
            // passed to 'console'.
            try{
        
                // Calls the 'StringTokenizer' class and passes 'console' to 'token'.
                StringTokenizer token = new StringTokenizer(console.nextLine());

            // Declares 'count' to count number of string tokens in 'token'.
            int count = token.countTokens();

            // Assigns tokens 0-2 to 'sMonth', 'sDay' & 'sYear', respectively.
            if (count > 0) {
                sMonth = token.nextToken();
                if (count > 1) {
                    sDay = token.nextToken();
                    if (count > 2) {
                        sYear = token.nextToken();
                    }
                }
            }

        // Converts string variables (sMonth, sDay, & sYear) to integer variables.    
        iMonth = Integer.valueOf(sMonth);
        iDay = Integer.valueOf(sDay);
        iYear = Integer.valueOf(sYear);

            
            // Checks to make sure integer month value, 'iMonth' is 1-12 (months).
            // If not, it throws 'IllegalMonthException', which is caught below...
            if (iMonth < 1 || iMonth > 12 ) {
            throw new IllegalMonthException();
            }
            
            // Assigns 'maxDays' & 'maxDaysLeap' to the appropriate array element...
            // based on the month (i.e., 'iMonth') that has been passed to the array.
            // Note, we are able to do this becase we are using the parrallel arrays...
            // technique.
            int maxDays = MAX_MONTH_DAYS[iMonth - 1];
            int maxDaysLeap = MAX_MONTH_DAYS_LEAP[iMonth - 1];
            
            // Calls the 'isLeapYear' method; if 'true', then it is a leap year...
            // and we will use the 'maxDaysLeap' variable to look up the maximum...
            // possible dates for each month in a leap year.
            // If 'iDay' falls outside these constraints, then it throws...
            // 'IllegalDayException', which is caught below...
            if (isLeapYear(iYear)) {
                if (iDay < 1 || iDay > maxDaysLeap) {
                    throw new IllegalDayException();
                }
              // Same as above, only the 'maxDays' are for non-leap year, years.  
            } else {
                if (iDay < 1 || iDay > maxDays) {
                    throw new IllegalDayException();
                }

            }
            
            // Checks to make sure 3001 > 'iYear' > 999.
            // If not, it throws 'IllegalYearException', which is caught below...
            if (iYear < 1000 || iYear > 3000 ) {
            throw new IllegalYearException();
            } 
         
        // If no exceptions are thrown the program breaks out of the inner... 
        // 'do/while loop' and prints out the date.
         break; 
         
        }
         
        // Calls the catch for a bad month value and prints out that the user...
        // has entered an improper month value.    
            catch (IllegalMonthException ime) {
            System.out.println(ime.getMessage());
        }
        // Calls the catch for a bad day value and prints out that the user...
        // has entered an improper day value.    
            catch (IllegalDayException ide) {
            System.out.println(ide.getMessage());
        }
        // Calls the catch for a bad year value and prints out that the user...
        // has entered an improper year value.    
            catch (IllegalYearException iye) {
            System.out.println(iye.getMessage());
        }
        
        // Prompts the user to enter another date beforing begining the loop.
            System.out.print("\nPlease enter a date in the format mm dd yyyy: ");
        
    } while (!goodDate); // loops while 'goodDate' ! = 'false';
    
        // Prints out the correct date value in the MMMMM dd, yyyy format.
        System.out.println("The date you entered is " + MONTH_NAMES[iMonth-1] + 
               " "+ sDay + ", " + sYear);
   
        // Prompts the user to continue the program.
        System.out.print("\nDo you want to enter another date? ('Yes' or 'No'): ");
    
            // Holds 'Yes'/'No' input
            cont = console.next();  
    
    } while (cont.equalsIgnoreCase("yes")); // If 'cont' = 'Yes', the program ends.
        System.out.println("\nThank you for using the Exceptional Dates Program 1.4."
                + " Good bye.");
    }
    // Method that returns if it is a leap year or not
    public static boolean isLeapYear(int year) {
        // A leap year is evenly divided by 400 or (4, yet not 100)
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        }
            return false;
    }

}
