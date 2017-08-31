package org.nekonium.jsonrpc;

import java.net.MalformedURLException;
import java.net.URL;

import org.nekonium.http.BaseHttpClient;
import org.nekonium.http.BaseHttpProxy;

import java.lang.reflect.Proxy;
//import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
//import com.googlecode.jsonrpc4j.ProxyUtil;

/**
 * @author Oldbeyond
 */
public class Gnekonium {
	// private JsonRpcHttpClient client;
	private INekoniumRpc nekoniumRpc;
	private BaseHttpProxy httpProxy;

	public Gnekonium(final String neknoniumUrl) throws MalformedURLException {
		// this.client = new JsonRpcHttpClient(new URL(neknoniumUrl));
		BaseHttpClient client = new BaseHttpClient();
		httpProxy = new BaseHttpProxy(client);
	}

	/**
	 * @return Nekonium RPC contains all JSON RPC APIs
	 */
	public INekoniumRpc getRPC() {
		if (nekoniumRpc == null) {
			this.nekoniumRpc = (INekoniumRpc) Proxy.newProxyInstance(getClass()
					.getClassLoader(), new Class<?>[] { INekoniumRpc.class },
					httpProxy);
		}
		return this.nekoniumRpc;
	}
}
