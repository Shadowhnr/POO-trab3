package Items;
import GameCharacter.*;
import Utilities.*;
public abstract class Potion  extends Item 
{
	protected int restorepts;
	public abstract void use(GameCharacter user);	
	public Potion(String name,double price,int restorepts)
	{	
		//chama o construtor da classe herdada, que é executado primeiro
		super(name,price);
		this.restorepts=restorepts;//nao se criou restricoes ao valor de restorepts pois deu-se a liberdade de criacao de pocoes "malignas" , que prejudicariam o personagem ao inves de ajuda-lo.
	}
	public Potion clone()
	{
		return (Potion)this.clone();
	}
	public int getDefensePts()
	{	
		return restorepts;						
	}
	public int getAttackPts()
	{
		return 0;//o ataque das pocoes é zero.
	}
	public boolean equip(MyInt counter)
	{
		System.out.println("Error: not a weapon or an armor");
		return false;
	}
}
