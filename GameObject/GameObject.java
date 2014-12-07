package GameObject;
//interface que indica as classes concretas que fazem parte do jogo ativamente
public interface GameObject
{
	//obrigada as classes que implementam essa interface a implementar esses metodos :
	 int getDefensePts();
	 int getAttackPts(); 
	//observacao: todos os metodos de uma interface sao abstratos e publicos.portanto é desnecessario, e desencorajado pela JLS(Java Language Especification) que eles sejam redundantemente declarados como tais.
}
