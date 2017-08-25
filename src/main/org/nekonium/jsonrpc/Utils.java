package org.nekonium.jsonrpc;

import java.math.BigInteger;

public class Utils {

	public static BigInteger convertNukoAmount(NukoUnit unit) {
		switch (unit) {
		case wei:
			return new BigInteger("1");
		case Kwei:
			return new BigInteger("1000");
		case Mwei:
			return new BigInteger("1000000");
		case Gwei:
			return new BigInteger("1000000000");
		case Szabo:
			return new BigInteger("1000000000000");
		case Finney:
			return new BigInteger("1000000000000000");
		case Nuko:
			return new BigInteger("1000000000000000000");
		case Knuko:
			return new BigInteger("1000000000000000000000");
		case Mnuko:
			return new BigInteger("1000000000000000000000000");
		case Gnuko:
			return new BigInteger("1000000000000000000000000000");
		case Tnuko:
			return new BigInteger("1000000000000000000000000000000");
		default:
			throw new IllegalArgumentException("Unknow unit");

		}
	}

	// EncodeUint64 encodes i as a hex string with 0x prefix.
	/**
	 * Encode Integer to Hex string with "0x" prefix
	 * 
	 * @param val
	 *            Integer to convert
	 * @return Hex string with 0x prefix
	 */
	public static String EncodeIntegerToHex(BigInteger val) {
		return "0x" + Long.toHexString(val.longValue());
	}
}
