import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class main_class {
	
	public static void main(String[] args)throws Exception {
		
		//open file
		Scanner consoleinput = new Scanner(System.in);
			
		FileReader filein = new FileReader(consoleinput.nextLine());			
		Scanner scan = new Scanner(filein);
		
		
		//Convert to numbers
		String NumbersS = scan.nextLine();
		NumbersS=NumbersS.replace('[', ' ');
		NumbersS=NumbersS.replace(']', ' ');
		String[] buffers =NumbersS.split(",",0);		
		
		
		//creating dictionary
		Map<String,String> dictionary = new HashMap<String,String>();
		
		//writing data in dictionary
		for(String i:buffers) {
			if(dictionary.containsKey(i.trim())) {					// if key already exist
				int buffervalue=Integer.valueOf(dictionary.get(i.trim()));	// saving current value
				dictionary.remove(i.trim());					// removing old data 
				dictionary.put(i.trim(),Integer.toString(buffervalue+1));	// writing new data			
			}else dictionary.put(i.trim(), "1");					// else add new key
		}
		
		//calculating required data
		int x3=0,x4=0,x5=0;
		//x3
		for(String i:dictionary.keySet()) if(dictionary.get(i)=="1")x3++;
		//
		
		//x4 x5
		for(String i:dictionary.keySet()) 
			if(Integer.valueOf(dictionary.get(i))>x5) {
				x4=Integer.valueOf(i);
				x5=Integer.valueOf(dictionary.get(i));
			}
		//
		
		//current date	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		//OUTPUT
		System.out.print(dateFormat.format(date)+"	["+NumbersS+"]		["+buffers.length+", "+dictionary.size()+", "+ x3 +", "+ x4 +", "+ x5 +"]\n"); 
		
			
		
		scan.close();
		consoleinput.close();
	}

}
