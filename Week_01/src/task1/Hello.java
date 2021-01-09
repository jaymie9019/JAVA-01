package task1;

/**
 * @author Jaymie on 2021/1/9
 */
public class Hello {
    private static int[] datas = {1, 2, 10, 200};
    public static void main(String[] args) {
        // 加法测试
        int a = 1;
        int b = 200;
        int c = a + b;
        System.out.println(c);

        // if 测试
        int max = 0;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        System.out.println(max);

        // for 测试
        int sum = 0;
        for (int num : datas) {
            sum += num;
        }
        System.out.println(sum);

    }
}
