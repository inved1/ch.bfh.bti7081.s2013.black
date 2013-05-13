/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author vill
 */
public class ClientChooser extends VerticalLayout implements View {
    public static final String VIEW_NAME = "clientChooser";
    
    private ClientManagerController _cmc;
    private ContentHelper _ch;
    
    public ClientChooser(ClientManagerController n) {
        
        setSpacing(false);
        setHeight("100%");
        
        _cmc = n;
        _ch = new ContentHelper(this, _cmc);
        _ch.drawHeaderMain();
        
        
        
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
        
        // Handle selection changes
        /*
        table.addListener(new Property.ValueChangeListener() {

            public void valueChange(ValueChangeEvent event) {
                if (event.getProperty().getValue() != null)
                    addComponent(new Label("Selected item id " +
                            event.getProperty().getValue().toString()));
                else // Item deselected
                    addComponent(new Label("Nothing selected"));
            }
        });
        */
        addComponent(table);
        setComponentAlignment(table, Alignment.TOP_LEFT);
        
        
        Button button = new Button("back");
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
