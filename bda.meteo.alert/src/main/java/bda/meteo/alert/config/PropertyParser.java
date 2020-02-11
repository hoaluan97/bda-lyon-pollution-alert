package bda.meteo.alert.config;

import java.io.*;
import java.util.Properties;

public class PropertyParser {
    
    private Properties props = new Properties();
    
    public String getProperty(String key) {
        return props.get(key).toString();
    }
    
    public void parsePropsFile(String propFileName) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        
        if (inputStream != null) {
            props.load(inputStream);
        } else {
            inputStream = new FileInputStream(new File(propFileName).getAbsolutePath());
            if (inputStream != null) {
                props.load(inputStream);
            }
        }
    }
    
}