public class Armor extends Item
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
	@Override	
	public Armor clone()
	{
		return new Armor(this.name,this.price,this.defensepts,this.weight);
	}
	public int getDefensePts()
	{
		return defensepts;
	}
	public int getAttackPts()
	{
		return 0;	
	}
	@Override
	public double getWeight()
	{
		return weight;
	}
	@Override
	public boolean equip(int counter)//contador dos slots
	{
		if(counter==1)
		{
			System.out.println("Error: Armor slot is full");
			return false;	
		}
		(counter)++;
		return true;	
	}
}

