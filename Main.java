package com.mycompany.fk;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        /* Set the Nimbus look and feel for a modern UI look */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                 IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PANE1.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            PANE1 payrollSystem = new PANE1();

            // This command calculates the exact size needed based on your Design bounds 
            payrollSystem.pack(); 

            // This ensures the window opens in the center of the monitor
            payrollSystem.setLocationRelativeTo(null); 

            payrollSystem.setVisible(true);
        });
    }
}