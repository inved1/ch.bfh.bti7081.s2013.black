/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.model.State;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Notification;

/**
 *
 * @author vill
 */
public class Controller {
    
    protected Navigator _nav;
    protected State _state;

    public Controller(Navigator n, State s) {
        _nav = n;
        _state = s;
    }
       
    public void navigateToGeneral(String menu) {
        _nav.navigateTo(menu);
    }
    
    public void navigateBack() {
        
        //Notification.show("navigate Back, content: " + _state.menuState.get(_state.menuState.size() - 1));
        
        _state.menuState.remove(_state.menuState.size() - 1);
        _nav.navigateTo(_state.menuState.get(_state.menuState.size() - 1));
        
    }
}
