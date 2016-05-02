
public class ExceptionPrixMenuIncorrect extends Exception {
	
	private static final long serialVersionUID = 1L;

	private String menu;
	
	public ExceptionPrixMenuIncorrect (String menu) {
		this.menu = menu;
	}
	
	public String getMenu() {
		return menu;
	}

	public String toString() {
		return ("Le prix de : " + menu + " est plus chère que chaque élément individuellement...");
	}
}
