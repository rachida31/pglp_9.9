package Dessin.TD_Dessin;

public abstract class Formes_Graphiques {
	
	
	protected String name;

	public Formes_Graphiques(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public abstract void print();
	public abstract void move(int x,int y);
}
