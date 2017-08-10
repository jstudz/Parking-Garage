package jss.parkinggarageapp;

import java.util.*;

/**
 * The receipt class is used to get the totals for each car as well as the total
 * for the garage. It uses a vehicle array to store each of the vehicles the
 * garage has in it for each given day. It will also run a method to calculate
 * the total for each car as far as hours and their total fee.
 *
 * @author Jamie Studzinski
 */
public class Receipt {

    private Vehicle[] vehicles = new Vehicle[0];
    private Garage garage;
    private double dailyTotal;
    private double totalHours;
    private int transactionNum;

   /**
    * Overrides the default constructor requiring a Garage object to be passed in
    * @param garage An instance of the Garage class
    */
    public Receipt(Garage garage) {
        setGarage(garage);
    }

    /**
     * restForNewDay sets all values to zero
     */
    public final void resetForNewDay() {
        Vehicle[] vehicles = new Vehicle[0];
        dailyTotal = 0;
    }

    /**
     * addVehicleToArray is used to add the vehicle information to an array for later use
     * in the program
     * 
     * @param vehicleID A string containing a unique ID for the Vehicle
     * @param hours Double containing the total hours the vehicle was parked
     * @param ticketNum A unique integer referencing the ticket number
     * @throws IllegalArgumentException VehicleID cannot be null, VehicleID must be 4 characters long, hours must be between 1 and 24
     */
    public final void addVehicleToArray(String vehicleID, double hours, int ticketNum) throws IllegalArgumentException {
        if (vehicleID == null || vehicleID.length() <= 3 || vehicleID.length() >= 5 || hours <= 0 || hours > 24) {
            throw new IllegalArgumentException("vehicleID cannot be null and must be 4 characters long. Hours cannot be less"
                    + " than or equal to zero and must be less than 24.");
        } else {

            Vehicle veh = new Vehicle(new ParkingTicket(hours, ticketNum), vehicleID);

            Vehicle[] tempVehList = new Vehicle[1 + vehicles.length];

            System.arraycopy(vehicles, 0, tempVehList, 0, vehicles.length);

            tempVehList[vehicles.length] = veh;
            vehicles = tempVehList;
        }

    }

    /**
     * calculateTotalFee is used to calculate the total amount due by the vehicle
     * based off the vehicleID passed in
     * 
     * @param vehicleID A String containing a unique ID for the Vehicle
     * @return A double containing the fee due by the vehicle
     * @throws IllegalArgumentException VehicleID cannot be null and must 4 characters long
     */
    public final double calculateTotalFee(String vehicleID) throws IllegalArgumentException {
        if (vehicleID == null || vehicleID.length() <= 3 || vehicleID.length() >= 5) {
            throw new IllegalArgumentException("vehicleID cannot be null and must be 4 characters long.");
        } else {
            double totalFee = 0;

            Vehicle vehicle = null;

            for (Vehicle v : vehicles) {
                if (vehicleID.equals(v.getVehicleID())) {
                    vehicle = v;
                    break;
                }

            }

            totalFee = garage.getFeeCalculator().calculateFee(vehicle.getTicket().getHours());

            if (vehicle.getTicket().getHours() > 24) {
                return totalFee;
            } else {
                return totalFee;
            }
        }

    }

    /**
     * getDailyTotal runs through the list and adds up the total Fees and returns
     * the daily total
     * 
     * @param input A list of maps containing all hours and fees for the day for the garage
     * @return A double containing the total amount earned by the Garage object
     */
    public final double getDailyTotal(List<LinkedHashMap<String, String>> input) {
        dailyTotal = 0;

        for (Map m : input) {
            dailyTotal += Double.parseDouble(m.get("Fees").toString());
        }
        return dailyTotal;
    }

    /**
     * getTotalHours runs through the list and adds up the total hours and returns
     * the daily total
     * 
     * @param input A list of maps containing all hours and fees for the day for the garage
     * @return A double containing the total amount of hours the cars were parked at the garage
     */
    public final double getTotalHours(List<LinkedHashMap<String, String>> input) {
        totalHours = 0;

        for (Map m : input) {
            totalHours += Double.parseDouble(m.get("Hours").toString());

        }

        return totalHours;
    }

     /**
     * getVehiclesParkedHours uses the array of vehicles to get the hours the vehicle
     * was parked for the day
     * 
     * @param vehicleID
     * @return 
     */
    public final double getVehiclesParkedHours(String vehicleID) {
        double vehicleHours = 0;

        for (Vehicle v : vehicles) {
            if (vehicleID.equals(v.getVehicleID())) {
                vehicleHours = v.getTicket().getHours();
            }
        }

        return vehicleHours;
    }
    
    /**
     * Gets the array of the vehicles parked at the garage
     * 
     * @return An array of the vehicles
     */
    public final Vehicle[] getVehicles() {
        return vehicles;
    }

    /**
     * Sets the vehicle array for the vehicles parked at the garage
     * 
     * @param vehicles An array of vehicles
     * @throws IllegalArgumentException Vehicle array cannot be null
     */
    public final void setVehicles(Vehicle[] vehicles) throws IllegalArgumentException{
        if (vehicles == null) {
            throw new IllegalArgumentException("Vehicle array cannot be null");
        } else {
            this.vehicles = vehicles;
        }
    }

    /**
     * Gets the Garage object being used by the Receipt class
     * 
     * @return Instance of the Garage object
     */
    public final Garage getGarage() {
        return garage;
    }

   /**
    * Sets the Garage object for the Receipt class
    * 
    * @param garage An instance of the Garage object
    * @throws IllegalArgumentException Garage object cannot be null
    */
    public final void setGarage(Garage garage) throws IllegalArgumentException{
        if (garage == null) {
            throw new IllegalArgumentException("Garage cannot be null"); 
        } else {
            this.garage = garage;
        }
    }

    /**
     * Gets the transaction number for the Receipt class
     * 
     * @return An integer referencing the transaction number
     */
    public int getTransactionNum() {
        return transactionNum;
    }

    /**
     * Sets the transaction number for the Receipt class
     * 
     * @param transcationNum An integer referencing the transaction number
     * @throws IllegalArgumentException transaction number must be between 1 and 999,999
     */
    public void setTransactionNum(int transcationNum) throws IllegalArgumentException{
        if (transactionNum <= 0 || transactionNum >=1000000) {
            throw new IllegalArgumentException("Invalid input for transaction number");
        }
        this.transactionNum = transcationNum;
    }

    /**
     * Overrides the toString method, converts a Receipt object to a string
     * @return A string contain garage.toString and the transaction number
     */
    @Override
    public String toString() {
        return "Receipt for " + garage.getName() + " Transaction Number: " + this.transactionNum;
    }

    /**
     * Overrides the equal method, compares to Receipt objects based on the
     * transaction number on the receipt
     * 
     * @param obj A reference to a Receipt object being passed in to be compared
     * @return A boolean on whether the objects are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Receipt other = (Receipt) obj;
        if (this.transactionNum != (other.getTransactionNum())) {
            return false;
        }
        return true;
    }

    /**
     * Computes a hash code for the Transaction Number of the Receipt object
     *
     * @return hash for vehicle object based on vehicleID
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.transactionNum;
        return hash;
    }

}
