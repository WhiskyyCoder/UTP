package Zad1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
Buffer b=new Buffer(10);
    Producer prod=new Producer(b);
    Consumer consumer=new Consumer(b);
    
    
    ExecutorService ex = Executors.newCachedThreadPool();
    ex.submit(prod);
    ex.submit(consumer);
  try {
	ex.awaitTermination(15,TimeUnit.SECONDS );
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    ex.shutdownNow();
	}

}
