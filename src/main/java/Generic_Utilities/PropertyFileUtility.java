package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class related to generic method from property file
 * @author Diptalok
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file and return value to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String ReadDataProp(String key)throws IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertyfile.properties");
	Properties prop = new Properties();
	prop.load(fis);
	String URL = prop.getProperty(key);
	return URL;
	
	}
}
