package org.nekonium.jsonrpc;

/**
 * General exception
 * 
 * @author oldbeyond
 * 
 */
public class NukoRpcException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	NukoRpcException(String message) {
		super(message);
	}
}
