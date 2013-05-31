/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model.data.settings;

import java.util.HashMap;
import java.util.Map;


/*******************************************************************************
 * Project:        Apollo, MHC-PMS 
 * Universtity: BFH Bern
 * Course:      BTI7081q
 * 
 * Class:       Settings.java
 * 
 *-*****************************************************************************/


/**
 *
 * @author Daniel Inversini
 * 
 * read out settings from settings.xml
 * 29.05.2013 - changed to hardcoded instead of xml.... prototyping- reasons
 * 
 */
public class Settings {
    private static final String DEFAULT_CONFIG_FILE = "settings.xml";
    private static final Map<String, String> settings = new HashMap<String, String>();
    
    /**
     * inits the settings
     */
    private static void initialize() {
        if (settings.isEmpty()) {
            try {
               settings.put("DBuser","web345");
               settings.put("DBpw","biobauer22");
               settings.put("DBtype","mysql");
               settings.put("DBname","usr_web345_11");
               settings.put("DBhost","login-5.hoststar.ch:3306");
               
               
            } catch (Exception ex) {
                System.out.println(ex.toString());
                settings.clear();
            }
        }
    }
    
    /**
     * gets the value from the settings
     * @param pName the parameter name
     * @return  the value which is stored
     */
    public static String get(String pName) {
        initialize();
        return settings.containsKey(pName) ? settings.get(pName) : null;
    }
}


