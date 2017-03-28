package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the url database table.
 * 
 */
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date expiredDate;
	private String longUrl;
	private int maxUse;
	private String password;
	private String shortUrl;
	private User user;

	public Url() {
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}


	public String getLongUrl() {
		return this.longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}


	public int getMaxUse() {
		return this.maxUse;
	}

	public void setMaxUse(int maxUse) {
		this.maxUse = maxUse;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShortUrl() {
		return this.shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}


	//bi-directional many-to-one association to User
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}