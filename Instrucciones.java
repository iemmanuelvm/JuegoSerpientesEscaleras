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

//Clase que contiene las instrucciones del juego

class Instrucciones extends JFrame implements ActionListener{
	JPanel Fondo;
	JButton Play, Instrucciones;

	//Imagenes que se utilizaran en la ventana "Incio"

	private ImageIcon imagen= new ImageIcon("ins.gif"); //Imagen que sera el fondo
	private ImageIcon jugar = new ImageIcon("boton1.gif"); //imagen para el boton "jugar"
	

	Border border1 = new LineBorder(new Color(173, 216, 230),1);//colorear el borde

	//Constructor
	Instrucciones(){
		//Creacion de la ventana
		super("Instrucciones");
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
		Play.setBounds(610,670,130,50);
		Play.setToolTipText("Jugar");
		Play.setBackground(new Color(173, 216, 230));
		Play.setBorder(border1);
		Play.setIcon(jugar);
		add(Play);
		Play.addActionListener(this);

		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Play) //Si se presiona el boton "Jugar" nos redirigira a la ventana "Jugabilidad"
		{
			this.dispose();
			Jugabilidad J = new Jugabilidad();
			J.setVisible(true);
		}
	}

		




}