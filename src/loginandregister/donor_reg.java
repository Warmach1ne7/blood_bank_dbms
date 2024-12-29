package loginandregister;



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.regex.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class donor_reg extends javax.swing.JFrame {
    PreparedStatement addChPS=null, fetChPS=null, searchChPS=null, modifyChPS=null, deleteChPS=null;
    Connection con=null;
    ResultSet fetChRes=null, searchChRes=null;
    Statement st=null;
    int h=1;
    public donor_reg() {
        
         /*try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:1527/blood bank", "omkar", "12345");
        } catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        */
         System.out.println("donor reg");
        initComponents();
       /* Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
        */setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setTitle("Blood Bank Management System");
         update.setEnabled(false);
         delete.setEnabled(false);
         System.out.println("d loaded");
    }
    public void close()
     {
      WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
      Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        register = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        address = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        bldgrp = new javax.swing.JLabel();
        uage = new javax.swing.JTextField();
        ucontact = new javax.swing.JTextField();
        ubldgrps = new javax.swing.JComboBox<>();
        client1 = new javax.swing.JLabel();
        iage = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        display = new javax.swing.JButton();
        icontact1 = new javax.swing.JLabel();
        client_id = new javax.swing.JLabel();
        uclientid = new javax.swing.JTextField();
        iname1 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        uaddress = new javax.swing.JTextArea();
        contact1 = new javax.swing.JLabel();
        weight1 = new javax.swing.JLabel();
        adhar = new javax.swing.JTextField();
        iadhar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        iname2 = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        ulast_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(0);
        setTitle("BLOOD BANK MANAGEMENT SYSTEM\n");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(791, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(793, 443));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("CLIENT REGISTRATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(569, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(null);

        register.setBackground(new java.awt.Color(204, 204, 204));
        register.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        register.setText("REGISTER");
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register);
        register.setBounds(10, 490, 105, 30);

        reset.setBackground(new java.awt.Color(204, 204, 204));
        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setText("RESET");
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset);
        reset.setBounds(600, 490, 79, 30);

        address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setText("Address     :");
        jPanel2.add(address);
        address.setBounds(90, 130, 100, 30);

        age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setText("Age  :");
        jPanel2.add(age);
        age.setBounds(90, 220, 96, 20);

        bldgrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bldgrp.setForeground(new java.awt.Color(255, 255, 255));
        bldgrp.setText("Blood Group :");
        jPanel2.add(bldgrp);
        bldgrp.setBounds(90, 410, 110, 30);

        uage.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        uage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uageActionPerformed(evt);
            }
        });
        uage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uageKeyReleased(evt);
            }
        });
        jPanel2.add(uage);
        uage.setBounds(240, 220, 180, 30);

        ucontact.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ucontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucontactActionPerformed(evt);
            }
        });
        ucontact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ucontactKeyReleased(evt);
            }
        });
        jPanel2.add(ucontact);
        ucontact.setBounds(240, 350, 180, 30);

        ubldgrps.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ubldgrps.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        ubldgrps.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubldgrps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubldgrpsActionPerformed(evt);
            }
        });
        jPanel2.add(ubldgrps);
        ubldgrps.setBounds(240, 410, 180, 30);

        client1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        client1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(client1);
        client1.setBounds(540, 10, 196, 22);

        iage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(iage);
        iage.setBounds(600, 220, 147, 22);

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(710, 490, 73, 30);

        update.setBackground(new java.awt.Color(204, 204, 204));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateKeyPressed(evt);
            }
        });
        jPanel2.add(update);
        update.setBounds(260, 490, 89, 30);

        delete.setBackground(new java.awt.Color(204, 204, 204));
        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete);
        delete.setBounds(380, 490, 87, 30);

        display.setBackground(new java.awt.Color(204, 204, 204));
        display.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        display.setText("DISPLAY");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });
        jPanel2.add(display);
        display.setBounds(140, 490, 95, 30);

        icontact1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        icontact1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(icontact1);
        icontact1.setBounds(590, 360, 160, 22);

        client_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        client_id.setForeground(new java.awt.Color(255, 255, 255));
        client_id.setText("CLIENT ID :");
        jPanel2.add(client_id);
        client_id.setBounds(90, 10, 96, 20);

        uclientid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uclientid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uclientidActionPerformed(evt);
            }
        });
        uclientid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uclientidKeyReleased(evt);
            }
        });
        jPanel2.add(uclientid);
        uclientid.setBounds(240, 10, 195, 30);

        iname1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iname1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(iname1);
        iname1.setBounds(570, 90, 196, 22);

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel2.add(search);
        search.setBounds(490, 490, 91, 30);

        uaddress.setColumns(20);
        uaddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uaddress.setRows(5);
        jScrollPane3.setViewportView(uaddress);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(240, 130, 195, 70);

        contact1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contact1.setForeground(new java.awt.Color(255, 255, 255));
        contact1.setText("Contact No:");
        jPanel2.add(contact1);
        contact1.setBounds(90, 350, 100, 30);

        weight1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weight1.setForeground(new java.awt.Color(255, 255, 255));
        weight1.setText("Aadhar Card No :");
        jPanel2.add(weight1);
        weight1.setBounds(90, 270, 120, 22);

        adhar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adharActionPerformed(evt);
            }
        });
        adhar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adharKeyReleased(evt);
            }
        });
        jPanel2.add(adhar);
        adhar.setBounds(240, 270, 180, 30);

        iadhar.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(iadhar);
        iadhar.setBounds(590, 270, 170, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("(Adhar No Should Be In Form :XXXX XXXX XXXX)");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 300, 310, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("(Client Id must be start from 1)");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(70, 30, 190, 14);

        fname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fname.setForeground(new java.awt.Color(255, 255, 255));
        fname.setText("FIRST  NAME :");
        jPanel2.add(fname);
        fname.setBounds(90, 50, 140, 20);

        uname.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        uname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                unameFocusLost(evt);
            }
        });
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        uname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unameKeyReleased(evt);
            }
        });
        jPanel2.add(uname);
        uname.setBounds(240, 50, 195, 30);

        iname2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iname2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(iname2);
        iname2.setBounds(570, 52, 196, 20);

        lname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lname.setForeground(new java.awt.Color(255, 255, 255));
        lname.setText("LAST NAME :");
        jPanel2.add(lname);
        lname.setBounds(90, 90, 130, 20);

        ulast_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ulast_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ulast_nameFocusLost(evt);
            }
        });
        ulast_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulast_nameActionPerformed(evt);
            }
        });
        ulast_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ulast_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ulast_nameKeyReleased(evt);
            }
        });
        jPanel2.add(ulast_name);
        ulast_name.setBounds(240, 90, 190, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginandregister/140508100350_1_540x360.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 810, 812);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uageActionPerformed
    private void ucontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucontactActionPerformed
           

    }//GEN-LAST:event_ucontactActionPerformed

    private void ubldgrpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubldgrpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubldgrpsActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        uclientid.setEnabled(true);
        uname.setEnabled(true);
        ulast_name.setEnabled(true);
        uaddress.setEnabled(true);
        uage.setEnabled(true);
        adhar.setEnabled(true);
        
        ucontact.setEnabled(true);
        adhar.setEnabled(true);
        uclientid.setText("");
        uname.setText("");
        ulast_name.setText("");
        uaddress.setText("");
        uage.setText("");
        adhar.setText("");
        
        ucontact.setText("");
        adhar.setText("");
        ubldgrps.setSelectedIndex(0);
        register.setEnabled(true);
        display.setEnabled(true);
        update.setEnabled(false);
        delete.setEnabled(false);
        search.setEnabled(true);
        back.setEnabled(true);
    }//GEN-LAST:event_resetActionPerformed

    private void uageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uageKeyReleased
        // TODO add your handling code here:
