/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view.clientmanager;

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
    
    private Navigator _nav;
    
    public ClientChooser(Navigator n) {
        _nav = n;
        
        Label label = new Label("Choose Client");
        addComponent(label);
        
        Button button = new Button("SWEET");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                addComponent(new Label("Thank you for clicking, changed by julien."));
                
                _nav.navigateTo("");
            }
        });
        addComponent(button);
    }
    
    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Welcome to Client Chooser, CLIENT GOATNESS xD");
    }
    
}
