import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class vehiculos{
    private JPanel vehiculos;
    private JTextField marca;
    private JTextField color;
    private JTextField anio;
    private JButton guardarButton;
    private JButton mostrarButton;
    private JButton siguienteButton;
    private JButton anteriorButton;

    public vehiculos(){
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcax = marca.getText();
                int aniox = Integer.parseInt(anio.getText());
                String colorx = color.getText();
                guardarDatos(marcax, aniox, colorx);
                //System.out.println("texto: " + marcax + ", anio: " + aniox + ", color: " + colorx);

            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(marca.getText());
                System.out.println(anio.getText());
                System.out.println(color.getText());
            }
        });
    }
    private void guardarDatos(String marcax, int aniox, String colorx) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("datos.txt", true));
            writer.write("Marca: " + marcax + ", Año: " + aniox + ", Color: " + colorx);
            writer.newLine();
            writer.close();
            System.out.println("Datos guardados en datos.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vehiculos");
        frame.setContentPane(new vehiculos().vehiculos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
