/*
 * Copyright @Dreamer01
 */

package aes.project;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class AESAlgorithm {
    public static String algo ="AES";
    public byte[] keyValue;
    
    public AESAlgorithm(byte key[]){
        keyValue = key;
        
    }
    
    public Key  generateKey() throws Exception{
        Key key = new SecretKeySpec(keyValue,algo);
        return key;
    }
    
    public String encrypt(String msg) throws Exception {
         Key key=generateKey();
         Cipher c=Cipher.getInstance(algo);
         c.init(Cipher.ENCRYPT_MODE, key);
         byte[] encVal=c.doFinal(msg.getBytes());
         String encryptedText= new BASE64Encoder().encode(encVal);
         return encryptedText;
    }
    
    public String decrypt(String msg) throws Exception{
         Key key=generateKey();
         Cipher c=Cipher.getInstance(algo);
         c.init(Cipher.DECRYPT_MODE, key);
         byte[]decodedText=new BASE64Decoder().decodeBuffer(msg);
         byte[] decVal=c.doFinal(decodedText);
         String decryptedText= new String(decVal);
         return decryptedText; 
    }

}
