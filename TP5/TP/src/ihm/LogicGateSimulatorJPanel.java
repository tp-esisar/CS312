package ihm;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gates.LogicGate;
import gates.gate;
import gates.led;

/**
 * Cette classe représente le conteneur de réalisation de conteneurs logiques
 * 
 * @author khalfie
 *
 */
public class LogicGateSimulatorJPanel extends JPanel {
	/**
	 * Le type de port logique (sélectionné depuis le toolbox) à positionner
	 * dans la partie dessin
	 */
	private LogicGate selectedLogicGate = LogicGate.NONE;

	/**
	 * Le conteneur ou on dessine le circuit logique
	 */
	private JPanel drawingPanel = new JPanel();

	/**
	 * La boite à outils contenant les ports logiques.
	 */
	private JPanel toolbox = new JPanel();

	/**
	 * Initialise l'interface graphique de simulation de circuits logiques
	 */
	// Question 3
	public LogicGateSimulatorJPanel() {
		this.setLayout(new GridLayout(1, 2));

		ImageIcon BUTTONicon = new ImageIcon("images/Switch.gif");
		ImageIcon ANDicon = new ImageIcon("images/AND64.png");
		ImageIcon NANDicon = new ImageIcon("images/NAND64.png");
		ImageIcon NORicon = new ImageIcon("images/NOR64.png");
		ImageIcon NOTicon = new ImageIcon("images/NOT64.png");
		ImageIcon ORicon = new ImageIcon("images/OR64.png");
		ImageIcon XORicon = new ImageIcon("images/XOR64.png");
		ImageIcon LEDicon = new ImageIcon("images/LED.gif");

		JLabel BUTTONlabel = new JLabel("SWITCH", BUTTONicon, JLabel.LEFT);
		JLabel ANDlabel = new JLabel("AND", ANDicon, JLabel.LEFT);
		JLabel NANDlabel = new JLabel("NAND", NANDicon, JLabel.LEFT);
		JLabel NORlabel = new JLabel("NOR", NORicon, JLabel.LEFT);
		JLabel NOTlabel = new JLabel("NOT", NOTicon, JLabel.LEFT);
		JLabel ORlabel = new JLabel("OR", ORicon, JLabel.LEFT);
		JLabel XORlabel = new JLabel("XOR", XORicon, JLabel.LEFT);
		JLabel LEDlabel = new JLabel("LED", LEDicon, JLabel.LEFT);

		BUTTONlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		ANDlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		NANDlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		NORlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		NOTlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		ORlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		XORlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		LEDlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		BUTTONlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.BUTTON;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/Switch.gif").getImage(), new Point(0, 0), ""));
			}
		});
		ANDlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.AND;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/AND32.png").getImage(), new Point(0, 0), ""));
			}
		});
		NANDlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.NAND;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/NAND32.png").getImage(), new Point(0, 0), ""));
			}
		});
		NORlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.NOR;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/NOR64.png").getImage(), new Point(0, 0), ""));
			}
		});
		NOTlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.NOT;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/NOT32.png").getImage(), new Point(0, 0), ""));
			}
		});
		ORlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.OR;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/OR32.png").getImage(), new Point(0, 0), ""));
			}
		});
		XORlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.XOR;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/XOR32.png").getImage(), new Point(0, 0), ""));
			}
		});

		LEDlabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectedLogicGate = LogicGate.LED;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Toolkit.getDefaultToolkit()
						.createCustomCursor(new ImageIcon("images/LED.gif").getImage(), new Point(0, 0), ""));
			}
		});

		toolbox.setLayout(new GridLayout(0, 2));
		toolbox.add(BUTTONlabel);
		toolbox.add(LEDlabel);
		toolbox.add(ANDlabel);
		toolbox.add(NANDlabel);
		toolbox.add(NORlabel);
		toolbox.add(NOTlabel);
		toolbox.add(ORlabel);
		toolbox.add(XORlabel);

		setLayout(new BorderLayout(5, 0));
		add(toolbox, BorderLayout.WEST);

		drawingPanel.setLayout(null);
		drawingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		drawingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				if (evt.getButton() == MouseEvent.BUTTON3) {
					selectedLogicGate = LogicGate.NONE;
					JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
					frame.setCursor(Cursor.getDefaultCursor());
					return;
				}
				if (selectedLogicGate == LogicGate.NONE) {
					return;
				}
				LogicOperatorJPanel logicOperatorJPanel = new LogicOperatorJPanel(null, selectedLogicGate, evt.getX(),
						evt.getY());

				drawingPanel.add(logicOperatorJPanel);

				selectedLogicGate = LogicGate.NONE;
				JFrame frame = (JFrame) SwingUtilities.getRoot(evt.getComponent());
				frame.setCursor(Cursor.getDefaultCursor());

				drawingPanel.validate();
				drawingPanel.repaint();
			}
		});

		add(drawingPanel, BorderLayout.CENTER);
	}

	/**
	 * Initialise l'interface graphique de simulation de circuits logiques à
	 * partir d'un circuit déjà sauvegardé
	 * 
	 * @param l
	 *            représente la racine du circuit logique (tout circuit fermé
	 *            doit contenir une seule Led)
	 */
	public LogicGateSimulatorJPanel(led l) {
		this();
		l.GetGatesFromRoot();
		for (gate g : LogicOperatorJPanel.lGates) {
			LogicOperatorJPanel logicOperatorJPanel = new LogicOperatorJPanel(g, g.logicGate, g.getX(), g.getY());
			drawingPanel.add(logicOperatorJPanel);
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawLine(LogicOperatorJPanel.xBegin, LogicOperatorJPanel.yBegin, LogicOperatorJPanel.xEnd,
				LogicOperatorJPanel.yEnd);

		for (gate gt : LogicOperatorJPanel.lGates) {
			if (gt.getIn1() != null) {
				if (gt.getIn1() instanceof gates.button) {
					g.drawLine(drawingPanel.getX() + gt.getX(), drawingPanel.getY() + gt.getY() + 10,
							drawingPanel.getX() + gt.getIn1().getX() + 80,
							drawingPanel.getY() + gt.getIn1().getY() + 30);
				} else {
					g.drawLine(drawingPanel.getX() + gt.getX(), drawingPanel.getY() + gt.getY() + 10,
							drawingPanel.getX() + gt.getIn1().getX() + 80,
							drawingPanel.getY() + gt.getIn1().getY() + 15);
				}
			}
			if (gt.getIn2() != null) {
				if (gt.getIn2() instanceof gates.button) {
					g.drawLine(drawingPanel.getX() + gt.getX(), drawingPanel.getY() + gt.getY() + 20,
							drawingPanel.getX() + gt.getIn2().getX() + 80,
							drawingPanel.getY() + gt.getIn2().getY() + 30);
				} else {
					g.drawLine(drawingPanel.getX() + gt.getX(), drawingPanel.getY() + gt.getY() + 20,
							drawingPanel.getX() + gt.getIn2().getX() + 80,
							drawingPanel.getY() + gt.getIn2().getY() + 15);
				}
			}
		}
	}

}
