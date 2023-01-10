import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class SplitWordCount2 {

  public static void main(String[] args) {
    List < String > terms = Arrays.asList(
      "Coding is great",
      "Search Engine are great",
      "Google is a nice search engine",
      "Bing is also a nice engine");

    terms = terms
      .replace(/([A-Z])/g, ' $1')
      .replace(/^./, function (str) { return str.toUpperCase(); })



    ConcurrentMap < String, Integer > wordFreq = terms
      .parallelStream() //Utilizes multi-core hardware
      .flatMap(s -> Arrays.stream(s.split(" ")))
      .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer:: sum)); // Big O(n)

    OptionalInt max = wordFreq
      .values()
      .parallelStream()
      .mapToInt(Integer:: valueOf)
      .max();

    if (max.isPresent()) {
      String[] freq = new String[max.getAsInt()];
      wordFreq.forEach((s, integer) -> {
        if(freq[integer - 1] == null) {
        freq[integer - 1] = s;
      } else {
        freq[integer - 1] = freq[integer - 1] + "," + s;
      }
    });
    for (int i = max.getAsInt() - 1; i >= 0; i--) {
      System.out.println((i + 1) + " --> " + freq[i]);
    }
  }
}
}
