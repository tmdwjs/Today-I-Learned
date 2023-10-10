// https://www.acmicpc.net/problem/1816

package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호_키_1816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long s = Long.parseLong(br.readLine());

            for (int j = 2; j <= 1000001; j++) {
                if (s % j == 0) {
                    System.out.println("NO");
                    break;
                }

                if (j == 1000001) {
                    System.out.println("YES");
                }
            }
        }
    }
}
