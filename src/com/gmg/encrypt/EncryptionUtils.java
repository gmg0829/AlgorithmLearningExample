package com.frame.util;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description: 加密算法
 * @date 2018/8/29  9:35
 */
public class EncryptionUtils {

    //使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
    private static String aesKEY = "123456789abcdefg";
    private static String aesIV = "123456789abcdefg";
    //DES加密的key 长度为八位
    private static String desKey = "bs7dff53";



    /**
     * SHA1算法进行加密
     * @param decript
     * @return
     * @throws Exception
     */
    public static String getSHA1(String decript)throws Exception
    {
        MessageDigest digest = MessageDigest
                .getInstance("SHA-1");
        digest.update(decript.getBytes());
        byte messageDigest[] = digest.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++)
        {
            String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
    }


    /**
     * 加密方法
     * @param data  要加密的数据
     * @param key 加密key
     * @param iv 加密iv
     * @return 加密的结果
     * @throws Exception
     */
    public static String encryptAES(String data) throws Exception {
        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//"算法/模式/补码方式"
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(aesKEY.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(aesIV.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new Base64().encodeToString(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密方法
     * @param data 要解密的数据
     * @param key  解密key
     * @param iv 解密iv
     * @return 解密的结果
     * @throws Exception
     */
    public static String desEncryptAES(String data) throws Exception {
        try {
            byte[] encrypted1 = new Base64().decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(aesKEY.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(aesIV.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * DES加密
     * @param datasource
     * @return
     */
    public static String encryptDES(String datasource){
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKeys = new DESKeySpec(desKey.getBytes("UTF-8"));
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKeys);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            byte[] temp = Base64.encodeBase64(cipher.doFinal(datasource.getBytes()));
            return IOUtils.toString(temp,"UTF-8");
        }catch(Throwable e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * DES解密
     * @return
     */
    public static String decodeDES(String data) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKeys = new DESKeySpec(desKey.getBytes("UTF-8"));
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKeys);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return IOUtils.toString(cipher.doFinal(Base64.decodeBase64(data)),"UTF-8");
    }


    public static void main(String[] args) throws  Exception{


        System.out.println(EncryptionUtils.encryptAES("admin"));
    }

}
