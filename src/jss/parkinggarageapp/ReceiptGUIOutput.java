package jss.parkinggarageapp;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * ReceiptGUIOutput class is used to display the fee for a car as well as
 * the total dailies for the garage using a GUI.
 *
 * @author Jamie Studzinski
 * @version 1.2
 */
public class ReceiptGUIOutput extends javax.swing.JFrame implements ReceiptOutputStrategy {

    /**
     * Creates new form OutputWindowGUI
     */
    public ReceiptGUIOutput() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOutput1 = new javax.swing.JLabel();
        lblOutput2 = new javax.swing.JLabel();
        lblOutput3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblOutput1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblOutput3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblOutput2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblOutput3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * displayCarFee is used to display the total fees and hours for a
     * particular car based on the vehicleID passed in
     *
     * @param receipt An instance of the receipt object being passed in
     * @param vehicleID A String containing a unique ID referencing a vehicle
     * @throws IllegalArgumentException Receipt cannot be null, Vehicle cannot
     * be null, vehicleID has to be 4 characters long
     */
    @Override
    public void displayCarFee(Receipt receipt, String vehicleID) {
        if (receipt == null || vehicleID == null || vehicleID.length() <= 3 || vehicleID.length() >= 5) {
            throw new IllegalArgumentException("Receipt object cannot be null, vehicleID cannot be null, and must contain 4 characters");
        } else {
            ReceiptGUIOutput output = new ReceiptGUIOutput();

            output.lblOutput1.setText("Thanks for using " + receipt.getGarage().getName());
            output.lblOutput2.setText(receipt.getGarage().getAddress());
            output.lblOutput3.setText("Receipt for Vehicle #" + vehicleID + " is: $"
                    + receipt.calculateTotalFee(vehicleID)
                    + " Hours Parked: " + receipt.getVehiclesParkedHours(vehicleID));

            output.setVisible(true);

            output.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    public void displayDailyTotal(Receipt receipt, List<LinkedHashMap<String, String>> input) {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt object cannot be null");
        } else {
            ReceiptGUIOutput output = new ReceiptGUIOutput();

            output.lblOutput1.setText("Total amount earned for " + receipt.getGarage().getName());
            output.lblOutput2.setText("Today is: $" + receipt.getDailyTotal(input));
            output.lblOutput3.setText("With a total of " + receipt.getTotalHours(input) + " hours.");

            output.setVisible(true);

            output.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblOutput1;
    private javax.swing.JLabel lblOutput2;
    private javax.swing.JLabel lblOutput3;
    // End of variables declaration//GEN-END:variables
}
