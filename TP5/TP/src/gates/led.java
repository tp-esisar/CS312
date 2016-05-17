package gates;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class led extends gate {
	
	public led() {
		logicGate=LogicGate.LED;
	}

	public boolean ValiderCircuitFerme() {
		if (in1==null || !in1.ValiderCircuitFerme())
			return false;
		else
			return true;
	}

	public boolean Process() {
		return in1.Process();
	}

}
