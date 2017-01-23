package com.nikola.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {

	public MD5Encoder() {
	}

	static public String getFormatedString(String p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(p.getBytes("UTF-8"));
		byte[] digest = md.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			String hex = Integer.toHexString(0xFF & digest[i]);
			if (hex.length() == 1)
				hexString.append("0" + hex);
			else
				hexString.append(hex);
		}
		return hexString.toString();
	}

}