/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.settings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;


/**
 *
 * @author Daniel Inversini
 * 
 * read out settings from settings.xml
 * create file if emtpy
 */
public class Settings {
    private static final String DEFAULT_CONFIG_FILE = "settings.xml";
    private static final Map<String, String> settings = new HashMap<String, String>();
    
    private static void initialize() {
        if (settings.isEmpty()) {
            try {
               settings.put("DBuser","web345");
               settings.put("DBpw","biobauer22");
               settings.put("DBtype","mysql");
               settings.put("DBname","usr_web345_11");
               settings.put("DBhost","login-5.hoststar.ch:3306");
               
               
                
                
                /*
                Document doc = new SAXBuilder().build(new InputSource(Settings.class.getResourceAsStream(DEFAULT_CONFIG_FILE)));
                System.out.println(doc.toString());
                for (Iterator<?> it = doc.getRootElement().getChildren().iterator(); it.hasNext();) {
                    Element element = (Element) it.next();
                    settings.put(element.getName(), element.getValue());
                }
                * */
            } catch (Exception ex) {
                System.out.println(ex.toString());
                settings.clear();
            }
        }
    }
    
    
    public static String get(String pName) {
        initialize();
        return settings.containsKey(pName) ? settings.get(pName) : null;
    }
}


