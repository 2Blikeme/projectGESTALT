package gui.components.fields;

import gui.interfaces.Chunk;
import gui.interfaces.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class SearchField implements CustomField {

    private int width = 130;
    private int height = 35;
    private JPanel searchPanel;
    private final Chunk findField;
    private final Chunk searchButton;
    @Autowired
    public SearchField(@Qualifier("customButton") Chunk searchButton,
                       @Qualifier("customTextField") Chunk findField) {
        searchPanel = new JPanel();
        this.searchButton = searchButton;
        this.findField = findField;


        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(findField.getComponent());
        searchPanel.add(searchButton.getComponent());
        searchPanel.setBackground(Color.decode("#222222"));


        findField.setSize(width * 2,height);
        findField.setBackground(Color.decode("#444444"));
        findField.setBorder(1, 1, 1, 1, Color.BLACK);


        searchButton.setSize(width, height);
        searchButton.setBackground(Color.decode("#444444"));
    }

    @Override
    public JComponent getComponent() {
        return searchPanel;
    }


    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

//
//    @Override
//    public void setBackground(Color color) {
//        searchPanel.setBackground(color);
//    }
}
