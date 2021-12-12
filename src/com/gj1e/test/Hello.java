package com.gj1e.test;


/**
 * @author FenDa
 */
public class Hello {
    public static void main(String[] args) {
        String a = "[\"用法用量不合规\",\"超量用药\",\"诊断不合规或缺诊断\",\"规格不完整\"]";
        String b = a.replaceAll("\\[|\\]| \\\\ |\"", "");
        System.out.println(b);
    }
}
