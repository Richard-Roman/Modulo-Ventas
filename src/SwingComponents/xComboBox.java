package SwingComponents;
import javax.swing.*;
import java.awt.*;

public class xComboBox extends JPanel{
   private Dimension xAllSize, xLabelSize, xComboSize;
   private String xLabelText, xComboValores[];
   private JLabel xLabel;
   private JComboBox<String> xCombo;
   
   public xComboBox(String LabelText, String valores[]){
      super(new FlowLayout(FlowLayout.LEFT,10,0));
      xComboValores = valores;
      xLabelText = LabelText;
      init();
      componetes();  
   }
   
   private void init(){
      setAllSize(new Dimension(340,24));
      setBackground(Color.white);
   }
   
   private void componetes(){
      addLabel();
      addComboBox();
   }
   
   private void addLabel(){
      xLabel = new JLabel(xLabelText);
      setLabelSize(new Dimension(150,24));
      add(xLabel);
   }
   
   private void addComboBox(){
      xCombo = new JComboBox<>(xComboValores);
      setComboSize(new Dimension(150,24));
      xCombo.setBackground(Color.white);
      xCombo.setRenderer(
         new DefaultListCellRenderer() {
            @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
               Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    
                    // Establecer el color de selección
               if (isSelected) {
                  renderer.setBackground(new Color(227, 227, 227));
                  renderer.setForeground(Color.BLACK); // Cambiar el color del texto si es necesario
               } else {
                  renderer.setBackground(Color.WHITE);
                  renderer.setForeground(Color.BLACK);
               }
               return renderer;
            }
         });
   
            // Obtener el ListCellRenderer actual del JComboBox
      ListCellRenderer<? super String> renderer = xCombo.getRenderer();
      add(xCombo);
   }
   
   public void setAllSize(Dimension allSize){
      xAllSize = allSize;
      setPreferredSize(xAllSize);
      setSize(xAllSize);
   }
   
   public Dimension getAllSize() {
      return xAllSize;
   }

    // Getters y Setters para xLabelSize
   public Dimension getLabelSize() {
      xLabelSize = xLabel.getPreferredSize();
      return xLabelSize;
   }

   public void setLabelSize(Dimension LabelSize) {
      this.xLabelSize = LabelSize;
      xLabel.setPreferredSize(xLabelSize);
   }

    // Getters y Setters para xFieldSize
   public Dimension getComboSize() {
      xComboSize =xCombo.getPreferredSize();
      return  xComboSize;
   }

   public void setComboSize(Dimension ComboSize) {
      this.xComboSize = ComboSize;
      xCombo.setPreferredSize(xComboSize);
   }

    // Getters y Setters para xLabelText
   public String getLabelText() {
      xLabelText = xLabel.getText();
      return xLabelText;
   }

   public void setLabelText(String labelText) {
      this.xLabelText = labelText;
      xLabel.setText(xLabelText);
   }

    // Getters y Setters para xFieldText
   public String getComboSelectedValue() {
      return (String) xCombo.getSelectedItem();
   }

   public void setComboSelectedValu(int index) {
      xCombo.setSelectedIndex(index);
   }
   
   
   public static void main(String[] args) {
      JFrame frame = new JFrame("XCampo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 600);
      xComboBox x = new xComboBox("Hola mundo", new String[]{"Vendedor1", "Vendedor2"});
      frame.add(x);
      frame.setVisible(true);
      x.setLabelText("Richard Roman");
      
   }
}