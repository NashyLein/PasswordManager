package com.nashy.password.manager.swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;

import com.nashy.password.manager.Services;
import com.nashy.password.manager.core.ApplicationCredentials;
import com.nashy.password.manager.core.User;

public class HomeDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Services services;
	
	private JPanel applicationList = new JPanel();
	
	private JPanel credentialsInfo = new JPanel();
	
	private String login;
		
	public HomeDialog(JFrame parent,String  login) {
		super(parent, "Home", true);
		
		this.login = login;
		JPanel globalPanel = new JPanel();
		globalPanel.setLayout(new BoxLayout(globalPanel, BoxLayout.Y_AXIS));
		JPanel panel = new JPanel(new GridBagLayout());
		globalPanel.add(panel);
        GridBagConstraints cs = new GridBagConstraints();
        
        EventQueue.invokeLater(() -> {
        	 User user = services.getUser(login);
             
             cs.fill = GridBagConstraints.HORIZONTAL;
             
             cs.gridx = 0;
             cs.gridy = 0;
             cs.gridwidth = 1;
             applicationList  = generateApplicationList(user, panel);
             panel.add(applicationList, cs);
             
             JPanel horizontalPanel = new JPanel();
             horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));
             horizontalPanel.add(new Button("toto"));
             horizontalPanel.add(new Button("titi"));
             globalPanel.add(horizontalPanel);
             
             add(globalPanel);
             setSize(600, 200);
             setLocationRelativeTo(parent);
        });
	}
	
	private JPanel generateApplicationList(User user, JPanel parent) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (ApplicationCredentials cur : user.getApplications()) {
			JLabel label = new JLabel(cur.getLocationName());
			panel.add(label);
			label.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					parent.remove(credentialsInfo);
					credentialsInfo = generateCredentialsInfo(cur.getLogin(), cur.getPassword());

					GridBagConstraints cs = new GridBagConstraints();
					cs.fill = GridBagConstraints.HORIZONTAL;
					cs.insets = new Insets(0, 50, 0, 50);
					cs.gridx = 1;
					cs.gridy = 0;
					cs.gridwidth = 1;
					parent.add(credentialsInfo, cs);
					parent.revalidate();
				}
				
			});
		}
		
		return panel;
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
