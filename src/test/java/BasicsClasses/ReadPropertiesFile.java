package BasicsClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ReadPropertiesFile {

	public ArrayList<String> ReadPropertiedFile(String filePath) throws IOException {

		Properties prop = new Properties();
		ArrayList<String> PropArray = new ArrayList<String>();
		InputStream readFile = null;

		readFile = new FileInputStream(filePath);
		prop.load(readFile);
		String BrowserName = prop.getProperty("Browser_Name");
		String BaseURL = prop.getProperty("Base_Url");
		PropArray.add(BrowserName);
		PropArray.add(BaseURL);
		return PropArray;

	}

}
