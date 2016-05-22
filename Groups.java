import java.util.Stack;

public class Groups{

  public static void main(String[] args) {
    System.out.println(groupCheck("({}())"));
  }


  public static boolean groupCheck(String s){
    String opens = "([{";
    String closes = ")]}";
    char[] arr = s.toCharArray();
    int i = 0;
    
    Stack<Character> st = new Stack<>();
    for (; i < arr.length; ++i){
      Character ch = arr[i];
      if (opens.indexOf(ch) != -1){
        st.push(ch);
      }
      else if(closes.indexOf(ch) != -1){
        if (st.empty())
          break;
        char o = st.pop();
        if(opens.indexOf(o) != closes.indexOf(ch))
          return false;
      }
    }
    
    if (st.empty() && i == arr.length)
      return true;
    
    return false;
  }
  
}