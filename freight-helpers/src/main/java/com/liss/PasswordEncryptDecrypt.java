package com.liss;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/*import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;*/
import java.util.Base64;


public class PasswordEncryptDecrypt /*implements PasswordEncoder*/ {
	
/*	private static String ALGORITHME = "AES";
    private static String SEC_KEY = "L155FRE1GHTPa55w0rd-Key-5ecurity";
    
    *//** genere une key prive appartie de SEC_KEY **//*
    
    private static Key generateKeyFromString(String secKey) throws Exception {
         byte[] keyVal  = secKey.getBytes();
         Key key = new SecretKeySpec(keyVal, ALGORITHME);
         return key;
     }
     
     @Override
     public String encode(CharSequence  valueEnc) { 
         String encryptedVal = null;
         try {
             Key key = generateKeyFromString(SEC_KEY);;
             Cipher c = Cipher.getInstance(ALGORITHME);
             c.init(Cipher.ENCRYPT_MODE, key);
             byte[] encValue = c.doFinal(valueEnc.toString().getBytes());
             encryptedVal = Base64.getEncoder().encodeToString(encValue);
         } catch(Exception ex) {
             System.out.println("Erreur lors du chiffrement du mot de passe : " + ex);
         }
        // System.err.println("encrypt: ("+valueEnc+") => ("+encryptedVal+")");
         return encryptedVal;
     }
     
     private String decrypt(String encryptedValue) {
         String decryptedValue = null;
         try {
             Key key = generateKeyFromString(SEC_KEY);
            // System.out.println(key.getEncoded().toString());
             Cipher c = Cipher.getInstance(ALGORITHME);
             c.init(Cipher.DECRYPT_MODE, key);
             //byte[] decorVal = new BASE64Decoder().decodeBuffer(encryptedValue);
             byte[] decorVal = Base64.getDecoder().decode(encryptedValue);
             byte[] decValue = c.doFinal(decorVal);
             decryptedValue = new String(decValue);
         } catch(Exception ex) {
             System.out.println("Erreur lors du déchiffrement du mot de passe : " + ex);
         }
         
        // System.err.println("decrypt: ("+encryptedValue+") => ("+decryptedValue+")");
         return decryptedValue;
     }

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		boolean isMatches = decrypt(encodedPassword).equals(rawPassword.toString());
		return isMatches;
	}*/

}
