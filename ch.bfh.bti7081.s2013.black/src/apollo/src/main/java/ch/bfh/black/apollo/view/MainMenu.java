/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.controller.publictransport.PublicTransportController;
import ch.bfh.black.apollo.model.Dict;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author vill
 */
public class MainMenu extends CssLayout implements View {
    public static final String VIEW_NAME = "";
    
    private ClientManagerController _cmc;
    private PublicTransportController _ptc;
    private ContentHelper _ch;
    
    public MainMenu(ClientManagerController cmc, PublicTransportController ptc) {
        _cmc = cmc;
        _ptc = ptc;
        
        _ch = new ContentHelper(this);
        _ch.drawHeaderMain();
        
        Label title = new Label(Dict.MAIN_MENU_TITLE);
        
        addComponent(title);
        title.setStyleName("main-menu-title");
        //setComponentAlignment(title, Alignment.TOP_CENTER);
        
        
        // Client Manager
        Button btClientManager = new Button(Dict.MAIN_MENU_CM, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                _cmc.clientManagerInit();
            }
        });
        addComponent(btClientManager);
        btClientManager.setStyleName("main-menu-bt");
        //setComponentAlignment(btClientManager, Alignment.TOP_LEFT);
        
        
        // Public Transport
        Button btPublicTransport = new Button(Dict.MAIN_MENU_PT, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                _ptc.publicTransportInit();
            }
        });
        addComponent(btPublicTransport);
        btPublicTransport.setStyleName("main-menu-bt");
        //setComponentAlignment(btPublicTransport, Alignment.TOP_LEFT);
        
        
        // XX
        Button btXX = new Button(Dict.MAIN_MENU_XX, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                
            }
        });
        addComponent(btXX);
        btXX.setStyleName("main-menu-bt");
        //setComponentAlignment(btXX, Alignment.TOP_LEFT);
        
        
        // YY
        Button btYY = new Button(Dict.MAIN_MENU_YY, new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                
            }
        });
        addComponent(btYY);
        btYY.setStyleName("main-menu-bt");
        //setComponentAlignment(btYY, Alignment.TOP_LEFT);
        
        
        _ch.drawFooter();
    }        
        
    @Override
    public void enter(ViewChangeEvent event) {
        //Notification.show("Yeah, StartView, GOATNESS :D");
    }
}
