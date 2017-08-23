package org.nekonium.jsonrpc;

public interface ISshRpc {
	String shh_post();

	String shh_version();

	/**
	 * Creates new whisper identity in the client.
	 * 
	 * @return DATA, 60 Bytes - the address of the new identiy.
	 */
	String shh_newIdentity();

	String shh_hasIdentity();

	String shh_newGroup();

	String shh_addToGroup();

	String shh_newFilter();

	String shh_uninstallFilter();

	String shh_getFilterChanges();

	String shh_getMessages();

}
