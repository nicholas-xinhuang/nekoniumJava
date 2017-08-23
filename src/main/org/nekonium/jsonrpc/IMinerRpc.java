package org.nekonium.jsonrpc;

public interface IMinerRpc {
	boolean miner_start();

	boolean miner_stop();

	boolean miner_setEtherbase(String coinBase) throws Exception;

	boolean miner_setExtra(String data) throws Exception;

	boolean miner_setGasPrice(String newMinGasPrice);

	boolean miner_startAutoDAG();

	boolean miner_stopAutoDAG();

	boolean miner_makeDAG();

	String miner_hashrate();
}
