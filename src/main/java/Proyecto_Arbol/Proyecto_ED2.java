/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto_Arbol;

import javax.swing.JOptionPane;

/**
 *
 * @author cobu-
 *
 */
public class Proyecto_ED2 extends javax.swing.JFrame {

    /**
     * Creates new form Proyecto_ED2
     */
    IArbolBusqueda<String, String> diccionario;

    public Proyecto_ED2() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 1080));
        getContentPane().setLayout(null);

        jButton1.setText("Crear Arbol");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(266, 71, 90, 24);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(368, 41, 647, 333);

        jButton2.setText("Mostrar Arbol");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(148, 71, 110, 24);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ÁRBOL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(457, 15, 467, 14);

        jButton4.setText("Buscar Palabra");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(140, 160, 130, 24);

        jButton5.setText("Agregar Palabra");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(50, 120, 130, 24);

        jButton6.setText("Eliminar Palabra");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(210, 120, 133, 24);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(368, 404, 647, 61);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(368, 492, 647, 57);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(368, 567, 647, 57);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(368, 642, 647, 56);

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jTextArea6.setAutoscrolls(false);
        jScrollPane6.setViewportView(jTextArea6);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(60, 230, 292, 80);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Definición");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 200, 144, 22);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DICCIONARIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(102, 24, 177, 35);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("RECORRIDO EN PRE ORDEN");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(61, 501, 268, 33);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("RECORRIDO POR NIVELES");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 660, 260, 33);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("RECORRIDO EN POST ORDEN");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 580, 290, 33);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("RECORRIDO IN ORDEN");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 420, 250, 33);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 350, 105, 30);

        jLabel8.setText("NÚMERO DE PALABRAS EN EL ÁRBOL");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 320, 218, 16);

        jButton3.setText("Vaciar árbol");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(39, 71, 100, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tipoArbol = JOptionPane.showInputDialog("Seleccionar el tipo de Arbol que desea usar : \n Arbol Binario de Busqueda = ABB \n"
                + " Arbol Balanceado = AVL \n Arbol de M-Vias = AMV \n Arbol B = AB", null);
        Integer orden;
        switch (tipoArbol) {
            case "ABB":
                diccionario = new ArbolBinario<>();
                break;
            case "AVL":
                diccionario = new ArbolAVL<>();
                break;
            case "AMV":
                String ordenMVias = JOptionPane.showInputDialog("indique el orden de su arbol ");
                orden = Integer.parseInt(ordenMVias);
                diccionario = new ArbolMVias<>(orden);
                break;
            case "AB":
                String ordenB = JOptionPane.showInputDialog("indique el orden de su árbol ");
                orden = Integer.parseInt(ordenB);
                diccionario = new ArbolB<>(orden);
                break;
            default:
                JOptionPane.showMessageDialog(null, "arbol no válido , creando Árbol Binario de Búsqueda");
                diccionario = new ArbolBinario<>();
                break;

        }
        this.cargarDiccioniario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (diccionario.esArbolVacio()) {
            JOptionPane.showMessageDialog(null, "El Árbol está vacío");
        }

        jTextArea1.setText(diccionario.toString()); // TODO add your handling code here:
        jTextArea2.setText(diccionario.recorridoInOrden().toString());
        jTextArea3.setText(diccionario.recorridoPreOrden().toString());
        jTextArea4.setText(diccionario.recorridoPostOrden().toString());
        jTextArea5.setText(diccionario.recorridoPorNiveles().toString());
        jTextField1.setText(Integer.toString(diccionario.size()));


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String claveABuscar = JOptionPane.showInputDialog("Escriba la palabra que desea buscar", null);
        String definicion = diccionario.contiene(claveABuscar);
        if (definicion == null) {
            JOptionPane.showMessageDialog(null, "La palabra no se encuentra en este diccionario");
            jTextArea6.setText("");
        } else {
            jTextArea6.setText(claveABuscar+".- "+ definicion);
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String claveAIngresar = JOptionPane.showInputDialog("Escriba la palabra que desea agregar", null);
        if (diccionario.contiene(claveAIngresar) != null) {
            JOptionPane.showMessageDialog(null, "La palabra que desea agregar ya se encuentra en el diccionario");
        } else {
        String definicionAIngresar = JOptionPane.showInputDialog("Escriba la definicion de : " + claveAIngresar, null);
        
        diccionario.insertar(claveAIngresar, definicionAIngresar);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String claveEliminar = JOptionPane.showInputDialog("Escriba la palabra que desea eliminar", null);

        if (diccionario.contiene(claveEliminar) == null) {
            JOptionPane.showMessageDialog(null, "La palabra que desea eliminar no se encuentra en el diccionario");
        } else {
            diccionario.eliminar(claveEliminar);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        diccionario.vaciar();        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Proyecto_ED2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyecto_ED2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyecto_ED2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto_ED2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyecto_ED2().setVisible(true);

            }
        });
    }

    public void cargarDiccioniario() {
        diccionario.insertar("juguete", "Objeto para jugar.");
        diccionario.insertar("fama", "Reputación, renombre o popularidad de una persona o cosa.");
        diccionario.insertar("gato", "Animal doméstico felino, conocido por su agilidad y por su carácter independiente.");
        diccionario.insertar("hombre", "Ser humano masculino.");
        diccionario.insertar("isla", "Porción de tierra rodeada de agua.");
        diccionario.insertar("jugar", "Realizar una actividad o un juego por diversión.");
        diccionario.insertar("luna", "Satélite natural de la Tierra, visible en la noche.");
        diccionario.insertar("noche", "Período del día en que no hay luz solar.");
        diccionario.insertar("abandonar", "Dejar a alguien o algo atrás, sin atender a lo que ocurre con ello.");
        diccionario.insertar("bajo", "Que está a una altura menor que lo habitual o esperado.");
        diccionario.insertar("cielo", "Espacio que se extiende sobre la Tierra, donde se encuentran el sol, las estrellas, etc.");
        diccionario.insertar("dado", "Objeto pequeño y generalmente cuadrado que se usa en juegos de azar.");
        diccionario.insertar("elefante", "Mamífero de gran tamaño, con trompa larga y colmillos de marfil.");
        diccionario.insertar("rojo", "Color que resulta de la mezcla de luz de largas longitudes de onda.");
        diccionario.insertar("silla", "Objeto para sentarse, con respaldo y asiento.");
        diccionario.insertar("tren", "Medio de transporte compuesto por una serie de vagones o coches, tirados por una locomotora.");
        diccionario.insertar("kilogramo", "Unidad de medida de masa, equivalente a 1,000 gramos.");
        diccionario.insertar("agua", "Líquido incoloro, inodoro e insípido, esencial para los seres vivos.");
        diccionario.insertar("banco", "Institución financiera que ofrece servicios de depósito y préstamo de dinero.");
        diccionario.insertar("cultura", "Conjunto de conocimientos, creencias, artes y costumbres que caracterizan a una sociedad.");
        diccionario.insertar("desarrollo", "Proceso de crecimiento y mejora en diversos aspectos, como la economía o la tecnología.");
        diccionario.insertar("futuro", "Tiempo que sucede al momento presente.");
        diccionario.insertar("inteligencia", "Capacidad para aprender, entender y tomar decisiones.");
        diccionario.insertar("justicia", "Concepto moral que se refiere a dar a cada uno lo que le corresponde.");
        diccionario.insertar("libertad", "Condición de quien no está sometido a ninguna autoridad o restricción.");
        diccionario.insertar("misterio", "Cosa desconocida o difícil de entender.");
        diccionario.insertar("origen", "Punto o circunstancia donde algo comienza.");
        diccionario.insertar("paz", "Estado de tranquilidad, ausencia de conflicto.");
        diccionario.insertar("risa", "Manifestación sonora y corporal de la alegría.");
        diccionario.insertar("sol", "Estrella que proporciona luz y calor a la Tierra.");
        diccionario.insertar("tiempo", "Duración o intervalo entre dos momentos.");
        diccionario.insertar("universo", "Todo lo que existe, incluyendo espacio, tiempo y materia.");
        diccionario.insertar("valor", "Cualidad de lo que se estima o se aprecia.");
        diccionario.insertar("xenofobia", "Miedo u odio hacia las personas de otros países o razas.");
        diccionario.insertar("yoga", "Disciplina física y mental originaria de la India, basada en la meditación.");
        diccionario.insertar("zafiro", "Piedra preciosa de color azul.");
        diccionario.insertar("abismo", "Gran profundidad o espacio vacío.");
        diccionario.insertar("barro", "Mezcla de tierra y agua que se endurece al secarse.");
        diccionario.insertar("cosecha", "Acción de recolectar los productos agrícolas.");
        diccionario.insertar("dieta", "Conjunto de alimentos y bebidas que consume una persona.");
        diccionario.insertar("espejo", "Objeto que refleja la luz, usado para ver la imagen de uno mismo.");
        diccionario.insertar("foco", "Dispositivo que emite luz.");
        diccionario.insertar("guitarra", "Instrumento musical de cuerdas.");
        diccionario.insertar("huevo", "Producto de la hembra de algunas especies animales, especialmente aves.");
        diccionario.insertar("instinto", "Comportamiento innato y natural de los seres vivos.");
        diccionario.insertar("juez", "Persona encargada de impartir justicia en un tribunal.");
        diccionario.insertar("kilo", "Unidad de medida de peso, equivalente a 1,000 gramos.");
        diccionario.insertar("luz", "Energía radiante que hace visibles los objetos.");
        diccionario.insertar("mesa", "Mueble plano, generalmente con cuatro patas, para comer, escribir o trabajar.");
        diccionario.insertar("nube", "Acumulación de vapor de agua suspendido en la atmósfera.");
        diccionario.insertar("orquesta", "Conjunto de músicos que tocan instrumentos diferentes.");
        diccionario.insertar("silencio", "Ausencia de ruido.");
        diccionario.insertar("yogur", "Producto lácteo fermentado.");
        diccionario.insertar("zona", "Área o espacio delimitado.");
        diccionario.insertar("aprecio", "Sentimiento de afecto y estima.");
        diccionario.insertar("escuela", "Institución educativa.");
        diccionario.insertar("gimnasio", "Lugar donde se practica ejercicio físico.");
        diccionario.insertar("largo", "De gran longitud.");
        diccionario.insertar("madera", "Material obtenido de los árboles.");
        diccionario.insertar("nave", "Vehículo que se desplaza por el aire o el espacio.");
        diccionario.insertar("orificio", "Abertura o agujero.");
        diccionario.insertar("piedra", "Material sólido que forma parte de la corteza terrestre.");
        diccionario.insertar("quinto", "Que ocupa la quinta posición.");
        diccionario.insertar("rasgo", "Característica o particularidad de una persona.");
        diccionario.insertar("taza", "Vaso pequeño con asa, usado para beber.");
        diccionario.insertar("viento", "Corriente de aire.");
        diccionario.insertar("zorro", "Animal mamífero de la familia de los cánidos.");
        diccionario.insertar("alumno", "Estudiante.");
        diccionario.insertar("blanco", "Color claro, opuesto al negro.");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
