package Items;
import Utilities.*;
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
	public Item clone()
	{
		return (Item)this.clone();//cria uma copia do objeto referenciado
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
	boolean equip(MyInt counter)
	{
		//metodo precisa retornar algo.mas e basicamente sem implementacao
		return false;
	}
	//o metodo getWeight() foi criado na classe Item para poder usa-lo polimorficamente no invetario , podendo usar armaduras como se fossem itens genericos.
	public double getWeight()
	{
		//metodo precisa retornar alguma coisa
		return 0.0;
	}
	public abstract int getAttackPts();	
	public abstract int getDefensePts();
}
