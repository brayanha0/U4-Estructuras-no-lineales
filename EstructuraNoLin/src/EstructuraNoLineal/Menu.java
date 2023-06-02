package EstructuraNoLineal;

import ArbolBinario.ArbolBin;
import static ArbolBinario.ArbolBin.buscaDato;
import ArbolBinario.Nodito;
import EntradaSalida.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public static void mostrarMenuArbolBin() {
        ArbolBin<Integer> arbol = new ArbolBin<>();
        JFrame frame = new JFrame("Menú ArbolBin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(9, 1));

        JButton insertarButton = new JButton("1. Insertar");
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingresa dato: "));
                arbol.insertarArbol(dato);
            }
        });
        frame.add(insertarButton);

        JButton recorridosButton = new JButton("2. Recorridos");
        recorridosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String preOrden = arbol.preOrden(arbol.getRaiz());
                String inOrden1 = arbol.inOrden1(arbol.getRaiz());
                String inOrden2 = arbol.inOrden2(arbol.getRaiz());
                String posOrden = arbol.posOrden(arbol.getRaiz());

                String mensaje = "PreOrden: " + preOrden + "\n" +
                        "InOrden1: " + inOrden1 + "\n" +
                        "InOrden2: " + inOrden2 + "\n" +
                        "PosOrden: " + posOrden;

                JOptionPane.showMessageDialog(null, mensaje, "Recorridos", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(recorridosButton);

        JButton buscarButton = new JButton("3. Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbol.arbolVacio()) {
                    JOptionPane.showMessageDialog(null, "El árbol está vacío", "Buscar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingresa número a buscar: "));
                    boolean encontrado = buscaDato(arbol.getRaiz(), dato);
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, "El elemento " + dato + " existe en el árbol", "Buscar", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El elemento " + dato + " no existe en el árbol", "Buscar", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        frame.add(buscarButton);

        JButton hojasButton = new JButton("4. Hojas");
        hojasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbol.arbolVacio()) {
                    JOptionPane.showMessageDialog(null, "El árbol está vacío", "Hojas", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String hojas = arbol.imprimeNodosF(arbol.getRaiz());
                    JOptionPane.showMessageDialog(null, "Las hojas son: " + hojas, "Hojas", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.add(hojasButton);

        JButton alturaButton = new JButton("5. Altura");
        alturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbol.arbolVacio()) {
                    JOptionPane.showMessageDialog(null, "El árbol está vacío", "Altura", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int alturaArbol = arbol.alturaArbol(arbol.getRaiz());
                    JOptionPane.showMessageDialog(null, "La altura del árbol es: " + alturaArbol, "Altura", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.add(alturaButton);

        JButton interioresButton = new JButton("6. Interiores");
        interioresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbol.arbolVacio()) {
                    JOptionPane.showMessageDialog(null, "El árbol está vacío", "Interiores", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String interiores = arbol.buscInteriores(arbol.getRaiz());
                    JOptionPane.showMessageDialog(null, "Los nodos interiores son: " + interiores, "Interiores", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.add(interioresButton);

        JButton verButton = new JButton("7. Ver");
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbol.arbolVacio()) {
                    JOptionPane.showMessageDialog(null, "El árbol está vacío", "Ver", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    arbol.dibujarArbol();
                }
            }
        });
        frame.add(verButton);

        JButton salirButton = new JButton("8. Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tools.ImprimeMensaje("Saliendo del ejercicio");
                frame.dispose();
            }
        });
        frame.add(salirButton);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        mostrarMenuArbolBin();
    }
}
