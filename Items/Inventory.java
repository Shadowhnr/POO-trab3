package Items;
import GameCharacter.*;
import Utilities.*;
import java.util.ArrayList; 
public class Inventory
{
	private	int spaces;
	private	double gold;
	private ArrayList<MyPair<Item,Boolean> > items;
	private int[] weapon_index;
	private int armor_index;	
	private	int weapon_count;
        private int armor_count;		
	public Inventory()
	{
		spaces=10;
		gold =0;
		//variavel que representa o numero de armas equipadas em um inventario
		weapon_count=0;
		//variavel que representa o numero de armaduras equipadas em um invetario
		armor_count=0;	
		weapon_index= new int[2];
		//vetor de variaveis que representa os indices das armas equipadas.o valor sentinela e -1.
		weapon_index[0]=-1;
		weapon_index[1]=-1;
		//variavel que representa o indice da armadura equipadas.o valor sentinela e -1.
		armor_index=-1;
		//inicializa o vetor de items
		items = new ArrayList<MyPair<Item,Boolean> >();
	}
	public double getTotalGold()
	{
		return gold;
	}
	public int getAvailableSpace()
	{
		return spaces;
	}
	public void spendGold(double subtraction)
	{
		double result = gold - subtraction;
		if(result<0)
		{
			throw new InvalidInputException("Error: on Class Inventory, method spendGold : Insufficient gold ."); 	
		}
		else
		{
			 gold=result;
		}
	}
	public void earnGold(double reward)
	{
		gold += reward;
	}
	public void setSpaces(int size)
	{
		if(size>=0)
			spaces= size;
		else
			throw new InvalidInputException("Error: on Class Inventory, method setSpaces : size must be greather than or equal to 0");
	}
	//retorna um ponteiro pra Item ,sendo que se nao achar um Item com nome igual a
	//input,retorna null
	public Item searchItem (String input)
	{	
		int i;
		for(i=0;i<items.size();i++)
		{
			if(items.get(i).first.getName()==input)
			return items.get(i).first;
		}
		System.out.println("Error: item not found");
		return null;
	}
	public Item searchItem (int number)
	{
		if(number<items.size())
		{
			return items.get(number).first;	
		}
		System.out.println("Error: item not found");
		return null;
	}
	public void insertItem (Item new_item)
	{
		MyPair<Item,Boolean> aux=new MyPair<Item,Boolean>(new_item,false);		
		items.add(aux);
	}
	public void removeItem (String input)
	{
		int i;
		for(i=0;i<items.size();i++)
		{
			if(items.get(i).first.getName()==input)
			{
			
				items.remove(i);	
				if(i==weapon_index[0])
				{
					weapon_index[0]=-1;
					weapon_count--;
				}
				if(i==weapon_index[1])
				{
					weapon_index[1]=-1;
					weapon_count--;
				}
				if(i==armor_index)
				{
					armor_index=-1;
					armor_count--;
				}
					break;
			}		
		}	
	}

	public void removeItem (int index)
	{
		if(index<items.size())
		{
			items.remove(index);
			if(index==weapon_index[0])
			{
				weapon_index[0]=-1;
				weapon_count--;
			}
			if(index==weapon_index[1])
			{
				weapon_index[1]=-1;
				weapon_count--;
			}
			if(index==armor_index)
			{
				armor_index=-1;
				armor_count--;
			}
		}	
	}
	public void equipWeapon(String name)
	{
		int i;
		Boolean result=false; 
		for(i=0;i<items.size();i++)
		{
			if(items.get(i).first.getName()==name)		
			{		
				MyInt temp = new MyInt();
				temp.counter=weapon_count;
				result=items.get(i).first.equip(temp);
				weapon_count=temp.counter;	
				//se o resultado for de fato uma weapon ,e alem disso a cota de armas equipadas ainda nao foi getingida
				if(result==true)
				{				
					items.get(i).second=true;
					weapon_index[weapon_count-1]=i;
				}
			}
		}
	}
	public String equippedWeaponName()
	{
		String ss=" ";
		if(weapon_index[0]!=-1)
			ss=items.get(weapon_index[0]).first.getName();
		if(weapon_index[1]!=-1)
			ss+=" and a "+items.get(weapon_index[1]).first.getName();
		return ss;	
	}	
	public void equipArmor(String name)
	{
		int i;
		Boolean result=false; 
		for(i=0;i<items.size();i++)
		{	
			if(items.get(i).first.getName()==name)		
			{	
				MyInt temp = new MyInt(); 
				temp.counter=armor_count;
				result=items.get(i).first.equip(temp);
				armor_count=temp.counter;
				//se o resultado for de fato uma armor ,e alem disso a cota de armaduras equipadas ainda nao foi getingida
				if(result==true)
				{				
					items.get(i).second=true;
					armor_index=i;
				}	
			}
		}
	}
	public String equippedArmorName()
	{
		String aux = " ";
		if(armor_index!=-1)
		{
			aux= items.get(armor_index).first.getName();	
		}
		return aux;
	}
	public int getAttackPts()
	{
		int sum=0;
		int i;
		for(i=0;i<2;i++)
		{
			if(weapon_index[i]!=-1)
				sum+=items.get(weapon_index[i]).first.getAttackPts();		
		}
		return sum;
	}
	public MyPair<Integer,Double> getDefensePts()
	{
		MyPair<Integer,Double> result= new MyPair<Integer,Double>(0,0.0);	
		if(armor_index!=-1)
		{	
			result.first= items.get(armor_index).first.getDefensePts();
			result.second=items.get(armor_index).first.getWeight();
		}
		return result;		
	}
}
