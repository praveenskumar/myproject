import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Compose extends JFrame implements ActionListener
{
	JPanel addressPanel;
	JPanel textPanel;
	JPanel controlPanel;
	JTextField address,subject;
	JTextArea body;
	JButton send,cancel;
	JLabel to;
	JLabel message;
	JLabel subjectlab;

	 class Focus implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			if(e.getSource()==address)
			{
				address.setBackground(new Color(22,33,33));
			}
			 if(e.getSource()==subject)
			{
				subject.setBackground(new Color(22,33,33));
			}
			 if(e.getSource()==body)
			 {
				 body.setBackground(new Color(22,33,33));
			 }
		 }
		 public void focusLost(FocusEvent fe)
		 {
			if(fe.getSource()==address)
			{
				address.setBackground(new Color(255,255,255));
			}
			 if(fe.getSource()==subject)
			{
				subject.setBackground(new Color(255,255,255));
			}
			 if(fe.getSource()==body)
			 {
				 body.setBackground(new Color(255,255,255));
			 }
		 }
	 }


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==send)
		{
			JOptionPane.showMessageDialog(null,"success","The message sent Successfully",1);
		}
		else if(ae.getSource()==cancel)
		{
			JOptionPane.showMessageDialog(null,"canceled","Sending Aborted",1);
		}
	}



	public void showCompose()
	{
		addressPanel=new JPanel(new GridLayout(2,2));
		textPanel=new JPanel(new GridLayout(1,1));
		controlPanel=new JPanel(new GridLayout(1,2));
		to=new JLabel("To");
		subjectlab=new JLabel("Subject");
		message=new JLabel("Message");
		address=new JTextField(50);
		address.addFocusListener(new Focus());
		subject=new JTextField(50);
		subject.addFocusListener(new Focus());
		body=new JTextArea(30,40);
		body.addFocusListener(new Focus());
		send=new JButton("Send");
		send.addActionListener(this);
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);

		addressPanel.add(to);
		addressPanel.add(address);
		addressPanel.add(subjectlab);
		addressPanel.add(subject);

		textPanel.add(body);

		controlPanel.add(send);
		controlPanel.add(cancel);
		add(addressPanel,BorderLayout.NORTH);
		add(textPanel,BorderLayout.CENTER);
		add(controlPanel,BorderLayout.SOUTH);
		setTitle("Mailer");
		setLocation(220,330);
		pack();
		//setVisible(true);
	}
}






