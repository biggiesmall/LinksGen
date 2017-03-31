package linksGen.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the visiteur database table.
 * 
 */
public class Visiteur implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String browser;
	private String country;
	private String os;
	private Date visiteDate;
	private Long idUrl;

	public Visiteur() {
	}


	public Visiteur(Long id, String browser, String country, String os, Date visiteDate, Long idUrl) {
		super();
		this.id = id;
		this.browser = browser;
		this.country = country;
		this.os = os;
		this.visiteDate = visiteDate;
		this.idUrl = idUrl;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Date getVisiteDate() {
		return this.visiteDate;
	}

	public void setVisiteDate(Date visiteDate) {
		this.visiteDate = visiteDate;
	}


	public Long getIdUrl() {
		return idUrl;
	}


	public void setIdUrl(Long idUrl) {
		this.idUrl = idUrl;
	}

}