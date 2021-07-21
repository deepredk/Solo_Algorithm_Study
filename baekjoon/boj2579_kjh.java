package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    final int STAIRS = Input.nextInt();

    int[] stairs = new int[STAIRS + 1];
    for (int i = 1; i <= STAIRS; i++) {
      stairs[i] = Input.nextInt();
    }

    System.out.print(getMaxScore(stairs, 0, 0));
  }

  static int getMaxScore(int[] stairs, int currentStair, int oneStepCount) {
    int score = stairs[currentStair];
    int maxScore = score;
    
    if (currentStair <= stairs.length - 3) {
      maxScore = Math.max(maxScore, score + getMaxScore(stairs, currentStair + 2, 0));
    }
    if (oneStepCount <= 1 && currentStair <= stairs.length - 2) {
      maxScore = Math.max(maxScore, score + getMaxScore(stairs, currentStair + 1, oneStepCount + 1));
    }

    return maxScore;
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