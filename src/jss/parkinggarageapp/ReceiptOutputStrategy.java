package jss.parkinggarageapp;

import java.util.*;

/**
 * ReceiptConsoleOutputStrategy interface is used for flexibility to create multiple
 * ways to output the car fees and daily totals for the garage program.
 *
 * @author Jamie Studzinski
 * @version 1.2
 */
public interface ReceiptOutputStrategy {

    /**
     * displayCarFee is used to display the total fees and hours for a particular car
     * based on the vehicleID passed in. Each class that implements this strategy
     * must override this method.
     * 
     * @param receipt An instance of the receipt object being passed in
     * @param vehicleID A String containing a unique ID referencing a vehicle
     * @throws IllegalArgumentException Receipt cannot be null, Vehicle cannot be null, vehicleID has to be 4 characters long
     */
    void displayCarFee(Receipt receipt, String vehicleID);

     /**
     * displayDailyTotal is used to the display the total hours and total fees 
     * for the day for the Garage. Each class that implements this strategy
     * must override this method.
     * 
     * @param receipt An instance of the receipt object being passed in
     * @param input A list of maps contain the total hours and fees for the day
     * @throws IllegalArgumentException Receipt and input cannot be null
     */
    void displayDailyTotal(Receipt receipt, List<LinkedHashMap<String, String>> input);
    
}
