package DefaultPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InsertingUI extends JFrame {

	//Start of declaration
	private Worker worker;
	
	private JPanel inputPanel;
	private JLabel lblInput;
	private JTextField tfInput;
	private JButton btnInput;
	
	private JPanel messagePanel;
	private JLabel lblErrorMessage;
	
	private JPanel outputPanel;
	private static final String[] tableHeading = {"Bin", "Elements"};
	private JTable tblOutput;
	//End of Declaration
	
	public InsertingUI(Worker worker, int maxSize) {
        super("Bin sorting");

        //Initialize the Worker
        this.worker = worker;

        //Initialize the maximum Size of out bins
        Bin.setMaxSize(maxSize);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setLayout(new BorderLayout());

        inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        lblInput = new JLabel("Element:");
        tfInput = new JTextField(20);
        
        lblErrorMessage = new JLabel("");

        //ActionListener to add the Element into the Bins
        ActionListener btnListener = b -> {
        	try {
        		//validates the Input and hands it over to the worker
        		worker.insertElement(validateUserInput(tfInput));
        		//empties the textfield
        		tfInput.setText("");

        		//empties the output Panel
        		outputPanel.removeAll();

        		//generates a new Table
        		tblOutput = new JTable(worker.getDisplayData(), tableHeading);

        		//adds this new Panel back into the Output Panel
        		outputPanel.add(new JScrollPane(tblOutput), BorderLayout.SOUTH);

        		//if the Element was succesfully inserted we can clear the Errors
        		removeErrorMessage();
        		
        		this.pack();
        	} catch (IllegalArgumentException e) {
        		System.err.println(e);	
        		displayErrorMessage(e.getMessage());
        	} catch (Exception e) {
        		System.err.println(e);	
        		displayErrorMessage("An exception occured please try again.");
        	}
        };

        btnInput = new JButton("Insert element");
        btnInput.addActionListener(btnListener);

        //KeyListener to make the UI more comfortable
		//With this the User can insert the Elements by pressing the Enter Key
        tfInput.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_ENTER){
        			btnInput.doClick();
        		}
        	}
        });

        inputPanel.add(lblInput);
        inputPanel.add(tfInput);
        inputPanel.add(btnInput);
        
        messagePanel.add(lblErrorMessage);
        
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(messagePanel, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    //In Case of an Exception, this will display a Hint to the User
	private void displayErrorMessage(String errorMessage) {
		//empties the MessagePanel
		removeErrorMessage();
		//inserts new Error
		lblErrorMessage.setText(errorMessage);
		//empties the input textflied
		tfInput.setText("");
		this.pack();
	}

	//Method to empty the messagePanel
	private void removeErrorMessage() {
		lblErrorMessage.setText("");
		this.pack();
	}

	//Checks if the given input is a valid input
	//The validateElement Method of the Bins checks if the Element is valid
	//This checks if there is actually an Element
	private int validateUserInput(JTextField tfInput) {
		//tests if the textfield has actually something in it
		if (tfInput == null || tfInput.getText().isEmpty()) {
			throw new IllegalArgumentException("Please insert a number");
		}
		//tests if the Input is actually an Integer
		try {
			return Integer.parseInt(tfInput.getText());
		} catch (Exception e) {
			throw new IllegalArgumentException("Must be a number");
		}
	}
}
