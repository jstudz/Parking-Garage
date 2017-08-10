package jss.parkinggarageapp;

/**
 * Main class used to start up the Garage App
 * 
 * @author Jamie Studzinski
 * @version 1.0
 */
public class JSSParkingGarageApp {

    public static void main(String[] args){
   
        /**
         * Starts up the GUI
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindowGUI().setVisible(true);
            }
        });
        
   
    }
   
}
