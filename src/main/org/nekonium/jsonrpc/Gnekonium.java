package org.nekonium.jsonrpc;

import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;


/**
 * @author Oldbeyond
 */
public class Gnekonium {
	private JsonRpcHttpClient client;
	private INekoniumRpc nekoniumRpc;

	public Gnekonium(final String neknoniumUrl) throws MalformedURLException {
		this.client = new JsonRpcHttpClient(new URL(neknoniumUrl));
	}

	public INekoniumRpc getRPC() {
		if (nekoniumRpc == null) {
			this.nekoniumRpc = ProxyUtil.createClientProxy(getClass()
					.getClassLoader(), INekoniumRpc.class, client);
		}
		return this.nekoniumRpc;
	}
}
