package work2;
import java.util.Scanner;

public class TestCalendar {

	public static void main(String[] args) {
		CalendarBean cb = new CalendarBean();
		
		//������ݺ��·�
		//cb.setTime(2021, 10);
		//���ô�ӡ����
		cb.printCalendar();
		System.out.println("Previous(p) or next(n) month:");
		
		//ѭ��
		String a;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.next();
			if(a.equals("p")) {
				cb.previousMonth();
				cb.printCalendar();
			}else if(a.equals("n")) {
				cb.nextMonth();
				cb.printCalendar();
			}else {
				break;
			}
			System.out.println("Previous(p) or next(n) month:");
		}
		scanner.close();
	}

}
