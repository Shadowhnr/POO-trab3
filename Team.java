import java.util.ArrayList;
import java.util.Random;

import GameCharacter.*;

public class Team {

		Random ran = new Random();

		private String name;
		private Color color;
		private int win;
		private int lose;
		private int draw;
		private int teamSize;
		private ArrayList<GameCharacter> characters;

		public Team(String name, Color color) {
			characters = new ArrayList<GameCharacter>();
			this.name = name;
			this.color = color;
			win = 0;
			lose = 0;
			draw = 0;
			ran.setSeed(System.currentTimeMillis());
		}
		public String getName() {
			return name;
		}

		public String getResults() {
			return 	"Win: " + win + " Lose: " + lose + " Draw: " + draw;
		}

		public String toString() {
			return "Nome: " + name + " Color: " + color;
		}

		public int resolveBattle(Team enemie) {
			if(getPoints() > enemie.getPoints()) {
				win++;
				return 0;
			}
			if(getPoints() < enemie.getPoints()) {
				lose++;
				return 0;
			} else {
				draw++;
				return 1;
			}
		}

		public void battle(Team enemie) {
			int i, prime, aux1, aux2;
			prime = firstPrime(teamSize, enemie.teamSize);
			aux1 = ran.nextInt(teamSize);
			aux2 = ran.nextInt(teamSize);
			for(i = 0; i < teamSize; i++) {
				System.out.println("\n" + getName() + " ataca " + enemie.getName());
				(characters.get(aux1)).attack(enemie.characters.get(aux2));
				System.out.println("\n" + enemie.getName() + " ataca " + getName());
				(enemie.characters.get(aux2)).attack(characters.get(aux1));
				aux1 = (aux1 + prime) % teamSize;
				aux2 = (aux2 + prime) % teamSize;
			}
		}

		public void addChar(GameCharacter character) {
			if(character == null)
				return;
			characters.add(character);
			teamSize++;
			return;
		}

		public void removeChar(int charNum) {
			if(charNum < teamSize && charNum >= 0) {
				characters.remove(charNum);
				teamSize--;
			} else
				System.out.println("ERROR: Team::removeChar(int)");
		}

		public void removeChar(GameCharacter character) {
			boolean found = characters.remove(character);
			if(found == true)
				System.out.println("SUCESS: removeChar(GameCharacter)");
			else
				System.out.println("ERROR: removeChar(GameCharacter)");
		}

		public GameCharacter searchChar(String charName) {
			boolean found = false;
			for(GameCharacter character : characters) {
				if(charName.equals(character.getName())) {
					System.out.println("SUCESS: O seguinte item foi encontrado: " + character.getName());
					found = true;
					return character;
				}
			}
			if(found == false)
				System.out.println("ERROR: Team::searchChar(string): O seguinte item não foi encontrado" + charName);
			return null;
		}

		public double getPoints() {
			Integer HPTotal = 0;
			for(GameCharacter character : characters) {
				HPTotal += character.getHP();
			}
			return HPTotal.doubleValue() / (double)teamSize;
		}

		public int firstPrime(int a, int b) {
			int x, j;
			boolean isPrime = false, aux;
			if(a > b) x = a;
			else x = b;
			while(!isPrime) {
				aux = false;
				for(j = 2; j < x; j++) {
					if(x % j == 0) {
						aux = true;
					}
				}
				if(aux == false) isPrime = true;
				else x++;
			}
			return x;
		}
}

