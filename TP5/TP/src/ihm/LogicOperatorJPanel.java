package ihm;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import gates.LogicGate;
import gates.gate;

/**
<<<<<<< HEAD
 * Cette classe repr�sente un op�rateur logique dans le panneau de dessin
=======
 * Cette classe représente un opérateur logique dans le panneau de dessin
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
 * 
 * @author khalfie
 *
 */
public class LogicOperatorJPanel extends JPanel {

	private int x0;
	private int y0;
	/**
<<<<<<< HEAD
	 * le extr�mit�s d'une connexion en cours de dessin.
=======
	 * le extrémités d'une connexion en cours de dessin.
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
	 */
	public static int xBegin, yBegin, xEnd, yEnd = 0;

	/**
<<<<<<< HEAD
	 * le port logique s�lectionn� depuis la toolbox.
=======
	 * le port logique sélectionné depuis la toolbox.
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
	 */
	gates.gate gate;

	/**
<<<<<<< HEAD
	 * les ports logiques reli�s par une connexion en cours de dessin.
=======
	 * les ports logiques reliés par une connexion en cours de dessin.
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
	 */
	static gates.gate in1Gate, in2Gate, outGate = null;

	/**
<<<<<<< HEAD
	 * la liste des ports logiques dessin�s
=======
	 * la liste des ports logiques dessinés
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
	 */
	public static List<gates.gate> lGates = new ArrayList<gates.gate>();

	JComponent gateImage = null;
	/**
<<<<<<< HEAD
	 * Initialise le port logique � dessiner
=======
	 * Initialise le port logique é dessiner
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
	 * 
	 * @param g
	 *            port logique correspondant
	 * @param logicGate
<<<<<<< HEAD
	 *            le type de port logique � dessiner
=======
	 *            le type de port logique é dessiner
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
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
				// Le dessin commence d'ici, quelles valeurs donner
<<<<<<< HEAD
				// � xBegin, xEnd, yBegin, yEnd ?
				xBegin = outGate.getX();
				yBegin = outGate.getY();
			}

			public void mouseReleased(MouseEvent e) {
				// Que fair apr�s la cr�ation d'une connection ?
				// Qu'est-ce qui change pour la variable gate ?
				// Que faire si on rel�che la souris sans connecter
				// la sortie qu'on est en train de faire glisser � une entr�e ?
				java.awt.Component compo = getComponentAt(xEnd, yEnd);
				System.out.println(compo+" xEnd: "+xEnd+" yEnd: "+yEnd);
				
				
=======
				// é xBegin, xEnd, yBegin, yEnd ?
			}

			public void mouseReleased(MouseEvent e) {
				// Que fair aprés la création d'une connection ?
				// Qu'est-ce qui change pour la variable gate ?
				// Que faire si on reléche la souris sans connecter
				// la sortie qu'on est en train de faire glisser é une entrée ?
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
			}
		});

		connectorOUT.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// On est en train de glisser une sortie et on cheche
<<<<<<< HEAD
				// une entr�e � connecter
				
				xEnd = e.getX() - connectorOUT.getX();
				yEnd = e.getY() - connectorOUT.getY();
				
				
=======
				// une entrée é connecter
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
			}
		});
		/*************************
		 * BEGIN : Question 3 Partie 2
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

<<<<<<< HEAD
			// On n'ajouter pas lec connecteur d'entr�e � un bouton, il n'a que
=======
			// On n'ajouter pas lec connecteur d'entrée é un bouton, il n'a que
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
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
				}
			});

<<<<<<< HEAD
			// On n'ajouter pas lec connecteur d'entr�e � un bouton, il n'a que
=======
			// On n'ajouter pas lec connecteur d'entrée é un bouton, il n'a que
>>>>>>> 0a78b9ca8f17c11e2cf547cf44e56725bc8991b6
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
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				gate.setX(e.getXOnScreen()- x0);
				gate.setY(e.getYOnScreen()- y0);
				
				
				setLocation(gate.getX(), gate.getY());
				System.out.println("drag" + gate.getX() +" / "+gate.getY() );
				System.out.println("mouse" + e.getYOnScreen() +" / "+e.getYOnScreen() );
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
		((JToggleButton) gateImage).setSelected(simulatedValue);
	}
}
