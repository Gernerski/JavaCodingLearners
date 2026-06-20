package ai_bandit.lab3;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * Im Wesentlichen muss Ihre Anwendung Folgendes beinhalten:
▶ Spielen einer oder mehrerer Runden (in Abb. 17.1 eine, zehn und 100)
▶ Auswahl der Spielstrategie (zuf¨allige Wahl oder Epsilon-Greedy-Verfahren)
▶ Zurucksetzen des Guthabens und der gespielten Runden ¨
▶ Grafische Darstellung, wie oft mit den einzelnen Banditen gespielt wurde
▶ Grafische Darstellung des Kontostandes im Verlauf der gespielten Runden
▶ Automatisches Spiel uber die Zeit

R1 Die Anwendung visualisiert das Spiel mit einem 7-armigen Banditen der Klasse MultiBandit
aus Kapitel 15.
R2 Das initiale Guthaben betr¨agt 10,- e.
R3 Es l¨asst sich einstellen, ob die zu spielenden Banditen zuf¨allig oder mittels Epsilon-GreedyVerfahren aus Kapitel 16 gew¨ahlt werden.
R4 Nutzer k¨onnen ausgehend vom jeweiligen Zustand des mehrarmigen Banditen eine einzelne
Runde, 10 Runden oder 100 Runden spielen
R5 Das Spiel kann zuruckgesetzt werden, wobei das Guthaben auf das initiale Guthaben und ¨
die Anzahl gespielter Runden auf null gesetzt wird.
R6 Es existiert eine grafische Balken-Darstellung, wie oft die einzelnen Banditen seit Programmstart bzw. dem letzten Zurucksetzen gespielt wurden. ¨
R7 Es existiert eine grafische Darstellung des Guthabens als Funktion der gespielten Runden
seit Programmstart bzw. dem letzten Zurucksetzen. ¨
R8 Es l¨asst sich ein ”
automatisches Spiel“ starten und stoppen, bei dem fortlaufend (z. B. alle
∆t = 100 ms) die jeweils n¨achste Runde gespielt wird.
Die Anforderung R8 muss nur erfullt werden, sofern wir vor dem Labortermin Parallelver- ¨
arbeitung mittels Threads in der Vorlesung behandelt haben.
 */

public class GraphicalUI {
	private JFrame frame;
	private JRadioButton[] solverSelection;
	private ButtonGroup solverSelectionGroup;
	private JButton[] startButtons;
	private ButtonGroup startGameButtonsGroup;
	private JPanel userInteractionContainer;
	private JPlotBarPanel plotBanditsPlaycount;
	
	public GraphicalUI(){
		
		initFrame();
		frameIniCompontents();
		UIElementeLayoutComponents();
		

        frame.setVisible(true);
	}
	
	private void initFrame() {
		frame = new JFrame();
		frame.setTitle("Hensel's Eleven - Überwachungszentrale");
		frame.setBounds(10, 10, 1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new java.awt.FlowLayout());
	}
	
	private void frameIniCompontents() {
		
		
		startButtons = new JButton[6];
		startButtons[0] = new JButton("Reset Bandits");
		startButtons[1] = new JButton("Play 1x");
		startButtons[2] = new JButton("Play 10x");
		startButtons[3] = new JButton("Play 100x");
		startButtons[4] = new JButton("Start");
		startButtons[5] = new JButton("Stop");
		startButtons[5].setVisible(false);
		
		solverSelection = new JRadioButton[2];
		solverSelection[0] = new JRadioButton("EPS Greedy", false);
		solverSelection[1] = new JRadioButton("Random", true);
		
		userInteractionContainer = new JPanel();
		frame.add(userInteractionContainer);
		
		solverSelectionGroup = new ButtonGroup();
		for (JRadioButton button: solverSelection) {
			frame.add(button);
			solverSelectionGroup.add(button);
			userInteractionContainer.add(button);
		}
		
		startGameButtonsGroup = new ButtonGroup();
		for (JButton button:startButtons) {
			frame.add(button);
			startGameButtonsGroup.add(button);
			userInteractionContainer.add(button);
		}
		
	}
	
	private void UIElementeLayoutComponents() {
		
	}
	
	private void FrameRegisterListeners() {
		
	}
}
