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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class category extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField category_name;
	private JTable table;
	private JTable table_1;
	private JTextField Bookname;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					category frame = new category();
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
	public category() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(381, -28, 580, 161);
		contentPane.add(lblNewLabel);
		
		JLabel lblCategoryName = new JLabel("Category name:");
		lblCategoryName.setForeground(new Color(0, 0, 0));
		lblCategoryName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCategoryName.setBounds(66, 210, 202, 78);
		contentPane.add(lblCategoryName);
		
		JLabel lblStatus = new JLabel("Book Name:");
		lblStatus.setForeground(new Color(0, 0, 0));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStatus.setBounds(68, 270, 223, 90);
		contentPane.add(lblStatus);
		
		category_name = new JTextField();
		category_name.setBounds(261, 224, 178, 38);
		contentPane.add(category_name);
		category_name.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					
					String sql="insert into category values(?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, category_name.getText());
					pts.setString(2, textField_1.getText());
					pts.setString(3, textField.getText());
					pts.executeUpdate();
                    String sql1="select * from appointment";
					
					PreparedStatement pts1=con.prepareStatement(sql1);
					ResultSet rs= pts.executeQuery();
					textField.requestFocus();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
						Object o[]= {rs.getString("aid"),rs.getString("adate"),rs.getString("aname")};
						
						dt.addrow(o);
					}	
					
					

					
					
					 JOptionPane.showMessageDialog(null,"it has been registered");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has been registered");

					}*/
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					
					String sql="insert into category values(?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, id.getText());
					pts.setString(2, category_name.getText());
					pts.setString(3, Bookname.getText());
					

					
					category_name.requestFocus();
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"it has been registered");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has been registered");

					}
			}
		});
		btnNewButton.setBounds(66, 384, 85, 38);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=id.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
					String sql="delete from category WHERE id='"+code+"'";
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
		btnDelete.setBounds(206, 384, 85, 38);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard1().setVisible(true);
				System.out.println("true");
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnCancel.setBounds(206, 453, 85, 38);
		contentPane.add(btnCancel);
		
		table = new JTable();
		table.setBounds(764, 248, 0, 0);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 180, 465, 180);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "BOOK NAME", "CATEGORY NAME"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(128);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(79);
		
		Bookname = new JTextField();
		Bookname.setColumns(10);
		Bookname.setBounds(261, 292, 178, 38);
		contentPane.add(Bookname);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(69, 169, 146, 31);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(261, 162, 178, 38);
		contentPane.add(id);
		
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
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
		btnShow.setBounds(66, 453, 85, 38);
		contentPane.add(btnShow);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vishwa\\Downloads\\61897a35583a9b51db018d3e_MartinPublicSeating-97560-Importance-School-Library-blogbanner1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 971, 560);
		contentPane.add(lblNewLabel_2);
	}	
}
	
	//public void Connect()

	/*	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","vishwa");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/

