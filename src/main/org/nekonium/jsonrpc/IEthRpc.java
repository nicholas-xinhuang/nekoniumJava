package org.nekonium.jsonrpc;

import java.util.Arrays;

public interface IEthRpc {
	class SyncingResult {
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

	class TransactionArgs {
		public String from;
		public String to;
		public String gas;
		public String gasPrice;
		public String value;
		public String data;
		public String nonce;

		@Override
		public String toString() {
			return "CallArguments{" + "from='" + from + '\'' + ", to='" + to
					+ '\'' + ", gasLimit='" + gas + '\'' + ", gasPrice='"
					+ gasPrice + '\'' + ", value='" + value + '\'' + ", data='"
					+ data + '\'' + ", nonce='" + nonce + '\'' + '}';
		}
	}

	class BlockResult {
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

	/*
	 * class CompilationResult { public String code; public CompilationInfo
	 * info;
	 * 
	 * @Override public String toString() { return "CompilationResult{" +
	 * "code='" + code + '\'' + ", info=" + info + '}'; } }
	 */

	class FilterRequest {
		public String fromBlock;
		public String toBlock;
		public Object address;
		public Object[] topics;

		@Override
		public String toString() {
			return "FilterRequest{" + "fromBlock='" + fromBlock + '\''
					+ ", toBlock='" + toBlock + '\'' + ", address=" + address
					+ ", topics=" + Arrays.toString(topics) + '}';
		}
	}

	class LogFilterElement {
		public String logIndex;
		public String blockNumber;
		public String blockHash;
		public String transactionHash;
		public String transactionIndex;
		public String address;
		public String data;
		public String[] topics;

		/*
		 * public LogFilterElement(LogInfo logInfo, Block b, int txIndex,
		 * Transaction tx, int logIdx) { logIndex = toJsonHex(logIdx);
		 * blockNumber = b == null ? null : toJsonHex(b.getNumber()); blockHash
		 * = b == null ? null : toJsonHex(b.getHash()); transactionIndex = b ==
		 * null ? null : toJsonHex(txIndex); transactionHash =
		 * toJsonHex(tx.getHash()); address = toJsonHex(tx.getReceiveAddress());
		 * data = toJsonHex(logInfo.getData()); topics = new
		 * String[logInfo.getTopics().size()]; for (int i = 0; i <
		 * topics.length; i++) { topics[i] =
		 * toJsonHex(logInfo.getTopics().get(i).getData()); } }
		 */
		@Override
		public String toString() {
			return "LogFilterElement{" + "logIndex='" + logIndex + '\''
					+ ", blockNumber='" + blockNumber + '\'' + ", blockHash='"
					+ blockHash + '\'' + ", transactionHash='"
					+ transactionHash + '\'' + ", transactionIndex='"
					+ transactionIndex + '\'' + ", address='" + address + '\''
					+ ", data='" + data + '\'' + ", topics="
					+ Arrays.toString(topics) + '}';
		}
	}

	/**
	 * @return The current client version
	 */
	String web3_clientVersion();

	/**
	 * Returns Keccak-256 (not the standardized SHA3-256) of the given data.
	 * 
	 * @param data
	 *            The data to convert into a SHA3 hash
	 * @return The SHA3 result of the given string.
	 * @throws Exception
	 */
	String web3_sha3(String data) throws Exception;

	/**
	 * @return Returns the current network id.
	 */
	String net_version();

	/**
	 * @return Returns number of peers currently connected to the client.
	 */
	String net_peerCount();

	/**
	 * @return Returns true if client is actively listening for network
	 *         connections.
	 */
	boolean net_listening();

	/**
	 * @return Returns the current nekonium protocol version.
	 */
	String eth_protocolVersion();

	/**
	 * @return Returns an object with data about the sync status or false.
	 */
	SyncingResult eth_syncing();

	/**
	 * @return Returns the client coinbase address.
	 */
	String eth_coinbase();

	/**
	 * @return Returns true if client is actively mining new blocks.
	 */
	boolean eth_mining();

	/**
	 * @return Returns the number of hashes per second that the node is mining
	 *         with.
	 */
	String eth_hashrate();

	/**
	 * @return Returns the current price per gas in wei.
	 */
	String eth_gasPrice();

	/**
	 * @return Returns a list of addresses owned by client.
	 */
	String[] eth_accounts();

	/**
	 * @return Returns the number of most recent block.
	 */
	String eth_blockNumber();

	/**
	 * Returns the balance of the account of given address.
	 * 
	 * @param address
	 *            20 Bytes - address to check for balance.
	 * @param block
	 *            integer block number, or the string "latest", "earliest" or
	 *            "pending"
	 * @return integer of the current balance in wei.
	 * @throws Exception
	 */
	String eth_getBalance(String address, String block) throws Exception;

	/**
	 * Returns the value from a storage position at a given address.
	 * 
	 * @param address
	 *            20 Bytes - address of the storage.
	 * @param storageIdx
	 *            integer of the position in the storage.
	 * @param blockId
	 *            integer block number, or the string "latest", "earliest" or
	 *            "pending"
	 * @return the value at this storage position.
	 * @throws Exception
	 */
	String eth_getStorageAt(String address, String storageIdx, String blockId)
			throws Exception;

