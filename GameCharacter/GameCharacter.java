package GameCharacter;

import java.util.Random;
import Items.*;



public abstract class GameCharacter {
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
		
		/**
		 * @brief construtor do character
		 * Inicializa os atributos do character, estes incluem o inventário.
		 * Define alguns atributos aleatóriamente (para facilitar os testes) 
		 * @param Alias (string) nome do character
		 */
		public GameCharacter(String Alias) {
			ran.setSeed(System.currentTimeMillis());
			this.Alias = Alias;
			myitems = new Inventory();
			attributes = 100;
			HP = 100;
			MAX_XP = 100;
			MAX_MP = 100;
			XP = 1 + ran.nextInt(99);
			strenght = 1 + ran.nextInt(24);
			speed = 1 + ran.nextInt(24);
			dexterity = 1 + ran.nextInt(24);
			constitution = 1 + ran.nextInt(24);
			attributes -= (strenght + speed + dexterity + constitution);
		}

		/**
		 * @brief retorna o nome do personagem
		 * @return (string) nome do character
		 */
		public String getName() {
			return Alias;
		}
		
		/**
		 * @brief calcula os pontos de defesa padrão do character a partir de seus atributos
		 * @return (int) pontos de defesa
		 */
		
		protected int defensePoints() {
			Double defPnts;
			defPnts = ((XP) * (constitution * 0.5 + dexterity * 0.3 + getSpeed() * 0.2 + myitems.getAllDefensePoints()) / 2);
			return defPnts.intValue();
		}
		
		/**
		 * @brief retorna os pontos de ataque padrão do character a partir de seus atributos
		 * @return (int) pontos de ataque
		 */
		protected int attackPoints() {
			Double attPnts;
			attPnts = ((XP) * (strenght * 0.5 + dexterity * 0.3 + getSpeed() * 0.2 + myitems.getAllAttackPoints()) / 3);
			return attPnts.intValue();
		}
		/**
		 * @brief método abstrato para calcular os pontos de ataque de cada classe derivada, como varia de classe para classe
		 * portanto a solução foi coloca-la como abstrata
		 * @return (int) pontos de ataque totais do character
		 */
		abstract int getAttackPoints();
		/**
		 * @brief método abstrato para calcular os pontos de defesa de cada classe derivada, como varia de classe para classe
		 * portanto a solução foi coloca-la como abstrata
		 * @return (int) pontos de defesa do personagem
		 */
		abstract int getDefensePoints();

		/**
		 * @brief adiciona XP ao character. Verifica se o valor é permitido, caso contrário retorna mensagem de erro.
		 * @param XPa (int) XP a ser adicionado
		 */
		public void addXP(int XPa) {
			try{
				if(!(XPa > 0 && XP + XPa <= MAX_XP)){
					throw new NotAllowedValue();
				}
				XP += XPa;
				System.out.println("SUCESS: GameCharacter::addXP(): XP atual: " + XP);
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: GameCharacter::addXP(String, int): %s\n", e.getMessage());
			}
		}

		/**
		 * @brief adicona HP ao personagem, caso o HP seja maior que o permitido, carrega o valor máximo permitido
		 * @param restorepts (int) pontos de restauração do personagem, pode ser negativo.
		 */
		public void addHP(int restorepts) {
			if(HP + restorepts > MAX_HP) {
				HP = MAX_HP;
			} else {
				HP += restorepts;
				if(HP < 0){
					HP = 0;
				}
			}
			System.out.println("SUCESS: GameCharacter::addHP(): HP atual: " + HP);
		}
		/**
		 * @brief adicona MP ao personagem, caso o MP seja maior que o permitido, carrega o valor máximo permitido
		 * @param restorepts (int) pontos de restauração do personagem, pode ser negativo.
		 */
		public void addMP(int restorepts) {
			if(MP + restorepts > MAX_MP) {
				HP = MAX_MP;
			} else {
				MP += restorepts;
				if(MP < 0){
					MP = 0;
				}
			}
			System.out.println("SUCESS: GameCharacter::addMP(): MP atual: " + MP);
		}

