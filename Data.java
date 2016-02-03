package Main;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class Data {
	private static  HashMap<String,String> map=new HashMap<String,String>();
	
	public static void setData(String user,String password){
		try{
			map.put(user,password);
			File file=new File("E:/map.txt");
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			if(!file.exists()){
				file.createNewFile();
			}
			//user is a String,password is a Stirng.
			FileWriter out=new FileWriter(file,true);
			out.write(user+"-->"+password+"\r\n");
			out.flush();
		}catch(Exception e){
			new ExDialog();
		}
		
	}

	public static boolean checkData(String user,String password){
		return map.get(user).equals(password);
	}
	
	public static boolean isHave(String user){
		return map.get(user)!=null;
	}
}

class ExDialog extends JDialog{
	public ExDialog(){
		setTitle("Dialog");
		 Container container=getContentPane();
		 container.add(new JLabel("Insufficient Server Capacity."));
		setVisible(true);
	}
}
