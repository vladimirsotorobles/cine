/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas;
    import java.sql.DriverManager; 
    import java.sql.Connection; 
    import java.sql.ResultSet; 
    import java.sql.SQLException;
    import java.sql.Statement; 
    import javax.swing.JOptionPane;

/**
 *
 * @author equipo hp
 */
public class Pelicula extends javax.swing.JFrame {
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs; 
    
    
    public void Conectar(){
         try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/netflix","root","utectulancingo");                     
            st=conexion.createStatement(); 

            rs=st.executeQuery("Select * from peliculas");             

            rs.next(); //recored todos los registros
            this.jTextField2_ID_PELICULA.setText(rs.getString("ID_PELICULA")); 
            this.jTextField2_NOMBRE.setText(rs.getString("NOMBRE"));                         
            this.jTextField3_GENERO.setText(rs.getString("GENERO"));             
            this.jTextField4_FORMATO.setText(rs.getString("FORMATO"));
            this.jTextField5_DURACION.setText(rs.getString("DURACION")); 

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error 1"+err.getMessage()); 
        } 

    } 
    
///siguienteRegistro*****************************************************************************************************   
     private void siguienteRegistro(){    
    try{             
        if (rs.isLast() == false) {
                rs.next();
            this.jTextField2_ID_PELICULA.setText(rs.getString("ID_PELICULA")); 
            this.jTextField2_NOMBRE.setText(rs.getString("NOMBRE"));                         
            this.jTextField3_GENERO.setText(rs.getString("GENERO"));             
            this.jTextField4_FORMATO.setText(rs.getString("FORMATO"));
            this.jTextField5_DURACION.setText(rs.getString("DURACION")); 
                
        }         
    }catch(Exception err) {            
        JOptionPane.showMessageDialog(null,"Error 2"+err.getMessage());         
    }     
}
     
//anteriorRegistro*********************************************************************************************************  
     private void anteriorRegistro(){    
    try{             
        if (rs.isFirst() == false) {
                rs.previous();
            this.jTextField2_ID_PELICULA.setText(rs.getString("ID_PELICULA")); 
            this.jTextField2_NOMBRE.setText(rs.getString("NOMBRE"));                         
            this.jTextField3_GENERO.setText(rs.getString("GENERO"));             
            this.jTextField4_FORMATO.setText(rs.getString("FORMATO"));
            this.jTextField5_DURACION.setText(rs.getString("DURACION")); 
            
        }         
    }catch(Exception err) {            
        JOptionPane.showMessageDialog(null,"Error 3"+err.getMessage());         
    }     
} 
     
///primerRegistro**********************************************************************************************************
     private void primerRegistro(){    
    try{             
        if (rs.isFirst() == false) {
        rs.first(); 
          this.jTextField2_ID_PELICULA.setText(rs.getString("ID_PELICULA")); 
            this.jTextField2_NOMBRE.setText(rs.getString("NOMBRE"));                         
            this.jTextField3_GENERO.setText(rs.getString("GENERO"));             
            this.jTextField4_FORMATO.setText(rs.getString("FORMATO"));
            this.jTextField5_DURACION.setText(rs.getString("DURACION"));
            
        }         
    }catch(Exception err) {            
        JOptionPane.showMessageDialog(null,"Error 4"+err.getMessage());         
    }     
} 
     
