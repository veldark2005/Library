package login_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;

public class history extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					history frame = new history();
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
	public history() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard1().setVisible(true);
				System.out.println("true");
				SwingUtilities.windowForComponent(btnNewButton_2).dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(56, 410, 99, 32);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(211, 24, 644, 565);
		contentPane.add(scrollPane);
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("print");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
					}
					catch(PrinterException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBounds(56, 330, 99, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("HISTORY");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblNewLabel_1.setBounds(16, 39, 185, 50);
		contentPane.add(lblNewLabel_1);
		
		
		
		textField = new JTextField();
		textField.setBounds(37, 129, 146, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add records");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\n\t\t...User History...\n\n");
				
				textArea.append("\t\t----------------------\n");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					Statement st=con.createStatement();
					String sql="select * from issuebook join returnbook on issuebook.mid=returnbook.rid where issuebook.mid=? ";
					
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, textField.getText());
					ResultSet rs= pts.executeQuery();

					while(rs.next()) {
					
					textArea.append("\t\tIssue Summary\n");
					String h="\tMember id         : "+rs.getString(1)+"\n";
					textArea.append("\t\t----------------------\n");
					String c="\tMember name   : "+rs.getString(2)+"\n";
					
					String hc="\tMember book    : "+rs.getString(3)+"\n";
					
					String ch="\tMember date     : "+rs.getString(4)+"\n";
					
					String chu="\tMember return : "+rs.getString(5)+"\n";
					
					
					//textArea.append("\t\t\tReturn Summary\n");
					String hi="\tReturn id       :\t"+rs.getString(6)+"\n";
					String ci="\tReturn book  :\t"+rs.getString(7)+"\n";
					String hkc="\tReturn date   :\t"+rs.getString(8)+"\n";
					String chn="\tReturn elap   :\t"+rs.getString(9)+"\n";
					String cbhu="\tReturn fine    :\t"+rs.getString(10)+"\n";
					
					
					
					
					textArea.append(h);
					textArea.append(c);
					textArea.append(hc);
					textArea.append(ch);
					textArea.append(chu);
					textArea.append("\t\t----------------------\n");
					textArea.append("\t\tReturn Summary\n");
					textArea.append("\t\t----------------------\n");
					textArea.append(hi);
					textArea.append(ci);
					textArea.append(hkc);
					textArea.append(chn);
					textArea.append(cbhu);
					//textArea.append(chk);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(42, 231, 138, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vishwa\\Downloads\\VIG4Ex.jpg"));
		lblNewLabel.setBounds(0, 0, 898, 660);
		contentPane.add(lblNewLabel);
	}
}
