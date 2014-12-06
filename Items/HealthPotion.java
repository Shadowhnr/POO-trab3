public class HealthPotion extends Potion
{
	public HealthPotion(String name,double price,int restorepts)
	{
		super(name,price,restorepts);
		//o construtor de Potion faz todo o trabalho 
	}
	@Override
	public void use(Character user)
	{
		user.addHP(this.restorepts);
	}
}
