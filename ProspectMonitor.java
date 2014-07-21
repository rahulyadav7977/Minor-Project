import java.sql.*;
import java.util.Scanner;
import static java.lang.System.*;
import java.io.Console;

class ProspectMonitor 
	{
		String prospectid, name, address, model, color,hotness;
 		long phone;
 		Scanner scn=new Scanner(System.in);
		ProspectMonitor pm=new ProspectMonitor();
		public void choice()
			{
				out.println("\nChoose:\n"+
							"\t1. Add Prospect\n"+
							"\t2. Update Phone number\n"+
							"\t3. Update Hotness\n"+
							"\t4. Update Color\n"+
							"\t5. View Prospects\n"+
							"\t6. Log Out");
				
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							try	
							{
								pm.AddNewProspect();
							}
							catch (Exception e)
							{}
							break;
						case 2:
							try
							{
								pm.UpdatePhone();
							}
							catch (Exception e)
							{}
							break;
						case 3:
							try
							{
								pm.UpdateHotness();
							}
							catch (Exception e)
							{}
							break;
						case 4:
							try
							{
								pm.UpdateColor();
							}
							catch (Exception e)
							{}
							break;
						case 5:
							try
							{
								pm.ViewProspects();
							}
							catch (Exception e)
							{}
							break;
						case 6:
							AutomobileTest t1= new AutomobileTest();
							try
							{
								t1.login();
							}
							catch (Exception e)
							{}
							break;
						default:
							out.println("Wrong choice");
							choice();
							break;
					}
			}

		 public void AddNewProspect() throws Exception
  			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
				Statement stmt=con.createStatement();
   
   				System.out.println("Enter ProspectID:");
   				prospectid=scn.next();
   				System.out.println("Enter Name:");
				name=scn.next();
				System.out.println("Enter Phone No:");
				phone=scn.nextLong();
				System.out.println("Enter Address:");
				address=scn.next();
				System.out.println("Enter Selected Model:");
				model=scn.next();
				System.out.println("Enter Color:");
				color=scn.next();
				System.out.println("Enter Hotness:");
   				hotness=scn.next();
 
   				stmt.executeUpdate("insert into prospect values ('"+prospectid+"','"+name+"',"+phone+",'"+address+"','"+model+"','"+color+"','"+hotness+"')");
  
   				System.out.println("Record Entered Succesfully!");
				out.println("\nPress\n"+
							"\t1 to add new\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							AddNewProspect();
							break;
						case 2:
							pm.choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							pm.choice();
							break;
					}	
  			}
 
 		void UpdatePhone() throws Exception
  			{
				Class.forName("com.mysql.jdbc.Driver");
   				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
   				Statement stmt=con.createStatement();

   				System.out.println("Enter the id for which the phone needs to be changed:");
   				prospectid=scn.next();
   				System.out.println("Enter the new phone number:");
   				phone=scn.nextInt();
   
   				stmt.executeUpdate("update prospect set phone = "+phone+" where prospect_id='"+prospectid+" ' ");
   				System.out.println("Phone no updated successfully!!");
				out.println("\nPress\n"+
							"\t1 to update another\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							UpdatePhone();
							break;
						case 2:
							pm.choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							pm.choice();
							break;
					}	
  			}
  

 		void UpdateHotness() throws Exception
  			{
				Class.forName("com.mysql.jdbc.Driver");
   				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
   				Statement stmt=con.createStatement();

   				System.out.println("Enter the id for which the hotness needs to be changed:");
   				prospectid=scn.next();
   				System.out.println("Enter the new hotness:"); 
   				hotness=scn.next();
  
   				stmt.executeUpdate("update prospect set hotness='"+hotness+"' where prospect_id='"+prospectid+" ' ");
   				System.out.println("Hotness updated successfully!!");
				out.println("\nPress\n"+
							"\t1 to update another\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							UpdateHotness();
							break;
						case 2:
							pm.choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							pm.choice();
							break;
					}	
  			}
   
 		void UpdateColor() throws Exception
  			{
				Class.forName("com.mysql.jdbc.Driver");
   				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
   				Statement stmt=con.createStatement();

   				System.out.println("Enter the id for which the color needs to be changed:");
   				prospectid=scn.next();
   				System.out.println("Enter the new color:"); 
   				color=scn.next();
  
   				stmt.executeUpdate("update prospect set selected_color='"+color+"' where prospect_id='"+prospectid+" ' ");
   				System.out.println("Color updated successfully!!");
				out.println("\nPress\n"+
							"\t1 to update another\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							UpdateColor();
							break;
						case 2:
							pm.choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							pm.choice();
							break;
					}	
  			}

 		void ViewProspects() throws Exception
  			{
				Class.forName("com.mysql.jdbc.Driver");
   				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
  	 			Statement stmt=con.createStatement();

   				ResultSet rs=stmt.executeQuery("SELECT * FROM prospect");
  
  
   				while(rs.next())
   					{
						System.out.println(rs.getString("prospect_id"));
    						System.out.println(rs.getString("pname"));
    						System.out.println(rs.getString("phone"));
    						System.out.println(rs.getString("address"));
    						System.out.println(rs.getString("selected_model"));
    						System.out.println(rs.getString("selected_color"));
    						System.out.println(rs.getString("hotness"));
						System.out.println();System.out.println();
       
    					}
				out.println("\nPress\n"+
							"\t1 to go back to main menu\n"+
							"\t2 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						
						case 1:
							pm.choice();
							break;
						case 2:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							pm.choice();
							break;
					}	
  			}

}


