package login_system;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
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
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Book extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
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
	public Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("print");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				table_1.print();
				}
				catch(PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(144, 370, 125, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblViewBook = new JLabel("View Book");
		lblViewBook.setBackground(new Color(64, 0, 0));
		lblViewBook.setForeground(new Color(0, 255, 255));
		lblViewBook.setBounds(425, 45, 142, 33);
		lblViewBook.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblViewBook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(407, 125, 476, 296);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Book Name", "Category"
			}
		));
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard1 frame = new Dashboard1();
				frame.setVisible(true);
				//Component btnNewButton = null;
				SwingUtilities.windowForComponent(btnCancel).dispose();
			}
		});
		btnCancel.setBounds(144, 269, 125, 56);
		contentPane.add(btnCancel);
		
		JButton btnViewBook = new JButton("View Book");
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
				Statement st=con.createStatement();
				String sql="select * from category";
				
				PreparedStatement pts=con.prepareStatement(sql);
				ResultSet rs= pts.executeQuery();
				    DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
				dt.setRowCount(0);
				while(rs.next()) {
				
				Object o[]= {rs.getString("id"),rs.getString("category_name"),rs.getString("Bookname")};
				dt.addRow(o);
				}
		}
			catch(Exception ec) {
				JOptionPane.showMessageDialog(null,"it has not been registered");
				ec.printStackTrace();
			}
		}
			
		});
		btnViewBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViewBook.setBounds(144, 160, 125, 56);
		contentPane.add(btnViewBook);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vishwa\\Downloads\\sxs.jpg"));
		lblNewLabel.setBounds(0, 0, 989, 493);
		contentPane.add(lblNewLabel);
	}
}
