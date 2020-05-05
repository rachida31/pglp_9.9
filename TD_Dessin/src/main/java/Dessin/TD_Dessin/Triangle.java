package Dessin.TD_Dessin;

public class Triangle extends Formes_Graphiques {
	private Coordonnee Coor1;
	private Coordonnee Coor2;
	private Coordonnee Coor3;

	public Triangle(String name,Coordonnee Coor1,Coordonnee Coor2,Coordonnee Coor3) {
		super(name);
		this.Coor1=new Coordonnee(Coor1.getX(),Coor1.getY());;
		this.Coor2=new Coordonnee(Coor2.getX(),Coor2.getY());;
		this.Coor3=new Coordonnee(Coor3.getX(),Coor3.getY());;
	}
	public Coordonnee getCoor1()
	{
		return this.Coor1;
	}
	public Coordonnee getCoor2()
	{
		return this.Coor2;
	}
	public Coordonnee getCoor3()
	{
		return this.Coor3;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
