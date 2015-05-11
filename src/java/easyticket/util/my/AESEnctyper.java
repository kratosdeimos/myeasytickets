package inet.util.my;


import inet.util.my.Base64;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

import inet.util.my.Base64;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AESEnctyper {
        //THO 13/11/2013  
	//http://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
	//  "algorithm/mode/padding" or  "algorithm"
	//PHP & Test: http://www.coderelic.com/examples/AES_Encryption_Example.php 
	
	private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String aesEncryptionAlgorithm = "AES";
    public static String KEY_AES = "c4b2420d95eac679a2a1c37e2d8eb7eb";
    
    public static  byte[] decrypt(byte[] cipherText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }
 
    public static byte[] encrypt(byte[] plainText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {	
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }
 
    private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException{
        byte[] keyBytes= new byte[16];
        byte[] parameterKeyBytes= key.getBytes(characterEncoding);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }
 
    /// <summary>
    /// Encrypts plaintext using AES 128bit key and a Chain Block Cipher and returns a base64 encoded string
    /// </summary>
    /// <param name="plainText">Plain text to encrypt</param>
    /// <param name="key">Secret key</param>
    /// <returns>Base64 encoded string</returns>
    public static String encrypt(String plainText, String key) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        byte[] plainTextbytes = plainText.getBytes(characterEncoding);
        byte[] keyBytes  = getKeyBytes(key);
        byte[] iniVector = keyBytes;
        return Base64.encodeToString(encrypt(plainTextbytes, keyBytes, iniVector), Base64.DEFAULT);
    }
 
    /// <summary>
    /// Decrypts a base64 encoded string using the given key (AES 128bit key and a Chain Block Cipher)
    /// </summary>
    /// <param name="encryptedText">Base64 Encoded String</param>
    /// <param name="key">Secret Key</param>
    /// <returns>Decrypted String</returns>
    public static String decrypt(String encryptedText, String key) throws KeyException, GeneralSecurityException, GeneralSecurityException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException{
        byte[] cipheredBytes = Base64.decode(encryptedText, Base64.DEFAULT);
        byte[] keyBytes = getKeyBytes(key);
        byte[] iniVector = keyBytes;
        return new String(decrypt(cipheredBytes, keyBytes, iniVector), characterEncoding);
    }
    
    public static void main(String args[]) {
    	try {
    		//KEY must be either 16, 24, or 32 bytes in length for 128, 192, and 256 bit encryption respectively
    		String s = AESEnctyper.encrypt("Chào Cảnh Huyền", "1234567890abcdef");
    		System.out.println(s);
    		
    		String s2 = AESEnctyper.decrypt("ulTAbpbMiAOhYBUZWSoI1EIjP2V6PJjzMQDiIqdhphY=", "1234567890abcdef");
    		System.out.println(s2);
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
