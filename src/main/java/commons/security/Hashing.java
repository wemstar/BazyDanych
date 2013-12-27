package commons.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by wemstar on 27.12.13.
 */
public class Hashing {

    public static String hashPassword(String password)
    {
        String generatedPassword = null;

        try {
            //String salt=getSalt();
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            //md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    public static boolean comparePassword(String password1,String password2)
    {
        byte a[]=password1.getBytes();
        byte b[]=password2.getBytes();
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++)
             diff |= a[i] ^ b[i];
        return diff == 0;

    }
    private static String getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
