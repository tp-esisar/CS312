
import java.util.ArrayList;

public class Carte {
	private ArrayList<Consommable> entrées;
	private ArrayList<Consommable> platsPrincipaux;
	private ArrayList<Consommable> desserts;
	private ArrayList<Consommable> boissons;
	
	private ArrayList<Menu> menus;

	public Carte() {
		entrées = new ArrayList<Consommable>();
		platsPrincipaux = new ArrayList<Consommable>();
		desserts = new ArrayList<Consommable>();
		boissons = new ArrayList<Consommable>();	
		menus = new ArrayList<Menu>();
	}
	
	public void addEntrée(Entrée e){
		if (verifCarte(e)) this.entrées.add(e);
	}
	
	public void addPlatPrincipal(PlatPrincipal p){
		if (verifCarte(p)) this.platsPrincipaux.add(p);
	}
	
	public void addDessert(Dessert d){
		if (verifCarte(d)) this.desserts.add(d);
	}
	
	public void addBoisson(Boisson b){
		if (verifCarte(b)) this.boissons.add(b);
	}
	
	public void addMenu(Menu m){
		if (verifMenu(m)){
			this.menus.add(m);
		}
	}
	
	public ArrayList<Consommable> getEntrées(){
		return this.entrées;
	}
	
	public ArrayList<Consommable> getPlatsPrincipaux(){
		return this.platsPrincipaux;
	}
	
	public ArrayList<Consommable> getDesserts(){
		return this.desserts;
	}
	
	public ArrayList<Consommable> getBoissons(){
		return this.boissons;
	}
	
	// V�rifie que les plats et boissons du menu sont bien dans la carte
	private boolean verifMenu(Menu m){
		
	}
	
	// V�rifie qu'il n'y a pas d'homonymes dans la carte
	private boolean verifCarte(Consommable c){
			
	}
	
	/* Calcule le prix de la commande. A priori, ce prix est la somme des prix des items 
	 * SAUF si une partie de ces items constituent un menu; dans ce cas, le tarif menu s'applique pour ces items.
	 */
	public int calculerPrixCommande(Commande c){
		
	}
	
	public void afficherMenu(){
		System.out.println("Liste des entr�es:" + entrées);
		System.out.println("Liste des plats principaux:" + platsPrincipaux);
		System.out.println("Liste des desserts:" + desserts);
		System.out.println("Liste des boissons:" + boissons);

	}
	

}
