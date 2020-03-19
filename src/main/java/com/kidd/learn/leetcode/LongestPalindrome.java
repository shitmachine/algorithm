package com.kidd.learn.leetcode;

import com.kidd.learn.Official;
import com.kidd.learn.Self;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        System.out.format("the palindrome result is %d", cal2(s));
        System.out.format("the palindrome result is %s" , cal1(s));
    }

    /**
     * 可以先将该字符川的所有字母分解。然后放入一个map中。
     * 如果该字符只有一个，那只取遍历到的第一个
     * 如果有两个则/2,最后翻转其中一边即得到结果
     * @param s
     * @return
     *
     */
    @Self
    private static String cal1(String s){
        if (s == null || s.length() == 0){
            return "";
        }

        Map<Character, Integer> maps = new HashMap<>();

        for (int i = 0 ; i < s.length(); i ++){
            if (maps.containsKey(s.charAt(i))){
                maps.put(s.charAt(i), maps.get(s.charAt(i)) + 1);
            } else {
                maps.putIfAbsent(s.charAt(i), 1);
            }
        }

        if (maps.size() == 1){
            return s;
        }

        StringBuilder the_odd_string = new StringBuilder();
        StringBuilder left_half = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : maps.entrySet()){
            //如果只有一个那么这个entry循环只进行一次
            if (entry.getValue() % 2 == 0){
                for (int i = 0; i < entry.getValue() /2; i ++ ){
                    left_half.append(entry.getKey());
                }
            } else {
                if ( the_odd_string.length() == 0){
                    for (int i = 0 ; i < entry.getValue(); i ++){
                        the_odd_string.append(entry.getKey());
                    }
                } else {
                    if (entry.getValue() > 1){
                        for (int i = 0 ; i < entry.getValue() / 2 * 2; i ++){
                            left_half.append(entry.getKey());
                        }
                    }
                }
            }
        }

        StringBuilder finalBuilder = new StringBuilder();
        String left_half_string = left_half.toString();
        String right_half_string = left_half.reverse().toString();
        if (the_odd_string.length() > 0){
            finalBuilder.append(left_half_string).append(the_odd_string.toString()).append(right_half_string);
        } else {
            finalBuilder.append(left_half_string).append(right_half_string);
        }
        return finalBuilder.toString();
    }

    /**
     * 前面读题错了，并不需要具体的输出，只需要输出长度，所以做下面的修改
     * @param s
     * @return
     */
    @Self
    private static int cal2(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> maps = new HashMap<>();
        s.chars().forEach(
                e -> {
                    char e_char = (char) e;
                    if (maps.containsKey(e_char)){
                        maps.put(e_char, maps.get(e_char) + 1);
                    } else {
                        maps.putIfAbsent(e_char, 1);
                    }
                }
        );

        if (maps.size() == 1){
            return maps.get(s.charAt(0));
        }

        int the_length = 0;
        boolean if_odd_added = false;
        for (Map.Entry<Character, Integer> entry : maps.entrySet()){
            if (!if_odd_added && entry.getValue() % 2 == 1){
                the_length += entry.getValue();
                if_odd_added = true;
            } else {
                if (entry.getValue() % 2 == 0){
                    the_length += entry.getValue();
                } else {
                    the_length += (entry.getValue() / 2 * 2);
                }
            }
        }
        return the_length;
    }

    /**
     * 官方的答案，果然简洁
     * @param s
     * @return
     */
    @Official
    private static int cal3(String s){
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

}
