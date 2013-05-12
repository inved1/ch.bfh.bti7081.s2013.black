/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.model;

import ch.bfh.black.apollo.view.MainMenu;
import java.util.ArrayList;

/**
 *
 * @author vill
 */
public class State {

    public ArrayList<String> menuState;
    
    public State() {
        
        menuState = new ArrayList<String>();
        menuState.add(MainMenu.VIEW_NAME);
    }
}
