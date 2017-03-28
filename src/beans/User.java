package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String civilite;
	private String email;
	private String nom;
	private String password;
	private String prenom;
	private List<Url> urls;

	public User() {
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCivilite() {
		return this.civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	//bi-directional many-to-one association to Url
	public List<Url> getUrls() {
		return this.urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Url addUrl(Url url) {
		getUrls().add(url);
		url.setUser(this);

		return url;
	}

	public Url removeUrl(Url url) {
		getUrls().remove(url);
		url.setUser(null);

		return url;
	}

}