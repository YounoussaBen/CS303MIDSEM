import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;


public class App extends JPanel {
    
    static int angle_degree = 0;

    public void paint(Graphics global){

        Graphics2D Graphics2D = (Graphics2D) global;

        Graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Graphics2D.setColor(Color.black);

        Graphics2D.fillRect(0, 0, getWidth(), getHeight());

        Font font =  new Font("bloomsburg",Font.CENTER_BASELINE,150);

        Graphics2D.setFont(font);  
        

        FontRenderContext font_render_context = Graphics2D.getFontRenderContext();

        TextLayout layout = new TextLayout("&", font, font_render_context);

        double s_width = layout.getBounds().getWidth();
        double s_height = layout.getBounds().getHeight();

        AffineTransform saveTransform = Graphics2D.getTransform();
        Graphics2D.setColor(Color.blue);
        Rectangle rectange = this.getBounds();

        Graphics2D.drawLine((int)(rectange.width)/2, 0, (int)(rectange.width)/2, rectange.height);
        Graphics2D.drawLine(0, (int)(rectange.height)/2, rectange.width, (int)(rectange.height)/2);
        
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToTranslation((rectange.width)/2, (rectange.height)/2);

        affineTransform.rotate(Math.toRadians(angle_degree), 0, 0);
        Graphics2D.setTransform(affineTransform);
        Graphics2D.drawString("&", (int)-s_width/2, (int)s_height/2);

        Graphics2D.setTransform(saveTransform);
        


}


public static void main(String[] args) throws InterruptedException {
    
    JFrame frame = new JFrame("Computer Graphics MidSem");
    
    App rotate = new App();
    
    frame.add(rotate);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    while(true){
        Thread.sleep(10);
        
            if(angle_degree >= 360){
            angle_degree = 0;
            } else {
            angle_degree += 5;
            }
        
        rotate.repaint();
        }

    }

}