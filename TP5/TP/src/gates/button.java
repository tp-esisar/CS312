package gates;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class button extends gate {

	boolean value = false;
	
	public boolean ValiderCircuitFerme() {
		return true;
	}

	public void setValue(boolean val) {
		value = val;
	}
	
	public boolean isValue() {
		return value;
	}
	
	public boolean Process() {
		return value;
	}

}
