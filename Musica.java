import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
//Clase que contiene la musica de fondo para el juego
public class Musica
{
	protected void getLanzar()
	{
	try
	{
	Clip sonido = AudioSystem.getClip();
	sonido.open(AudioSystem.getAudioInputStream(new File("Escalera.wav")));
	sonido.start();
	sonido.loop(0);
	 }
	 catch (Exception e) 
		{
     System.out.println("" + e);
        }

	}
	protected void getRun()
	{
	try
	{
	Clip sonido = AudioSystem.getClip();
	sonido.open(AudioSystem.getAudioInputStream(new File("Run.wav")));
	sonido.start();
	sonido.loop(0);
	 }
	 catch (Exception e) 
		{
     System.out.println("" + e);
        }
	}
	protected void getTriunfo()
	{
	try
	{
	Clip sonido = AudioSystem.getClip();
	sonido.open(AudioSystem.getAudioInputStream(new File("Win.wav")));
	sonido.start();
	sonido.loop(0);
	 }
	 catch (Exception e) 
		{
     System.out.println("" + e);
        }
	}	
	protected void getVivora()
	{
	try
	{
	Clip sonido = AudioSystem.getClip();
	sonido.open(AudioSystem.getAudioInputStream(new File("Serpiente.wav")));
	sonido.start();
	sonido.loop(0);
	 }
	 catch (Exception e) 
		{
     System.out.println("" + e);
        }

	}
}