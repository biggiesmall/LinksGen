package linksGen.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import linksGen.beans.Url;
import linksGen.beans.User;
import linksGen.beans.Visiteur;

public class VisiteurDao {
	
	public Connection getConnection()  throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver"); 
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/linksgen", "root", ""); 
		return connection;
	}
	
	public List<Visiteur> listVisitorByShort(String shortUrl) {
		Connection connection = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		List<Visiteur> listVisiteur = new ArrayList<Visiteur>();
		try {
			
			connection = getConnection();
			String sql = "SELECT * FROM visiteur, url WHERE visiteur.id_url = url.id AND url.short_url = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, shortUrl);
			rs =  stmt.executeQuery();
			while(rs.next()){
				listVisiteur.add( new Visiteur(rs.getLong("id"),
						rs.getString("browser"),
						rs.getString("country"),
						rs.getString("os"),
						rs.getDate("visite_date"),
						rs.getLong("id_url")));
			}
		} catch (Exception e) {
			System.out.println(" Erreur fermeture : " + e.getMessage());
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
		return listVisiteur;
	}

}
