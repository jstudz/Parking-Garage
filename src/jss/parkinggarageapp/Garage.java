package jss.parkinggarageapp;

/**
 * Garage class is where the AutomatedTeller and FeeCalculatorStrategy are stored.
 * 
 * @author Jamie Studzinski
 * @version 1.2
 */
public class Garage {
    private Vehicle vehicle;
    private FeeCalculatorStrategy feeCalculator;
    private AutomatedTeller atm;
    private String name;
    private String address;

    /**
     * Overrides the default constructor requiring a FeeCalculatorStrategy, string 
     * containing a name, and a string contain an address being passed in
     * 
     * @param feeCalculator FeeCalculatorStrategy this particular garage object uses
     * @param name A string containing the name of the Garage object
     * @param address A string containing the address of the Garage object
     */
    public Garage(FeeCalculatorStrategy feeCalculator, String name, String address) {
        setFeeCalculator(feeCalculator);
        setName(name);
        setAddress(address);
    }

    /**
     * Get the Fee Calculator being used by the Garage object
     * 
     * @return Fee Calculator for this Garage Object
     */
    public final FeeCalculatorStrategy getFeeCalculator() {
        return feeCalculator;
    }

    /**
     * Sets the Fee Calculator for the Garage object
     * 
     * @param feeCalculator FeeCalculatorStrategy being passed through
     * @throws IllegalArgumentException Fee Calculator object cannot be null
     */
    public final void setFeeCalculator(FeeCalculatorStrategy feeCalculator) throws IllegalArgumentException{
        if (feeCalculator == null) {
            throw new IllegalArgumentException("Fee Calculator cannot be null");
        } else {
            this.feeCalculator = feeCalculator;
        }
    }

    /**
     * Gets the name of the Garage object
     * 
     * @return A string containing the name of the Garage object
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name of the Garage object
     * 
     * @param name A string containing the name
     * @throws IllegalArgumentException name has to be greater than 2 and less than 50 characters long
     */
    public final void setName(String name) throws IllegalArgumentException{
        if (name == null || name.length() < 2 || name.length() > 50) {
            throw new IllegalArgumentException("Name cannot be null, less than 2 or greater than 50");
        } else {
            this.name = name;
        }
    }

    /**
     * Gets the address of the Garage object
     * 
     * @return A string containing the address of the Garage object
     */
    public final String getAddress() {
        return address;
    }

    /**
     * Sets the address of the Garage object
     * 
     * @param address A string containing the address 
     * @throws IllegalArgumentException address must be greater than 10 and less 250 characters long
     */
    public final void setAddress(String address) throws IllegalArgumentException{
        if(address == null || address.length() < 10 || address.length() > 250) {
            throw new IllegalArgumentException("Address cannot be null, less than zero or greater than 250");
        } else {
            this.address = address;
        }
    }

    /**
     * Gets a vehicle object that is parked at the Garage
     * 
     * @return Instance of the Vehicle class 
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets an instance of the vehicle object
     * 
     * @param vehicle Instance of a vehicle object
     * @throws IllegalArgumentException Vehicle cannot be null
     */
    public void setVehicle(Vehicle vehicle) throws IllegalArgumentException{
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        } else {
            this.vehicle = vehicle;
        }
    }

    /**
     * Gets an AutomatedTeller object that the Garage uses
     * 
     * @return Instance of the AutomatedTeller object
     */
    public AutomatedTeller getAtm() {
        return atm;
    }

    
    /**
     * Sets an instance of the AutomatedTeller object
     * 
     * @param atm Instance of the AutomatedTeller object
     * @throws IllegalArgumentException ATM cannot be null
     */
    public void setAtm(AutomatedTeller atm) throws IllegalArgumentException{
        if (atm == null) {
            throw new IllegalArgumentException("ATM cannot be null");
        } else {
            this.atm = atm;
        }
    }

    /**
     * Overrides the toString method, converts Garage to a string
     * 
     * @return Garage name and Garage address
     */
    @Override
    public String toString() {
        return "Garage Name: " + this.name + " Garage address: " + this.address;
    }

    /**
     * Overrides the equal method, checks to see if two Garage objects are equal based
     * on the name of the Garage
     * 
     * @param obj Instance of the Garage object to be compared
     * @return A boolean based on whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       final Garage other = (Garage) obj;
       if (!this.name.equals(other.getName())) {
           return false;
       }
       return true;
    }

    /**
     * Overrides the hashCode method, uses the hash code for the Garage name
     * to check equality of two objects
     * 
     * @return Integer of the hash code
     */
    @Override
    public int hashCode() {
       int hash = 3;
       hash = 53 * hash + (this.name.hashCode());
       return hash;
    }

}
