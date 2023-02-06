//COMPONENTES A UTILIZAR DE JAVA
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.Graphics;
import javax.swing.*;
import java.applet.*;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.util.Random;
//CREAMOS LA CLASE Y HEREDAMOS DE JFRAME
class Tablero extends JFrame
{
	int tituloCont;
	JLabel titulo[] = new JLabel[20];
    int posicionLetra=100;
    String[] letras={"S", "E", "R", "P", "I", "E", "N", "T", "E", "S", "Y", "E", "S", "C", "A", "L", "E", "R", "A", "S"};
    Tablero() 
    {
    	//CREAMOS LA VENTANA DEL JUEGO DE SERPIENTES Y ESCALERAS
        super("SERPIENTES Y ESCALERAS");
		setSize(1400, 900);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color colorVentana = new Color(245,255,250);
		this.getContentPane().setBackground(colorVentana);

		JPanel panel1 = new JPanel();
        Color color1=new Color(250,250,210);
        panel1.setSize(1400,100);
        panel1.setLocation(0, 0);
        add(panel1);
        panel1.setBackground(color1);
        panel1.setLayout(null);
		for (int i = 0; i < 20; i++) 
        {
        	//GENERA UN NUMERO ALEATORIO PARA TONO DE COLOR RED (R,G,B)
        	Random r1 = new Random();
            int Low1 = 0;
            int High1 = 255;
            int R = r1.nextInt(High1-Low1) + Low1;
            //GENERA UN NUMERO ALEATORIO PARA TONO DE COLOR GREEN (R,G,B)
            Random r2 = new Random();
            int Low2 = 0;
            int High2 = 255;
            int G = r2.nextInt(High2-Low2) + Low2;
            //GENERA UN NUMERO ALEATORIO PARA TONO DE COLOR BLUE (R,G,B)
            Random r3 = new Random();
            int Low3 = 0;
            int High3 = 255;
            int B = r3.nextInt(High3-Low3) + Low3;
            //CREA UN COLOR ALEATORIO PARA EL COLOR DE LETRA DEL TITULO
            Color color = new Color(R, G, B);
            titulo[i] = new JLabel(letras[i]);
            titulo[i].setFont(new Font("Comic Sans MS", Font.BOLD, 50));
            titulo[i].setForeground(color);
            panel1.add(titulo[i]);
        }
        //POSICIONES DE LETRAS
        titulo[0].setBounds(20+posicionLetra, 20, 50, 50);  //0
        titulo[1].setBounds(70+posicionLetra, 20, 50, 50);  //1
        titulo[2].setBounds(120+posicionLetra, 20, 50, 50); //2
        titulo[3].setBounds(170+posicionLetra, 20, 50, 50); //3
        titulo[4].setBounds(220+posicionLetra, 20, 50, 50); //4
        titulo[5].setBounds(270+posicionLetra, 20, 50, 50); //5
        titulo[6].setBounds(320+posicionLetra, 20, 50, 50); //6
        titulo[7].setBounds(370+posicionLetra, 20, 50, 50); //7
        titulo[8].setBounds(420+posicionLetra, 20, 50, 50); //8
        titulo[9].setBounds(470+posicionLetra, 20, 50, 50); //9
        titulo[10].setBounds(570+posicionLetra, 20, 50, 50); //10
        titulo[11].setBounds(670+posicionLetra, 20, 50, 50); //11
        titulo[12].setBounds(720+posicionLetra, 20, 50, 50); //12
        titulo[13].setBounds(770+posicionLetra, 20, 50, 50); //13
        titulo[14].setBounds(820+posicionLetra, 20, 50, 50); //15
        titulo[15].setBounds(870+posicionLetra, 20, 50, 50); //16
        titulo[16].setBounds(920+posicionLetra, 20, 50, 50); //17
        titulo[17].setBounds(970+posicionLetra, 20, 50, 50); //18
        titulo[18].setBounds(1020+posicionLetra, 20, 50, 50); //19
        titulo[19].setBounds(1070+posicionLetra, 20, 50, 50); //20
	}
}