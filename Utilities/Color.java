package Utilities;
//enumeracao que representara a cor dos times
public enum Color
{
	//esses campos sao constantes, por isso o nome em maiusculo:
	BLUE(0,0,255),
	RED(255,0,0),
	GREEN(0,255,0),
	YELLOW(255,255,0),
	WHITE(255,255,255),
	BLACK(0,0,0);
	//valores rgb para cores:
	private int red;
	private int green;
	private int blue;
	//construtor de enum's precisa ser private ou package-private:
	Color(int red,int green,int blue)
	{
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
}

