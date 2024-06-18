package login_system;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Label;

public class login {

	JFrame frame;
	private JTextField user;
	private JPasswordField pass;
	private JLabel error;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	} 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255)); 
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_5, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 20));
		pass.setBounds(446, 280, 269, 44);
		panel.add(pass);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 80, 818, 10);
		panel_2.setBackground(new Color(0, 0, 0));
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Library Management");
		lblNewLabel.setBounds(165, 12, 525, 58);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 41));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Username    :");
		lblNewLabel_1.setBounds(103, 198, 285, 48);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 35));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Password     :");
		lblNewLabel_2.setBounds(100, 268, 256, 68);
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 35));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(446, 198, 269, 44);
		user.setFont(new Font("Tahoma", Font.BOLD, 20));
		user.setForeground(new Color(0, 0, 0));
		panel.add(user);
		user.setColumns(10);
		
		JButton btnNewButton = new JButton("log-in");
		btnNewButton.setBounds(317, 423, 144, 50);
		btnNewButton.addActionListener(new ActionListener() {
			private int et;

			 public void actionPerformed(ActionEvent e) {
					try {
						String us = user.getText();
						String ps = pass.getText();
						System.out.println(us);

						System.out.println(ps);
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
						System.out.println("1");
						Statement st = con.createStatement();
						System.out.println("1");
						String sql = "Select * from access";
						System.out.println("1");
						ResultSet rs = st.executeQuery(sql);
						System.out.println("1");
						while(rs.next()){
						String username = rs.getString("username");
						System.out.println("1-");
						String password = rs.getString("password");
						System.out.println("1-");
                        et=0;
						if(us.equals(username) && ps.equals(password)){
							et=1;
						JOptionPane.showMessageDialog(btnNewButton,"successful", "Login",-1);
						Dashboard1 frame = new Dashboard1();
						frame.setVisible(true);
						System.out.println("true");
						SwingUtilities.windowForComponent(btnNewButton).dispose();
						}
						else{
						user.setText("");
						pass.setText("");
						System.out.println("false");
						
						}
						
						
							}
						if(et==0) {
							error.setText("Invalid");
					}
						}
					catch(Exception o) {
						JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					}
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 28));
		btnNewButton.setForeground(new Color(0, 0, 0));
		panel.add(btnNewButton);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register frame = new register();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(register).dispose();
			}
		});
		register.setForeground(Color.BLACK);
		register.setFont(new Font("Sitka Text", Font.BOLD, 26));
		register.setBounds(44, 425, 144, 47);
		panel.add(register);
		
		JButton btnNewButton_1 = new JButton("Forgot password\r\n");
		btnNewButton_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new forgetpage().setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
			
		});
		btnNewButton_1.setBounds(588, 423, 190, 47);
		panel.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( rdbtnNewRadioButton.isSelected()) {
					pass.setEchoChar((char)0);
				}
				else {
					pass.setEchoChar('*');
				}
			}
		});
		
		error = new JLabel("");
		error.setForeground(new Color(255, 0, 0));
		error.setFont(new Font("Tahoma", Font.BOLD, 22));
		error.setBounds(504, 359, 248, 56);
		panel.add(error);
		rdbtnNewRadioButton.setBounds(588, 323, 127, 21);
		panel.add(rdbtnNewRadioButton);
		
		JLabel pic_1 = new JLabel("");
		pic_1.setIcon(new ImageIcon("C:\\Users\\Vishwa\\OneDrive\\Pictures\\82860library-management-system.jpg"));
		pic_1.setBounds(-10, 0, 818, 533);
		panel.add(pic_1);
		frame.setBounds(100, 100, 835, 585);
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
