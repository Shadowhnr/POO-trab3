package GameCharacter;
import Items.*;
import Utilities.*;
public abstract class GameCharacter
{
	private	String alias;
	private	Inventory myitems;
	private	int HP;
	private	int MP;
	private	boolean is_alive; //essa variavel foi criada para representar se um dado personagem esta vivo.Algumas funcoes(normalmente as relacionadas a acoes e operacoes) só podem ser executadas quando o personagem referido estiver vivo.

	protected int XP;
	protected int strength;
	protected int speed;
	protected int dexterity;
	protected int constitution; 
	protected int attack_points;
	protected int defense_points; 
	protected boolean attackEquipped;
	protected boolean defenseEquipped;	
     

	public GameCharacter(String input)
	{
		alias=input;
		HP=100;
		MP=100;
		XP=1;
		//os atributos foram setados para 25 cada para a criacao de um padrao de personagens,independente de seus tipos.
		strength =25;
		speed=25;
		dexterity=25;
		constitution=25;
		myitems = new Inventory();
		//seta attack_points inicialmente para seu estado base,ou seja, com 'bare hands',que compoe o ataque sem armas
		attack_points=getAttackPointsStandard();
		//seta defense_points inicialmente para seu estado bose,ou seja,com 'own body',que compoe a defesa sem armadura
		defense_points=getDefensePointsStandard();
		//variavel que representa se o personagem esta vivo ou nao.
		is_alive=true;
		//variavel booleana que representa se o personagem tem pelo menos uma arma equipada
		attackEquipped=false;
		//variavel booleana que representa se o personagem tem uma armadura equipada
		defenseEquipped=false;
	}
	public String getName()
	{
		return alias;
	}
	public int getDefensePointsStandard()
	{
		MyPair<Integer,Double> defensepts;
		double value;
		double exponential_value;
		//pega os pontos de defesa da armadura equipada
		defensepts=this.myitems.getDefensePts();
		System.out.println(this.alias+" armor defensepts are "+defensepts.first);
		System.out.println(this.alias+" armor weight is "+defensepts.second);
		//faz o calculo da diminuicao da velocidade com base no peso da armadura
		exponential_value=this.speed*Math.exp(-((defensepts.second*defensepts.second)/400));
		this.speed=(int)exponential_value;
		if(defensepts.first!=0 || defensepts.second!=0.0)
			defenseEquipped=true;
		//modificacoes foram feitas para tornar as batalhas mais rapidas :
		value=(((constitution*.05+dexterity*.03+speed*.03)+(defensepts.first)*.05)*((double)XP/2));
		System.out.println(this.alias+" total defense points are "+(int)value);
		System.out.println(this.alias+" speed is "+speed);

		return (int)value;//faz o cast de ponto flutuante para inteiro
	}

	public int getAttackPointsStandard()
	{      
		int getAttack;
		double value;
		//pega os pontos de ataque da arma equipada
		getAttack = myitems.getAttackPts();
		System.out.println(this.alias+" weapon attack points are "+getAttack);
		if(getAttack!=0)
			attackEquipped=true;				
		
		value = ((( strength*0.5+dexterity*0.3 + speed*0.2 )+(getAttack))*((double)XP/3));
		System.out.println(this.alias+" total value of attack is  "+(int)value);	
		System.out.println(this.alias+" speed is "+speed);
		System.out.println(this.alias+" strength is "+strength);
		System.out.println(this.alias+" dexterity is "+dexterity);
		System.out.println(this.alias+" XP is "+XP);
		return (int) value;
	}

