package Zad1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Plik extends SimpleFileVisitor<Path> {
	private String result;
	public Plik(String result) {
		// TODO Auto-generated constructor stub
		this.result=result;
	}
	  @Override
	  public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
		  if(!file.toFile().isDirectory() && ((Path)file).toFile().getName().endsWith(".txt"))
		  try {
			  
			  InputStreamReader in=new  InputStreamReader(new FileInputStream(file.toFile()), Charset.forName("Cp1250"));
			BufferedReader br=new BufferedReader(in);
			 FileOutputStream fos = new FileOutputStream(result,true);
		     Writer out = new OutputStreamWriter(fos, "UTF-8");
			String x;
			
			while((x=br.readLine()) != null){
				out.append(x+" \n");
			}
			out.close();
			fos.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	    
	    
	    return FileVisitResult.CONTINUE;
	  }
	  
}
