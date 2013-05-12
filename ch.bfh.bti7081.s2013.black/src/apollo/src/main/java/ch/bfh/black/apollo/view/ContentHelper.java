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
import com.vaadin.ui.Notification;

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
        
        Label title = new Label(Dict.HEADER_MAIN_TITLE);
        title.setStyleName("header-main-title");
        
        _layout.addComponent(header);
        header.addComponent(title);
        
    }
    
    public void drawHeaderNav() {
        
        HorizontalLayout header = new HorizontalLayout();
        header.setStyleName("header-nav");

        Button back = new Button("", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                // FIXME wieso nur final hier?????? müsste dynamisch sein verdammt
                //_controller.navigateToGeneral(MainMenu.VIEW_NAME);
                
                //navigateBack();
                
                _controller.navigateBack();
            }
        });
        back.setStyleName("header-nav-bt-back");
        header.addComponent(back);
        
        /*Embedded e = new Embedded("Goat", new ThemeResource("img/goat.jpg"));
        header.addComponent(e);*/
        
        _layout.addComponent(header);
    }
    
    private void navigateBack() {
        
        
    }
    
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
        //_layout.setComponentAlignment(f, Alignment.BOTTOM_LEFT);
    }
}
