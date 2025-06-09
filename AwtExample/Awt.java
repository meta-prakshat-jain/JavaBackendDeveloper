package AwtExample;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Awt{

	//Using constructors we can invoke components in our program
	public Awt() {
		Frame frame=new Frame("Hello first GUI");
		Checkbox cb1=new Checkbox("Java");
		cb1.setBounds(20,190,50,50);
		Checkbox cb2=new Checkbox("C++");
		cb2.setBounds(20,222,50,50);
		Checkbox cb3=new Checkbox("Python");
		cb3.setBounds(20,255,50,50);

		TextArea textArea=new TextArea("");
		textArea.setBounds(250,40,200,200);

		TextField text=new TextField("username");
		text.setBackground(Color.orange);
		text.setBounds(20,120,150,30);

		Label label=new Label("Enter the text");
		label.setBackground(Color.lightGray);
		label.setBounds(20,90,150,30);//x,y,width,height

		Button button=new Button("Click Me");
		button.setBackground(Color.darkGray);
		button.setBounds(20,40,80,30);//x,y,width,height

		button.addActionListener(new ActionListener()
		{
			@Override

			public void actionPerformed(ActionEvent e) {
				label.setText("button clicked succesfully") ;
				label.setBackground(Color.green);
			}
		});

		frame.add(button);
		frame.add(label);
		frame.add(text);
		frame.add(textArea);
		frame.add(cb1);
		frame.add(cb2);
		frame.add(cb3);

		frame.setSize(700,500);
		frame.setLayout(null);//if not layout the button will come to center
		frame.setVisible(true);

		//Window will close
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
	}
	public static void main(String[] args) {
		Awt project=new Awt();


	}
}