package fantastzjy.temp;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Base64;
public class Encryption {

    private static byte[] sharedkey = {
            0x01, 0x02, 0x03, 0x05, 0x07, 0x0B, 0x0D, 0x11,
            0x12, 0x11, 0x0D, 0x0B, 0x07, 0x02, 0x04, 0x08,
            0x01, 0x02, 0x03, 0x05, 0x07, 0x0B, 0x0D, 0x11
    };

    private static byte[] sharedvector = {
            0x01, 0x02, 0x03, 0x05, 0x07, 0x0B, 0x0D, 0x11
    };


    public static void main(String... argv)
            throws Exception {
        String plaintext = "userNameHere:passwordHere";
        String ciphertext = encrypt(plaintext);
        System.out.println(ciphertext);
        System.out.println(decrypt(ciphertext));


        System.out.println();
        System.out.println(
                Encryption.encrypt2("s=w&u=123123&l=sss&p=rrrr&b=a&a=dfsdfsdfsdfsdfsdfsdf", "lhXnlyyppPe+zw21oG6Fln4hC726Chxc", "lyy6EzLPPOc=")
        );
        //System.out.println(
        //        "097118198035119046030008183168156231253013005013147251118016107198046244035246229041188113148051138174006059159011092028048219027013181227183229083010030144227083081028"
        //);


    }

    public static String encrypt(String plaintext)
            throws Exception {
        Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(sharedkey, "DESede"), new IvParameterSpec(sharedvector));
        byte[] encrypted = c.doFinal(plaintext.getBytes("UTF-8"));
        return Base64.encode(encrypted);
    }

    public static String decrypt(String ciphertext)
            throws Exception {
        Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(sharedkey, "DESede"), new IvParameterSpec(sharedvector));
        byte[] decrypted = c.doFinal(Base64.decode(ciphertext));
        return new String(decrypted);
    }


    public static String encrypt2(String plaintext, String sKey, String sIv) throws Exception {
        Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        //for (byte b : org.apache.commons.codec.binary.Base64.decodeBase64(sKey)) {
        //    System.out.println(b+" ");
        //}
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(
                        org.apache.commons.codec.binary.Base64.decodeBase64(sKey), "DESede"),
                new IvParameterSpec(org.apache.commons.codec.binary.Base64.decodeBase64(sIv)
                ));
        byte[] encrypted = c.doFinal(plaintext.getBytes("UTF-8"));

        byte[] mm = new byte[encrypted.length];
        for (int i = 0; i < encrypted.length; i++) {
            mm[i] = (byte) (encrypted[i] & 0xff);
        }

        System.out.println();
        //System.out.println(String.valueOf(encrypted));

        //java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        return new BASE64Encoder().encode(encrypted);

        //return new String(decoder.decode(str.getBytes()), "UTF-8");

        //return Base64.encodeBase64(encrypted).toString();
        //return Base64.encodeBase64(encrypted);
        //return new String(Base64.encode(encrypted));
    }


}