package elementaryschoolmanagementsystem;

import javax.swing.JOptionPane;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class ChangePassword extends javax.swing.JFrame implements DBUpdateInterface {
    private String newPassword,currentPassword;
    private String confirmPw;
    

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        done_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        oldpas_txt = new javax.swing.JPasswordField();
        pas_txt = new javax.swing.JPasswordField();
        confirm_txt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Change Password For Teacher Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel2.setText("New Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel3.setText("Confirm Password");

        back_btn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        done_btn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        done_btn.setText("Done");
        done_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setText("Current Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pas_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(confirm_txt)
                            .addComponent(oldpas_txt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(done_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldpas_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pas_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(done_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
       ClassTeacherDashboard db=new ClassTeacherDashboard();
       db.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void done_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_btnActionPerformed
        // TODO add your handling code here:
        if(this.validation()) 
            updateRecords();
    }//GEN-LAST:event_done_btnActionPerformed
    public boolean validation()
    {
        boolean flag=false;
          if(oldpas_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Current Password  field cannot be left blank");
            flag=false;
        }
        else
        {
            try{
                Class.forName("java.sql.DriverManager");
                Connection con = Db_Connection.connectDbMethod(); 
                Statement st=con.createStatement(); 
                        //association relationship between LoginPage and ChangePassword as accessing static property of LoginPage
                ResultSet rs=st.executeQuery("select * from logindetails where id="+LoginPage.id+" and password='"+oldpas_txt.getText()+"'");
                if(rs.next())
                        {
                             currentPassword=oldpas_txt.getText(); //converting String input into integer
                             flag=true;
                        }
                        else{
                            JOptionPane.showMessageDialog(this," Invalid current Password");
                            flag=false;
                            
                        }
                 
             }catch(Exception e){
                 e.printStackTrace();
             }
         
        }
        if(this.pas_txt.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Password  field cannot be left blank");
            flag=false;
        }
        else
        {
            if(!pas_txt.getText().equals(confirm_txt.getText())){
                JOptionPane.showMessageDialog(this,"confirmation password doesn't match");
                flag=false;
            }
            else{
            this.newPassword=this.pas_txt.getText(); //converting String input into integer
            flag=true;
            }
            
        }
        
      
        return flag;
    }
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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JPasswordField confirm_txt;
    private javax.swing.JButton done_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField oldpas_txt;
    private javax.swing.JPasswordField pas_txt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateRecords() {
          
        int input = JOptionPane.showConfirmDialog(null,"Do you want to Update your password ?", "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);
        if(input==0) {
                try{
                     Class.forName("java.sql.DriverManager");
                        Connection con = Db_Connection.connectDbMethod(); 
                        Statement st=con.createStatement(); 
                        ResultSet r=st.executeQuery("select * from logindetails");
                        int y=0;
                        while(r.next()){
                            if(LoginPage.id== r.getInt("id")) 
                               y=st.executeUpdate("update logindetails set password ='"+this.newPassword+"' where  id = "+LoginPage.id+" " );
                        }
                
                                                
                      
                         if(y>0 ) {
                          javax.swing.JOptionPane.showMessageDialog(this,"password has been updated");
                          ClassTeacherDashboard ah=new ClassTeacherDashboard();
                          ah.setVisible(true);
                          this.dispose();
                           } 
                        }catch(Exception e) {
                           
                          e.printStackTrace(); }
                          }    
            
       }

}
