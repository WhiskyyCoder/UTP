/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomersPurchaseSortFind {
ArrayList<Purchase> zakupy=new ArrayList<Purchase>();
	public void readFile(String fname)  {
		try{
		FileReader fr=new FileReader(fname);
		
		BufferedReader br=new BufferedReader(fr);

		StringBuffer sb=new StringBuffer();
		String line="";
		while((line=br.readLine())!=null){
			String[] tab=line.split(";");
			zakupy.add(new Purchase(tab[0],tab[1].split(" ")[0],tab[1].split(" ")[1],tab[2],Double.parseDouble(tab[3]),Double.parseDouble(tab[4])));
	
			
			
		}}catch(IOException ex){
			
		}
	}
	public void showSortedBy(String string) {
		
		switch(string){
		case "Nazwiska":
		zakupy.sort((e,e1)->{
		if(e.nazwisko.compareToIgnoreCase(e1.nazwisko)<0){
			
			return -1;
		}else{
			if((e.nazwisko.compareToIgnoreCase(e1.nazwisko))==0){
				
			if(e.id_klient.compareToIgnoreCase(e1.id_klient)<0) 
					{
			return -1;
					}else{
						if((e.id_klient.compareToIgnoreCase(e1.id_klient))==0) {
							return 0;
						}else{
							if((e.id_klient.compareToIgnoreCase(e1.id_klient)>0)){
								return 1;
							}
						}}
			
			
			
			
			
			}
			}
		return 0;});
					
		
		
			
			
			
			
		System.out.println("Nazwiska:");
		for(Purchase z:zakupy){
			System.out.println(z.id_klient+";"+z.nazwisko+" "+z.imie+";"+z.nazwa_towaru+";"+z.cena+";"+z.ilosc);
			
		}
		break;
		case "Koszty":
			System.out.println("Koszty:");	
		zakupy.sort((e,e1)->{
			double k1=e.ilosc*e.cena;
			double k2=e1.ilosc*e1.cena;
			if(k1<k2){
				return 1 ;
			}else{
				if(k1>k2){
					return -1;
				}else{
				if(k1==k2){
				 return 0;
				}	
					
					
				}
				
			}
			
			
			
			return 0;	
		});
		for(Purchase z:zakupy){
			System.out.println(z.id_klient+";"+z.nazwisko+" "+z.imie+";"+z.nazwa_towaru+";"+z.cena+";"+z.ilosc+" (Koszt)"+z.cena*z.ilosc);
			
		}
		break;
		
		}
	}
	public void showPurchaseFor(String id) {
		if(inTxt(id)){
		System.out.println("Klient "+id+":");	
		zakupy.forEach((e)->{if(e.id_klient.equalsIgnoreCase(id))System.out.println(e.id_klient+";"+e.nazwisko+" "+e.imie+";"+e.nazwa_towaru+";"+e.cena+";"+e.ilosc);});
		}else{
	    System.out.println("Brak klienta "+id+" w pliku txt");		
		}
	}
	public boolean inTxt(String id){
		for(Purchase p: zakupy){
			if(id.equalsIgnoreCase(p.id_klient))
				return true;
		}
		
		return false;
	}
}
