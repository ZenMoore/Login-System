package Main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
public class EntryFrame extends JFrame{
	public EntryFrame(){
		Container container=getContentPane();
		container.setLayout(new GridLayout(4,1,20,20));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		
		JLabel jl=new JLabel("User:");
		final String de=new String("User name");
		final JTextField jtf=new JTextField(de,20);
		jtf.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(jtf.getText().equals(de)|jtf.getText().matches("\\s+"))
					jtf.setText("");
				jtf.setCaretColor(Color.BLACK);
				jtf.setBackground(Color.white);
			}
			public void focusLost(FocusEvent e){
				if(jtf.getText().equals("")||jtf.getText().matches("\\s+"))
					jtf.setText(de);
				jtf.setBackground(Color.lightGray);
				jtf.setCaretColor(Color.LIGHT_GRAY);
			}
		});
		jp1.add(jl);jp1.add(jtf);
		
		JLabel jl1=new JLabel("Password:");
		final String defau=new String("Password");
		final JPasswordField jtf1=new JPasswordField(defau,20);
			jtf1.setEchoChar('\0');
//		else
//			jtf1.setEchoChar('$');
		jtf1.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(String.valueOf(jtf1.getPassword()).equals(defau)||String.valueOf(jtf1.getPassword()).equals("")||String.valueOf(jtf1.getPassword()).matches("\\s+")){
					jtf1.setEchoChar('$');
					jtf1.setText("");
				}
				jtf1.setCaretColor(Color.BLACK);
				jtf1.setBackground(Color.white);	
			}
			public void focusLost(FocusEvent e){
				if(String.valueOf(jtf1.getPassword()).equals(defau)||String.valueOf(jtf1.getPassword()).equals("")||String.valueOf(jtf1.getPassword()).matches("\\s+")){
					jtf1.setEchoChar('\0');
					jtf1.setText(defau);
				}
				jtf1.setCaretColor(Color.LIGHT_GRAY);
				jtf1.setBackground(Color.lightGray);
			}
		});
		jp2.add(jl1);jp2.add(jtf1);
		
		JButton lo=new JButton("Sign up");
		lo.setSize(20,10);
		lo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new LoginDialog();
			}
		});
		jp3.add(lo);
		
		JButton ok=new JButton("Sign in");
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(Data.isHave(jtf.getText())){
					if(Data.checkData(jtf.getText(), String.valueOf(jtf1.getPassword()))){
						new MyDialog(EntryFrame.this,"Congratulations.Login Success").setVisible(true);
					}else{
						new MyDialog(EntryFrame.this,"Sorry.Password is wrong.").setVisible(true);
					}
				}else{
					new MyDialog(EntryFrame.this,"Sorry.No such a user.").setVisible(true);
				}				
			}
		});
		JButton re=new JButton("Reset");
		re.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtf.setText("");
				jtf1.setText("");
			}
		});
		jp4.add(ok);
		jp4.add(re);
		
		container.add(jp1);
		container.add(jp2);
		container.add(jp3);
		container.add(jp4);
		
		setTitle("Sign-in Window");
		setBackground(Color.LIGHT_GRAY);
		setBounds(200,200,500,200);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args){
			new EntryFrame();
	}
}

class MyDialog extends JDialog{
	MyDialog(EntryFrame m,String message){
		super(m,"Dialog",true);
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,1,20,20));
		JButton jb=new JButton("Exit");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MyDialog.this.dispose();
			}
		});
		c.add(new JLabel(message));
		c.add(jb);
		setBounds(230,230,200,150);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
