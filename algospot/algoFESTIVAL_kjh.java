import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    final int T = Input.nextInt();

    for (int i = 0; i < T; i++) {
      int availableDays = Input.nextInt();
      int numberOfTeams = Input.nextInt();

      int[] costs = new int[availableDays];
      for (int j = 0; j < availableDays; j++) {
        costs[j] = Input.nextInt();
      }

      sb.append(getLeastAverageCost(costs, numberOfTeams)).append('\n');
    }

    System.out.print(sb);
  }

  static double getLeastAverageCost(int[] costs, int numberOfTeams) {
    double leastAverageCost = 100000.0;

    for (int i = numberOfTeams; i <= costs.length; i++) { // 몇일 빌릴지
      for (int j = 0; j <= costs.length - i; j++) { // 첫 인덱스
        int costSum = 0;
        for (int k = j; k < j + i; k++) { // 빌릴 인덱스
          costSum += costs[k];
        }
        leastAverageCost = Math.min(leastAverageCost, (double) costSum / i);
      }
    }

    return leastAverageCost;
  }
}

class Input {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer tokenizer;

  public static String nextLine() {
    try {
      String line = br.readLine();
      if (line.equals("")) {
        return nextLine();
      }
      return line;
    } catch (Exception e) {
    }

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
    if (!tokenizer.hasMoreTokens()) {
      tokenizer = makeTokens();
    }
  }

  private static StringTokenizer makeTokens() {
    StringTokenizer tokens = new StringTokenizer(nextLine(), " ");
    if (tokens.hasMoreTokens() == false) {
      makeTokens();
    }
    return tokens;
  }
}