package com.diversius.acciona.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class HashUtil {
    public static String createHash() {
        try {
            String uuid = UUID.randomUUID().toString();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(uuid.getBytes());
            return Hex.encodeHexString(md5);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
