package main.java.playgrid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * JavaDoc
 * <p/>
 * User: ioanna Date: 2013/10/01  21:12
 */
public class BattleshipsPlaygroundGUI {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        createAndShowGUI();
      }
    });

  }

  private static void createAndShowGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame guiFrame = new JFrame("***BATTLESHIPS***");
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    BattleshipsPanel battleshipsPanel = new BattleshipsPanel();
    battleshipsPanel.setBackground(Color.LIGHT_GRAY);
    int width = battleshipsPanel.getImageWidth();
    int height = battleshipsPanel.getImageHeight();

    guiFrame.setContentPane(battleshipsPanel);
    guiFrame.setSize(width, height);
    guiFrame.setVisible(true);
  }

  private static class BattleshipsPanel extends JPanel {
    private BufferedImage image;

    public BattleshipsPanel() {
      try {
        InputStream input =
                getClass().getResourceAsStream("/src/main/resources/images/schiffe_versenken-spielgrid.gif");
        image = ImageIO.read(input);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Dimension dimension = getSize();
      g.drawImage(image, 0, 0, dimension.width, dimension.height, null);
    }

    private int getImageWidth() {
      return image.getWidth();
    }

    private int getImageHeight() {
      return image.getHeight();
    }
  }
}
