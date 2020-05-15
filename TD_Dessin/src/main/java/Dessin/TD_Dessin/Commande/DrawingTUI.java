package Dessin.TD_Dessin.Commande;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Formes_Graphiques;
import Dessin.TD_Dessin.DAO.DaoFactory;


public class DrawingTUI {
	private Formes_Graphiques forme;
	//private ArrayList<String> l;
	//private DaoFactory drf;
	public DrawingTUI()
	{
		this.forme=null;
		//this.l= new ArrayList<String>();
		//drf=new DaoFactory();
	}
	public void dessinGroupe( ArrayList<String> l) throws Exception
	{
    	System.out.println("dessin groupe ");
    	Formes_Graphiques f=null;
		if(l.get(1).equalsIgnoreCase("groupe"))
		{ 
        	System.out.println("hhhhhhhhhhhh groupe ");
	        	
	        		if(l.size()<=3)
	        		{
	        		System.out.println(" Merci de mettre le bon nombre d\'element pour crer le groupe !");
	        		forme=null;
	        		}
	        		else if(!("g".regionMatches(true, 0, l.get(0), 0, 1)))
	        		{
	            	System.out.println(" Merci de mettre le nom de votre groupe comme suit : \" g \" avec un chiffre !");	
	        		forme=null;
	        		}
	        		else 
	        		{
	        			int i=2;
      		    	  System.out.println("taaaaaaiiiiiiilllllee  "+l.size());
      		    	  while(i<l.size())
      		    	  { 	System.out.println("qqqqqqqqqqqqqqqxxxxxxxxxxx");	  

      		    		  if(("a".regionMatches(true, 0, l.get(i), 0, 1)))
      		  	        {System.out.println("44444444444444111111111111");
    		  	        	  f=DaoFactory.getCarreDAO().read(l.get(i));
    		  	        	  f.print();
    		  	        }
    		  	          else if(("c".regionMatches(true, 0, l.get(i), 0, 1)))
    		  		        {	
    		  	        	  System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssss");
    		  	        	  f=DaoFactory.getCercleDAO().read(l.get(i));
    		  	        	  f.print();

    		  		        }   else if(("t".regionMatches(true, 0, l.get(i), 0, 1)))
    		  		        {     System.out.println("tttttttttttttttttttttttttttttttt");

    		  		        	  f=DaoFactory.getTriangleDAO().read(l.get(i));
    		  		        	  f.print();

    		  		        }   else if(("r".regionMatches(true, 0, l.get(i), 0, 1)))
    		  		        {
    		  		        	  f=DaoFactory.getRectangleDAO().read(l.get(i));
    		  		        	  f.print();
    		  		        }
      		    		  if(f==null)
      		    		  {
                		System.out.println("La forme "+l.get(i)+" n'existe pas vous douvez  mttre une forme qui existe merci!");	  
      		    		forme=new Cercle ("c0",new Coordonnee(0,0),0);
      		    		
                		break;
      		    		  }
      		    		  i++;
      		    	  }
	        			if(f!=null) { 
      		    	  System.out.println("ddddddddddddddddddddddddddddd");
	  	        		    forme=DaoFactory.getForm_GroupeDAO().read(l.get(0));
	        		  //  forme.print();
	        		      if(forme!=null)
	        		      {
	        		    	 // forme=null;
	        	        System.out.println("Le nom que vous avez donner a votre groupe existe déja merci de le modifier!");
	        		      }
	        		      else {
	        		    	  System.out.println("yyyyyyyyyyyyyyyeeeeeeeeeeeeessssssssssss");
	        		      }
	        		      }
	        			else System.out.println("nnnnnnnnnnoooooooooooonnnnnnnnnn");	
	        		}}
							}
	public void dessinForme( ArrayList<String> l) throws Exception
	{
       System.out.println(l);
     
   	System.out.println("dessin forme ");
 
        if(l.get(1).equalsIgnoreCase("cercle"))
        { 
        	System.out.println("cercle");
        	forme=new Cercle("c0",new Coordonnee(0,0),0);
        		if(l.size()!=5)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre cercle !");
        		
        		}
        		else if(!("c".regionMatches(true, 0, l.get(0), 0, 1)))
        		{
            	System.out.println(" Merci de mettre le nom de votre cercle comme suit : \" c \" avec un chiffre !");	
        		
        		}
        		else 
        		{
        		    forme=DaoFactory.getCercleDAO().read(l.get(0));
        		      if(forme!=null)
        		      {
        	        System.out.println("Le nom que vous avez donner a votre cercle existe déja merci de le modifier!");

        		      }
        		}
        		
        	
       			
        }
        else if(l.get(1).equalsIgnoreCase("Carre"))
        {if(l.size()!=5)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre carre !");
        		forme=null;
        		}
        		else if(!("a".regionMatches(true, 0, l.get(0), 0, 1)))
        		{
            	System.out.println(" Merci de mettre le nom de votre carre comme suit : \" a \" avec un chiffre !");	
        		forme=null;
        		}
        		else 
        		{
        		    forme=DaoFactory.getCarreDAO().read(l.get(0));
        		      if(forme!=null)
        		      {
        	        System.out.println("Le nom que vous avez donner a votre carre existe déja merci de le modifier!");

        		      }
        		}
        		

        }
        else if(l.get(1).equalsIgnoreCase("Triangle"))
        {
        		if(l.size()!=8)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre triangle !");
        		forme=null;
        		}
        		else if(!("t".regionMatches(true, 0, l.get(0), 0, 1)))
        		{
            	System.out.println(" Merci de mettre le nom de votre triangele comme suit : \" t \" avec un chiffre !");	
        		forme=null;
        		}
        		else 
        		{
        		    forme=DaoFactory.getTriangleDAO().read(l.get(0));
        		      if(forme!=null)
        		      {
        	        System.out.println("Le nom que vous avez donner a votre triangle existe déja merci de le modifier!");

        		      }
        		}

        }
        else if(l.get(1).equalsIgnoreCase("Rectangle"))
        {
        	
        		if(l.size()!=6)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre rectangle !");
        		forme=null;
        		}
        		else if(!("r".regionMatches(true, 0, l.get(0), 0, 1)))
        		{
            	System.out.println(" Merci de mettre le nom de votre rectangle comme suit : \" r \" avec un chiffre !");	
        		forme=null;
        		}
        		else 
        		{
        		    forme=DaoFactory.getRectangleDAO().read(l.get(0));
        		      if(forme!=null)
        		      {
        	        System.out.println("Le nom que vous avez donner a votre rectangle existe déja merci de le modifier!");

        		      }
        		}
        	
        }
		
	}
	public void deplacerForme( ArrayList<String> l) throws Exception
	{
	   	System.out.println("deplacer forme ");

	        		if(l.size()!=4)
	        		{
	        		System.out.println(" Merci de mettre le bon nombre d\'element pour effectuer le deplacement !");
	        		forme=null;
	        		}
	          else if(("a".regionMatches(true, 0, l.get(1), 0, 1)))
	        {
	        	  forme=DaoFactory.getCarreDAO().read(l.get(1));
	        }
	          else if(("c".regionMatches(true, 0, l.get(1), 0, 1)))
		        {	   	        	  System.out.println("jjjjjjjjjjjjjjjjhhhhhhhhh  "+ l.get(1));
     	 
	        	  forme=DaoFactory.getCercleDAO().read(l.get(1));
forme.print();
		        }   else if(("t".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getTriangleDAO().read(l.get(1));

		        }   else if(("r".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getRectangleDAO().read(l.get(1));
		        }
		        else if(("g".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getForm_GroupeDAO().read(l.get(1));
		        }
			        	   	        	  System.out.println("jjjjjjjjjjjjjjjjtttttttttttthhhhhhhhh  "+ l.get(1));

	}
	public void afficheForme( ArrayList<String> l) throws Exception
	{
	   	System.out.println("affiche forme ");

	        		if(l.size()!=2)
	        		{
	        		System.out.println(" Merci de mettre le bon nombre d\'element pour afficher!");
	        		forme=null;
	        		}
	          else if(("a".regionMatches(true, 0, l.get(1), 0, 1)))
	        {
	        	  forme=DaoFactory.getCarreDAO().read(l.get(1));

	        }
	          else if(("c".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
	        	  forme=DaoFactory.getCercleDAO().read(l.get(1));
	        	  forme.print();
 
		        }   else if(!("t".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getTriangleDAO().read(l.get(1));
		        }   else if(("r".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getRectangleDAO().read(l.get(1));
		        } else if(("g".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getForm_GroupeDAO().read(l.get(1));
		        }
	
	}
	public void deleteForme( ArrayList<String> l) throws Exception
	{
	   	System.out.println("effacer forme ");
	        		if(l.size()!=2)
	        		{
	        		System.out.println(" Merci de mettre le bon nombre d\'element pour supprimer!");
	        		forme=null;
	        		}
	          else if(!("a".regionMatches(true, 0, l.get(1), 0, 1)))
	        {
	        	  forme=DaoFactory.getCarreDAO().read(l.get(1));

	        }
	          else if(!("c".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
	        	  forme=DaoFactory.getCercleDAO().read(l.get(1));
 
		        }   else if(!("t".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getTriangleDAO().read(l.get(1));
		        }   else if(!("r".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getRectangleDAO().read(l.get(1));
		        } else if(!("g".regionMatches(true, 0, l.get(1), 0, 1)))
		        {
		        	  forme=DaoFactory.getForm_GroupeDAO().read(l.get(1));
		        }
	
	}
	public  ArrayList<String> liste(String str)
	{
		 ArrayList<String> l=new  ArrayList<String>();
		 System.out.println( "Hello World! "+ str );
		 //l=null;
	        StringTokenizer multiTokenizer = new StringTokenizer(str, "=(), ");
	        System.out.println("length kkkkkkkk "+multiTokenizer.hasMoreTokens());
	        while (multiTokenizer.hasMoreTokens())
	        {
	        	String a= multiTokenizer.nextToken();
	        	l.add(a);
	   		 System.out.println( "Hello World! aaaa "+a );

	        }
			 System.out.println( "Hello World!taille "+l.size() );
return l;
	}
	public Commande nextCommand(String commande) throws Exception
	{
		 ArrayList<String> l;
	   	System.out.println("nextCommand forme ");

    	l=liste(commande);
       if(l.size()>1) {
		if(!l.get(1).equalsIgnoreCase("cercle")&&!l.get(1).equalsIgnoreCase("carre")
	        		&&!l.get(1).equalsIgnoreCase("triangle")&&!l.get(1).equalsIgnoreCase("rectangle")
	        		&&!l.get(1).equalsIgnoreCase("groupe")&&!l.get(0).equalsIgnoreCase("move")&&!l.get(0).equalsIgnoreCase("delete")
	        		&&!l.get(0).equalsIgnoreCase("print")&&!l.get(0).equalsIgnoreCase("exit"))
	    
		{
			System.out.println("la commande que vous avez entrer ne correspond a aucun commande!");
			return null;
		}
		else {
			if(l.get(1).equalsIgnoreCase("cercle")||l.get(1).equalsIgnoreCase("carre")
	        ||l.get(1).equalsIgnoreCase("triangle")||l.get(1).equalsIgnoreCase("rectangle"))
			{
				dessinForme(l);
				if(forme==null) {
				CreationCommande command= new CreationCommande(l);
				return command;}
			}
			else if(l.get(1).equalsIgnoreCase("groupe"))
			{
				dessinGroupe(l);
				if(forme==null) {
					System.out.println("ffffffffffooooooooooorrrrrrmmmmm");
				CreationGroupeCommande command= new CreationGroupeCommande(l);
				return command;	}
			}
			
			else if(l.get(0).equalsIgnoreCase("move"))
			{
				  deplacerForme(l);
				if(forme!=null) {
				MoveCommande command= new MoveCommande(forme,new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3))));
				return command;	}
				else return null;
			}
			else if(l.get(0).equalsIgnoreCase("delete"))
			{
				  deleteForme(l);
					if(forme!=null) {
				DeleteCommande command= new DeleteCommande(forme);
				return command;	}
			}
			else if(l.get(0).equalsIgnoreCase("print"))
			{
				 afficheForme(l);
					if(forme!=null) {
				ReadCommande command= new ReadCommande(forme);
				return command;	}
			}
			else if(l.get(0).equalsIgnoreCase("exit"))
			{
				
				ExiteCommande command= new ExiteCommande();
				return command;	
			}
		}
       }
	return null;
		
	}
	public void affiche()
	{
		this.forme.print();
	}

}
