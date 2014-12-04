package GameCharacter;

import java.util.Random;
import Items.*;



public class GameCharacter {
		/** (string) nome do character*/
		private String Alias; 
		/** (int) HP do character (vida)*/
		private int HP; 
		/** (int) limite máximo de HP (vida) */
		private int MAX_HP;	
		/** (int) limite máximo para XP (experiência) */
		private int MAX_XP; 
		/** (int) MP do character (mana) */
		private int MP; 
		/** (int) limite máximo para MP */
		private int MAX_MP;	
		/** inventário que armazena os itens do character */
		private Inventory myitems; 
		/** construindo random */
		Random ran = new Random(); 
		/** (int) XP do character (experiência) */
		protected int XP; 
		/** (int) força do character*/
		protected int strenght; 
		/** (int) velocidade do character */
		protected int speed;
		/** (int) destreza do character */
		protected int dexterity;
		/** (int) constituição do character */
		protected int constitution;
		/** (int) valor total de todos os atributos do character*/
		protected int attributes;


		public void removeItem(int itemNum) {
			myitems.removeItem(itemNum);
		}

		public void removeItem(String itemName) {
			myitems.removeItem(itemName);
		}

		public void insertItem(Item item) {
			myitems.insertItem(item);
		}

		public GameCharacter(String Alias) {
			ran.setSeed(System.currentTimeMillis());
			this.Alias = Alias;
			myitems = new Inventory();
			attributes = 100;
			HP = 100;
			MAX_XP = 100;
			MAX_MP = 100;
			//inicializa randomicamente alguns atributos
			XP = 1 + ran.nextInt(99);
			strenght = 1 + ran.nextInt(24);
			speed = 1 + ran.nextInt(24);
			dexterity = 1 + ran.nextInt(24);
			constitution = 1 + ran.nextInt(24);
			attributes -= (strenght + speed + dexterity + constitution);
		}

		public String getName() {
			return Alias;
		}

		protected int defensePoints() {
			Double defPnts;
			defPnts = ((XP) * (constitution * 0.5 + dexterity * 0.3 + getSpeed() * 0.2 + myitems.getAllDefensePoints()) / 2);
			return defPnts.intValue();
		}

		protected int attackPoints() {
			Double attPnts;
			attPnts = ((XP) * (strenght * 0.5 + dexterity * 0.3 + getSpeed() * 0.2 + myitems.getAllAttackPoints()) / 3);
			return attPnts.intValue();
		}

		protected int getAttackPoints() {
			return 0;
		}

		protected int getDefensePoints() {
			return 0;
		}

		public void addXP(int XPa) {
			if(XPa > 0 && XP + XPa <= MAX_XP)
				XP += XPa;
			else
				System.out.println("Error: Não foi possivel adicionar XP");
		}

		public void addHP(int restorepts) {
			if(HP + restorepts > MAX_HP) {
				HP = MAX_HP;
			} else {
				HP += restorepts;
			}
			System.out.println("SUCESS: Character::addHP(): HP atual: " + HP);
		}

		public void addMP(int restorepts) {
			if(MP + restorepts > MAX_MP) {
				HP = MAX_MP;
			} else {
				MP += restorepts;
			}
			System.out.println("SUCESS: Character::addMP(): MP atual: " + MP);
		}


		public void setStrenght(int newStrenght) {
			if(attributes + strenght >= newStrenght && newStrenght > 0) {
				attributes = attributes + strenght - newStrenght;
				strenght = newStrenght;
			} else
				System.out.println("Error: Não foi possivel modificar Strenght");
		}

		public void setSpeed(int newSpeed) {
			if(attributes + speed >= newSpeed && newSpeed > 0) {
				attributes = attributes + speed - newSpeed;
				speed = newSpeed;
			} else
				System.out.println("Error: Não foi possivel modificar Speed");
		}

		public void setDexterity(int newDexterity) {
			if(attributes + dexterity >= newDexterity && newDexterity > 0) {
				attributes = attributes + dexterity - newDexterity;
				dexterity = newDexterity;
			} else
				System.out.println("Error: Não foi possivel modificar dexterity");
		}

		public void setConstitution(int newConstitution) {
			if(attributes + constitution >= newConstitution && newConstitution > 0) {
				attributes = attributes + constitution - newConstitution;
				constitution = newConstitution;
			} else
				System.out.println("Error: Não foi possivel modificar Constitution");
		}

		public void attack(GameCharacter enemie) {
			int HPLost = 0;
			if(getHP() == 0) {
				System.out.println("INFO: " + Alias + " não está vivo");
				return;
			}
			if(enemie.getHP() == 0) {
				System.out.println("INFO: " + enemie.getName() + " não está vivo");
				return;
			}
			System.out.println("INFO: " + Alias + " ataca " + enemie.getName());
			if(ran.nextInt(10) < 1) {
				System.out.println("INFO: Ataque MISS");
				return;
			}//Miss
			else {
				HPLost = (this.getAttackPoints() - enemie.getDefensePoints()) + ran.nextInt(11) - 5;	//Dano puro
				if(HPLost <= 0)
					HPLost = 1;
				if(ran.nextInt(100)*XP < 1) {
					HPLost = 2 * HPLost;
					System.out.println("INFO: Ataque Crítico");
				}//Dano Critico
				if(enemie.HP - HPLost <= 0) {
					enemie.HP = 0;
					System.out.println("INFO: " + enemie.getName() + " perdeu " + HPLost + ". HP atual: " + enemie.HP);
					System.out.println("Failed: O Character " + enemie.getName() + " morreu.");
				} else {
					enemie.HP -= HPLost;
					System.out.println("INFO: " + enemie.getName() + " perdeu " + HPLost + ". HP atual: " + enemie.HP);
				}
			}
		}

		public void characterInfo() {
			System.out.println("\n**************************************************\n" +
							   "CHARACTER INFO\nAlias: " + Alias + "\nHP: " + HP + "\nXP: " + XP + "\nStrenght: " + strenght +
							   "\nSpeed: " + speed + "\nDexterity: " + dexterity + "\nConstitution: " + constitution +
							   "\nCharAttackPoints/CharItemAttackPoints: " + getAttackPoints() + "/" + myitems.getAllAttackPoints() +
							   "\nCharDefensePoints/CharItemDefensePoints: " + getDefensePoints() + "/" + myitems.getAllDefensePoints() +
							   "\n**************************************************");
		}

		public int getHP() {
			return HP;
		}

		public int getMP() {
			return MP;
		}

		public boolean isAlive() {
			return (HP != 0);
		}

		public int getSpeed() {
			Double x;
			x = speed * java.lang.Math.exp(-(myitems.getWeight() * myitems.getWeight()) / 20.0);
			return x.intValue();
		}
		
		//chama as funcoes do inventorio
		public void loadItem(int itemNum) {
			myitems.loadItem(itemNum);
		}
		public void loadItem(String itemName) {
			myitems.loadItem(itemName);
		}
		public void unloadItem(int itemNum) {
			myitems.unloadItem(itemNum);
		}
		public void unloadItem(String itemName) {
			myitems.unloadItem(itemName);
		}
}