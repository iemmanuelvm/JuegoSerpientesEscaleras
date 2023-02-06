import java.awt.Graphics;//importamos las librerias 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

class Inicio extends JFrame implements ActionListener{
	JPanel Fondo;
	JButton Play, reglas;

	//Imagenes que se utilizaran en la ventana "Incio"

	private ImageIcon imagen= new ImageIcon("jugar.gif"); //Imagen que sera el fondo
	private ImageIcon jugar = new ImageIcon("boton1.gif"); //imagen para el boton "jugar"
	private ImageIcon ins = new ImageIcon("boton2.gif"); //Imagen para el boton "instrucciones"

	Border border1 = new LineBorder(new Color(173, 216, 230),1);//colorear el borde

	//Constructor
	Inicio(){
		//Creacion de la ventana
		super("Serpientes y Escaleras");
		setLayout(null);
		setSize(1400,900); //dimesiones de la ventana
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//la ventana se abre maximizada


		Fondo = new JPanel();
		Fondo.setLayout(null);
		Fondo.setVisible(true);
		Fondo.setBounds(10,10,1400,900);
		JLabel fondoIMAGEN = new JLabel(imagen);//la etiqueta tiene la imagen de fondo
		fondoIMAGEN.setSize(1400,900);//el tamaño de la etiqueta
		add(fondoIMAGEN);//Se agrega la imagen de fondo a la ventana

		//Creacion del boton "Jugar"
		Play = new JButton();
		Play.setBounds(580,400,130,50);
		Play.setToolTipText("Jugar");
		Play.setBackground(new Color(173, 216, 230));
		Play.setBorder(border1);
		Play.setIcon(jugar);
		add(Play);
		Play.addActionListener(this);

		//Creacion del boton "Instrucciones"
		reglas = new JButton();
		reglas.setBounds(510,450,260,50);
		reglas.setToolTipText("Instrucciones");
		reglas.setBackground(new Color(173, 216, 230));
		reglas.setBorder(border1);
		reglas.setIcon(ins);
		add(reglas);
		reglas.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Play)
		{
			this.dispose();
			Jugabilidad J = new Jugabilidad();
			J.setVisible(true);
		}

		if(e.getSource()==reglas)
		{
			this.dispose();
			Instrucciones I = new Instrucciones();
			I.setVisible(true);
		}
	}

		




}