/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.controller.publictransport;

import ch.bfh.black.apollo.controller.Controller;
import ch.bfh.black.apollo.model.State;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.navigator.Navigator;

/**
 *
 * @author vill
 */
public class PublicTransportController extends Controller {

    public PublicTransportController(Navigator n, State s) {
        super(n, s);
    }
    
    public void publicTransportInit() {
        // FIXME andere View
        _nav.navigateTo(ClientChooser.VIEW_NAME);
    }
}
