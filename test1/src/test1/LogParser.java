
package test1;
import java.io.*;


public class LogParser {
	public LogParser(String choosedFilePath, String choosedFileName)
	{
		System.out.println(choosedFilePath + choosedFileName);
	}

	public LogParser(final File choosedFile)
	{
		
		if(choosedFile.exists() == true){
			System.out.println(choosedFile.getAbsolutePath());
			try{
				BufferedReader inFile = new BufferedReader(new FileReader(choosedFile));
				String sLine = null;
				String coordinates = null;
				int pX=9999, pY=9999, pZ=9999;
				int hitStringEntry;
				
				while( (sLine = inFile.readLine()) != null ){
					if( (hitStringEntry = sLine.indexOf("finger released")) > 0){
						coordinates = sLine.substring(hitStringEntry + 20, sLine.length()-1);
						System.out.println(sLine + "// " + coordinates);
						
						char[] char_coordinates1;
						char[] char_coordinates2;
						char[] char_coordinates3;
						
						char_coordinates1 = coordinates.substring(0, 3).trim().toCharArray();
						
						System.out.println("char_coordinates1 : " + char_coordinates1[0] + "\t");
						if (char_coordinates1[0] < '0' || char_coordinates1[0] > '9')
							continue;
						
						coordinates.substring(5,8).trim().length();
						
						char_coordinates2 = coordinates.substring(5, 8).trim().toCharArray();
						
						System.out.println("char_coordinates2 : " + char_coordinates2[0] + "\t");
						if (char_coordinates2[0] < '0' || char_coordinates2[0] > '9')
							continue;
						
						char_coordinates3 = coordinates.substring(10, coordinates.length()-1).trim().toCharArray();
						System.out.println("char_coordinates3 : " + char_coordinates3[0] + "\t");
						if (char_coordinates3[0] < '0' || char_coordinates3[0] > '9')
							continue;
						
						pX = Integer.parseInt(coordinates.substring(0, 3).trim());	
						pY = Integer.parseInt(coordinates.substring(5, 8).trim());
						pZ = Integer.parseInt(coordinates.substring(10, coordinates.length()-1).trim());
						//System.out.println(sLine + "// " + pX + ',' + pY + ',' + pZ);
					}
				}
			}catch(FileNotFoundException e){
				System.out.println("The File doesn't exist");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
