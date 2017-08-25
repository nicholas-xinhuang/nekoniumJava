package org.nekonium.jsonrpc;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.nekonium.jsonrpc.parameters.TransactionArgs;

/**
 * @author Oldbeyond
 */

public class Nekonium {

	private Gnekonium gnekonium;
	private String addr;

	/**
	 * @param address
	 *            Nekonium address
	 * @param endpoint
	 *            Nekonium Blockchain URL
	 * @throws Exception
	 */
	public Nekonium(final String address, final String endpoint)
			throws Exception {
		this.gnekonium = new Gnekonium(endpoint);
		this.addr = address;
	}

	/**
	 * @param endpoint
	 *            Nekonium Blockchain URL
	 * @throws Exception
	 */
	public Nekonium(final String endpoint) throws Exception {
		this.gnekonium = new Gnekonium(endpoint);
		if (getRPC().eth_accounts().length > 0)
			this.addr = getRPC().eth_coinbase();
	}

	/**
	 * @return Gnekonium RPC interface
	 */
	public INekoniumRpc getRPC() {
		return gnekonium.getRPC();
	}

	/**
	 * @return Nekonium Account List
	 */
	public String[] getAccountList() {
		return getRPC().eth_accounts();
	}

	/**
	 * Create a new Nekonium Account
	 * 
	 * @param password
	 *            Nekonium Account Password
	 * @return Nekonium Account Address
	 */
	public String createNewAccount(String password) {
		return getRPC().personal_newAccount(password);
	}

	/**
	 * @param addr
	 *            Nekonium Account to switch to
	 */
	public void switchAccount(String addr) {
		this.addr = addr;
	}

	/**
	 * Unlock the account for transaction
	 * 
	 * @param password
	 *            account password for decryption
	 * @param duration
	 *            time duration for account unlock, 0 for forever
	 * @return true if account is successfully unlocked
	 */
	public Boolean unlock(String password, Integer duration) {
		return getRPC().personal_unlockAccount(addr, password, duration);
	}

	/**
	 * @return the balance in Nuko Unit
	 * @throws Exception
	 */
	public Double getBalance() throws Exception {
		return getBalance(NukoUnit.Nuko);
	}

	/**
	 * @param unit
	 *            NUKO Unit (wei,nuko, etc..)
	 * @return the balance in Nuko Unit
	 * @throws Exception
	 */
	public Double getBalance(NukoUnit unit) throws Exception {
		final String balance = getRPC().eth_getBalance(addr, "latest");
		BigDecimal value = new BigDecimal(new BigInteger(balance.substring(2),
				16).toString());
		value = value.divide(new BigDecimal(Utils.convertNukoAmount(unit)
				.toString()));
		return value.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * Send nuko to destination address
	 * 
	 * @param toAddress
	 *            Destination address
	 * @param amount
	 *            The amount to send
	 * @return Transaction receipt
	 * @throws Exception
	 */
	public String sendTransaction(String toAddress, Double amount)
			throws Exception {
		return sendTransaction(toAddress, amount, NukoUnit.Nuko);
	}

	/**
	 * Send Transaction
	 * 
	 * @param toAddress
	 *            Destination address
	 * @param amount
	 *            The amount to send
	 * @param unit
	 *            NUKO Unit (wei, nuko, etc ..)
	 * @return Transaction receipt`
	 * @throws Exception
	 */
	public String sendTransaction(String toAddress, Double amount, NukoUnit unit)
			throws Exception {
		final String DEFAULT_GASPRICE = "5000000000";
		final String DEFAULT_GAS = "90000";

		final String gasPrice = Utils.EncodeIntegerToHex(new BigInteger(
				DEFAULT_GASPRICE));
		final String gas = Utils
				.EncodeIntegerToHex(new BigInteger(DEFAULT_GAS));
		final BigDecimal sentAmount = new BigDecimal(amount).setScale(100,
				BigDecimal.ROUND_HALF_UP).multiply(
				new BigDecimal(Utils.convertNukoAmount(unit)).setScale(100,
						BigDecimal.ROUND_HALF_UP));
		final String sentAmountHex = Utils.EncodeIntegerToHex(sentAmount
				.toBigInteger());

		TransactionArgs transactionArgs = new TransactionArgs(addr, toAddress,
				gas, gasPrice, sentAmountHex);
		return getRPC().eth_sendTransaction(transactionArgs);
	}
}
