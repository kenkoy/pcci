package com.pcci.idls.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PWUtil {
	private final static int ITERATION_NUMBER = 1000;

	public PWUtil() {
	}

	public static String encryptPassword(String stringToEncrypt) {
		String newString = "";
		byte[] bDigest = null;
		try {
			bDigest = getHash(ITERATION_NUMBER, stringToEncrypt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newString = byteToBase64(bDigest);
		return newString;
	}

	public static boolean isPasswordValid(String dbPassword, String userPassword){
		byte[] bDigest = null;
		byte[] proposedDigest = null;
		
		try {
			bDigest = base64ToByte(dbPassword);
			// Compute the new DIGEST
			proposedDigest = getHash(ITERATION_NUMBER, userPassword);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Arrays.equals(proposedDigest, bDigest);
		
	}
	
	/**
	 * From a password, a number of iterations and a salt, returns the
	 * corresponding digest
	 * 
	 * @param iterationNb
	 *            int The number of iterations of the algorithm
	 * @param password
	 *            String The password to encrypt
	 * @return byte[] The digested password
	 * @throws NoSuchAlgorithmException
	 *             If the algorithm doesn't exist
	 */

	public static byte[] getHash(int iterationNb, String password)
			throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		byte[] input = null;
		try {
			input = digest.digest(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < iterationNb; i++) {
			digest.reset();
			input = digest.digest(input);
		}
		return input;
	}

	/**
	 * From a base 64 representation, returns the corresponding byte[]
	 * 
	 * @param data
	 *            String The base64 representation
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] base64ToByte(String data) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(data);
	}

	/**
	 * From a byte[] returns a base 64 representation
	 * 
	 * @param data
	 *            byte[]
	 * @return String
	 * @throws IOException
	 */
	public static String byteToBase64(byte[] data) {
		BASE64Encoder endecoder = new BASE64Encoder();
		return endecoder.encode(data);
	}

}
