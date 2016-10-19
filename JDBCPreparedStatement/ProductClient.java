import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ProductClient extends JFrame
{

public List<Product> products=new ArrayList<>();


	JLabel headerLabel,l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4;
	JPanel headerPanel,contentPanel,footerPanel;
	private ProductFactory proxy;
	private ProductInterface dao;

	//constructor begins
	public ProductClient()
	{
	try{
	proxy=new ProductFactory();
	dao=proxy.createInstance();

	}

	catch(ClassNotFoundException exe)
	{
		JOptionPane.showMessageDialog(null,"Driver Not Found");
		System.exit(0);
	}
	catch(SQLException exe)
	{
	JOptionPane.showMessageDialog(null,"Unable to connect to Server");
	}
	}//constructor ends


	//this method creates window
	public void createAndShowGUI()
	{
		headerLabel=new JLabel("ProductDetails");
		headerLabel.setFont(new Font(Font.SANS_SERIF,java.awt.Font.ITALIC,16));
		l1=new JLabel("ProductID");
		l2=new JLabel("Product");
		l3=new JLabel("Price");
		l4=new JLabel("qty");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);

		b1=new JButton("Select");
		b2=new JButton("Insert");
		b3=new JButton("Update");
		b4=new JButton("Delete");
		headerPanel=new JPanel();
		contentPanel=new JPanel();
		footerPanel=new JPanel();

		headerPanel.add(headerLabel);
		contentPanel.setLayout(new GridLayout(4,2));
		contentPanel.add(l1);
		contentPanel.add(t1);
		contentPanel.add(l2);
		contentPanel.add(t2);
		contentPanel.add(l3);
		contentPanel.add(t3);
		contentPanel.add(l4);
		contentPanel.add(t4);
		footerPanel=new JPanel();
		footerPanel.setLayout(new FlowLayout());
		footerPanel.add(b1);
		footerPanel.add(b2);
		footerPanel.add(b3);
		footerPanel.add(b4);
		add(headerPanel,BorderLayout.NORTH);
		add(contentPanel,BorderLayout.CENTER);
		add(footerPanel,BorderLayout.SOUTH);
		pack();
		setVisible(true);
		setLocation(250,250);
		b1.addActionListener(e->{
			try{
				ResultSet rs=dao.select(t1.getText().trim());
				if(rs.next())
				{
					Product p=new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
					t2.setText(p.getName());
					t3.setText(new Integer(p.getPrice()).toString());
					t4.setText(new Integer(p.getQty()).toString());
				}
				}
			catch(SQLException exe)
			{
				JOptionPane.showMessageDialog(null,"Unable to retreive the data from the database");

			}
			});
			//insert
			b2.addActionListener(e->{
				int rowAffected=0;
				try{
					Product p=new Product(t1.getText().trim(),t2.getText().trim(),Integer.parseInt(t3.getText().trim()),Integer.parseInt(t4.getText().trim()));
				rowAffected=dao.insert(p.getId(),p.getName(),p.getPrice(),p.getQty());
				if(rowAffected>0)
				{
					JOptionPane.showMessageDialog(null,"Data Inserted Succesfully");
				}
			}
			catch(SQLException exe)
			{
					JOptionPane.showMessageDialog(null,"Data was not Inserted");
			}
		});
	//update
		b3.addActionListener(e->{
			try{
				int rowAffected=0;
				Product p=new Product();
				p.setPrice(Integer.parseInt(t3.getText().trim()));
				p.setQty(Integer.parseInt(t4.getText().trim()));
				p.setId(t1.getText().trim());
				rowAffected=dao.update(p.getPrice(),p.getQty(),p.getId());
				if(rowAffected>0)
				{
					JOptionPane.showMessageDialog(null,"Updated Successfully");
				}
			}
			catch(SQLException exe)
			{
				JOptionPane.showMessageDialog(null,"Failed to Update");
			}});

		b4.addActionListener(e->{
			try{
				int rowAffected=0;
				Product p=new Product();
				p.setId(t1.getText().trim());
				rowAffected=dao.delete(p.getId());
				if(rowAffected>0)
				{
					JOptionPane.showMessageDialog(null,"DELETED SuccessFully");
				}
				}
				catch(SQLException exe)
				{
					JOptionPane.showMessageDialog(null,"Unable to delete");
				}
			});


	}//window creating method ends

public static void main(String args[])
{


	ProductClient pc=new ProductClient();
	pc.createAndShowGUI();
}
}
