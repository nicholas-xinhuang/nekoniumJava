package org.nekonium.jsonrpc;

public interface IAdminRpc {
	boolean admin_addPeer(String s);

	String admin_exportChain();

	String admin_importChain();

	String admin_sleepBlocks();

	String admin_verbosity();

	String admin_setSolc();

	String admin_startRPC();

	String admin_stopRPC();

	String admin_setGlobalRegistrar();

	String admin_setHashReg();

	String admin_setUrlHint();

	String admin_saveInfo();

	String admin_register();

	String admin_registerUrl();

	String admin_startNatSpec();

	String admin_stopNatSpec();

	String admin_getContractInfo();

	String admin_httpGet();

	String admin_nodeInfo();

	String admin_peers();

	String admin_datadir();
}
