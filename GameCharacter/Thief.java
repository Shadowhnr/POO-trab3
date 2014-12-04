package GameCharacter;

public class Thief extends GameCharacter { // implements gameObject

		private int stealth;	/** atributo adicional de Thief*/

		/**
		 * @brief construtor para Thief
		 * verifica se o valor de stealth é válido, senão assume como 1.
		 * @param name (String) alias do Thief
		 * @param stealth (int) valor de stealth atribuído a Thief
		 */
		public Thief(String name, int stealth)  {
			super(name);

			try{
				if(stealth > 100 || stealth < 1) {
					throw new NotAllowedValue();
				}
				this.stealth = stealth;
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: Thief::Thief(String, int): %s\n", e.getMessage());
				this.stealth = 1;
			}
		}
		/**
		 * @brief adiciona stealth ao Thief, verifica se o valor é válido
		 * @param add (int) valor de Stealth a ser adicionado
		 */
		public void addStealth(int add) {
			try{
				if((stealth + add < 1 || stealth + add > 100)){
					throw new NotAllowedValue();
				}
				stealth += add;
			}catch(NotAllowedValue e){
				System.err.printf("ERROR: Thief::addStealth(String, int): %s\n", e.getMessage());
			}
		}
		/**
		 * @brief calcula os attackPoints do Thief
		 * @return (int) valor de attackPoints + stealth 
		 */
		@Override
		protected int getAttackPoints() {
			return attackPoints() + stealth;
		}
		/**
		 * @brief calcula os defensePoints do Thief
		 * @return (int) valor de attackPoints 
		 */
		@Override
		protected int getDefensePoints() {
			return defensePoints();
		}
}
