package gates;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class not extends gate {

	public boolean ValiderCircuitFerme() {
		if (in1==null || !in1.ValiderCircuitFerme())
			return false;
		else
			return true;
	}

	public boolean Process() {
		if(!in1.Process())
			return true;
		else
			return false;
	}

}
