package Zad1;
import java.util.Random;

public class Producer implements Runnable {
private Buffer buf;
private int liczba;
	public Producer(Buffer b) {
	buf=b;
	}
	
	
	@Override
	public void run() {
	
		
		while(true){
			if(Thread.currentThread().isInterrupted())return ;
			liczba=new Random().nextInt(100);
			
			
			
			buf.put(liczba);
			try {
				Thread.sleep(new Random().nextInt(2)*1000);
			} catch (InterruptedException e) {
	         return ;
	 		}
			
		}

	}

}
