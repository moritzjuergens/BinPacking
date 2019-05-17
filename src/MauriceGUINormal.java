import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MauriceGUINormal extends JFrame {

    private List<Bin> bins = new ArrayList<Bin>();


    private MauriceGUINormal() {

        super("Bin sorting");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

//halla georg
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel lblInput = new JLabel("Element:");
        JTextField tfInput = new JTextField(20);

        /*
        ActionListener rbtnListener = e -> {

            JRadioButton btn = new JRadioButton();
            Random r = new Random();

            while(btn.isSelected()) {

                tfInput.setText(String.valueOf(r.nextInt()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }


            }

        };
        */

        ActionListener btnListener = e -> {

            this.einsortieren(Integer.parseInt(tfInput.getText()));
            tfInput.setText("");

            String[][] data = new String[this.bins.size()][2];

            for (int i = 0; i < bins.size(); i++) {

                data[i][0] = String.valueOf(i);

                String elements = "";

                for (int element : bins.get(i).getElements()) {

                    elements = elements + String.valueOf(element) + ", ";

                }

                data[i][1] = elements;

            }

            outputPanel.removeAll();

            String[] tabellenÜberschrift = {"Bin:", "Elemente:"};
            JTable tblOutput = new JTable(data, tabellenÜberschrift);

            outputPanel.add(new JScrollPane(tblOutput), BorderLayout.SOUTH);

            this.pack();
        };


        JButton btnInput = new JButton("Einsortieren");
        btnInput.addActionListener(btnListener);

        //JRadioButton rbtnRandom = new JRadioButton("Generate Random Elements");
        //rbtnRandom.addActionListener(rbtnListener);


        inputPanel.add(lblInput);
        inputPanel.add(tfInput);
        inputPanel.add(btnInput);


        this.add(inputPanel, BorderLayout.NORTH);
        this.add(outputPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);

    }


    public static void main(String[] args) {

        new MauriceGUINormal();

    }

    public void einsortieren(int element){

        if(element > 0 && element <= 10) {

            boolean worked = false;

            for (Bin bin : bins){

                if (bin.addElement(element)){
                    worked = true;
                    break;
                }

            }

            if (!worked) {
                bins.add(new Bin());
                bins.get(bins.size()-1).addElement(element);
            }
        }
    }

}

