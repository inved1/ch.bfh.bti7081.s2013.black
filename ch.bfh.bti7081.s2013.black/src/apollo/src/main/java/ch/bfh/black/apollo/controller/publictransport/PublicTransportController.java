/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.publictransport;

import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.navigator.Navigator;

/**
 *
 * @author vill
 */
public class PublicTransportController {
    
    private Navigator _nav;

    public PublicTransportController(Navigator n) {
        _nav = n;
    }
    
    public void publicTransportInit() {
        // FIXME andere View
        _nav.navigateTo(ClientChooser.VIEW_NAME);
    }
}
