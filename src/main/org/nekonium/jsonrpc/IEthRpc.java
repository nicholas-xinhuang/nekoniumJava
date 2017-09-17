package org.nekonium.jsonrpc;

import org.nekonium.jsonrpc.parameters.FilterRequest;
import org.nekonium.jsonrpc.parameters.TransactionArgs;
import org.nekonium.jsonrpc.returns.BlockResult;
import org.nekonium.jsonrpc.returns.SyncingResult;

public interface IEthRpc {

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
	String web3_sha3(String data) throws NukoRpcException;

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
	String eth_getBalance(String address, String block) throws NukoRpcException;

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
			throws NukoRpcException;

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
			throws NukoRpcException;

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
			throws NukoRpcException;

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
	String eth_getBlockTransactionCountByNumber(String bnOrId) throws NukoRpcException;

	/**
	 * Returns the number of uncles in a block from a block matching the given
	 * block hash.
	 * 
	 * @param blockHash
	 * @return integer of the number of uncles in this block.
	 * @throws Exception
	 */
	String eth_getUncleCountByBlockHash(String blockHash) throws NukoRpcException;

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
	String eth_getUncleCountByBlockNumber(String bnOrId) throws NukoRpcException;

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
	String eth_getCode(String addr, String bnOrId) throws NukoRpcException;

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
	String eth_sign(String addr, String data) throws NukoRpcException;

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
			throws NukoRpcException;

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
	String eth_sendRawTransaction(String rawData) throws NukoRpcException;

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
	String eth_call(TransactionArgs args, String bnOrId) throws NukoRpcException;

	String eth_estimateGas(TransactionArgs args) throws Exception;

	BlockResult eth_getBlockByHash(String blockHash,
			Boolean fullTransactionObjects) throws Exception;

	/**
	 * Unimplmented eth_getTransactionByHash
	 * eth_getTransactionByBlockHashAndIndex
	 * eth_getTransactionByBlockNumberAndIndex eth_getTransactionReceipt
	 * ethj_getTransactionReceipt
	 * */

	/**
	 * Returns information about a uncle of a block by hash and uncle index
	 * position.
	 * 
	 * @param blockHash
	 *            32 Bytes - hash a block.
	 * @param uncleIdx
	 *            the uncle's index position.
	 * @return A block object, or null when no block was found
	 * @throws Exception
	 */
	BlockResult eth_getUncleByBlockHashAndIndex(String blockHash,
			String uncleIdx) throws NukoRpcException;

	/**
	 * Returns information about a block by block number.
	 * 
	 * @param bnOrId
	 *            integer of a block number, or the string "earliest", "latest"
	 *            or "pending
	 * @param fullTransactionObjects
	 *            If true it returns the full transaction objects, if false only
	 *            the hashes of the transactions.
	 * @return A block object, or null when no block was found
	 * @throws Exception
	 */
	BlockResult eth_getBlockByNumber(String bnOrId,
			Boolean fullTransactionObjects) throws NukoRpcException;

	/**
	 * 
	 * @param blockId
	 * @param uncleIdx
	 * @return
	 * @throws Exception
	 */
	BlockResult eth_getUncleByBlockNumberAndIndex(String blockId,
			String uncleIdx) throws NukoRpcException;

	String[] eth_getCompilers();

	String eth_resend();

	String eth_pendingTransactions();

	String eth_newFilter(FilterRequest fr) throws NukoRpcException;

	// String eth_newFilter(String fromBlock, String toBlock, String address,
	// String[] topics) throws Exception;

	String eth_newBlockFilter();

	String eth_newPendingTransactionFilter();

	boolean eth_uninstallFilter(String id);

	Object[] eth_getFilterChanges(String id);

	Object[] eth_getFilterLogs(String id);

	Object[] eth_getLogs(FilterRequest fr) throws NukoRpcException;

	String eth_getWork();

	String eth_submitWork();

	String eth_submitHashrate();

	String net_addPeer();

}
