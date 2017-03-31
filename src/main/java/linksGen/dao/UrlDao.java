package linksGen.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.Connection;

import linksGen.beans.Url;
import linksGen.beans.User;

public class UrlDao {
	
	public Connection getConnection()  throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver"); 
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/linksgen", "root", ""); 
		return connection;
	}
	
	public boolean addUrl(Url url) {
		boolean result = true;
		Connection connection = null;
		PreparedStatement  stmt = null;
		try {
			
			connection = getConnection();
			String sql = "INSERT INTO user (long_url, short_url, password, expire_date, max_use, id_user) VALUES (?,?,?,?,?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, url.getLongUrl());
			stmt.setString(2, url.getShortUrl());
			stmt.setString(3, url.getPassword());
			stmt.setDate(4, (url.getExpiredDate()!=null)?new java.sql.Date(url.getExpiredDate().getTime()):null);
			stmt.setInt(5, url.getMaxUse());
			stmt.setLong(6, url.getidUser());
			int nbRow = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(" Erreur fermeture : " + e.getMessage());
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
	
	
	public Url findUrlByShort(String shortUrl, User user) {
		Url url = null;
		Connection connection = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		try {
			
			connection = getConnection();
			String sql = "SELECT * FROM url WHERE short_url = ? ";
			if(user != null){
				sql += " AND id_user = ?";
			}
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, shortUrl);
			stmt.setLong(2, user.getId());
			rs =  stmt.executeQuery();
			if(rs.next()){
				url = new Url( rs.getLong("id"),
						rs.getString("long_url"),
						rs.getString("short_url"),
						rs.getString("password"),
						rs.getDate("expired_date"),
						rs.getInt("max_use"),
						rs.getLong("id_user"));
			}
		} catch (Exception e) {
			System.out.println(" Erreur fermeture : " + e.getMessage());
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
		return url;
	}


/*
	public boolean findListUrlByIP(Long id, User user) {
		boolean result = true;
		Connection connection = null;
		PreparedStatement  stmt = null;
		try {
			connection = getConnection();
			String sql = "UPDATE user SET civilite=?, nom=?, prenom=?, email=?, password=? WHERE id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getCivilite());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.setLong(6, id);
			int nbRow = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(" Erreur fermeture : " + e.getMessage());
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
	}*/
	

}
