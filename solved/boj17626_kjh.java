package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  static int[] memorizedLeastSquares;

  public static void main(String[] args) throws Exception {
    int num = Input.nextInt();
    
    memorizedLeastSquares = new int[50001];
    System.out.print(getLeastSquares(num));
  } 

  static int getLeastSquares(int num) {
    if (num == 0) return 0;
    if (memorizedLeastSquares[num] != 0) return memorizedLeastSquares[num];

    int sqrted = (int) Math.floor(Math.sqrt(num));
    int leastSquares = 50000;

    for (int i = sqrted; i >= 1; i--) {
      int square = (int) Math.pow(i, 2);
      if (num < square) continue;
      leastSquares = Math.min(leastSquares, 1 + getLeastSquares(num - square));
    }

    memorizedLeastSquares[num] = leastSquares;
    return leastSquares;
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