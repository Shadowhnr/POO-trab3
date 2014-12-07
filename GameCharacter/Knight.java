package GameCharacter;
import GameObject.*;
public class Knight extends  GameCharacter implements GameObject 
{
	protected int power;	
	public Knight(String name ,int power)
	{
		super(name);
		this.power=power;	
	}
	public void addPower(int number)
	{
		power+=number;
	}
	public int getAttackPts()
	{		
		return this.getAttackPointsStandard();		
	}
	public int getDefensePts()
	{
		return this.getDefensePointsStandard() + power;
	}
}
