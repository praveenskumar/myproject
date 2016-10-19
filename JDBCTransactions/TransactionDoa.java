import java.sql.*;

public class TransactionDoa
{

private Connection con=null;
public void hello()
{
	System.out.println("Hello");
}
	public TransactionDoa() throws SQLException,ClassNotFoundException
	{
		try
		{
			con=DBConnection.getConnection();
		}

		catch(SQLException exe)
		{
			throw exe;
		}
		catch(ClassNotFoundException exe)
				{
					throw exe;
		}

	}

	public int deposit(String accountNumber,int pin,float amount,String transactionType) throws SQLException
	{
		System.out.println(accountNumber+pin+amount+transactionType);
		int balAffected=0;
		int tranAffected=0;
		int status=1;
			try{
				PreparedStatement depositAccount=con.prepareStatement("update Account_Holder set Balance=Balance+? where AccountNumber=? and pin=?");
				PreparedStatement transactionSummary=con.prepareStatement("insert into Account_Holder_Transaction values(?,?,?,?)");

con.setAutoCommit(false);


				depositAccount.setFloat(1,amount);
				depositAccount.setString(2,accountNumber);
					depositAccount.setInt(3,pin);

					transactionSummary.setString(1,accountNumber);
					transactionSummary.setFloat(2,amount);
					transactionSummary.setDate(3,new Date(System.currentTimeMillis()));
					transactionSummary.setString(4,transactionType);
					balAffected=depositAccount.executeUpdate();
					System.out.println("RowAffected:"+balAffected);
					tranAffected=transactionSummary.executeUpdate();
				con.commit();
					if(balAffected==1 && tranAffected==1)
					{
						status=1;
					}
			}


			catch(SQLException exe)
			{
				throw exe;
			}
			System.out.println(status);
			return status;
		}

		public int withDraw(String accountNumber,int pin,float amount,String transactionType) throws SQLException
			{
				System.out.println(accountNumber+pin+amount+transactionType);
				int balAffected=0;
				int tranAffected=0;
				int status=1;
					try{
						PreparedStatement withDrawAccount=con.prepareStatement("update Account_Holder set Balance=Balance-? where AccountNumber=? and pin=?");
						PreparedStatement transactionSummary=con.prepareStatement("insert into Account_Holder_Transaction values(?,?,?,?)");


con.setAutoCommit(false);

					withDrawAccount.setFloat(1,amount);
						withDrawAccount.setString(2,accountNumber);
							withDrawAccount.setInt(3,pin);

							transactionSummary.setString(1,accountNumber);
							transactionSummary.setFloat(2,amount);
							transactionSummary.setDate(3,new Date(System.currentTimeMillis()));
							transactionSummary.setString(4,transactionType);
							balAffected=withDrawAccount.executeUpdate();
							System.out.println("RowAffected:"+balAffected);
							tranAffected=transactionSummary.executeUpdate();
						con.commit();
							if(balAffected==1 && tranAffected==1)
							{
								status=1;
							}
					}


					catch(SQLException exe)
					{
						throw exe;
					}
					System.out.println(status);
					return status;
				}




				public int transfer(String accountNumber,String payee,int pin,float amount,String transactionType) throws SQLException
							{
								int balAffected1=0;
								int balAffected2=0;
								int tranAffected1=0;
								int tranAffected2=0;
								String str1="TransDebit";
								String str2="TransCredit";
								int status=1;
									try{
										PreparedStatement payerAccount=con.prepareStatement("update Account_Holder set Balance=Balance-? where AccountNumber=? and pin=?");
										PreparedStatement ptransactionSummary=con.prepareStatement("insert into Account_Holder_Transaction values(?,?,?,?)");
										PreparedStatement receiverAccount=con.prepareStatement("update Account_Holder set Balance=Balance+? where AccountNumber=?");
										PreparedStatement rtransactionSummary=con.prepareStatement("insert into Account_Holder_Transaction values(?,?,?,?)");


										con.setAutoCommit(false);
										payerAccount.setFloat(1,amount);
										payerAccount.setString(2,accountNumber);
											payerAccount.setInt(3,pin);



											ptransactionSummary.setString(1,accountNumber);
											ptransactionSummary.setFloat(2,amount);
											ptransactionSummary.setDate(3,new Date(System.currentTimeMillis()));
											ptransactionSummary.setString(4,str1);
											receiverAccount.setFloat(1,amount);
											receiverAccount.setString(2,payee);

											rtransactionSummary.setString(1,payee);
											rtransactionSummary.setFloat(2,amount);
											rtransactionSummary.setDate(3,new Date(System.currentTimeMillis()));
											rtransactionSummary.setString(4,str2);

											balAffected1=payerAccount.executeUpdate();
											tranAffected1=ptransactionSummary.executeUpdate();
											balAffected2=receiverAccount.executeUpdate();
											tranAffected2=rtransactionSummary.executeUpdate();
										con.commit();
											if(balAffected1==1 && tranAffected1==1 && balAffected2==1 && tranAffected2==1 )
											{
												status=1;
											}
									}


									catch(SQLException exe)
									{
										throw exe;
									}
									return status;
				}


	}

