/*        String pattern="^[0-9]{2}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(uage.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
            
            
          
            update.setEnabled(false);
          iage.setText("Enter Valid Age");
        }
        else
        {
            register.setEnabled(true);
           iage.setText(null);
           update.setEnabled(true);
        }*/
check();
    }//GEN-LAST:event_uageKeyReleased

    public void check()
    {
    String pattern="[0-9]+"; 
       Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(uclientid.getText());
        if(!match.matches())
        {
            
            register.setEnabled(false);
          client1.setText("Enter Valid Client ID");
        }
        else
        {
            register.setEnabled(true);
           client1.setText(null);
        }

  pattern="^[a-zA-Z]{3,30}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(uname.getText());
        if(!match.matches())
        {
            
            register.setEnabled(false);
            update.setEnabled(false);
          iname2.setText("Enter Valid Name");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
          iname2.setText(null);
        }

         pattern="^[a-zA-Z]{3,30}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(ulast_name.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
            update.setEnabled(false);
          iname1.setText("Enter Valid Name");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
          iname1.setText(null);
        }
        pattern="^[0-9]{2}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(uage.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
            
            
          
            update.setEnabled(false);
          iage.setText("Enter Valid Age");
        }
        else
        {
            register.setEnabled(true);
           iage.setText(null);
           update.setEnabled(true);
        }
        pattern="^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(adhar.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
            update.setEnabled(false);
            iadhar.setText("Enter Valid Adhar No");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
            iadhar.setText(null);
        }
        pattern="^[0-9]{10}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(ucontact.getText());
        if(!match.matches())
        {
            
            update.setEnabled(false);
            register.setEnabled(false);
          icontact1.setText("Enter Valid Contact No");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
           icontact1.setText(null);
        }
    }
    private void ucontactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ucontactKeyReleased
        // TODO add your handling code here:
        check();
        String pattern="^[0-9]{10}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(ucontact.getText());
        if(!match.matches())
        {
            
            update.setEnabled(false);
            register.setEnabled(false);
          icontact1.setText("Enter Valid Contact No");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
           icontact1.setText(null);
        }
      
    }//GEN-LAST:event_ucontactKeyReleased
    public boolean checkall()
    {
        String pattern="[0-9]+"; 
         Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(uclientid.getText());
        if(!match.matches())
        {
            JOptionPane.showMessageDialog(null, "Enter valid client Id");
            return false;
        }

        pattern="^[a-zA-Z]{3,30}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(uname.getText());
        if(!match.matches())
        {
            JOptionPane.showMessageDialog(null, "Enter valid name");
            return false;
           
        }
       

         pattern="^[a-zA-Z]{3,30}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(ulast_name.getText());
        if(!match.matches())
        {
            JOptionPane.showMessageDialog(null, "Enter valid name");
            return false;
        }
        pattern="^[0-9]{2}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(uage.getText());
        if(!match.matches())
        {
            
            
            JOptionPane.showMessageDialog(null, "enter valid age");
            return false;
        }
        pattern="^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(adhar.getText());
        if(!match.matches())
        {
            JOptionPane.showMessageDialog(null, "Enter valid adhaar no");
            return false;
        }
        pattern="^[0-9]{10}$";
        patt=Pattern.compile(pattern);
        match=patt.matcher(ucontact.getText());
        if(!match.matches())
        {
            JOptionPane.showMessageDialog(null, "Enter valid number");
            return false;
        }
        return true;
    }
   
    
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        if(!checkall())
            return;
        register.setEnabled(false);
        display.setEnabled(true);
        delete.setEnabled(false);
        reset.setEnabled(false);
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
            System.out.println("accessed");
        }
        catch (Exception ex) 
        {
            
            JOptionPane.showMessageDialog(null, ex);
            
        }
        try
        {
            String c_id=uclientid.getText();
            String firstname=uname.getText();
            String lastname=ulast_name.getText();
            String _age=uage.getText();
            String addr=uaddress.getText();
            String bloodgrp=ubldgrps.getSelectedItem().toString();
            
            String aadhar = adhar.getText();
            String contact=ucontact.getText();  System.out.println("declared");
            
            if(c_id.equals("")||firstname.equals("")||lastname.equals("")||_age.equals("")||addr.equals("")||bloodgrp.equals("")||aadhar.equals("")||contact.equals(""))
            {
                JOptionPane.showMessageDialog(null,"ADD ALL DATA FIELDS");
                update.setEnabled(false);
                search.setEnabled(true);
                reset.setEnabled(true);
                
            }
            else{
            String query="update client set aadhar_no='"+aadhar+"',firstname='"+firstname+"',lastname='"+lastname+"',age="+_age+",address='"+addr+"',contact='"+contact+"',blood_group='"+bloodgrp+"' where client_id="+c_id;
            System.out.println("query set");
            Statement sta=con.createStatement();
            //modifyChPS=con.prepareStatement(query);
            sta.executeUpdate(query);
            System.out.println("sql done");
          //modifyChPS.execute();
            /*query="update donor set blood_group='"+bloodgrp+"',weight="+_weight+" where c_id="+c_id+"";
            sta=con.createStatement();
            *///modifyChPS=con.prepareStatement(query);
            sta.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Data updated");
        search.setEnabled(true);
        reset.setEnabled(true);
        update.setEnabled(false);
          uclientid.setText("");
          uclientid.setEnabled(true);
        uname.setText("");
        ulast_name.setText("");
        uaddress.setText("");
        uage.setText("");
        ucontact.setText("");
        
        ubldgrps.setSelectedIndex(0);
        update.setEnabled(true);
        adhar.setText("");
            }
    }
