package fantastzjy.temp;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtils {

    private static final Logger log = LoggerFactory.getLogger(DESUtils.class);

    //private static final String KEY_ALGORITHM = "DES";
    //private static final String DEFAULT_CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";// 默认的加密算法 "算法/模式/补码方式"

    private static final String KEY_ALGORITHM = "DES";
    //private static final String DEFAULT_CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding"; // 默认的加密算法 "算法/模式/补码方式"
    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/CBC/PKCS5Padding"; // 默认的加密算法 "算法/模式/补码方式"


    // s=w&u=123123&l=sss&p=rrrr&b=a&a=dfsdfsdfsdfsdfsdfsdf
    // 097118198035119046030008183168156231253013005013147251118016107198046244035246229041188113148051138174006059159011092028048219027013181227183229083010030144227083081028


    public static void main(String[] args) {
        System.out.println(
                DESUtils.encrypt("s=w&u=123123&l=sss&p=rrrr&b=a&a=dfsdfsdfsdfsdfsdfsdf", "lhXnlyyppPe+zw21oG6Fln4hC726Chxc", "lyy6EzLPPOc=")
                        .equals("097118198035119046030008183168156231253013005013147251118016107198046244035246229041188113148051138174006059159011092028048219027013181227183229083010030144227083081028")
        );
        System.out.println(
                DESUtils.encrypt("s=w&u=123123&l=sss&p=rrrr&b=a&a=dfsdfsdfsdfsdfsdfsdf", "lhXnlyyppPe+zw21oG6Fln4hC726Chxc", "lyy6EzLPPOc=")
        );
        System.out.println(
                "097118198035119046030008183168156231253013005013147251118016107198046244035246229041188113148051138174006059159011092028048219027013181227183229083010030144227083081028"
        );
    }

    /**
     * DES加密
     *
     * @param message
     * @param sKey
     * @param sIv
     * @return
     */
    public static String encrypt(String message, String sKey, String sIv) {
        try {
            DESKeySpec desKey = new DESKeySpec(Base64.decodeBase64(sKey));
            IvParameterSpec iv = new IvParameterSpec(Base64.decodeBase64(sIv));

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
            SecretKey secretKey = keyFactory.generateSecret(desKey);

            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            //byte[] result = cipher.doFinal(message.getBytes("UTF-8"));


            byte[] aa = message.getBytes("UTF-8");

            byte[] mm = new byte[aa.length];

            for (int i = 0; i < aa.length; i++) {
                mm[i] = (byte) (aa[i] & 0xff);
            }


            byte[] result = cipher.doFinal(mm);


            int[] data = new int[result.length];
            for (int i = 0; i < result.length; i++) {
                if (result[i] < 0) {
                    data[i] = result[i] + 128;
                    //data[i] = result[i] & 0xff;
                } else {
                    data[i] = result[i];
                }
            }

            // byte[] arrayOfByte1 = Encoding.UTF8.GetBytes (paramString);

            String result1 = "";
            for (int j : data) {
                result1 += GetString(j);
            }

            return result1;
            //return new String(result, "ascii");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private static String GetString(int asci) {
        String result = String.valueOf(asci);
        switch (result.length()) {
            case 1:
                return "00" + result;
            case 2:
                return "0" + result;
            default:
                return result;
        }
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * DES解密
     *
     * @param message
     * @param sKey
     * @param sIv
     * @return
     */
    public static String decrypt(String message, String sKey, String sIv) {
        try {
            DESKeySpec desKey = new DESKeySpec(Base64.decodeBase64(sKey));
            IvParameterSpec iv = new IvParameterSpec(Base64.decodeBase64(sIv));

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
            SecretKey secretKey = keyFactory.generateSecret(desKey);

            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

            byte[] retByte = cipher.doFinal(message.getBytes("UTF-8"));
            return new String(retByte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
