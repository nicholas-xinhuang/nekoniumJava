package org.nekonium.jsonrpc.returns;

import java.util.Arrays;

public class BlockResult {
	public String number; // QUANTITY - the block number. null when its
							// pending block.
	public String hash; // DATA, 32 Bytes - hash of the block. null when its
						// pending block.
	public String parentHash; // DATA, 32 Bytes - hash of the parent block.
	public String nonce; // DATA, 8 Bytes - hash of the generated
							// proof-of-work. null when its pending block.
	public String sha3Uncles; // DATA, 32 Bytes - SHA3 of the uncles data in
								// the block.
	public String logsBloom; // DATA, 256 Bytes - the bloom filter for the
								// logs of the block. null when its pending
								// block.
	public String transactionsRoot; // DATA, 32 Bytes - the root of the
									// transaction trie of the block.
	public String stateRoot; // DATA, 32 Bytes - the root of the final state
								// trie of the block.
	public String receiptsRoot; // DATA, 32 Bytes - the root of the receipts
								// trie of the block.
	public String miner; // DATA, 20 Bytes - the address of the beneficiary
							// to whom the mining rewards were given.
	public String difficulty; // QUANTITY - integer of the difficulty for
								// this block.
	public String totalDifficulty; // QUANTITY - integer of the total
									// difficulty of the chain until this
									// block.
	public String extraData; // DATA - the "extra data" field of this block
	public String size;// QUANTITY - integer the size of this block in
						// bytes.
	public String gasLimit;// : QUANTITY - the maximum gas allowed in this
							// block.
	public String gasUsed; // QUANTITY - the total used gas by all
							// transactions in this block.
	public String timestamp; // : QUANTITY - the unix timestamp for when the
								// block was collated.
	public Object[] transactions; // : Array - Array of transaction objects,
									// or 32 Bytes transaction hashes
									// depending on the last given
									// parameter.
	public String[] uncles; // : Array - Array of uncle hashes.

	@Override
	public String toString() {
		return "BlockResult{" + "number='" + number + '\'' + ", hash='"
				+ hash + '\'' + ", parentHash='" + parentHash + '\''
				+ ", nonce='" + nonce + '\'' + ", sha3Uncles='"
				+ sha3Uncles + '\'' + ", logsBloom='" + logsBloom + '\''
				+ ", transactionsRoot='" + transactionsRoot + '\''
				+ ", stateRoot='" + stateRoot + '\'' + ", receiptsRoot='"
				+ receiptsRoot + '\'' + ", miner='" + miner + '\''
				+ ", difficulty='" + difficulty + '\''
				+ ", totalDifficulty='" + totalDifficulty + '\''
				+ ", extraData='" + extraData + '\'' + ", size='" + size
				+ '\'' + ", gasLimit='" + gasLimit + '\'' + ", gasUsed='"
				+ gasUsed + '\'' + ", timestamp='" + timestamp + '\''
				+ ", transactions=" + Arrays.toString(transactions)
				+ ", uncles=" + Arrays.toString(uncles) + '}';
	}
}