package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/12/18
 * @Time 19:28
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution20 {
    public boolean isNumeric(char[] str){
        if (str==null || str.length<=0)
            return false;
        //长度为1，则必须是数字0-9
        if (str.length==1){
            return str[0]>='0' && str[0]<='9';
        }

        boolean hasSign = false;//+-符号标志
        boolean hasDot = false; //'.'小数点标志
        boolean hasE = false;   //E或e标志
        for (int i = 0; i < str.length; i++) {
            if (str[i]=='+' || str[i]=='-'){
                //第一次出现且不在开头，则前一个字符必须是E或e
                if (!hasSign && i>0 && str[i-1]!='e' && str[i-1]!= 'E')
                    return false;
                //第二次出现+-符号，则前一个字符必须是E或e
                if (hasSign && str[i-1]!='e' && str[i-1]!= 'E')
                    return false;
                hasSign = true;

            }else if (str[i] == '.'){
                //只能出现一次小数点，且e或E之后不能出现
                if (hasDot || hasE) return false;

                hasDot = true;
            }else if (str[i]=='e' || str[i]=='E'){
                //E或e不能出现在最后一个
                if (i == str.length-1)  return false;

                //E或e只能出现一次
                if (hasE)   return false;

                hasE = true;

            }else if (str[i]<'0' || str[i]>'9'){
                //字符串中出现不是数字或者+-Ee这些符号的直接返回false;
                return false;
            }

        }
        return true;
    }
}
