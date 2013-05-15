/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.controller.MenuState;
import ch.bfh.black.apollo.view.MainMenu;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;

/**
 *
 * @author vill
 */
public class ClientChooserState implements MenuState {
    
    private MenuManager _mm;

    public ClientChooserState(MenuManager mm) {
        _mm = mm;
    }

    @Override
    public void init() {
        _mm.getNavigator().navigateTo(ClientChooser.VIEW_NAME);
    }

    @Override
    public void back() {
        _mm.getNavigator().navigateTo(MainMenu.VIEW_NAME);
        _mm.setMenuState(_mm.getMainMenuState());
    }
    
}
