package ch.bfh.black.apollo;

import ch.bfh.black.apollo.view.StartView;
import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    Navigator navigator;
    protected static final String MAINVIEW = "main";
    
    @Override
    protected void init(VaadinRequest request) {
        
        getPage().setTitle("Apollo");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        navigator.addView(StartView.VIEW_NAME, new StartView(navigator));
        navigator.addView(ClientChooser.VIEW_NAME, new ClientChooser(navigator));
    }
    
    
    
}
