package Items;
import GameCharacter.*;
import GameObject.*;
public class ManaPotion extends Potion implements GameObject
{
	public ManaPotion(String name ,double price ,int restorepts)
	{
		super(name,price,restorepts);
		//sem implementacao pois a classe mae ja fez tudo.
	}
	public void use(GameCharacter user )
	{	
		user.addMP(this.restorepts);	
	}
}
