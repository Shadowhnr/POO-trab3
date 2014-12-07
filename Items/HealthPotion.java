package Items;
import GameCharacter.*;
import GameObject.*;
public class HealthPotion extends Potion implements GameObject 
{
	public HealthPotion(String name,double price,int restorepts)
	{
		super(name,price,restorepts);
		//o construtor de Potion faz todo o trabalho 
	}
	public void use(GameCharacter user)
	{
		user.addHP(this.restorepts);
	}
}
