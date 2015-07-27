package com.letv.tigase.utils.exceptions;

/**
 * 记录已存在异常 ：多用于添加数据时验证唯一
 * 
 * @author zhengxin
 * @version 2015-7-27 11:24:59
 * 
 */
public class ExistedException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = -8244308607506869202L;

    public ExistedException() {
        super();
    }

    public ExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistedException(String message) {
        super(message);
    }

    public ExistedException(Throwable cause) {
        super(cause);
    }

}
