
import java.util.ArrayList;

public class Commande {
	private ArrayList<Consommable> itemsCommand�s;
	
	public Commande() {
		this.itemsCommand�s = new ArrayList<Consommable>();
	}
	
	public void addItem(Consommable c){
		this.itemsCommand�s.add(c);
	}
	
	public ArrayList<Consommable> getItemsCommand�s(){
		return this.itemsCommand�s;
	}

}
