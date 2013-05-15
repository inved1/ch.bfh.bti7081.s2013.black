/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.model.data.Client;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Notification;
import java.sql.SQLException;

/**
 *
 * @author vill
 */
public class ClientDetail extends AbsoluteLayout implements View {
    public static final String VIEW_NAME = "clientDetail";

    private ClientManagerController _cmc;
    private ContentHelper _ch;
    
    public ClientDetail(ClientManagerController n) {
        _cmc = n;
        
        _ch = new ContentHelper(this, _cmc);
        _ch.drawHeaderMain();
        
        _ch.drawFooter();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            Client c  = new Client(_cmc.getState().clientId);
            
            Notification.show(c.getName1());
            
        } catch (SQLException ex) {
            
        }
    }
    
    
}
