package org.nekonium.jsonrpc.returns;

public class SyncingResult {
	private String startingBlock;
	private String currentBlock;
	private String highestBlock;
	private Boolean result;

	public SyncingResult(String startingBlock, String currentBlock,
			String highestBlock) {
		this.startingBlock = startingBlock;
		this.currentBlock = currentBlock;
		this.highestBlock = highestBlock;
	}

	public SyncingResult(Boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "SyncingResult [startingBlock=" + startingBlock
				+ ", currentBlock=" + currentBlock + ", highestBlock="
				+ highestBlock + ", result=" + result + "]";
	}
}