package Zad2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Plik extends SimpleFileVisitor<Path> {
	private String result;
	public Plik(String result) {
		// TODO Auto-generated constructor stub
		this.result=result;
	}
	  @Override
	  public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		  if(!file.toFile().isDirectory() && file.toFile().getName().endsWith(".txt") ){
		Stream<String> stream = Files.lines(file, Charset.forName("Cp1250")) ;
		 FileOutputStream fos = new FileOutputStream(result,true);
		 Writer out = new OutputStreamWriter(fos, "UTF8");
		 stream.forEach(n->{try {
			out.write(n);
		} catch (IOException e) {
			e.printStackTrace();
		}});
		out.close();
		fos.close();
		stream.close();
	  }
		  
		
	    
	    return FileVisitResult.CONTINUE;
	  }
	  
}
