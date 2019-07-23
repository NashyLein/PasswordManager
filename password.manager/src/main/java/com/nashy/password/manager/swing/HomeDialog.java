package com.nashy.password.manager.swing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;

import com.nashy.password.manager.Services;

public class HomeDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Services services;
	
	private String login;
		
	public HomeDialog(JFrame parent,String  login) {
		super(parent, "Home", true);
		
		this.login = login;
		JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(generateCredentialsInfo("toto", "toto"), cs);
        
        add(panel);
        setSize(600, 200);
        setLocationRelativeTo(parent);
        
		
	}
	
	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	private JPanel generateCredentialsInfo(String username, String password) {
		JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        JLabel lbUsername = new JLabel("Nom d'utilisateur: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        JTextField tfUsername = new JTextField(20);
        tfUsername.setEditable(false);
        tfUsername.setText(username);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        JLabel lbPassword = new JLabel("Mot de passe: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        JTextField tfPassword = new JTextField(20);
        tfPassword.setEditable(false);
        tfPassword.setText(password);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
        
        return panel;

	}
	 
}
