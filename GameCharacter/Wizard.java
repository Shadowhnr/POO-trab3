package GameCharacter;
import GameObject.*;
public class Wizard extends GameCharacter implements GameObject
{
	protected int wisdom;

	public Wizard(String name, int wisdom)
	{
		super(name);

		this.wisdom=wisdom;
	}

	public void addWisdom(int number)
	{
		this.wisdom+=number;
	}

	public int getAttackPts()
	{
		return this.getAttackPointsStandard();
	}

	public int getDefensePts()
	{
		return this.getDefensePointsStandard() + (wisdom/2);
	}
}
