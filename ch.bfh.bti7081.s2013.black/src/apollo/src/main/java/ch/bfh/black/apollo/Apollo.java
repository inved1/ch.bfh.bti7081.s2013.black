package ch.bfh.black.apollo;

import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.model.Dict;
import ch.bfh.black.apollo.model.State;
import ch.bfh.black.apollo.view.MainMenu;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import ch.bfh.black.apollo.view.clientmanager.ClientDetail;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
* The Application's "main" class
* 
* 
*
* @author Julien Villiger
* 
*/

@SuppressWarnings("serial")

// working with own theme, based on reindeer.
@Theme("apollotheme")
public class Apollo extends UI
{
    protected static final String MAINVIEW = "main";
    
    ClientManagerController clientManagerController;
    
    private State _state;
    private Navigator _navigator;
    private MenuManager _menuManager;
    
    @Override
    protected void init(VaadinRequest request) {
        
        // set page title
        getPage().setTitle(Dict.HEADER_MAIN_TITLE);
        
        // init
        _state = new State();
        _navigator = new Navigator(this, this);
        _menuManager = new MenuManager(_navigator);
        clientManagerController = new ClientManagerController(_menuManager, _state);
        
        // register all views
        _navigator.addView(MainMenu.VIEW_NAME, new MainMenu(clientManagerController));
        _navigator.addView(ClientChooser.VIEW_NAME, new ClientChooser(clientManagerController));
        _navigator.addView(ClientDetail.VIEW_NAME, new ClientDetail(clientManagerController));
    }
}
