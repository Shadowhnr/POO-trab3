public class ManaPotion extends Potion // a classe herda de Potion
{
	public ManaPotion(String name ,double price ,int restorepts)
	{
		super(name,price,restorepts);
		//sem implementacao pois a classe mae ja fez tudo.
	}
	@Override
	public void use(Character user )
	{	
		user.addMP(this.restorepts);	
	}
}
