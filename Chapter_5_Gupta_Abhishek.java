import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IP_chapter5_Gupta_Abhishek
{

//Defining class for Procedure  to enter a new customer details
	public static void new_customer(String c_name, String c_address, int category)
	{ 
        String query = "{ call new_customer(?, ?, ?) }"; //Calling procedure #1
        ResultSet rs;
        												// Connect to database
        final String hostName = "userID-sql-server.database.windows.net"; 
        final String dbName = "my-sql-db";
        final String user = "userID";
        final String password = "password";
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("query1: enter the new customer");
            try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
            											//Providing parameters to the procedure
            	stmt.setString(1, c_name);
            	stmt.setString(2, c_address);
            	stmt.setInt(3, category);
            	rs = stmt.executeQuery();				//Query execution
            	}
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            	}
            }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
        }
	
//Defining class for Procedure to enter new department 
	public static void new_department(int dept_no, String dept_data)
	{ 
        String query = "{ call new_department(?, ?) }"; //Calling procedure #1
        ResultSet rs;
        												// Connect to database
        final String hostName = "userID-sql-server.database.windows.net"; 
        final String dbName = "my-sql-db";
        final String user = "userID";
        final String password = "password";
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("query2: enter the new department");
            try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
            											//Providing parameters to the procedure
            	stmt.setInt(1, dept_no);
            	stmt.setString(2, dept_data);
            	rs = stmt.executeQuery();				//Query execution
            	}
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            	}
            }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
        }	

	
//Defining class for Procedure to enter new assembly
		public static void new_assembly(int assembly_id, String date_ordered, String assembly_details, String name)
		{ 
	        String query = "{ call new_assembly(?, ?,?,?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query3: enter the new assembly");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											//Providing parameters to the procedure
	            	stmt.setInt(1, assembly_id);
	            	stmt.setString(2, date_ordered);
	            	stmt.setString(3, assembly_details);
	            	stmt.setString(4, name);
	            	rs = stmt.executeQuery();				//Query execution
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }	
	
//Defining class for Procedure  to enter a new process
		public static void new_process(int process_id, String process_data, int dept_no)
		{ 
	        String query = "{ call new_process(?, ?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query4: enter the new process");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											//Providing parameters to the procedure
	            	stmt.setInt(1, process_id);
	            	stmt.setString(2, process_data);
	            	stmt.setInt(3, dept_no);
	            	rs = stmt.executeQuery();				//Query execution
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
			
//Defining class for Procedure to enter new account
		public static void new_account(int account_no, String date_ac_established)
		{ 
	        String query = "{ call new_account(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query5: enter the new account");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, account_no);
	            	stmt.setString(2, date_ac_established);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
		

