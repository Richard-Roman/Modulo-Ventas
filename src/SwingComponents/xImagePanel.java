
package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Richard Roman
 */
public class xImagePanel extends JPanel {
    
    private Icon imag;
    private final String ruta;
    
    public Icon getIcon() {
        return imag;
    }

    public void setRuta(Icon newIcon) {
        this.imag = newIcon;
    }
    
    public xImagePanel(String ruta){
        
        setBackground(new Color(0, 0, 0, 0));
        //setForeground(Color.decode("#7A8C8D"));
        this.ruta = ruta;
        setOpaque(false);
        setBorder(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        ImageIcon img = new ImageIcon(getClass().getResource(ruta));
        g.drawImage(img.getImage(), 0, 0,width,height, null);
        super.paintComponent(g);
    }

}
