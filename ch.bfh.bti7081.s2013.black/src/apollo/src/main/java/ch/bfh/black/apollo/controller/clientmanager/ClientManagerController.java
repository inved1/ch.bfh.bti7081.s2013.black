/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.view.MainMenu;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.navigator.Navigator;

/**
 *
 * @author vill
 */
public class ClientManagerController {
    
    private Navigator _nav;

    public ClientManagerController(Navigator n) {
        _nav = n;
    }
    
    public void clientManagerInit() {
        _nav.navigateTo(ClientChooser.VIEW_NAME);
    }
    
    public void chooseClient() {
        _nav.navigateTo(MainMenu.VIEW_NAME);
    }
}


