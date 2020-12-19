package Pack1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filehandling 
{
	
	public static File file = new File("Rawtext.txt");

	
	public int numberoflines() throws IOException
	{
	      FileInputStream fis = new FileInputStream(file);
	      byte[] byteArray = new byte[(int)file.length()];
	      fis.read(byteArray);
	      String data = new String(byteArray);
	      String[] stringArray = data.split("\r\n");
	      System.out.println("Number of lines in the file are ::"+stringArray.length);
	      return stringArray.length;
		
	}
	
	public void numberofspaces() throws IOException
	{
		FileInputStream fn = new FileInputStream(file);        
	    InputStreamReader input = new InputStreamReader(fn);   
	    BufferedReader reader = new BufferedReader(input);       
	    String sentence;
	    int countWord = 0,whitespaceCount = 0;
	    while((sentence= reader.readLine()) != null)
	    {
	    String[] wordlist =sentence.split("\\s+");
	    countWord += wordlist.length; //5
	     whitespaceCount += countWord -1;//4
	    } 
	      
	      System.out.println(" Number of whitespaces = " + whitespaceCount);
		
	}
	
	public void reader() throws IOException
	{
		//  +  =
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		int count=0;
		while(line!=null)
		{
			count++;
			line=br.readLine();
		}
		System.out.println("The total number of lines"+count);
	}
	
	public void readeandstore() throws IOException
	{
		//  +  =
		String text=" ";
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while(line!=null)
		{
			text=text +line;
			line=br.readLine();
		}
		System.out.println(text);
		//String[] y=text.split("\\s+");
		//System.out.println(y[5]);
		
		
	}
	
	public void removespaces()
	{
		String str = "   Hello Geeks  .  Welcome ,    Do you love Geeks , Geeks  ? "; 
	    System.out.println(str.replaceAll("\\s+"," ").trim()); 
	    System.out.println(str.replaceAll("\\s+"," ")); 

	}
	
	

	
	
	



	public static void main(String[] args) throws IOException 
	{
		Filehandling fl=new Filehandling();
		//fl.numberoflines();
		//fl.reader();
		//fl.readeandstore();
		fl.removespaces();
		   

	}

}
