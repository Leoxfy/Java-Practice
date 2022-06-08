package work2;

import java.io.File;

public class FolderCopy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File(".\\files");
		File file2 = new File(".\\files\\poem");
		File file3 = new File(".\\files\\poem\\将进酒.txt");
		File file4 = new File(".\\files\\poem\\五古·咏苎萝山.txt");
		File file5 = new File(".\\files\\李白诗集.txt");
		
		MenuComponent component1 = new Menu(file1);
		MenuComponent component2 = new Menu(file2);
		MenuComponent component3 = new MenuItem(file3);
		MenuComponent component4 = new MenuItem(file4);
		MenuComponent component5 = new MenuItem(file5);
		
		component1.add(component2);
		component1.add(component5);
		component2.add(component3);
		component2.add(component4);
		
		component1.copy(".\\MyCopyTest");
		System.out.println("copy测试");
	}

}
