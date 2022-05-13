package gui;

import gui.cosmetic.MyFont;
import gui.interfaces.Block;
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


    @Autowired
    public MainWindow(Block header, MyFont font) throws IOException {
        mainWindow = new JFrame();
        mainWindow.setFont(new Font("Ubuntu", Font.PLAIN, 16));

        this.header = header;

        JPanel tmp1 = new JPanel();
        JPanel tmp4 = new JPanel();


        tmp1.setBackground(Color.decode("#718e72"));
        tmp4.setBackground(Color.decode("#2a2a2a"));



        mainWindow.add(header.getComponent(), BorderLayout.NORTH);
        mainWindow.add(tmp1, BorderLayout.SOUTH);
        mainWindow.add(tmp4, BorderLayout.CENTER);


        mainWindow.setTitle(name);
        mainWindow.setPreferredSize(new Dimension(WindowWidth, WindowHeight));
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
        this.font = font;
    }

}
