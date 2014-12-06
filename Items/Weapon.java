public class Weapon extends Item
{
	protected int attackpts;
	protected double range;
	//chama o construtor de Item ,e depois executa as operacoes do construtor de Weapon 
	public Weapon(String name,double price,int attackpts,double range)
	{
		super(name,price);
		if(attackpts>=1 && attackpts<=9)
			this.attackpts=attackpts;
		else
			throw new InvalidInputException("Error: Weapon attackpts must be a value between 1 and 9.");
		if(range>=0)
			this.range=range;
		else
			throw new InvalidInputException("Error: Weapon Range must be a value greater than or equal to 0.");
	
	}
	//construtor de copia
	@Override
	public Weapon clone()
	{
		return new Weapon(this.name,this.price,this.attackpts,this.range);
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
	@Override
	public boolean equip(int counter)//contador dos slots
	{									
		if(counter==2)
		{
			System.out.println("Error: Weapon slot is full");
			return false;
		}
		(counter)++;
		return true;		
	}
}	
