package AAA熟悉各常使用的类;

public class String_ {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2); // true 因为s1和s2指向同一个字符串常量池中的对象
        System.out.println(s1 == s3); // false 因为s3是通过new关键字创建的对象 不在字符串常量池中
        System.out.println(s1.equals(s3)); // true 因为equals方法比较的是字符串的内容 而不是对象的地址
        // String类的常用方法
        String s4 = "hello world";
        System.out.println(s4.length()); // 11 返回字符串的长度
        System.out.println(s4.charAt(0)); // h 返回字符串中指定位置的字符
        System.out.println(s4.substring(0,5)); // hello 返回字符串中指定范围的子字符串
        System.out.println(s4.indexOf("o")); // 4 返回字符串中第一次出现指定字符或字符串的位置 如果没有找到返回-1
        System.out.println(s4.contains("world")); // true 判断字符串是否包含指定的字符或字符串
        // String转换Array
        String s5 = "abcde";
        char[] chars = s5.toCharArray(); // 将字符串转换为字符数组
        // String转换List
        String s6 = "a,b,c,d,e";
        String[] arr = s6.split(","); // 将字符串按照指定的分隔符分割成字符串数组
        // String转换Integer
        String s7 = "123";
        int num = Integer.parseInt(s7); // 将字符串转换为整数
        // Integer转换String
        int num2 = 456;
        String s8 = Integer.toString(num2); // 将整数转换为字符串
        // String是不可变类 任何对字符串的修改都会创建一个新的字符串对象
        String s9 = "abc";
        s9 = s9 + "def"; // 这里s9指向了一个新的字符串对象 "abcdef" 原来的字符串对象 "abc" 没有被修改
        System.out.println(s9); // abcdef
        // StringBuilder和StringBuffer是可变类 可以在原有的字符串对象上进行修改 不会创建新的对象
        StringBuilder sb = new StringBuilder("abc");
        sb.append("def"); // 在原有的字符串对象上追加字符串 "def"
        System.out.println(sb.toString()); // abcdef

    }
}
