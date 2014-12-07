package Utilities;
import java.util.Random;
public class RandomNumber
{
	private static Random generator;
	public static int nextInt(int number) { return generator.nextInt(number); }
	//essa declaracao fara com que quando o Class Loader passar pelo programa,a variavel generator sera inicializada
	static
	{
		generator = new Random();
	}
}
