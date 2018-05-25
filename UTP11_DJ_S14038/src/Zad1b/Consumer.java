package Zad1b;

import java.util.Random;

public class Consumer  implements Runnable{
	 private Buffer buf;
	 public Consumer(Buffer b) {
		buf=b;
	}
	@Override
	public void run() {
    while(true){
	if(Thread.currentThread().isInterrupted())return ;
	int liczba=buf.get();
	if(liczba ==-1) return;
	System.out.println("Consum: "+liczba);
	try {
	Thread.sleep(new Random().nextInt(2)*1000);
	} catch (InterruptedException e) {
    return;
	}
	
	
	
}
		
	}
	 
	 

}
