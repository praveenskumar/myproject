import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FileDemo extends JFrame implements FocusListener
{

		public void focusGained(FocusEvent fe)
		{
			if(fe.getSource()==t1)
			{
				t1.setBackground(new Color(236,231,96));
			}
			if(fe.getSource()==t2)
			{
				t2.setBackground(new Color(236,231,96));
			}
			if(fe.getSource()==t3)
			{
				t3.setBackground(new Color(236,231,96));
			}
		}

		public void focusLost(FocusEvent fe)
		{
			if(fe.getSource()==t1)
			{
				t1.setBackground(new Color(255,255,255));
			}
			if(fe.getSource()==t2)
			{
				t2.setBackground(new Color(255,255,255));
			}

			if(fe.getSource()==t3)
			{
				t3.setBackground(new Color(255,255,255));
			}
		}


	//private String fname,lname,ph;
	JPanel panel;
	JButton b1;
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	public static boolean firstNameValidator(String firstName)
	{
		return firstName.matches("[A-Z][a-z]*");
	}

	public static boolean lastNameValidator(String lastName)
	{
		return lastName.matches("[A-Z][a-z]*");
	}

	public static boolean phoneValidator(String phone)
	{
		return phone.matches("\\d{10}");
	}
	public void storeData(String fname,String lname,String ph)
	{

		try(PrintWriter pw=new PrintWriter(new FileWriter("reg.txt",true)))
		{
			pw.print(fname);
			pw.print(",");
			pw.print(lname);
			pw.print(",");
			pw.print(ph);
			pw.print(",");
		}
		catch(IOException exe)
		{
			exe.printStackTrace();
		}
	}

public void createWindow()
{
	panel=new JPanel();
	panel.setLayout(null);
	l1=new JLabel("FirstName");
	l2=new JLabel("LastName");
	l3=new JLabel("Mobile");

	t1=new JTextField(32);
	t2=new JTextField(32);
	t3=new JTextField(10);

	b1=new JButton("Submit");

	b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			String s1,s2,s3,s4,s5,s6;
			s1=t1.getText();
			s4=s1.trim();
			System.out.println(s4);
			s2=t2.getText().trim();
			s3=t3.getText().trim();
			if(firstNameValidator(s4) && lastNameValidator(t2.getText().trim()) && phoneValidator(t3.getText().trim()))
			{
			storeData(s4,s2,s3);
			JOptionPane.showMessageDialog(null,"The data stored successfuly");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"InValid Input","Error",JOptionPane.WARNING_MESSAGE);
			}

		}
	});
	l1.setBounds(20,10,90,30);
	l2.setBounds(20,50,90,30);
	l3.setBounds(20,90,90,30);
	t1.setBounds(110,10,100,30);
	t1.addFocusListener(this);
	t2.addFocusListener(this);
	t3.addFocusListener(this);
	t2.setBounds(110,50,100,30);
	t3.setBounds(110,90,100,30);
	b1.setBounds(110,130,100,30);
	panel.add(l1);

	panel.add(t1);
	panel.add(l2);
	panel.add(t2);
	panel.add(l3);
	panel.add(t3);
	panel.add(b1);
	setTitle("FileDemo");
	setLocation(200,330);

	add(panel);
	setSize(250,250);
	setVisible(true);
}


	public static void main(String args[])
	{
	FileDemo fd=new FileDemo();
		try
					{
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(fd);
						}
					catch(Exception e)
					{
						e.printStackTrace();
		}
	fd.createWindow();
	}

}


