import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, Integer> dict = new HashMap<>();

        for (int i=0; i<n; i++){
            String word = br.readLine();
            if (word.length() >= m){
                dict.put(word, dict.getOrDefault(word, 0)+1);
            }
        }
        List<String> words = new ArrayList<>(dict.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.compare(dict.get(o1), dict.get(o2)) != 0){
                    return Integer.compare(dict.get(o2), dict.get(o1));
                }
                if (o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word + "\n");
        }
        System.out.println(sb);
    }
}