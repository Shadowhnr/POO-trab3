public abstract class Item //Item e uma classe abstrata,de maneira que nao pode ser instanciada
{
 	private String name;
	private double price;
	public Item(String name,double price)
	{		
		this.name  = name;
		
		if(price>=0.0)
			this.price = price;
		else
			throw new InvalidInputException("Error: An Item's price has to be over or equal to 0"); //tratamento de erro
	}
	@Override //sobrescreve o metodo clone de Object() 
	public Item clone()
	{
		return new Item(this.name,this.price);//cria uma copia do objeto referenciado
	}
	public String getName()
	{	
		return name;
	}
	public void use()
	{
		//sem implementacao em item
	}
	public double getPrice()
	{
		return price;		
	}
	boolean equip(int counter)
	{
		//metodo precisa retornar algo.mas e basicamente sem implementacao
		return false;
	}
	public double getWeight()
	{
		//metodo precisa retornar alguma coisa
		return 0.0;
	}
	//metodos abstratos(equivalentes aos virtuais puros do C++)
	public abstract int getDefensePts();
	public abstract int getAttackPts();
}
