/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

/**
 *
 * @author vill
 */
//public class ClientChooser extends VerticalLayout implements View {
public class ClientChooser extends AbsoluteLayout implements View {
    public static final String VIEW_NAME = "clientChooser";
    
    private ClientManagerController _cmc;
    private ContentHelper _ch;
    
    public ClientChooser(ClientManagerController n) {
        
        //setSpacing(false);
        setHeight("100%");
        
        
        _cmc = n;
        _ch = new ContentHelper(this, _cmc);
        _ch.drawHeaderMain();
        
        setStyleName("client-chooser");
        
        // TABLE
        Table table = new Table("Clients");
        
        // Define two columns for the built-in container
        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Nr",  Integer.class, null);

        table.addItem(new Object[]{"Julien Villiger", 3333}, 1);
        table.addItem(new Object[]{"Daniel Inversini", 3184}, 2);
        table.addItem(new Object[]{"Fanky", 3648}, 3);
        table.addItem(new Object[]{"Fülli", 3009}, 4);
        table.addItem(new Object[]{"Mao Tse-Tung", 5938}, 5);

        // Show 5 rows
        table.setPageLength(5);
        table.setSelectable(true);
        table.setImmediate(true);
        table.setSizeFull();
        table.setStyleName("client-chooser-table");
        
        // Handle selection changes
       
        table.addValueChangeListener(new Property.ValueChangeListener() {
        
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                
                //Notification.show(event.getProperty().getValue().toString());
                
                
                _cmc.chooseClient(3);
            }
        });
        addComponent(table);
        
        
        Button button = new Button("back");
        button.addClickListener(new Button.ClickListener() {
            
            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                _cmc.back();
            }
        });
        addComponent(button);
        button.setStyleName("client-chooser-bt-back");
        
        
        _ch.drawFooter();
        
    }
    
    @Override
    public void enter(ViewChangeEvent event) {
        //Notification.show("Welcome to Client Chooser, CLIENT GOATNESS xD");
    }
    
}
