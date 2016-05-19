package ihm;

import gates.LogicGate;
import gates.gate;
import gates.led;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/**
 * Cette classe représente un opérateur logique dans le panneau de dessin
 * 
 * @author khalfie
 *
 */
public class LogicOperatorJPanel extends JPanel {

	private int x0;
	private int y0;
	/**
	 * le extrémités d'une connexion en cours de dessin.
	 */
	public static int xBegin, yBegin, xEnd, yEnd = 0;

	/**
	 * le port logique sélectionné depuis la toolbox.
	 */
	gates.gate gate;

	/**
	 * les ports logiques reliés par une connexion en cours de dessin.
	 */
	static gates.gate in1Gate, in2Gate, outGate = null;

	/**
	 * la liste des ports logiques dessinés
	 */
	public static List<gates.gate> lGates = new ArrayList<gates.gate>();

	JComponent gateImage = null;
	/**
	 * Initialise le port logique é dessiner
	 * 
	 * @param g
	 *            port logique correspondant
	 * @param logicGate
	 *            le type de port logique é dessiner
	 * @param x
	 *            la position de la porte logique sur le conteneur de dessin
	 * @param y
	 *            la position de la porte logique sur le conteneur de dessin
	 */
	public LogicOperatorJPanel(gate g, LogicGate logicGate, int x, int y) {
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		JPanel connectorsPanel = new JPanel();
		connectorsPanel.setLayout(new BoxLayout(connectorsPanel, BoxLayout.PAGE_AXIS));

		JLabel connectorIN1 = new JLabel(new ImageIcon("images/connector.png"));

		connectorIN1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		connectorIN1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				connectorIN1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
				in1Gate = gate;
			}

