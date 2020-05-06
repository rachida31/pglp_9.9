package Dessin.TD_Dessin;

public class Carre extends Formes_Graphiques {
	private Coordonnee Coor;
	private int cote;
	public Carre(String name,Coordonnee Coor,int cote) {
		super(name);
		this.Coor=new Coordonnee(Coor.getX(),Coor.getY());
		this.cote=cote;
	}
	public Coordonnee getCoor()
	{
		return this.Coor;
	}
	public int getCote()
	{
		return this.cote;
	}
	@Override
	public void print() {
		String carre =  this.name + " : carre ((coté:" + cote +") "
				 + ("(x:"+Coor.getX() + "," + "y:"+Coor.getY())+"))";
		System.out.println(carre);		
	}

	@Override
	public void move(int x,int y) {
		this.Coor.move(x, y);
	}

}
