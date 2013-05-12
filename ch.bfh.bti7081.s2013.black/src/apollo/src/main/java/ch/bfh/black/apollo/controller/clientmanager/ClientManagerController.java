/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.Controller;
import ch.bfh.black.apollo.model.State;
import ch.bfh.black.apollo.view.MainMenu;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.navigator.Navigator;

/**
 *
 * @author vill
 */
public class ClientManagerController extends Controller {

    public ClientManagerController(Navigator n, State s) {
        super(n, s);
    }
    
    public void clientManagerInit() {
        _state.menuState.add(ClientChooser.VIEW_NAME);
        navigate();
    }
    
    public void chooseClient() {
        _state.menuState.add(MainMenu.VIEW_NAME);
        navigate();
    }
    
    public void chooseClientBack() {
        _state.menuState.add(MainMenu.VIEW_NAME);
        navigate();
    }
    
    private void navigate() {
        _nav.navigateTo(_state.menuState.get(_state.menuState.size() - 1));
    }
}


