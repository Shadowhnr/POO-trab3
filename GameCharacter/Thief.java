package GameCharacter;

public class Thief extends GameCharacter implements gameObject {

		private int stealth;

		public Thief(String name, int stealth)  {
			super(name);

			try{
				if(stealth > 100 || stealth < 1) {
					throw new NotAllowedValue();
				}
				this.stealth = stealth;
			}catch(NotAllowedValue e){
				this.stealth = 1;			
			}
		}

		@Override
		protected int getAttackPoints() {
			return attackPoints() + stealth;
		}
		@Override
		protected int getDefensePoints() {
			return defensePoints();
		}

		public void addStealth(int add) {
			try{
				if((stealth + add < 1 || stealth + add > 100)){
					throw new NotAllowedValue();
				}	
				stealth += add;
			}catch(NotAllowedValue e){
				System.out.println("ERROR: Thief::addStealth()");
			}
		}
}
