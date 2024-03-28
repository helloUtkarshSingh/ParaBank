package BasicsClasses;

public class ReadTestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadExcelFile readData = new ReadExcelFile(
				System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\ParaBank.xlsx");
		String sheetName = "LoginTest";
		String testName = "Update Contact Info";

		// ******************Find Start Row of TestCase******************
		int StartRow = 0; // FileName column
		while (!readData.getCellData(sheetName, 0, StartRow).equalsIgnoreCase(testName)) {
			StartRow++;
		}
		System.out.println("Test Start from Row Number: " + StartRow);

		int startTestColum = StartRow + 1;
		int startTestRow = StartRow + 2;

		System.out.println("startTestColum: " + startTestColum);
		System.out.println("startTestRow: " + startTestRow);

		// ******************Find Number of Rows of TestCase******************
		int rows = 0;
		while (!readData.getCellData(sheetName, 0, startTestRow + rows).equals("")) {
			rows++;
		}
		System.out.println("Total number of Row in test: " + testName + " is: " + rows);

		// Find Number of Cols of TestCase
		int cols = 0;
		while (!readData.getCellData(sheetName, cols, startTestColum).equals("")) {
			cols++;
		}
		System.out.println("Test Start from Columns Number: " + cols);
		System.out.println("colNumber:- "+cols+" rowNumber:- "+startTestRow);
		for (int rowNumber = startTestRow; rowNumber < StartRow + rows; rowNumber++) {
			for (int colNumber = 0; colNumber < cols; colNumber++) {
				System.out.println(readData.getCellData(sheetName, colNumber, rowNumber));
			}

		}
	}

}
