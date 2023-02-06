import java.util.Random;

//Clase que genera un numero aleatorio
class GenerarNumero
{
	int NumDado;
	protected GenerarNumero()
	{
		this.NumDado = 1;
	}
	protected int getValorDado()
	{
		Random r = new Random(); //Metodo que genera numeros aleatorios
        int Low = 1; //Minimo
        int High = 6; //Maximo
        NumDado = r.nextInt(High-Low) + Low;
        return NumDado;
	}
}