/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
* Main Menu View where several modules are selectable.
* Button Clicks are handled.
* 
*
* @author Julien Villiger
* 
*/

public class MainMenu extends CssLayout implements View {
    public static final String VIEW_NAME = "";
    
    private ClientManagerController _cmc;
    private ContentHelper _ch;
    
    private CssLayout _content;
    
    public MainMenu(ClientManagerController cmc) {
        
        _cmc = cmc;
        
        _ch = new ContentHelper(this);
        _ch.drawHeaderMain();
        
        _content = new CssLayout();
        _content.setStyleName("main-menu");
        _content.setWidth("100%");
        addComponent(_content);
        
        Label title = new Label(Dict.MAIN_MENU_TITLE);
        
        _content.addComponent(title);
        title.setStyleName("main-menu-title");
        //setComponentAlignment(title, Alignment.TOP_CENTER);
        
        
        // Client Manager
        Button btClientManager = new Button(Dict.MAIN_MENU_CM, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                _cmc.init();
            }
        });
        _content.addComponent(btClientManager);
        btClientManager.setStyleName("main-menu-bt");
        //setComponentAlignment(btClientManager, Alignment.TOP_LEFT);
        
        
        // Public Transport
        Button btPublicTransport = new Button(Dict.MAIN_MENU_PT, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            }
        });
        _content.addComponent(btPublicTransport);
        btPublicTransport.setStyleName("main-menu-bt");
        //setComponentAlignment(btPublicTransport, Alignment.TOP_LEFT);
        
        
        // XX
        Button btXX = new Button(Dict.MAIN_MENU_XX, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                
            }
        });
        _content.addComponent(btXX);
        btXX.setStyleName("main-menu-bt");
        //setComponentAlignment(btXX, Alignment.TOP_LEFT);
        
        
        // YY
        Button btYY = new Button(Dict.MAIN_MENU_YY, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                
            }
        });
        _content.addComponent(btYY);
        btYY.setStyleName("main-menu-bt");
        //setComponentAlignment(btYY, Alignment.TOP_LEFT);
        
        
        _ch.drawFooter();
    }        
        
    @Override
    public void enter(ViewChangeEvent event) {
        //Notification.show("Yeah, StartView, GOATNESS :D");
    }
}