//Defining class for Procedure to enter new process account
		public static void new_process_account(int account_no, float process_cost, int process_id)
		{ 
	        String query = "{ call new_process_account(?, ?, ?) }"; 
	        ResultSet rs;
	        										
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query5: enter the new process account, if any");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, account_no);
	            	stmt.setFloat(2, process_cost);
	            	stmt.setInt(3, process_id);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
		
//Defining class for Procedure to enter new assembly account
		public static void new_assembly_account(int account_no, float assembly_cost, int assembly_id)
		{ 
	        String query = "{ call new_assembly_account(?, ?, ?) }"; 
	        ResultSet rs;
	        										
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query5: enter the new assembly account, if any");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, account_no);
	            	stmt.setFloat(2, assembly_cost);
	            	stmt.setInt(3, assembly_id);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }		
		
//Defining class for Procedure to enter new department account
		public static void new_department_account(int account_no, float department_cost, int dept_no)
		{ 
	        String query = "{ call new_department_account(?, ?, ?) }"; 
	        ResultSet rs;
	        										
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query5: enter the new department account, if any");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, account_no);
	            	stmt.setFloat(2, department_cost);
	            	stmt.setInt(3, dept_no);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }			
		
		
//Defining class for Procedure to create a new job query 6
		public static void new_job(int new_job_no, String new_date_commenced, int new_assembly_id, int new_process_id)
		{ 
	        String query = "{ call new_job(?, ?,?,?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query6: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											//Providing parameters to the procedure
	            	stmt.setInt(1, new_job_no);
	            	stmt.setString(2, new_date_commenced);
	            	stmt.setInt(3, new_assembly_id);
	            	stmt.setInt(4, new_process_id);
	            	rs = stmt.executeQuery();				//Query execution
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }	

//Defining class for Procedure to create a new job query 7
		public static void completion_job(int job_no, String date_completed)
		{ 
	        String query = "{ call completion_job(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, job_no);
	            	stmt.setString(2, date_completed);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }		

//Defining class for Procedure to create a completed_cut_job query 7
		public static void completed_cut_job(int job_no, String machine_type,String time_machine_used,String material,float labor_time_cut )
		{ 
	        String query = "{ call completed_cut_job(?, ?,?,?,?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, job_no);
	            	stmt.setString(2, machine_type);
	            	stmt.setString(3, time_machine_used);
	            	stmt.setString(4, material);
	            	stmt.setFloat(5, labor_time_cut);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }	
	
//Defining class for Procedure to create a completed_paint_job query 7
		public static void completed_paint_job(int job_no, String color, float volume,float labor_time_paint )
		{ 
	        String query = "{ call completed_paint_job(?, ?,?,?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, job_no);
	            	stmt.setString(2, color);
	            	stmt.setFloat(3, volume);
	            	stmt.setFloat(4, labor_time_paint);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }	
				
//Defining class for Procedure to create a completed_paint_job query 7
		public static void completed_fit_job(int job_no, float labor_time_fit )
		{ 
	        String query = "{ call completed_fit_job(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, job_no);
	            	stmt.setFloat(2, labor_time_fit);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }		
	
//Defining class for Procedure to entry cost transaction 8
		public static void cost_transaction_entry(int transaction_no, float sup_cost, int transaction_job_no )
		{ 
	        String query = "{ call cost_transaction_entry(?, ?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, transaction_no);
	            	stmt.setFloat(2, sup_cost);
	            	stmt.setInt(3, transaction_job_no);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }			
		
//Defining class for Procedure to update process account of given cost transaction 8
		public static void update_process_ac(int tran_no, float process_sup_cost)
		{ 
	        String query = "{ call update_process_ac(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, tran_no);
	            	stmt.setFloat(2, process_sup_cost);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }	
		
//Defining class for Procedure to update assembly account of given cost transaction 8
		public static void update_assembly_ac(int tran_no, float assembly_sup_cost)
		{ 
	        String query = "{ call update_assembly_ac(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, tran_no);
	            	stmt.setFloat(2, assembly_sup_cost);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }		
		
//Defining class for Procedure to update department account of given cost transaction 8
		public static void update_dept_ac(int tran_no, float dept_sup_cost)
		{ 
	        String query = "{ call update_dept_ac(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	//System.out.println("query7: enter the new job");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, tran_no);
	            	stmt.setFloat(2, dept_sup_cost);
	            	rs = stmt.executeQuery();				
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }			
		
//Defining class for Procedure retrieve cost incurred on assembly id query 9
		public static void ret_assembly_cost(int ret_assembly_id)
		{ 
	        String query = "{ call ret_assembly_cost(?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, ret_assembly_id);
	            	rs = stmt.executeQuery();	
	            	while (rs.next()) {			//Displaying table from SQL database
	                    System.out.println(String.format("%f",
	                                  rs.getFloat(1)));
	                 }
	            	     	
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
		
//Defining class for Procedure retrieve total labor time query 10
		public static void tot_labor_time(int dept_num, String start_compl_date, String end_compl_date)
		{ 
	        String query = "{ call tot_labor_time(?,?,?) }"; 
	        ResultSet rs;

	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, dept_num);
	            	stmt.setString(2, start_compl_date);
	            	stmt.setString(3, end_compl_date);
	            	rs = stmt.executeQuery();	
	            	while (rs.next()) {			//Displaying table from SQL database
	                    System.out.println(String.format("%f",
	                                  rs.getFloat(1)));
	                 }
	            	     	
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }

//Defining class for Procedure retrieve process and department for query 11
		public static void ret_process(int assembly_id_process)
		{ 
	        String query = "{ call ret_process(?) }"; 
	        ResultSet rs;

	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, assembly_id_process);
	            	rs = stmt.executeQuery();
	            	while (rs.next()) {			//Displaying table from SQL database
	                    System.out.println(String.format("%d",
	                                  rs.getInt(1)));
	                 }
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
				
//Defining class for Procedure to retrieve jobs as per query 12
		public static void ret_jobs(String start_comp_date, String end_comp_date, int deptartment_no)
		{ 
	        String query = "{ call ret_jobs(?, ?, ?) }"; 
	        ResultSet rs;
	        										
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setString(1, start_comp_date);
	            	stmt.setString(2, end_comp_date);
	            	stmt.setInt(3, deptartment_no);
	            	rs = stmt.executeQuery();	
	            	while (rs.next()) {			//Displaying table from SQL database
	                    System.out.println(String.format("%d",
	                                  rs.getInt(1)));
	                 }
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }			
		
		
//Defining class for Procedure retrieve customer as per query 13
		public static void ret_customer(int start_cat, int end_cat)
		{ 
	        String query = "{ call ret_customer(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query13: enter the start and end category to retrieve customer");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, start_cat);
	            	stmt.setInt(2, end_cat);
	            	rs = stmt.executeQuery();	
	            	
            	while (rs.next()) {			//Displaying table from SQL database
                    System.out.println(String.format("%s",
                                  rs.getString(1)));
                 }
	            	
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
				
