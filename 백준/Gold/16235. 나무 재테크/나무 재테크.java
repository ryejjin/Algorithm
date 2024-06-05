import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] nutrient;
    static int[][] newNutrient;
    static ArrayList<Integer>[][] soil;
    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nutrient = new int[N][N];
        newNutrient = new int[N][N];
        soil = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(nutrient[i], 5); // 초기 양분은 모두 5
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                newNutrient[i][j] = Integer.parseInt(st.nextToken());
                soil[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            soil[x][y].add(z);
        }

        for (int year = 0; year < K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (ArrayList<Integer> trees : soil[i]) {
                ans += trees.size();
            }
        }

        System.out.println(ans);
    }

    static void springAndSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Collections.sort(soil[i][j]);
                ArrayList<Integer> newTrees = new ArrayList<>();
                int deadTreesNutrient = 0;
                for (int age : soil[i][j]) {
                    if (nutrient[i][j] >= age) {
                        nutrient[i][j] -= age;
                        newTrees.add(age + 1);
                    } else {
                        deadTreesNutrient += age / 2;
                    }
                }
                soil[i][j] = newTrees;
                nutrient[i][j] += deadTreesNutrient;
            }
        }
    }

    static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : soil[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                                soil[ni][nj].add(0, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrient[i][j] += newNutrient[i][j];
            }
        }
    }
}