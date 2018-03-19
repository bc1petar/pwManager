package passwordmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.DestroyFailedException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author ptrmr
 */
public class pManagerGUI extends javax.swing.JFrame {

    database db = new database();
    
    public pManagerGUI() {
        initComponents();
        setTitle("Password Manager");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        webService_TF = new javax.swing.JTextField();
        password_TF = new javax.swing.JTextField();
        username_TF = new javax.swing.JTextField();
        encSave_B = new javax.swing.JButton();
        key_PF = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        decSave_B = new javax.swing.JButton();
        genPW_B = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Web service:");

        jLabel3.setText("Password:");

        password_TF.setEditable(false);

        username_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_TFActionPerformed(evt);
            }
        });

        encSave_B.setText("Add and encrypt to file.aes");
        encSave_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encSave_BActionPerformed(evt);
            }
        });

        key_PF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key_PFActionPerformed(evt);
            }
        });

        jLabel4.setText("Key for enc/dec:");

        decSave_B.setText("Decrypt file.aes and save to db.txt");
        decSave_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decSave_BActionPerformed(evt);
            }
        });

        genPW_B.setText("Generate password");
        genPW_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genPW_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password_TF)
                    .addComponent(username_TF)
                    .addComponent(webService_TF)
                    .addComponent(key_PF))
                .addGap(29, 29, 29)
                .addComponent(genPW_B)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(encSave_B, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(decSave_B)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(webService_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genPW_B))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(key_PF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decSave_B)
                    .addComponent(encSave_B))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void key_PFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key_PFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_key_PFActionPerformed

    private void username_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_TFActionPerformed

    private void genPW_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genPW_BActionPerformed
        try {
            SecureRandom sr= SecureRandom.getInstance("SHA1PRNG");
            byte [] l = new byte[16];
            sr.setSeed(System.currentTimeMillis());
            sr.nextBytes(l);
            BASE64Encoder b64 = new BASE64Encoder();
            this.password_TF.setText(b64.encode(l));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_genPW_BActionPerformed

    private void encSave_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encSave_BActionPerformed
        db.addAcc(new accounts(this.webService_TF.getText(), this.username_TF.getText(), this.password_TF.getText()));
        try {
            if(this.key_PF.getText().length()>0){
                try {
                    db.saveAndEncrypt(this.key_PF.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadPaddingException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DestroyFailedException ex) {
                    Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Key field is empty");
            }
        } catch (IOException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.webService_TF.setText("");
        this.username_TF.setText("");
        this.password_TF.setText("");
    }//GEN-LAST:event_encSave_BActionPerformed

    private void decSave_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decSave_BActionPerformed

        try {
            this.db.decryptAndShow(this.key_PF.getText());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_decSave_BActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decSave_B;
    private javax.swing.JButton encSave_B;
    private javax.swing.JButton genPW_B;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField key_PF;
    private javax.swing.JTextField password_TF;
    private javax.swing.JTextField username_TF;
    private javax.swing.JTextField webService_TF;
    // End of variables declaration//GEN-END:variables
}
