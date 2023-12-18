/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementaryschoolmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ASUS
 */
public class ViewStudent extends javax.swing.JFrame {
    public DefaultTableModel data;
    private String fname;
    private int id;

    ArrayList<Integer> studentID = new ArrayList<Integer>();

    public ViewStudent() {
        initComponents();
        this.setLocationRelativeTo(null);
        data = (DefaultTableModel) table.getModel();

     

        JTableHeader header = table.getTableHeader();//header is an object of JTableHEader class
        header.setFont(new Font("Arial", Font.BOLD, 16));
        table.setRowHeight(40);
        table.setGridColor(Color.RED);
        table.setShowGrid(true);
        table.setFont(new Font("Arial", Font.BOLD, 14));
        this.showIDs();
        this.showStudentRecords();
    }

    public void showIDs() {// method used to add the student names to the arrayList
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("Select * from student_details");
            while (r.next()) {
            
               int id = r.getInt(1);
               studentID.add(id);
            }
            selectionSort();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectionSort() {// method implemeted to sort student IDS in ascending order
        int temp1 =0;
        for (int i = 0; i < (studentID.size() - 1); i++) {
            for (int j = i + 1; j < studentID.size(); j++) {
                if (studentID.get(i).compareTo(studentID.get(j)) > 0) {
                    temp1 = studentID.get(i);
                    studentID.set(i, studentID.get(j));
                    studentID.set(j, temp1);
                }
            }
        }

        for (int i = 0; i < studentID.size() - 1; i++) {
  
            studentID_combo.addItem(studentID.get(i));// using methods like  .get of the arrayList to make code easier and more understandable
        }


    }
public int getEnglishScore(int sid){
     int eng_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from engsubjectdetails where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("participationscore");
                int criteria2= r.getInt("homeworkscore");
                int criteria3=r.getInt("readingscore");
                int criteria4=r.getInt("speakingscore");
                eng_overall=(int)((criteria1+criteria2+criteria3+criteria4));
              
                 
                  }
                

        } catch (Exception e) {
            e.printStackTrace();
        }
     return eng_overall;
}
public int getCompScore(int sid){
     int comp_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from compsubject_details where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("labActivityScore");
                int criteria2= r.getInt("homeworkscore");
              
                comp_overall=(int)((criteria1+criteria2));
                
              
                 
                  }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return comp_overall;
}
public int getGkScore(int sid){
     int gk_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from  gksubjectdetails where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("ParticipationScore");
                int criteria2= r.getInt("homeworkScore");
                int criteria3= r.getInt("quizScore");
                gk_overall=(int)((criteria1+criteria2+criteria3));
                
              
                 
                  }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return gk_overall;
}
public int getHindiScore(int sid){
     int hindi_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from  hindisubjectdetails where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("ParticipationScore");
                int criteria2= r.getInt("homeworkScore");
                int criteria3= r.getInt("speakingScore");
                int criteria4= r.getInt("readingScore");
                int criteria5= r.getInt("listeningScore");
                hindi_overall=(int)((criteria1+criteria2+criteria3+criteria4+criteria5));
             
                 
                  }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return hindi_overall;
}
public int getMathScore(int sid){
     int math_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from  mathsubject_details where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("ParticipationScore");
                int criteria2= r.getInt("homeworkScore");
                int criteria3= r.getInt("testScore");
                int criteria4= r.getInt("doubtsScore");
                int criteria5= r.getInt("conceptUnderstanding");
                math_overall=(int)((criteria1+criteria2+criteria3+criteria4+criteria5));
               
                 
                  }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return math_overall;
}
public int getScienceScore(int sid){
     int science_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from sciencessubjectdetails where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("ParticipationScore");
                int criteria2= r.getInt("homeworkScore");
                int criteria3= r.getInt("testScore");
                int criteria4= r.getInt("doubtsScore");
                int criteria5= r.getInt("conceptUnderstanding");
                science_overall=(int)((criteria1+criteria2+criteria3+criteria4+criteria5));
                
                 
                  }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return science_overall;
}
public int getSstScore(int sid){
     int sst_overall=0;
     
     try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from sstsubjectdetails where studentid="+sid);
            while (r.next()) {
                int criteria1=r.getInt("ParticipationScore");
                int criteria2= r.getInt("homeworkScore");
                int criteria3= r.getInt("testScore");
                
                sst_overall=(int)((criteria1+criteria2+criteria3));
               
                 
                  }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return sst_overall;
}



    public void showStudentRecords() {
        data = (DefaultTableModel) table.getModel();
        data.setRowCount(0);
        try {
            Class.forName("java.sql.DriverManager");                
            Connection con = Db_Connection.connectDbMethod(); 
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {
                int id=r.getInt(1);
                String fname = r.getString(2);
                String lname = r.getString(3);
                String classc = r.getString(4);
                int homeroomScore = r.getInt(8);
                int engScore=this.getEnglishScore(id);
                int compScore = this.getCompScore(id);
                int gkScore = this.getGkScore(id);
                int hindiScore = this.getHindiScore(id);
                int mathScore = this.getMathScore(id);
                int scienceScore = this.getScienceScore(id);
                int sstScore = this.getSstScore(id);
                int combinedOverAllScore = (int)((homeroomScore+engScore+compScore+gkScore+hindiScore+mathScore+scienceScore+sstScore));

                
                //same code for other subjects
                  data.addRow(new Object[]{id,classc,fname,lname,homeroomScore,engScore,hindiScore,mathScore,sstScore,scienceScore,gkScore,compScore,combinedOverAllScore});
                  
              
            }

        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        back_btn1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        studentID_combo = new javax.swing.JComboBox();
        viewAll_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Elementary School Manager");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1141, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Class", "First Name", "Last Name", "HomeRoom Score", "English Score", "Hindi Score", "Math Score", "SST Score", "Sciences Score", "GK Score", "ICT Score", "Overall Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        back_btn1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        back_btn1.setText("Back");
        back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btn1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Student"));

        studentID_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentID_comboActionPerformed(evt);
            }
        });

        viewAll_btn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        viewAll_btn.setText("View All");
        viewAll_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAll_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentID_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(viewAll_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentID_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewAll_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(504, 504, 504)
                                .addComponent(back_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1645, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(back_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btn1ActionPerformed
        // TODO add your handling code here:
       CoordinatorDashboard db=new CoordinatorDashboard();
       db.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_back_btn1ActionPerformed

    private void viewAll_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAll_btnActionPerformed
        // TODO add your handling code here:
        showStudentRecords();
    }//GEN-LAST:event_viewAll_btnActionPerformed
public void clearTable()// to clear previous values shown in table
{
    DefaultTableModel dm = (DefaultTableModel) table.getModel();
    dm.getDataVector().removeAllElements();
    revalidate();
}
    private void studentID_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentID_comboActionPerformed
      
     int id = (int) studentID_combo.getSelectedItem();
     clearTable();// called to empty previous values
     
      try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from student_details where id ="+id);
            while (r.next()) {
                
                String fname = r.getString(2);
                String lname = r.getString(3);
                String classc = r.getString(4);
                int homeroomScore = r.getInt(8);
                int engScore=this.getEnglishScore(id);
                int compScore = this.getCompScore(id);
                int gkScore = this.getGkScore(id);
                int hindiScore = this.getHindiScore(id);
                int mathScore = this.getMathScore(id);
                int scienceScore = this.getScienceScore(id);
                int sstScore = this.getSstScore(id);
                int overallScore = (int)((homeroomScore+engScore+compScore+gkScore+hindiScore+mathScore+scienceScore+sstScore)/8*5);
                 
                data.addRow(new Object[]{id,classc,fname,lname,homeroomScore,engScore,hindiScore,mathScore,sstScore,scienceScore,gkScore,compScore,overallScore});
                 
                  }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }//GEN-LAST:event_studentID_comboActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox studentID_combo;
    private javax.swing.JTable table;
    private javax.swing.JButton viewAll_btn;
    // End of variables declaration//GEN-END:variables
}
