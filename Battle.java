import Utilities.*;
public class Battle extends Thread
{
	private MyPair<Team,Team> contestants;
	public Battle(Team one,Team two)
	{
		contestants= new MyPair<Team,Team>(one,two);
	}	
	public void run()
	{
			//a variavel i e o iterador que passara pelos times,mas nao sera usada diretamente.a sua unica finalidade é contar ate um valor determinado pelo numero de personagens vivos em cada time
		int i;
		//variavel que representa qual time inicia atacando no turno.  
		int team_turn;
		//variavel que representa o resultado de getPoints(),ou seja,a media aritmetica dos HPs dos personagens de um time.
		double this_result;
		//vetor que representa qual dos personagens ainda nao atacou naquele turno,dentre os personagens do Team 'contestants.first'
		boolean[] available_1=new boolean[contestants.first.characters.size()];
		//vetor que representa qual dos personagens ainda nao atacou naquele turno,dentre os personagens do Team 'contestants.second'
		boolean[] available_2=new boolean[contestants.second.characters.size()];
		//contador que representa o numero de personagens vivos no time contestants.first
		int alive_count_1;
		//contador que representa o numero de personagens vivos no time contestants.second
		int alive_count_2;
		//variavel que representa valores randomicos para os indices de contestants.first.characters e contestants.second.characters. É usado somente durante o ataque.o valor sentinela é -1. 
		int random_attack=-1;
		//variavel que representa valores randomicos para os indices de contestants.first.characters e contestants.second.characters. É usada somente durante a defesa.o valor sentinela é -1.
		int random_defense=-1;
		//variavel que e usada para o guardar o retorno de contestants.second.getPoints(),para fazer o output da situacao da batalha a cada turno.
		double opposite_result;
		RandomNumber rand = new RandomNumber();
		alive_count_1=contestants.first.characters.size();
		alive_count_2=contestants.second.characters.size();
		this_result=100;
		opposite_result=100;
		System.out.println("Initiating battle between team "+contestants.first.getName()+" and team "+contestants.second.getName());

		//enquanto existem personagens vivos nos 2 times
		while(alive_count_1 != 0 && alive_count_2!=0)
		{
			team_turn=rand.nextInt(100)+1;
			//reseta os valores dos vetores que decidirao se alguns personagens ja atacaram ou nao
			for(i=0;i<contestants.first.characters.size();i++)
			{
				available_1[i]=true;
			}
			for(i=0;i<contestants.second.characters.size();i++)
			{
				available_2[i]=true;	
			}

			//se o time 'contestants.first' foi sorteado randomicamente,podendo assim atacar em primeiro	
			if(team_turn<=50)
			{
				//a iteracao acontece ate que todos os personagens vivos dos dois times tenham atacado
				for(i=0;i<alive_count_1 && i<alive_count_2 ;i++)
				{
					//se a iteracao for menor que o numero de personagens vivos no time contestants.first
					if(i<alive_count_1)
					{
						//observacao: e checagem acontece sequencialmente,se random_attack for -1 as outras condicoes do while nao executam, nao tendo problemas com vetores acessados fora do limite
						//a condicao de iteracao é: o valor de random_attack e -1 (ou seja,a variavel nao foi usada ainda) , o personagem ja atacou nesse turno, e o personagem ja esta morto
						while(random_attack==-1||available_1[random_attack]==false || !contestants.first.characters.get(random_attack).isAlive())
						{
							random_attack=rand.nextInt(contestants.first.characters.size());
						}
						while(random_defense==-1||!contestants.second.characters.get(random_defense).isAlive())				
						{
							random_defense=rand.nextInt(contestants.second.characters.size());
						}
						contestants.first.characters.get(random_attack).attack(contestants.second.characters.get(random_defense));
						if(!contestants.second.characters.get(random_defense).isAlive())
						{
							alive_count_2--;
							contestants.second.characters.remove(random_defense);
						}
						available_1[random_attack]=false;
									
					}
					random_attack=-1;
					random_defense=-1;
					if(alive_count_2==0)
						break;
					if(i<alive_count_2)
					{
						while(random_attack==-1	|| available_2[random_attack]==false|| !contestants.second.characters.get(random_attack).isAlive() )

						{
							random_attack=rand.nextInt(contestants.second.characters.size());
						}
						while(random_defense==-1|| !contestants.first.characters.get(random_defense).isAlive())	
						{
							random_defense=rand.nextInt(contestants.first.characters.size());
						}
						contestants.second.characters.get(random_attack).attack(contestants.first.characters.get(random_defense));
						if(!contestants.first.characters.get(random_defense).isAlive())
						{
							alive_count_1--;
							contestants.first.characters.remove(random_defense);
						}
						available_2[random_attack]=false;				
					}
					if(alive_count_1==0)
						break;
					random_attack=-1;
					random_defense=-1;
				}							
			}
			else
			{
				//a ordem de ataque entre contestants.second e contestants.first é invertida caso team_turn > 50	
				for(i=0;i<alive_count_1 && i<alive_count_2 ;i++)
				{

					if(i<alive_count_2)
					{
						while(random_attack==-1	|| available_2[random_attack]==false|| !contestants.second.characters.get(random_attack).isAlive() )
						{
							random_attack=rand.nextInt(contestants.second.characters.size());
						}
						while(random_defense==-1|| !contestants.first.characters.get(random_defense).isAlive())	
						{	
							random_defense=rand.nextInt(contestants.first.characters.size());
						}
						contestants.second.characters.get(random_attack).attack(contestants.first.characters.get(random_defense));
						if(!contestants.first.characters.get(random_defense).isAlive())
						{
							alive_count_1--;	
							contestants.first.characters.remove(random_defense);	
						}
						available_2[random_attack]=false;				
					}
					if(alive_count_1==0)
						break;
					random_attack=-1;
					random_defense=-1;
					if(i<alive_count_1)
					{
						while(random_attack==-1||available_1[random_attack]==false || !contestants.first.characters.get(random_attack).isAlive())
						{
							random_attack=rand.nextInt(contestants.first.characters.size());
						}
						while(random_defense==-1||!contestants.second.characters.get(random_defense).isAlive())				
						{	
							random_defense=rand.nextInt(contestants.second.characters.size());
						}
						contestants.first.characters.get(random_attack).attack(contestants.second.characters.get(random_defense));
						if(!contestants.second.characters.get(random_defense).isAlive())
						{
							alive_count_2--;
							contestants.second.characters.remove(random_defense);
						}
						available_1[random_attack]=false;
					}
					random_attack=-1;
					random_defense=-1;
					if(alive_count_2==0)
						break;
				}
			}	
			this_result=contestants.first.getPoints();
			opposite_result=contestants.second.getPoints();
			System.out.println("The "+contestants.first.getName()+" have "+(int)this_result+" points so far.");
			System.out.println("The "+contestants.second.getName()+" have "+(int)opposite_result+" points so far.");
		}
		if(alive_count_2==0)
		{
			contestants.first.addWin();
			contestants.second.addLoss();
			System.out.println("The "+contestants.first.getName()+" win!");
		}
		else
		{
			contestants.first.addLoss();
			contestants.second.addWin();
			System.out.println("The "+contestants.second.getName()+" win!");
		}					
	}	
}   
