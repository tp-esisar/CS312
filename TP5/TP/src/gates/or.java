package gates;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class or extends gate {

	public boolean ValiderCircuitFerme() {
		if (in1==null || in2==null || !in1.ValiderCircuitFerme() || !in2.ValiderCircuitFerme())
			return false;
		else
			return true;
	}

	public boolean Process() {
		if(in1.Process() || in2.Process())
			return true;
		else
			return false;
	}

}
