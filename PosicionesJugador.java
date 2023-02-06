class PosicionesJugador 
{
	int a;
	protected PosicionesJugador()
	{
		this.a=a;
	}
	//RETORNA EL VALOR EN EJE X PARA DARLE ANIMACION A LA FIGURA ES 
	//DECIR EL LIMITE DE LA CASILLA
	protected int EnX(int a)
	{
		if(a==1 || a==10 || a==11 || a==20 || a==21)
			a=200;
		if(a==2 || a==9 || a==12 || a==19 || a==22)
			a=300;
		if(a==3 || a==8 || a==13 || a==18 || a==23)
			a=400;
		if(a==4 || a==7 || a==14 || a==17 || a==24)
			a=500;
		if(a==5 || a==6 || a==15 || a==16 || a==25)
			a=600;
		return a;
	}
	//RETORNA EL VALOR EN EJE Y PARA DARLE ANIMACION A LA FIGURA ES 
	//DECIR EL LIMITE DE LA CASILLA
	protected int EnY(int a)
	{
		if(a==1 || a==2 || a==3 || a==4 || a==5)
			a=530;
		if(a==6 || a==7 || a==8 || a==9 || a==10)
			a=430;
		if(a==11 || a==12 || a==13 || a==14 || a==15)
			a=330;
		if(a==16 || a==17 || a==18 || a==19 || a==20)
			a=230;
		if(a==21 || a==22 || a==23 || a==24 || a==25)
			a=130;
		return a;
	}
	

}