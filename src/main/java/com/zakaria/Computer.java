package com.zakaria;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Computer {
    /*
    This class takes care about key generation,
    creating hmac, computer moves etc.
     */

    private final int keySize = 256;
    private String key;
    private String hmac;
    public String getKey() {
        return generateKey();
    }

    static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
//        System.out.println(sb);
        return sb.toString();
    }

    private String generateKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[keySize];
        random.nextBytes(key);
//        System.out.println(bytesToHex(key));
        return bytesToHex(key);
    }


    public static String generateHmac(String algorithm, String data, String key)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKeySpec);
        return bytesToHex(mac.doFinal(data.getBytes()));
    }

    public String generateMove(String[] arr) {
        SecureRandom random = new SecureRandom();
        int randomIndex = random.nextInt(arr.length);
        return arr[randomIndex];
    }

}
