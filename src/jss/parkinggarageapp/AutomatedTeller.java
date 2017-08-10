package jss.parkinggarageapp;

import java.util.*;

/**
 * AutomatedTeller class is used to take in the vehicle information as well as output
 * fees and totals for the garage program
 * 
 * @author Jamie Studzinski
 * @version 1.2
 */
public class AutomatedTeller {
    private Receipt receipt;
    private ReceiptOutputStrategy ros;
    private Garage garage;

    /**
     * Overrides the default constructor requiring a receipt, ReceiptOutputStrategy
     * and garage object to be passed in
     * 
     * @param receipt Instance of the Receipt class
     * @param ros Instance of the ReceiptOutputStrategy class
     * @param garage  Instance of the Garage class
     */
    public AutomatedTeller(Receipt receipt, ReceiptOutputStrategy ros, Garage garage) {
        setReceipt(receipt);
        setRos(ros);
        setGarage(garage);
    }
    
    
    /**
     * startNewDay method is used to clear all totals for the previous day and start
     * fresh
     * 
     * @param garage Instance of the Garage class
     * @throws IllegalArgumentException Garage object cannot be null
     */
    public final void startNewDay(Garage garage) throws IllegalArgumentException{
        if(garage == null) {
            throw new IllegalArgumentException("Garage object cannot be null");
        } else {
            receipt = new Receipt(garage);
            receipt.resetForNewDay();
        }
    }
    
    /**
     * parkNewVehicle method will add the vehicle to an array in the receipt class
     * 
     * @param vehicleID String contain a unique ID for the vehicle
     * @param hours Total number of hours the car was parked at the garage
     * @param ticketNum A unique number for the ticket
     * @throws IllegalArgumentException  VehicleID cannot be null, Hours has to be between 1 and 24
     */
    public final void parkNewVehicle(String vehicleID, double hours, int ticketNum) throws IllegalArgumentException{
       if (vehicleID == null || hours <= 0 || hours > 24) {
           throw new IllegalArgumentException("vehicleID cannot be null, hours has to be greater than zero or less than 24");
       } else {
           receipt.addVehicleToArray(vehicleID, hours, ticketNum);
       }
    }
    
    /**
     * outputFee uses the vehicleID to gather the total hours and fees for the particular
     * vehicle
     * 
     * @param vehicleID String containing a unique ID for the vehicle
     * @throws IllegalArgumentException VehicleID cannot be null
     */
    public final void outputFee(String vehicleID) throws IllegalArgumentException{
        if(vehicleID == null) {
            throw new IllegalArgumentException("vehicleID cannot be null");
        } else {
            ros.displayCarFee(receipt, vehicleID);
        }
    }
    
    /**
     * outputDailyTotal will gather the hours and fees for all vehicles parked 
     * and calculate the total hours and total fees for the day
     * 
     * @param input List of maps containing the hours and fees of all vehicles
     */
    public final void outputDailyTotal(List<LinkedHashMap<String, String>> input) {
        ros.displayDailyTotal(receipt, input);
    }

    /**
     * Gets the particular instance of the receipt object used
     * 
     * @return The instance of the receipt class
     *
     */
    public final Receipt getReceipt() {
        return receipt;
    }

    /**
     * Sets the receipt object for this class
     * 
     * @param receipt Receipt object being passed through
     * @throws IllegalArgumentException Receipt object cannot be null
     */
    public final void setReceipt(Receipt receipt) throws IllegalArgumentException{
        if(receipt == null) {
            throw new IllegalArgumentException("Receipt object cannot be null");
        } else {
            this.receipt = receipt;
        }
    }

    /**
     * Gets the particular instance of the ReceiptOutputStrategy object being used
     * 
     * @return The instance of the ReceiptOutputStrategy being used
     */
    public final ReceiptOutputStrategy getRos() {
        return ros;
    }

    /**
     * Sets the ReceiptOutputStrategy object for this class
     * 
     * @param ros ReceiptOutputStrategy object being passed through
     * @throws IllegalArgumentException ReceiptOutputStrategy cannot be null
     */
    public final void setRos(ReceiptOutputStrategy ros) throws IllegalArgumentException{
        if(ros == null) {
            throw new IllegalArgumentException("ReceiptOuputStrategy cannot be null");
        } else {
            this.ros = ros;
        }
    }

    /**
     * Gets the particular instance of the Garage object being used
     * 
     * @return The instance of the Garage object being used
     */
    public Garage getGarage() {
        return garage;
    }

    
    /**
     * Sets the Garage object for this class
     * 
     * @param garage Garage object being passed through
     * @throws IllegalArgumentException Garage object cannot be hull
     */
    public void setGarage(Garage garage) throws IllegalArgumentException{
        if(garage == null) {
            throw new IllegalArgumentException("Garage object cannot be null");
        } else {
            this.garage = garage;
        }
    }

    /**
     * Overrides the toString method 
     * 
     * @return String of the garage.toString and receipt.toString methods
     */
    @Override
    public String toString() {
        return " Garage: " + garage.toString() + " Receipt: " + receipt.toString(); 
    }
    
    /**
     * Overrides the equals method and compares the garage object for the 
     * AutomatedTeller to check if they are equal to each other
     * 
     * @param obj Instance of an object to be used as a comparison
     * @return A boolean whether they are equal or not
     */
    @Override
    public boolean equals(Object obj) {
       if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       final AutomatedTeller other = (AutomatedTeller) obj;
       if (!Objects.equals(this.garage, other.garage)) {
           return false;
       }
       return true;
    }

   /**
    * Overrides the hashCode method and uses the garage object to find equality
    * 
    * @return Returns the hash code to be used
    */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.garage.hashCode();
        return hash;
    }
    
    
    
}
