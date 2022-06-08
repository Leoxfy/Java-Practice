package work2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//菜单类，属于树枝结点
public class Menu extends MenuComponent{
	
	//菜单可以有多个子菜单或者子菜单项
	private List<MenuComponent>menuComponentList = new ArrayList<>();

	
	//构造方法
	public Menu(File curFile) {
		this.curFile = curFile;
	}
	
	@Override
	public void add(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		menuComponentList.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		menuComponentList.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int index) {
		// TODO Auto-generated method stub
		return menuComponentList.get(index);
	}

	@Override
	public void copy(String parent) {
		File desFile = new File(parent);
		if(!desFile.exists()) {
			desFile.mkdir();
		}
		
		File rootFolder = new File(parent,curFile.getName());

		if(!rootFolder.exists()) {
			rootFolder.mkdir();
		}
		for(MenuComponent component:menuComponentList) {
			component.copy(rootFolder.getPath());
		}
	}

}
