
package jss.parkinggarageapp;

/**
 * Best value fee calculator implements the FeeCalculatorStrategy class. This class
 * is used if there is a max charge for the Garage. 
 * 
 * @author Jamie Studzinski
 * @version 1.2
 */
public class BestValueFeeCalculator implements FeeCalculatorStrategy {
    private double baseFee;
    private double baseFeeHours;
    private double additionalFee;
    private double maxCharge;
    private String calcID;
  

    /**
     * Overrides the default constructor requiring for baseFee, baseFeeHours, additonalFee
     * maxCharage and calcID to be passed through
     * 
     * @param baseFee Double used for the initial fee of parking
     * @param baseFeeHours Double used for the amount of hours a car can be parked before additionalFee kicks in
     * @param additionalFee Double used as a per hour charged for parking in the garage after the baseeFeeHours has been reached
     * @param maxCharge Double that contains the max charge for a car parked
     * @param calcID Unique string identify the particular calculator
     */
    public BestValueFeeCalculator(double baseFee, double baseFeeHours, double additionalFee, double maxCharge, String calcID) {
        setBaseFee(baseFee);
        setBaseFeeHours(baseFeeHours);
        setAdditionalFee(additionalFee);
        setMaxCharge(maxCharge);
        setCalcID(calcID);
    }

    /**
     * calculateFee method is used to get the total fee due for the car based on the formula
     * If total hours is greater than base fee hours it will calculate additional charge; otherwise
     * if total hours is less than base fee hours it will return the base fee charge.
     * 
     * It will then check to see if the total fee is less than max charge, will return max charge if
     * it is greater.
     * 
     * @param totalHours Total amount of hours the car was parked
     * @return The total fee for the car
     */
    @Override
    public final double calculateFee(double totalHours) {
        double total = 0;
        
   
       if (totalHours > baseFeeHours) {
            total = baseFee * baseFeeHours + (Math.ceil(totalHours - baseFeeHours)) * additionalFee;
        }
        else {
            total = baseFee * Math.ceil(baseFeeHours);
        }
        if (total < maxCharge) {
            return total;
        }
        else {
            return maxCharge;
        }

    }
    
    /**
     * Gets the base fee for the Calculator class
     * 
     * @return Double containing the base fee
     */
    public final double getBaseFee() {
        return baseFee;
    }

  /**
   * Sets the base fee for the Calculator class
   * 
   * @param baseFee Double being used as the baseeFee for the calculator
   * @throws IllegalArgumentException  baseFee cannot be less than $1 or greater than $50
   */
    public final void setBaseFee(double baseFee) throws IllegalArgumentException{
        if (baseFee <= 0 || baseFee >= 50) {
            throw new IllegalArgumentException("Base Fee cannot be less than or equal to zero or greater than equal to 50.");
        } else {
            this.baseFee = baseFee;
        }
    }

    /**
     * Get the baseFeeHours for the Calculator class
     * 
     * @return The hours for the baseFeeHours 
     */
    public final double getBaseFeeHours() {
        return baseFeeHours;
    }

    /**
     * Sets the base fee hours for the calculator class
     * 
     * @param baseFeeHours Double being used as the base fee hours for the Calculator class
     * @throws IllegalArgumentException Base fee hours cannot be 0 or less and greater than or equal to 24
     */
    public final void setBaseFeeHours(double baseFeeHours) throws IllegalArgumentException{
         if (baseFeeHours <=0 || baseFeeHours >=24) {
            throw new IllegalArgumentException("Base fee hours cannot be less than or equal to 0 or greater than or equal to 24.");
        } else {
            this.baseFeeHours = baseFeeHours;
        }
    }

    /**
     * Gets the additional fee per hour for the Calculator class
     * 
     * @return Double contain the additionalFee
     */
    public final double getAdditionalFee() {
        return additionalFee;
    }

    /**
     * Sets the additional fee for the Calculator class
     * 
     * @param additionalFee Double contain the additionalFee per hour
     * @throws IllegalArgumentException additionalFee cannot be less than or equal to 0 and greater than or equal to 10
     */
    public final void setAdditionalFee(double additionalFee) throws IllegalArgumentException{
         if (additionalFee <= 0 || additionalFee >=10) {
            throw new IllegalArgumentException("Additional Fee cannot be equal to or less than 0 or greater than or equal to 10.");
        } else {
            this.additionalFee = additionalFee;
        }
    }

    /**
     * Get the max charge for the Calculator class
     * 
     * @return Double containing the max charge
     */
    public final double getMaxCharge() {
        return maxCharge;
    }

    /**
     * Sets the max charge for the Calculator class
     * 
     * @param maxCharge Double containing the amount of the max charge
     * @throws IllegalArgumentException Max charge cannot be less than or equal to 0 and greater than or equal to 100
     */
    public final void setMaxCharge(double maxCharge) throws IllegalArgumentException{
        if (maxCharge <= 0 || maxCharge >= 100) {
            throw new IllegalArgumentException("Max Charge cannot be less than or equal to 0 or 100");
        }else {
            this.maxCharge = maxCharge;
        }
    }
    
    /**
     * Gets the unique ID for the Calculator class
     * 
     * @return A string containing a unique ID 
     */
    public String getCalcID() {
        return calcID;
    }

    /**
     * Sets the unique ID for the Calculator class
     * 
     * @param calcID A string containing a unique ID
     * @throws IllegalArgumentException String must be 5 characters long
     */
    public void setCalcID(String calcID) throws IllegalArgumentException{
        if(calcID == null || calcID.length() < 5 || calcID.length() > 5) {
            throw new IllegalArgumentException("Calcuator ID cannot be null and must be 5 characters long");
        } else {
            this.calcID = calcID;
        }
    }
    
    /**
     * Overrides the toString method 
     * 
     * @return "Best Value Fee Calculator" designating which Calculator is being used
     */
    @Override
    public String toString() {
        return "Bast Value Fee Calculator";
    }

     /**
     * Overrides the equals method and compares the calcID for the two objects to see
     * if they are equal
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
       final BestValueFeeCalculator other = (BestValueFeeCalculator) obj;
       if (!this.calcID.equals(other.getCalcID())) {
           return false;
       }        
       return true;
    }

    /**
    * Overrides the hashCode method and uses the calcID hash code to find equality
    * 
    * @return Returns the hash code to be used
    */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.calcID.hashCode());
        return hash;
    }
}
