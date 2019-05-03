import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinPackingUI extends JFrame {

    public BinPackingUI(){
        super("Bin Packing Problem");

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel dataLabel = new JPanel(new GridLayout(0, 2));
        JPanel elementPanel = new JPanel(new FlowLayout());

        JLabel sizeLabel = new JLabel("Bin Größe");
        JTextField sizeTextField = new JTextField();

        JLabel countElementLabel = new JLabel("Anzahl Elemente");
        JTextField countElementTextField = new JTextField();

        JLabel elementLabel = new JLabel();
        JTextField elementTextField = new JTextField();

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
        mainPanel.add(elementPanel, BorderLayout.SOUTH);

        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);

        ActionListener buttonListener = e -> {
            e.getActionCommand();

            if (e.getActionCommand().equals("Anwenden")){

            }
        };

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
