package Utilities;
//classe inicialmente chamada de Pair, teve que receber modifcacao de nome para MyPair , pois existia um tipo conflitante do Java. 
public class MyPair<T,U>
{
	
	//fazendo  mimicamente como no C++, por isso os atributos sao public. a unica vantagem é o fato de que não é necessário criar setters e getters.
	public T first;
	public U second;
	
	public MyPair(T first,U second)
	{
		this.first=first;
		this.second= second;
	}					
}
