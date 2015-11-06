package MainSystem.Admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L; // To remove the warning
	
	private JFrame frame = new JFrame("Admin Login");
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton forgotPasswordButton;
	private LoginController myController;
	private JLabel messageLabel;
    
	public LoginGUI(LoginController myController)
	{
	    this.myController = myController;
	    
		JPanel contentPane = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gridBagLayout);
		
		JLabel lblWelcomeAdminPlease = new JLabel("Welcome Admin! Please login below.");
		GridBagConstraints gbc_lblWelcomeAdminPlease = new GridBagConstraints();
		gbc_lblWelcomeAdminPlease.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblWelcomeAdminPlease.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcomeAdminPlease.gridx = 4;
		gbc_lblWelcomeAdminPlease.gridy = 0;
		contentPane.add(lblWelcomeAdminPlease, gbc_lblWelcomeAdminPlease);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 3;
		gbc_lblUsername.gridy = 1;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		usernameField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(usernameField, gbc_textField);
		usernameField.setColumns(10);
		usernameField.setBounds(50, 20, 100, 20);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener (this);
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.gridx = 4;
		gbc_passwordField_1.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField_1);
		
		
		submitButton = new JButton("Submit");
        submitButton.addActionListener (this);
        GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
        gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
        gbc_btnSubmit.gridx = 4;
        gbc_btnSubmit.gridy = 3;
        contentPane.add(submitButton, gbc_btnSubmit);

		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().add(contentPane);
		
		forgotPasswordButton = new JButton("Forgot Password");
		forgotPasswordButton.addActionListener (this);
		GridBagConstraints gbc_btnForgotPassword = new GridBagConstraints();
		gbc_btnForgotPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnForgotPassword.insets = new Insets(0, 0, 5, 5);
		gbc_btnForgotPassword.gridx = 4;
		gbc_btnForgotPassword.gridy = 4;
		contentPane.add(forgotPasswordButton, gbc_btnForgotPassword);
		
		messageLabel = new JLabel("");
		GridBagConstraints gbc_lblLbl = new GridBagConstraints();
		gbc_lblLbl.gridwidth = 2;
		gbc_lblLbl.insets = new Insets(0, 0, 0, 5);
		gbc_lblLbl.gridx = 3;
		gbc_lblLbl.gridy = 5;
		contentPane.add(messageLabel, gbc_lblLbl);
		frame.setVisible(true);
	}

    public void actionPerformed (ActionEvent arg0)
    {
        if (arg0.getSource ().equals (this.submitButton) || arg0.getSource ().equals (this.passwordField))
        {
            myController.validateCredentials (usernameField.getText (), String.valueOf (passwordField.getPassword ()));
        }
        else if (arg0.getSource ().equals (this.forgotPasswordButton)) {
            myController.forgotPassword ();
        }
    }

    public void closeWindow ()
    {
        frame.dispose ();
    }

    public void displayErrorMessage (String string)
    {
        // TODO: Do we want to have something that looks a bit better than just a popup message?
        //JOptionPane.showMessageDialog (this, string, "Error", JOptionPane.ERROR_MESSAGE);
        messageLabel.setText (string);
    }
}
