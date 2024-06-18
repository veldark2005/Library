package login_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Dashboard1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard1 frame = new Dashboard1();
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
	public Dashboard1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("CATEGORY");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(115, 100, 128, 63);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new category().setVisible(true);
				System.out.println("true");
				SwingUtilities.windowForComponent(btnNewButton).dispose();

			}
		});
		contentPane.setLayout(null);
		
		JButton btnHistory = new JButton("HISTORY");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				history frame = new history();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(btnHistory).dispose();
				
			}
		});
		btnHistory.setForeground(Color.WHITE);
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistory.setBackground(Color.BLACK);
		btnHistory.setBounds(115, 450, 128, 63);
		contentPane.add(btnHistory);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JButton btnViewBook = new JButton("VIEW BOOK");
		btnViewBook.setForeground(Color.WHITE);
		btnViewBook.setBackground(new Color(0, 0, 0));
		btnViewBook.setBounds(115, 190, 128, 63);
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book frame = new Book();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();

			}
		});
		btnViewBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnViewBook);
		
		JButton ISSUE = new JButton("ISSUE BOOK");
		ISSUE.setForeground(Color.WHITE);
		ISSUE.setBackground(new Color(0, 0, 0));
		ISSUE.setBounds(115, 280, 128, 63);
		ISSUE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issue_Book frame = new Issue_Book();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(ISSUE).dispose();

			}
		});
		ISSUE.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(ISSUE);
		
		JButton RETURN = new JButton("RETURN BOOK");
		RETURN.setForeground(Color.WHITE);
		RETURN.setBackground(new Color(0, 0, 0));
		RETURN.setBounds(115, 360, 128, 63);
		RETURN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return_Book frame = new Return_Book();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(RETURN).dispose();


			}
		});
		RETURN.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(RETURN);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(new Color(0, 0, 0));
		btnLogOut.setBounds(115, 540, 128, 63);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login window = new login();
				window.frame.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("LIBRARY MANAGEMENT");
		lblNewLabel.setBounds(52, 27, 270, 56);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(0, 0, 358, 630);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vishwa\\Downloads\\d2665c2dfc5ee37579f04db818156dd5.jpg"));
		lblNewLabel_2.setBounds(0, 0, 369, 655);
		contentPane.add(lblNewLabel_2);
	}
}
