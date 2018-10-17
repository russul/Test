package GUI;
import java.awt.*;
import java.awt.event.*;

public class TFmath {
	public static void main(String[] args){
		new TFFrame().launchFrame();
	}
}


class TFFrame extends Frame{
	TextField num1,num2,num3;
	
	public void launchFrame(){
		 num1 = new TextField(10); 
		 num2 = new TextField(10);
		 num3 = new TextField(15);
		Label lblplus = new Label("+");
		Button bunE = new Button("=");
		bunE.addActionListener( new Mymonitor(this));
		setLayout(new FlowLayout());
		add(num1);
		add(lblplus);
		add(num2);
		add(bunE);
		add(num3);
		pack();
		setVisible(true);
	}
}

class Mymonitor implements ActionListener{
	TFFrame tf = null;
	
	
	public Mymonitor(TFFrame tf){
		this.tf = tf  ;
	}
	
	
	public void actionPerformed(ActionEvent e){
		int n1 = Integer.parseInt(tf.num1.getText());
		int n2 = Integer.parseInt(tf.num1.getText());
		tf.num3.setText("" + (n1+n2)); 
	}
}