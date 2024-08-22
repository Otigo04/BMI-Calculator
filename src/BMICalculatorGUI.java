import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI {

    private JFrame fenster;
    private JTextField ageFeld;
    private JTextField gewichtFeld;
    private JTextField größeFeld;
    private JLabel ergebnisLabel;

    public BMICalculatorGUI() {
        // Setup des Fensters
        fenster = new JFrame("DER BLITZ-BMI-Rechner");
        fenster.setSize(600, 400);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setLayout(new GridLayout(4, 2));

        // Komponenten hinzufügen
        fenster.add(new JLabel("Alter eingeben: "));
        ageFeld = new JTextField();
        fenster.add(ageFeld);

        fenster.add(new JLabel("Gewicht eingeben (kg): "));
        gewichtFeld = new JTextField();
        fenster.add(gewichtFeld);

        fenster.add(new JLabel("Größe eingeben (m): "));
        größeFeld = new JTextField();
        fenster.add(größeFeld);

        JButton berechnenButton = new JButton("BMI berechnen");
        fenster.add(berechnenButton);

        ergebnisLabel = new JLabel("Dein BMI wird hier angezeigt.");
        fenster.add(ergebnisLabel);

        // Event-Handling
        berechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechneBMI();
            }
        });

        // Fenster anzeigen
        fenster.setVisible(true);
    }

    private void berechneBMI() {
        try {
            double gewicht = Double.parseDouble(gewichtFeld.getText());
            double größe = Double.parseDouble(größeFeld.getText());
            double age = Double.parseDouble(ageFeld.getText());

            BMICalc bmiCalc = new BMICalc(); // Annahme: BMICalc hat einen Standard-Konstruktor
            bmiCalc.calculator(gewicht, größe);

            ergebnisLabel.setText("Dein BMI ist: " + bmiCalc.getBMIResult());
        } catch (NumberFormatException ex) {
            ergebnisLabel.setText("Ungültige Eingabe. Bitte nur Zahlen eingeben.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BMICalculatorGUI();
            }
        });
    }
}
