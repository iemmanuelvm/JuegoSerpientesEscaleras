import java.util.Random;
class PersonajesAleatorio

//Clase que generara personajes aleatorios durante el juego
{
	int NumDado;
	protected PersonajesAleatorio()
	{
		this.NumDado = 1;
	}
	protected int getPersonajesAleatorio()
	{
		Random r = new Random();
        int Low = 1;
        int High = 11;
        NumDado = r.nextInt(High-Low) + Low;
        return NumDado;
	}
}