/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller;

import ch.bfh.black.apollo.controller.clientmanager.ClientChooserState;
import ch.bfh.black.apollo.controller.clientmanager.ClientDetailState;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import ch.bfh.black.apollo.view.clientmanager.ClientDetail;
import com.vaadin.navigator.Navigator;

/**
 *
 * @author vill
 */
public class MenuManager {

    private MenuState _menuState;
    private Navigator _nav;
    
    // states
    private MainMenuState _mms;
    private ClientChooserState _ccs;
    private ClientDetailState _cds;
    
    public MenuManager(Navigator nav) {
        
        _nav = nav;
        
        _mms = new MainMenuState(this);
        _ccs = new ClientChooserState(this);
        _cds = new ClientDetailState(this);
        
        _menuState = _mms;
        
        if(nav.getState().equals(ClientChooser.VIEW_NAME)) _menuState = _ccs;
        else if(nav.getState().equals(ClientDetail.VIEW_NAME)) _menuState = _cds;
        else _menuState = _mms;
        
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
        return _nav;
    }
    
    public MainMenuState getMainMenuState() {
        return _mms;
    }
    
    public ClientChooserState getClientChooserState() {
        return _ccs;
    }
    
    public ClientDetailState getClientDetailState() {
        return _cds;
    }
}