		/**
		 * @brief setter para strenght, verifica se é possivel modificar, senão retorna mensagem de erro 
		 * @param newStrenght (int) nova strenght
		 */
		public void setStrenght(int newStrenght) {
			try{
				if(!(attributes + strenght >= newStrenght && newStrenght > 0)){
					throw new NotAllowedValue();
				}
				attributes = attributes + strenght - newStrenght;
				strenght = newStrenght;
				System.out.println("SUCESS: GameCharacter::setStrenght(): strenght: " + strenght);
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: GameCharacter::setStrenght (int): %s\n", e.getMessage());
			}
		}
		/**
		 * @brief setter para speed, verifica se é possivel modificar, senão retorna mensagem de erro 
		 * @param newSpeed (int) nova speed
		 */
		public void setSpeed(int newSpeed) {
			try{
				if(!(attributes + speed >= newSpeed && newSpeed > 0)) {
					throw new NotAllowedValue();
				}
				attributes = attributes + speed - newSpeed;
				speed = newSpeed;
				System.out.println("SUCESS: GameCharacter::setSpeed(): speed: " + speed);
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: GameCharacter::setSpeed (int): %s\n", e.getMessage());
			}
		}
		/**
		 * @brief setter para dexterity, verifica se é possivel modificar, senão retorna mensagem de erro 
		 * @param newDexterity (int) nova dexterity
		 */
		public void setDexterity(int newDexterity) {
			try{
				if(!(attributes + dexterity >= newDexterity && newDexterity > 0)) {
					throw new NotAllowedValue();
				}
				attributes = attributes + dexterity - newDexterity;
				dexterity = newDexterity;
				System.out.println("SUCESS: GameCharacter::setDexterity(): dexterity: " + dexterity);
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: GameCharacter::setDexterity (int): %s\n", e.getMessage());
			}
		}
		/**
		 * @brief setter para constitution, verifica se é possivel modificar, senão retorna mensagem de erro 
		 * @param newConstitution (int) nova constitution
		 */
		public void setConstitution(int newConstitution) {
			try{
				if(!(attributes + constitution >= newConstitution && newConstitution > 0)) {
					throw new NotAllowedValue();
				}
				attributes = attributes + constitution - newConstitution;
				constitution = newConstitution;
				System.out.println("SUCESS: GameCharacter::setConstitution(): constitution: " + constitution);
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: GameCharacter::setConstitution (int): %s\n", e.getMessage());
			}
		}
		/**
		 * @brief
		 * @param enemie (GameCharacter) character inimigo a receber o dano
		 */
		public void attack(GameCharacter enemie) {
			/** armazena o valor do dano a ser recebido após os cálculos*/
			int HPLost = 0;
			
			/** verifica se o character que vai atacar está vivo */
			if(getHP() == 0) {
				System.out.println("INFO: " + Alias + " não está vivo");
				return;
			}
			/** verifica se o character que vai ser atacado está vivo */
			if(enemie.getHP() == 0) {
				System.out.println("INFO: " + enemie.getName() + " não está vivo");
				return;
			}
			System.out.println("INFO: " + Alias + " ataca " + enemie.getName());
			/** probabilidade de o ataque dar miss */
			if(ran.nextInt(10) < 1) {
				System.out.println("INFO: Ataque MISS");
				return;
			}
			else {
				/** calculo do dano puro */
				HPLost = (this.getAttackPoints() - enemie.getDefensePoints()) + ran.nextInt(11) - 5;
				/** tratamento do dano negativo */
				if(HPLost <= 0)
					HPLost = 1;
				/** probablilidade do dano ser crítico */
				if(ran.nextInt(100)*XP < 1) {
					HPLost = 2 * HPLost;
					System.out.println("INFO: Ataque Crítico");
				}
				/** atribuição do dano */
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
		/**
		 * @brief imprime as informações do character
		 */
		public void characterInfo() {
			System.out.println("\n**************************************************\n" +
							   "CHARACTER INFO\nAlias: " + Alias + "\nHP: " + HP + "\nXP: " + XP + "\nStrenght: " + strenght +
							   "\nSpeed: " + speed + "\nDexterity: " + dexterity + "\nConstitution: " + constitution +
							   "\nCharAttackPoints/CharItemAttackPoints: " + getAttackPoints() + "/" + myitems.getAllAttackPoints() +
							   "\nCharDefensePoints/CharItemDefensePoints: " + getDefensePoints() + "/" + myitems.getAllDefensePoints() +
							   "\n**************************************************");
		}
		/**
		 * @brief Getter para HP
		 * @return (int) HP do character
		 */
		public int getHP() {
			return HP;
		}
		/**
		 * @brief getter para MP
		 * @return (int) MP do character
		 */
		public int getMP() {
			return MP;
		}
		/**
		 * @brief verifica se o character está vivo
		 * @return (bool) true para vivo, false para morto
		 */
		public boolean isAlive() {
			return (HP != 0);
		}
		/**
		 * @brief retorna a velocidade real do personagem baseada no peso de seu inventário
		 * @return (int) velocidade real
		 */
		public int getSpeed() {
			Double x;
			x = speed * java.lang.Math.exp(-(myitems.getWeight() * myitems.getWeight()) / 20.0);
			return x.intValue();
		}

		/**
		 * @brief remove o Item do inventário do personagem (solução encontrada foi chamar a função própria do inventário)
		 * @param itemNum (int) numero da posição do item a ser removido
		 */
		public void removeItem(int itemNum) {
			myitems.removeItem(itemNum);
		}
		/**
		 * @brief remove o Item do inventário do personagem (solução encontrada foi chamar a função própria do inventário)
		 * @param itemName (string) nome da posição do item a ser removido
		 */
		public void removeItem(String itemName) {
			myitems.removeItem(itemName);
		}
		/**
		 * @brief insere o Item do inventário do personagem (solução encontrada foi chamar a função própria do inventário)
		 * @param item (Item) item a ser inserido
		 */
		public void insertItem(Item item) {
			myitems.insertItem(item);
		}
		
		/**
		 * @brief carrega o algum Item que já está no inventório. (inserir o item no inventório não o carrega automaticamente)
		 * @param itemNum (int) numero do item do inventorio a ser carregado
		 */
		public void loadItem(int itemNum) {
			myitems.loadItem(itemNum);
		}
		/**
		 * @brief carrega o algum Item que já está no inventório. (inserir o item no inventório não o carrega automaticamente)
		 * @param itemName (string) nome do item do inventório a ser carregado
		 */
		public void loadItem(String itemName) {
			myitems.loadItem(itemName);
		}
		/**
		 * @brief descarrega o algum Item que já está no inventório. (descarregar o item do inventório não o remove automaticamente) 
		 * @param itemNum (int) numero do item a ser descarregado
		 */
		public void unloadItem(int itemNum) {
			myitems.unloadItem(itemNum);
		}
		/**
		 * @brief descarrega o algum Item que já está no inventório. (descarregar o item do inventório não o remove automaticamente) 
		 * @param itemNum (string) nome do item a ser descarregado
		 */
		public void unloadItem(String itemName) {
			myitems.unloadItem(itemName);
		}
}