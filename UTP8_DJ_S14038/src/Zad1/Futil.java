package Zad1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Futil {

	public static void processDir(String dirName, String resultFileName) {
		try {
			Path p=new File(dirName).toPath();
			Files.walkFileTree(p,new Plik(resultFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
