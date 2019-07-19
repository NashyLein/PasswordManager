package com.nashy.password.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nashy.password.manager.swing.AccountCreationDialog;
import com.nashy.password.manager.swing.LoginDialog;


@SpringBootApplication
public class App extends JFrame {
	
	@Autowired
	private Services serv;
	
	private LoginDialog loginDialog;
	
	private AccountCreationDialog accountCreationDialog;

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public App() {

        initUI();
    }

    private void initUI() {
    	
    	JLabel label = new JLabel("Choississez ce que vous voulez faire");
    	JButton loginButton = new JButton("Login");
        JButton quitButton = new JButton("Quit");
        JButton createAccountButton = new JButton("Create account");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(1);
        });
        
        loginButton.addActionListener((ActionEvent event)-> {
        	loginDialog.setVisible(true);
        	if (loginDialog.isSucceeded()) {
        		loginDialog.dispose();
        	}
        });
        
        createAccountButton.addActionListener((ActionEvent event)-> {
        	accountCreationDialog.setVisible(true);
        });
        

        createLayout(label, loginButton, createAccountButton, quitButton);

        setTitle("Test");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();

        JPanel panel1 = new JPanel();
        panel1.add(arg[0]);
        panel1.setBorder(new LineBorder(Color.GRAY));
        JPanel panel2 = new JPanel();
        for (int i = 1; i < arg.length; i++) {
			panel2.add(arg[i]);
		}
        
        pane.add(panel1, BorderLayout.PAGE_START);
        pane.add(panel2, BorderLayout.CENTER);
    }
    
    @Bean
    public int populateDB() {
    	serv.populateDB();
    	return 0;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(App.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {
        	App app = ctx.getBean(App.class);
            LoginDialog loginDialog = ctx.getBean(LoginDialog.class, app);
            AccountCreationDialog accountCreation = ctx.getBean(AccountCreationDialog.class, app);
            app.loginDialog = loginDialog;
            app.accountCreationDialog = accountCreation;
            app.setVisible(true);
        });
    }
}
