package gui.blocks;

import gui.interfaces.Block;
import gui.interfaces.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Header implements Block {

    private JPanel header;
    private final CustomField searchField;
    private final CustomField logoField;

    @Autowired
    public Header(CustomField searchField,
                  CustomField logoField) {
        header = new JPanel();

        this.logoField = logoField;
        this.searchField = searchField;

        header.setLayout(new GridLayout(1,2));

        //logoField.getComponent().setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        //searchField.getComponent().setAlignmentX(java.awt.Component.RIGHT_ALIGNMENT);


        //header.setMaximumSize(new Dimension(10000, 200));
        //header.setBackground(Color.getColor("#1C1918"));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));



        header.add(logoField.getComponent());
        header.add(searchField.getComponent());
    }

    @Override
    public JPanel getComponent() {
        return header;
    }


    @Override
    public void setSize(int width, int height) {
    }
}
