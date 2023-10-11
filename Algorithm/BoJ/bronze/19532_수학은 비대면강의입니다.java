// https://www.acmicpc.net/problem/19532

package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은_비대면강의입니다_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];
        int i = 0;

        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (x * arr[0] + y * arr[1] == arr[2]) {
                    if (x * arr[3] + y * arr[4] == arr[5]) {
                        System.out.print(x + " " + y);
                        break;
                    }
                }
            }
        }
    }
}
