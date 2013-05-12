/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view;

import ch.bfh.black.apollo.model.Dict;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author vill
 */
public class ContentHelper {
    
    private AbstractLayout _layout;
    
    public ContentHelper(AbstractLayout l) {
        
        _layout = l;
        _layout.setSizeFull();
    }
    
    public void drawHeaderMain() {
        
        HorizontalLayout header = new HorizontalLayout();
        header.setStyleName("header-main");
        
        Label title = new Label(Dict.HEADER_MAIN_TITLE);
        title.setStyleName("header-main-title");
        
        _layout.addComponent(header);
        header.addComponent(title);
        
    }
    
    public void drawHeader() {
        
        
    }
    
    public void drawFooter() {
        
        HorizontalLayout f = new HorizontalLayout();
        _layout.addComponent(f);
        f.addComponent(new Label("footer"));
        f.setStyleName("main-footer");
        //_layout.setComponentAlignment(f, Alignment.BOTTOM_LEFT);
    }
}
