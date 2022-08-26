package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataFileReader {

	public static void main(String[] args) {

		DataFileReader data = new DataFileReader();
		data.costcoDataReader();

	}

	public String[][] costcoDataReader() {

		String[][] costcoData = null;

		try {
			File f = new File("src/test/resources/testData/costcoProducts.txt");

			BufferedReader br = new BufferedReader(new FileReader(f));

			String line = br.readLine();

			ArrayList<String[]> datas = new ArrayList<>();

			while (line != null) {
				String[] data = line.split("-");
				datas.add(data);

				line = br.readLine();
			}

			costcoData = new String[datas.size()][2];

			for (int i = 0; i < datas.size(); i++) {
				costcoData[i] = datas.get(i);
			}

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return costcoData;

	}

}
