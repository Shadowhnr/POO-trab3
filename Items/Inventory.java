package Items;
import java.util.ArrayList;

public class Inventory {

		//Declaração dos atributos
		private double gold;
		private double weight;
		private int spaces;
		private int spacesFilled;	//Espaços ocupados
		private int MAX_WEAPON;	//limite superior para weapon
		private int MAX_ARMOR;	//limite superior para armor
		private int weaponLoaded;	//itens weapon carregados
		private int armorLoaded;	//itens armor carregados
		private int allDefPnts;	//soma de todos os pontos de defesa dos items no inventario
		private int allAttPnts;	//soma de todos os pontos de ataque dos items no inventario
		private ArrayList<ItemSet> items;

		public Inventory() {
			items = new ArrayList<ItemSet>();
			spaces = 4;
			spacesFilled = 0;
			allAttPnts = 0;
			allDefPnts = 0;
			gold = 0.0;
			MAX_WEAPON = 2;
			MAX_ARMOR = 1;
		}

		public double getTotalGold() {
			return gold;
		}

		public int getAvaliableSpace() {
			return (spaces - spacesFilled);
		}

		public void spendGold(double goldSpent) {
			if(gold - goldSpent < 0)
				System.out.println("Error: Inventory::spendGold(double): Você não tem dinheiro suficiente!");
			else {
				gold -= goldSpent;
				System.out.println("Sucess: Inventory::spendGold(double): Agora você possui $" + gold);
			}
		}

		public void earnGold(double goldEarned) {
			gold += goldEarned;
			System.out.println("Sucess: Inventory::earnGold(double): Agora você possui $" + gold);
		}

		public void setSpaces(int spaces) {
			this.spaces = spaces;
		}

		public ItemSet searchItem(int itemNum) {
			if((itemNum < 0 || itemNum >= spacesFilled)) {
				System.out.println("Error: Inventory::searchItem(int): Não foi possivel encontrar este item");
				return null;
			} else {
				ItemSet itemSet = items.get(itemNum);
				System.out.println("Sucess: Inventory::searchItem(int): O item " + itemSet.item.getName() + " foi encontrado.");
				return itemSet;
			}
		}

		public ItemSet searchItem(String itemName) {
			boolean found = false;
			for(ItemSet itemSet : items) {
				if(itemName.equals(itemSet.item.getName())) {
					System.out.println("SUCESS: Inventory::searchItem(string): O seguinte item foi encontrado: " + itemSet.item.getName());
					found = true;
					return itemSet;
				}
			}
			if(found == false)
				System.out.println("ERROR: Inventory::searchItem(string): O seguinte item não foi encontrado" + itemName);
			return null;
		}

		public void insertItem(Item item) {
			ItemSet itemSet = new ItemSet(item, false);
			if(!(spaces == spacesFilled)) {
				items.add(itemSet);
				spacesFilled++;
				System.out.println("Sucess: Inventory::insertItem(Item): O item " + item.getName() + " foi inserido com sucesso. Ainda há espaço para mais " + getAvaliableSpace() + " items.");
			} else
				System.out.println("Error: Inventory::insertItem(Item): O inventario está cheio.");
		}

		public void removeItem(String itemName) {
			ItemSet itemSet = searchItem(itemName);
			boolean sucess;
			if(itemSet != null) {
				unloadItemSet(itemSet);
				sucess = items.remove(itemSet);
				spacesFilled--;
				System.out.println("SUCESS: Inventory::removeItem(string): O item foi removido com sucesso (" + sucess + ")");
			} else {
				System.out.println("ERROR: Inventory::removeItem(string): O item não foi encontrado");
			}
		}

		public void removeItem(int itemNum) {
			if(itemNum < 0 || itemNum >= spacesFilled) {
				System.out.println("Error: Inventory::removeItem(int): Item inexistente");
			} else {
				unloadItemSet(searchItem(itemNum));
				items.remove(itemNum);
				spacesFilled--;
				System.out.println("Sucess: Inventory::removeItem(int): O item foi removido.");
			}
		}

