/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vill
 */
//public class ClientDetail extends AbsoluteLayout implements View {
public class ClientDetail extends CssLayout implements View {    
    public static final String VIEW_NAME = "clientDetail";

    private ClientManagerController _cmc;
    private ContentHelper _ch;
    
    private CssLayout _content;
    
    private Table _tInfo;
    private Table _tHistory;
    
    public ClientDetail(ClientManagerController n) {
        _cmc = n;
        
        _ch = new ContentHelper(this, _cmc);
        _ch.drawHeaderMain();
        
        _content = new CssLayout();
        _content.setStyleName("client-detail");
        _content.setWidth("100%");
        _content.setHeight("100%");
        addComponent(_content);
        
        // table Info
        _tInfo = new Table(Dict.CLIENT_DETAIL_TITLE);
        _tInfo.addContainerProperty("Name", String.class, null);
        _tInfo.addContainerProperty("Nr", String.class, null);
        _tInfo.setWidth("100%");
        _content.addComponent(_tInfo);
        
        
        _tHistory = new Table(Dict.CLIENT_DETAIL_HISTORY_TITLE);
        _tHistory.addContainerProperty("Date", String.class, null);
        _tHistory.addContainerProperty("Description", String.class, null);
        _tHistory.setWidth("100%");
        _content.addComponent(_tHistory);
        
        
        Button button = new Button("back");
        button.setStyleName("button-back");
        button.addClickListener(new Button.ClickListener() {

                @Override
                public void buttonClick(Button.ClickEvent event) {

                    _cmc.back();
                }
            });
        _content.addComponent(button);
        
        _ch.drawFooter();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            Client c  = new Client(_cmc.getState().clientId);
            
            //clear table
            _tInfo.removeAllItems();
            _tInfo.addItem(new Object[]{"Name", c.getName1()}, 1);
            _tInfo.addItem(new Object[]{"Street", c.getStreet()}, 2);
            _tInfo.setPageLength(6);
            
            _tHistory.removeAllItems();
            ArrayList<ClientHistory> lst = c.getClientHistory();
            for(ClientHistory ch:lst ){
                _tHistory.addItem(new Object[]{ch.getTm().toString(),ch.getDescription()},lst.indexOf(ch)+1);
            }
                    
            //_tHistory.addItem(new Object[]{"12.03.1996", "Beschneidung."}, 1);
            //_tHistory.addItem(new Object[]{"09.05.1997", "Geschlechtsumwandlung."}, 2);
            _tHistory.setPageLength(4);
            
            
        } catch (SQLException ex) {
            
        }
    }
    
    
}
