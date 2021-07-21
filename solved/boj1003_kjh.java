package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  static int[] numberOfCallingZero;
  static int[] numberOfCallingOne;

  public static void main(String[] args) throws Exception {
    final int T = Input.nextInt();
    
    numberOfCallingZero = new int[41];
    numberOfCallingOne = new int[41];

    numberOfCallingZero[0] = 1;
    numberOfCallingZero[2] = 1;
    numberOfCallingOne[1] = 1;
    numberOfCallingOne[2] = 1;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int n = Input.nextInt();
      sb.append(getNumberOfCallingZero(n))
        .append(' ')
        .append(getNumberOfCallingOne(n))
        .append('\n');
    }

    System.out.print(sb);
  }

  static int getNumberOfCallingZero(int n) {
    if (n == 1) return 0;
    if (numberOfCallingZero[n] != 0) return numberOfCallingZero[n];

    numberOfCallingZero[n] = getNumberOfCallingZero(n - 1) + getNumberOfCallingZero(n - 2);
    return numberOfCallingZero[n];
  }

  static int getNumberOfCallingOne(int n) {
    if (n == 0) return 0;
    if (numberOfCallingOne[n] != 0) return numberOfCallingOne[n];

    numberOfCallingOne[n] = getNumberOfCallingOne(n - 1) + getNumberOfCallingOne(n - 2);
    return numberOfCallingOne[n];
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