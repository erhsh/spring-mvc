package com.erhsh.prj.distrmgmtsys.exception;

/**
 * 服务器内部错误
 * 
 * @author j
 * 
 */
public class DmsServerException extends RuntimeException {
	//
	private static final long serialVersionUID = -2444433441989132173L;

	public DmsServerException(String msg) {
		super(msg);
	}

	public DmsServerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DmsServerException(Throwable cause) {
		super(cause);
	}

}
