package jss.parkinggarageapp;

/**
 * ParkingTicket class is used to issue a vehicle a parking ticket containing a 
 * unique ticket number and the total hours the car is parked
 * 
 * @author Jamie Studzinski
 * @version 1.2
 */
public class ParkingTicket {
    private int ticketNumber;
    private double hours;

    /**
     * Overrides the default constructor requiring for the hours and ticket number
     * to be passed through
     * 
     * @param hours Double containing the hours for the car
     * @param ticketNum Integer containing a unique number referencing the ticket number
     */
    public ParkingTicket(double hours, int ticketNum) {
        setHours(hours);
        setTicketNumber(ticketNum);
    }

    /**
     * Gets the ticket number for the Ticket object
     * 
     * @return A unique integer referencing the ticket number
     */
    public final int getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the ticket number for the Ticket object
     * 
     * @param ticketNumber A unique integer referencing the ticket number
     * @throws IllegalArgumentException ticketNum cannot be less than 1
     */
    public final void setTicketNumber(int ticketNumber) throws IllegalArgumentException{
        if(ticketNumber <=0) {
           throw new IllegalArgumentException("Ticket Number cannot be less than 0");
        } else {
            this.ticketNumber = ticketNumber;
        }
    }

    /**
     * Gets the hours the Ticket object
     * 
     * @return A double containing the hours for the Ticket object
     */
    public final double getHours() {
        return hours;
    }

    /**
     * Sets the hours for the Ticket object
     * 
     * @param hours A double containing the hours for the Ticket object
     * @throws IllegalArgumentException hours cannot be less than 1 or greater than 24
     */
    public final void setHours(double hours) throws IllegalArgumentException
    {
        if (hours <=0 || hours >24) {
            throw new IllegalArgumentException("Hours cannot be null, less than 1 or greater than 24");
        }else {
            this.hours = hours;
        }
    }

    /**
     * Overrides the toString method, converts a Ticket object to a string
     * 
     * @return A string containing the ticket number and hours
     */
    @Override
    public String toString() {
        return "Ticket Number: " + this.ticketNumber + " Hours: " + this.hours;
    }

    /**
     * Overrides the equal method, compares two ticket objects and compares their
     * ticket number to check if they are equal
     * 
     * @param obj Instance of the ticket object to being compared
     * @return A boolean whether or not the two objects are equal or not
     */
    @Override
    public boolean equals(Object obj) {
         if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       
       final ParkingTicket other = (ParkingTicket) obj;
       if (other.getTicketNumber() != this.ticketNumber) {
           return false;
       }
       return true;
    }

    /**
     * Overrides the hashCode method, uses the ticket number integer to check
     * equality of the two objects
     * 
     * @return Integer containing the hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.ticketNumber;
        return hash;
    }
    
}
