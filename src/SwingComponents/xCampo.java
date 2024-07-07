package SwingComponents;
import javax.swing.*;
import java.awt.*;

public class xCampo extends JPanel{
   private Dimension xAllSize, xLabelSize, xFieldSize;
   private String xLabelText, xFieldText;
   private JLabel xLabel;
   private JTextField xField;
   
   public xCampo(String LabelText){
      super(new FlowLayout(FlowLayout.LEFT,10,0));
      init();
      componetes(LabelText);  
   }
   
   private void init(){
      setAllSize(new Dimension(340,24));
      setBackground(Color.white);
   }
   
   private void componetes(String LabelText){
      addLabel(LabelText);
      addField();
   }
   
   private void addLabel(String LabelText){
      xLabelText = LabelText;
      xLabel = new JLabel(xLabelText);
      setLabelSize(new Dimension(150,24));
      add(xLabel);
   }
   private void addField(){
      xField = new JTextField();
      xFieldText = xField.getText();
      setFieldSize(new Dimension(150,24));
      xField.setSelectionColor(new Color(227, 227, 227));
      add(xField);
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
   public Dimension getFieldSize() {
      xFieldSize =xField.getPreferredSize();
      return  xFieldSize;
   }

   public void setFieldSize(Dimension FieldSize) {
      this.xFieldSize = FieldSize;
      xField.setPreferredSize(xFieldSize);
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
   public String getFieldText() {
      xFieldText = xField.getText();
      return xFieldText;
   }

   public void setFieldText(String fieldText) {
      this.xFieldText = fieldText;
      xField.setText(xFieldText);
   }
   
   public boolean fieldLleno(){
      return !xField.getText().trim().isEmpty();
   }
   
   public static void main(String[] args) {
      JFrame frame = new JFrame("XCampo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 600);
      xCampo x = new xCampo("Hola mundo");
      frame.add(x);
      frame.setVisible(true);
      x.setLabelText("Richard Roman");
      
   }
}