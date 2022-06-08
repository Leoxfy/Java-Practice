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
			operation = "存入";
		}else if(mode==1) {
			operation = "取出";
		}
		
	}
	@Override
	public String getMessage() {
		return operation + "数据非法：" + msg;
	}
}
