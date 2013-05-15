/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.Controller;
import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.model.State;

/**
 *
 * @author vill
 */
public class ClientManagerController extends Controller {
    
    public ClientManagerController(MenuManager mm, State s) {
        super(mm, s);
    }
    
    public void init() {
        _mm.setMenuState(_mm.getClientChooserState());
        _mm.init();
    }
    
    public void chooseClient(int id) {
        _state.clientId = id;
        _mm.setMenuState(_mm.getClientDetailState());
        _mm.init();
    }
}


