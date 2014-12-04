package GameCharacter;

public class Knight extends GameCharacter { // implements gameObject
		
		protected int power;	/**atributo adicional do Knight */
		/**
		 * @brief construtor para o Knight
		 * verifica se o valor de power recebido é valido, senão assume 1.
		 * @param name (String) alias do personagem 
		 * @param power (int) valor de power atribuido ao Knight
		 */
		public Knight(String name, int power) {
			super(name);

			try{
				if((power < 1 || power > 100)) {
					throw new NotAllowedValue();
				}
				this.power = power;
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: Knight::Knight(String, int): %s\n", e.getMessage());
				this.power = 1;
			}
		}
		/**
		 * @brief adiciona power ao Knight
		 * verifica se o valor de power recebido é valido, senão não adiciona.
		 * @param add (int)valor de power a ser adicionado
		 */
		public void addPower(int add) {
			try{
				if(add + power > 100 || add + power < 1) {
					throw new NotAllowedValue();
				}
				power += add;
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: Knight::addPower(String, int): %s\n", e.getMessage());
			}
		}
		/**
		 * @brief retorna o valor de getDefensePoints
		 * @return (int) valor de getDefensePoints + power adicional da classe Knight
		 */
		@Override
		protected int getDefensePoints() {
			return defensePoints() + power;
		}
		/**
		 * @brief retorna o valor de getAttackPoints
		 * @return (int) valor de getAttackPoints
		 */
		@Override
		protected int getAttackPoints() {
			return attackPoints();
		}
}
