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
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides Input-Fields to add a new client history entry.
 * 
 * @author Julien Villiger
 */
public class AddClientHistory extends CssLayout implements View {
    
    // unique name for this view
    public static final String VIEW_NAME = "addClientHistory";
    
    private ClientManagerController _clientManagerController;
    private ContentHelper _contentHelper;
    
    private CssLayout _content;
    private PopupDateField _datefield;
    private TextArea _textinput;
    private boolean _inputIsCorrect = false;
    
    private Date _inputDate;
    private String _inputComment;
    
    public AddClientHistory(ClientManagerController clientManagerController) {
        
        setHeight("100%");
        
        _clientManagerController = clientManagerController;
        
        // init
        _contentHelper = new ContentHelper(this, _clientManagerController);
        _content = new CssLayout();
        
        // draw header
        _contentHelper.drawHeaderMain();
        
        // adjust layout
        _content.setStyleName("client-chooser");
        _content.setWidth("100%");
        addComponent(_content);
        
        // set title of view
        Label title = new Label(Dict.ADD_CLIENT_HISTORY_TITLE);
        title.setStyleName("main-menu-title");
        _content.addComponent(title);
        
        // set title of date input
        Label titleDateInput = new Label(Dict.ADD_CLIENT_HISTORY_DATE_TITLE);
        titleDateInput.setStyleName("add-client-history-date-title");
        _content.addComponent(titleDateInput);
        
        // Create a DateField with the default style.
        _datefield = new PopupDateField() {
            
            @Override
            protected Date handleUnparsableDateString(String dateString) throws com.vaadin.data.Property.ReadOnlyException {
                
                Notification.show(Dict.DATE_NOT_CORRECT, Notification.Type.ERROR_MESSAGE);
                
                _inputIsCorrect = false;
                
                //throw new com.vaadin.data.Property.ReadOnlyException("Not a number");
                
                return new Date();
                //return null;
            }
            
        };

        // Set the date and time to present.
        _datefield.setValue(new Date());
        _datefield.setResolution(DateField.RESOLUTION_DAY);
        _datefield.setStyleName("date-input");
        _datefield.setDateFormat("dd.MM.yyyy");
        _datefield.setStyleName("date-input");
        _content.addComponent(_datefield);
        
        // set title of text input
        Label titleTextInput = new Label(Dict.ADD_CLIENT_HISTORY_TEXT_TITLE);
        titleTextInput.setStyleName("add-client-history-text-title");
        _content.addComponent(titleTextInput);
        
        // create textinput
        _textinput = new TextArea("");
        _textinput.setRows(8);
        _textinput.setStyleName("textarea-comment");
        _content.addComponent(_textinput);
        
        
        // create button to add history entry
        Button buttonAdHistory = new Button("add");
        buttonAdHistory.setStyleName("button-back");
        buttonAdHistory.setStyleName("button-add-client-history");
        buttonAdHistory.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                //_inputIsCorrect = true;
                
                try{
                    _inputDate = _datefield.getValue(); 
                } catch(Exception e) {
                    Notification.show("yeah yeah yeah");
                }
               
                _inputComment = _textinput.getValue();
                
                createEntry();
            }
        });
        _content.addComponent(buttonAdHistory);
        
        
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
    
    private void createEntry() {
        try {
            /*
            if(_inputIsCorrect) {
                Notification.show("save in DB now");
            }
            */
            
            //Notification.show(_inputComment);
            //Notification.show(_inputDate.toString());
            //Notification.show(String.valueOf(_clientManagerController.getState().clientId));
            Client c =  new Client(_clientManagerController.getState().clientId);
            ClientHistory ch = new ClientHistory();
            ch.setDescription(_inputComment);
            ch.setClientID(_clientManagerController.getState().clientId);
            ch.save();
            c.addHistory(ch);
            ch.save();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddClientHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AddClientHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
    }
    
}