class Administrator
	{
		Administrator ad=new Administrator();
		Scanner scn=new Scanner(System.in);
		ProspectMonitor pm=new ProspectMonitor();
		void ad_choice() throws Exception
			{
				out.println("\nChoose:\n"+
							"\t1. Create Monitor\n"+
							"\t2. View Monitor\n"+
							"\t3. View Prospects\n"+
							"\t4. Search Prospects\n"+
							"\t5. Delete Prospects\n"+
							"\t6. Change Password\n"+
							"\t7. Log Out");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							ad.createnewmonitor();
							break;
						case 2:
							ad.viewmonitor();
							break;
						case 3:
							ad.viewprospects();
							break;
						case 4:
							ad.SearchProspect();
							break;
						case 5:
							ad.DeleteProspect();
							break;
						case 6:
							ad.ChangePassword();
							break;
						case 7:
							AutomobileTest t1= new AutomobileTest();
							t1.login();
							break;
						default:
							out.println("Wrong choice");
							ad_choice();
							break;
					}
			}
		void createnewmonitor() throws Exception
 			{
				Class.forName("com.mysql.jdbc.Driver");
  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
  				Statement stmt=con.createStatement();
  				Scanner scn=new Scanner(System.in);
  
  				String loginid, password, name, role;
  				long phone;
  
  				System.out.println("Enter Monitor ID:");
  				loginid=scn.next();
 	 			System.out.println("Enter password:");
  				password=scn.next();
  				System.out.println("Enter Monitor Name:");
  				name=scn.next();
  				System.out.println("Enter phone no:");
  				phone=scn.nextLong();
  
  				stmt.executeQuery("insert into prospect values('"+loginid+"','"+password+"','"+name+"',"+phone+",'monitor'");
				out.println("Successfuly Created\n");
				out.println("\nPress\n"+
							"\t1 to add new\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							createnewmonitor();
							break;
						case 2:
							ad.ad_choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							ad.ad_choice();
							break;
					}	
  			}
 
 		void viewmonitor() throws Exception
 			{
				Class.forName("com.mysql.jdbc.Driver");
  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
				Statement stmt=con.createStatement();

  				ResultSet rs=stmt.executeQuery("SELECT * FROM login where role='monitor'");
 
  				while(rs.next())
   					{
						System.out.println(rs.getString("login_id"));
    						System.out.println(rs.getString("password"));
    						System.out.println(rs.getString("name"));
    						System.out.println(rs.getString("phone"));
    						System.out.println(rs.getString("role"));
    						System.out.println();System.out.println();
   					}
				out.println("\nPress\n"+
							"\t1 to go back to main menu\n"+
							"\t2 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							ad.ad_choice();
							break;
						case 2:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							ad.ad_choice();
							break;
					}
 			}

 		void viewprospects() throws Exception
 			{
				ProspectMonitor ob=new ProspectMonitor(); 
  				ob.ViewProspects();
				out.println("\nPress\n"+
							"\t1 to go back to main menu\n"+
							"\t2 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							ad.ad_choice();
							break;
						case 2:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							ad.ad_choice();
							break;
					}
 			}
 
 		void SearchProspect() throws Exception
 			{
				Class.forName("com.mysql.jdbc.Driver");
  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
  				Statement stmt=con.createStatement();
  				Scanner scn=new Scanner(System.in);
  				int ch;

  				System.out.println("How would you like to search prospect?");
  				System.out.println("1.By Name\n2.By Hotness");
  				System.out.println("Enter choice (1/2):");
  				ch=scn.nextInt();
  				if(ch==1)
    					{
						System.out.println("\n\nEnter name:");
     						String name=scn.next();
     						ResultSet rs=stmt.executeQuery("Select * from prospect where pname='"+name+"'");
     						while(rs.next())
     							{
								System.out.println(rs.getString("prospect_id"));
      								System.out.println(rs.getString("pname"));
      								System.out.println(rs.getString("phone"));
      								System.out.println(rs.getString("address"));
      								System.out.println(rs.getString("selected_model"));
      								System.out.println(rs.getString("selected_color"));
      								System.out.println(rs.getString("hotness"));
      								System.out.println();System.out.println();
     							}
    					}
  
  				if(ch==2)
    					{
						System.out.println("\n\nEnter hotness:");
     						String hotness=scn.next();
     						ResultSet rs=stmt.executeQuery("Select * from prosect where hotness='"+hotness+"'");
     						while(rs.next())
     							{
								System.out.println(rs.getString("prospect_id"));
      								System.out.println(rs.getString("pname"));
      								System.out.println(rs.getString("phone"));
      								System.out.println(rs.getString("address"));
      								System.out.println(rs.getString("selected_model"));
      								System.out.println(rs.getString("selected_color"));
      								System.out.println(rs.getString("hotness"));
      								System.out.println();System.out.println();
     							}
    					}
 
  				else
  					{
						System.out.println("Invalid Choice!");
						SearchProspect();
  					}
				out.println("\nPress\n"+
							"\t1 to Search new\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch1=scn.nextInt();
				switch(ch1)
					{
						case 1:
							SearchProspect();
							break;
						case 2:
							ad.ad_choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch2=scn.next(".").charAt(0);
							if(ch2=='Y'|| ch2=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch2=='n'||ch2=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							ad.ad_choice();
							break;
					}	
 			}

 		void DeleteProspect() throws Exception
 			{
				Class.forName("com.mysql.jdbc.Driver");
  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
  				Statement stmt=con.createStatement();

  				Scanner scn=new Scanner(System.in);
 
  				try 
					{
						System.out.println("Enter the ProspectID:");
       						String pid=scn.next();
  						stmt.executeQuery("delete from prospect where prospect_id='"+pid+"'");
      					}
  				catch(Exception e)
					{
						System.err.println("Invalid ID!");

 					}
				out.println("\nPress\n"+
							"\t1 to delete another\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch=scn.nextInt();
				switch(ch)
					{
						case 1:
							DeleteProspect();
							break;
						case 2:
							ad.ad_choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch1=scn.next(".").charAt(0);
							if(ch1=='Y'|| ch1=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch1=='n'||ch1=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							ad.ad_choice();
							break;
					}	

				
			}

 		void ChangePassword() throws Exception
 			{
				Class.forName("com.mysql.jdbc.Driver");
  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
  				Statement stmt=con.createStatement();

  				Scanner scn=new Scanner(System.in);

  				System.out.println("Whose password you want to change:");
  				System.out.println("1.Self");
  				System.out.println("2.Monitor");
  				System.out.println("Enter choice (1/2):"); 
  				int ch=scn.nextInt();
  
  				if(ch==1)
    					{
						System.out.println("Enter new password:");
     						String pass=scn.next();
     						stmt.executeUpdate("update login set password='"+pass+"' where role='admin'"); 
     						System.out.println("Password Change Successful!");
    					}    
  
  				if(ch==2)
    					{
						System.out.println("Enter MonitorID for which you want to change the passord:");
     						String id=scn.next();
     						System.out.println("Enter new password:");
     						String pass=scn.next();
     						stmt.executeQuery("update login set password='"+pass+"' where login_id='"+id+"'");
     						System.out.println("Password Change Successful!");
    					}
  
  				else
    					{
						System.out.println("Invalid Choice!");
    					}
				out.println("\nPress\n"+
							"\t1 to Change another\n"+
							"\t2 to go back to main menu\n"+
							"\t3 to exit\n");
				int ch1=scn.nextInt();
				switch(ch1)
					{
						case 1:
							ChangePassword();
							break;
						case 2:
							ad.ad_choice();
							break;
						case 3:
							out.println("Are you sure you want to exit? (Y/N)");
							char ch2=scn.next(".").charAt(0);
							if(ch2=='Y'|| ch2=='y')
								{
									out.println("BYE! LIVE LONG AND PROSPER!");
									System.exit(1);
								}
							else if(ch2=='n'||ch2=='N')
								{
									pm.choice();
								}
							else
								{
									out.println("INVALID CHOICE");
									pm.choice();
								}
						default:
							out.println("INVALID CHOICE");
							ad.ad_choice();
							break;
					}
 			}

	}


class AutomobileTest
	{
		
		Scanner scn=new Scanner(System.in);
		String id1;
		String role;
		String name;
		


		public String login() throws Exception
			{
				out.println("Choose:->\n"+
							"\t1:Admin\n"+
							"\t2:Monitor\n");
				Class.forName("com.mysql.jdbc.Driver");
  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/automobile","root","123");
				Statement stmt=con.createStatement();
				int choice=scn.nextInt();		
				switch(choice)
					{ 
						case 1:
							out.println("Enter login id");
							id1=scn.next();
							out.println("Enter password");
							Console co=System.console();
							String p2=new String(co.readPassword());
							
							ResultSet status=stmt.executeQuery("select name from login where login_id='"+id1+"' AND password='"+p2+"' AND role='admin'");
							if(!status.next())
								{
									out.println("NO MATCH FOUND\tTRY AGAIN");
									login();
								}
							else	
								{
									
									out.println("------******Login Successful******------");
									ResultSet rs=stmt.executeQuery("select name from login where login_id='"+id1+"' AND password='"+p2+"' AND role='admin'");
									name=rs.getString("name");
									out.println("\n\t\tWelcome:"+name);
									role=rs.getString("role");
									return(role);
								}
							break;
						case 2:
							out.println("Enter login id");
							id1=scn.next();
							out.println("Enter password");
							Console co1=System.console();
							p2=new String(co1.readPassword());
							ResultSet status1=stmt.executeQuery("select name from login where (login_id='"+id1+"' AND password='"+p2+"' AND role='monitor'");			
							if(!status1.next())
								{
									out.println("NO MATCH FOUND\tTRY AGAIN");
									login();
								}
							else	
								{
									
									out.println("------******Login Successful******------");
									ResultSet rs=stmt.executeQuery("select name from login where login_id='"+id1+"' AND password='"+p2+"' AND role='monitor'");
									name=rs.getString("name");
									out.println("\n\t\tWelcome:"+name);
									role=rs.getString("role");
									return(role);
								}
							break;
						default:
							out.println("Wrong choice");
							out.println("Enter again");
							login();
					}
				return("NULL");

		}

	
	public static void main(String ... args) throws Exception
  		{
			AutomobileTest t= new AutomobileTest();
			String st=t.login();
			if(st.equals("admin"))
				{
					Administrator a=new Administrator();
					a.ad_choice();
				}
			else
				{
					ProspectMonitor p=new ProspectMonitor();
					p.choice();
				}
		}
}
			
			
	
	
	
   