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
		String triangle =  this.name + " : triangle ("+ 
	("(x:"+Coor1.getX() + "," + "y:"+Coor1.getY())+
	("),(x:"+Coor2.getX() + "," + "y:"+Coor2.getY())+
	("),(x:"+Coor3.getX() + "," + "y:"+Coor3.getY())+"))";
		System.out.println(triangle);		
	}

	@Override
	public void move(int x,int y) {

		this.Coor1.move(x, y);
		this.Coor2.move(x, y);
		this.Coor3.move(x, y);

	}

}
