public abstract class Potion  extends Item 
{
	protected int restorepts;
	public abstract void use(Character user);	
	public Potion(String name,double price,int restorepts)
	{	
		//chama o construtor da classe herdada, que é executado primeiro
		super(name,price);
		this.restorepts=restorepts;//nao se criou restricoes ao valor de restorepts pois deu-se a liberdade de criacao de pocoes "malignas" , que prejudicariam o personagem ao inves de ajuda-lo.
	}
	@Override
	public Potion clone()
	{
		return new Potion(this.name,this.price,this.restorepts);
	}
	public int getDefensePts()
	{	
		return restorepts;						
	}
	public int getAttackPts()
	{
		return 0;//o ataque das pocoes é zero.
	}
	public boolean equip(int counter)
	{
		System.out.println("Error: not a weapon or an armor");
		return false;
	}
}
