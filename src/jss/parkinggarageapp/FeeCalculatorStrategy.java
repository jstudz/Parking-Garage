
package jss.parkinggarageapp;

/**
 * FeeCalculatorStrategy is an interface used for flexibility purpose to add multiple
 * fee calculators into the program
 * 
 * @author Arthas
 * @version 1.2
 */
public interface FeeCalculatorStrategy {

    /**
     * calculateFee must be overrode in all classes that implement the FeeCalculatorStrategy
     * 
     * @param totalHours Double of the total hours the vehicle was parked
     * @return Double containing the total fee due for the vehicle
     */
    double calculateFee(double totalHours);
    
}
