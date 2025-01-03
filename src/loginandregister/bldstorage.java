package loginandregister;

import java.awt.Dimension;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import java.util.regex.*;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rucha
 */
public class bldstorage extends javax.swing.JFrame {
 PreparedStatement addChPS, fetChPS, searchChPS, modifyChPS, deleteChPS,searchChPS1;
    Connection con;
    ResultSet fetChRes, searchChRes,searchChRes1;

   
    public bldstorage() {
        
         /*  try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:3306/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }*/
        initComponents();
        //this.setAlwaysOnTop(false);
        this.setSize(500,450);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setTitle("Blood Bank Management System");
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
           

    }
    public void close()
     {
      WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
      Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        charges = new javax.swing.JTextField();
        bldtypcode = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(0);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(793, 443));
        setSize(new java.awt.Dimension(793, 443));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        jLabel5.setBackground(new java.awt.Color(51, 51, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("   BLOOD STORAGE DETAILS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 67);

        jPanel2.setBackground(new java.awt.Color(202, 242, 255));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Blood Type Code");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(79, 42, 127, 24);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(79, 128, 127, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(79, 209, 127, 22);

        quantity.setEditable(false);
        quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        jPanel2.add(quantity);
        quantity.setBounds(316, 128, 128, 23);

        charges.setEditable(false);
        charges.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(charges);
        charges.setBounds(316, 209, 128, 23);

        bldtypcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bldtypcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- SELECT---", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        bldtypcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bldtypcodeFocusLost(evt);
            }
        });
        bldtypcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bldtypcodeActionPerformed(evt);
            }
        });
        jPanel2.add(bldtypcode);
        bldtypcode.setBounds(316, 42, 128, 24);

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(457, 305, 95, 25);

        reset.setBackground(new java.awt.Color(204, 204, 204));
        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset);
        reset.setBounds(168, 305, 100, 25);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("(per litre bag)");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(454, 215, 80, 14);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginandregister/140508100350_1_540x360.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, -10, 800, 440);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 60, 800, 430);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        quantity.setText("");
        charges.setText("");
        bldtypcode.setSelectedIndex(0);
    }//GEN-LAST:event_resetActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
      close();
      this.dispose();
      adminmanagement adm =new adminmanagement();
      adm.setVisible(true);
      
    }//GEN-LAST:event_backActionPerformed

    private void bldtypcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bldtypcodeFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bldtypcodeFocusLost

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void bldtypcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bldtypcodeActionPerformed
        // TODO add your handling code here:
         try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        if(bldtypcode.getSelectedItem()=="A+")
        {
           //charges.setText("100");
           try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='A+'";
           String query1="select price from blood_collection where blood_typecode='A+'";
           searchChPS=con.prepareStatement(query);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
            
            searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
            
            
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }
        else if(bldtypcode.getSelectedItem()=="A-")
        {
           
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='A-'";
           String query1="select price from blood_collection where blood_typecode='A-'";
           searchChPS=con.prepareStatement(query);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
            
            
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
            
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }
        else if(bldtypcode.getSelectedItem()=="B+")
        {
           
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='B+'";
           String query1="select price from blood_collection where blood_typecode='B+'";
           searchChPS=con.prepareStatement(query);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }
        else if(bldtypcode.getSelectedItem()=="B-")
        {
          
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='B-'";
           String query1="select price from blood_collection where blood_typecode='B-'";
           searchChPS=con.prepareStatement(query);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }else if(bldtypcode.getSelectedItem()=="AB+")
        {
          
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='AB+'";
           String query1="select price from blood_collection where blood_typecode='AB+'";
           searchChPS=con.prepareStatement(query);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }else if(bldtypcode.getSelectedItem()=="AB-")
        {
          
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='AB-'";
           String query1="select price from blood_collection where blood_typecode='AB-'";
           searchChPS=con.prepareStatement(query);
            
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("price"));

            }
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }
        else if(bldtypcode.getSelectedItem()=="O+")
        {
          
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='O+'";
           String query1="select price from blood_collection where blood_typecode='O+'";
           searchChPS=con.prepareStatement(query);
            
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }else if(bldtypcode.getSelectedItem()=="O-")
        {
           
            try{
           Statement sta=con.createStatement();
           String query="select quantity from blood_collection where blood_typecode='O-'";
           String query1="select price from blood_collection where blood_typecode='O-'";
           searchChPS=con.prepareStatement(query);
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                quantity.setText(searchChRes.getString("quantity"));

            }
             searchChPS1=con.prepareStatement(query1);
            //searchChPS.setInt(1,Integer.parseInt();
            searchChRes1=searchChPS1.executeQuery();
            if(searchChRes1.next())
            {
                charges.setText(searchChRes1.getString("price"));

            }
           }catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,ex);
           }
        }
        
    }//GEN-LAST:event_bldtypcodeActionPerformed

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
            java.util.logging.Logger.getLogger(bldstorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bldstorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bldstorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bldstorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bldstorage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> bldtypcode;
    private javax.swing.JTextField charges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}