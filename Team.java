import GameCharacter.*;
import Utilities.*; 
import java.util.ArrayList;
public class Team
{
	private	String name;
	private	Color color;
	private	int win;
	private	int lose;
	private int draw;
	private	ArrayList<GameCharacter> characters;
	public Team(String name,Color color)
	{
		this.name=name;
		this.color=color;
		win=0;
		lose=0;
		draw=0;
		characters = new ArrayList<GameCharacter>();	
	}
	public String getName()
	{
		return name;
	}
	public String getResults()
	{
		String aux;//stream usada para conversao de int para string
		aux="The team "+this.name+" has until now "+win+" wins, "+lose+" losses, and "+draw+" draws\n";
		return aux;
	}
	public String toString()
	{
		String aux;
		aux="The team name is "+this.name+" and it's color is "+this.color+"\n";
		return aux;
	}
	public void resolveBattle(Team opposite)
	{	
		//a variavel i e o iterador que passara pelos times,mas nao sera usada diretamente.a sua unica finalidade é contar ate um valor determinado pelo numero de personagens vivos em cada time
		int i;
		//variavel que representa qual time inicia atacando no turno.  
		int team_turn;
		//variavel que representa o resultado de getPoints(),ou seja,a media aritmetica dos HPs dos personagens de um time.
		double this_result;
		//vetor que representa qual dos personagens ainda nao atacou naquele turno,dentre os personagens do Team 'this'
		boolean[] available_1=new boolean[this.characters.size()];
		//vetor que representa qual dos personagens ainda nao atacou naquele turno,dentre os personagens do Team 'opposite'
		boolean[] available_2=new boolean[opposite.characters.size()];
		//contador que representa o numero de personagens vivos no time this
		int alive_count_1;
		//contador que representa o numero de personagens vivos no time opposite
		int alive_count_2;
		//variavel que representa valores randomicos para os indices de this.characters e opposite.characters. É usado somente durante o ataque.o valor sentinela é -1. 
		int random_attack=-1;
		//variavel que representa valores randomicos para os indices de this.characters e opposite.characters. É usada somente durante a defesa.o valor sentinela é -1.
		int random_defense=-1;
		//variavel que e usada para o guardar o retorno de opposite.getPoints(),para fazer o output da situacao da batalha a cada turno.
		double opposite_result;
		RandomNumber rand = new RandomNumber();
		alive_count_1=this.characters.size();
		alive_count_2=opposite.characters.size();
		this_result=100;
		opposite_result=100;
		System.out.println("Initiating battle between team "+this.name+" and team "+opposite.name);

		//enquanto existem personagens vivos nos 2 times
		while(alive_count_1 != 0 && alive_count_2!=0)
		{
			team_turn=rand.nextInt(100)+1;
			//reseta os valores dos vetores que decidirao se alguns personagens ja atacaram ou nao
			for(i=0;i<this.characters.size();i++)
			{
				available_1[i]=true;
			}
			for(i=0;i<opposite.characters.size();i++)
			{
				available_2[i]=true;	
			}

			//se o time 'this' foi sorteado randomicamente,podendo assim atacar em primeiro	
			if(team_turn<=50)
			{
				//a iteracao acontece ate que todos os personagens vivos dos dois times tenham atacado
				for(i=0;i<alive_count_1 && i<alive_count_2 ;i++)
				{
					//se a iteracao for menor que o numero de personagens vivos no time this
					if(i<alive_count_1)
					{
						//observacao: e checagem acontece sequencialmente,se random_attack for -1 as outras condicoes do while nao executam, nao tendo problemas com vetores acessados fora do limite
						//a condicao de iteracao é: o valor de random_attack e -1 (ou seja,a variavel nao foi usada ainda) , o personagem ja atacou nesse turno, e o personagem ja esta morto
						while(random_attack==-1||available_1[random_attack]==false || !this.characters.get(random_attack).isAlive())
						{
							random_attack=rand.nextInt(this.characters.size());
						}
						while(random_defense==-1||!opposite.characters.get(random_defense).isAlive())				
						{
							random_defense=rand.nextInt(opposite.characters.size());
						}
						this.characters.get(random_attack).attack(opposite.characters.get(random_defense));
						if(!opposite.characters.get(random_defense).isAlive())
							alive_count_2--;
						available_1[random_attack]=false;
									
					}
					random_attack=-1;
					random_defense=-1;
					if(alive_count_2==0)
						break;
					if(i<alive_count_2)
					{
						while(random_attack==-1	|| available_2[random_attack]==false|| !opposite.characters.get(random_attack).isAlive() )

						{
							random_attack=rand.nextInt(opposite.characters.size());
						}
						while(random_defense==-1|| !this.characters.get(random_defense).isAlive())	
						{
							random_defense=rand.nextInt(this.characters.size());
						}
						opposite.characters.get(random_attack).attack(this.characters.get(random_defense));
						if(!this.characters.get(random_defense).isAlive())
							alive_count_1--;
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
				//a ordem de ataque entre opposite e this é invertida caso team_turn > 50	
				for(i=0;i<alive_count_1 && i<alive_count_2 ;i++)
				{

					if(i<alive_count_2)
					{
						while(random_attack==-1	|| available_2[random_attack]==false|| !opposite.characters.get(random_attack).isAlive() )
						{
							random_attack=rand.nextInt(opposite.characters.size());
						}
						while(random_defense==-1|| !this.characters.get(random_defense).isAlive())	
						{	
							random_defense=rand.nextInt(this.characters.size());
						}
						opposite.characters.get(random_attack).attack(this.characters.get(random_defense));
						if(!this.characters.get(random_defense).isAlive())
							alive_count_1--;	
						available_2[random_attack]=false;				
					}
					if(alive_count_1==0)
						break;
					random_attack=-1;
					random_defense=-1;
					if(i<alive_count_1)
					{
						while(random_attack==-1||available_1[random_attack]==false || !this.characters.get(random_attack).isAlive())
						{
							random_attack=rand.nextInt(this.characters.size());
						}
						while(random_defense==-1||!opposite.characters.get(random_defense).isAlive())				
						{	
							random_defense=rand.nextInt(opposite.characters.size());
						}
						this.characters.get(random_attack).attack(opposite.characters.get(random_defense));
						if(!opposite.characters.get(random_defense).isAlive())
							alive_count_2--;
						available_1[random_attack]=false;
					}
					random_attack=-1;
					random_defense=-1;
					if(alive_count_2==0)
						break;
				}
			}	
			this_result=this.getPoints();
			opposite_result=opposite.getPoints();
			System.out.println("The "+this.name+" has "+this_result+" points so far.");
			System.out.println("The "+opposite.name+" has "+opposite_result+" points so far.");
		}
		if(alive_count_2==0)
		{
			this.win++;
			opposite.lose++;
			System.out.println("The "+this.name+" win!");
		}
		else
		{
			this.lose++;
			opposite.win++;
			System.out.println("The "+opposite.name+" win!");
		}					
	}
	public void addChar(GameCharacter rookie)
	{	
		characters.add(rookie);		
	}
	public void removeChar(int index)
	{
		if(index<characters.size())
		{
			characters.remove(index);	
		}	
		else
		{
			System.out.println("Error: index not allowed!");
		}
	}
	public void removeChar(GameCharacter deserter)
	{
		int i;
		boolean found=false; 
		for(i=0;i<characters.size();i++)
		{
			if(characters.get(i)==deserter)
			{
				characters.remove( i);
				found=true;			
			}
		}
		if(found==false)
		{
			System.out.println("Error GameCharacter not found in team "+this.name);
		}

	}
	public GameCharacter searchChar(String name )
	{
		int i;
		for(i=0;i<characters.size();i++)
		{
			if(characters.get(i).getName()==name)
				return characters.get(i);		
		}
		System.out.println("Error: No character named "+name+"in team "+this.name);
		return null;
	}
	public double getPoints()
	{
		int i;
		double arithmetic_mean=0.0;
		for(i=0;i<characters.size();i++)
		{
			arithmetic_mean+=characters.get(i).getHP();
		}
		if(characters.size()>0)
			arithmetic_mean/=characters.size();
		return arithmetic_mean;
	}
}
