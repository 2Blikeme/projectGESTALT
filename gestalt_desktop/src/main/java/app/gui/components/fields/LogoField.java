package app.gui.components.fields;

import app.gui.cosmetic.MyFont;
import app.gui.interfaces.CustomField;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class LogoField implements CustomField {

    private JPanel logoPanel;
    private final String name = "Project Gestalt";
    private MyFont font;

    // TODO: 13.05.2022 убрать это в бдшку
    private final static String logoPath = "/home/gestalt/Github/projectGESTALT/gestalt_desktop/src/main/resources/img/logo_white.png";



    public LogoField(MyFont font) {
        logoPanel = new JPanel();

        // добавление картинки
        ImageIcon picImage = new ImageIcon(new ImageIcon(logoPath)
                .getImage()
                .getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        JLabel picLabel = new JLabel(picImage);
        picLabel.setText(name);

        picLabel.setForeground(Color.WHITE);
        picLabel.setFont(font.getFont());

        logoPanel.setBackground(Color.decode("#222222"));
        logoPanel.add(picLabel);
    }

    @Override
    public JComponent getComponent() {
        return logoPanel;
    }


    @Override
    public void setSize(int width, int height) {

    }
}
