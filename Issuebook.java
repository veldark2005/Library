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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Issue_Book extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mid;
	private JTextField mname;
	private JTextField mbook;
	private JTable table;
	public static String book1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue_Book frame = new Issue_Book();
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
	public Issue_Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser mreturn = new JDateChooser();
		mreturn.setBounds(255, 371, 178, 39);
		contentPane.add(mreturn);
		
		JDateChooser mdate = new JDateChooser();
		mdate.setBounds(255, 310, 178, 39);
		contentPane.add(mdate);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setForeground(new Color(0, 255, 255));
		lblIssueBook.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblIssueBook.setBounds(423, 43, 183, 40);
		contentPane.add(lblIssueBook);
		
		JLabel lblMemberId = new JLabel("Member ID:");
		lblMemberId.setForeground(new Color(0, 255, 0));
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMemberId.setBounds(58, 115, 202, 78);
		contentPane.add(lblMemberId);
		
		JLabel lblMemberName = new JLabel("Member Name:");
		lblMemberName.setForeground(new Color(0, 255, 0));
		lblMemberName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMemberName.setBounds(58, 171, 202, 78);
		contentPane.add(lblMemberName);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setForeground(new Color(0, 255, 0));
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBookName.setBounds(58, 239, 202, 78);
		contentPane.add(lblBookName);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(0, 255, 0));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDate.setBounds(58, 300, 202, 78);
		contentPane.add(lblDate);
		
		JLabel lblReturnBook = new JLabel("Return Date:");
		lblReturnBook.setForeground(new Color(0, 255, 0));
		lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReturnBook.setBounds(58, 359, 202, 78);
		contentPane.add(lblReturnBook);
		
		mid = new JTextField();
		mid.setColumns(10);
		mid.setBounds(255, 132, 178, 38);
		contentPane.add(mid);
		
		mname = new JTextField();
		mname.setColumns(10);
		mname.setBounds(255, 191, 178, 38);
		contentPane.add(mname);
		
		mbook = new JTextField();
		mbook.setColumns(10);
		mbook.setBounds(255, 259, 178, 38);
		contentPane.add(mbook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(462, 135, 504, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Member ID", "Member Name", "Book Name", "Date", "Return Date"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					
					String sql="insert into issuebook values(?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, mid.getText());
					pts.setString(2, mname.getText());
					pts.setString(3, mbook.getText());
					pts.setString(4, mdate.getDate().toString()); 
                    pts.setString(5, mreturn.getDate().toString()); 

					
					mname.requestFocus();
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"it has been registered");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has been registered");

					}
			}
		});
		btnNewButton.setBounds(58, 435, 85, 38);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Show");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					Statement st=con.createStatement();
					String sql="select * from issuebook";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("mid"),rs.getString("mname"),rs.getString("mbook"),rs.getString("mdate"),rs.getString("mreturn")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(205, 435, 85, 38);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=mid.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					String sql="delete from issuebook WHERE mid='"+code+"'";
					PreparedStatement pts=con.prepareStatement(sql); 
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"Book deleted");
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
					
				}
			}
		});
		btnDelete.setBounds(58, 495, 85, 38);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard1().setVisible(true);
				System.out.println("true");
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnBack.setBounds(205, 495, 85, 38);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vishwa\\Downloads\\aaasusan-q-yin-2JIvboGLeho-unsplash-1024x683.png"));
		lblNewLabel.setBounds(0, 0, 987, 569);
		contentPane.add(lblNewLabel);
	}
}
