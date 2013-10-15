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
 * User: ioanna Date: 2013/10/06  21:13
 */
public class BattleshipsPlaygroundGUI {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          createAndShowGUI();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  private static void createAndShowGUI() throws IOException {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame guiFrame = new JFrame("*** BATTLESHIPS ***");
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    ContentPanel contentPanel = new ContentPanel();
    guiFrame.setContentPane(contentPanel);
    guiFrame.setSize(1000, 500);
    guiFrame.setVisible(true);
  }

  private static class ContentPanel extends JPanel {
    private BufferedImage image;

    public ContentPanel() throws IOException {
      super();
      getImage();
      this.setOpaque(true);
    }

    public void getImage() throws IOException {
      InputStream input =
              getClass().getResourceAsStream("/src/main/resources/images/schiffe_versenken-spielgrid.gif");
      image = ImageIO.read(input);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.drawImage(image, 0, 50, image.getWidth(), image.getHeight(), null);
      g.drawImage(image, image.getWidth() + 100, 50, image.getWidth(), image.getHeight(), null);

      String player = "Player ";
      g.setFont(new Font("Serif", Font.BOLD, 25));
      g.drawString(player + "1", image.getWidth() / 3, 35);
      g.drawString(player + "2", image.getWidth() + 100 + (image.getWidth() / 3), 35);
    }
  }
}
