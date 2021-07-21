package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Main {
  public static void main(String[] args) throws Exception {
    List<Integer> scores = new ArrayList<>();

    int totalScore = 0;
    for (int i = 0; i < 8; i++) {
      int score = Input.nextInt();

      scores.add(score);
      totalScore += score;
    }

    List<Integer> top5Scores = scores.stream()
      .sorted(Comparator.reverseOrder())
      .limit(5)
      .collect(toList());

    int top5ScoresSum = top5Scores.stream().reduce(0, Integer::sum);
    String top5AnswersNumber = top5Scores.stream()
      .mapToInt(i -> scores.indexOf(i) + 1)
      .sorted()
      .mapToObj(String::valueOf)
      .collect(joining(" "));
    
    System.out.println(top5ScoresSum);
    System.out.println(top5AnswersNumber);
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