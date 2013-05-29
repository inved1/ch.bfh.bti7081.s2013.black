package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.controller.clientmanager.ClientChooserState;
import ch.bfh.black.apollo.controller.clientmanager.ClientDetailState;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import ch.bfh.black.apollo.view.clientmanager.ClientDetail;
import com.vaadin.navigator.Navigator;

/**
* MenuManager handles the different View-States of the app.
* Implemented with State Pattern.
*
* @author Julien Villiger
* 
*/

public class MenuManager {
    
    private MenuState _menuState;
    private Navigator _navigator;
    
    // states
    private MainMenuState _mainMenuState;
    private ClientChooserState _clientChooserState;
    private ClientDetailState clientDetailState;
    
    /**
     * 
     * @param nav 
     */
    public MenuManager(Navigator nav) {
        
        _navigator = nav;
        
        // different menu states are initialized
        // every screen (menu state) has its own state class (based on state pattern)
        _mainMenuState = new MainMenuState(this);
        _clientChooserState = new ClientChooserState(this);
        clientDetailState = new ClientDetailState(this);
        
        // setting the first state, depending which menu state is already active
        // (typing subpage in adressbar)
        if(nav.getState().equals(ClientChooser.VIEW_NAME)) _menuState = _clientChooserState;
        else if(nav.getState().equals(ClientDetail.VIEW_NAME)) _menuState = clientDetailState;
        else _menuState = _mainMenuState;
    }
    
    public void init() {
        _menuState.init();
    }

    public void back() {
        _menuState.back();
    }
    
    public void setMenuState(MenuState state) {
        _menuState = state;
    }
    
    public Navigator getNavigator() {
        return _navigator;
    }
    
    public MainMenuState getMainMenuState() {
        return _mainMenuState;
    }
    
    public ClientChooserState getClientChooserState() {
        return _clientChooserState;
    }
    
    public ClientDetailState getClientDetailState() {
        return clientDetailState;
    }
}