	/**
	 * Returns the number of transactions sent from an address.
	 * 
	 * @param address
	 *            20 Bytes - address.
	 * @param blockId
	 *            integer block number, or the string "latest", "earliest" or
	 *            "pending"
	 * @return integer of the number of transactions send from this address.
	 * @throws Exception
	 */
	String eth_getTransactionCount(String address, String blockId)
			throws Exception;

	/**
	 * Returns the number of transactions in a block from a block matching the
	 * given block hash.
	 * 
	 * @param blockHash
	 *            32 Bytes - hash of a block
	 * @return integer of the number of transactions in this block.
	 * @throws Exception
	 */
	String eth_getBlockTransactionCountByHash(String blockHash)
			throws Exception;

	/**
	 * Returns the number of transactions in a block from a block matching the
	 * given block number.
	 * 
	 * @param bnOrId
	 *            integer of a block number, or the string "earliest", "latest"
	 *            or "pending"
	 * @return integer of the number of transactions in this block.
	 * @throws Exception
	 */
	String eth_getBlockTransactionCountByNumber(String bnOrId) throws Exception;

	/**
	 * Returns the number of uncles in a block from a block matching the given
	 * block hash.
	 * 
	 * @param blockHash
	 * @return integer of the number of uncles in this block.
	 * @throws Exception
	 */
	String eth_getUncleCountByBlockHash(String blockHash) throws Exception;

	/**
	 * Returns the number of uncles in a block from a block matching the given
	 * block number.
	 * 
	 * @param bnOrId
	 *            integer of a block number, or the string "latest", "earliest"
	 *            or "pending"
	 * @return integer of the number of uncles in this block.
	 * @throws Exception
	 */
	String eth_getUncleCountByBlockNumber(String bnOrId) throws Exception;

	/**
	 * Returns code at a given address.
	 * 
	 * @param addr
	 *            20 Bytes - address
	 * @param bnOrId
	 *            integer block number, or the string "latest", "earliest" or
	 *            "pending"
	 * @return the code from the given address.
	 * @throws Exception
	 */
	String eth_getCode(String addr, String bnOrId) throws Exception;

	/**
	 * The sign method calculates an Ethereum specific signature with:
	 * sign(keccak256("\x19Ethereum Signed Message:\n" + len(message) +
	 * message))).
	 * 
	 * @param addr
	 *            20 Bytes - address
	 * @param data
	 *            N Bytes - message to sign
	 * @return
	 * @throws Exception
	 */
	String eth_sign(String addr, String data) throws Exception;

	/**
	 * Creates new message call transaction or a contract creation, if the data
	 * field contains code.
	 * 
	 * @param transactionArgs
	 *            The transaction object
	 * @return 32 Bytes - the transaction hash, or the zero hash if the
	 *         transaction is not yet available.
	 * @throws Exception
	 */
	String eth_sendTransaction(TransactionArgs transactionArgs)
			throws Exception;

	/**
	 * Creates new message call transaction or a contract creation for signed
	 * transactions.
	 * 
	 * @param rawData
	 *            The signed transaction data.
	 * @return 32 Bytes - the transaction hash, or the zero hash if the
	 *         transaction is not yet available.
	 * @throws Exception
	 */
	String eth_sendRawTransaction(String rawData) throws Exception;

	/**
	 * Executes a new message call immediately without creating a transaction on
	 * the block chain.
	 * 
	 * @param args
	 *            The transaction call object
	 * @param bnOrId
	 *            integer block number, or the string "latest", "earliest" or
	 *            "pending"
	 * @return the return value of executed contract.
	 * @throws Exception
	 */
	String eth_call(TransactionArgs args, String bnOrId) throws Exception;

	String eth_estimateGas(TransactionArgs args) throws Exception;

	BlockResult eth_getBlockByHash(String blockHash,
			Boolean fullTransactionObjects) throws Exception;

	BlockResult eth_getBlockByNumber(String bnOrId,
			Boolean fullTransactionObjects) throws Exception;

	
	/** Unimplmented
	 * eth_getTransactionByHash
	 * eth_getTransactionByBlockHashAndIndex
	 * eth_getTransactionByBlockNumberAndIndex
	 * eth_getTransactionReceipt
	 * ethj_getTransactionReceipt
	 * */

	BlockResult eth_getUncleByBlockHashAndIndex(String blockHash,
			String uncleIdx) throws Exception;

	BlockResult eth_getUncleByBlockNumberAndIndex(String blockId,
			String uncleIdx) throws Exception;

	String[] eth_getCompilers();

	String eth_resend();

	String eth_pendingTransactions();

	String eth_newFilter(FilterRequest fr) throws Exception;

	// String eth_newFilter(String fromBlock, String toBlock, String address,
	// String[] topics) throws Exception;

	String eth_newBlockFilter();

	String eth_newPendingTransactionFilter();

	boolean eth_uninstallFilter(String id);

	Object[] eth_getFilterChanges(String id);

	Object[] eth_getFilterLogs(String id);

	Object[] eth_getLogs(FilterRequest fr) throws Exception;

	String eth_getWork();

	String eth_submitWork();

	String eth_submitHashrate();

	String net_addPeer();

}
