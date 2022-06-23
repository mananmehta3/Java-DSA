package com.company.Fundamentals;

public class strings {

    public static void main(String[] args) {
//        String a = "Manan";
//        String b = new String("Manan");
//        System.out.println(a.equals(b));
//        System.out.println(a == b);
//        System.out.println("Nishika");
//        // System.out.println(b.length() + " " + b.charAt(2));
//        String name = null;
//        System.out.println(name);
//        int num = 7;
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Arrays.toString(new int[]{}));
//
        // PrettyPrinting
//         float a = 453.728739f;
//         System.out.println(a);
//         System.out.printf("%.2f",a);
//        System.out.println();
//        System.out.printf("%.3f",Math.PI);
        // System.out.printf("My name is %s and I am %s cool","Manan","Super");
//        System.out.println('a' + 'b');
//        System.out.println("a" + "b" + new ArrayList<>());
//        System.out.println((char)('a'+3));
//        System.out.println("Kunal"+56+new ArrayList<>());

        // Performance
//        String str = ""; // o(n^2) complexity
//        for (int i = 0; i < 26; i++) {
//            char ch = (char) ('a' + i);
//            str += ch;
//        }
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < 26; i++) {
//            char ch = (char) ('a' + i);
//            str.append(ch);
//        }
//        System.out.println(str.toString());
//        StringBuilder n = new StringBuilder();
//        String name = "Manan";
//        n.append(name);
//        System.out.println(str.deleteCharAt(3));
//        System.out.println(n.lastIndexOf("a"));

    // Methods
        String name = "A man, a plan, a canal: Panama";
//        name = name.toUpperCase();
//        System.out.println(Arrays.toString(name.toCharArray()));
//        System.out.println(Arrays.toString(name.split(" ")));
        String ans = name.replaceAll("[^a-zA-Z]","");
        ans = ans.toLowerCase();
        System.out.println(ans.strip());
    }

}
