import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TransactionInterface extends JFrame
{
	JPanel hpanel,cpanel,tpanel;
	JLabel l1,l2,l3,l4,hlabel;
	JTextField t1,t2,t4;
	JPasswordField t3;
	JButton b1,b2,b3,b4;
	private TransactionDoa td;
	public TransactionInterface()
	{

			try		{
				td=new TransactionDoa();
				}
				catch(SQLException exe)
				{
					JOptionPane.showMessageDialog(null," Try Later!!!");
				}
				catch(ClassNotFoundException exe)
				{
					JOptionPane.showMessageDialog(null,"Unable to load driver!!!");
					System.exit(0);
		}
	}
	public void display()
	{

		hlabel=new JLabel("Welcome");
		hpanel=new JPanel();
		hpanel.add(hlabel);

		l1=new JLabel("Account");
		l2=new JLabel("Payee Accounr");
		l3=new JLabel("Pin");
		l4=new JLabel("Ammount");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JPasswordField(20);
		t4=new JTextField(20);
		cpanel=new JPanel();
		cpanel.setLayout(new GridLayout(4,2));
		cpanel.add(l1);
		cpanel.add(t1);
		cpanel.add(l2);
		cpanel.add(t2);
		cpanel.add(l3);
		cpanel.add(t3);
		cpanel.add(l4);
		cpanel.add(t4);

		b1=new JButton("Deposit");
		b2=new JButton("WithDraw");
		b3=new JButton("Transfer");
		b4=new JButton("Cancel");

		b1.addActionListener(
			e->{

			try{
				int status=0;
				String str="Credit";
			status=td.deposit(t1.getText().trim(),Integer.parseInt(t3.getText().trim()),Float.parseFloat(t4.getText().trim()),str);
			if(status==1)
				{
					JOptionPane.showMessageDialog(null,"Deposited Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Deposit failed");
				}
			}
			catch(SQLException exe)
			{
				JOptionPane.showMessageDialog(null,"Transaction Failed Try Later!!!");
			}
			});
		b4.addActionListener(e->{JOptionPane.showConfirmDialog(null,"Are you sure to Exit?","EXiting",JOptionPane.YES_NO_OPTION);
		System.exit(0);});
		b2.addActionListener(
			e->{

			try{
				int status=0;
				String str="Debit";
			status=td.withDraw(t1.getText().trim(),Integer.parseInt(t3.getText().trim()),Float.parseFloat(t4.getText().trim()),str);
			if(status==1)
				{
					JOptionPane.showMessageDialog(null,"WithDrawal of "+t4.getText()+"Successfull");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Deposited failed");
				}
			}
			catch(SQLException exe)
			{
				JOptionPane.showMessageDialog(null,"Transaction Failed Try Later!!!");
			}
			});
			b3.addActionListener(
						e->{

						try{
							int status=0;
							String str="Transfer";
						status=td.transfer(t1.getText().trim(),t2.getText().trim(),Integer.parseInt(t3.getText().trim()),Float.parseFloat(t4.getText().trim()),str);
						if(status==1)
							{
								JOptionPane.showMessageDialog(null,"Transfer of "+t4.getText()+"Successfull");
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Transfer failed");
							}
						}
						catch(SQLException exe)
						{
							JOptionPane.showMessageDialog(null,"Transaction Failed Try Later!!!");
						}
			});
		tpanel=new JPanel();
		tpanel.setLayout(new FlowLayout());
		tpanel.add(b1);
		tpanel.add(b2);
		tpanel.add(b3);
		tpanel.add(b4);

		setTitle("Banking App");
		setLocation(200,300);
		add(hpanel,BorderLayout.NORTH);
		add(cpanel,BorderLayout.CENTER);
		add(tpanel,BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	public static void main(String args[])
	{
		TransactionInterface t=new TransactionInterface();
		try
							{
								UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					SwingUtilities.updateComponentTreeUI(t);
								}
							catch(Exception e)
							{
								e.printStackTrace();
		}
		t.display();
	}
}