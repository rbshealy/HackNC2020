import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;

public class patriot {

  public static void main(String[] args) throws IOException {
    try {
      Robot rob = new Robot();
      Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
      BufferedImage picture = rob.createScreenCapture(screenRect);
      for (int i = 0; i < screenRect.getWidth(); i++) {
        for (int j = 0; j < screenRect.getHeight(); j++) {
          int p = picture.getRGB(i, j);
          Color color = new Color(p);
          int r = color.getRed();
          int b = color.getBlue();
          int g = color.getGreen();
          g = g + b + r;
          g = g / 3;

          Color colour = new Color(0, g, 0);


          picture.setRGB(i, j, colour.getRGB());
        }
      }

      JFrame f = new JFrame(); //creates jframe f

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this

      f.setUndecorated(true); //removes the surrounding border

      ImageIcon image = new ImageIcon(picture); //imports the image

      JLabel lbl = new JLabel(image); //puts the image into a jlabel

      f.getContentPane().add(lbl); //puts label inside the jframe

      f.setSize(image.getIconWidth(), image.getIconHeight()); //gets h and w of image and sets jframe to the size

      int x = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
      int y = (screenSize.height - f.getSize().height)/2;//of the center of the screen

      f.setLocation(x, y); //sets the location of the jframe
      f.setVisible(true); //makes the jframe visible

      Thread.sleep(10000);
      f.dispose();

    }
    catch (AWTException | InterruptedException ex) {  // | InterruptedException ex
      System.out.println(ex);
    }
  }
}