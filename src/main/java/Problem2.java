import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        //存储字符和他们出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //得到出现最多的ch
        int maxValue = 0;
        for (int value : map.values()) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        //构不成
        if (maxValue > (map.size() - 1) / 2) {
            System.out.println("");
            return;
        }
        //应该按照频率排序,然后把后面的插入到前面的
        System.out.println(map);
        System.out.println(maxValue);
    }
}
