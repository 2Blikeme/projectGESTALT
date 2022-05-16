package app.gui.components.chunks;

import app.gui.cosmetic.MyFont;
import app.gui.interfaces.Chunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomButton implements Chunk {
    private JButton button;
    private String holder = "Search";
    private final MyFont font;

    public void setSize(int width, int height) {
        this.button.setPreferredSize(new Dimension(width, height));
    }

    public void setHolder(String holder) {
        this.holder = holder;
        button.setText(holder);
    }

    @Autowired
    public CustomButton(MyFont font) {
        button = new JButton();
        button.setText(holder);
        button.setFont(font.getFont());
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        this.font = font;
    }

    @Override
    public JComponent getComponent() {
        return button;
    }


    @Override
    public void setBorder(int top, int left, int bottom, int right, Color color) {
        button.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, color));
    }


    @Override
    public void setBackground(Color color) {
        button.setBackground(color);
    }


    @Override
    public void setForeground(Color color) {
        button.setForeground(color);
    }

}
