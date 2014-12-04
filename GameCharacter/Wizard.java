package GameCharacter;

public class Wizard extends GameCharacter {

		private int wisdom; /** atributo adicional do Wizard*/
		/**
		 * @brief construtor para Wizard
		 * verifica se o valor de wisdom é válido, senão assume como 1.
		 * @param name (string) alias do Wizard
		 * @param wisdom (int) valor de wisdom adicionado a Wizard
		 */
		public Wizard(String name, int wisdom) {
            super(name);

            try{
    			if(wisdom < 1 || wisdom > 100) {
    				throw new NotAllowedValue();
    			}
    			this.wisdom = 1;
            }catch(NotAllowedValue e){
                System.err.printf("ERROR: Wizard::Wizard(String, int): %s\n", e);
                this.wisdom = 1;
            }
		}

		public void addWisdom(int add) {
            try{
                if(wisdom + add > 100 || wisdom + add < 1) {
                    throw new NotAllowedValue();
                }
                wisdom += add;
            }catch(NotAllowedValue e){
                System.err.printf("ERROR: Wizard::addWisdom(String, int): %s\n", e);
            }
		}
        @Override
        protected int getDefensePoints() {
            return (int) defensePoints() + (wisdom / 2);
        }
        @Override
        protected int getAttackPoints() {
            return attackPoints();
        }
}
