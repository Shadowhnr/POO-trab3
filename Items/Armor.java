package Items;
import Utilities.*;
import GameObject.*;
public class Armor extends Item implements GameObject
{
	protected int defensepts;
	protected double weight;

	public Armor(String name ,double price,int defensepts,double weight)
	{
		super(name,price);
		if(defensepts>=1 && defensepts<=20)
			this.defensepts=defensepts;
		else
			throw new InvalidInputException("Error: Armor defepnsepts must be a value between 1 and 20.");
	
		if(weight >=1 && weight<=20)
			this.weight=weight;
		else
			throw new InvalidInputException("Error: Armor weight must be a value between 1 and 20.");
	
	}
	public Armor clone()
	{
		return (Armor)this.clone();
	}
	public int getDefensePts()
	{
		return defensepts;
	}
	public int getAttackPts()
	{
		return 0;	
	}
	public double getWeight()
	{
		return weight;
	}
	public boolean equip(MyInt myint)//classe que simula passagem por parametro. seu unico atributo é um contador , que representa os slots de arma. 
	{
		if(myint.counter==1)
		{
			System.out.println("Error: Armor slot is full");
			return false;	
		}
		myint.counter++;
		return true;	
	}
}

