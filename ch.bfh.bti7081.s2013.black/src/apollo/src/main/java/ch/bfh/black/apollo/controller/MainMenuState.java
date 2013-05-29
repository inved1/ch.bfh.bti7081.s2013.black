package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.view.clientmanager.ClientChooser;

/**
 * State for Main Menu of App.
 * 
 * @author Julien Villiger
 */
public class MainMenuState implements MenuState {
    
    private MenuManager _menuManager;

    public MainMenuState(MenuManager menuManager) {
        _menuManager = menuManager;
    }
    
    @Override
    public void init() {
        _menuManager.getNavigator().navigateTo(ClientChooser.VIEW_NAME);
    }

    @Override
    public void back() {
        
    }
}
