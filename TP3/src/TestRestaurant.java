
public class TestRestaurant {

	public static void main(String[] args) throws Exception {
		Carte carte = new Carte();
		Menu menu = null;
		Menu menu2 = null;
		
		//Cr�ation des diff�rents plats
		Entr�e entr�e1 = new Entr�e ("Salade verte", 4);
		Entr�e entr�e2 = new Entr�e ("Salade compos�e", 6);
		PlatPrincipal plat1 = new PlatPrincipal ("Pizza Reine", 9);
		PlatPrincipal plat2 = new PlatPrincipal ("Pizza Margarita", 8);
		PlatPrincipal plat3 = new PlatPrincipal ("Spaghetti � la Bolognaise", 25);
		Dessert dessert1 = new Dessert("Tiramisu", 4);
		Boisson boisson1 = new Boisson("Eau", 100);
		
		//On essaie d'ajouter les menus
		//Il faut capturer les exception si jamais l'insertion n'est pas possible car un consommable n'existe pas.
		System.out.println("--- Ajout des menus ---");
		try {
			menu = new Menu (18, entr�e1, plat1, dessert1, boisson1); 
			System.out.println(menu);
		} catch (ExceptionPrixMenuIncorrect e) {
			System.out.println(e);
		} //Ne fonctionne pas car le prix est plus ch�re que les �l�ments
		
		try {
			menu = new Menu (15, entr�e1, plat1, dessert1, boisson1); 
			System.out.println(menu);
		} catch (ExceptionPrixMenuIncorrect e) {
			System.out.println(e);
		} //Fonctionne
		
		try {
			menu2 = new Menu (10, new Entr�e ("Salade rouge", 4), plat1, dessert1, boisson1); 
			System.out.println(menu2);
		} catch (ExceptionPrixMenuIncorrect e) {
			System.out.println(e);
		} //Fonctionne
		
		//Ajout des �l�ments � la carte
		System.out.println("\n--- Affichage de la carte et ajout des menus ---");
		carte.addEntr�e(entr�e1);
		carte.addEntr�e(entr�e2);
		carte.addPlatPrincipal(plat1);
		carte.addPlatPrincipal(plat2);
		carte.addPlatPrincipal(plat3);
		carte.addDessert(dessert1);
		carte.addBoisson(boisson1);
		
		carte.addDessert(new Dessert ("Salade verte", 40)); //Ne doit pas s'ajouter car d�j� pr�sent !
		
		carte.addMenu(menu);
		carte.addMenu(menu2); //Ne doit pas s'ajouter � la carte car certain �l�ments n'existent pas
		
		carte.afficherMenu();
		
		//On ajoute 2 fois � commande donn�e dans le sujet pour voir si l'on reconnait bien les menus
		System.out.println("\n\n--- Ajout commande ---");
		Commande commande = new Commande();
		commande.addItem(entr�e1);
		commande.addItem(plat1);
		commande.addItem(plat2);
		commande.addItem(dessert1);
		commande.addItem(boisson1);
		commande.addItem(entr�e1);
		commande.addItem(plat1);
		commande.addItem(plat2);
		commande.addItem(dessert1);
		commande.addItem(boisson1);
		
		System.out.println(carte.calculerPrixCommande(commande));
	}

}
