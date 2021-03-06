package jss.parkinggarageapp;

import java.util.*;

/**
 * ReceiptConsoleOutput class is used to display the fee for a car as well as the
 * total dailies for the garage on the console log.
 * 
 * @author Jamie Studzinski
 * @version 1.2
 */
public class ReceiptConsoleOutput implements ReceiptOutputStrategy {
    
    /**
     * displayCarFee is used to display the total fees and hours for a particular car
     * based on the vehicleID passed in
     * 
     * @param receipt An instance of the receipt object being passed in
     * @param vehicleID A String containing a unique ID referencing a vehicle
     * @throws IllegalArgumentException Receipt cannot be null, Vehicle cannot be null, vehicleID has to be 4 characters long
     */
    @Override
    public final void displayCarFee(Receipt receipt, String vehicleID) throws IllegalArgumentException{
        if(receipt == null || vehicleID == null || vehicleID.length() <= 3 || vehicleID.length() >= 5) {
            throw new IllegalArgumentException("Receipt object cannot be null, vehicleID cannot be null, and must contain 4 characters");
        } else {
            System.out.println("Thanks for using " + receipt.getGarage().getName());
            System.out.println(receipt.getGarage().getAddress());
            System.out.println("Receipt for Vehicle #" + vehicleID + " is: $" + receipt.calculateTotalFee(vehicleID) + 
                    " Hours Parked: " + receipt.getVehiclesParkedHours(vehicleID));
            System.out.println();
        }
        
    }
    
    /**
     * displayDailyTotal is used to the display the total hours and total fees 
     * for the day for the Garage.
     * 
     * @param receipt An instance of the receipt object being passed in
     * @param input A list of maps contain the total hours and fees for the day
     * @throws IllegalArgumentException Receipt and input cannot be null
     */
    @Override
    public final void displayDailyTotal(Receipt receipt, List<LinkedHashMap<String, String>> input) throws IllegalArgumentException{
        if(receipt == null || input == null) {
            throw new IllegalArgumentException("Receipt object cannot be null");
        } else {
            System.out.println("Total amount earned for " + receipt.getGarage().getName() + " today is: $" + 
                    receipt.getDailyTotal(input) +
                    ", with a total of " + receipt.getTotalHours(input)+ " hours.");
        }
    }
    
    
}
