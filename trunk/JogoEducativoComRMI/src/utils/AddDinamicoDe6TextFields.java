package utils;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.text.ParseException;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;

public class AddDinamicoDe6TextFields extends JInternalFrame{
     private TextField field1;
     private TextField field2;
     private TextField field3;
     private TextField field4;
     private TextField field5;
     private TextField field6;
     
    public AddDinamicoDe6TextFields() throws ParseException{   
        super("Desvende o nome do animal que esta sendo mostrado...");
        field1 = new TextField();
        field1.setEditable(false);
        
        field2 = new TextField();
        field2.setEditable(false);
        
        field3 = new TextField();
        field3.setEditable(false);
        
        field4 = new TextField();
        field4.setEditable(false);
        
        field5 = new TextField();
        field5.setEditable(false);
        
        field6 = new TextField();
        field6.setEditable(false);
        
        field1.setColumns(1);        
        field2.setColumns(1);       
        field3.setColumns(1);        
        field4.setColumns(1);
        field5.setColumns(1);
        field6.setColumns(1);
        
    setLayout(new GridBagLayout());
  
    ((JComponent)getContentPane()).setBorder(
       new EmptyBorder(10, 10, 10, 10));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.insets = new Insets(2, 2, 2, 2);

    gbc.gridy = 0;
    gbc.gridx = 0; 
    gbc.anchor = GridBagConstraints.CENTER;
    add(field1, gbc);

    gbc.gridy = 0;
    gbc.gridx = 1;
    add(field2, gbc);

    gbc.gridy = 0;
    gbc.gridx = 2;
    add(field3, gbc);    
  
    gbc.gridy = 0;
    gbc.gridx = 3;
    add(field4, gbc);    
    
    gbc.gridy = 0;
    gbc.gridx = 4;
    add(field5, gbc);    
    
    gbc.gridy = 0;
    gbc.gridx = 5;
    add(field6, gbc);    

    pack(); 
    setVisible(true);     
 }
    
        public void habilitaField1(boolean acao,String letraCorresp){
        if(acao == true){
            this.field1.setVisible(true);
            this.field1.setText(letraCorresp);
            this.setVisible(false);
            this.setVisible(true);
        }else{
            this.field1.setVisible(false);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    
    public void habilitaField2(boolean acao,String letraCorresp){
        if(acao == true){
            this.field2.setVisible(true);
            this.field2.setText(letraCorresp);
            this.setVisible(false);
            this.setVisible(true);
        }else{
            this.field2.setVisible(false);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    
    public void habilitaField3(boolean acao,String letraCorresp){
        if(acao == true){
            this.field3.setVisible(true);
            this.field3.setText(letraCorresp);
            this.setVisible(false);
            this.setVisible(true);
        }else{
            this.field3.setVisible(false);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    
    public void habilitaField4(boolean acao,String letraCorresp){
        if(acao == true){
            this.field4.setVisible(true);
            this.field4.setText(letraCorresp);
            this.setVisible(false);
            this.setVisible(true);
        }else{
            this.field4.setVisible(false);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    
    public void habilitaField5(boolean acao,String letraCorresp){
        if(acao == true){
            this.field5.setVisible(true);
            this.field5.setText(letraCorresp);
            this.setVisible(false);
            this.setVisible(true);
        }else{
            this.field5.setVisible(false);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    
     public void habilitaField6(boolean acao,String letraCorresp){
        if(acao == true){
            this.field6.setVisible(true);
            this.field6.setText(letraCorresp);
            this.setVisible(false);
            this.setVisible(true);
        }else{
            this.field6.setVisible(false);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    
    public String verificaNomeAnimal(){
        StringBuilder str = new StringBuilder();
        str.append(this.getField1());
        str.append(this.getField2());
        str.append(this.getField3());
        str.append(this.getField4());
        str.append(this.getField5());
        str.append(this.getField6());
        return str.toString();
    }
     
     public String getField1() {
        return field1.getText();
    }

    public void setField1(String str) {
        this.field1.setText(str);
    }

    public String getField2() {
        return field2.getText();
    }

    public void setField2(String str) {
        this.field2.setText(str);
    }

    public String getField3() {
        return field3.getText();
    }

    public void setField3(String str) {
        this.field3.setText(str);
    }

    public String getField4() {
        return field4.getText();
    }

    public void setField4(String str) {
        this.field4.setText(str);
    }

    public String getField5() {
        return field5.getText();
    }

    public void setField5(String str) {
        this.field5.setText(str);
    }
    
    public String getField6() {
        return field5.getText();
    }

    public void setField6(String str) {
        this.field5.setText(str);
    }
    
  public static void main(String args[]) throws ParseException{
    AddDinamicoDe6TextFields app = new AddDinamicoDe6TextFields();
    app.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
  }
}
