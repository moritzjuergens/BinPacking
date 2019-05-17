package DefaultPackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.scene.layout.Border;

public class StartingUI extends JFrame {
	
	private static final String ACTION_NORMAL = "NORMAL";
	private static final String ACTION_FUNCTIONAL = "FUNCTIONAL";
	
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
	
	public StartingUI () {
		super("Start Screen");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
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
        
        
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
		
        lblInput = new JLabel();
        lblInput.setText("Maximum Size: ");
        inputPanel.add(lblInput);
        
        tfInput = new JTextField(5);
        inputPanel.add(tfInput);
		
        this.add(inputPanel, BorderLayout.CENTER);
        
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        ActionListener btnListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String action = event.getActionCommand();
				maxSize = Integer.parseInt(tfInput.getText());
				
				if (action.equals("ACTION_NORMAL")) {
					worker = new WorkerNormal();
					new InsertingUI(worker, maxSize);
					
				} else if (action.equals("ACTION_FUNCTIONAL")) {
					worker = new WorkerFunctional();
					new InsertingUI(worker, maxSize);
				}
				setVisible(false);
			}
		};
		
		btnNormal = new JButton("Normal");
		btnNormal.setActionCommand("ACTION_NORMAL");
		btnNormal.addActionListener(btnListener);
		buttonPanel.add(btnNormal);
		
		btnFunctional = new JButton("Functional");
		btnFunctional.setActionCommand("ACTION_FUNCTIONAL");
		btnFunctional.addActionListener(btnListener);
		buttonPanel.add(btnFunctional);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
        
		this.pack();
		this.setVisible(true);
	}
}
