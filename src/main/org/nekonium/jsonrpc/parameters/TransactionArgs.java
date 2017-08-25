package org.nekonium.jsonrpc.parameters;

public class TransactionArgs {
	public String from;
	public String to;
	public String gas;
	public String gasPrice;
	public String value;

	public TransactionArgs(String from, String to, String gas, String gasPrice,
			String value) {
		this.from = from;
		this.to = to;
		this.gas = gas;
		this.gasPrice = gasPrice;
		this.value = value;
	}

	// public String data;
	// public String nonce;
}