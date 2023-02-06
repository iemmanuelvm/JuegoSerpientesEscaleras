import java.awt.Graphics; 
import javax.swing.ImageIcon; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BaseInicioTierra
{ 
private ImageIcon baseInicial;
private Graphics g;
public BaseInicioTierra(Graphics g)
{ 
	this.g=g;
} 
protected Graphics getTierra()
{
	baseInicial = new ImageIcon(getClass().getResource("tierra.png"));
	g.drawImage(baseInicial.getImage(), 20, 650, baseInicial.getImageObserver()); 
	return g;
}
}