
public class Boisson implements Consommable{
	
	private String nom;
	private int prix; // en cents d'euros
	private int volume; // en centilitres
	
	public Boisson(String nom, int prix, int volume){
		this.nom = nom;
		this.prix = prix;
		this.volume = volume;
	}
	
	public Boisson(String nom, int volume){
		this(nom, 0, volume);
	}
	
	public int getVolume(){
		return volume;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getPrix(){
		return this.prix;
	}
}
