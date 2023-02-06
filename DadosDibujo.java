import java.awt.Graphics; 
import javax.swing.ImageIcon; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Clase que contiene las imagen del dado
class DadosDibujo
{ 
private ImageIcon imagen1, imagen2, imagen3, imagen4, imagen5, imagen6; 
private Graphics g;
private int x;
private boolean primeraVez = false;

public DadosDibujo(Graphics g)
{ 
	this.g=g;
	this.x=0;
} 
protected Graphics getValor(int x)
{
	if(x==0)
	{
	imagen1 = new ImageIcon(getClass().getResource("caradado1.png")); 
	g.drawImage(imagen1.getImage(), 950, 200, imagen1.getImageObserver());
	}
	if(x==1)
	{
		imagen1 = new ImageIcon(getClass().getResource("caradado1.png")); 
		g.drawImage(imagen1.getImage(), 950, 200, imagen1.getImageObserver());
	}
	if(x==2)
	{
		imagen2 = new ImageIcon(getClass().getResource("caradado2.png"));
		g.drawImage(imagen2.getImage(), 950, 200, imagen2.getImageObserver());
	}
	if(x==3)
	{
		imagen3 = new ImageIcon(getClass().getResource("caradado3.png"));
		g.drawImage(imagen3.getImage(), 950, 200, imagen3.getImageObserver());
	}
	if(x==4)
	{
		imagen4 = new ImageIcon(getClass().getResource("caradado4.png"));
		g.drawImage(imagen4.getImage(), 950, 200, imagen4.getImageObserver());
	}
	if(x==5)
	{
		imagen5 = new ImageIcon(getClass().getResource("caradado5.png"));
		g.drawImage(imagen5.getImage(), 950, 200, imagen5.getImageObserver());
	}
	if(x==6)
	{
		imagen6 = new ImageIcon(getClass().getResource("caradado6.png"));
		g.drawImage(imagen6.getImage(), 950, 200, imagen6.getImageObserver());
	}
	return g;
}
}