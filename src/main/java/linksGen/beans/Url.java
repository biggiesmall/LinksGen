package linksGen.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the url database table.
 * 
 */
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date expiredDate;
	private String longUrl;
	private int maxUse;
	private String password;
	private String shortUrl;
	private Long  idUser;

	public Url() {
	}


	public Url(Long id, String longUrl, String shortUrl, String password, Date expiredDate, int maxUse, Long idUser) {
		super();
		this.id = id;
		this.expiredDate = expiredDate;
		this.longUrl = longUrl;
		this.maxUse = maxUse;
		this.password = password;
		this.shortUrl = shortUrl;
		this.idUser = idUser;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
	public Long getidUser() {
		return this.idUser;
	}

	public void setidUser(Long idUser) {
		this.idUser = idUser;
	}

}