import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyLogin extends JFrame implements ActionListener,FocusListener
{

	JPanel login,iconpan;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	Icon icon;
	public void showLoginInterface()
	{
		login=new JPanel();
		login.setLayout(null);
		l1=new JLabel("username:");
		l2=new JLabel("password:");

		icon=new ImageIcon("icon_lock_key.gif");
		l3=new JLabel(icon);
		t1=new JTextField(32);
		t2=new JPasswordField(32);
		b1=new JButton("Login");
		b2=new JButton("Cancel");
		login.add(l3);
		l3.setBounds(0,0,120,150);
		login.add(l1);
		l1.setBounds(130,20,75,30);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		login.add(t1);
		t1.setBounds(205,20,215,30);
		login.add(l2);
		l2.setBounds(130,65,75,30);
		login.add(t2);
		t2.setBounds(205,65,215,30);
		login.add(b1);
		b1.setBounds(205,100,90,30);
		login.add(b2);
		b1.addActionListener(this);
		b2.setBounds(330,100,90,30);
		b2.addActionListener(this);
		setTitle("Login Module");
		setLocation(300,300);
		//add(iconpan,BorderLayout.WEST);
		add(login);
		pack();
		setSize(450,180);
		setVisible(true);
		//setDefaultCloseOperation(JOptionPane.showConfirmDialog(null,"Are you sure to quit the application",null,JOptionPane.OK_CANCEL_OPTION));

	}

	public void actionPerformed(ActionEvent ae)
	{
		String s1="arhot@live.com";
		String s2="9945786330";
		if(ae.getSource()==b1)
		{
				s1=t1.getText().trim();
				s2=t2.getText().trim();
				if(s1.equals("arhot@live.com") && s2.equals("9945786330"))
				{
					Compose c=new Compose();
					c.showCompose();
					c.setVisible(true);
					this.hide();
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid username or password","Login Error",JOptionPane.WARNING_MESSAGE);
					t1.requestFocus();
				}
		}
			else if(ae.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
				t1.requestFocus();
			}
	}

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

		if(fe.getSource()==b1)
		{
			b1.setBackground(new Color(158,185,247));
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
	}



	public static void main(String... args)
	{
		MyLogin ml=new MyLogin();

				try
				{
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		SwingUtilities.updateComponentTreeUI(ml);
					}
				catch(Exception e)
				{
					e.printStackTrace();
		}
		ml.showLoginInterface();
	}
}










