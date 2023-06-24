/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Railway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Train_Details extends javax.swing.JFrame {

    /**
     * Creates new form Train_Details
     */
    public Train_Details() {
        initComponents();
        Connect();
        train_detail();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {

         try {
             
             String url = "jdbc:mysql://localhost:3306/railway_reservation_system?zeroDateTimeBehavior=convertToNull";
String user = "root";
String password = "swathi0127";
Properties props = new Properties();
props.setProperty("zeroDateTimeBehavior", "convertToNull");

 con = DriverManager.getConnection(url, user, password);
 System.out.println("connection success");

                  } catch(Exception e){ 
            System.out.println(e);
    }
    
            
    }
    
    
    public void train_detail()
    {
        
        try {
            pst=con.prepareStatement("select * from train");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c=rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i=0;i<=c;i++)
                {
                    v.add(rs.getString("trainId"));
                    v.add(rs.getString("trainName"));
                    v.add(rs.getString("startPlace"));
                    v.add(rs.getString("destinationPlace"));
                    v.add(rs.getString("Price"));
                }
                
                d.addRow(v);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Train_Details.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        tname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        splace = new javax.swing.JTextField();
        dplace = new javax.swing.JTextField();
        tname1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(182, 176, 176));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel2.setText("Train Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel2)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(440, 30, 590, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Train Name", "Start Place", "Destination Place", "Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(730, 140, 600, 402);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 200, 60, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("Train Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 250, 140, 28);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 0));
        jLabel5.setText("Start Place");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 310, 140, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setText("Destination Place");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 350, 190, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 0));
        jLabel7.setText("Price");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 400, 90, 30);

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id);
        id.setBounds(430, 190, 150, 30);
        getContentPane().add(tname);
        tname.setBounds(430, 250, 150, 30);

        jButton1.setBackground(new java.awt.Color(51, 51, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 580, 100, 60);

        jButton2.setBackground(new java.awt.Color(51, 51, 0));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 580, 130, 60);

        jButton3.setBackground(new java.awt.Color(51, 51, 0));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(530, 580, 110, 60);
        getContentPane().add(price);
        price.setBounds(430, 400, 150, 30);
        getContentPane().add(splace);
        splace.setBounds(430, 300, 150, 30);
        getContentPane().add(dplace);
        dplace.setBounds(430, 350, 150, 30);
        getContentPane().add(tname1);
        tname1.setBounds(430, 250, 150, 30);

        jButton4.setBackground(new java.awt.Color(51, 51, 0));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(690, 580, 110, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rahul Vijayan\\Documents\\NetBeansProjects\\Railway Reservation System\\images\\4.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1380, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String ID = id.getText();
        String TrainName = tname.getText();
        String StartPlace = splace.getText();
        String DestinationPlace = dplace.getText();
        String Price = price.getText();
        
        try {
            pst = con.prepareStatement("insert into train(trainId,trainName,startPlace,destinationPlace,Price)values(?,?,?,?,?)");
            
            pst.setString(1, ID);
            pst.setString(2, TrainName);
            pst.setString(3, StartPlace);
            pst.setString(4, DestinationPlace);
            pst.setString(5, Price);
            
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Record Added Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Record Adding Failed");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Train_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
        DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
        
        int selectIndex = jTable1.getSelectedRow();
        
        id.setText(d.getValueAt(selectIndex, 0).toString());
        tname.setText(d.getValueAt(selectIndex, 1).toString());
        splace.setText(d.getValueAt(selectIndex, 2).toString());
        dplace.setText(d.getValueAt(selectIndex, 3).toString());
        price.setText(d.getValueAt(selectIndex, 4).toString());
        
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String ID = id.getText();
        String TrainName = tname.getText();
        String StartPlace = splace.getText();
        String DestinationPlace = dplace.getText();
        String Price = price.getText();
        
        try {
            pst = con.prepareStatement("update train set trainName=?, startPlace=?, destinationPlace=?, Price=? where trainId=?");
            
           
            pst.setString(1, TrainName);
            pst.setString(2, StartPlace);
            pst.setString(3, DestinationPlace);
            pst.setString(4, Price);
            pst.setString(5, ID);
            
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Record Updated Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Record Updation Failed");
            }
            
            id.setText("");
            tname.setText("");
            splace.setText("");
            dplace.setText("");
            price.setText("");
            id.requestFocus();
            train_detail();
            jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Train_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String ID = id.getText();
        
        try {
            pst = con.prepareStatement("delete from train where trainId=?");
            
            pst.setString(1, ID);
            
            
            int k = pst.executeUpdate();
            
            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Record Deletion Failed");
            }
            
            id.setText("");
            tname.setText("");
            splace.setText("");
            dplace.setText("");
            price.setText("");
            id.requestFocus();
            train_detail();
            jButton1.setEnabled(true);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Train_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        train_detail();
        jButton1.setEnabled(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Train_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Train_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Train_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Train_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Train_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dplace;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField splace;
    private javax.swing.JTextField tname;
    private javax.swing.JTextField tname1;
    // End of variables declaration//GEN-END:variables
}
