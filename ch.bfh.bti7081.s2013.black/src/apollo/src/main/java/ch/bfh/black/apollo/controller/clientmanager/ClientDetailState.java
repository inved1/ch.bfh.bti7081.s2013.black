package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.controller.MenuState;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import ch.bfh.black.apollo.view.clientmanager.ClientDetail;

/**
 * Specific Menu State for ClientDetail Menu.
 * 
 * @author Julien Villiger
 */
public class ClientDetailState implements MenuState{ 
    
    private MenuManager _menuManager;

    public ClientDetailState(MenuManager menuManager) {
        _menuManager = menuManager;
    }

    @Override
    public void init() {
        _menuManager.getNavigator().navigateTo(ClientDetail.VIEW_NAME);
    }

    @Override
    public void back() {
        _menuManager.getNavigator().navigateTo(ClientChooser.VIEW_NAME);
        _menuManager.setMenuState(_menuManager.getClientChooserState());
    }
}
