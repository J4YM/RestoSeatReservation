/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.frontend;

import java.awt.event.ActionEvent;
import restaurantsystem.backend.ReserveBackend;

/**
 *
 * @author 
 */
public class View extends javax.swing.JFrame {

    private final ReserveBackend itemService;
    
    
    public View() {
        initComponents();
        this.itemService = new ReserveBackend();
        performFileRelatedTask();
    }
    
    //Total Counters
    public int res = 0;
    public int grand = 0;
    public int childinit = 0;
    public int adultinit = 0;
    
    public int inc() {
        int x = res + 1;
        res = x;
        return x;
    }
    
    public int grand(int x) {
        int y = grand + x;
        grand = y;
        return y;
    }
    
    public int childinit(int x) {
        int y = childinit + x;
        childinit = y;
        return y;
    }
    
    public int adultinit(int x) {
        int y = adultinit + x;
        adultinit = y;
        return y;
    }
    
    public int getgrand() {
        return grand;
    }
    
    public int getchild() {
        return childinit;
    }
    
    public int getadult() {
        return adultinit;
    }

    private void performFileRelatedTask() {
        StringBuilder fullnames = new StringBuilder();
        StringBuilder grandtotal = new StringBuilder();
        StringBuilder ctotal = new StringBuilder();
        StringBuilder atotal = new StringBuilder();
        
        
        itemService.getAll().forEach((item) -> {
            int grandinit = (Integer.parseInt(item.getChild())* 300) + (Integer.parseInt(item.getAdult())*500);
            grand(grandinit);
            childinit(Integer.parseInt(item.getChild()));
            adultinit(Integer.parseInt(item.getAdult()));
            fullnames.append(item.getName())
                    .append("\t")
                    .append(item.incResnum() + inc())
                    .append(" \t")
                    .append(item.getDaT())
                    .append(" \t")
                    .append(item.getAdult())
                    .append(" \t")
                    .append(item.getChild())
                    .append("\t")
                    .append("Php ")
                    .append(grandinit)
                    .append("\n")
                    .append("\n");
        });
        

        grandtotal.append(getgrand());
        ctotal.append(getchild());
        atotal.append(getadult());
        
        text.setText(fullnames.toString());
        subtotal.setText("Php" + grandtotal.toString());
        childtotal.setText(ctotal.toString());
        adulttotal.setText(atotal.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adulttotal = new javax.swing.JTextField();
        childtotal = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 204, 204));
        text.setColumns(20);
        text.setLineWrap(true);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        backButton.setText("Main Menu");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Reservation #");

        jLabel3.setText("Date");

        jLabel4.setText("Adults");

        jLabel5.setText("Children");

        jLabel6.setText("Total");

        jLabel7.setText("Subtotal");

        subtotal.setEditable(false);
        subtotal.setBackground(new java.awt.Color(255, 255, 255));
        subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalActionPerformed(evt);
            }
        });

        jLabel8.setText("# of Adults");

        jLabel9.setText("# of Children");

        adulttotal.setEditable(false);
        adulttotal.setBackground(new java.awt.Color(255, 255, 255));
        adulttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adulttotalActionPerformed(evt);
            }
        });

        childtotal.setEditable(false);
        childtotal.setBackground(new java.awt.Color(255, 255, 255));
        childtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childtotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(childtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(adulttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(adulttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(childtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        featuremenu im = new featuremenu();
        im.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalActionPerformed

    private void adulttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adulttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adulttotalActionPerformed

    private void childtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_childtotalActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adulttotal;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField childtotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {

    }
}
