package SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class xButton extends JButton {

    private Color normalBackground = new Color(255, 165, 0); // Naranja claro
    private Color hoverBackground = Color.BLACK;
    private Color normalForeground = Color.BLACK;
    private Color hoverForeground = Color.WHITE;
    private Dimension size = new Dimension(215,60);
    public xButton(String text) {
        super(text);
        initialize();
    }
    
    public void Size(Dimension d){
      this.size = d;
      setPreferredSize(size);
    }

    private void initialize() {
        // Establecer las propiedades iniciales del botón
        setBackground(normalBackground);
        setForeground(normalForeground);
        setFont(new Font("SansSerif", Font.PLAIN, 15));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);
        setPreferredSize(size);
        setMinimumSize(size);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setHorizontalAlignment(SwingConstants.LEFT);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackground);
                setForeground(hoverForeground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalBackground);
                setForeground(normalForeground);
            }
        });
    }
}