//Defining class for Procedure to delete cut jobs as per query 14
		public static void delete_cut_jobs(int start_job_no, int end_job_no)
		{ 
	        String query = "{ call delete_cut_jobs(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query14: enter the start and end job no to delete cut jobs");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, start_job_no);
	            	stmt.setInt(2, end_job_no);
	            	rs = stmt.executeQuery();	
	            	
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }				
				
//Defining class for Procedure to change color as per query 15
		public static void change_color(String color, int col_job_no)
		{ 
	        String query = "{ call change_color(?, ?) }";
	        ResultSet rs;
	        												
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query15: enter the color and end job no to change color");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setString(1, color);
	            	stmt.setInt(2, col_job_no);
	            	rs = stmt.executeQuery();	
	            	
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }		
	
		
//Defining class for Procedure retrieve customer and export to text file as per query 17
		public static void export_customer(int start_cat, int end_cat) throws IOException
		{ 
	        String query = "{ call ret_customer(?, ?) }"; //Calling procedure #1
	        ResultSet rs;
	        												// Connect to database
	        final String hostName = "userID-sql-server.database.windows.net"; 
	        final String dbName = "my-sql-db";
	        final String user = "userID";
	        final String password = "password";
	        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	        try 
	        (final Connection connection = DriverManager.getConnection(url)) 
	        {
	        	final String schema = connection.getSchema(); 
	        	System.out.println("Successful connection - Schema:" + schema); 
	        	System.out.println("query13: enter the start and end category to retrieve customer");
	            try
	            (final Connection conn = DriverManager.getConnection(url);
	            		CallableStatement stmt = conn.prepareCall(query))
	            {
	            											
	            	stmt.setInt(1, start_cat);
	            	stmt.setInt(2, end_cat);
	            	rs = stmt.executeQuery();	
	            	
	            	FileWriter fstream = new FileWriter("C:\\Users\\abhig\\Desktop\\DBMS\\Individual project\\exportFile.txt");
	            	BufferedWriter out = new BufferedWriter(fstream);
	            	while (rs.next()) {            
	            	        out.write((rs.getString(1)) + ", ");
	            	        out.newLine();
	            	}
	            	System.out.println("Completed writing into text file");
	            	out.close();
	            	
	            	}
	            catch (SQLException ex)
	            {
	            	System.out.println(ex.getMessage());
	            	}
	            }
	        catch (SQLException e)
	        {
				throw new RuntimeException(e);
			}
	        }
				
	public static void main(String[] args) throws IOException
	{
		String nl = System.getProperty("line.separator");	//Defining line separator 
		System.out.println("1. Insert new customer by selecting option 1" + nl +
				"2. Insert new department by selecting option 2" + nl +
				"3. Insert new assembly by selecting option 3" + nl +
				"4. Insert new process details by selecting option 4" + nl +
				"5. Insert new account details by selecting option 5" + nl +
				"6. Insert new job option 6" + nl +
				"7. Insert the job completion details option 7" + nl +
				"8. Update all the sup cost option 8" + nl +
				"9. Retrieve cost incurred in assembly ID option 9" + nl +
				"10.Retrieve total labor time option 10" + nl +
				"11.Retrieve process through which assembly id has passed option 11" + nl +
				"12.Retrieve job no between completion date option 12" + nl +
				"13.Retrieve customer name between category option 13" + nl +
				"14.Delete cut jobs between jo no. option 14" + nl +
				"15.Update color for given jo no. option 15" + nl +
				"17.Export the customer name by option 17" + nl 
				+ "18. Exit");
		
		while (true)
		{
			System.out.println("Please Enter Option Number: ");//Obtaining user input for option
			Scanner user_input = new Scanner(System.in);
			int option = user_input.nextInt();

			if (option == 1)
			{
				System.out.println("Enter New Customer's name: ");//Performer ID input by user
				String c_name = user_input.next();
				
				System.out.println("Enter New customer's address: ");//Performer age input by user
				String c_address = user_input.next();
				
				System.out.println("Enter New customer's category: ");//Performer name input by user
				int category = user_input.nextInt();
				
				new_customer(c_name, c_address, category);//Providing input to procedure 1
			}
			
			else if (option == 2)
			{
				System.out.println("Enter New Department's number: ");
				int dept_no = user_input.nextInt();
				
				System.out.println("Enter New department's data: ");
				String dept_data = user_input.next();
				new_department(dept_no, dept_data);
			}
			
			else if (option == 3)
			{
				System.out.println("Enter New assembly ID: ");
				int assembly_id = user_input.nextInt();
				
				System.out.println("Enter date ordered for assembly: ");
				String date_ordered = user_input.next();
				
				System.out.println("Enter assembly details: ");
				String assembly_details = user_input.next();
				
				System.out.println("Enter customer name who ordered assembly : ");
				String name = user_input.next();
				
				new_assembly(assembly_id, date_ordered, assembly_details, name);
			}
			
			else if (option == 4)
			{
				System.out.println("Enter new process id: ");
				int process_id = user_input.nextInt();
				
				System.out.println("Enter the process data: ");
				String process_data = user_input.next();
				
				System.out.println("Enter the departemnt no for this process: ");
				int dept_no = user_input.nextInt();
				
				new_process(process_id, process_data, dept_no);//Providing input to procedure 1
			}
			
			else if (option == 5)
			{
				System.out.println("Enter the account no: ");
				int account_no = user_input.nextInt();
				
				System.out.println("Enter the date established: ");
				String date_ac_established = user_input.next();

				new_account(account_no, date_ac_established);
				
				System.out.println("Enter the type account related to (process1, assembly2 or dept3: 1, 2, 3? ");
				int ac_type = user_input.nextInt();
				
				if (ac_type == 1)
				{
						System.out.println("Enter the process cost: ");
						float process_cost = user_input.nextFloat();
						
						System.out.println("Enter the process id: ");
						int process_id = user_input.nextInt();
						
						new_process_account(account_no, process_cost, process_id);
				}
				
				if (ac_type == 2)
				{
						System.out.println("Enter the assembly cost: ");
						float assembly_cost = user_input.nextFloat();
						
						System.out.println("Enter the assembly id: ");
						int assembly_id = user_input.nextInt();
						
						new_assembly_account(account_no, assembly_cost, assembly_id);
				}
				
				if (ac_type == 3)
				{
						System.out.println("Enter the department cost: ");
						float department_cost = user_input.nextFloat();
						
						System.out.println("Enter the department number: ");
						int dept_no = user_input.nextInt();
						
						new_department_account(account_no, department_cost, dept_no);
				}
				

			}
			
			else if (option == 6)
			{
				System.out.println("Enter New job number: ");
				int new_job_no = user_input.nextInt();
				
				System.out.println("Enter date commenced: ");
				String new_date_commenced = user_input.next();
				
				System.out.println("Enter assembly id: ");
				int new_assembly_id = user_input.nextInt();
				
				System.out.println("Enter process id: ");
				int new_process_id = user_input.nextInt();
				
				new_job(new_job_no, new_date_commenced, new_assembly_id, new_process_id);
			}
			
			else if (option == 7)
			{
				System.out.println("Enter the job no: ");
				int job_no = user_input.nextInt();
				
				System.out.println("Enter the date completed: ");
				String date_completed = user_input.next();

				completion_job(job_no, date_completed);
				
				System.out.println("Enter the type of job (cut1, paint2 or fit3: 1, 2, 3? ");
				int job_type = user_input.nextInt();
				
				if (job_type == 1)
				{
						System.out.println("Enter the machine type: ");
						String machine_type = user_input.next();
						System.out.println("Enter the time machine used: ");
						String time_machine_used = user_input.next();
						System.out.println("Enter the material used: ");
						String material = user_input.next();
						System.out.println("Enter the labor time cut: ");
						float labor_time_cut = user_input.nextFloat();
						
						completed_cut_job(job_no, machine_type, time_machine_used, material, labor_time_cut);
				}
				
				if (job_type == 2)
				{
						System.out.println("Enter the color: ");
						String color = user_input.next();
						System.out.println("Enter the volume used: ");
						float volume = user_input.nextFloat();
						System.out.println("Enter the labor time paint: ");
						float labor_time_paint = user_input.nextFloat();
						
						completed_paint_job(job_no, color, volume, labor_time_paint);
				}
				
				if (job_type == 3)
				{
						System.out.println("Enter the labor time fit: ");
						float labor_time_fit = user_input.nextFloat();
						
						completed_fit_job(job_no, labor_time_fit);
				}
				

			}
			
			else if (option == 8)
			{
				System.out.println("Enter the transaction no: ");
				int transaction_no = user_input.nextInt();
				
				System.out.println("Enter the sup cost: ");
				Float sup_cost = user_input.nextFloat();
				
				System.out.println("Enter the transaction job no: ");
				int transaction_job_no = user_input.nextInt();
				
				System.out.println("Enter the process sup cost: ");
				Float process_sup_cost = user_input.nextFloat();
				
				System.out.println("Enter the assembly sup cost: ");
				Float assembly_sup_cost = user_input.nextFloat();
				
				System.out.println("Enter the department sup cost: ");
				Float dept_sup_cost = user_input.nextFloat();
				
				cost_transaction_entry(transaction_no, sup_cost, transaction_job_no);
				update_assembly_ac(transaction_no, assembly_sup_cost);
				update_process_ac(transaction_no, process_sup_cost);
				update_dept_ac(transaction_no, dept_sup_cost);
			}
			
			else if (option == 9)
			{
				System.out.println("Enter assembly id: ");
				int ret_assembly_id = user_input.nextInt();				
				ret_assembly_cost(ret_assembly_id);
			}
			
			else if (option == 10)
			{
				System.out.println("Enter dept_no: ");
				int dept_num = user_input.nextInt();	
				
				System.out.println("Enter start of job completion date: ");
				String start_compl_date = user_input.next();
				
				System.out.println("Enter end of job completion date: ");
				String end_compl_date = user_input.next();
				
				tot_labor_time(dept_num, start_compl_date, end_compl_date);
			}
			
			else if (option == 11)
			{
				System.out.println("Enter assembly id: ");
				int assembly_id_process = user_input.nextInt();
				ret_process(assembly_id_process);
			}
			
			else if (option == 12)
			{
				System.out.println("Enter start of job completion date: ");
				String start_comp_date = user_input.next();
				
				System.out.println("Enter end of job completion date: ");
				String end_comp_date = user_input.next();
				
				System.out.println("Enter dept_no: ");
				int department_no = user_input.nextInt();	
				
				ret_jobs(start_comp_date, end_comp_date, department_no);
			}
			
			else if (option == 13)
			{
				System.out.println("Enter start category: ");
				int start_cat = user_input.nextInt();
				
				System.out.println("Enter end category: ");
				int end_cat = user_input.nextInt();
				
				ret_customer(start_cat, end_cat);
			}
			
			else if (option == 14)
			{
				System.out.println("Enter start job no.: ");
				int start_job_no = user_input.nextInt();
				
				System.out.println("Enter end job no.: ");
				int end_job_no = user_input.nextInt();
				
				delete_cut_jobs(start_job_no, end_job_no);
			}
			
			else if (option == 15)
			{
				System.out.println("Enter new color: ");
				String color = user_input.next();
				
				System.out.println("Enter job no.: ");
				int col_job_no = user_input.nextInt();
				
				change_color(color, col_job_no);
			}
			
			else if (option == 17)
			{
				System.out.println("Enter start category: ");
				int start_cat = user_input.nextInt();
				
				System.out.println("Enter end category: ");
				int end_cat = user_input.nextInt();
				
				export_customer(start_cat, end_cat);
			}
			
			else if (option == 18)
			{
				System.out.println("Quit option successfully exeuted");
				System.exit(0);//Breaking while loop
			}
		}
		
    }
}

	