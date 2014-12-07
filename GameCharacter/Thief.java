package GameCharacter;  
import GameObject.*;
public class Thief extends GameCharacter implements GameObject
{
	protected int stealth;
	public Thief(String name,int stealth)
	{
		super(name);
		this.stealth=stealth;
	}
	public void addStealth(int number)
	{
		this.stealth+=number;
	}
	public int getAttackPts()
	{
		return this.getAttackPointsStandard()+stealth;
	}
	public int getDefensePts()
	{
		return this.getDefensePointsStandard();
	}
}
