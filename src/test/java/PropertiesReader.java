import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Singleton class for reading properties for application.properties file
public class PropertiesReader {
    private static PropertiesReader propertiesReader = new PropertiesReader();
    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException exception) {
            throw new IllegalArgumentException();
        }
    }

    private static String getProperty(String name) {
        return propertiesReader.properties.getProperty(name);
    }

    private static String getParameterFromCommandLine(String parameter) {
        return System.getProperty(parameter, null);
    }

    public static String getParam(String param) {
        if (getParameterFromCommandLine(param) != null) {
            return getParameterFromCommandLine(param);
        } else {
            return getProperty(param);
        }
    }
}
