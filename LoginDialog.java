package Main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.JDialog;

public class LoginDialog extends JDialog{
	public LoginDialog(){
		setTitle("Sign-up Window");
		Container container=getContentPane();
		container.setLayout(new GridLayout(4,1));
		final String de=new String("Please input user name");
		final JTextField jtf1=new JTextField(de);
		jtf1.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(jtf1.getText().equals(de)|jtf1.getText().matches("\\s+"))
					jtf1.setText("");
				jtf1.setCaretColor(Color.BLACK);
				jtf1.setBackground(Color.white);
			}
			public void focusLost(FocusEvent e){
				if(jtf1.getText().equals("")||jtf1.getText().matches("\\s+"))
					jtf1.setText(de);
				jtf1.setBackground(Color.lightGray);
				jtf1.setCaretColor(Color.LIGHT_GRAY);
			}
		});
		final String defau=new String("Please input password");
		final JPasswordField jtf2=new JPasswordField(defau);
		jtf2.setEchoChar('\0');
		jtf2.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(String.valueOf(jtf2.getPassword()).equals(defau)||String.valueOf(jtf2.getPassword()).equals("")||String.valueOf(jtf2.getPassword()).matches("\\s+")){
					jtf2.setEchoChar('$');
					jtf2.setText("");
				}
				jtf2.setCaretColor(Color.BLACK);
				jtf2.setBackground(Color.white);	
			}
			public void focusLost(FocusEvent e){
				if(String.valueOf(jtf2.getPassword()).equals(defau)||String.valueOf(jtf2.getPassword()).equals("")||String.valueOf(jtf2.getPassword()).matches("\\s+")){
					jtf2.setEchoChar('\0');
					jtf2.setText(defau);
				}
				jtf2.setCaretColor(Color.LIGHT_GRAY);
				jtf2.setBackground(Color.lightGray);
			}
		});
		final JPasswordField jtf3=new JPasswordField(defau);
		jtf3.setEchoChar('\0');
		jtf3.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(String.valueOf(jtf3.getPassword()).equals(defau)||String.valueOf(jtf3.getPassword()).equals("")||String.valueOf(jtf3.getPassword()).matches("\\s+")){
					jtf3.setEchoChar('$');
					jtf3.setText("");
				}
				jtf3.setCaretColor(Color.BLACK);
				jtf3.setBackground(Color.white);	
			}
			public void focusLost(FocusEvent e){
				if(String.valueOf(jtf3.getPassword()).equals(defau)||String.valueOf(jtf3.getPassword()).equals("")||String.valueOf(jtf3.getPassword()).matches("\\s+")){
					jtf3.setEchoChar('\0');
					jtf3.setText(defau);
				}
				jtf3.setCaretColor(Color.LIGHT_GRAY);
				jtf3.setBackground(Color.lightGray);
			}
		});
		JButton jb=new JButton("Sign up");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(String.valueOf(jtf2.getPassword()).equals(String.valueOf(jtf3.getPassword()))){
					if(!String.valueOf(jtf1.getText()).equals("")||!String.valueOf(jtf1.getText()).equals("\\s+")){
						if(!(String.valueOf(jtf2.getPassword()).equals("")||String.valueOf(jtf2.getPassword()).equals("\\s+"))){
							Data.setData(jtf1.getText(),String.valueOf(jtf2.getPassword()));
							LoginDialog.this.dispose();
						}else{
							new LExDialog("Sorry.Password can't be empty.");
						}
					}else{
						new LExDialog("Sorry.User name can't be empty.");
					}
				}else{
					new LExDialog("Sorry.Two pieces of passwords are difference.");
				}
			}
		});
		container.add(jtf1);
		container.add(jtf2);
		container.add(jtf3);
		container.add(jb);
		setBounds(300,300,300,250);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
class LExDialog extends JDialog{
	public LExDialog(String des){
		setTitle("Dialog");
		Container container=getContentPane();
		container.add(new JLabel(des));
		setBounds(250,250,300,200);
		setVisible(true);
	}
}
