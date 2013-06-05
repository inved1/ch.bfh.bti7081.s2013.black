package ch.bfh.black.apollo.controller.clientmanager;

import ch.bfh.black.apollo.controller.Controller;
import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.model.State;
import com.vaadin.ui.Notification;

/**
 * Handles ClientManager specific controller functionality.
 * Mainly provides methods for listeners, captured in view.
 * 
 * @author Julien Villiger
 */
public class ClientManagerController extends Controller {
    
    /**
     * @param menuManager
     * @param state 
     */
    public ClientManagerController(MenuManager menuManager, State state) {
        super(menuManager, state);
    }
    
    /**
     * initialize current state
     */
    public void init() {
        _menuManager.setMenuState(_menuManager.getClientChooserState());
        _menuManager.init();
    }
    
    /**
     * switches to client detail view after clicking client-list
     * 
     * @param id 
     */
    public void chooseClient(int id) {
        _state.clientId = id;
        _menuManager.setMenuState(_menuManager.getClientDetailState());
        _menuManager.init();
    }
    
    public void addClientHistory() {
        _menuManager.setMenuState(_menuManager.getAddClientHistoryState());
        _menuManager.init();
    }
}


