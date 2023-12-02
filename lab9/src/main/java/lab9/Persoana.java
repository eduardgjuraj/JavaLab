package lab9;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class Persoana {
	/**
	 * 
	 */
	private String nume;
	private String prenume;
	private String zi;
	private String luna;
	private String an;
	private String adresa;
	private String telefon;
	
	public Persoana() {}
	
	public Persoana(String nume, String prenume, String zi, String luna, String an, String adresa, String telefon) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.zi = zi;
		this.luna = luna;
		this.an = an;
		this.adresa = adresa;
		this.telefon = telefon;
	}
	@Override
	public String toString() {
		 return "<tr>" +
	                "<td>" + nume + "</td>" +
	                "<td>" + prenume + "</td>" +
	                "<td>" + zi + "-"
	                + luna + "-"
	                + an + "</td>" +
	                "<td>" + adresa + "</td>" +
	                "<td>" + telefon + "</td>" +
	                "</tr>";
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getZi() {
		return zi;
	}
	public void setZi(String zi) {
		this.zi = zi;
	}
	public String getLuna() {
		return luna;
	}
	public void setLuna(String luna) {
		this.luna = luna;
	}
	public String getAn() {
		return an;
	}
	public void setAn(String an) {
		this.an = an;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	
}	
