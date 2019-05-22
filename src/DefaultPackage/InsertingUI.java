package DefaultPackage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
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
	private static final String[] tableHeading = {"Bin", "Quantity", "Elements"};
	private JTable tblOutput;
	//End of Declaration

	public InsertingUI(Worker worker, int maxSize) {
		super("Bin Sorting");

		//Initialize the eorker
		this.worker = worker;

		//Initialize the maximum size of out bins
		Bin.setMaxSize(maxSize);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		outputPanel = new JPanel(new BorderLayout());

		lblInput = new JLabel("Element:");
		tfInput = new JTextField(20);

		lblErrorMessage = new JLabel("");

		//ActionListener to add the element into the Bins
		ActionListener btnListener = b -> {
			try {
				//validates the enput and hands it over to the worker
				worker.insertElement(validateUserInput(tfInput));

				//empties the textfield
				tfInput.setText("");

				//empties the output Panel
				outputPanel.removeAll();

				//generates a new Table
				tblOutput = new JTable(worker.getDisplayData(), tableHeading);

				tblOutput.getColumnModel().getColumn(0).setMaxWidth(50);
				tblOutput.getColumnModel().getColumn(1).setMaxWidth(50);

				//highlights all full bins
				tblOutput.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
					@Override
					public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

						Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

						//Tests if there is any bin with the same index the current row has
						if (worker.getBinIndexOfFullBins().contains(row)){
							//Sets the Highlight Background
							setBackground(Color.PINK);
						} else {
							//Sets the default Background
							setBackground(Color.WHITE);
						}
						return this;
					}
				});

				//adds this new Panel back into the Output Panel
				outputPanel.add(new JScrollPane(tblOutput), BorderLayout.SOUTH);

				//adds the label to show the quantity of all elements
				outputPanel.add(new JLabel("Number of elements: " + worker.getNumberOfElements()), BorderLayout.NORTH);

				//if the element was successfully inserted we can clear the errors
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

		//KeyListener to make the UI more user-friendly
		//With this the user can insert the elements by pressing the enter key
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

	//In case of an exception, this will display a hint to the user
	private void displayErrorMessage(String errorMessage) {
		//empties the MessagePanel
		removeErrorMessage();
		//inserts new error
		lblErrorMessage.setText(errorMessage);
		//empties the input textfield
		tfInput.setText("");
		this.pack();
	}

	//Method to empty the messagePanel
	private void removeErrorMessage() {
		lblErrorMessage.setText("");
		this.pack();
	}

	//Checks if the given input is a valid input
	//The validateElement Method of the bins checks if the element is valid
	//This checks if there is actually an element
	private int validateUserInput(JTextField tfInput) {
		//tests if the textfield has actually something in it
		if (tfInput == null || tfInput.getText().isEmpty()) {
			throw new IllegalArgumentException("Please insert a number");
		}
		//tests if the Input is actually an integer
		try {
			return Integer.parseInt(tfInput.getText());
		} catch (Exception e) {
			throw new IllegalArgumentException("Must be a number");
		}
	}
}