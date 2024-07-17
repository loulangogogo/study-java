package io.github.loulangogogo.test04;

import io.gitee.loulan_yxq.owner.core.crypto.AESTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import lombok.extern.slf4j.Slf4j;

/*********************************************************
 ** 加密和解密工具类，主要使用AES加解密
 ** <br><br>
 ** Date: Created in 2022/11/22 12:22
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
@Slf4j
public class EncryptAndDecryptTool {

    // 加密串的前缀，没有这个串认为没有加密
    private final static String ENCRYPT_DATA_PRE = "DRAGON_E_";

    // 生成密钥需要的盐值
    private final static String KEY_SALT = "11029_YXQ@56%";
    // 加解密密钥
    public static String encryptAndDecryptKey;

    static {
        try {
            encryptAndDecryptKey = AESTool.getkey(KEY_SALT);
        } catch (Exception e) {
            throw new RuntimeException("生产加解密密钥key错误。", e);
        }
    }

    /**
     * 加密
     * @param   data 要进行加密的数据
     * @return  加密后的数据
     * @throws
     * @author :loulan
     */
    public static String encrypt(String data) {
        try {
            return AESTool.encrypt(encryptAndDecryptKey, data);
        } catch (Exception e) {
            throw new RuntimeException("数据加密失败，请检查参数是否正确。");
        }
    }

    /**
     * 尝试加密
     * 如果数据已经是加密数据那么不再进行加密
     *
     * @param data 要进行加密的数据
     * @return 加密后的数据
     * @throws
     * @author :loulan
     */
    public static String tryEncrypt(String data) {
        if (StrTool.isEmpty(data)) {
            return data;
        }
        if (isEncryptData(data)) {
            return data;
        }
        return ENCRYPT_DATA_PRE+encrypt(data);
    }

    /**
     * 解密
     * 直接解密
     * @param       encryptData 被解密数据
     * @return      解密后的数据
     * @exception
     * @author     :loulan
     * */
    public static String decrypt(String encryptData) {
        try {
            return AESTool.decrypt(encryptAndDecryptKey, encryptData);
        } catch (Exception e) {
            log.error("数据{}解密异常{}", encryptData, e.getMessage());
            return encryptData;
        }
    }

    /**
     * 尝试解密
     * 如果不是加密数据就直接返回
     * @param       encryptData 被解密数据
     * @return      解密后的数据
     * @exception
     * @author     :loulan
     * */
    public static String tryDecrypt(String encryptData) {
        if (StrTool.isEmpty(encryptData)) {
            return encryptData;
        }
        if (!isEncryptData(encryptData)) {
            return encryptData;
        }

        return decrypt(getEncryptStr(encryptData));
    }


    /**
     * 检查判断一个数据是加密串
     *
     * @param data 要进行判断的数据
     * @return 是否是加密串
     * @throws
     * @author :loulan
     */
    public static Boolean isEncryptData(String data) {
        if (StrTool.isEmpty(data)) {
            return Boolean.FALSE;
        }
        return data.startsWith(ENCRYPT_DATA_PRE);
    }

    /**
     * 获取加密字符串，不包含前缀的纯加密串
     * 如果参数不是加密串那么原串返回。
     * @param       data
     * @return
     * @exception
     * @author     :loulan
     * */
    private static String getEncryptStr(String data) {
        if (isEncryptData(data)) {
            return data.replaceFirst(ENCRYPT_DATA_PRE, "");
        } else {
            return data;
        }
    }
}
