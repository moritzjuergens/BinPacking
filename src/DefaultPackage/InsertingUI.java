package DefaultPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InsertingUI extends JFrame {
	
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
	
	public InsertingUI(Worker worker, int maxSize) {
        super("Bin sorting");
        
        this.worker = worker;
        
        Bin.setMaxSize(maxSize);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setLayout(new BorderLayout());

        inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        lblInput = new JLabel("Element:");
        tfInput = new JTextField(20);
        
        lblErrorMessage = new JLabel("");

        ActionListener btnListener = b -> {
        	try {
        		worker.insertElement(validateUserInput(tfInput));
        		tfInput.setText("");
        		
        		outputPanel.removeAll();
        		
        		tblOutput = new JTable(worker.getDisplayData(), tableHeading);
        		
        		outputPanel.add(new JScrollPane(tblOutput), BorderLayout.SOUTH);
        		
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
	
	private void displayErrorMessage(String errorMessage) {
		removeErrorMessage();
		lblErrorMessage.setText(errorMessage);
		tfInput.setText("");
		this.pack();
	}

	private void removeErrorMessage() {
		lblErrorMessage.setText("");
		this.pack();
	}
	
	private int validateUserInput(JTextField tfInput) {
		if (tfInput == null || tfInput.getText().isEmpty()) {
			throw new IllegalArgumentException("Please insert a number");
		}
		try {
			return Integer.parseInt(tfInput.getText());
		} catch (Exception e) {
			throw new IllegalArgumentException("Must be a number");
		}
	}
}
