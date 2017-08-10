package jss.parkinggarageapp;

/**
* The Vehicle class is designed to uniquely give each vehicle it's on parking ticket
* from the ParkingTicket class. And it will also assign a Vehicle ID to each vehicle
* so you can tell them apart.
* 
* @author Jameson Studzinski
* @version 1.0
**/

public class Vehicle {
    private ParkingTicket ticket;
    private String vehicleID;

    /**Initializes a new instances of the Vehicle class. Requires the user to enter
     * in a parking ticket as well as a vehicle ID
     * 
     * @param ticket instance of the Ticket class  
     * @param vehicleID  4 character String representing the vehicle
     */
    public Vehicle(ParkingTicket ticket, String vehicleID) {
        setTicket(ticket);
        setVehicleID(vehicleID);
    }
    
    /**Gets the vehicleID for the instances of the class
     * 
     * @return vehicleID - 4 character String representing the vehicle
     */
    public final String getVehicleID() {
        return vehicleID;
    }

    /**Sets the vehicleID for the instances of the vehicle
     * 
     * @param vehicleID  4 character String representing the vehicle
     * @throws IllegalArgumentException if vehicleID is null, less than or equal
     *                                  to 3, or greater than equal to 5
     */
    public final void setVehicleID(String vehicleID) throws IllegalArgumentException{
        if(vehicleID == null || vehicleID.length() <= 3 || vehicleID.length() >= 5) {
            throw new IllegalArgumentException("Improper vehicle ID");
        }else {
            this.vehicleID = vehicleID;
        }
    }

    /**Gets the instances of the Parking Ticket assigned to the vehicle
     * 
     * @return ticket instances of the Parking Ticket
     */
    public ParkingTicket getTicket() {
        return ticket;
    }

    /**Set the ticket based on the ParkingTicket class
     * 
     * @param ticket ticket holds the amount of hours a car is parked
     * @throws IllegalArgumentException ticket cannot be null
     * @see ParkingTicket
     */
    public void setTicket(ParkingTicket ticket) throws IllegalArgumentException{
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        } else {
            this.ticket = ticket;
        }
    }

    /**Converts the vehicle class to a String
     * 
     * @return Vehicle.toString() Vehicle ID and Ticket Number for the vehicle
     */
    @Override
    public String toString() {
        return "Vehicle ID: " + this.vehicleID + " Ticket No: " + this.ticket.getTicketNumber();
    }

    /**Tests to see if the vehicleID of two instances of the Vehicle class are equal
     * 
     * 
     * @param obj object compared to the vehicle object
     * @return boolean true if obj is not null, getClass() is equal to obj.getClass()
     *                 and if vehicleID are not equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       final Vehicle other = (Vehicle) obj;
       if (!this.vehicleID.equals(other.getVehicleID())) {
           return false;
       }
        return true;
    }

    /**Computes a hash code for the vehicleID of the vehicle object
     * 
     * @return hash for vehicle object based on vehicleID
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.vehicleID.hashCode());
        return hash;
    }
    
}
