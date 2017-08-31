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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(String gasPrice) {
		this.gasPrice = gasPrice;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// public String data;
	// public String nonce;
}