package DefaultPackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartingUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	//Start of declaration
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

        //Start of Welcome Panel
		//Area of welcoming texts to the User
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        
        lblWelcome1 = new JLabel();
        lblWelcome1.setText("Welcome to this bin packing Programm");
        welcomePanel.add(lblWelcome1, BorderLayout.NORTH);
        
        lblWelcome2 = new JLabel();
        lblWelcome2.setText("Please insert the maximum size of Elements per bin");
        welcomePanel.add(lblWelcome2, BorderLayout.CENTER);
        
        lblWelcome3 = new JLabel();
        lblWelcome3.setText("and press on of the buttons to continue.");
        welcomePanel.add(lblWelcome3, BorderLayout.SOUTH);
        
        this.add(welcomePanel, BorderLayout.NORTH);
        //End of Welcome Panel


		//Start of Iput Panel
		// Here the User wil insert the needed Information
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
		
        lblInput = new JLabel();
        lblInput.setText("Maximum Size: ");
        inputPanel.add(lblInput);
        
        tfInput = new JTextField(5);
        inputPanel.add(tfInput);
		
        this.add(inputPanel, BorderLayout.CENTER);
        //End of Input Panel

        //Start of Button Panel
		//Here will be placed two button so the User can decide between normal or functional Code
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        //ActionListener to perform the pressed Button
        ActionListener btnListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String action = event.getActionCommand();
				maxSize = Integer.parseInt(tfInput.getText());

				//The Buttons will open up the same UI, but they will hand over a different worker.
				//This way we can choose the Code to execute
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
			}
		};

        //Button to start Normal Code
		btnNormal = new JButton("Normal");
		btnNormal.setActionCommand(Action.ACTION_NORMAL.name());
		btnNormal.addActionListener(btnListener);
		buttonPanel.add(btnNormal);

		//Button to start Functional Code
		btnFunctional = new JButton("Functional");
		btnFunctional.setActionCommand(Action.ACTION_FUNCTIONAL.name());
		btnFunctional.addActionListener(btnListener);
		buttonPanel.add(btnFunctional);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
        //End of Button Panel

		this.pack();
		this.setVisible(true);
	}
}
