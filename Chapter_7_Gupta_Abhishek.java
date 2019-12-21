package jsp_azure_test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DataHandler  {
    
private Connection conn;

//Azure SQL connection credentials
	private String server = "userID-sql-server.database.windows.net";
	private String database = "my-sql-db";
	private String username = "userID";
	private String password = "password";

	// Resulting connection string
	final private String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", 
	server, database, username, password);

// Initialize and save the database connection
private void getDBConnection() throws SQLException 
{
	if (conn != null) {
		return; 
		}
	this.conn = DriverManager.getConnection(url); 
	}

	// Return the result of selecting everything from the movie_night table 
public ResultSet getAllcustomers() 
		throws SQLException 
{
	getDBConnection();
	final String sqlQuery = "SELECT * FROM Customer;";
	final PreparedStatement stmt = conn.prepareStatement(sqlQuery); 
	return stmt.executeQuery();
	}
	// Inserts a record into the movie_night table with the given attribute values 
public boolean add_new_customer(String name, String add, int categ) 
		throws SQLException 
		{
		getDBConnection(); 
		
		// Prepare the database connection
		
		
		// Prepare the SQL statement
				final String sqlQuery =
						"INSERT INTO Customer "
						+ "(name, add, categ) "
						+ "VALUES "
						+ "(?, ?, ?)";
				final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
		// Replace the '?' in the above statement with the given attribute values 
		stmt.setString(1, name);
		stmt.setString(2, add);
		stmt.setInt(3, categ);
		
		// Execute the query, if only one record is updated, then we indicate success by returning true
		return stmt.executeUpdate() == 1;
		}

	public ResultSet ret_customer_java(int categ1, int categ2) throws SQLException//Defining class for Procedure 1
	{
		
        getDBConnection(); 
		
		// Prepare the database connection
		
		
		// Prepare the SQL statement
				final String sqlQuery = "{ call ret_customer(?, ?) }";

				final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
         // Replace the '?' in the above statement with the given attribute values
			stmt.setInt(1, categ1);
			stmt.setInt(2, categ2);

               
                return stmt.executeQuery();


		}
    }
   




