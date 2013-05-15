package ch.bfh.black.apollo;

import ch.bfh.black.apollo.controller.MenuManager;
import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.controller.publictransport.PublicTransportController;
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
 */
@SuppressWarnings("serial")
@Theme("apollotheme")
public class MyVaadinUI extends UI
{
    protected static final String MAINVIEW = "main";
    
    ClientManagerController cmc;
    PublicTransportController ptc;
    
    private State _state;
    private Navigator _navigator;
    private MenuManager _mm;
    
    @Override
    protected void init(VaadinRequest request) {
        
        getPage().setTitle("Apollo");
        
        _state = new State();
        
        _navigator = new Navigator(this, this);
        
        _mm = new MenuManager(_navigator);
        
        cmc = new ClientManagerController(_mm, _state);
        //ptc = new PublicTransportController(navigator, _state);
        
        // register all views
        _navigator.addView(MainMenu.VIEW_NAME, new MainMenu(cmc, ptc));
        _navigator.addView(ClientChooser.VIEW_NAME, new ClientChooser(cmc));
        _navigator.addView(ClientDetail.VIEW_NAME, new ClientDetail(cmc));
    }
}
