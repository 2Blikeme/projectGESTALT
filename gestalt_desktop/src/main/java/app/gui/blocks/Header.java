package app.gui.blocks;

import app.gui.interfaces.Block;
import app.gui.interfaces.CustomField;
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


        setBorder(0, 0, 1, 0, Color.BLACK);



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


    @Override
    public void setBorder(int top, int left, int bottom, int right, Color color) {
        header.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, color));
    }


    @Override
    public void setBackground(Color color) {
        header.setBackground(color);
    }
}