		public void loadItemSet(ItemSet itemSet) {
			if(itemSet.loaded == false) {
				allAttPnts += itemSet.item.getAttackPts();
				allDefPnts += itemSet.item.getDefensePts();
				itemSet.loaded = true;
				System.out.println("Sucess: Inventory::loadItemSet(ItemSet): Item carregado");
				return;
			}
			System.out.println("Error: Inventory::loadItemSet(ItemSet): Item não carregado");
		}

		public void unloadItemSet(ItemSet itemSet) {
			if(itemSet.loaded == true) {
				allAttPnts -= itemSet.item.getAttackPts();
				allDefPnts -= itemSet.item.getDefensePts();
				itemSet.loaded = false;
				System.out.println("Sucess: Inventory::unloadItemSet(ItemSet): Item descarregado");
			}
			System.out.println("Error: Inventory::unloadItemSet(ItemSet): Item já descarregado");
		}

		public void loadItem(String itemName) {
			ItemSet itemSet = searchItem(itemName);
			if(itemSet == null) return;
			switch(itemSet.item.type()) {
			case weapon:
				if(weaponLoaded < MAX_WEAPON) {
					weaponLoaded++;
					loadItemSet(itemSet);
				} else System.out.println("ERROR: Inventory::loadItem(int): Maximo de itens carregados");
				return;
			case armor:
				if(armorLoaded < MAX_ARMOR) {
					armorLoaded++;
					weight += itemSet.item.getWeight();
					loadItemSet(itemSet);
				} else System.out.println("ERROR: Inventory::loadItem(int): Maximo de itens carregados");
				return;
			case healthpotion:
				itemSet.item.use();
				items.remove(itemSet);
				return;
			case manapotion:
				itemSet.item.use();
				items.remove(itemSet);
				return;
			default:
				loadItemSet(itemSet);
				return;
			}
		}

		public void loadItem(int itemNum) {
			ItemSet itemSet = searchItem(itemNum);
			if(itemSet == null) return;
			switch(itemSet.item.type()) {
			case weapon:
				if(weaponLoaded < MAX_WEAPON) {
					weaponLoaded++;
					loadItemSet(itemSet);
				} else System.out.println("ERROR: Inventory::loadItem(int): Maximo de itens carregados");
				return;
			case armor:
				if(armorLoaded < MAX_ARMOR) {
					armorLoaded++;
					weight += itemSet.item.getWeight();
					loadItemSet(itemSet);
				} else System.out.println("ERROR: Inventory::loadItem(int): Maximo de itens carregados");
				return;
			case healthpotion:
				itemSet.item.use();
				items.remove(itemSet);
				return;
			case manapotion:
				itemSet.item.use();
				items.remove(itemSet);
				return;
			default:
				loadItemSet(itemSet);
				return;
			}
		}

		public void unloadItem(String itemName) {
			ItemSet itemSet = searchItem(itemName);
			if(itemSet == null) return;
			if(itemSet.loaded == true) {
				if(itemSet.item.type() == ItemType.weapon) {
					weaponLoaded--;
					unloadItemSet(itemSet);
					return;
				}
				if(itemSet.item.type() == ItemType.armor) {
					armorLoaded--;
					weight -= itemSet.item.getWeight();
					unloadItemSet(itemSet);
					return;
				}
				unloadItemSet(itemSet);
			}
		}

		public void unloadItem(int itemNum) {
			ItemSet itemSet = searchItem(itemNum);
			if(itemSet == null) return;
			if(itemSet.loaded == true) {
				if(itemSet.item.type() == ItemType.weapon) {
					weaponLoaded--;
					unloadItemSet(itemSet);
					return;
				}
				if(itemSet.item.type() == ItemType.armor) {
					armorLoaded--;
					weight -= itemSet.item.getWeight();
					unloadItemSet(itemSet);
					return;
				}
				unloadItemSet(itemSet);
			}
		}

		public int getAllAttackPoints() {
			return allAttPnts;
		}


		public int getAllDefensePoints() {
			return allDefPnts;
		}

		public double getWeight() {
			return weight;
		}
}
