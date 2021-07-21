package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

class Main {
  public static void main(String[] args) throws Exception {
    final int MONSTERS = Input.nextInt();
    final int PROBLEMS = Input.nextInt();

    Map<String, Integer> monsterMap = new HashMap<>();

    String[] monsters = new String[MONSTERS + 1];
    for (int i = 1; i <= MONSTERS; i++) {
      monsters[i] = Input.nextLine();
      monsterMap.put(monsters[i], i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < PROBLEMS; i++) {
      String problem = Input.nextLine();
      if (Character.isDigit(problem.charAt(0))) {
        int problemNumber = Integer.parseInt(problem);
        sb.append(monsters[problemNumber]).append('\n');
        continue;
      }

      sb.append(monsterMap.get(problem)).append('\n');
    }
    System.out.print(sb);
  }
}

class Input {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer tokenizer;

  public static String nextLine() {
    try {
      return br.readLine();
    } catch(Exception e) { }
    
    return null;
  }

  public static int nextInt() {
    String nextString = next();
    return Integer.parseInt(nextString);
  }

  public static double nextDouble() {
    String nextString = next();
    return Double.parseDouble(nextString);
  }

  public static long nextLong() {
    String nextString = next();
    return Long.parseLong(nextString);
  }

  public static char nextChar() {
    String nextString = next();
    return nextString.charAt(0);
  }
  
  public static String next() {
    makeTokensIfNeed();
    return tokenizer.nextToken();
  }

  public static void skipLine() {
    nextLine();
  }

  public static void skipLine(int n) {
    for (int i = 0; i < n; i++) {
      nextLine();
    }
  }
  
  private static void makeTokensIfNeed() {
    makeTokensIfNotReadedYet();
    makeTokensIfHasNoToken();
  }

  private static void makeTokensIfNotReadedYet() {
    if (tokenizer == null) {
      tokenizer = makeTokens();
    }
  }

  private static void makeTokensIfHasNoToken() {
    if (tokenizer.hasMoreTokens() == false) {
      tokenizer = makeTokens();
    }
  }
  
  private static StringTokenizer makeTokens() {
    return new StringTokenizer(nextLine(), " ");
  }
}