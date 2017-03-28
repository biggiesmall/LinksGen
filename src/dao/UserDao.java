package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.Connection;

import beans.Url;
import beans.User;

public class UserDao {
	
	public Connection getConnection()  throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver"); 
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root"); 
		return connection;
	}
	
	public boolean addUser(User user) {
		boolean result = true;
		Connection connection = null;
		PreparedStatement  stmt = null;
		try {
			connection = getConnection();
			String sql = "INSERT INTO user (civilite, nom, prenom, email, password) VALUES (?,?,?,?,?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getCivilite());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			int nbRow = stmt.executeUpdate();
		} catch (Exception e) {
			result = false;
		}
		finally
		{
	        if (null != stmt) {
		        try
		        {
		            stmt.close();
		        }
		        catch (Exception e)
		        {
		            System.out.println(" Erreur fermeture : Stmt");
		        }
		    }
		     
		    if (null != connection) 
		    {
		        try
		        {
		            connection.close();
		        }
		        catch (Exception e)
		        {
		        	System.out.println(" Erreur fermeture : Connection");
		        }
		    }
		}
		return result;
	}
	
	
	public User findUserByLoginPassword(String login, String password) {
		Connection connection = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			
			connection = getConnection();
			String sql = "SELECT id, civilite, nom, prenom, email, password FROM users WHERE login = ? AND password = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, password);
			rs =  stmt.executeQuery();
			if(rs.next()){
				user = new User( rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						null);
			}
		} catch (Exception e) {
			user = null;
		}
		finally
		{
		    if (null != rs) 
		    {
		        try
		        {
		            rs.close();
		        }
		        catch (Exception e)
		        {
		        	System.out.println(" Erreur fermeture : RS");
		        }
		    }			
			if (null != stmt) {
		        try
		        {
		            stmt.close();
		        }
		        catch (Exception e)
		        {
		            System.out.println(" Erreur fermeture : Stmt");
		        }
		    }
		     
		    if (null != connection) 
		    {
		        try
		        {
		            connection.close();
		        }
		        catch (Exception e)
		        {
		        	System.out.println(" Erreur fermeture : Connection");
		        }
		    }
		}
		return user;
	}

}

/*

Connection connection = null;
Statement stmt = null;
ResultSet rs = null;
String mySql = "SELECT ...";  // Put your query here.
  
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
try
{
    // Arguments 2 and 3 are name and password if required
    connection = DriverManager.getConnection("jdbc:odbc:myDriver", "", "");
    stmt = connection.createStatement();
    rs = stmt.executeQuery(mySql);    
    while (rs.next()) {
    // do stuff with ResultSet
    }
} 
catch (SQLException sqle) 
{
    ...
} 
catch (Exception e) 
{
    ...
} 
finally
{
    if (null != rs) 
    {
        try
        {
            rs.close();
        }
        catch (Exception e)
        {
            ...
        }
        finally
        {
            rs = null;
        }
    }
     
    if (null != stmt) 
    {
        try
        {
            stmt.close();
        }
        catch (Exception e)
        {
            ...
        }
        finally
        {
            rs = null;
        }
    }
     
    if (null != connection) 
    {
        try
        {
            connection.close();
        }
        catch (Exception e)
        {
            ...
        }
        finally
        {
            rs = null;
        }
    }
}



...

//insertion d'un enregistrement dans la table client

requete = "INSERT INTO client VALUES (3,'client 3','prenom 3')";
try {
   Statement stmt = con.createStatement();
   int nbMaj = stmt.executeUpdate(requete);
   affiche("nb mise a jour = "+nbMaj);
} catch (SQLException e) {
   e.printStackTrace();
}

...
*/