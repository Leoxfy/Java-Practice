package work2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//菜单项类
public class MenuItem extends MenuComponent{

	public MenuItem(File curFile) {
		this.curFile = curFile;
	}
	
	@Override
	public void copy(String parent) {
		// TODO Auto-generated method stub
		File desfile = new File(parent,curFile.getName());
		if(!desfile.exists()) {
			try {
				desfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//字节流复制
		
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in= new FileInputStream(curFile);
			out = new FileOutputStream(desfile);
			byte[] buffer = new byte[200];
			int n = -1;
			while( ( n=in.read(buffer, 0, 200)) !=-1) {
				out.write(buffer, 0, n);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
