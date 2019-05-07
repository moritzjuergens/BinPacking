import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BinPackingUI extends JFrame {

    static List<Integer> elements = new ArrayList<Integer>();
    static List<BinUserInteraction> bins = new ArrayList<BinUserInteraction>();

    public BinPackingUI(){
        super("Bin Packing Problem");

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel dataLabel = new JPanel(new GridLayout(0, 2));
        JPanel elementPanel = new JPanel(new FlowLayout());
        JTextArea outputTextArea = new JTextArea(30,10);

        JLabel sizeLabel = new JLabel("Bin Größe");
        JTextField sizeTextField = new JTextField();

        JLabel countElementLabel = new JLabel("Anzahl Elemente");
        JTextField countElementTextField = new JTextField();

        JLabel elementLabel = new JLabel();
        JTextField elementTextField = new JTextField(3);
        elementLabel.setVisible(false);
        elementTextField.setVisible(false);

        dataLabel.add(sizeLabel);
        dataLabel.add(sizeTextField);
        dataLabel.add(countElementLabel);
        dataLabel.add(countElementTextField);

        JButton applyButton = new JButton("Anwenden");
        JButton saveElementButton = new JButton("Speichern");

        elementPanel.add(elementLabel);
        elementPanel.add(elementTextField);
        elementPanel.add(saveElementButton);

        mainPanel.add(dataLabel, BorderLayout.WEST);
        mainPanel.add(applyButton, BorderLayout.EAST);
        mainPanel.add(elementPanel, BorderLayout.CENTER);
        mainPanel.add(outputTextArea, BorderLayout.SOUTH);

        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);

        ActionListener buttonListener = e -> {
            e.getActionCommand();

            int binSize = 0;
            int elementCount = 0;
            int elementSize = 0;

            if (e.getActionCommand().equals("Anwenden")){

                elementLabel.setVisible(true);
                elementLabel.setText("1. Element: ");
                elementTextField.setVisible(true);

                binSize = Integer.parseInt(sizeTextField.getText());
                elementCount = Integer.parseInt(countElementTextField.getText());


            }

            if (e.getActionCommand().equals("Speichern")){


                for (int i = 0; i < elementCount; i++){
                    elementLabel.setText((i+1) + ". Element: ");
                    elementSize = Integer.parseInt(elementTextField.getText());
                    elements.add(elementSize);
                }

            }

            new BinBackingFunctional(binSize, elementCount, elements, bins);
        };

        applyButton.addActionListener(buttonListener);
        saveElementButton.addActionListener(buttonListener);

        mainPanel.setBorder(bevelBorder);

        setContentPane(mainPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BinPackingUI();
    }
}
