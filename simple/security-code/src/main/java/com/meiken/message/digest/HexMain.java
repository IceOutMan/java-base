package com.meiken.message.digest;

/**
 * @Author glf
 * @Date 2022/1/23
 */
public class HexMain {
    public static void main(String[] args) {
        byte[] testBytes = new byte[]{-1};
        String hexStr = bytes2Hex(testBytes);
        byte[] bytes = hexString2Bytes(hexStr);
        System.out.println(hexStr);
        System.out.println(bytes[0]);

    }

    public static String byteToBit(byte b){
        return ""
                + (byte)((b >> 7) & 0x1) + (byte)((b >> 6) & 0x1)
                + (byte)((b >> 5) & 0x1) + (byte)((b >> 4) & 0x1)
                + (byte)((b >> 3) & 0x1) + (byte)((b >> 2) & 0x1)
                + (byte)((b >> 1) & 0x1) + (byte)((b >> 0) & 0x1);
    }


    public static String bytes2Hex(byte[] bytes){
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];

            String temp = Integer.toHexString(b & 0xFF);
            if( temp.length() == 1){
                hex.append("0");
            }
            hex.append(temp.toLowerCase());
        }
        return hex.toString();
    }

    public static byte[] hexString2Bytes(String hexString){
        if(hexString == null || hexString.equals("")){
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos +1]));
        }
        return d;
    }

    private static byte charToByte(char c){
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

}


