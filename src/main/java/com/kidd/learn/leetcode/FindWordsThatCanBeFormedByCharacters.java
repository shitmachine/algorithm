package com.kidd.learn.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[] words = {"catt","bt","hat","tree"};
        String chars = "atachtbb";

        int result = cal2(words, chars);

        System.out.format("the cal2 result is %d", result);
    }

    /**
     * 暴力法，将所有单词遍历，每一个单词遍历其中每一个字母，在下面的循环中，字母表也遍历，若是匹配长度加1
     * @param words
     * @param chars
     * @return
     */
    private static int cal1(String[] words, String chars){
        return 0;
    }

    /**
     * 将chars转换为一个map，遍历words中的单词，逐一charAt(i),  如果map中有该元素，则直接-1，
     * @param words
     * @param chars
     * @return
     */
    private static int cal2(String[] words, String chars){
        if (chars == null || chars.length() == 0){
            return 0;
        }

        //1. 组织字母表
        Map<Character, Integer> maps = new HashMap<>(words.length);
        for (int i = 0; i < chars.length(); i ++){
             char ch = chars.charAt(i);
             if (maps.containsKey(ch)){
                 maps.put(ch, maps.get(ch) + 1);
             }  else {
                maps.put(ch, 1);
             }
        }

        // 2. 遍历每一个单词，并且通过maps来判断符不符合
        int result_length = 0;
        for (int i = 0; i < words.length; i ++){
            String word = words[i];
            Map<Character, Integer> new_maps = new HashMap<>(maps.size());
            maps.entrySet().forEach(
                    e -> {
                        new_maps.put(e.getKey(), e.getValue());
                    }
            );
            boolean is_right = true;
            // 判断new_map中是否存在该char， 如果存在且余量大于0， 则继续查询其余字母，若无或者余量为0， 直接舍弃该单词
            for (int j = 0; j < word.length(); j ++ ){
                char ch = word.charAt(j);
                if (new_maps.containsKey(ch)){
                    int remain = new_maps.get(ch);
                    if (remain < 1){
                        is_right = false;
                        break;
                    } else {
                        new_maps.put(ch, remain - 1);
                    }
                } else {
                    is_right = false;
                    break;
                }
            }
            if (is_right){
                result_length += words[i].length();
            }
        }
        return result_length;
    }


}
