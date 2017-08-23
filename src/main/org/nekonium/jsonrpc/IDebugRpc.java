package org.nekonium.jsonrpc;

public interface IDebugRpc {
	String debug_printBlock();

	String debug_getBlockRlp();

	String debug_setHead();

	String debug_processBlock();

	String debug_seedHash();

	String debug_dumpBlock();

	String debug_metrics();
}
