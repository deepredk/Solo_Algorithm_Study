package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  static int[] memorized;

  public static void main(String[] args) throws Exception {
    final int T = Input.nextInt();
    memorized = new int[12];

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int n = Input.nextInt();
      sb.append(solve(n)).append('\n');
    }
    System.out.print(sb);
  }

  static int solve(int n) {
    if (n == 0) return 1;
    if (memorized[n] != 0) return memorized[n];

    int cases = 0;
    if (n >= 3) {
      cases += solve(n - 3);
    }
    if (n >= 2) {
      cases += solve(n - 2);
    }
    cases += solve(n - 1);
    
    memorized[n] = cases;
    return memorized[n];
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