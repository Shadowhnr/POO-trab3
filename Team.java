import java.util.ArrayList;
import java.util.Random;

import GameCharacter.*;

public class Team {

		Random ran = new Random();

		/** (string) nome do time */
		private String name;
		/** (enum) cor do time */
		private Color color;
		/** (int) numero de vitorias */
		private int win;
		/** (int) numero de derrotas */
		private int lose;
		/** (int) numero de empater */
		private int draw;
		/** (int) tamanho do time */
		private int teamSize;
		/** time */
		private ArrayList<GameCharacter> characters;

		/**
		 * @brief construtor
		 * @param name (string) nome do time
		 * @param color (enum) cor do time
		 */
		public Team(String name, Color color) {
			characters = new ArrayList<GameCharacter>();
			this.name = name;
			this.color = color;
			win = 0;
			lose = 0;
			draw = 0;
			ran.setSeed(System.currentTimeMillis());
		}
		/**
		 * @brief retorna o nome do time
		 * @return (string) nome do time
		 */
		public String getName() {
			return name;
		}
		/**
		 * @brief retorna o resultado do time
		 * @return (string) contem o resultado do time
		 */
		public String getResults() {
			return 	"Win: " + win + " Lose: " + lose + " Draw: " + draw;
		}
		/**
		 * @brief retorna as informações do time
		 * @return (string) informações do time
		 */
		public String toString() {
			return "Nome: " + name + " Color: " + color;
		}
		/**
		 * @brief compara o numero de pontos entre os dois times, incrementa os atributos do time (vitórias, empates, derrotas)
		 * @param enemie (Team) time inimigo
		 * @return (int) 1 caso empate, 0 caso contrário
		 */
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
		/**
		 * @brief faz uma batalha entre dois times, escolhendo randomicamente os adversarios. O algoritmo para ataques
		 * randomicos utilizado foi o de numeros primos. Economiza processamento e memória.
		 * @param enemie (Team) time inimigo
		 */
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
		/**
		 * @brief adiciona um char ao time
		 * @param character (GameCharacter) character a ser adicionado ao time;
		 */
		public void addChar(GameCharacter character) {
			if(character == null){
				System.out.println("ERROR: Team::addChar(GameCharacter)");
				return;
			}
			characters.add(character);
			teamSize++;
			return;
		}
		/**
		 * @brief remove um character do time
		 * @param charNum (int) numero do char a ser removido
		 */
		public void removeChar(int charNum) {
			if(charNum < teamSize && charNum >= 0) {
				characters.remove(charNum);
				teamSize--;
			} else{
				System.out.println("ERROR: Team::removeChar(int)");
			}
		}
		/**
		 * @brief remove um character do time
		 * @param character (GameCharacter) character a ser removido
		 */
		public void removeChar(GameCharacter character) {
			boolean found = characters.remove(character);
			if(found == true)
				System.out.println("SUCESS: removeChar(GameCharacter)");
			else
				System.out.println("ERROR: removeChar(GameCharacter)");
		}
		/**
		 * @brief procura um character no time
		 * @param charName (string) nome do character
		 * @return (GameCharacter) character encontrado, null caso contrario
		 */
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
		/**
		 * @brief calcula os pontos do time (soma do HP total de todo o time dividida pelo tamanho do time)
		 * @return (double) pontos do time
		 */
		public double getPoints() {
			Integer HPTotal = 0;
			for(GameCharacter character : characters) {
				HPTotal += character.getHP();
			}
			return HPTotal.doubleValue() / (double)teamSize;
		}
		/**
		 * @brief calcula o primeiro numero primo maior que os numeros recebidos, função necessária para cálculo de ataques
		 * aleatorios na função battle
		 * @param a (int) numero 1
		 * @param b (int) numero 2
		 * @return (int) numero primo
		 */
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

