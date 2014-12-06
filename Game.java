import java.util.Random;

import Items.*;
import GameCharacter.*;

public class Game {

		public static void main(String[] args) {
			Random ran = new Random();
			ran.setSeed(System.currentTimeMillis());
			//Declaração dos objetos
			Team tm1, tm2;
			Knight kn1, kn2, kn3, kn4;
			Thief th1, th2;
			Wizard wz1, wz2;
			Weapon wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8, wp9, wp10;
			Armor a1, a2, a3, a4, a5, a6;
			HealthPotion hp1, hp2, hp3, hp4, hp5;
			ManaPotion mp1, mp2, mp3;
			//Instanciação do itens
			tm1 = new Team("Radiant", Color.green);
			tm2 = new Team("Dire", Color.red);
			wp1  = new Weapon("Machado a", 100.0, 1 + ran.nextInt(9), 40.0);
			wp2  = new Weapon("Machado b", 95.0, 1 + ran.nextInt(9), 40.0);
			wp3  = new Weapon("Martelo a", 90.0, 1 + ran.nextInt(9), 30.0);
			wp4  = new Weapon("Martelo b", 85.0, 1 + ran.nextInt(9), 30.0);
			wp5  = new Weapon("Faca a", 80.0, 1 + ran.nextInt(9), 20.0);
			wp6  = new Weapon("Faca b", 75.0, 1 + ran.nextInt(9), 20.0);
			wp7  = new Weapon("Espada a", 70.0, 1 + ran.nextInt(9), 15.0);
			wp8  = new Weapon("Espada b", 65.0, 1 + ran.nextInt(9), 15.0);
			wp9  = new Weapon("Arco a", 60.0, 1 + ran.nextInt(9), 60.0);
			wp10 = new Weapon("Arco b", 55.0, 1 + ran.nextInt(9), 60.0);

			a1 = new Armor("Escudo a", 90.0, 3 + ran.nextInt(20), 30.0);
			a2 = new Armor("Escudo b", 80.0, 3 + ran.nextInt(20), 25.0);
			a3 = new Armor("Escudo c", 70.0, 3 + ran.nextInt(20), 20.0);
			a4 = new Armor("Escudo d", 60.0, 3 + ran.nextInt(20), 15.0);
			a5 = new Armor("Escudo e", 50.0, 3 + ran.nextInt(20), 10.0);
			a6 = new Armor("Escudo f", 40.0, 3 + ran.nextInt(20), 09.0);

			wz1 = new Wizard("Gandalf", 16);
			wz2 = new Wizard("Saruman", 20);
			kn1 = new Knight("Aragorn", 5);
			kn2 = new Knight("Faramir", 7);
			kn3 = new Knight("Ugluk", 8);
			kn4 = new Knight("Azog", 12);
			th1 = new Thief("Frodo", 10);
			th2 = new Thief("Gollum", 16);

			hp1 = new HealthPotion("HP a", 30.0, 30);
			hp2 = new HealthPotion("HP b", 25.0, 25);
			hp3 = new HealthPotion("HP c", 20.0, 20);
			hp4 = new HealthPotion("HP d", 15.0, 15);
			hp5 = new HealthPotion("HP e", 10.0, 10);
			mp1 = new ManaPotion("MP a", 40.0, 40);
			mp2 = new ManaPotion("MP b", 30.0, 30);
			mp3 = new ManaPotion("MP c", 20.0, 20);

            //Inserindo Itens e carregando
			kn1.insertItem(a1);
			kn1.insertItem(a2);
			kn1.insertItem(wp1);
			kn1.insertItem(wp2);
			kn1.insertItem(wp3);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			kn2.insertItem(a3);
			kn2.insertItem(a4);
			kn2.insertItem(wp4);
			kn2.insertItem(wp5);
			kn2.insertItem(wp6);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			kn3.insertItem(a5);
			kn3.insertItem(a6);
			kn3.insertItem(wp7);
			kn3.insertItem(wp8);
			kn3.insertItem(wp9);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			kn4.insertItem(a1);
			kn4.insertItem(a2);
			kn4.insertItem(wp10);
			kn4.insertItem(hp1);
			kn4.insertItem(mp1);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			wz1.insertItem(a1);
			wz1.insertItem(a2);
			wz1.insertItem(wp10);
			wz1.insertItem(hp1);
			wz1.insertItem(mp1);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			wz2.insertItem(a3);
			wz2.insertItem(wp1);
			wz2.insertItem(wp2);
			wz2.insertItem(hp2);
			wz2.insertItem(mp2);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			th1.insertItem(a3);
			th1.insertItem(wp1);
			th1.insertItem(wp2);
			th1.insertItem(hp3);
			th1.insertItem(mp3);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			th2.insertItem(a1);
			th2.insertItem(wp5);
			th2.insertItem(wp8);
			th2.insertItem(hp4);
			th2.insertItem(hp5);
			kn1.loadItem(1);
			kn1.loadItem(2);
			kn1.loadItem(3);
			kn1.loadItem(4);
			kn1.loadItem(0);
			tm1.addChar(wz1);
			tm1.addChar(kn1);
			tm1.addChar(kn2);
			tm1.addChar(th1);
			tm2.addChar(wz2);
			tm2.addChar(kn3);
			tm2.addChar(kn4);
			tm2.addChar(th2);

			//Começando a batalha
			System.out.println(tm1.toString());
			System.out.println(tm2.toString());
			tm1.battle(tm2);
			tm1.resolveBattle(tm2);
			tm2.resolveBattle(tm1);
			System.out.println(tm1.toString() + "\n" + tm1.getResults());
			System.out.println(tm2.toString() + "\n" + tm2.getResults());
		}

}
