package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.model.Dict;
import ch.bfh.black.apollo.model.data.Client;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A list of all clients is generated.
 * Client can be chosen to switch to client detail view.
 * 
 * @author Julien Villiger
 */

public class ClientChooser extends CssLayout implements View {
    
    // unique name for this view
    public static final String VIEW_NAME = "clientChooser";
    
    private ClientManagerController _clientManagerController;
    private ContentHelper _contentHelper;
    
    private CssLayout _content;
    
    public ClientChooser(ClientManagerController clientManagerController) {
        
        setHeight("100%");
        
        _clientManagerController = clientManagerController;
        
        // init
        _contentHelper = new ContentHelper(this, _clientManagerController);
        _content = new CssLayout();
        Table table = new Table(Dict.CLIENT_CHOOSER_TITLE);
        
        // draw header
        _contentHelper.drawHeaderMain();
        
        // adjust layout
        _content.setStyleName("client-chooser");
        _content.setWidth("100%");
        addComponent(_content);
        
        // adjust table
        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Nr",  Integer.class, null);
        table.setPageLength(14);
        table.setSelectable(true);
        table.setImmediate(true);
        table.setWidth("100%");
        
        // establish db connection
        try {
            
            Client c = new Client();
            ArrayList<Client> lst = Client.listAll();
            System.out.println(lst.toString());
            
            // fill up table with clients
            for(Client cl: lst){
                table.addItem(new Object[]{cl.getName1(),cl.getClientID()},lst.indexOf(cl)+1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        // Handle selection changes
        table.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                _clientManagerController.chooseClient((Integer)event.getProperty().getValue());

            }
        });
        _content.addComponent(table);
        
        // create back button and add listener
        Button button = new Button("back");
        button.setStyleName("button-back");
        button.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {

                _clientManagerController.back();
            }
        });
        _content.addComponent(button);
        
        // draw footer
        _contentHelper.drawFooter();
    }
    
    @Override
    public void enter(ViewChangeEvent event) {
    }
    
}
