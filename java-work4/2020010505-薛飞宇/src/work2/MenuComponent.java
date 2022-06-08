package work2;

import java.io.File;

//菜单组件，属于抽象根结点

public abstract class MenuComponent {
	
	File curFile;
	
	//添加子菜单
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	//移除子菜单
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	//获取指定的子菜单
	public MenuComponent getChild(int index) {
		throw new UnsupportedOperationException();
	}
	
	
	//复制操作
	public abstract void copy(String parent);
}