package app.gui;

import app.gui.cosmetic.MyFont;
import app.gui.interfaces.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


@Component
public class MainWindow {

    private JFrame mainWindow;
    private static final String name = "Gestalt";
    private static final int WindowWidth = 1300;
    private static final int WindowHeight = 960;

    private final MyFont font;

    private final Block header;
    private final Block body;


    @Autowired
    public MainWindow(Block header, MyFont font, Block body) throws IOException {
        mainWindow = new JFrame();
        mainWindow.setFont(new Font("Ubuntu", Font.PLAIN, 16));

        this.header = header;
        this.font = font;
        this.body = body;

        JPanel tmp1 = new JPanel();



        tmp1.setBackground(Color.decode("#718e72"));
        tmp1.setPreferredSize(new Dimension(2000, 100));



        body.setBackground(Color.decode("#2a2a2a"));



        mainWindow.add(header.getComponent(), BorderLayout.NORTH);

        //Заглушки#########################################################
        mainWindow.add(tmp1, BorderLayout.SOUTH);
        mainWindow.add(new JLabel ("LeftBar" ), BorderLayout.WEST);
        mainWindow.add(new JLabel ("RightBar"), BorderLayout.EAST);
        //#################################################################


        mainWindow.add(body.getComponent(), BorderLayout.CENTER);
        mainWindow.setTitle(name);
        mainWindow.setPreferredSize(new Dimension(WindowWidth, WindowHeight));
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);

    }

}
