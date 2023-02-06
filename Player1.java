import javax.swing.*;
//HEREDAMOS DE LA THREAD PARA LA ANIMACION
public class Player1 extends Thread
{
	int jugadorEnX, jugadorEnY, posX, posY, dados;
	JLabel player1;
	//VARIABLES AUXILIARES PARA EL MANEJO DE MOVIMIENTO
	int temp=500;
	int temp2=500;
	int temp3=500;
	int temp4=500;
	//HACEMOS REFERENCIA A LAS VARIABLES DE INSTANCIA
	public Player1(int jugadorEnX,int jugadorEnY, int posX,int posY,JLabel player1, int dados)
	{
		
		this.jugadorEnX=jugadorEnX;
		this.jugadorEnY=jugadorEnY;
		this.player1=player1;
		this.posX=posX;
		this.posY=posY;
		this.dados=dados;
	}
	//METODO RUN PARA LLEVAR A CABO EL MOVIMIENTO
	public void run()
	{
		//SE INICIALIZAN LAS VARIABLES TEMPORALES EN EJE DE LAS X PARA ESE MOVIMIENTO
		int temp=jugadorEnX;
		int temp2=jugadorEnX;
		int temp3=jugadorEnX;
		int temp4=jugadorEnX;
		//SI EL DADO CAE EN ESAS CASILLA REALIZARA EL RESPECTIVO MOVIMIENTO EN TODO ESE EJE RESPETANDO EL RANGO
		if(dados==1 || dados==2 || dados==3 || dados==5)
		{
			if(posY==530&&posX<601)
			{	for (int i=jugadorEnX;i<posX;i++ ) 
				{
					player1.setLocation(i,posY);
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}	
			}
		}
		//ESCALERA
		if(dados==4)
		{
			if(posY==530&&posX<601)
			{	for (int i=jugadorEnX;i<=posX;i++ ) 
				{
					player1.setLocation(i,posY);
					if(i==500)
            		{
						for (int j=posY; j>=330; j--) 
            			{
							player1.setLocation(i,j);
							try{Thread.sleep(5);
							}catch(InterruptedException e)
							{
							System.out.println("Execpcion de inactividad");
							}
						}
					}
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}	
			}
		}
		//CAMBIO DE NIVEL
		if(dados==6)
		{
			if(posY==430&&posX<601)
			{	
				for (int i=jugadorEnX;i<=posX;i++ ) 
				{
					player1.setLocation(i,530);
					if(i==600)
            		{
						for (int j=530; j>=430; j--) 
            			{
							player1.setLocation(i,j);
							try{Thread.sleep(5);
							}catch(InterruptedException e)
							{
							System.out.println("Execpcion de inactividad");
							}
						}
					}
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}	
			}
		}
			//SI EL DADO CAE EN ESAS CASILLA REALIZARA EL RESPECTIVO MOVIMIENTO EN TODO ESE EJE RESPETANDO EL RANGO CON RESPECTO A LA POSICION DE Y
			if(dados==7 || dados==8 || dados==10)
			{
			if(posY==430)
			{	
				for (int i=jugadorEnY;i>430;i--) 
				{
			
					player1.setLocation(601,i);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int i=temp;i>posX;i--) 
				{
			
					player1.setLocation(i,posY);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				if(temp==600)
					temp=temp-100;
				else
					temp=temp-100;
			}
			}
			//ESCALERA
			if(dados==9)
			{
			if(posY==430)
			{	
				for (int i=jugadorEnY;i>430;i--) 
				{
			
					player1.setLocation(601,i);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int i=temp;i>posX;i--) 
				{
			
					player1.setLocation(i,posY);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}

					for (int j=posY; j>=230; j--) 
            			{
						player1.setLocation(posX,j);
						try{Thread.sleep(5);
						}catch(InterruptedException e)
						{
						System.out.println("Execpcion de inactividad");
						}
						}
				if(temp==600)
					temp=temp+100;
				else
					temp=temp+100;
			}
			}
			//SERPIENTE Y CAMBIO DE NIVEL
			if(dados==11)
			{
			if(posY==330&&posX<201)
			{	
				for (int i=jugadorEnX;i<=posX;i++ ) 
				{
					player1.setLocation(i,430);
					if(i==200)
            		{
						for (int j=430; j>=330; j--) 
            			{
							player1.setLocation(i,j);
							try{Thread.sleep(10);
							}catch(InterruptedException e)
							{
							System.out.println("Execpcion de inactividad");
							}
						}
					}
					try{Thread.sleep(10);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int j=330; j<=530; j++) 
            			{
						player1.setLocation(posX,j);
						try{Thread.sleep(5);
						}catch(InterruptedException e)
						{
						System.out.println("Execpcion de inactividad");
						}
						}	
			}
			}
			//ESCALERA
			if(dados==13) 
			{
				for (int i=posY;i>330;i--) 
				{
			
					player1.setLocation(200, i);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int j=temp2;j<posX;j++) 
				{
			
					player1.setLocation(j,posY);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int j=posY; j>=230; j--) 
            			{
						player1.setLocation(posX,j);
						try{Thread.sleep(5);
						}catch(InterruptedException e)
						{
						System.out.println("Execpcion de inactividad");
						}
						}
				if(temp2==600)
					temp2=temp2-100;
				else
					temp2=temp2-100;
			}
			//SI EL DADO CAE EN ESAS CASILLA REALIZARA EL RESPECTIVO MOVIMIENTO EN TODO ESE EJE RESPETANDO EL RANGO
			if(dados==12 || dados==14 || dados==15)
			{
			if(posY==330)
			{
				for (int i=posY;i>330;i--) 
				{
			
					player1.setLocation(200, i);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int j=temp2;j<posX;j++) 
				{
			
					player1.setLocation(j,posY);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				if(temp2==600)
					temp2=temp2-100;
				else
					temp2=temp2-100;
			}
			}
			//SI EL DADO CAE EN ESAS CASILLA REALIZARA EL RESPECTIVO MOVIMIENTO EN TODO ESE EJE RESPETANDO EL RANGO
			if(dados==17 || dados==18 || dados==19 || dados==20)
			{
			if(posY==230)
			{	
				for (int i=jugadorEnX;i<230;i++ ) 
				{
			
					player1.setLocation(601,i);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int i=temp3;i>posX;i--) 
				{
			
					player1.setLocation(i,posY);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				if(temp3==600)
					temp3=temp3-100;
				else
					temp3=temp3-100;
			}
			}
			//SERPIENTE Y CAMBIO DE NIVEL
			if(dados==16)
			{
			if(posY==230&&posX<601)
			{	
				for (int j=230; j<=530; j++) 
            			{
						player1.setLocation(posX,j);
						try{Thread.sleep(10);
						}catch(InterruptedException e)
						{
						System.out.println("Execpcion de inactividad");
						}
						}	
			}
			}
			if(dados==21)
			{
			if(posY==130&&posX<201)
			{	
				for (int j=130; j<=230; j++) 
            			{
						player1.setLocation(posX,j);
						try{Thread.sleep(10);
						}catch(InterruptedException e)
						{
						System.out.println("Execpcion de inactividad");
						}
						}	
			}
			}
			//SI EL DADO CAE EN ESAS CASILLA REALIZARA EL RESPECTIVO MOVIMIENTO EN TODO ESE EJE RESPETANDO EL RANGO
			if(dados==22 || dados==23 || dados==24 || dados==25)
			{
			if(posY==130)
			{
				for (int i=posY;i>130;i--) 
				{
			
					player1.setLocation(200, i);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				for (int j=temp4;j<posX;j++) 
				{
			
					player1.setLocation(j,posY);
			
					try{Thread.sleep(5);
					}catch(InterruptedException e)
					{
					System.out.println("Execpcion de inactividad");
					}
				}
				if(temp4==600)
					temp4=temp4-100;
				else
					temp4=temp4-100;
			}				
			}
		yield();//REGRESA AL HILO QUE SE EJECUTA EN ESTADO RUNNABLE PARA QUE SE UTILIZADO POSTERIORMENTE
	}
}