///ultimoRegistro*************************************************************************************************************     
     private void ultimoRegistro(){    
    try{             
        if (rs.isLast() == false) {
        rs.last();
             this.jTextField2_ID_PELICULA.setText(rs.getString("ID_PELICULA")); 
            this.jTextField2_NOMBRE.setText(rs.getString("NOMBRE"));                         
            this.jTextField3_GENERO.setText(rs.getString("GENERO"));             
            this.jTextField4_FORMATO.setText(rs.getString("FORMATO"));
            this.jTextField5_DURACION.setText(rs.getString("DURACION"));         
        }         
    }catch(Exception err) {            
        JOptionPane.showMessageDialog(null,"Error 5"+err.getMessage());         
    }     
} 
     
     
     private void guadarRegistro() {        
       try{ 
           
            String NOMBRE=this.jTextField2_NOMBRE.getText(); 
            String GENERO=this.jTextField3_GENERO.getText(); 
            String FORMATO=this.jTextField4_FORMATO.getText(); 
            String DURACION=this.jTextField5_DURACION.getText();

            st.executeUpdate("Insert into PELICULAS(NOMBRE,GENERO,FORMATO,DURACION)"+" values ('"+ NOMBRE +"','"+GENERO+"','"+FORMATO+"','"+DURACION+"');"); 
            rs=st.executeQuery("Select * from peliculas");
            this.primerRegistro();

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error 6"+err.getMessage()); 
        } 

    } 
     
     private void borrarRegistro(){
        try{ 
            String NOMBRE = this.jTextField2_NOMBRE.getText(); 
                        
           st.executeUpdate("DELETE from PELICULAS where NOMBRE='"+NOMBRE+"';"); 
           this.Conectar();
           this.primerRegistro();
           
           
       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error 7"+err.getMessage()); 
        } 
        

    }
     
     
     private void modificarRegistro(){
            try{
                String ID_PELICULA=this.jTextField2_ID_PELICULA.getText();
                String NOMBRE=this.jTextField2_NOMBRE.getText(); 
                String GENERO=this.jTextField3_GENERO.getText(); 
                String FORMATO=this.jTextField4_FORMATO.getText(); 
                String DURACION=this.jTextField5_DURACION.getText();
                               
                  st.executeUpdate("update PELICULAS set ID_PELICULA='"+ID_PELICULA+"', NOMBRE='"+ NOMBRE+"',GENERO='"+GENERO+"',FORMATO='"+FORMATO+"',DURACION='"+DURACION+"' where ID_PELICULA='"+ID_PELICULA+"'");
                  this.Conectar();
                  this.primerRegistro();       
              }
              catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error 8"+err.getMessage()); 
        } 
    } 
     
     private void nuevoRegistro(){
        jTextField2_NOMBRE.setText("");
        jTextField3_GENERO.setText("");
        jTextField4_FORMATO.setText("");
        jTextField5_DURACION.setText("");
        
    }

    /**
     * Creates new form Pelicula
     */
    public Pelicula() {
        initComponents();
        Conectar();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2_NOMBRE = new javax.swing.JTextField();
        jTextField3_GENERO = new javax.swing.JTextField();
        jTextField4_FORMATO = new javax.swing.JTextField();
        jTextField5_DURACION = new javax.swing.JTextField();
        jButton_siguiente = new javax.swing.JButton();
        jButton_ultimo = new javax.swing.JButton();
        jButton_primero = new javax.swing.JButton();
        jButton1_Nuevo = new javax.swing.JButton();
        jButton2_Guardar = new javax.swing.JButton();
        jButton3_Borrar = new javax.swing.JButton();
        jButton_anterior = new javax.swing.JButton();
        jButton1_MODIFICAR = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel10 = new javax.swing.JLabel();
        jButton1_SALIR = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField2_ID_PELICULA = new javax.swing.JTextField();

        jLabel1.setText("id_pelicula");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel12.setText("ID_PELICULA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("nombre");

        jLabel3.setText("genero");

        jLabel4.setText("formato");

        jLabel5.setText("duracion");

        jButton_siguiente.setText(">>");
        jButton_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_siguienteMouseClicked(evt);
            }
        });

        jButton_ultimo.setText(">|");
        jButton_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ultimoMouseClicked(evt);
            }
        });

        jButton_primero.setText("|<");
        jButton_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_primeroMouseClicked(evt);
            }
        });

        jButton1_Nuevo.setText("Nuevo");
        jButton1_Nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1_NuevoMouseClicked(evt);
            }
        });

        jButton2_Guardar.setText("Guardar");
        jButton2_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2_GuardarMouseClicked(evt);
            }
        });

        jButton3_Borrar.setText("Borrar");
        jButton3_Borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3_BorrarMouseClicked(evt);
            }
        });

        jButton_anterior.setText("<<");
        jButton_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_anteriorMouseClicked(evt);
            }
        });

        jButton1_MODIFICAR.setText("MODIFICAR");
        jButton1_MODIFICAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1_MODIFICARMouseClicked(evt);
            }
        });
        jButton1_MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_MODIFICARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jLabel10.setText("            PELICULAS");

        jButton1_SALIR.setText("SALIR");
        jButton1_SALIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1_SALIRMouseClicked(evt);
            }
        });

        jTextField2_ID_PELICULA.setEnabled(false);
        jTextField2_ID_PELICULA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_ID_PELICULAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2_ID_PELICULA, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(jButton1_SALIR)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_primero)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton_siguiente)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_ultimo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5_DURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2_NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3_GENERO, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4_FORMATO, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1_Nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2_Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3_Borrar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1_MODIFICAR)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2_ID_PELICULA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2_NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3_GENERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4_FORMATO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5_DURACION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_primero)
                    .addComponent(jButton_anterior)
                    .addComponent(jButton_siguiente)
                    .addComponent(jButton_ultimo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1_Nuevo)
                    .addComponent(jButton2_Guardar)
                    .addComponent(jButton3_Borrar)
                    .addComponent(jButton1_MODIFICAR))
                .addGap(61, 61, 61)
                .addComponent(jButton1_SALIR)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_siguienteMouseClicked
        siguienteRegistro();
    }//GEN-LAST:event_jButton_siguienteMouseClicked

    private void jButton_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ultimoMouseClicked
        ultimoRegistro();
    }//GEN-LAST:event_jButton_ultimoMouseClicked

    private void jButton_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_primeroMouseClicked
        primerRegistro();
    }//GEN-LAST:event_jButton_primeroMouseClicked

    private void jButton1_NuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_NuevoMouseClicked
        // TODO add your handling code here:
        nuevoRegistro();
    }//GEN-LAST:event_jButton1_NuevoMouseClicked

    private void jButton2_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_GuardarMouseClicked
        // TODO add your handling code here:
        guadarRegistro();
    }//GEN-LAST:event_jButton2_GuardarMouseClicked

    private void jButton3_BorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3_BorrarMouseClicked
        // TODO add your handling code here:
        borrarRegistro();
    }//GEN-LAST:event_jButton3_BorrarMouseClicked

    private void jButton_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_anteriorMouseClicked
        anteriorRegistro();
    }//GEN-LAST:event_jButton_anteriorMouseClicked

    private void jButton1_MODIFICARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_MODIFICARMouseClicked
        // TODO add your handling code here:
        modificarRegistro();
    }//GEN-LAST:event_jButton1_MODIFICARMouseClicked

    private void jButton1_SALIRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_SALIRMouseClicked
        // TODO add your handling code here:
         Menu contra=new Menu();
contra.show();
dispose();
    }//GEN-LAST:event_jButton1_SALIRMouseClicked

    private void jTextField2_ID_PELICULAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_ID_PELICULAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_ID_PELICULAActionPerformed

    private void jButton1_MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_MODIFICARActionPerformed
        modificarRegistro();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1_MODIFICARActionPerformed

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
            java.util.logging.Logger.getLogger(Pelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pelicula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_MODIFICAR;
    private javax.swing.JButton jButton1_Nuevo;
    private javax.swing.JButton jButton1_SALIR;
    private javax.swing.JButton jButton2_Guardar;
    private javax.swing.JButton jButton3_Borrar;
    private javax.swing.JButton jButton_anterior;
    private javax.swing.JButton jButton_primero;
    private javax.swing.JButton jButton_siguiente;
    private javax.swing.JButton jButton_ultimo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2_ID_PELICULA;
    private javax.swing.JTextField jTextField2_NOMBRE;
    private javax.swing.JTextField jTextField3_GENERO;
    private javax.swing.JTextField jTextField4_FORMATO;
    private javax.swing.JTextField jTextField5_DURACION;
    // End of variables declaration//GEN-END:variables
}
