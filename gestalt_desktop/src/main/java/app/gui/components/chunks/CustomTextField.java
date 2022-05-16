package app.gui.components.chunks;

import app.gui.cosmetic.MyFont;
import app.gui.interfaces.Chunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


@Component
public class CustomTextField implements Chunk {
    private JTextField textField;
    private String placeholder = "Song name or artist";
    private final MyFont font;
    @Autowired
    public CustomTextField(MyFont font) {
        textField = new JTextField();
        textField.setText(placeholder);
        textField.setFont(font.getFont());
        initFindField();
        this.font = font;
    }

    private void initFindField() {
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    @Override
    public JComponent getComponent() {
        return textField;
    }

    @Override
    public void setSize(int width, int height) {
        this.textField.setPreferredSize(new Dimension(width, height));
    }


    @Override
    public void setBorder(int top, int left, int bottom, int right, Color color) {
        textField.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, color));
    }


    @Override
    public void setBackground(Color color) {
        textField.setBackground(color);
    }


    @Override
    public void setForeground(Color color) {
        textField.setForeground(color);
    }
}
