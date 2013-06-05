/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.controller.MenuState;
import ch.bfh.black.apollo.view.clientmanager.AddClientHistory;
import ch.bfh.black.apollo.view.clientmanager.ClientDetail;

/**
 * Specific Menu State for ClientDetail Menu.
 * 
 * @author Julien Villiger
 */
public class AddClientHistoryState implements MenuState{
    
    private MenuManager _menuManager;

    public AddClientHistoryState(MenuManager menuManager) {
        _menuManager = menuManager;
    }

    @Override
    public void init() {
        _menuManager.getNavigator().navigateTo(AddClientHistory.VIEW_NAME);
    }

    @Override
    public void back() {
        _menuManager.getNavigator().navigateTo(ClientDetail.VIEW_NAME);
        _menuManager.setMenuState(_menuManager.getClientDetailState());
    }
}
