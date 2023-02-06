import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Jugabilidad extends Tablero implements Runnable, ActionListener
{ 
private JButton Lanzar, Detener, Aplicar; 
private JPanel panel2, panel1, panel4, panel3, panel5;
private JLabel play1;
private JLabel play2;
private JLabel marco, casillaP1, casillaP2, dadoBase, fondo;
private JTextField CasillaPlayer1, CasillaPlayer2, Contador1, Contador2, Turno, AuxDado;
private JLabel camino[] = new JLabel[26];
private JLabel escaleras[] = new JLabel[4];
private JLabel serpientes[] = new JLabel[4];
private int posicionCaminox=-60;
private int posicionCaminoy=-130;
private int resultadoDados;
private boolean primeraVez=true;
private boolean suspendido=true;
private int b,d,c,a,suma=0;
private int enX=600,posicionX=0,posicionY=0;
private int b1,d1,c1,a1,suma1=0;
private int enX1=600,posicionX1=0,posicionY1=0;
private boolean turno1=true;
private boolean turno2=false;
private int delay=20;
private int per1=0;
private int per2=0;
private Thread hilo;
public Jugabilidad()
{ 
hilo = new Thread(this);
 
JPanel panel1 = new JPanel();
Color color1=new Color(238, 232, 170);
panel1.setSize(415,90);
panel1.setLocation(820, 450);
add(panel1);
panel1.setBackground(color1);
panel1.setLayout(null);
//BOTON PARA LANZAR DADO
Lanzar = new JButton("Lanzar Dados");
Lanzar.setFont(new Font( "3ds Light", Font.BOLD, 20));  
Lanzar.setBackground(Color.white);
Lanzar.setForeground(Color.black);
Lanzar.setBounds(5, 20, 200, 50);
Lanzar.addActionListener(this);
panel1.add(Lanzar);
//BOTON PARA DETENER DADO
Detener = new JButton("Detener Dados");
Detener.setFont(new Font( "3ds Light", Font.BOLD, 20));  
Detener.setBackground(Color.white);
Detener.setForeground(Color.black);
Detener.setBounds(210, 20, 200, 50);
Detener.addActionListener(this);
Detener.setEnabled(false);
panel1.add(Detener);
//CREAMOS DOS OBJETOS DE LA CLASE PERSONAJE ALEATORIO PARA QUE SE ESCOJAN DOS DE LOS 10 PERSONAJES DISPONIBLES
PersonajesAleatorio aleatorio1 = new PersonajesAleatorio();
PersonajesAleatorio aleatorio2 = new PersonajesAleatorio();
per1=aleatorio1.getPersonajesAleatorio();
per2=aleatorio2.getPersonajesAleatorio();
//ETIQUETAS DE LOS PERSONAJES
play1=new JLabel("");
play1.setIcon(new ImageIcon(getClass().getResource("Personaje"+per1+".png")));
add(play1);
play1.setBounds(20,540,70,70);
play2=new JLabel("");
play2.setIcon(new ImageIcon(getClass().getResource("Personaje"+per2+".png")));
add(play2);
play2.setBounds(90,540,70,70);

//PANELES PARA EL CONTROL VISUAL DEL JUEGO
JPanel panel2 = new JPanel();
panel2.setSize(500,500);
panel2.setLocation(200, 100);
add(panel2);
panel2.setBackground(color1);
panel2.setLayout(null);
JPanel panel4 = new JPanel();
Color color3 = new Color(0,206,209);
panel4.setSize(660,500);
panel4.setLocation(700, 100);
add(panel4);
panel4.setBackground(color3);
panel4.setLayout(null);
JPanel panel5 = new JPanel();
panel5.setSize(200,500);
panel5.setLocation(0, 100);
add(panel5);
panel5.setBackground(color3);
panel5.setLayout(null);
//JTEXTFIEL PARA EL CONTEO DONDE SE ENCUENTRAN LOS PERSONAJES EN EL TABLERO
CasillaPlayer1 = new JTextField();
CasillaPlayer1.setBounds(120, 140, 100, 25);
CasillaPlayer1.setBackground(Color.WHITE);
CasillaPlayer1.setForeground(Color.BLACK);
CasillaPlayer1.setDisabledTextColor(Color.BLACK);
CasillaPlayer1.setFont(new Font("3ds Light", 1, 20));
CasillaPlayer1.setHorizontalAlignment(JTextField.RIGHT);
CasillaPlayer1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
CasillaPlayer1.setEnabled(false);
CasillaPlayer1.setText("Jugador 1");
panel4.add(CasillaPlayer1);
//CONTADOR DE CASILLAS
Contador1 = new JTextField();
Contador1.setBounds(120, 163, 100, 90);
Contador1.setBackground(Color.WHITE);
Contador1.setForeground(Color.BLACK);
Contador1.setDisabledTextColor(Color.BLACK);
Contador1.setFont(new Font("3ds Light", 1, 16));
Contador1.setHorizontalAlignment(JTextField.RIGHT);
Contador1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
Contador1.setHorizontalAlignment(JTextField.CENTER); 
Contador1.setEnabled(false);
panel4.add(Contador1);
//JTEXTFIEL PARA EL CONTEO DONDE SE ENCUENTRAN LOS PERSONAJES EN EL TABLERO
CasillaPlayer2 = new JTextField();
CasillaPlayer2.setBounds(433, 140, 100, 25);
CasillaPlayer2.setBackground(Color.WHITE);
CasillaPlayer2.setForeground(Color.BLACK);
CasillaPlayer2.setDisabledTextColor(Color.BLACK);
CasillaPlayer2.setFont(new Font("3ds Light", 1, 20));
CasillaPlayer2.setHorizontalAlignment(JTextField.RIGHT);
CasillaPlayer2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
CasillaPlayer2.setEnabled(false);
CasillaPlayer2.setText("Jugador 2");
panel4.add(CasillaPlayer2);
//CONTADOR DE CASILLAS
Contador2 = new JTextField();
Contador2.setBounds(433, 163, 100, 90);
Contador2.setBackground(Color.WHITE);
Contador2.setForeground(Color.BLACK);
Contador2.setDisabledTextColor(Color.BLACK);
Contador2.setFont(new Font("3ds Light", 1, 16));
Contador2.setHorizontalAlignment(JTextField.RIGHT);
Contador2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
Contador2.setHorizontalAlignment(JTextField.CENTER); 
Contador2.setEnabled(false);
panel4.add(Contador2);
//PARA SABER QUIEN FUE QUIEN LANZO LOS DADOS
Turno = new JTextField();
Turno.setBounds(218, 0, 216, 45);
Turno.setBackground(Color.WHITE);
Turno.setForeground(Color.BLACK);
Turno.setDisabledTextColor(Color.BLACK);
Turno.setFont(new Font("3ds Light", 1, 20));
Turno.setHorizontalAlignment(JTextField.RIGHT);
Turno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
Turno.setText("Turno Jugador 1");
Turno.setEnabled(false);
Turno.setHorizontalAlignment(JTextField.CENTER); 
panel4.add(Turno);
//MUESTRA EL AVANCE QUE VA DAR CON RESPECTO A LOS DADOS
AuxDado = new JTextField();
AuxDado.setBounds(218, 290, 216, 45);
AuxDado.setBackground(Color.WHITE);
AuxDado.setForeground(Color.BLACK);
AuxDado.setDisabledTextColor(Color.BLACK);
AuxDado.setFont(new Font("3ds Light", 1, 20));
AuxDado.setHorizontalAlignment(JTextField.CENTER);
AuxDado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
AuxDado.setEnabled(false);
AuxDado.setLayout(null);
panel4.add(AuxDado);
//IMAGENES DE CONTENIDO VISUAL DEL JUEGO
casillaP1=new JLabel("");
casillaP1.setIcon(new ImageIcon(getClass().getResource("casillaPlay1.png")));
casillaP1.setBounds(0,60,220,220);
panel4.add(casillaP1);
dadoBase=new JLabel("");
dadoBase.setIcon(new ImageIcon(getClass().getResource("Lanzar.jpg")));
panel4.add(dadoBase);
dadoBase.setBounds(950,200,100,100);
casillaP2=new JLabel("");
casillaP2.setIcon(new ImageIcon(getClass().getResource("casillaPlay2.png")));
panel4.add(casillaP2);
casillaP2.setBounds(431,60,220,220);
marco=new JLabel("");
marco.setIcon(new ImageIcon(getClass().getResource("Marco.png")));
panel4.add(marco);
marco.setBounds(218,43,220,220);
fondo=new JLabel("");
fondo.setIcon(new ImageIcon(getClass().getResource("1.jpg")));
fondo.setBounds(0,0,660,500);
panel4.add(fondo);

        //CREAMOS LAS ETIQUETAS DE IMAGENES DE ESCALERAS
        for (int i = 0; i < 4; i++) 
        {
            escaleras[i] = new JLabel();
            escaleras[i].setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            panel2.add(escaleras[i]);
        }
        //CREAMOS LAS ETIQUETAS DE IMAGENES DE SERPIENTES
        for (int i = 0; i < 4; i++) 
        {
            serpientes[i] = new JLabel();
            serpientes[i].setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            panel2.add(serpientes[i]);
        }
        //CREAMOS LAS ETIQUETAS DE IMAGENES DE NIVEL DEL CAMINO
        for (int i = 0; i < 26; i++) 
        {
            camino[i] = new JLabel();
            camino[i].setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            if(i!=25)
            {
            camino[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
            panel2.add(camino[i]);
        }
        //POSICIONES DEL CAMINO
        add(camino[25]);
        camino[0].setBounds(60+posicionCaminox, 530+posicionCaminoy, 100, 100); //1
        camino[1].setBounds(160+posicionCaminox, 530+posicionCaminoy, 100, 100);//2
        camino[2].setBounds(260+posicionCaminox, 530+posicionCaminoy, 100, 100);//3
        camino[3].setBounds(360+posicionCaminox, 530+posicionCaminoy, 100, 100);//4
        camino[4].setBounds(460+posicionCaminox, 530+posicionCaminoy, 100, 100);//5
        camino[5].setBounds(460+posicionCaminox, 430+posicionCaminoy, 100, 100);//6
        camino[6].setBounds(360+posicionCaminox, 430+posicionCaminoy, 100, 100);//7
        camino[7].setBounds(260+posicionCaminox, 430+posicionCaminoy, 100, 100);//8
        camino[8].setBounds(160+posicionCaminox, 430+posicionCaminoy, 100, 100);//9
        camino[9].setBounds(60+posicionCaminox, 430+posicionCaminoy, 100, 100);//10
        camino[10].setBounds(60+posicionCaminox, 330+posicionCaminoy, 100, 100); //11
        camino[11].setBounds(160+posicionCaminox, 330+posicionCaminoy, 100, 100);//12
        camino[12].setBounds(260+posicionCaminox, 330+posicionCaminoy, 100, 100);//13
        camino[13].setBounds(360+posicionCaminox, 330+posicionCaminoy, 100, 100);//14
        camino[14].setBounds(460+posicionCaminox, 330+posicionCaminoy, 100, 100);//15
        camino[15].setBounds(460+posicionCaminox, 230+posicionCaminoy, 100, 100);//16
        camino[16].setBounds(360+posicionCaminox, 230+posicionCaminoy, 100, 100);//17
        camino[17].setBounds(260+posicionCaminox, 230+posicionCaminoy, 100, 100);//18
        camino[18].setBounds(160+posicionCaminox, 230+posicionCaminoy, 100, 100);//19
        camino[19].setBounds(60+posicionCaminox, 230+posicionCaminoy, 100, 100);//20
        camino[20].setBounds(60+posicionCaminox, 130+posicionCaminoy, 100, 100); //21
        camino[21].setBounds(160+posicionCaminox, 130+posicionCaminoy, 100, 100);//22
        camino[22].setBounds(260+posicionCaminox, 130+posicionCaminoy, 100, 100);//23
        camino[23].setBounds(360+posicionCaminox, 130+posicionCaminoy, 100, 100);//24
        camino[24].setBounds(460+posicionCaminox, 130+posicionCaminoy, 100, 100);//25
        camino[25].setBounds(20, 600, 300, 100);
        //CREACION DE LAS CASILLA MEDIANTE IMAGENES
        camino[0].setIcon(new ImageIcon(getClass().getResource("1.gif")));
        camino[1].setIcon(new ImageIcon(getClass().getResource("2.gif")));
        camino[2].setIcon(new ImageIcon(getClass().getResource("3.gif")));
        camino[3].setIcon(new ImageIcon(getClass().getResource("4.gif")));
        camino[4].setIcon(new ImageIcon(getClass().getResource("5.gif")));
        camino[5].setIcon(new ImageIcon(getClass().getResource("6.gif")));
        camino[6].setIcon(new ImageIcon(getClass().getResource("7.gif")));
        camino[7].setIcon(new ImageIcon(getClass().getResource("8.gif")));
        camino[8].setIcon(new ImageIcon(getClass().getResource("9.gif")));
        camino[9].setIcon(new ImageIcon(getClass().getResource("10.gif")));
        camino[10].setIcon(new ImageIcon(getClass().getResource("11.gif")));
        camino[11].setIcon(new ImageIcon(getClass().getResource("12.gif")));
        camino[12].setIcon(new ImageIcon(getClass().getResource("13.gif")));
        camino[13].setIcon(new ImageIcon(getClass().getResource("14.gif")));
        camino[14].setIcon(new ImageIcon(getClass().getResource("15.gif")));
        camino[15].setIcon(new ImageIcon(getClass().getResource("16.gif")));
        camino[16].setIcon(new ImageIcon(getClass().getResource("17.gif")));
        camino[17].setIcon(new ImageIcon(getClass().getResource("18.gif")));
        camino[18].setIcon(new ImageIcon(getClass().getResource("19.gif")));
        camino[19].setIcon(new ImageIcon(getClass().getResource("20.gif")));
        camino[20].setIcon(new ImageIcon(getClass().getResource("21.gif")));
        camino[21].setIcon(new ImageIcon(getClass().getResource("22.gif")));
        camino[22].setIcon(new ImageIcon(getClass().getResource("23.gif")));
        camino[23].setIcon(new ImageIcon(getClass().getResource("24.gif")));
        camino[24].setIcon(new ImageIcon(getClass().getResource("25.gif")));
        camino[25].setIcon(new ImageIcon(getClass().getResource("tierra.png")));
        //AGREGAMOS LAS IMAGENES DE LAS ESCALERAS EN LA ETIQUETA CREADA
        escaleras[0].setIcon(new ImageIcon(getClass().getResource("escalera1.png")));
        escaleras[1].setIcon(new ImageIcon(getClass().getResource("escalera2.png")));
        escaleras[2].setIcon(new ImageIcon(getClass().getResource("escalera3.png")));
        //POSICIONES DE ESCALERAS
        escaleras[0].setBounds(350+posicionCaminox, 160+posicionCaminoy, 320, 640); //1
        escaleras[1].setBounds(130+posicionCaminox, 80+posicionCaminoy, 320, 640); //2
        escaleras[2].setBounds(230+posicionCaminox, 20+posicionCaminoy, 320, 640); //2
        //AGREGAMOS LAS IMAGENES DE LAS SEPIENTES EN LA ETIQUETA CREADA
        serpientes[0].setIcon(new ImageIcon(getClass().getResource("Serpiente1.png")));
        serpientes[1].setIcon(new ImageIcon(getClass().getResource("Serpiente2.png")));
        serpientes[2].setIcon(new ImageIcon(getClass().getResource("Serpiente3.png")));
        //POSICIONES DE SEPIENTES
        serpientes[0].setBounds(60+posicionCaminox, 160+posicionCaminoy, 320, 640); //1
        serpientes[1].setBounds(470+posicionCaminox, 80+posicionCaminoy, 320, 640); //2
        serpientes[2].setBounds(70+posicionCaminox, -80+posicionCaminoy, 320, 640); //2

        JPanel panel3 = new JPanel();
        Color color4=new Color(250,250,210);
        panel3.setSize(1400,110);
        panel3.setLocation(0, 600);
        add(panel3);
        panel3.setBackground(color1);
        panel3.setLayout(null);
} 

//Metodo paint que generara los dados
public void paint(Graphics g) 
{ 
super.paint(g);
DadosDibujo dadosD = new DadosDibujo(g);
g=dadosD.getValor(resultadoDados);
} 
public void run()
{
	GenerarNumero dado = new GenerarNumero();
	while (true)
        {
        resultadoDados = dado.getValorDado();
		repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                break;
            }
        }
   }
//CREAMOS DOS OBJETOS DE POSICIONESJUGADOR PARA LLEVAR EL CONTROL DE CASILLAS EN SUS RESPECTIVOS EJES X Y Y
PosicionesJugador obj1 = new PosicionesJugador();
PosicionesJugador obj2 = new PosicionesJugador();
Musica mus = new Musica();
public void actionPerformed(ActionEvent e)
	{
		// BOTON PARA LANZAR DADO
		if (e.getSource()==Lanzar)
		{
            Lanzar.setEnabled(false);
            Detener.setEnabled(true);
            Contador1.setText("Casilla "+suma);
            Contador2.setText("Casilla "+suma1);
			if (primeraVez)
            {   
                //HILO DEL DADO
            	hilo.start();
                primeraVez=false;
            }
            else
            {   hilo.resume();
                suspendido=false;
            }
            repaint();
		} 
		// BOTON PARA PARAR DADO 
        if(e.getSource()==Detener)
        {
            repaint();
            Lanzar.setEnabled(true);
            Detener.setEnabled(false);
            hilo.suspend();
            suspendido=true;
            mus.getRun();
            //JUGABILIDAD DEL JUGADOR 1 CUANDO ES SU TURNO
            if(turno1)
            {
            a=resultadoDados;
            if (suma>=25) 
            {
                suma=25;   
            }
            else
            {
                suma+=a;
            }
            b=obj1.EnX(suma);//SE MANDA LLAMAR EL METODO DEL LA CLASE CREADA EN X PARA EN MANEJO DE ESE EJE
            d=obj1.EnY(suma);//SE MANDA LLAMAR EL METODO DEL LA CLASE CREADA EN Y PARA EN MANEJO DE ESE EJE
            posicionY=d;
            Player1 jugador1 =new Player1(posicionX,posicionY,b,d,play1,suma);//SE CREA UN OBJETO DE LA CLASE JUGADOR PARA LA ANIMACION
            if(suma>25)
            {
                suma=25;
            }
            //ESCALERA
            if(suma==4)
            {
                suma=14;
                mus.getLanzar();
            }
            if(suma==7)
            {
                play1.setBounds(500, 430, 70, 70);
            }
            if(suma==12)
            {
                play1.setBounds(300, 330, 70, 70);
            }
            if(suma==17)
            {
                play1.setBounds(500, 230, 70, 70);
            }
            if(suma==22)
            {
                play1.setBounds(300, 130, 70, 70);
            }
            //ESCALERA
            if(suma==9)
            {
                suma=19;
                mus.getLanzar();
            }
            //SERPIENTE
            if(suma==11)
            {
                suma=1;
                mus.getVivora();
            }
            //SERPIENTE
            if(suma==21)
            {
                suma=20;
                mus.getVivora();
            }
            //ESCALERA
            if(suma==13)
            {
                suma=18;
                mus.getLanzar();
            }
            //SERPIENTE
            if(suma==16)
            {
                suma=5;
                mus.getVivora();
            }
            //POSICIONES DE LAS ETIQUETAS EN CASO DE QUE NO SE DIERA LA ANIMACION SE COLOQUE EN LA CASILLA CORRESPONDIENTE
            if(suma==1)
            {
                play1.setBounds(200, 530, 70, 70);
            }
            if(suma==2)
            {
                play1.setBounds(300, 530, 70, 70);
            }
            if(suma==3)
            {
                play1.setBounds(400, 530, 70, 70);
            }
            if(suma==4)
            {
                play1.setBounds(500, 530, 70, 70);
            }
            if(suma==5)
            {
                play1.setBounds(600, 530, 70, 70);
            }
            if(suma==6)
            {
                play1.setBounds(600, 430, 70, 70);
            }
            if(suma==7)
            {
                play1.setBounds(500, 430, 70, 70);
            }
            if(suma==8)
            {
                play1.setBounds(400, 430, 70, 70);
            }
            if(suma==9)
            {
                play1.setBounds(300, 430, 70, 70);
            }
            if(suma==10)
            {
                play1.setBounds(200, 430, 70, 70);
            }
            if(suma==11)
            {
                play1.setBounds(200, 330, 70, 70);
            }
            if(suma==12)
            {
                play1.setBounds(300, 330, 70, 70);
            }
            if(suma==13)
            {
                play1.setBounds(400, 330, 70, 70);
            }
            if(suma==14)
            {
                play1.setBounds(500, 330, 70, 70);
            }
            if(suma==15)
            {
                play1.setBounds(600, 330, 70, 70);
            }
            if(suma==16)
            {
                play1.setBounds(600, 230, 70, 70);
            }
            if(suma==17)
            {
                play1.setBounds(500, 230, 70, 70);
            }
            if(suma==18)
            {
                play1.setBounds(400, 230, 70, 70);
            }
            if(suma==19)
            {
                play1.setBounds(300, 230, 70, 70);
            }
            if(suma==20)
            {
                play1.setBounds(200, 230, 70, 70);
            }
            if(suma==21)
            {
                play1.setBounds(200, 130, 70, 70);
            }
            if(suma==22)
            {
                play1.setBounds(300, 130, 70, 70);
            }
            if(suma==23)
            {
                play1.setBounds(400, 130, 70, 70);
            }
            if(suma==24)
            {
                play1.setBounds(500, 130, 70, 70);
            }
            if(suma==25)
            {
                play1.setBounds(600, 130, 70, 70);
            }
        jugador1.start();//INICIA EL MOVIEMIENTO DEL HILO DEL JUGADOR UN0
        posicionX=b;
        Contador1.setText("Casilla "+suma);//MOSTRAMOS EN JTEXTFIELD EN QUE POSICION ESTA ACTUALMENTE
        if(suma==25)
            {   //MENSAJE DE QUE SE GANO EL JUEGO CON EL JUGADOR 1
                Contador1.setText("Casilla "+suma);
                mus.getTriunfo();
                JOptionPane.showMessageDialog(null,"FELICIDADES GANO EL JUGADOR 1");
                dispose();
            }
            }
            //JUGABILIDAD DEL JUGADOR 2 CUANDO ES SU TURNO
            if(turno2)
            {
            a1=resultadoDados;
            if (suma1>25) 
            {
                suma1=25;   
            }
            else
            {
                suma1+=a1;//CONTADOR DE SUMA DE DADOS
            }
            b1=obj2.EnX(suma1);
            d1=obj2.EnY(suma1);
            posicionY1=d1;
            Player1 jugador2 =new Player1(posicionX1,posicionY1,b1,d1,play2,suma1);//SE CREA UN OBJETO DE LA CLASE PLAYER 1 PARA EL MOVIEMTO DEL RESPECTIVO
            jugador2.start();
            if(suma>25)
            {
                suma=25;
            }
            //ESCALERA
            if(suma1==9)
            {
                suma1=19;
                mus.getLanzar();
            }
            //SERPIENTE
            if(suma1==11)
            {
                suma1=1;
                mus.getVivora();
            }
            //SERPIENTE
            if(suma1==21)
            {
                suma1=20;
                mus.getVivora();
            }
            //ESCALERA
            if(suma1==13)
            {
                suma1=18;
                mus.getLanzar();
            }
            //SERPIENTE
            if(suma1==16)
            {
                suma1=5;
                mus.getVivora();
            }
            posicionX1=b1;
            }
            if(suma1==4)
            {
                suma1=14;
                mus.getLanzar();
            }
            //ETIQUETAS PARA EN CASO DE QUE EL JUGADOR 2 NO HAGA SU MOVIMIENTO
            if(suma1==1)
            {
                play2.setBounds(200, 530, 70, 70);
            }
            if(suma1==2)
            {
                play2.setBounds(300, 530, 70, 70);
            }
            if(suma1==3)
            {
                play2.setBounds(400, 530, 70, 70);
            }
            if(suma1==4)
            {
                play2.setBounds(500, 530, 70, 70);
            }
            if(suma1==5)
            {
                play2.setBounds(600, 530, 70, 70);
            }
            if(suma1==6)
            {
                play2.setBounds(600, 430, 70, 70);
            }
            if(suma1==7)
            {
                play2.setBounds(500, 430, 70, 70);
            }
            if(suma1==8)
            {
                play2.setBounds(400, 430, 70, 70);
            }
            if(suma1==9)
            {
                play2.setBounds(300, 430, 70, 70);
            }
            if(suma1==10)
            {
                play2.setBounds(200, 430, 70, 70);
            }
            if(suma1==11)
            {
                play2.setBounds(200, 330, 70, 70);
            }
            if(suma1==12)
            {
                play2.setBounds(300, 330, 70, 70);
            }
            if(suma1==13)
            {
                play2.setBounds(400, 330, 70, 70);
            }
            if(suma1==14)
            {
                play2.setBounds(500, 330, 70, 70);
            }
            if(suma1==15)
            {
                play2.setBounds(600, 330, 70, 70);
            }
            if(suma1==16)
            {
                play2.setBounds(600, 230, 70, 70);
            }
            if(suma1==17)
            {
                play2.setBounds(500, 230, 70, 70);
            }
            if(suma1==18)
            {
                play2.setBounds(400, 230, 70, 70);
            }
            if(suma1==19)
            {
                play2.setBounds(300, 230, 70, 70);
            }
            if(suma1==20)
            {
                play2.setBounds(200, 230, 70, 70);
            }
            if(suma1==21)
            {
                play2.setBounds(200, 130, 70, 70);
            }
            if(suma1==22)
            {
                play2.setBounds(300, 130, 70, 70);
            }
            if(suma1==23)
            {
                play2.setBounds(400, 130, 70, 70);
            }
            if(suma1==24)
            {
                play2.setBounds(500, 130, 70, 70);
            }
            if(suma1==25)
            {
                play2.setBounds(600, 130, 70, 70);
            }
            if(suma1==25)
            {   //MENSAJE DE GANADOR DEL PERSONAJE 2
                Contador2.setText("Casilla "+suma);
                mus.getTriunfo();
                JOptionPane.showMessageDialog(null,"FELICIDADES GANO EL JUGADOR 2");
                dispose();
            }
            Contador2.setText("Casilla "+suma1);
        //CONTROL PARA TURNAR A LOS DOS JUGADORES
        if(turno1==true)
        {
            turno2=true;
            turno1=false;
            Turno.setText("Turno Jugador 2");
        }
        else
        {
            turno2=false;
            turno1=true;
            Turno.setText("Turno Jugador 1");
        }
        }
        AuxDado.setText("Avance " + resultadoDados);
	}
}