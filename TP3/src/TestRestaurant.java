
public class TestRestaurant {

	public static void main(String[] args) throws Exception {
		Carte carte = new Carte();
		
		carte.addEntrée(new Entrée ("Salade verte", 4));
		carte.addEntrée(new Entrée ("Salade composée", 6));
		carte.addPlatPrincipal(new PlatPrincipal ("Pizza Reine", 9));
		carte.addPlatPrincipal(new PlatPrincipal ("Pizza Margarita", 8));
		carte.addPlatPrincipal(new PlatPrincipal ("Spaghetti à la Bolognaise", 25));
		carte.addDessert(new Dessert("Tiramisu", 4));
		carte.addBoisson(new Boisson("Eau", 100));
		
		carte.addMenu(new Menu (15, 
				new Entrée ("Salade verte", 4),
				new PlatPrincipal ("Pizza Reine", 9),
				new Dessert("Tiramisu", 4),
				new Boisson("Eau", 100)) );
		
		carte.afficherMenu();
		
	}

}
