package Zadania;

import java.sql.Connection;
import java.sql.Statement;

public class Ins1 {

  static public void main(String[] args) {
    new Ins1();
  }

Statement stmt;

Ins1()  {
   Connection con = null;
   try {
     //...
   } catch (Exception exc)  {
     System.out.println(exc);
     System.exit(1);
   }
	// nazwy wydawców do wpisywania do tabeli
   String[] wyd =  { "PWN", "PWE", "Czytelnik", "Amber", "HELION", "MIKOM" };

   	// pierwszy numer wydawcy do wpisywania do tabeli: PWN ma numer 15, PWE ma 16, ...
   int beginKey = 15;

   String[] ins =  // ? ... tablica instrukcji SQL do wpisywania rekordów do tabeli: INSERT ...                  

   int insCount = 0;   // ile rekordów wpisano
   try  {
     for (int i=0; i < ins.length; i++) // wpisywanie rekordów
     // ...
   }
//...
}
} 
