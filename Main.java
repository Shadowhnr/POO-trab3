//Trabalho 3 de Programacao Orientada a Objetos
//Nome: Helder de Melo Mendes     
// n usp : 850431
//Nome Gustavo Okuyama
// n usp :8504285 
import Items.*;
import GameCharacter.*;
import Utilities.*;
public class Main
{
	public static void main(String args[])
	{
			
		GameCharacter ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11,ch12,ch13,ch14,ch15,ch16;
		Team team_blue,team_red,team_white,team_black;
		Armor armor_1,armor_2,armor_3,armor_4,armor_5,armor_6;
		Weapon weapon_1,weapon_2,weapon_3,weapon_4,weapon_5,weapon_6,weapon_7,weapon_8,weapon_9,weapon_10;
		HealthPotion health_potion_1,health_potion_2,health_potion_3,health_potion_4,health_potion_5;
		ManaPotion mana_potion_1,mana_potion_2,mana_potion_3;	
		try
		{
			ch1= new Knight("Tacinnus Jykk",30);
			ch2= new Wizard("Brann Richard",20);
			ch3= new Thief("Hym Turrad",30);	
			ch4= new Knight("Kan Thusad",10);
			
			ch5= new Knight("Keith Yunard",30);
			ch6= new Wizard("Matt Taron",20);
			ch7= new Thief("Slavos Stramutsky",30);
			ch8= new Knight("Oomeru Gyre",10);
			
			ch9= new Knight("Lord Byron",30);
			ch10= new Wizard("Meth Alamine",20);
			ch11= new Thief("Junior Vandizek",30);	
			ch12= new Knight("Kal Wor",10);
			
			ch13= new Knight("Yu Mei",30);	
			ch14= new Knight("Trok Mann",30);
			ch15= new Wizard("Byron Russel",20);
			ch16= new Thief("Treceny Taylor",30);	


			team_blue= new Team("Thusand Warriors",Color.BLUE); 
			team_red= new Team("Iceland Warriors",Color.RED);
			team_white= new Team("Onderon Warriors",Color.WHITE);
			team_black= new Team("Agoge Warriors",Color.BLACK);
			armor_1= new Armor("leather armor",20.0,5,5.0);
			armor_2= new Armor("mithril armor",50.0,18,5.0);
			armor_3= new Armor("wooden armor",5.0,5,10.0);
			armor_4= new Armor("steel armor",13.0,10,8.0);
			armor_5= new Armor("power armor",15.0,8 ,10.0);
			armor_6= new Armor("iron armor",18.0,10,12.0);
			weapon_1= new Weapon("short sword",2.0,1,1);	
			weapon_2 = new Weapon("rapier",5.0,40,5);
			weapon_3= new Weapon("steel sword",4.0,30,1);
			weapon_4= new Weapon("wooden sword",3.0,10,1);
			weapon_5= new Weapon("steel dagger",2.0,30,1);
			weapon_6= new Weapon("large rock",2.0,20,10);
			weapon_7= new Weapon("iron mace",2.0,25,3);
			weapon_8= new Weapon("crossbow",2.0,18,10);
			weapon_9= new Weapon("bow",2.0,30,20);
			weapon_10= new Weapon("iron axe",2.0,30,3);
			health_potion_1= new HealthPotion("elixir",2.0,2);
			health_potion_2= new HealthPotion("small potion",5.0,5);
			health_potion_3= new HealthPotion("big potion",10.0,10);
			health_potion_4= new HealthPotion("life essence",30.0,50);
			health_potion_5= new HealthPotion("Life orb",500.0,100);
			mana_potion_1= new ManaPotion("small mana potion",5.0,5);
			mana_potion_2= new ManaPotion("big mana potion",10.0,10 );
			mana_potion_3= new ManaPotion("Magic Orb",500.0,100);
			ch1.addToInventory(armor_1);
			ch1.addToInventory(weapon_1);
			ch1.addToInventory(weapon_10);
			ch1.addToInventory(health_potion_1);
			ch1.addToInventory(mana_potion_1);
			ch1.equipWeapon("short sword");
			ch1.equipWeapon("iron axe");
			ch1.equipArmor("leather armor");				
			ch2.addToInventory(armor_2);			
			ch2.addToInventory(weapon_2);
			ch2.addToInventory(health_potion_2);
			ch2.addToInventory(mana_potion_2);
			ch2.equipWeapon("rapier");
			ch2.equipArmor("mithril armor");
			ch3.addToInventory(armor_3);
			ch3.addToInventory(weapon_3);
			ch3.addToInventory(health_potion_3);
			ch3.addToInventory(mana_potion_3);
			ch3.equipWeapon("steel sword");
			ch3.equipArmor("wooden armor");
			ch4.addToInventory(armor_4);
			ch4.addToInventory(weapon_4);
			ch4.addToInventory(health_potion_4);
			ch4.addToInventory(mana_potion_1);
			ch4.equipWeapon("wooden sword");
			ch4.equipArmor("steel armor");
			ch5.addToInventory(armor_5);
			ch5.addToInventory(weapon_5);
			ch5.addToInventory(weapon_10);
			ch5.addToInventory(health_potion_5);
			ch5.addToInventory(mana_potion_2);
			ch5.equipWeapon("steel dagger");
			ch5.equipWeapon("iron axe");
			ch5.equipArmor("power armor");					
			ch6.addToInventory(armor_6);
			ch6.addToInventory(weapon_6);
			ch6.addToInventory(health_potion_1);
			ch6.addToInventory(mana_potion_3);
			ch6.equipWeapon("large rock");
			ch6.equipArmor("iron armor");	
			ch7.addToInventory(armor_1);
			ch7.addToInventory(weapon_7);
			ch7.addToInventory(health_potion_2);
			ch7.addToInventory(mana_potion_1);
			ch7.equipWeapon("iron mace");
			ch7.equipArmor("leather armor");	
			ch8.addToInventory(armor_2);
			ch8.addToInventory(weapon_8);
			ch8.addToInventory(health_potion_3);
			ch8.addToInventory(mana_potion_2);
			ch8.equipWeapon("crossbow");
			ch8.equipArmor("mithril armor");
			ch9.addToInventory(armor_1);
			ch9.addToInventory(weapon_1);
			ch9.addToInventory(weapon_10);
			ch9.addToInventory(health_potion_1);
			ch9.addToInventory(mana_potion_1);
			ch9.equipWeapon("short sword");
			ch9.equipWeapon("iron axe");
			ch9.equipArmor("leather armor");
			ch10.addToInventory(armor_2);			
			ch10.addToInventory(weapon_2);
			ch10.addToInventory(health_potion_2);
			ch10.addToInventory(mana_potion_2);
			ch10.equipWeapon("rapier");
			ch10.equipArmor("mithril armor");
			ch11.addToInventory(health_potion_3);
			ch11.addToInventory(mana_potion_3);
			ch11.equipWeapon("steel sword");
			ch11.equipArmor("wooden armor");
			ch12.addToInventory(armor_4);
			ch12.addToInventory(weapon_4);
			ch12.addToInventory(health_potion_4);
			ch12.addToInventory(mana_potion_1);
			ch12.equipWeapon("wooden sword");
			ch12.equipArmor("steel armor");
			ch13.addToInventory(armor_5);
			ch13.addToInventory(weapon_5);
			ch13.addToInventory(weapon_10);
			ch13.addToInventory(health_potion_5);
			ch13.addToInventory(mana_potion_2);
			ch13.equipWeapon("steel dagger");
			ch13.equipWeapon("iron axe");
			ch13.equipArmor("power armor");	
			ch14.addToInventory(armor_6);
			ch14.addToInventory(weapon_6);
			ch14.addToInventory(health_potion_1);
			ch14.addToInventory(mana_potion_3);
			ch14.equipWeapon("large rock");
			ch14.equipArmor("iron armor");	
			ch15.addToInventory(armor_1);
			ch15.addToInventory(weapon_7);
			ch15.addToInventory(health_potion_2);
			ch15.addToInventory(mana_potion_1);
			ch15.equipWeapon("iron mace");
			ch15.equipArmor("leather armor");
			ch16.addToInventory(armor_2);
			ch16.addToInventory(weapon_8);
			ch16.addToInventory(health_potion_3);
			ch16.addToInventory(mana_potion_2);
			ch16.equipWeapon("crossbow");
			ch16.equipArmor("mithril armor");
	
	
			team_blue.addChar(ch1);
			team_blue.addChar(ch2);
			team_blue.addChar(ch3);
			team_blue.addChar(ch4);
			team_red.addChar(ch5);
			team_red.addChar(ch6);
			team_red.addChar(ch7);
			team_red.addChar(ch8);
			team_white.addChar(ch9);
			team_white.addChar(ch10);
			team_white.addChar(ch11);
			team_white.addChar(ch12);
			team_black.addChar(ch13);
			team_black.addChar(ch14);
			team_black.addChar(ch15);
			team_black.addChar(ch16);
			Battle battle1 = new Battle(team_blue,team_red);
			Battle battle2 = new Battle(team_white,team_black);	
			System.out.println("A DeathMatch starts now :");
			battle1.start();
			battle2.start();
			try
			{
				battle1.join();
				battle2.join();
				System.out.println();
				System.out.println("The battle between the survivors starts:");
				System.out.println();
				System.out.println();
				System.out.println();

				Battle battle3;
				if(team_blue.getWin()==1)
				{
					if(team_white.getWin()==1)
					{
						battle3=new Battle(team_blue,team_white);
						battle3.start();
					}
					else
					{
						battle3=new Battle(team_blue,team_black);
						battle3.start();
					}	
				}
				else
				{
					if(team_white.getWin()==1)
					{
						battle3=new Battle(team_red,team_white);
						battle3.start();
					}
					else
					{
						battle3=new Battle(team_red,team_black);
						battle3.start();
	
					}
				}
				
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		catch(InvalidInputException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
