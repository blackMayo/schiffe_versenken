package main.java.playgrid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        createAndShowGUI();
      }
    });

  }

  private static void createAndShowGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame guiFrame = new JFrame("*** BATTLESHIPS ***");
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    ContentPanel contentPanel = new ContentPanel(new BorderLayout());
    if (contentPanel != null) {
      guiFrame.setContentPane(contentPanel);
    }
    guiFrame.setSize(1000, 500);
    guiFrame.setVisible(true);
  }

  private static class ContentPanel extends JPanel {
    public ContentPanel(BorderLayout borderLayout) {
      super(borderLayout);
      this.setLayout(new GridLayout(1, 2));
      this.setOpaque(true);
      addImagesToContentPanel();
    }

    private void addImagesToContentPanel() {
      this.add(new BattleshipsPanel(), BorderLayout.WEST);
      this.add(new BattleshipsPanel(), BorderLayout.EAST);
    }
  }

  private static class BattleshipsPanel extends JPanel {

    private BufferedImage image;
    private final MouseListener mouseListener;

    private BattleshipsPanel() {
      try {
        getImage();
        mouseListener = getMouseListener(this);
        this.addMouseListener(mouseListener);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public void getImage() throws IOException {
      InputStream input =
              getClass().getResourceAsStream("/src/main/resources/images/schiffe_versenken-spielgrid.gif");
      image = ImageIO.read(input);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Dimension dimension = getSize();
      g.drawImage(image, 0, 0, dimension.width, dimension.height, null);
    }

    private MouseListener getMouseListener(final BattleshipsPanel battleshipsPanel) {
      return new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          battleshipsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        }

        @Override
        public void mouseExited(MouseEvent e) {
          battleshipsPanel.setBorder(BorderFactory.createEmptyBorder());
        }
      };
    }
  }
}
