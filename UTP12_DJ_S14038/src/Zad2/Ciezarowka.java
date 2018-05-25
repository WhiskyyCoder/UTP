package Zad2;

public class Ciezarowka extends Pojazd {
public int ladownosc;
private int iloscnaczep;
private String nazwa;
	public Ciezarowka(String marka, String kolor) {
		super(marka, kolor);
		// TODO Auto-generated constructor stub
	}
	public Ciezarowka(String marka, String kolor,int lad) {
		super(marka, kolor);
		this.ladownosc=lad;
		// TODO Auto-generated constructor stub
	}
	public Ciezarowka(String nazwa) {
		super("Volvo", "Czarny");
		this.nazwa=nazwa;
		
		// TODO Auto-generated constructor stub
	}
	public String getNazwa() {
		return nazwa;
	}
public void setIloscnaczep(int iloscnaczep) {
	this.iloscnaczep = iloscnaczep;
}
	
	public int getIloscnaczep() {
		return iloscnaczep;
	}

}
