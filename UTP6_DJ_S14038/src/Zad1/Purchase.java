/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad1;


public class Purchase {
String id_klient;
String nazwisko;
String imie;
String nazwa_towaru;
double cena;
double ilosc;
public Purchase(String id_klient, String nazwisko, String imie, String nazwa_towaru,double cena,double ilosc) {

	this.id_klient = id_klient;
	this.nazwisko = nazwisko;
	this.imie = imie;
	this.cena=cena;
	this.nazwa_towaru = nazwa_towaru;
	this.ilosc = ilosc;
}

}

