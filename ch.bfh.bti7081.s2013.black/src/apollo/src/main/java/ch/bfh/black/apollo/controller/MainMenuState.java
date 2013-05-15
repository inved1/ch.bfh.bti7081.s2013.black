/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.view.clientmanager.ClientChooser;

/**
 *
 * @author vill
 */
public class MainMenuState implements MenuState {
    
    private MenuManager _mm;

    public MainMenuState(MenuManager mm) {
        _mm = mm;
    }
    
    @Override
    public void init() {
        _mm.getNavigator().navigateTo(ClientChooser.VIEW_NAME);
    }

    @Override
    public void back() {
        
    }
}
