package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataFileReader {
	
	public static void main(String[] args) {
		DataFileReader data = new DataFileReader();
		data.dataReader();
		
		
		
	}
	
	public ArrayList<String[]> dataReader() {
		ArrayList<String[]> datas = new ArrayList<>();
		
		try {
		File f = new File("src/test/resources/testData/costcoProducts.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String line =br.readLine();
		
		
		
		while (line !=null) {
			String[] data = line.split("-");
			datas.add(data);
		
			line = br.readLine();
		
		
		}
		br.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return datas;
		
	}

}
