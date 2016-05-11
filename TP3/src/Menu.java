import java.util.ArrayList;

public class Menu {
	ArrayList<Consommable> items;
	int prix; // en cents

	public Menu(int prix, Entrée e, PlatPrincipal p, Dessert d, Boisson b) throws Exception {
		this.prix=prix;
		items = new ArrayList<Consommable>();
		items.add(e);
		items.add(p);
		items.add(d);
		items.add(b);
		if (!verifPrixMenu())
			throw new ExceptionPrixMenuIncorrect (this.toString());
	}
	
	public ArrayList<Consommable> getItems(){
		return this.items;
	}
	
	public int getPrix(){
		return this.prix;
	}

	public String toString(){
		String message = "Menu compose de ";
		for (Consommable i : items) 
			message += i.getNom() + ", ";
		message += "au prix de " + this.prix + " euros";
		return message;
	}
	
	private boolean verifPrixMenu(){
		int sommePrix = 0;
		for(Consommable c: this.items){
			sommePrix += c.getPrix();
		}
		return sommePrix >= this.prix && sommePrix > 0;
	}
}
