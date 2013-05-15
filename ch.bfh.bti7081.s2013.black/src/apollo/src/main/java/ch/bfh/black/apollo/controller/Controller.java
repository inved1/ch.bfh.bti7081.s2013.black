/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.model.State;

/**
 *
 * @author vill
 */
public class Controller {
    
    protected MenuManager _mm;
    protected State _state;

    public Controller(MenuManager mm, State s) {
        _mm = mm;
        _state = s;
    }
    
    public void back() {
        _mm.back();
    }
    
    public State getState(){
        return _state;
    }
}
