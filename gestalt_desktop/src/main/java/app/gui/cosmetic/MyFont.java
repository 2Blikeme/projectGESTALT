package app.gui.cosmetic;

import org.springframework.stereotype.Component;
import java.awt.*;

@Component
public class MyFont {

    private Font font;
    private final String fontName = "Ubuntu";
    private final int fontSize = 24;


    public MyFont() {
        font = new Font(fontName, Font.PLAIN, fontSize);
    }


    public Font getFont() {
        return font;
    }
}
