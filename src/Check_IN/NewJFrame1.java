/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Check_IN;

import LogIn.MessageDialog;
import combo_suggestion.ComboBoxSuggestion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import textfield.TextField;
/**
 *
 * @author ZBOOK
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    int num;
    public NewJFrame1(int number) {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setSize(445, 380);
        num = number;
        init();
    }
    private void init() {
        NameTextField.setLabelText("Name");
        PhoneTextField.setLabelText("Phone Number");
        
        SaveButton.setFocusable(false);
        SaveButton.setBackground(new Color(215, 209, 209));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(MaleRadioButton);
        buttonGroup.add(FemaleRadioButton);  
        
        
        String[] countries = Locale.getISOCountries();
        NationalityComboBox.addItem("Nationality");
        for (int i = 0; i < countries.length; i++) {
            Locale locale = new Locale("", countries[i]);
            NationalityComboBox.addItem(locale.getDisplayCountry());
        }
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveButton = new javax.swing.JButton();
        NationalityComboBox = new combo_suggestion.ComboBoxSuggestion();
        MaleRadioButton = new radio_button.RadioButtonCustom();
        FemaleRadioButton = new radio_button.RadioButtonCustom();
        NameTextField = new textfield.TextField();
        PhoneTextField = new textfield.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        MaleRadioButton.setText("Male");

        FemaleRadioButton.setText("Female");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(NationalityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FemaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NationalityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FemaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(SaveButton)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        TextField tx[] = {NameTextField, PhoneTextField};
        ComboBoxSuggestion combSug[] = {NationalityComboBox};
        int i = 0;
        for(; i < tx.length; i++) {
            if(tx[i].getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);
                tx[i].setLineColor(Color.red);
                tx[i].requestFocus();
                break;
            }
            else {
                tx[i].setLineColor(new Color(3, 155, 216));
            }
            if(i == tx.length - 1) {
                if(!(MaleRadioButton.isSelected() || FemaleRadioButton.isSelected())) {
                    JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                else if(combSug[0].getSelectedItem() == "Nationality") {
                    JOptionPane.showMessageDialog(this, "Fill in Nationality", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }

            }
        }
        if(i == tx.length) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");

                // Get ClientID From Client table
                PreparedStatement pst = conn.prepareStatement("SELECT MAX(ClientID) AS LastClientID FROM Client");

                ResultSet rs = pst.executeQuery();
                int clientId = 0;
                if(rs.next()) {
                    clientId = rs.getInt("LastClientID");
                }
                // insert into client table
                PreparedStatement pstCompanion = conn.prepareStatement("INSERT INTO Companion (ClientID, Nationality, Phone, Name, Gender) VALUES (?, ?, ?, ?, ?)");
                pstCompanion.setInt(1, clientId);
                pstCompanion.setString(2, (String) NationalityComboBox.getSelectedItem());
                pstCompanion.setString(3, PhoneTextField.getText());
                pstCompanion.setString(4, NameTextField.getText());
                if(MaleRadioButton.isSelected())
                pstCompanion.setBoolean(5, true);
                else if(FemaleRadioButton.isSelected())
                pstCompanion.setBoolean(5, false);

                pstCompanion.executeUpdate();

                new MessageDialog("Saved", this).setVisible(true);
                NameTextField.setText("");
                PhoneTextField.setText("");
                NationalityComboBox.setSelectedIndex(0);
                MaleRadioButton.setSelected(false);
                FemaleRadioButton.setSelected(false);
                num--;
                if(num == 0) {
                    this.setVisible(false);
                }

            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private radio_button.RadioButtonCustom FemaleRadioButton;
    private radio_button.RadioButtonCustom MaleRadioButton;
    private textfield.TextField NameTextField;
    private combo_suggestion.ComboBoxSuggestion NationalityComboBox;
    private textfield.TextField PhoneTextField;
    private javax.swing.JButton SaveButton;
    // End of variables declaration//GEN-END:variables
}
