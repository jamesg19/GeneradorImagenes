/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author James Gramajo
 */
public class Form extends javax.swing.JFrame {

    JFileChooser seleccionar = new JFileChooser();
    Gestor gst;
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    NumeroLinea numeroLinea;
    String fichero = null;
    public Form() {
        initComponents();
        numeroLinea = new NumeroLinea(jTextArea);
        jScrollPane1.setRowHeaderView(numeroLinea);
        gst=new Gestor();
    }

    
    public String AbrirArchivo(File fichero) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int a;
            while ((a = entrada.read()) != -1) {
                char caracter = (char) a;
                documento += caracter;
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        //jTextArea.setText(documento);
        return documento;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        RadioImagenes = new javax.swing.JRadioButton();
        RadioCapas = new javax.swing.JRadioButton();
        RadioUsuarios = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        respuestaArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextAreaMouseMoved(evt);
            }
        });
        jTextArea.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jTextAreaAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        RadioImagenes.setBackground(new java.awt.Color(153, 204, 255));
        RadioImagenes.setForeground(new java.awt.Color(0, 0, 0));
        RadioImagenes.setText("Imagenes");
        RadioImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioImagenesActionPerformed(evt);
            }
        });

        RadioCapas.setBackground(new java.awt.Color(153, 204, 255));
        RadioCapas.setForeground(new java.awt.Color(0, 0, 0));
        RadioCapas.setText("Capas");
        RadioCapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioCapasActionPerformed(evt);
            }
        });

        RadioUsuarios.setBackground(new java.awt.Color(153, 204, 255));
        RadioUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        RadioUsuarios.setText("Usuarios");
        RadioUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioUsuariosActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecciona el tipo de dato a guardar:");

        respuestaArea.setColumns(20);
        respuestaArea.setRows(5);
        jScrollPane2.setViewportView(respuestaArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(RadioCapas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(RadioUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RadioImagenes)
                            .addComponent(RadioCapas)
                            .addComponent(RadioUsuarios)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Menu");

        jMenuItem3.setText("Ir al Menu");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RadioImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioImagenesActionPerformed
        // TODO add your handling code here:
        RadioUsuarios.setSelected(false);
        RadioCapas.setSelected(false);
    }//GEN-LAST:event_RadioImagenesActionPerformed

    private void RadioUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioUsuariosActionPerformed
        // TODO add your handling code here:
        RadioImagenes.setSelected(false);
        RadioCapas.setSelected(false);
        
    }//GEN-LAST:event_RadioUsuariosActionPerformed

    private void RadioCapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioCapasActionPerformed
        // TODO add your handling code here:
        RadioImagenes.setSelected(false);
        RadioUsuarios.setSelected(false);
    }//GEN-LAST:event_RadioCapasActionPerformed

    private void jTextAreaAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTextAreaAncestorMoved
        // TODO add your handling code here:
        //jScrollPane1.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextAreaAncestorMoved

    private void jTextAreaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMouseMoved
        // TODO add your handling code here:
        jScrollPane1.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextAreaMouseMoved

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                    String documento = AbrirArchivo(archivo);
                    fichero = seleccionar.getSelectedFile() + "";
                    jTextArea.setText("");
                    jTextArea.setText(documento); 
            }
        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyTyped
        // TODO add your handling code here:
        jScrollPane1.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextAreaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (RadioImagenes.isSelected()) {
            if (!jTextArea.getText().equals(null)) {
                String codigo = jTextArea.getText();

                respuestaArea.setText("");
                gst.analizar(codigo, respuestaArea);

            } else {
                JOptionPane.showMessageDialog(null, "El campo de texto esta vacio");
            }
            
            
        } else if (RadioCapas.isSelected()) {
                String codigo = jTextArea.getText();

                respuestaArea.setText("");
                gst.analizarCapa(codigo, respuestaArea);
            
        } 
        
        
        else if(RadioUsuarios.isSelected()){
            String codigo = jTextArea.getText();

                respuestaArea.setText("");
                gst.analizarU(codigo, respuestaArea);
            
        } 
        
        
        else if(!RadioImagenes.isSelected()|| !RadioCapas.isSelected()|| !RadioUsuarios.isSelected()){
            JOptionPane.showMessageDialog(null, "Selecciona el tipo de dato a cargar\n"
                    + "Capas, imagenes, usuarios");
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Menu menu=new Menu(gst);
        menu.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioCapas;
    private javax.swing.JRadioButton RadioImagenes;
    private javax.swing.JRadioButton RadioUsuarios;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextArea respuestaArea;
    // End of variables declaration//GEN-END:variables
}
