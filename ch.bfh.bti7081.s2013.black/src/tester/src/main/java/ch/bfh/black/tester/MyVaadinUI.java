package ch.bfh.black.tester;

import com.vaadin.event.FieldEvents;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

     @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Click Me, Dani rockt");
        final TextField txt = new TextField("Text");
        Button btn2 = new Button("Add Text From txtField");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(txt);
        layout.addComponent(btn2);
                
        layout.addComponent(button);
        
        btn2.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
               layout.addComponent(new Label("Text from txtField: [" + txt.getValue() + "]"));
               
            }
        });
        txt.setMaxLength(50);
        txt.addTextChangeListener(new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                layout.addComponent(new Label(event.getText()));
            }
        });
     }

}
