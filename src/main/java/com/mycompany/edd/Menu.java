/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd;

import javax.swing.JOptionPane;

/**
 *
 * @author James Gramajo
 */
public class Menu extends javax.swing.JFrame {
    Gestor gst;
    /**
     * Creates new form Menu
     * @param gst
     */
    public Menu(Gestor gst) {
        initComponents();
        this.gst=gst;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GeneraImagenes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        GeneraAVLcapa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        GenerarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GeneraImagenes.setText("Generar Diagrama de Imagenes");
        GeneraImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneraImagenesActionPerformed(evt);
            }
        });

        jLabel1.setText("Poryecto EDD");

        GeneraAVLcapa.setText("Generar AVL Caps");
        GeneraAVLcapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneraAVLcapaActionPerformed(evt);
            }
        });

        jButton2.setText("Generar AVL Usuarios");

        GenerarImagen.setText("Generar Imagen ");
        GenerarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(GeneraImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(GeneraAVLcapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(160, 160, 160)
                        .addComponent(GenerarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GenerarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GeneraImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(GeneraAVLcapa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeneraImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneraImagenesActionPerformed
        // TODO add your handling code here:
        
        gst.generarImagenes();
    }//GEN-LAST:event_GeneraImagenesActionPerformed

    private void GenerarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarImagenActionPerformed
        // TODO add your handling code here:
        int idCapa;
        try{
        
        idCapa=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la capa a graficar"));
        gst.GraficarCapa(idCapa);
        } catch(Exception e){
            idCapa=Integer.parseInt(JOptionPane.showInputDialog("SOLO PUEDE INGRESAR NUMEROS\n"
                    + "Ingrese el ID de la imagen a graficar"));
        }
        
        
    }//GEN-LAST:event_GenerarImagenActionPerformed

    private void GeneraAVLcapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneraAVLcapaActionPerformed
        // TODO add your handling code here:
        //gst.b();
        gst.GenerarAvlCapa();
    }//GEN-LAST:event_GeneraAVLcapaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeneraAVLcapa;
    private javax.swing.JButton GeneraImagenes;
    private javax.swing.JButton GenerarImagen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
