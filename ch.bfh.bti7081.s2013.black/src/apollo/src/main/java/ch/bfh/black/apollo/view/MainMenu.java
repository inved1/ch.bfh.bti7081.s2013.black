package ch.bfh.black.apollo.view;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.model.Dict;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

/**
* Main Menu View where all modules are selectable.
* Button Clicks are handled.
*
* @author Julien Villiger
*/

public class MainMenu extends CssLayout implements View {
    
    // unique name for this view
    public static final String VIEW_NAME = "";
    
    private ClientManagerController _clientManagerController;
    private ContentHelper _contentHelper;
    
    private CssLayout _content;
    
    public MainMenu(ClientManagerController clientManagerController) {
        
        _clientManagerController = clientManagerController;
        
        // init
        _contentHelper = new ContentHelper(this);
        _content = new CssLayout();
        Label title = new Label(Dict.MAIN_MENU_TITLE);
        
        // draw header
        _contentHelper.drawHeaderMain();
        
        // adjust layout
        _content.setStyleName("main-menu");
        _content.setWidth("100%");
        addComponent(_content);
        
        // set title of view
        _content.addComponent(title);
        title.setStyleName("main-menu-title");
        
        // generate Client Manager button
        Button btClientManager = new Button(Dict.MAIN_MENU_CM, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                _clientManagerController.init();
            }
        });
        _content.addComponent(btClientManager);
        btClientManager.setStyleName("main-menu-bt");
        
        
        // generate Feature 2 button
        Button btPublicTransport = new Button(Dict.MAIN_MENU_PT, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                // nothing
            }
        });
        _content.addComponent(btPublicTransport);
        btPublicTransport.setStyleName("main-menu-bt");
        
        
        // generate Feature 3 button
        Button btXX = new Button(Dict.MAIN_MENU_XX, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                // nothing
            }
        });
        _content.addComponent(btXX);
        btXX.setStyleName("main-menu-bt");
        
        
        // generate Feature 4 button
        Button btYY = new Button(Dict.MAIN_MENU_YY, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                // nothing
            }
        });
        _content.addComponent(btYY);
        btYY.setStyleName("main-menu-bt");
        
        // draw footer
        _contentHelper.drawFooter();
    }        
        
    @Override
    public void enter(ViewChangeEvent event) {
    }
}
