public class SpinWords {

  public String spinWords(String sentence) {
    StringBuilder sb = new StringBuilder();
    for (String s : sentence.split(" ")){
      if (s.length() >= 5)
        s = reverse(s);
      sb.append(s).append(' ');
    }

    return sb.toString().trim();
  }
  
  public String reverse(String input){
    char[] in = input.toCharArray();
    int begin=0;
    int end=in.length-1;
    char temp;
    while(end>begin){
        temp = in[begin];
        in[begin]=in[end];
        in[end] = temp;
        end--;
        begin++;
    }
    return new String(in);
  }
}