package org.nekonium.jsonrpc.parameters;

import java.util.Arrays;

public class FilterRequest {
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