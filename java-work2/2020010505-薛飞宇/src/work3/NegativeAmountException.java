package work3;

public class NegativeAmountException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	String operation;
	public NegativeAmountException(String m, int mode) {
		msg = m;
		if(mode==0) {
			operation = "����";
		}else if(mode==1) {
			operation = "ȡ��";
		}
		
	}
	@Override
	public String getMessage() {
		return operation + "���ݷǷ���" + msg;
	}
}