	public void attack(GameCharacter opponent)
	{	
		int result;
		RandomNumber rand=new RandomNumber();
		int rnd;
		rnd= rand.nextInt(11) -5; // gera um numero randomicamente entre -5 e 5.	
		if(this.is_alive && opponent.is_alive)	//certas funcoes so executam operacoes se os personagens envolvidos estao vivos.esta é uma delas.
		{
			System.out.print(this.alias+" attacks "+opponent.alias+" with ");
			if(attackEquipped==false)
			{
			    
			    System.out.print("bare hands,and "+opponent.alias+" defends with ");
			    
			    if(opponent.defenseEquipped==false)
			    {
				System.out.println("his own body. ");
			    }
			    else
			    {
				System.out.println("a "+opponent.myitems.equippedArmorName()+".");
			    }
			    
			}
			else
			{
			    System.out.print(this.myitems.equippedWeaponName()+", and "+opponent.alias+"  defends with ");
			    if(opponent.defenseEquipped==false)
			    {
				System.out.print("his own body. ");
			    }
			    else
			    {
				System.out.print("a "+opponent.myitems.equippedArmorName()+".");
			    }
			}
			result= (this.attack_points -opponent.defense_points) +rnd;
			rnd = rand.nextInt(1000) +1;
		//preferiu-se usar a funcao rand() com numeros inteiros,para evitar problemas com numeros de ponto flutuante.Por isso estimou-se o numero de 1 ate 1000,de forma que o minimo valor de(100/XP) continua sendo um inteiro(que no caso,é igual a 1).Isso nao invalida o fato de que a chance continua sendo (0.1/XP),pois é só multipicar o ultimo numero por 1000 para obter (100/XP);
			System.out.print("\n");
			if(rnd<=(100/XP))
			{
			    System.out.print(this.alias+" has missed the attack.\n");
			}
			else
			{
			    rnd=rand.nextInt(100) + 1;
		    //aqui pode-se usar numeros de 1 a 100,pois o menor numero obtido por rnd continua sendo inteiro. Tem-se que  (0.02*XP)/2 = 0.01*XP   , e esse resultado multiplicado por 100 =  XP.
			    if(rnd<=XP)
			    {
				result*=2;
				System.out.print("Critical strike!Damage is doubled!\n");
			    }
			    //observacao:mesmo e o dano for critico,se ele for negativo ou igual a 0,sera setado para 1.
			    if(result<=0)
			    {
				result=1;
			    }
			    if(opponent.HP - result<=0)//se o HP do oponente for para abaixo ou igual a 0,ele esta morto
			    {
				opponent.HP=0;
				System.out.println(opponent.alias+" has recieved "+result+" damage points!\n");
				System.out.println(opponent.alias +" has deceased.\n");
				opponent.is_alive=false;
				if(this.XP +5 <=100)
				{
					//a recompensa pela vitoria da batalha esta com o valor de 5 pontos de experiencia
					this.XP+=5;
				}
			    }
			    else
			    {
				opponent.HP-=result;
				System.out.println(opponent.alias+" has recieved "+result+" damage points!\n");
			    }
			}
	    }
	    else
	    {
		if(!this.is_alive)
		{
		    System.out.println("error: "+this.alias+" is dead");
		}
		else
		{
		    System.out.println("error: "+opponent.alias+" is dead");
		}
	    }
		
	}
	public void addXP(int amount)
	{
	    int sum;
	    if(is_alive)
	    {
		sum=XP+amount;
		if(sum<=100)
			XP=sum;
		else
			XP=100;
	    }
	    else
	    {
		 System.out.println("error: "+this.alias+" is dead");
	    }
	}
	public void setStrength(int strength)
	{
		if(strength>=1 && strength<=99)
			this.strength = strength;
		else
			throw new InvalidInputException("Invalid strength set");
	} 
	public void setSpeed(int speed)
	{
		if(speed>=1 && speed<=99)
			this.speed = speed;	
		else
			throw new InvalidInputException("Invalid speed set");
	}
	public void setDexterity(int dexterity)
	{
		if(dexterity>=1 && dexterity<=99)
			this.dexterity=dexterity;
		else
			throw new InvalidInputException("Invalid dexterity set");	
	}
	public void setConstitution(int constitution)
	{
		if(constitution>=1 && constitution<=99)
			this.constitution = constitution;
		else
			throw new InvalidInputException("Invalid constitution set");
	}
	public void equipWeapon(String name)
	{
	    if(is_alive)
	    {
		myitems.equipWeapon(name);
		this.attack_points=this.getAttackPointsStandard();	 
	    }
	    else
		System.out.println("error: "+this.alias+" is dead");
	}
	public void equipArmor(String name)
	{	
	    if(is_alive)
	    {		
		myitems.equipArmor(name);
		this.defense_points=this.getDefensePointsStandard();	
	    }
	    else
	    {
		System.out.println("error: "+this.alias+" is dead");
	    }
	}
	public void addToInventory(Item item)
	{
	    if(is_alive)
	    {
		this.myitems.insertItem(item);
	    }
	    else
	    {
		System.out.println("error: "+this.alias+" is dead");
	    }
	}
	public boolean isAlive()
	{
		return is_alive;
	}
	public void addHP(int number)
	{
		int sum=0;
		sum=this.HP+ number;
		if(sum<=100)
			this.HP=sum;
		else
			this.HP=100;
		
	}
	public void addMP(int number)
	{
		int sum=0;
		sum= this.MP + number;	
		if(sum<=100)
			this.MP=sum;
		else
			this.MP=100;
	}
	public int getHP()
	{
		return this.HP;
	}
	public int getMP()
	{
		return this.MP;
	}
}


