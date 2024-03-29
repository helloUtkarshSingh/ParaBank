package BasicsClasses;

import java.util.Hashtable;

public class ReadTestData {

	public static Object[][] SendExcelData(String DataFile,String SheatName, String TestName) {
		// TODO Auto-generated method stub
		ReadExcelFile readData = new ReadExcelFile(
				System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\"+DataFile);
		String sheetName = SheatName;
		String testName = TestName;

		// ******************Find Start Row of TestCase******************
		int StartRow = 0; // FileName column
		while (!readData.getCellData(sheetName, 0, StartRow).equalsIgnoreCase(testName)) {
			StartRow++;
		}

		int startTestColum = StartRow + 1;
		int startTestRow = StartRow + 2;

		// ******************Find Number of Rows of TestCase******************
		int totalrows = 0;
		while (!readData.getCellData(sheetName, 0, startTestRow + totalrows).equals("")) {
			totalrows++;
		}

		// Find Number of Cols of TestCase
		int totalcols = 0;
		while (!readData.getCellData(sheetName, totalcols, startTestColum).equals("")) {
			totalcols++;
		}

		//To Return Data to the Test
		Object[][] dataset= new Object[totalrows][1];
		Hashtable<String, String> dataTable = null;
		int dataRowNumber = 0;
		for (int rowNumber = startTestRow; rowNumber <= startTestColum + totalrows; rowNumber++) {
			dataTable = new Hashtable<String, String>();
			for (int colNumber = 0; colNumber < totalcols; colNumber++) {
				String key = readData.getCellData1(sheetName, colNumber, startTestColum);
				String value = readData.getCellData1(sheetName, colNumber, rowNumber);
				dataTable.put(key, value);
				
			}
			dataset[dataRowNumber][0] = dataTable;
			dataRowNumber++;
		}
		return dataset;
	}

}
