package loginandregister;

import java.sql.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rucha
 */
public class bill extends javax.swing.JFrame {
   PreparedStatement addChPS=null, fetChPS=null, searchChPS=null, modifyChPS=null, deleteChPS=null;
    Connection con=null;
    ResultSet fetChRes=null, searchChRes=null;
    Statement st;
    public bill() {
       
        initComponents();
        this.setSize(668, 501);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
       setTitle("Blood Bank Management System");
        
         String billNO ="";
         billNO =GetMaxBillNO();
         ebill.setText(billNO);
                    
         saveBill.setEnabled(false);
    }
    public boolean IsRecDonor(String ClientID)
    {
          String adharNo ="";
          try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
            //return false ;
        }
      try{
            Statement sta=con.createStatement();
            fetChRes =sta.executeQuery("select aadhar_no from client where client_id ="+ ClientID +"");
            
            if(fetChRes.next()) {
               adharNo  = fetChRes.getString("aadhar_no");
             }
            else
            {
             JOptionPane.showMessageDialog(null,"record not found");
             System.exit(0);
             }
          }
      catch(Exception ex)
              {
               JOptionPane.showMessageDialog(null,ex);
               return false;
              }
         String donorCount = "";
           try{
     
           Statement sta=con.createStatement();
            fetChRes =sta.executeQuery("select Count(*) as Count from client where aadhar_no='"+ adharNo +"'");
            
            while (fetChRes.next()) {
               donorCount  = fetChRes.getString("Count");
             }
               }catch(Exception ex)
        {
               JOptionPane.showMessageDialog(null,ex);
               //return false;
        }
          