			public void mouseExited(MouseEvent e) {
				connectorIN1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
				in1Gate = null;
			}
		});

		JLabel connectorIN2 = new JLabel(new ImageIcon("images/connector.png"));

		connectorIN2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		connectorIN2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				connectorIN2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
				in2Gate = gate;
			}

			public void mouseExited(MouseEvent e) {
				connectorIN2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
				in2Gate = null;
			}
		});

		JLabel connectorOUT = new JLabel(new ImageIcon("images/connector.png"));
		connectorOUT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		connectorOUT.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				connectorOUT.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
				outGate = gate;
			}

			public void mouseExited(MouseEvent e) {
				connectorOUT.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
				outGate = null;
			}

			/*************************
			 * BEGIN : Question 3 Partie 2
			 ******************************/
			public void mousePressed(MouseEvent e) {
				xBegin = xEnd = getParent().getParent().getMousePosition().x;
				yBegin = yEnd = getParent().getParent().getMousePosition().y;
				getParent().getParent().validate();
				getParent().getParent().repaint();
			}

			public void mouseReleased(MouseEvent e) {
				if (in1Gate!=null)
					in1Gate.setIn1(gate);
				else if(in2Gate!=null)
					in2Gate.setIn2(gate);
				
				xEnd = xBegin = 0;
				yEnd = yBegin = 0;
				
				for (gate g : LogicOperatorJPanel.lGates) {
					if (g instanceof gates.led) {
						if (((led) g).ValiderCircuitFerme()) {
							boolean simulatedValue = ((led) g).Process();
							JPanel drawingPanel = (JPanel) getParent().getParent().getComponent(1);

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
				
				getParent().getParent().validate();
				getParent().getParent().repaint();
				
				
			
			}
		});

		connectorOUT.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				xEnd = getParent().getParent().getMousePosition().x;
				yEnd = getParent().getParent().getMousePosition().y;
				
				getParent().getParent().validate();
				getParent().getParent().repaint();
			}
		});
		/*************************
		 * END : Question 3 Partie 2
		 ******************************/
		switch (logicGate) {
		case AND:
			if (g == null) {
				gate = new gates.and();
			} else {
				gate = g;
			}

			gateImage = new JLabel(new ImageIcon("images/AND64.png"));

			connectorsPanel.add(connectorIN1);
			connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			connectorsPanel.add(connectorIN2);
			this.add(connectorsPanel);
			this.add(gateImage);
			this.add(connectorOUT);

			break;
		case NAND:
			if (g == null) {
				gate = new gates.nand();
			} else {
				gate = g;
			}
			gateImage = new JLabel(new ImageIcon("images/NAND64.png"));

			connectorsPanel.add(connectorIN1);
			connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			connectorsPanel.add(connectorIN2);
			this.add(connectorsPanel);
			this.add(gateImage);
			this.add(connectorOUT);

			break;
		case NOR:
			if (g == null) {
				gate = new gates.nor();
			} else {
				gate = g;
			}
			gateImage = new JLabel(new ImageIcon("images/NOR64.png"));

			connectorsPanel.add(connectorIN1);
			connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			connectorsPanel.add(connectorIN2);
			this.add(connectorsPanel);
			this.add(gateImage);
			this.add(connectorOUT);

			break;
		case NOT:
			if (g == null) {
				gate = new gates.not();
			} else {
				gate = g;
			}
			gateImage = new JLabel(new ImageIcon("images/NOT64.png"));

			// On n'ajouter pas lec connecteur d'entrée é un bouton, il n'a que
			// le connecteur de sortie.
			// connectorsPanel.add(connectorIN1);
			// connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			// connectorsPanel.add(connectorIN2);
			connectorsPanel.add(connectorIN1);
			this.add(connectorsPanel);
			this.add(gateImage);
			this.add(connectorOUT);

			break;
		case OR:
			if (g == null) {
				gate = new gates.or();
			} else {
				gate = g;
			}
			gateImage = new JLabel(new ImageIcon("images/OR64.png"));

			connectorsPanel.add(connectorIN1);
			connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			connectorsPanel.add(connectorIN2);
			this.add(connectorsPanel);
			this.add(gateImage);
			this.add(connectorOUT);

			break;
		case XOR:
			if (g == null) {
				gate = new gates.xor();
			} else {
				gate = g;
			}
			gateImage = new JLabel(new ImageIcon("images/XOR64.png"));

			connectorsPanel.add(connectorIN1);
			connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			connectorsPanel.add(connectorIN2);
			this.add(connectorsPanel);
			this.add(gateImage);
			this.add(connectorOUT);

			break;
		case BUTTON:
			if (g == null) {
				gate = new gates.button();
			} else {
				gate = g;
			}
			gateImage = new JToggleButton(new ImageIcon("images/Switch.gif"), false);

			((JToggleButton) gateImage).setContentAreaFilled(false);
			((JToggleButton) gateImage).setBorderPainted(false);
			((JToggleButton) gateImage).setFocusPainted(false);
			((JToggleButton) gateImage).setSelectedIcon(new ImageIcon("images/Switch_on.gif"));

			((JToggleButton) gateImage).setSelected(((gates.button) gate).isValue());

			((JToggleButton) gateImage).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JToggleButton btn = (JToggleButton) e.getSource();
					if (btn.isSelected()) {
						((gates.button) gate).setValue(true);
					} else {
						((gates.button) gate).setValue(false);
					}
					for (gate g : LogicOperatorJPanel.lGates) {
						if (g instanceof gates.led) {
							if (((led) g).ValiderCircuitFerme()) {
								boolean simulatedValue = ((led) g).Process();
								JPanel drawingPanel = (JPanel) getParent().getParent().getComponent(1);

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


			// On n'ajouter pas lec connecteur d'entrée é un bouton, il n'a que
			// le connecteur de sortie.
			// connectorsPanel.add(connectorIN1);
			// connectorsPanel.add(Box.createRigidArea(new Dimension(0, 6)));
			// connectorsPanel.add(connectorIN2);
			this.add(gateImage);
			this.add(connectorOUT);
			break;
		case LED:
			if (g == null) {
				gate = new gates.led();
			} else {
				gate = g;
			}
			gateImage = new JToggleButton(new ImageIcon("images/LED.gif"), false);

			((JToggleButton) gateImage).setContentAreaFilled(false);
			((JToggleButton) gateImage).setBorderPainted(false);
			((JToggleButton) gateImage).setFocusPainted(false);
			((JToggleButton) gateImage).setSelectedIcon(new ImageIcon("images/LED_on.gif"));

			((JToggleButton) gateImage).setDisabledSelectedIcon(new ImageIcon("images/LED_on.gif"));
			((JToggleButton) gateImage).setDisabledIcon(new ImageIcon("images/LED.gif"));
			((JToggleButton) gateImage).setEnabled(false);

			connectorsPanel.add(connectorIN1);
			this.add(connectorsPanel);
			this.add(gateImage);
			break;
		case NONE:
			break;
		}
		gate.setX(x);
		gate.setY(y);

		if (g == null) {
			lGates.add(gate);
		}

	
		/*************************
		 * BEGIN : Question 2 Partie 2
		 ******************************/
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x0 = e.getXOnScreen()-gate.getX();
				y0 = e.getYOnScreen()-gate.getY();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					JPopupMenu popup = new JPopupMenu();
					JMenuItem menuItem;
					menuItem = new JMenuItem("Supprimer", new ImageIcon(
							"images/remove.png"));
					menuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							java.awt.Container JPanel = getParent().getParent();
							getParent().remove(LogicOperatorJPanel.this);
							
							for (gate g : LogicOperatorJPanel.lGates) {
								if (g.getIn1() == gate)
									g.setIn1(null);
								else if (g.getIn2() == gate)
									g.setIn2(null);
							}
							LogicOperatorJPanel.lGates.remove(gate);
							JPanel.validate();
							JPanel.repaint();
						}
					});
					popup.add(menuItem);
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				gate.setX(e.getXOnScreen()- x0);
				gate.setY(e.getYOnScreen()- y0);
				setLocation(gate.getX(), gate.getY());
				getParent().getParent().validate();
				getParent().getParent().repaint();
			}
		});
		/*************************
		 * END : Question 2 Partie 2
		 ****************************/

		this.setBounds(x, y, this.getPreferredSize().width, this.getPreferredSize().height);
		this.validate();
		this.repaint();
	}

	public void SimulateCircuit(boolean simulatedValue) {
		System.out.println(simulatedValue);
		((JToggleButton) gateImage).setSelected(simulatedValue);
	}
}
