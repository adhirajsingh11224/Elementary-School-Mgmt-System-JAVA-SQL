/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementaryschoolmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class YearlyAwardList extends javax.swing.JFrame {

    public DefaultTableModel data;
    private String fname;
    private int id;

    ArrayList<Integer> IDinComboList = new ArrayList<Integer>(); // used to store the id's of those students that are a part of class selected in combo box

    /**
     * Creates new form YearlyAwardList
     */
    public YearlyAwardList() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        class_combo = new javax.swing.JComboBox();
        back = new javax.swing.JButton();
        add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Yearly Awards List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CS Topper", "English Topper", "GK Topper", "Hindi Topper", "Math Topper", "Science Topper", "SST Topper", "All Rounder", "Commendable Effort"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 286, 1303, 46));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evaluate By Class", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        class_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1A", "1B", "1C", "1D", "2A", "2B", "2C", "2D", "3A", "3B", "3C", "3D", "4A", "4B", "4C", "4D", "5A", "5B", "5C", "5D" }));
        class_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(class_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(class_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, -1, -1));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 389, 108, 37));

        add.setText("Update");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 389, 108, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int computersTopper() {// to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from compsubject_details where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;

    }

    public int englishTopper() {
       // to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from engsubjectdetails where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;

    }

    public int gkTopper() {
        // to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from gksubjectdetails where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;

    }

    public int hindiTopper() {
        // to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from hindisubjectdetails where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;
    }

    public int mathTopper() {
             // to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from mathsubject_details where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;  

    }

    public int scienceTopper() {
                // to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from  sciencessubjectdetails where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;  

    }

    public int sstTopper() {
                  // to calculate who scored the highest in this subject
        //where class = combo box class, fetches id associated with the score and displays name and id
        int topperScore = 0;
        int topperID = 0;
        int checkID; // to check if student is part of the class in combo box
        String checkClass; //to check if student is part of the class in combo box

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();

            ResultSet r = st.executeQuery("select * from student_details");
            while (r.next()) {// going through sql table to see where class in combo matches with class of student
                checkID = r.getInt(1);
                checkClass = r.getString(4);

                if (checkClass.equals(class_combo.getSelectedItem().toString())) {
                    IDinComboList.add(checkID);// ids in combo selected class stored
                }
            }

            for (int i = 0; i < IDinComboList.size() - 1; i++) {
                ResultSet a = st.executeQuery("select * from  sstsubjectdetails where studentID=" + IDinComboList.get(i));//computers topper 
                while (a.next()) {

                    int score = a.getInt("Overall_score");
                    if (score > topperScore) {
                        topperScore = score;
                        topperID = IDinComboList.get(i);

                    }
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topperID;  

    }

    public void showStudentRecords() {
        data = (DefaultTableModel) table.getModel();
        data.setRowCount(0);
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = Db_Connection.connectDbMethod();
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select * from student_details where class='" + class_combo.getSelectedItem()+ "'");
            while (r.next()) {
                int CSid = computersTopper();
                int ENGid = englishTopper();
                int GKid = gkTopper();
                int HINDIid = hindiTopper();
                int MATHid = mathTopper();
                int SCIid = scienceTopper();
                int SSTid = sstTopper();
                int Ar = allRounder();

              

         
       data.addRow(new Object[]{CSid,ENGid,GKid,HINDIid,MATHid,SCIid,SSTid,Ar});

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int allRounder(){ // checks if one topper is also topping all other subjects i.e. the all rounder
        int IDCHECK = computersTopper();
        int allrounderID = 0; // if the allrounder is 0 then there is no all rounder in the class
        if(IDCHECK == computersTopper() && IDCHECK == englishTopper() && IDCHECK == gkTopper() && IDCHECK == hindiTopper() && IDCHECK == mathTopper() && IDCHECK == scienceTopper() && IDCHECK == sstTopper()  )
        {
            allrounderID = IDCHECK;
        }
        
        return allrounderID;
    }

    public void getAwards() {
        showStudentRecords();
        allRounder();
        System.out.println(computersTopper());
        System.out.println(englishTopper());
        System.out.println(gkTopper());
        System.out.println(hindiTopper());
        System.out.println(mathTopper());
        System.out.println(scienceTopper());
        System.out.println(sstTopper());

    }


    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        CoordinatorDashboard db = new CoordinatorDashboard();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void class_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_comboActionPerformed
        getAwards();
       
       


    }//GEN-LAST:event_class_comboActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(this, "Commendable Effort Added");
    }//GEN-LAST:event_addActionPerformed

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
            java.util.logging.Logger.getLogger(YearlyAwardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YearlyAwardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YearlyAwardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YearlyAwardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YearlyAwardList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JComboBox class_combo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
