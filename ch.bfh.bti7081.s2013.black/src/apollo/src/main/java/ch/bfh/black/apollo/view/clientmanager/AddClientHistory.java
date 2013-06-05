/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view.clientmanager;

import ch.bfh.black.apollo.controller.clientmanager.ClientManagerController;
import ch.bfh.black.apollo.model.Dict;
import ch.bfh.black.apollo.view.ContentHelper;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import java.util.Date;

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
        PopupDateField date = new PopupDateField();

        // Set the date and time to present.
        date.setValue(new Date());
        date.setResolution(DateField.RESOLUTION_DAY);
        date.setStyleName("date-input");
        _content.addComponent(date);
        
        // set title of text input
        Label titleTextInput = new Label(Dict.ADD_CLIENT_HISTORY_TEXT_TITLE);
        titleTextInput.setStyleName("add-client-history-text-title");
        _content.addComponent(titleTextInput);
        
        
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
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
    }
    
}
