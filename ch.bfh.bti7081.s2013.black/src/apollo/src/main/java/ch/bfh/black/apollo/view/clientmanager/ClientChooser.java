/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author vill
 */
public class ClientChooser extends VerticalLayout implements View {
    public static final String VIEW_NAME = "viewNameClientChooser";
    
    private ClientManagerController _cmc;
    private ContentHelper _ch;
    
    public ClientChooser(ClientManagerController n) {
        _cmc = n;
        _ch = new ContentHelper(this);
        
        Label label = new Label("Choose Client");
        addComponent(label);
        
        Button button = new Button("SWEET");
        button.addClickListener(new Button.ClickListener() {
            
            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                _cmc.chooseClient();
            }
        });
        addComponent(button);
        
        _ch.drawFooter();
        
    }
    
    @Override
    public void enter(ViewChangeEvent event) {
        //Notification.show("Welcome to Client Chooser, CLIENT GOATNESS xD");
    }
    
}
