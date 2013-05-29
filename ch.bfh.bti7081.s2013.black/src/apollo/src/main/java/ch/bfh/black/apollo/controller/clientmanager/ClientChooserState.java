package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.controller.MenuState;
import ch.bfh.black.apollo.view.MainMenu;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;

/**
 * Specific Menu State for ClientChooser Menu.
 * 
 * @author Julien Villiger
 */
public class ClientChooserState implements MenuState {
    
    private MenuManager _menuManager;

    /**
     * @param menuManager 
     */
    public ClientChooserState(MenuManager menuManager) {
        _menuManager = menuManager;
    }

    @Override
    public void init() {
        _menuManager.getNavigator().navigateTo(ClientChooser.VIEW_NAME);
    }

    @Override
    public void back() {
        _menuManager.getNavigator().navigateTo(MainMenu.VIEW_NAME);
        _menuManager.setMenuState(_menuManager.getMainMenuState());
    }
    
}
