import GameCharacter.*;
import Utilities.*; 
import java.util.ArrayList;
public class Team
{
	private	String name;
	private	Color color;
	private	int win;
	private	int loss;
	private  int draw;
	//atributo publico para facilitar o uso de multithreading
	public	ArrayList<GameCharacter> characters;
	public Team(String name,Color color)
	{
		this.name=name;
		this.color=color;
		win=0;
		loss=0;
		draw=0;
		characters = new ArrayList<GameCharacter>();	
	}
	public String getName()
	{
		return name;
	}
	public Color getColor()
	{
		return color;
	}
	public void addWin()
	{
		win++;	
	}
	public void addLoss()
	{
		loss++;
	}
	public void addDraw()
	{
		draw++;
	}

	public String getResults()
	{
		String aux;//stream usada para conversao de int para string
		aux="The team "+this.name+" has until now "+win+" wins, "+loss+" losses, and "+draw+" draws\n";
		return aux;
	}
	public String toString()
	{
		String aux;
		aux="The team name is "+this.name+" and it's color is "+this.color+"\n";
		return aux;
	}

	public void addChar(GameCharacter rookie)
	{	
		characters.add(rookie);		
	}
	public void removeChar(int index)
	{
		if(index<characters.size())
		{
			characters.remove(index);	
		}	
		else
		{
			System.out.println("Error: index not allowed!");
		}
	}
	public void removeChar(GameCharacter deserter)
	{
		int i;
		boolean found=false; 
		for(i=0;i<characters.size();i++)
		{
			if(characters.get(i)==deserter)
			{
				characters.remove( i);
				found=true;			
			}
		}
		if(found==false)
		{
			System.out.println("Error GameCharacter not found in team "+this.name);
		}

	}
	public GameCharacter searchChar(String name )
	{
		int i;
		for(i=0;i<characters.size();i++)
		{
			if(characters.get(i).getName()==name)
				return characters.get(i);		
		}
		System.out.println("Error: No character named "+name+"in team "+this.name);
		return null;
	}
	public double getPoints()
	{
		int i;
		double arithmetic_mean=0.0;
		for(i=0;i<characters.size();i++)
		{
			arithmetic_mean+=characters.get(i).getHP();
		}
		if(characters.size()>0)
			arithmetic_mean/=characters.size();
		return arithmetic_mean;
	}
	public int getWin()
	{
		return win;	
	}
}
