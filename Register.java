package login_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newuser;
	private JPasswordField newpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		newuser = new JTextField();
		newuser.setForeground(Color.BLACK);
		newuser.setFont(new Font("Tahoma", Font.BOLD, 20));
		newuser.setColumns(10);
		newuser.setBounds(309, 152, 269, 44);
		contentPane.add(newuser);
		
		newpass = new JPasswordField();
		newpass.setFont(new Font("Tahoma", Font.BOLD, 25));
		newpass.setBounds(309, 247, 269, 44);
		contentPane.add(newpass);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					int c=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");

					Statement st1 = con.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					System.out.println("1");
					
					System.out.println("2");
					String sql2 = "SELECT COUNT(*) AS count FROM access";
					
				
					PreparedStatement ps2 = con.prepareStatement(sql2);
					System.out.println("4");
					ResultSet res2 = ps2.executeQuery();
					System.out.println("5");
					String input = newpass.getText();
					int inputLen = input.length();
					int uppercount=0;
					int lowercount=0;
		        	int digitcount=0;
					for(int j =0; j < inputLen ; j++)
					{
						char ch = input.charAt(j);
						if (Character.isUpperCase(ch))
							uppercount++;
						else if (Character.isLowerCase(ch))
							lowercount++;
						else if (Character.isDigit(ch))
							digitcount++;
					}
					System.out.print(uppercount);
					System.out.print(lowercount);
					System.out.print(digitcount);
					while(res2.next())
					{ c = res2.getInt(1);
					 System.out.print(c);}
					c+=1;
					while(res1.next()) {
						
						if(  uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
							
					String sql="insert into access (username,password) values(?,?)";
					
					PreparedStatement pts=con.prepareStatement(sql);

					pts.setString(1, newuser.getText());
					pts.setString(2, newpass.getText());
					
					
					 
					
					 newuser.setText("");
					 newpass.setText("");
					
					
					pts.executeUpdate();


					JOptionPane.showMessageDialog(null,"Acount has been registered");
						}
						
						break;
						
					}
					 
					
				
				}
				catch(Exception eX) {
				eX.printStackTrace();	
				}
			}
		});
		register.setForeground(Color.BLACK);
		register.setFont(new Font("Tahoma", Font.BOLD, 25));
		register.setBounds(368, 328, 144, 50);
		contentPane.add(register);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(146, 150, 129, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(146, 247, 129, 44);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Library Management");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(212, 41, 525, 58);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login window = new login();
				window.frame.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(389, 408, 107, 50);
		contentPane.add(btnNewButton_1);
	}
}
