package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.model.Dict;
import ch.bfh.black.apollo.model.data.Client;
import ch.bfh.black.apollo.model.data.ClientHistory;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * All Client Detail Information are shown with its history.
 * 
 * @author Julien Villiger
 */

public class ClientDetail extends CssLayout implements View {  
    
    // unique name for this view
    public static final String VIEW_NAME = "clientDetail";

    private ClientManagerController _clientManagerController;
    private ContentHelper _contentHelper;
    
    private CssLayout _content;
    
    private Table _tableInfo;
    private Table _tableHistory;
    
    public ClientDetail(ClientManagerController clientManagerController) {
        
        setHeight("100%");
        
        _clientManagerController = clientManagerController;
        
        // init
        _contentHelper = new ContentHelper(this, _clientManagerController);
        _content = new CssLayout();
        
        // draw header
        _contentHelper.drawHeaderMain();
        
        // adjust layout
        _content.setStyleName("client-detail");
        _content.setWidth("100%");
        _content.setHeight("100%");
        addComponent(_content);
        
        // adjust table Info
        _tableInfo = new Table(Dict.CLIENT_DETAIL_TITLE);
        _tableInfo.addContainerProperty("Name", String.class, null);
        _tableInfo.addContainerProperty("Value", String.class, null);
        _tableInfo.setWidth("100%");
        _content.addComponent(_tableInfo);
        
        // adjust table history
        _tableHistory = new Table(Dict.CLIENT_DETAIL_HISTORY_TITLE);
        _tableHistory.addContainerProperty("Date", String.class, null);
        _tableHistory.addContainerProperty("Description", String.class, null);
        _tableHistory.setWidth("100%");
        _content.addComponent(_tableHistory);
        
        // create back button
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
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        try {
            Client c  = new Client(_clientManagerController.getState().clientId);
            
            // clear table info
            _tableInfo.removeAllItems();
            
            // adjust table info
            _tableInfo.addItem(new Object[]{"Name", c.getName1()}, 1);
            _tableInfo.addItem(new Object[]{"Street", c.getStreet()}, 2);
            _tableInfo.addItem(new Object[]{"ZIP, City", c.getZip() + " " + c.getCity()}, 3);
            _tableInfo.addItem(new Object[]{"Coutry", c.getCountry()}, 4);
            _tableInfo.setPageLength(6);
            
            // clear table history
            _tableHistory.removeAllItems();
            
            // adjust table history
            ArrayList<ClientHistory> lst = c.getClientHistory();
            for(ClientHistory ch:lst ){
                _tableHistory.addItem(new Object[]{ch.getTm().toString(), ch.getDescription()}, lst.indexOf(ch)+1);
            }
            _tableHistory.setPageLength(4);
            
            
        } catch (SQLException ex) {
            
        }
    }
    
    
}
