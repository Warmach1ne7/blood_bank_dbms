 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author Akshay
 */
public class DispTicket extends javax.swing.JFrame {
    /**
     * Creates new form DispTicket
     */
    public DispTicket() {
        initComponents();
    }

    DispTicket(JTextField price, int t_id) {
      
    }

    DispTicket(int total, int t_id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       initComponents();
        
        amount = total;
        tid = t_id;
        try{       
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/railway_reservation_system", "omkar", "12345");                   
                    PreparedStatement pst=conn.prepareStatement("select * from ticket where Ticket_id = "+tid+"");
                    ResultSet rs=pst.executeQuery();
                    System.out.println(tid);
                    if(rs.next())
                    {
                        dates = rs.getString("Date");           
                        qtys = rs.getInt("No_Of_Seat");
                        pid = rs.getInt("p_id");
                        t = rs.getInt("train_id");
                    }
                  System.out.println("d:"+dates+","+qtys+","+pid+","+t);
                    tidLabel.setText(""+tid);
                    piid.setText(""+pid);
                    dateLabel.setText(""+dates);
                    seats.setText(""+qtys);
                   ti.setText(""+t);
                    totalLabel.setText(""+amount);
                    String trainname=null,traintype=null,tsource=null,tdestin=null,time=null,depttime=null;
                    PreparedStatement pst1=conn.prepareStatement(" select t_name,t_type,source,destination,arrival_time,departure_time from train where t_id = "+t+"");                                      
                    ResultSet rs1=pst1.executeQuery();
                    if(rs1.next())
                    {
                       trainname=rs1.getString("t_name");
                       traintype=rs1.getString("t_type");
                       tsource=rs1.getString("source");
                       tdestin=rs1.getString("destination");
                       time=rs1.getString("arrival_time");
                       depttime=rs1.getString("departure_time");
                    }
                    tname.setText(""+trainname);
                        type.setText(""+traintype);
                       from.setText(""+tsource);
                       to.setText(""+tdestin);
                        at.setText(""+time);
                         dt.setText(""+depttime);
        }        
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
         e.printStackTrace(); 
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

        jLabel1 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tidLabel = new javax.swing.JLabel();
        seats = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        piid = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ti = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        at = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RAILWAY RESERVATION SYSTEM");
        setLocation(new java.awt.Point(350, 100));
        setPreferredSize(new java.awt.Dimension(620, 450));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("DATE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 70, 68, 23);

        dateLabel.setBackground(new java.awt.Color(255, 255, 255));
        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel.setText("_______");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(400, 70, 138, 23);

        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalLabel.setText("_______");
        getContentPane().add(totalLabel);
        totalLabel.setBounds(390, 250, 70, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(290, 250, 54, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("TICKET ID");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 70, 70, 17);

        tidLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tidLabel.setText("_____");
        getContentPane().add(tidLabel);
        tidLabel.setBounds(183, 70, 40, 17);

        seats.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        seats.setText("_____");
        getContentPane().add(seats);
        seats.setBounds(180, 250, 54, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RAILWAY TICKET");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(160, 20, 226, 46);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("SEATS");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 250, 54, 17);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("PASSENGER ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 100, 99, 17);

        piid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        piid.setText(" _____");
        getContentPane().add(piid);
        piid.setBounds(180, 100, 44, 17);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("TRAIN ID");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 130, 63, 17);

        ti.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ti.setText(" _____");
        getContentPane().add(ti);
        ti.setBounds(180, 130, 44, 17);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("FROM");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 190, 41, 17);

        from.setText(" ____________");
        getContentPane().add(from);
        from.setBounds(180, 180, 108, 28);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("TO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 190, 19, 17);

        to.setText(" ______________");
        getContentPane().add(to);
        to.setBounds(400, 180, 138, 28);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("TRAIN NAME");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 160, 99, 17);

        tname.setText("_______________");
        getContentPane().add(tname);
        tname.setBounds(180, 160, 140, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 350, 120, 23);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("DEPT. TIME");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 220, 99, 25);

        dt.setText("______");
        getContentPane().add(dt);
        dt.setBounds(180, 220, 108, 25);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("ARR. TIME");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(290, 220, 87, 25);

        at.setText("_________");
        getContentPane().add(at);
        at.setBounds(390, 220, 105, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("TRAIN TYPE");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(290, 120, 87, 27);

        jLabel16.setText("jLabel16");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(523, 146, 126, 0);

        type.setText("______________");
        getContentPane().add(type);
        type.setBounds(400, 120, 140, 22);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akshay\\Pictures\\1811974.png")); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(700, 280));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, -20, 600, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DispTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DispTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DispTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DispTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DispTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel at;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dt;
    private javax.swing.JLabel from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel piid;
    private javax.swing.JLabel seats;
    private javax.swing.JLabel ti;
    private javax.swing.JLabel tidLabel;
    private javax.swing.JLabel tname;
    private javax.swing.JLabel to;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables

private int amount;
private int nm,qtys;
private int mid;
private int total;
private int qty,t;
private int available;
private int pid,p_id,tid;
private String dates; 

}
