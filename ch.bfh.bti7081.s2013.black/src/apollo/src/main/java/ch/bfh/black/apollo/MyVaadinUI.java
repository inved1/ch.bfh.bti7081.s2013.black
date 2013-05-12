package ch.bfh.black.apollo;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.controller.publictransport.PublicTransportController;
import ch.bfh.black.apollo.model.State;
import ch.bfh.black.apollo.view.MainMenu;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Theme("apollotheme")
public class MyVaadinUI extends UI
{
    Navigator navigator;
    protected static final String MAINVIEW = "main";
    
    ClientManagerController cmc;
    PublicTransportController ptc;
    
    private State _state;
    
    @Override
    protected void init(VaadinRequest request) {
        
        getPage().setTitle("Apollo");
        
        _state = new State();
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        cmc = new ClientManagerController(navigator, _state);
        ptc = new PublicTransportController(navigator, _state);
        
        navigator.addView(MainMenu.VIEW_NAME, new MainMenu(cmc, ptc));
        navigator.addView(ClientChooser.VIEW_NAME, new ClientChooser(cmc));
    }
}
