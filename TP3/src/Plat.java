
public class Plat implements Consommable{
	
	private String nom;
	private int prix; // en cents d'euros

	public Plat(String nom, int prix){
		this.nom = nom;
		this.prix = prix;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getPrix(){
		return this.prix;
	}
	
}
