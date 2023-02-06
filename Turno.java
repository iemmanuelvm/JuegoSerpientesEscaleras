class Turno
{
	boolean isPlayer1;
	boolean isPlayer2;
	Turno(boolean isPlayer1, boolean isPlayer2)
	{
		this.isPlayer1=false;
		this.isPlayer2=false;
	}
	boolean UnoAUno(boolean isPlayer1, boolean isPlayer2)
	{
		if(isPlayer1)
		{
			isPlayer2=true;
			return isPlayer2;
		}
		if(isPlayer2)
		{
			isPlayer1=true;
			return isPlayer1;
		}
	}
}