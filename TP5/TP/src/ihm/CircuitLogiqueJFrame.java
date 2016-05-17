package ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import gates.LogicGate;
import gates.and;
import gates.button;
import gates.gate;
import gates.led;
import gates.nand;
import gates.nor;
import gates.not;
import gates.or;
import gates.xor;

/**
 * Cette classe repr�sente la fen�tre principale de l'interface graphique
 * 
 * Elle contient le menu et le conteneur de dessin
 * 
 * @author khalfie
 *
 */
public class CircuitLogiqueJFrame extends JFrame {

	/**
	 * Panneau principal qui contiendra le menu et le panneau de dessin
	 */
	private JPanel contentPane;

	/**
	 * Panneau de dessin
	 */
	private LogicGateSimulatorJPanel lgsPanel = new LogicGateSimulatorJPanel();

	/**
	 * Initialise la fen�tre principale
	 */
	public CircuitLogiqueJFrame() {

		setResizable(false);
		setTitle("Logic Gate Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 640);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 0));
		setContentPane(contentPane);

		createToolBar();
		contentPane.add(lgsPanel, BorderLayout.CENTER);
	}

	/**
	 * Cr�ation du toolbar
	 */
	private void createToolBar() {

		JToolBar toolbar = new JToolBar();

		ImageIcon iconNew = new ImageIcon("images/new.png");
		ImageIcon iconLoad = new ImageIcon("images/open.gif");
		ImageIcon iconSave = new ImageIcon("images/save.png");
		ImageIcon iconValidate = new ImageIcon("images/validate.png");
		ImageIcon iconSimulate = new ImageIcon("images/gears.png");

		JButton buttonNew = new JButton(iconNew);
		JButton buttonLoad = new JButton(iconLoad);
		JButton buttonSave = new JButton(iconSave);
		JButton buttonValidate = new JButton(iconValidate);
		JButton buttonSimulate = new JButton(iconSimulate);

		buttonNew.setToolTipText("Cr�er un nouveau circuit logique");
		buttonLoad.setToolTipText("Charger un fichier (*.boole) contenant un circuit logique");
		buttonSave.setToolTipText("Sauvegarder un circuit logique dans un fichier (*.boole)");
		buttonValidate.setToolTipText("V�rifier si un circuit logique est ferm�");
		buttonSimulate.setToolTipText("Simuler le r�sultat d'un circuit logique");

		toolbar.add(buttonNew);
		toolbar.add(buttonLoad);
		toolbar.add(buttonSave);
		toolbar.add(buttonValidate);
		toolbar.add(buttonSimulate);

		buttonSimulate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (gate g : LogicOperatorJPanel.lGates) {
					if (g instanceof gates.led) {
						if (((led) g).ValiderCircuitFerme()) {
							boolean simulatedValue = ((led) g).Process();
							LogicGateSimulatorJPanel logicGateSimulatorJPanel = (LogicGateSimulatorJPanel) contentPane
									.getComponent(1);
							JPanel drawingPanel = (JPanel) logicGateSimulatorJPanel.getComponent(1);

							for (Component cp : drawingPanel.getComponents()) {
								LogicOperatorJPanel operateur = (LogicOperatorJPanel) cp;
								if (operateur.gate.logicGate == LogicGate.LED) {
									operateur.SimulateCircuit(simulatedValue);
									break;
								}
							}
						}
					}
				}
			}
		});

		buttonNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				LogicOperatorJPanel.lGates = new ArrayList<gates.gate>();
				contentPane.remove(lgsPanel);
				lgsPanel = new LogicGateSimulatorJPanel();
				contentPane.add(lgsPanel, BorderLayout.CENTER);
				contentPane.validate();
				contentPane.repaint();
			}
		});
		buttonValidate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				for (gate g : LogicOperatorJPanel.lGates) {
					if (g instanceof gates.led) {
						if (((led) g).ValiderCircuitFerme()) {
							JOptionPane.showMessageDialog(null, "Le circcuit est bien ferm�",
									"InfoBox: " + "Circuit Ferm�", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"Le circcuit n'est pas ferm�. Merci de connecter toutes les entr�es sorties",
									"InfoBox: " + "Circuit Non Ferm�", JOptionPane.WARNING_MESSAGE);
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Un circuit logique doit contenir une seule LED.",
						"InfoBox: " + "Pas de LED", JOptionPane.ERROR_MESSAGE);
			}
		});
		buttonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (gate g : LogicOperatorJPanel.lGates) {
					if (g instanceof gates.led) {
						if (((led) g).ValiderCircuitFerme()) {
							try {
								JFileChooser fileChooser = new JFileChooser();
								fileChooser.setFileFilter(new FileNameExtensionFilter("Circuits logiques", "boole"));
								if (fileChooser.showSaveDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
									File file = fileChooser.getSelectedFile();
									if (!file.getPath().toLowerCase().endsWith(".boole")) {

										file = new File(file.getPath() + ".boole");
									}
									JAXBContext jaxbContext = JAXBContext.newInstance(and.class, button.class,
											nand.class, nor.class, not.class, or.class, xor.class, led.class);
									Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
									jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

									jaxbMarshaller.marshal(g, file);
									jaxbMarshaller.marshal(g, System.out);
								}
							} catch (JAXBException ex) {
								ex.printStackTrace();
							}
						}
						return;
					}
				}
			}
		});
		buttonLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(System.getProperty("user.home")));
				fc.setDialogTitle("Choisir un Circuit Logique");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setFileFilter(new FileNameExtensionFilter("Circuits logiques", "boole"));
				if (fc.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fc.getSelectedFile();
						JAXBContext jaxbContext = JAXBContext.newInstance(and.class, button.class, nand.class,
								nor.class, not.class, or.class, xor.class, led.class);
						Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
						led l = (led) jaxbUnmarshaller.unmarshal(file);
						contentPane.remove(lgsPanel);
						lgsPanel = new LogicGateSimulatorJPanel(l);
						contentPane.add(lgsPanel, BorderLayout.CENTER);
						contentPane.validate();
						contentPane.repaint();
					} catch (JAXBException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		contentPane.add(toolbar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		CircuitLogiqueJFrame frame = new CircuitLogiqueJFrame();
		frame.setVisible(true);
	}
}