           if( Integer.parseInt(donorCount) > 0)
           {
               return true; // Give Discount
           }
           else
           {
               return false; // no discount;
           }      
          }
    
    public Boolean IsBloodGroupQtyAvailable(String BloodType, String InputQty)
    {
      try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
            return false ;
        }
          try{
            Statement sta=con.createStatement();
            fetChRes =sta.executeQuery("select quantity from blood_collection where blood_typecode ='"+ BloodType +"' ");
            
            String totalQty = "";
            
            while (fetChRes.next()) {
               totalQty  = fetChRes.getString("quantity");
             }
            
            if( Integer.parseInt(totalQty) > Integer.parseInt(InputQty)  )
            {
                return true;
            }
            else
            {
                return false;   
            }
        
               }catch(Exception ex)
        {
               JOptionPane.showMessageDialog(null,ex);
                           return false ;

        }
         
    }
    
    
     public Double GetChargeAsperBloodGrp(String bloodGrp, Boolean IsDiscount  )
    {
          Double charges =0.0;
          try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
              return 0.0;
        }
        try{
            Statement sta=con.createStatement();
            fetChRes =sta.executeQuery("select price from blood_collection where blood_typecode='"+ bloodGrp  + "'");
            
            while (fetChRes.next()) {
               charges  = Double.parseDouble( fetChRes.getString("price"));
             }
               }catch(Exception ex)
        {
               JOptionPane.showMessageDialog(null,ex);
               return 0.0;
        }

          Double qty  = Double.parseDouble( Qty.getText());
          Double Amount = 0.0;
                  
         // JOptionPane.showMessageDialog(null, IsDiscount);
          
          if (IsDiscount == true )
          {
              Double DiscountRate = 0.0;
              
                 Amount   = charges * qty;
              
                 //DiscountRate = (Amount * 0.2);
                DiscountRate=1.0;
                 Double FinalAmount = 0.0;
                 FinalAmount = Amount - DiscountRate;
                 
                          weight.setText(Amount.toString());
                          
                    //          JOptionPane.showMessageDialog(null, FinalAmount);
                   
                 return FinalAmount;
 
          }
          else
          {
              Amount   = charges * qty;
              weight.setText(Amount.toString());
               return Amount;
          }

    }
     
    public String GetMaxBillNO()
    {
          String billNO ="";
          try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
       try{
            Statement sta=con.createStatement();
            fetChRes =sta.executeQuery("select max(bill_no) + 1 as billno from transaction_bill");
            System.out.println("bill SET");
            while (fetChRes.next()) {
               billNO  = fetChRes.getString("billno");
               System.out.println(billNO);
             }
               }catch(Exception ex)
        {
               JOptionPane.showMessageDialog(null,ex);
        }
          return billNO;
        
    }
    
     public Boolean SaveBill(Boolean IsDonor)
    {
         
          try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
        String blood_group=ebgrp.getSelectedItem().toString();  
        String client_id=client_id1.getSelectedItem().toString();
        String billno=ebill.getText();
        String Qty1= Qty.getText();
                String bld_grp=ebgrp.getSelectedItem().toString();
           String ClientType=eclient.getSelectedItem().toString();
           String charge=etotal.getText();
       String BillDate=billdate.getText();
       
        try{
            Statement sta=con.createStatement();
            String query = "Insert into transaction_bill values("+billno+",'"+BillDate+"','"+blood_group+"',"+charge+","+Qty1+","+client_id+",'"+ClientType+"')";
      
              PreparedStatement addChPS;
               String cid=client_id1.getSelectedItem().toString();
               String Q= Qty.getText();
               String w=weight.getText();
            addChPS=con.prepareStatement(query);
            sta.executeUpdate(query);
         System.out.println("fff");   
            if (IsDonor == true)
            {
                    String Query2 = "";
                Query2 = "update blood_collection set quantity = (quantity + " + Qty1 +") where blood_typecode='"+ bld_grp +"' ";
                
             addChPS=con.prepareStatement(Query2);
             sta.executeUpdate(Query2);System.out.println("ffff");
              Query2 = "insert into donor values("+Q+","+w+","+cid+")";
                System.out.println("ffff");
             addChPS=con.prepareStatement(Query2);
             sta.executeUpdate(Query2);
             
             
            }
            else
            {
                 String Ql= Qty.getText();
                String b=ebgrp.getSelectedItem().toString();
                String Query1 = "";
                Query1 = "update blood_collection set quantity = (quantity - " + Qty1 +") where blood_typecode='"+ bld_grp +"' ";
              // JOptionPane.showMessageDialog(null, Query1);
                   addChPS=con.prepareStatement(Query1);
                      sta.executeUpdate(Query1);
                       Query1 = "insert into recipient values('"+b+"',"+Ql+","+cid+")";
                
             addChPS=con.prepareStatement(Query1);
             sta.executeUpdate(Query1);
                
            }
            return true;
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
              return false;
             }

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
        Lable_billing = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bill = new javax.swing.JLabel();
        client = new javax.swing.JLabel();
        cid = new javax.swing.JLabel();
        ebill = new javax.swing.JTextField();
        eclient = new javax.swing.JComboBox<>();
        name = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        bgrp = new javax.swing.JLabel();
        ebgrp = new javax.swing.JComboBox<>();
        amt = new javax.swing.JLabel();
        weight = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        generate_bill = new javax.swing.JButton();
        etotal = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Qty = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        new_bill = new javax.swing.JButton();
        saveBill = new javax.swing.JButton();
        billdate = new javax.swing.JTextField();
        client_id1 = new javax.swing.JComboBox<>();
        iqty = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        BG = new javax.swing.JTextField();
        dispdonor = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(0);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(793, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(793, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        Lable_billing.setBackground(new java.awt.Color(255, 255, 255));
        Lable_billing.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Lable_billing.setForeground(new java.awt.Color(255, 255, 255));
        Lable_billing.setText("Billing");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Lable_billing, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lable_billing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 810, 60);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(668, 501));
        jPanel2.setLayout(null);

        bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bill.setForeground(new java.awt.Color(255, 255, 255));
        bill.setText("BILL NO");
        jPanel2.add(bill);
        bill.setBounds(33, 15, 64, 17);

        client.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        client.setForeground(new java.awt.Color(255, 255, 255));
        client.setText("CLIENT TYPE");
        jPanel2.add(client);
        client.setBounds(33, 48, 94, 17);

        cid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cid.setForeground(new java.awt.Color(255, 255, 255));
        cid.setText("CLIENT ID");
        jPanel2.add(cid);
        cid.setBounds(30, 110, 75, 17);

        ebill.setEditable(false);
        ebill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebillActionPerformed(evt);
            }
        });
        jPanel2.add(ebill);
        ebill.setBounds(209, 12, 150, 30);

        eclient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eclient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DONOR", "RECEIVER" }));
        eclient.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                eclientPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        eclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eclientMouseClicked(evt);
            }
        });
        eclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eclientActionPerformed(evt);
            }
        });
        jPanel2.add(eclient);
        eclient.setBounds(210, 50, 150, 30);

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("FIRST NAME");
        jPanel2.add(name);
        name.setBounds(33, 147, 100, 17);

        lastname.setEditable(false);
        lastname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(lastname);
        lastname.setBounds(210, 190, 150, 30);

        bgrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bgrp.setForeground(new java.awt.Color(255, 255, 255));
        bgrp.setText("BLOOD GROUP");
        jPanel2.add(bgrp);
        bgrp.setBounds(30, 230, 104, 25);

        ebgrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ebgrp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        ebgrp.setEnabled(false);
        ebgrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebgrpActionPerformed(evt);
            }
        });
        jPanel2.add(ebgrp);
        ebgrp.setBounds(210, 230, 60, 30);

        amt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amt.setForeground(new java.awt.Color(255, 255, 255));
        amt.setText("Weight");
        jPanel2.add(amt);
        amt.setBounds(40, 290, 49, 17);

        weight.setEditable(false);
        jPanel2.add(weight);
        weight.setBounds(210, 280, 150, 30);

        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("TOTAL");
        jPanel2.add(total);
        total.setBounds(40, 370, 63, 17);

        print.setBackground(new java.awt.Color(204, 204, 204));
        print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print.setText("DISPLAY");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel2.add(print);
        print.setBounds(530, 420, 110, 25);

        generate_bill.setBackground(new java.awt.Color(204, 204, 204));
        generate_bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generate_bill.setText("GENERATE BILL");
        generate_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_billActionPerformed(evt);
            }
        });
        jPanel2.add(generate_bill);
        generate_bill.setBounds(30, 420, 147, 25);

        etotal.setEditable(false);
        etotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etotalActionPerformed(evt);
            }
        });
        jPanel2.add(etotal);
        etotal.setBounds(210, 360, 150, 30);

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(680, 420, 73, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATE ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(580, 20, 42, 17);

        Qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtyActionPerformed(evt);
            }
        });
        Qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QtyKeyReleased(evt);
            }
        });
        jPanel2.add(Qty);
        Qty.setBounds(210, 320, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUANTITY");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 330, 76, 17);

        new_bill.setBackground(new java.awt.Color(204, 204, 204));
        new_bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        new_bill.setText("New Bill");
        new_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_billActionPerformed(evt);
            }
        });
        jPanel2.add(new_bill);
        new_bill.setBounds(380, 420, 87, 25);

        saveBill.setBackground(new java.awt.Color(204, 204, 204));
        saveBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBill.setText("Save Bill");
        saveBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBillActionPerformed(evt);
            }
        });
        jPanel2.add(saveBill);
        saveBill.setBounds(230, 420, 89, 25);

        billdate.setEditable(false);
        billdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billdateMouseClicked(evt);
            }
        });
        billdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billdateActionPerformed(evt);
            }
        });
        jPanel2.add(billdate);
        billdate.setBounds(660, 10, 105, 28);

        client_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_id1ActionPerformed(evt);
            }
        });
        jPanel2.add(client_id1);
        client_id1.setBounds(210, 100, 150, 30);

        iqty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iqty.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(iqty);
        iqty.setBounds(510, 270, 210, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LAST NAME");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 200, 110, 14);

        firstname.setEditable(false);
        firstname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(firstname);
        firstname.setBounds(209, 146, 150, 30);
        jPanel2.add(BG);
        BG.setBounds(280, 230, 70, 30);

        dispdonor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dispdonor.setText("DISPLAY DONOR");
        dispdonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispdonorActionPerformed(evt);
            }
        });
        jPanel2.add(dispdonor);
        dispdonor.setBounds(530, 360, 160, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginandregister/140508100350_1_540x360.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 810, 812);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 60, 810, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBillActionPerformed

        try
        {

            Boolean IsDonor  = false;

            if (eclient.getSelectedItem().toString().toUpperCase() == "DONOR")
            {
                IsDonor = true ;System.out.println("check none");
            }
            else
            {
                IsDonor = false;
            }

            if( SaveBill(IsDonor) == true )
            {
                JOptionPane.showMessageDialog(null,"DATA ADDED SUCCESSFULLY");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error occurred while saving record(s).");
            }

            saveBill.setEnabled(false);

        }
        catch( Exception ex)
        {

        }

    }//GEN-LAST:event_saveBillActionPerformed

    private void new_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_billActionPerformed
       
      client_id1.setSelectedIndex(0);
      lastname.setText("");
      billdate.setText("");
      Qty.setText("");
      weight.setText("");
      etotal.setText("");
      ebgrp.setSelectedIndex(0);
      eclient.setSelectedIndex(0);
      String billNO ="";
        billNO =GetMaxBillNO();
        ebill.setText(billNO);
        System.out.println("billno set");
        firstname.setText("");
        lastname.setText("");
    }//GEN-LAST:event_new_billActionPerformed

    private void QtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyKeyReleased
        // TODO add your handling code here:
         String pattern="^[0-9]{1,2}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(Qty.getText());
        if(!match.matches())
        {
          iqty.setText("Enter Valid Quantity");
        }
        else
        {
           iqty.setText(null);
        }
    }//GEN-LAST:event_QtyKeyReleased

    private void QtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtyActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        close();
        this.dispose();
        adminmanagement adm =new adminmanagement();
        adm.setVisible(true);

    }//GEN-LAST:event_backActionPerformed

    private void etotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etotalActionPerformed

    private void generate_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_billActionPerformed
         // TODO add your handling code here:
            
         Boolean IsDonor = false;
       if(eclient.getSelectedItem().toString().toUpperCase().equals("RECEIVER"))
        {
            IsDonor = false;
           if (Qty.getText()=="")
            {
                JOptionPane.showMessageDialog(null,"Please input blood quantity");
                System.exit(0);
            }

            Boolean flag = false;

            flag =   IsBloodGroupQtyAvailable(ebgrp.getSelectedItem().toString(), Qty.getText());
            if (flag == false )
            {
                JOptionPane.showMessageDialog(null,"Selected quantity is not available.");
                return;
            }

            Boolean isDonor = false;
            isDonor = IsRecDonor(client_id1.getSelectedItem().toString());

            Double FinalAmount = 0.0;
            FinalAmount = GetChargeAsperBloodGrp(ebgrp.getSelectedItem().toString(),isDonor);

            etotal.setText(FinalAmount.toString());

        }
        else
        {
            IsDonor = true ;
           if (Qty.getText()=="")
            {
                JOptionPane.showMessageDialog(null,"Please input blood quantity");
                System.exit(0);
            }
            etotal.setText("0");
        }

         saveBill.setEnabled(true);
         if(eclient.getSelectedItem()=="DONOR")
          {
              if (Qty.getText()=="")
            {
                JOptionPane.showMessageDialog(null,"Please input blood  quantity");
                System.exit(0);
            }
        try{
           Statement sta=con.createStatement();
           String query="select client_id,firstname,lastname,blood_group from client where client_id=?";

            searchChPS=con.prepareStatement(query);
            searchChPS.setInt(1,Integer.parseInt(client_id1.getSelectedItem().toString()));
            searchChRes=searchChPS.executeQuery();
            System.out.println(client_id1.getSelectedItem().toString());
            if(searchChRes.next())
            {
              //  client_id1.setSelectedItem(searchChRes.getString("client_id"));
              //  firstname.setText(searchChRes.getString("firstname"));
                //lastname.setText(searchChRes.getString("lastname"));
                ebgrp.setSelectedItem(searchChRes.getString("blood_group"));
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Record Not Found !!");
            }
            //con.close();
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(null,"Enter correct details");
        }
          }
          else {
               try{
           Statement sta=con.createStatement();
           String query="select client_id,firstname,lastname,blood_group from client join recipient on  client.client_id=?";
           
           /* searchChPS=con.prepareStatement(query);
            searchChPS.setInt(1,Integer.parseInt(client_id1.getSelectedItem().toString()));
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                //client_id1.setSelectedItem(searchChRes.getString("client_id"));
             //   firstname.setText(searchChRes.getString("firstname"));
              //  lastname.setText(searchChRes.getString("lastname"));
                ebgrp.setSelectedItem(searchChRes.getString("blood_group"));
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Record Not Found !!");
            }*/
            //con.close();
        }
          
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(null,"Enter correct details");
        }
              
       }
          
    }//GEN-LAST:event_generate_billActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
     /*try
        {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
                public int print(Graphics pg,PageFormat pf,int pageNum){
                    if(pageNum>0){
                        return Printable.NO_SUCH_PAGE;
                    }
                    
                    Graphics2D g2= (Graphics2D)pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.scale(0.700,0.800);
                    
                    jPanel1.paint(g2);
                    jPanel2.paint(g2);
                    return Printable.PAGE_EXISTS;
                }
            });
                boolean ok = job.printDialog();
                if(ok){
                    try
                    {
                        job.print();
                    }
                    catch(PrinterException e)
                    {
                        
                    }
                }
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
     */
       //close();
        //this.dispose();
        displaytrans_rec reg=new displaytrans_rec();
        reg.setVisible(true);
    }//GEN-LAST:event_printActionPerformed

    private void ebgrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebgrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ebgrpActionPerformed

    private void eclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eclientActionPerformed
                client_id1.removeAllItems();  
        if(eclient.getSelectedItem()=="DONOR") {
             // client_id1.removeAll();
         try{
              
              String sql="select * from client";
                  addChPS=con.prepareStatement(sql);
                  fetChRes=addChPS.executeQuery();
                  BG.setVisible(true);
                  ebgrp.setVisible(false);
                  weight.setVisible(true);
                  weight.setEditable(true);
                   amt.setVisible(true);
                  while(fetChRes.next())
                  {
                    String str=fetChRes.getString("client_id");
                    client_id1.addItem(str);
                  }  
            }
              
         
         catch(Exception ex)
         {
            JOptionPane.showMessageDialog(null,ex);
         }
         }   
                   
                   if(eclient.getSelectedItem()=="RECEIVER") {
             // client_id1.removeAll();
         try{
              
              String sql="select * from client";
                  addChPS=con.prepareStatement(sql);
                  fetChRes=addChPS.executeQuery();
                  BG.setVisible(false);
                  ebgrp.setVisible(true);
                  weight.setVisible(false);
                  ebgrp.setEnabled(true);
                  amt.setVisible(false);
                  while(fetChRes.next())
                  {
                    String str=fetChRes.getString("client_id");
                    client_id1.addItem(str);
                  }  
            }
              
         
         catch(Exception ex)
         {
            JOptionPane.showMessageDialog(null,ex);
         }
         }                     
        
    }//GEN-LAST:event_eclientActionPerformed

    private void billdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billdateMouseClicked
      /*  int d,m,y;
        GregorianCalendar gc = new GregorianCalendar();
        d=gc.get(Calendar.DAY_OF_MONTH);
        m=gc.get(Calendar.MONDAY);
        y=gc.get(Calendar.YEAR);
        billdate.setText(String.valueOf(y+"-"+(m+1)+"-"+d));
*/
    }//GEN-LAST:event_billdateMouseClicked

    private void billdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billdateActionPerformed

    private void ebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ebillActionPerformed

    private void client_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_id1ActionPerformed
       try{
           String client_id=client_id1.getSelectedItem().toString();
           String c_type=eclient.getSelectedItem().toString();
           String query="",a="RECEIVER";
           System.out.println(c_type);
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
             //query="select * from client inner join "+c_type+" on "+c_type+".c_id=client.client_id where client_id="+client_id;
           if(c_type.equals(a))
           {
               
            query="select firstname,lastname from client where client.client_id="+client_id; 
            searchChPS=con.prepareStatement(query);
            searchChRes=searchChPS.executeQuery();    
            if(searchChRes.next())
            {
                firstname.setText(searchChRes.getString("firstname"));
                lastname.setText(searchChRes.getString("lastname"));
                
            }
           }
            else
           {
               System.out.println("fedsffsdd");
                query="select firstname,lastname,blood_group from client  where client.client_id="+client_id;
                searchChPS=con.prepareStatement(query);
            searchChRes=searchChPS.executeQuery();    
            if(searchChRes.next())
            {
                firstname.setText(searchChRes.getString("firstname"));
                lastname.setText(searchChRes.getString("lastname"));
                BG.setText(searchChRes.getString("blood_group"));
                BG.setEditable(false);
            }
           } 
           searchChPS=con.prepareStatement(query);
            searchChRes=searchChPS.executeQuery();    
            if(searchChRes.next())
            {
                firstname.setText(searchChRes.getString("firstname"));
                lastname.setText(searchChRes.getString("lastname"));
                ebgrp.setSelectedItem(searchChRes.getString("blood_group"));
            }
             
       }
       catch(Exception ex)
       {
           
       }
    }//GEN-LAST:event_client_id1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null,"Select Client Type,Client ID and Enter Quantity and Click On GENERATE BILL");
        int d,m,y;
        GregorianCalendar gc = new GregorianCalendar();
        d=gc.get(Calendar.DAY_OF_MONTH);
        m=gc.get(Calendar.MONDAY);
        y=gc.get(Calendar.YEAR);
        billdate.setText(String.valueOf(y+"-"+(m+1)+"-"+d));
        
    }//GEN-LAST:event_formWindowOpened

    private void eclientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eclientMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_eclientMouseClicked

    private void eclientPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_eclientPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
    }//GEN-LAST:event_eclientPopupMenuWillBecomeInvisible

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void dispdonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispdonorActionPerformed
        // TODO add your handling code here:
        displayrecipient r=new displayrecipient();
        r.setVisible(true);
        
    }//GEN-LAST:event_dispdonorActionPerformed

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
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BG;
    private javax.swing.JLabel Lable_billing;
    private javax.swing.JTextField Qty;
    private javax.swing.JLabel amt;
    private javax.swing.JButton back;
    private javax.swing.JLabel bgrp;
    private javax.swing.JLabel bill;
    private javax.swing.JTextField billdate;
    private javax.swing.JLabel cid;
    private javax.swing.JLabel client;
    private javax.swing.JComboBox<String> client_id1;
    private javax.swing.JButton dispdonor;
    private javax.swing.JComboBox<String> ebgrp;
    private javax.swing.JTextField ebill;
    private javax.swing.JComboBox<String> eclient;
    private javax.swing.JTextField etotal;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton generate_bill;
    private javax.swing.JLabel iqty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel name;
    private javax.swing.JButton new_bill;
    private javax.swing.JButton print;
    private javax.swing.JButton saveBill;
    private javax.swing.JLabel total;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
