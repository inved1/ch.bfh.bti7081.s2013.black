/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view;

import ch.bfh.black.apollo.view.clientmanager.ClientChooser;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author vill
 */
public class StartView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";
    
    private Navigator _nav;
    
    public StartView(Navigator n) {
        _nav = n;
        
        setSizeFull();
        
        Label label = new Label("StartView");
        addComponent(label);

        Button button = new Button("Go to Main View", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show("clicked, fick ja");
                
                _nav.navigateTo(ClientChooser.VIEW_NAME);
            }
        });
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }        
        
    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Yeah, StartView, GOATNESS :D");
    }
}
