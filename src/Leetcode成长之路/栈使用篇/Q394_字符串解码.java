package Leetcode成长之路.栈使用篇;

import java.util.*;

class Q394_字符串解码 {
    /* 字符串编码
    输入：s = "3[a2[c]]"
    输出："accaccacc"
    */
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("");
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                String pre = stack.pop();
                stack.push(pre + c);
            } else if (c == '[') {
                stack.push(Character.toString(c));
                stack.push("");
            } else if (c == ']') {
                String pre = stack.pop();
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                StringBuilder res = new StringBuilder();
                while (num-- != 0){
                    res.append(pre);
                }
                stack.push(stack.pop()+res.toString());
            }else if(Character.isDigit(c)){
                if(stack.peek() != null && !stack.peek().isBlank() && Character.isDigit(stack.peek().charAt(0))){
                    stack.push(stack.pop()+c);
                }
                else stack.push(Character.toString(c));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Q394_字符串解码 q394字符串解码 = new Q394_字符串解码();
        Scanner scanner = new Scanner(System.in);

    }
}