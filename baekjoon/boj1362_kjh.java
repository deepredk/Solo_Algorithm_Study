package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    
    int numberOfCase = 1;
    while (true) {
      int properWeight = Input.nextInt();
      int weight = Input.nextInt();
      boolean isDead = false;

      if (properWeight == 0) break;

      while (true) {
        char command = Input.nextChar();
        int parameter = Input.nextInt();

        if (command == 'F') {
          weight += parameter;
        }
        if (command == 'E') {
          weight -= parameter;
          if (weight <= 0) isDead = true;
        }

        if (command == '#') {
          sb.append(numberOfCase++).append(' ').append(isDead ? "RIP" : diagnoseCondition(properWeight, weight))
            .append('\n');
          break;
        }
      }
    }

    System.out.print(sb);
  }

  static String diagnoseCondition(int properWeight, int weight) {
    if (weight < 0) return "RIP";

    if (weight > properWeight / 2 && weight < properWeight * 2) {
      return ":-)";
    }

    return ":-(";
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