catch(Exception ex){
    System.out.println("not exec");
JOptionPane.showMessageDialog(null,ex);


        }
       
    }//GEN-LAST:event_updateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
      close();
      this.dispose();
      mainmenu mn =new mainmenu();
      mn.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void uclientidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uclientidKeyReleased
        // TODO add your handling code here:
       //String pattern="^[1]{1}[0-9]{2}$";
      check();
      String pattern="[0-9]+"; 
       Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(uclientid.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
          client1.setText("Enter Valid Client ID");
        }
        else
        {
            register.setEnabled(true);
           client1.setText(null);
        }
        
    }//GEN-LAST:event_uclientidKeyReleased

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
           if(!checkall())
               return;
        try {
           
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
             String client_id=uclientid.getText();
             String firstname=uname.getText();
             String lastname=ulast_name.getText();
             String _age=uage.getText();
             String addr=uaddress.getText();
             String bloodgrp=ubldgrps.getSelectedItem().toString();
             String aadhar = adhar.getText();
             String contact=ucontact.getText();
              if(client_id.equals("")||firstname.equals("")||lastname.equals("")||_age.equals("")||addr.equals("")||bloodgrp.equals("")||aadhar.equals("")||contact.equals(""))
            {
                JOptionPane.showMessageDialog(null,"ADD ALL DATA FIELDS");
                return;
                
                
            }
             String query="insert into client values("+client_id+",'"+firstname+"','"+lastname+"','"+addr+"','"+aadhar+"',"+_age+",'"+contact+"','"+bloodgrp+"'  )" ;
             Statement st=con.createStatement();
             ResultSet r;
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"DATA ADDED SUCCESSFULLY");
        } catch (Exception ex) 
        {
            System.out.println("not accessed");
            JOptionPane.showMessageDialog(null, ex);
        }
        /*String client_id;
        client_id = uclientid.getText();
        String firstname=uname.getText();
        String lastname=ulast_name.getText();
        String _age=uage.getText();
        String addr=uaddress.getText();
        String bloodgrp=ubldgrps.getSelectedItem().toString();
        String _weight=uweight.getText();
        
   String aadhar = adhar.getText();
        
        
        String contact_no=ucontact.getText();   
        try{
            Statement sta=con.createStatement();
            String query = "Insert into client(c_id,c_name,age,address,contact)values('"+client_id+"','"+firstname+"','"+_age+"','"+addr+"','"+contact_no+"')";
      
             //sta.executeUpdate("Insert into contact values('"+contact_no+"','"+client_id+"')");
           
            //addChPS=con.prepareStatement(query);
            sta.executeUpdate(query);
        }
        catch(Exception ex)
        { System.out.println("not exec");
              JOptionPane.showMessageDialog(null,ex);
        }*/
        try{    
            
            
            
            register.setEnabled(true);
            display.setEnabled(true);      
            search.setEnabled(true);
        uclientid.setText("");
        uname.setText("");
        ulast_name.setText("");
        uaddress.setText("");
        uage.setText("");
        ucontact.setText("");
        //ucontact1.setText("");
       
        adhar.setText("");
        ubldgrps.setSelectedIndex(0);
           }catch(Exception ex){
               System.out.println("not accessed");
              JOptionPane.showMessageDialog(null,"Enter valid client id");
             }
        
    }//GEN-LAST:event_registerActionPerformed

    private void uclientidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uclientidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uclientidActionPerformed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        // TODO add your handling code here:
       // close();
        //this.dispose();
        displaydonor clf=new displaydonor();
        clf.setVisible(true);
    }//GEN-LAST:event_displayActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
         register.setEnabled(false);
         display.setEnabled(false);
         update.setEnabled(false);
         delete.setEnabled(false);
         reset.setEnabled(false);
          try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
            System.out.println("accessed");
        }
        catch (Exception ex) 
        {
            
            JOptionPane.showMessageDialog(null, ex);
        }   
        
        try{
          //String query="delete donor from donor INNER JOIN contact ON door.client_id=contact.client_idn where donor.client_id=?";
          String query="delete from client where client_id=?";
          
          deleteChPS=con.prepareStatement(query);
          deleteChPS.setInt(1,Integer.parseInt(uclientid.getText()));
          deleteChPS.executeUpdate();
         
          JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!");
         // con.close();
         update.setEnabled(false);
         search.setEnabled(true);
         reset.setEnabled(true);
        uclientid.setText("");
        uname.setText("");
        ulast_name.setText("");
        uaddress.setText("");
        uage.setText("");
        ucontact.setText("");
       
        ubldgrps.setSelectedIndex(0);
        update.setEnabled(true);
        adhar.setText("");
        display.setEnabled(true);

        }catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null, ex);
        }
        // display.setEnabled(true);
         
    }//GEN-LAST:event_deleteActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
         register.setEnabled(false);
         display.setEnabled(false);
         update.setEnabled(false);
         delete.setEnabled(false);
         reset.setEnabled(false);
         
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/bloodbank", "omkar", "12345");
           Statement sta=con.createStatement();
           String client_id=uclientid.getText();
           String query=" select client.client_id ,client.firstname,client.lastname ,client.age ,client.address,client.blood_group,client.aadhar_no,client.contact from client where client_id="+client_id;
                   

            searchChPS=con.prepareStatement(query);
           //searchChPS.setInt(1,Integer.parseInt(uclientid.getText()));
             
            searchChRes=searchChPS.executeQuery();
            if(searchChRes.next())
            {
                uclientid.setText(searchChRes.getString("client_id"));
                uname.setText(searchChRes.getString("firstname"));
                ulast_name.setText(searchChRes.getString("lastname"));
                uage.setText(searchChRes.getString("age"));
                
                uaddress.setText(searchChRes.getString("address"));
                adhar.setText(searchChRes.getString("aadhar_no"));
                ubldgrps.setSelectedItem(searchChRes.getString("blood_group"));
               ucontact.setText(searchChRes.getString("contact"));
              // ucontact1.setText(searchChRes.getString("contact_no"));
               search.setEnabled(false);
               delete.setEnabled(true);
               update.setEnabled(true);
               reset.setEnabled(true);
               uclientid.setEnabled(false);
            }
            else
            {
                register.setEnabled(true);
                reset.setEnabled(true);
                display.setEnabled(true);
               JOptionPane.showMessageDialog(null, "Record Not Found !!");
            }
            
            //con.close();
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(null,ex);
        }
        
        
        
    }//GEN-LAST:event_searchActionPerformed

    private void adharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adharActionPerformed

    private void adharKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adharKeyReleased
        // TODO add your handling code here:
        
        check();
        String pattern="^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(adhar.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
            update.setEnabled(false);
            iadhar.setText("Enter Valid Adhar No");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
            iadhar.setText(null);
        }
        
    }//GEN-LAST:event_adharKeyReleased

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void unameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameKeyPressed

    private void unameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unameKeyReleased
        // TODO add your handling code here:
       check();
        String pattern="^[a-zA-Z]{3,30}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(uname.getText());
        if(!match.matches())
        {
            
            register.setEnabled(false);
            update.setEnabled(false);
          iname2.setText("Enter Valid Name");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
          iname2.setText(null);
        }
       
    }//GEN-LAST:event_unameKeyReleased

    private void ulast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulast_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ulast_nameActionPerformed
   
    private void ulast_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ulast_nameKeyReleased
        // TODO add your handling code here:
       check();
        String pattern="^[a-zA-Z]{3,30}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match=patt.matcher(ulast_name.getText());
        if(!match.matches())
        {
            register.setEnabled(false);
            update.setEnabled(false);
          iname1.setText("Enter Valid Name");
        }
        else
        {
            update.setEnabled(true);
            register.setEnabled(true);
          iname1.setText(null);
        }
          
    }//GEN-LAST:event_ulast_nameKeyReleased

    private void ulast_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ulast_nameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ulast_nameKeyPressed

    private void unameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_unameFocusLost

    private void ulast_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ulast_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ulast_nameFocusLost

    private void updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateKeyPressed

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
            java.util.logging.Logger.getLogger(donor_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(donor_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(donor_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(donor_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new donor_reg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField adhar;
    private javax.swing.JLabel age;
    private javax.swing.JButton back;
    private javax.swing.JLabel bldgrp;
    private javax.swing.JLabel client1;
    private javax.swing.JLabel client_id;
    private javax.swing.JLabel contact1;
    private javax.swing.JButton delete;
    private javax.swing.JButton display;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel iadhar;
    private javax.swing.JLabel iage;
    private javax.swing.JLabel icontact1;
    private javax.swing.JLabel iname1;
    private javax.swing.JLabel iname2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lname;
    private javax.swing.JButton register;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea uaddress;
    private javax.swing.JTextField uage;
    private javax.swing.JComboBox<String> ubldgrps;
    private javax.swing.JTextField uclientid;
    private javax.swing.JTextField ucontact;
    private javax.swing.JTextField ulast_name;
    private javax.swing.JTextField uname;
    private javax.swing.JButton update;
    private javax.swing.JLabel weight1;
    // End of variables declaration//GEN-END:variables
}
