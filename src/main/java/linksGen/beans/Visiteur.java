package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the visiteur database table.
 * 
 */
public class Visiteur implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String browser;
	private String country;
	private String os;
	private Date visiteDate;

	public Visiteur() {
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

}