package Zad2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Dictionary {
HashMap<String,List<String>> definicje=new HashMap<>();
private String fname;
	public Dictionary(String fname) {
		try{
		
			this.fname=fname;
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fname)));

			StringBuffer sb=new StringBuffer();
			String line="";
			while((line=br.readLine())!=null){
		
				if(Pattern.compile(".+\\s+[=]\\s+.+").matcher(line).find()){
				
					String con=new String(line.getBytes("cp1250"),"UTF-8");
					String[] tab=con.split("=");
				if(definicje.containsKey(tab[0].toLowerCase().trim())){
					if(!inList(definicje.get(tab[0].toLowerCase().trim()), tab[1].substring(1, tab[1].length()-1))){
					definicje.get(tab[0].toLowerCase().trim()).add(tab[1].substring(1, tab[1].length()-1));
					}
					}else{
					List<String> l=new ArrayList<>();
					l.add(tab[1].substring(1, tab[1].length()-1));
					definicje.put(tab[0].toLowerCase().trim(),l);
				}
				}
				
				
			}}catch(IOException ex){
				
			}
	}
	public void save(){
		try{
		File plik = new File(fname);
		FileWriter plikw = new FileWriter(plik, false); // true to append
		                                                     // false to overwrite.
		
		for(String w:definicje.keySet()){
			for(String k:definicje.get(w)){
				plikw.write(w+" = "+dot(k)+"\n");
			}	
		}
		plikw.close();
		}catch(IOException ex){
			
			
		}
	}
	
	
	
	public String dot(String d){
		int x=0;
		for(char c:d.toCharArray()){
			if(x<d.length()-1){
			if(c=='.'){
				return d.substring(x+1);
			}
			}
			x++;
		}
		
		
		
		return d;
	}
	public List<String> lookup(String slowo){
		List<String> l=null;
		try{
		l =definicje.get(slowo.toLowerCase());
		
		l.sort((e,e1)->{
			if(e.compareToIgnoreCase(e1)<0)
				return -1;
			if(e.compareToIgnoreCase(e1)>0)
				return 1;
			return 0;
		});	
		int x=1;
		for(String r:l){
			if(!r.substring(0, 4).contains(".")){
			l.set(x-1, x+"."+l.get(x-1));
			
			}else{
				l.set(x-1, x+"."+dot(l.get(x-1)));
				
			}
			x++;
		}
	}catch(NullPointerException ex){
	System.out.println("Brak podanego hasla :"+slowo);
		
	}
		
return l;
	}
	public boolean inList(List<String> l,String def){
		
		for(String s:l){
		
			if(def.equalsIgnoreCase(dot(s)))
				return true;
		}
		
		
		return false;
	}
	public void delete(String haslo,int index){
		List<String> lp=lookup(haslo);
				lp.remove(index-1);
			
		
		
		
	}
	public void update(String haslo,String definicja,int index){
		List<String> lp=lookup(haslo);
				lp.remove(index-1);
		lp.add(definicja);	
		lookup(haslo);
		
		
	}
	public void add(String haslo,String definicja){
		try{
		List<String> l =definicje.get(haslo.toLowerCase());
		if(!inList(l, definicja)){
			l.add(definicja);
		}
		}catch(NullPointerException ex){
		List<String> l=new ArrayList<>();	
		l.add(definicja);
		definicje.put(haslo, l);
		
		}
		
		
	}
	
	

}
