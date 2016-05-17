package gates;

import javax.xml.bind.annotation.XmlAttribute;
import ihm.LogicOperatorJPanel;

/**
 * Cette classe simule le comportement d'un port logique
 *
 *
 */
public abstract class gate {
	/**
	 * Le type de la porte logique
	 */
	public LogicGate logicGate;
	/**
	 * Les coordonnées de la porte logique dans le dessin.
	 */
	int x, y;
	/**
	 * Les portes connectés dans les deux connecteurs in1 et in2.
	 */
	gate in1, in2 = null;

	public gate getIn1() {
		return in1;
	}

	public void setIn1(gate in1) {
		this.in1 = in1;
	}

	public gate getIn2() {
		return in2;
	}

	public void setIn2(gate in2) {
		this.in2 = in2;
	}

	public gate() {
	}

	public gate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	@XmlAttribute
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	@XmlAttribute
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Valider s'il un connecteur non occupé dans le circuit
	 */
	abstract public boolean ValiderCircuitFerme();

	/**
	 * Retourner le résultat de l'opération logique .
	 */
	abstract public boolean Process();

	public void GetGatesFromRoot() {
		LogicOperatorJPanel.lGates.add(this);
		if (this.in1 != null) {
			this.in1.GetGatesFromRoot();
		}
		if (this.in2 != null) {
			this.in2.GetGatesFromRoot();
		}
	}
}
