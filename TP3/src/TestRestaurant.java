
public class TestRestaurant {

	public static void main(String[] args) throws Exception {
		Carte carte = new Carte();
		Menu menu = null;
		Menu menu2 = null;
		
		//Création des différents plats
		Entrée entrée1 = new Entrée ("Salade verte", 4);
		Entrée entrée2 = new Entrée ("Salade composée", 6);
		PlatPrincipal plat1 = new PlatPrincipal ("Pizza Reine", 9);
		PlatPrincipal plat2 = new PlatPrincipal ("Pizza Margarita", 8);
		PlatPrincipal plat3 = new PlatPrincipal ("Spaghetti à la Bolognaise", 25);
		Dessert dessert1 = new Dessert("Tiramisu", 4);
		Boisson boisson1 = new Boisson("Eau", 100);
		
		//On essaie d'ajouter les menus
		//Il faut capturer les exception si jamais l'insertion n'est pas possible car un consommable n'existe pas.
		System.out.println("--- Ajout des menus ---");
		try {
			menu = new Menu (18, entrée1, plat1, dessert1, boisson1); 
			System.out.println(menu);
		} catch (ExceptionPrixMenuIncorrect e) {
			System.out.println(e);
		} //Ne fonctionne pas car le prix est plus chère que les éléments
		
		try {
			menu = new Menu (15, entrée1, plat1, dessert1, boisson1); 
			System.out.println(menu);
		} catch (ExceptionPrixMenuIncorrect e) {
			System.out.println(e);
		} //Fonctionne
		
		try {
			menu2 = new Menu (10, new Entrée ("Salade rouge", 4), plat1, dessert1, boisson1); 
			System.out.println(menu2);
		} catch (ExceptionPrixMenuIncorrect e) {
			System.out.println(e);
		} //Fonctionne
		
		//Ajout des éléments à la carte
		System.out.println("\n--- Affichage de la carte et ajout des menus ---");
		carte.addEntrée(entrée1);
		carte.addEntrée(entrée2);
		carte.addPlatPrincipal(plat1);
		carte.addPlatPrincipal(plat2);
		carte.addPlatPrincipal(plat3);
		carte.addDessert(dessert1);
		carte.addBoisson(boisson1);
		
		carte.addDessert(new Dessert ("Salade verte", 40)); //Ne doit pas s'ajouter car déjà présent !
		
		carte.addMenu(menu);
		carte.addMenu(menu2); //Ne doit pas s'ajouter à la carte car certain éléments n'existent pas
		
		carte.afficherMenu();
		
		//On ajoute 2 fois à commande donnée dans le sujet pour voir si l'on reconnait bien les menus
		System.out.println("\n\n--- Ajout commande ---");
		Commande commande = new Commande();
		commande.addItem(entrée1);
		commande.addItem(plat1);
		commande.addItem(plat2);
		commande.addItem(dessert1);
		commande.addItem(boisson1);
		commande.addItem(entrée1);
		commande.addItem(plat1);
		commande.addItem(plat2);
		commande.addItem(dessert1);
		commande.addItem(boisson1);
		
		System.out.println(carte.calculerPrixCommande(commande));
	}

}
