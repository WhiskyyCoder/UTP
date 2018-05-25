package Zad2;

public class Main {

	public static void main(String[] args) {
		String fname=System.getProperty("user.home") + "/dictionary.txt";
		Dictionary dc=new Dictionary(fname);

		dc.add("kot", "to zwierzak pospolity");
		dc.add("kot", "to zwierzak pospolity");
		dc.add("kot", "to zwierzak ktory nie lubi psa");
		for(String a:dc.lookup("kot"))
			System.out.println(a);
		
		dc.delete("kot", 1);
		System.out.println("--------------------");
		for(String a:dc.lookup("kot"))
			System.out.println(a);	
		System.out.println("--------------------");
		dc.update("kot", "kot zmieniony", 1);
	    dc.add("kot", "test");
	    dc.add("kot", "kot zmieniony");
		for(String a:dc.lookup("kot"))
			System.out.println(a);	
		
		dc.save();
	}

}
