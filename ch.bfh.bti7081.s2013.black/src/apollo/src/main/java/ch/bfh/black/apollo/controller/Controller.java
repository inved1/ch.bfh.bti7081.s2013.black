/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.model.State;

/**
 * General controller.
 * All other controllers extend this one.
 * 
 * Has basic methods which are used for every controller.
 * 
 * @author Julien Villiger
 */
public class Controller {
    
    protected MenuManager _menuManager;
    protected State _state;
    
    /**
     * @param menuManager
     * @param state 
     */
    public Controller(MenuManager menuManager, State state) {
        _menuManager = menuManager;
        _state = state;
    }
    
    public void back() {
        _menuManager.back();
    }
    
    public State getState(){
        return _state;
    }
}
