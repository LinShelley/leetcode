import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**1. Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * @param nums [2, 7, 11, 15]
     * @param target 9
     * @return [0, 1]
     */
    private static int[] twoSum(int nums[], int target) {
        int a = 0, b = 0;
        Map<Long, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            Long f = (long) (nums[i] * (target - nums[i]));
            if(m.containsKey(f)) {
                a = m.get(f);
                if(nums[a] + nums[i] == target) {  //存在f为负的情况
                    b = i;
                    break;
                }
            }
            m.put(f, i);
        }
        return new int[]{a, b};
    }

    /**2. Add Two Numbers
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * @param l1 (2 -> 4 -> 3)
     * @param l2 (5 -> 6 -> 4)
     * @return    7 -> 0 -> 8
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p3 = new ListNode(0);
        ListNode res = p3;
        int tmp = 0;
        boolean first = true;
        while (!(l1 == null && l2 == null)) {
            int s = tmp;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            if(!first) {
                p3.next = new ListNode(0);
                p3 = p3.next;
            }
            p3.val = s % 10;
            tmp = s / 10;
            first = false;
        }
        if(tmp > 0) {
            p3.next = new ListNode(tmp);
        }
        return res;
    }

    /**3. Longest Substring Without Repeating Characters
     * Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param s 'abcabcbb'
     * @return 3
     */
    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = 0, curr = 0;
        String str = "";
        for(int i = 0; i < s.length(); i ++) {
            String c = s.substring(i, i+1);
            int idx = str.lastIndexOf(c);
            if (idx != -1) {
                max = max>curr ? max : curr;
                curr = 1;
                str = str.substring(idx, str.length());
                System.out.println(str);
            } else {
                str += c;
                curr ++;
            }
        }
        max = max>curr ? max : curr;
        System.out.println(str);
        return max;
    }

    /**6. ZigZag Conversion
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *And then read line by line: "PAHNAPLSIIGYIR"
     * @param s  "PAYPALISHIRING"
     * @param numRows  3
     * @return  PAHNAPLSIIGYIR"
     */
    public static String convert(String s, int numRows) {
        return "";
    }

    public static void main1(String[] args) {
        int[] nums = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
        int target = 542;
        int[] res = twoSum(nums, target);
        System.out.println(nums.length);
        for (int re : res) {
            System.out.println(re);  //28 45
        }
    }

    public static void main2(String[] args) {
        ListNode p1 = new ListNode(2);
        ListNode p12 = new ListNode(4);
        ListNode p13 = new ListNode(3);
        ListNode p2 = new ListNode(5);
        ListNode p22 = new ListNode(6);
        ListNode p23 = new ListNode(4);
        p1.next = p12;
        p12.next = p13;
        p2.next = p22;
        p22.next = p23;
        ListNode rs = addTwoNumbers(p1, p2);
        while (rs != null) {
            System.out.print(rs.val + " -> ");
            rs = rs.next;
        }
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
