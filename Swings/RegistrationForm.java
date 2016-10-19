import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame implements ActionListener
{
	FocusListener bg=new FocusListener(){

		                    public void focusGained(FocusEvent e) {
		                        e.getComponent().setBackground(Color.YELLOW);
		                    }


		                    public void focusLost(FocusEvent e) {
		                        e.getComponent().setBackground(Color.WHITE);
                    }
	};

	boolean mobval=false,fnameval=false,lnameval=false;
	String pass,conpass;
	JPanel top;
	JTextField userName,fname,lname,mobile;
	JPasswordField password,confirmPassword;
	JPanel bottom,center;
	JLabel labFName,labLName,labPassword,labConfirmPassword,labUserName,labMobile,labCountry,labBDay;
	JComboBox nation;
	 JComboBox month,day,year;
	JCheckBox checkBox;
	JButton button;
	public void createAndShowGUI()
	{
		//Text Fields
		top=new JPanel(new GridLayout(7,2));
		userName=new JTextField(32);
		password=new JPasswordField(32);
		fname=new JTextField(32);
		fname.addFocusListener(bg);
		lname=new JTextField(32);
		lname.addFocusListener(bg);
		confirmPassword=new JPasswordField(32);
		mobile=new JTextField(10);
		password.addFocusListener(bg);
		confirmPassword.addFocusListener(bg);
		mobile.addFocusListener(bg);
		userName.addFocusListener(bg);
		//Labels
		labFName=new JLabel("FirstName");
		labLName=new JLabel("LastName");
		labUserName=new JLabel("UserName");
		labPassword=new JLabel("Password");
		labConfirmPassword=new JLabel("ConfirmPassword");
		labMobile=new JLabel("MobileNumber");
		labCountry=new JLabel("Country");
		//Combo box
		nation=new JComboBox();
		nation.addItem("select");
			nation.addItem("Denmark");
				nation.addItem("France");
					nation.addItem("India");
						nation.addItem("USA");
		//Adding Component to top panel
		top.add(labFName);
		top.add(fname);
		top.add(labLName);
		top.add(lname);
		top.add(labUserName);
		top.add(userName);
		top.add(labPassword);
		top.add(password);
		top.add(labConfirmPassword);
		top.add(confirmPassword);
		top.add(labMobile);
		top.add(mobile);
		top.add(labCountry);
		top.add(nation);

		//center panel
		labBDay=new JLabel("Birthday");
		month=new JComboBox();
		month.addItem("January");
		month.addItem("February");
		month.addItem("March");
		month.addItem("April");
		month.addItem("May");
		month.addItem("June");
		month.addItem("July");
		month.addItem("August");
		month.addItem("September");
		month.addItem("October");
		month.addItem("November");
		month.addItem("December");
		day=new JComboBox();
		int i=1;
		for(i=1;i<32;i++)
		{
			day.addItem(i);
		}
		year=new JComboBox();
		int k=1901;
		while(k<1997)
		{
			year.addItem(k);
			k++;
		}
		center=new JPanel();
		center.add(labBDay);
		center.add(month);
		center.add(day);
		center.add(year);
		//craeting bottom panel
		checkBox=new JCheckBox("Agree Usage Terms");
		bottom=new JPanel(new GridLayout(1,2));
		bottom.add(checkBox);
		button=new JButton("Submit");
		button.addActionListener(this);
		bottom.add(button);
//creating frame

		add(top,BorderLayout.NORTH);
		add(center,BorderLayout.WEST);
		add(bottom,BorderLayout.SOUTH);
		setTitle("Registration Form");
		pack();
		setLocation(300,250);
		setVisible(true);


	}
	//Validation methods begin
	  public static boolean validateFirstName(String firstName)
	   {
	      return firstName.matches( "[A-Z][a-zA-Z]*" );
	   }

	   public static boolean validateLastName(String lastName)
	   {
	      return lastName.matches( "[A-z][a-zA-Z]*" );
   		}

   		public static boolean validateMobileNumber(String mobileNumber)
   		{
			return mobileNumber.matches("\\d{10}");
		}

		public static boolean validateUserName(String userName)
		{
			return userName.matches("[a-z]*@gmail.com");
		}

		public static boolean validatePassword(String password)
				{
					return password.matches("\\w{8}[a-zA-Z0-9]*");
				}

   //validation methods end



   ///Event Handler
	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource()==button)
		{

			if(validateMobileNumber(mobile.getText()) && validateFirstName(fname.getText()) && validateLastName(lname.getText()))// && validateUserName(userName.getText()))
				{
					JOptionPane jp=new JOptionPane();
					JOptionPane.showMessageDialog(null,"Welcome"+fname.getText(),"Registered SuccessFully",1);
				}
			else if(validateFirstName(fname.getText()) && validateLastName(lname.getText()))
				{
					JOptionPane.showMessageDialog(null,"Enter Valid Mobile Number","Registration failed",1);
					mobile.requestFocus();
					mobile.setText("");

				}


			else if(validateMobileNumber(mobile.getText()) && validateFirstName(fname.getText()))
				{
					JOptionPane.showMessageDialog(null,"Enter Valid Last Name","Registration failed",1);
					lname.requestFocus();
					lname.setText("");
				}

			else if(validateMobileNumber(mobile.getText()) &&validateLastName(lname.getText()))
				{
				JOptionPane.showMessageDialog(null,"Enter Valid First Name","Registration failed",1);
				fname.requestFocus();
					fname.setText("");
				}
			else if(validateMobileNumber(mobile.getText()))
				{
				JOptionPane.showMessageDialog(null,"Enter Valid First Name and Last Name","Registration failed",1);
				fname.requestFocus();
					fname.setText("");
					lname.setText("");
				}

			else if(validateFirstName(fname.getText()))
						{
							JOptionPane.showMessageDialog(null,"Enter Valid Last Name and Mobile Number","Registration failed",1);
							lname.requestFocus();
					lname.setText("");
					mobile.setText("");
						}
			else if(validateLastName(lname.getText()))
						{
							JOptionPane.showMessageDialog(null,"Enter Valid first Name and Mobile Number","Registration failed",1);
							fname.requestFocus();
							fname.setText("");
							mobile.setText("");
						}
			else
			{
				JOptionPane.showMessageDialog(null,"Please Enter Valid details","Registration failed",1);
				fname.requestFocus();
					fname.setText("");
				lname.setText("");
					mobile.setText("");
			}

	}
	}


	public static void main(String args[])
	{
			RegistrationForm rf=new RegistrationForm();
			rf.createAndShowGUI();
	}
}



