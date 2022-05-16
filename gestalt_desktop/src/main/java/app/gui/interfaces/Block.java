package app.gui.interfaces;

import java.awt.*;

public interface Block extends CustomComponent {

    void setBorder(int top, int left, int bottom, int right, Color color);
    void setBackground(Color color);

}
