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
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class Return_Book extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rid;
	private JTextField rbook;
	private JTable table;
	private JTextField relap;
	private JTextField rfine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return_Book frame = new Return_Book();
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
	public Return_Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser rdate = new JDateChooser();
		rdate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdate.setBounds(257, 240, 178, 38);
		contentPane.add(rdate);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setForeground(new Color(0, 255, 255));
		lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblReturnBook.setBounds(429, 21, 183, 40);
		contentPane.add(lblReturnBook);
		
		JLabel lblMemberId = new JLabel("Member ID:");
		lblMemberId.setForeground(new Color(255, 255, 0));
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMemberId.setBounds(66, 77, 202, 78);
		contentPane.add(lblMemberId);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setForeground(new Color(255, 255, 0));
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBookName.setBounds(66, 152, 202, 78);
		contentPane.add(lblBookName);
		
		JLabel lblReturnDate = new JLabel("Return Date:");
		lblReturnDate.setForeground(new Color(255, 255, 0));
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReturnDate.setBounds(66, 220, 202, 78);
		contentPane.add(lblReturnDate);
		
		JLabel lblDaysElap = new JLabel("Days Elap:");
		lblDaysElap.setForeground(new Color(255, 255, 0));
		lblDaysElap.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDaysElap.setBounds(66, 282, 202, 78);
		contentPane.add(lblDaysElap);
		
		JLabel lblFine = new JLabel("Fine:");
		lblFine.setForeground(new Color(255, 255, 0));
		lblFine.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFine.setBounds(66, 348, 202, 78);
		contentPane.add(lblFine);
		
		rid = new JTextField();
		rid.setColumns(10);
		rid.setBounds(257, 104, 178, 38);
		contentPane.add(rid);
		
		rbook = new JTextField();
		rbook.setColumns(10);
		rbook.setBounds(257, 178, 178, 38);
		contentPane.add(rbook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 115, 464, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Member ID", "Member Name", "Book Name", "Return Date", "Days Elap", "Fine"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					
					String sql="insert into returnbook values(?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, rid.getText());
					pts.setString(2, rbook.getText());
					pts.setString(3, rdate.getDate().toString());
					pts.setString(4, relap.getText());
					pts.setString(5, rfine.getText());					

					
					rbook.requestFocus();
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"it has been registered");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
						ex.printStackTrace();

					}
			}
		});
		btnNewButton.setBounds(66, 436, 85, 38);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Show");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					Statement st=con.createStatement();
					String sql="select returnbook.rid,issuebook.mname,returnbook.rbook,returnbook.rdate,returnbook.relap,returnbook.rfine from issuebook inner join returnbook ON issuebook.mid=returnbook.rid where issuebook.mid=?";
					
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, rid.getText());
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("returnbook.rid"),rs.getString("issuebook.mname"),rs.getString("returnbook.rbook"),rs.getString("returnbook.rdate"),rs.getString("returnbook.relap"),rs.getString("returnbook.rfine")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(234, 436, 85, 38);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=rid.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					String sql="delete from returnbook WHERE rid='"+code+"'";
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
		btnDelete.setBounds(66, 495, 85, 38);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard1().setVisible(true);
				System.out.println("true");
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnBack.setBounds(234, 495, 85, 38);
		contentPane.add(btnBack);
		
		relap = new JTextField();
		relap.setColumns(10);
		relap.setBounds(257, 308, 178, 38);
		contentPane.add(relap);
		
		rfine = new JTextField();
		rfine.setColumns(10);
		rfine.setBounds(257, 370, 178, 38);
		contentPane.add(rfine);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vishwa\\Downloads\\1701414904328.jpg"));
		lblNewLabel.setBounds(0, 0, 992, 588);
		contentPane.add(lblNewLabel);
	}
}
