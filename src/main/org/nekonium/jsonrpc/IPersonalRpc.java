package org.nekonium.jsonrpc;

public interface IPersonalRpc {
	String personal_newAccount(String seed);
	boolean personal_unlockAccount(String addr, String pass, Integer duration);
	String[] personal_listAccounts();
}
