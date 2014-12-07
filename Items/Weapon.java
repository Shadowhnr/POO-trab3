package Items;
import Utilities.*;
import GameObject.*;
public class Weapon extends Item implements GameObject
{
	protected int attackpts;
	protected double range;
	//chama o construtor de Item ,e depois executa as operacoes do construtor de Weapon 
	public Weapon(String name,double price,int attackpts,double range)
	{
		super(name,price);
		if(attackpts>=1 && attackpts<=50)
			this.attackpts=attackpts;
		else
			throw new InvalidInputException("Error: Weapon attackpts must be a value between 1 and 50.");
		if(range>=0)
			this.range=range;
		else
			throw new InvalidInputException("Error: Weapon Range must be a value greater than or equal to 0.");
	
	}
	//construtor de copia
	public Weapon clone()
	{
		return (Weapon)this.clone();
	}
	public int getDefensePts()
	{
		return 0;
	}
	public int getAttackPts()
	{
		return this.attackpts;
	}
	public double getRange()
	{
		return this.range;	
	}
	//funcao polimorfica que decidira se o item e uma armadura ou uma arma, e alem disso determinara se existem slots ou nao para serem preenchidos.
	public boolean equip(MyInt myint)//classe que simula passagem por parametro. seu unico atributo é um contador , que representa os slots de arma. 
	{									
		if(myint.counter==2)
		{
			System.out.println("Error: Weapon slot is full");
			return false;
		}
		myint.counter++;
		return true;		
	}
}	
