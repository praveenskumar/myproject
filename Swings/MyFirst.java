import javax.swing.*;
import com.sun.java.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyFirst extends JFrame implements ActionListener
{
	 JPanel panel,iconPanel;
	 JLabel l1,l2,l3;
	 JTextField username;
	 JPasswordField password;
	 JButton button;
	 JCheckBox checkBox;
	 JRadioButton ra1,ra2;
	 JComboBox j1;
	Icon loginIcon=new ImageIcon("icon_lock_key.gif");
	JLabel iconLab=new JLabel(loginIcon);
	JLabel lab=new JLabel("You are not a valid user");
	public  void ShowGUI()
	{
		iconPanel=new JPanel();
		iconPanel.add(iconLab);
		panel=new JPanel();
		panel.setLayout(new java.awt.GridLayout(5,2));
		l1=new JLabel("username:");
		l2=new JLabel("password:");
		l3=new JLabel("Select Country");
		username=new JTextField(20);
		password=new JPasswordField(20);
		button=new JButton("Login");
		button.addActionListener(this);
		checkBox=new JCheckBox("Agree Terms");
		ra1=new JRadioButton("Admin");
		ra2=new JRadioButton("User");
		j1=new JComboBox();
		panel.add(l1);
		panel.add(username);
		j1.addItem("India");
		j1.addItem("USA");
		j1.addItem("Cannada");

		panel.add(l2);
		panel.add(password);
		ButtonGroup bg=new ButtonGroup();
		bg.add(ra1);
		bg.add(ra2);
		panel.add(ra1);
		panel.add(ra2);
		panel.add(checkBox);
		panel.add(button);
		panel.add(l3);
		panel.add(j1);
getContentPane().add(panel,BorderLayout.EAST);
getContentPane().add(iconPanel,BorderLayout.WEST);
pack();
}
public void actionPerformed(ActionEvent ae)
{
	String uname,pwd;
	if(ae.getSource()==button)
	{
		uname=username.getText().trim();
		pwd=password.getText().trim();
		if((uname==null || uname=="") && (pwd==null || pwd==""))
			{
			JOptionPane.showMessageDialog(null,null,"please enter username & password",1);
			}
		else
				{
		 			if(uname.equals("sa") && pwd.equals("admin"))
					{
						Compose msg=new Compose();
						msg.showCompose();
						this.hide();
					}
						else
					{
						JOptionPane.showMessageDialog(null,lab,"oops!!!!",1);
						username.setText("");
						password.setText("");
						username.requestFocus();
						}
				}
	}

}

	public static void main(String... args)
	{
		MyFirst frame=new MyFirst();

				frame.setTitle("Login");
				//frame.setSize(550,400);
				frame.setLocation(300,200);
//				frame.getContentPane().add(panel);
				frame.setVisible(true);
	//	frame.pack();

		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
SwingUtilities.updateComponentTreeUI(frame);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		frame.ShowGUI();
	}
}
