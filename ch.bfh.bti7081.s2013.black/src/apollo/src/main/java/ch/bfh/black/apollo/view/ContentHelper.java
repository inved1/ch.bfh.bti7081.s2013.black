/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.black.apollo.view;

import ch.bfh.black.apollo.controller.Controller;
import ch.bfh.black.apollo.model.Dict;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Reindeer;

/**
 *
 * @author vill
 */
public class ContentHelper {
    
    private AbstractLayout _layout;
    private Controller _controller;
    
    public ContentHelper(AbstractLayout l) {
        
        _layout = l;
        _layout.setSizeFull();
    }
    
    public ContentHelper(AbstractLayout l, Controller c) {
        
        this(l);
        
        _controller = c;
    }
    
    public void drawHeaderMain() {
        
        HorizontalLayout header = new HorizontalLayout();
        header.setStyleName("header-main");
        header.setWidth("100%");
        
        Label title = new Label(Dict.HEADER_MAIN_TITLE);
        title.setStyleName("header-main-title");
        header.addComponent(title);
        
        _layout.addComponent(header);
        
        
    }
    
    /*
    public void drawHeaderNav() {
        
        HorizontalLayout header = new HorizontalLayout();
        header.setStyleName("header-nav");

        Button back = new Button("back button", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                _controller.navigateBack();
            }
        });
        //back.setStyleName("header-nav-bt-back");
        header.addComponent(back);
        
        _layout.addComponent(header);
    }
    */
    
    /*
    private void navigateBack() {
        
        
    }
    */
    
    public void drawFooter() {
        
        HorizontalLayout f = new HorizontalLayout();
        _layout.addComponent(f);
        
        Label date = new Label(Dict.DATE);
        date.setStyleName("main-footer-date");
        
        Label group = new Label(Dict.GROUP_NAME);
        group.setStyleName("main-footer-group");
        
        f.addComponent(date);
        f.addComponent(group);
        f.setStyleName("main-footer");
    }
}
