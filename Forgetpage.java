package login_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class forgetpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userf;
	private JTextField newpass;
	private JTextField confirmpass;
	private JTextField captcha1;
	private String captcha;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgetpage frame = new forgetpage();
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
	public static String create() {
        Random rand = new Random();
        int length = 7 + (Math.abs(rand.nextInt()) % 3); // Fixed typo random -> rand, added closing parenthesis for Math.abs
        StringBuffer captcha = new StringBuffer(); // Fixed typo capt -> captcha
        for (int i = 0; i < length; i++) {
            int base = Math.abs(rand.nextInt()) % 62; // Fixed typo random -> rand
            int charNumber = 0; // Fixed typo charn -> charNumber
            char charN; // Added missing variable declaration char charN
            if (base < 26) {
                charN = (char) (65 + base); // Fixed typo char -> charN
            } else if (base < 52) {
                charN = (char) (97 + (base - 26)); // Fixed typo char -> charN, added missing parenthesis
            } else {
                charN = (char) (48 + (base - 52)); // Fixed typo char -> charN, changed -- to -
            }
            captcha.append(charN); // Fixed typo capatacha -> captcha, char -> charN
        }
        return captcha.toString(); // Fixed typo capatacha -> captcha
    }
	public forgetpage() {
		lblNewLabel=new JLabel();
		captcha=create();
		lblNewLabel.setText(captcha);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(304, 374, 190, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUser.setBounds(42, 96, 202, 78);
		contentPane.add(lblUser);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewPassword.setBounds(42, 160, 202, 78);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("confirm password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConfirmPassword.setBounds(42, 231, 202, 78);
		contentPane.add(lblConfirmPassword);
		
		userf = new JTextField();
		userf.setBounds(294, 105, 200, 50);
		contentPane.add(userf);
		userf.setColumns(10);
		
		newpass = new JTextField();
		newpass.setColumns(10);
		newpass.setBounds(294, 181, 200, 50);
		contentPane.add(newpass);
		
		confirmpass = new JTextField();
		confirmpass.setColumns(10);
		confirmpass.setBounds(294, 252, 200, 50);
		contentPane.add(confirmpass);
		
		JButton btnNewButton = new JButton("change password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						int i=1;
						String s=captcha1.getText();
						
						String us1 = userf.getText();
						String np = newpass.getText();	
						String cp = confirmpass.getText();
						if(!s.equals(captcha))
						{
							captcha1.setText("");
							JOptionPane.showMessageDialog(null,"invalid captcha");
						
							
						}else {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
						Statement st1 = con1.createStatement();
						String sql1 =  "Select * from access";
						ResultSet res1 = st1.executeQuery(sql1);
						
						
						while(res1.next()) {
							String use1 = res1.getString("username");
							System.out.print("1");
						
							if(us1.equals(use1) && np.equals(cp))  {
								String sql2 = "update access set password = '"+np+"' where username = '"+us1+"'";
								PreparedStatement pts = con1.prepareStatement(sql2);
								System.out.print(np);
							    /*pts.setValueAt(np,sql2,0);
							    System.out.print(i);
								pts.setInt(1,i);
								System.out.println(sql2);*/
								System.out.println("2");
								pts.executeUpdate(sql2);
								System.out.print("success");
								JOptionPane.showMessageDialog(btnNewButton, " data updated", "updated", -1);
								try {
									login window = new login();
									window.frame.setVisible(true);
									SwingUtilities.windowForComponent(btnNewButton).dispose();
									
								}
								catch(Exception a)
								{
									JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
								}
							}
							else {
							     userf.setText("");
							     newpass.setText("");
							     confirmpass.setText("");
							    							     
							}
							i++;
						}
						
					}}
					
					
						
						catch(Exception os)
						{
							System.out.print(os);
							JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
						}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(631, 276, 175, 68);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login window = new login();
				window.frame.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setBounds(669, 374, 90, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblForgotPassword.setBounds(349, 10, 240, 40);
		contentPane.add(lblForgotPassword);
		
		JButton btnNewButton_2 = new JButton("Generate Captcha");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				captcha = create();
				lblNewLabel.setText(captcha);
			}
		});
		btnNewButton_2.setBounds(42, 382, 180, 32);
		contentPane.add(btnNewButton_2);
		
		captcha1 = new JTextField();
		captcha1.setColumns(10);
		captcha1.setBounds(294, 325, 200, 50);
		contentPane.add(captcha1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Captcha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(42, 319, 222, 50);
		contentPane.add(lblNewLabel_1);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
