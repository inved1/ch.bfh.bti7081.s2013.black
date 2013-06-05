/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.tester;

import java.util.ArrayList;

/**
 * class for testing Junit tests 
 * @author Daniel Inversini
 */
public class Client {
    
    
    private final static String CLIENT_NAME = "Daniel Inversini";
    private final static String CLIENT_STREET = "Brauihof 20";
    private final static String CLIENT_CITY = "Langenthal";
    private final static int CLIENT_ZIP = 4900;
    private final static String CLIENT_COUNTRY = "CH";
    
    private String myName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyStreet() {
        return myStreet;
    }

    public void setMyStreet(String myStreet) {
        this.myStreet = myStreet;
    }

    public String getMyCity() {
        return myCity;
    }

    public void setMyCity(String myCity) {
        this.myCity = myCity;
    }

    public int getMyZIP() {
        return myZIP;
    }

    public void setMyZIP(int myZIP) {
        this.myZIP = myZIP;
    }

    public String getMyCountry() {
        return myCountry;
    }

    public void setMyCountry(String myCountry) {
        this.myCountry = myCountry;
    }
    private String myStreet;
    private String myCity;
    private int myZIP;
    private String myCountry;
    
    
    private ArrayList<String> myInfos;
    
    public Client() throws Exception{
        this.myName = CLIENT_NAME;
        this.myStreet = CLIENT_STREET;
        this.myCity = CLIENT_CITY;
        this.myZIP = CLIENT_ZIP;
        this.myCountry = CLIENT_COUNTRY;
        
        
        this.myInfos = new ArrayList<String>();
        
        
    }
        
    
    
    public void addInfo(String info) throws Exception {
        this.myInfos.add(info);
    }
    
    public void removeInfo(String info) throws Exception {
        this.myInfos.remove(info);
    }
}
