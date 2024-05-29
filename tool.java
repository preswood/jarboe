package jarboe;
//JarboeFX is developed by Sean P. Emili
//Version 0.0.1
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

public class tool {
	private static String defaultFile;
	
	public static void write(String dir, String data)
	{
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dir));
		} catch (IOException whoops) {}
		try {
		      writer.write(data);
		      writer.close();
		} catch (IOException e) {}
	}
	
	public static void qwrite(String data)
	{
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(defaultFile));
		} catch (IOException whoops) {}
		try {
		      writer.write(data);
		      writer.close();
		} catch (IOException e) {}
	}
	
	public static void setFile(String x)
	{
		if (checkFile(x))
			defaultFile = x;
		else
			System.out.println(ANSI.RED + "ERROR - File not found" + ANSI.RESET);
	}
	
	public static String read(String dir)
	{
		Path filePath = Path.of(dir);
		String datiCaricati="";
		try
		    {datiCaricati = Files.readString(filePath);}
		catch (IOException e) {}
		return datiCaricati;
	}
	
	public static String qread()
	{
		return read(defaultFile);
	}
	
	public static Vector<String> fread(String dir)
	{
		Vector<String> datiCaricati = new Vector<String>();
		try {
			File file = new File(dir);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while((line = bufferedReader.readLine()) != null) {
				datiCaricati.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {}
		return datiCaricati;
	}
	
	public static boolean checkFile(String dir)
	{
		File f = new File(dir);
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkFolder(String dir)
	{
		File f = new File(dir);
		if(f.exists() && f.isDirectory()) { 
		    return true;
		} else {
			return false;
		}
	}
}
