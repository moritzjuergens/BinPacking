package DefaultPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class StartingUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	//Start of declaration
	private JPanel mainPanel;

	private JPanel welcomePanel;
	private JLabel lblWelcome1;
	private JLabel lblWelcome2;
	private JLabel lblWelcome3;
	
	private JPanel inputPanel;
	private JLabel lblInput;
	private JTextField tfInput;
	
	private JPanel buttonPanel;
	private JButton btnNormal;
	private JButton btnFunctional;
	
	private Worker worker;	
	private int maxSize;
	//End of declaration
	
	public StartingUI () {
		super("Start Screen");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Main panel to add all other panels on to
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //Start of welcome panel
		//Area of welcoming texts to the User
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        
        lblWelcome1 = new JLabel();
        lblWelcome1.setText("Welcome to this bin packing program");
        welcomePanel.add(lblWelcome1, BorderLayout.NORTH);
        
        lblWelcome2 = new JLabel();
        lblWelcome2.setText("Please insert the maximum size of each bin");
        welcomePanel.add(lblWelcome2, BorderLayout.CENTER);
        
        lblWelcome3 = new JLabel();
        lblWelcome3.setText("and press one of the buttons to continue.");
        welcomePanel.add(lblWelcome3, BorderLayout.SOUTH);
        
        mainPanel.add(welcomePanel, BorderLayout.NORTH);
        //End of Welcome Panel


		//Start of input panel
		//Here will the user insert the necessary Information
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
		
        lblInput = new JLabel();
        lblInput.setText("Maximum size: ");
        inputPanel.add(lblInput);
        
        tfInput = new JTextField(5);
        inputPanel.add(tfInput);
		
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        //End of input panel

        //Start of button panel
		//Here two buttons are created so the user can decide between normal or functional code
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        //ActionListener to perform an action when the button is pressed
        ActionListener btnListener = event -> {

			String action = event.getActionCommand();
			maxSize = Integer.parseInt(tfInput.getText());

			//The buttons will open up the same UI, but they will hand over a different worker.
			//This way we can choose which code is executed
			if (Action.ACTION_NORMAL.name().equals(action)) {
				worker = new WorkerNormal();
				new InsertingUI(worker, maxSize);
			} else if (Action.ACTION_FUNCTIONAL.name().equals(action)) {
				worker = new WorkerFunctional();
				new InsertingUI(worker, maxSize);
			} else {
				throw new IllegalArgumentException("No valid action is selected");
			}
			//Hide this UI
			setVisible(false);
		};

        //Button to start normal code
		btnNormal = new JButton("Normal");
		btnNormal.setActionCommand(Action.ACTION_NORMAL.name());
		btnNormal.addActionListener(btnListener);
		buttonPanel.add(btnNormal);

		//Button to start functional code
		btnFunctional = new JButton("Functional");
		btnFunctional.setActionCommand(Action.ACTION_FUNCTIONAL.name());
		btnFunctional.addActionListener(btnListener);
		buttonPanel.add(btnFunctional);
		
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        //End of button panel

		//Create emptyBorder for gap between window edge and beginning of text
		Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		//Set the border to the mainPanel
		mainPanel.setBorder(emptyBorder);

		this.add(mainPanel);

		this.pack();
		this.setVisible(true);
	}
}