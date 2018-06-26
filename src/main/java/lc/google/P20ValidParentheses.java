package lc.google;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * Input: "()"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: "()[]{}"
 * 
 * Output: true
 * 
 * Example 3:
 * 
 * Input: "(]"
 * 
 * Output: false
 * 
 * Example 4:
 * 
 * Input: "([)]"
 * 
 * Output: false
 * 
 * Example 5:
 * 
 * Input: "{[]}"
 * 
 * Output: true
 * 
 * @author zli
 *
 */
public class P20ValidParentheses {

  public boolean isValid(String s) {
    char[] charArray = s.toCharArray();

    char[] stack = new char[s.length()];
    int head = 0;

    for (char c : charArray) {
      if (isLeft(c))
        stack[head++] = c;
      else if (isRight(c)) {
        if (head <= 0)
          return false;
        else {
          Character t = theOther(c);
          if (t == null || t != stack[--head])
            return false;
        }
      }
    }
    return head == 0;
  }

  boolean isLeft(char c) {
    switch (c) {
      case '{':
        return true;
      case '[':
        return true;
      case '(':
        return true;
      default:
        return false;
    }
  }

  boolean isRight(char c) {
    switch (c) {
      case ']':
        return true;
      case '}':
        return true;
      case ')':
        return true;
      default:
        return false;
    }
  }

  Character theOther(char c) {
    switch (c) {
      case '}':
        return '{';
      case ']':
        return '[';
      case ')':
        return '(';
      default:
        return null;
    }
  }

  public static void main(String[] args) {
    P20ValidParentheses p = new P20ValidParentheses();

    assert p.isValid("()") == true;
    assert p.isValid("()[]{}") == true;
    assert p.isValid("(]") == false;
    assert p.isValid("([)]") == false;
    assert p.isValid("{[]}") == true;
    assert p.isValid("[") == false;
    assert p.isValid("]") == false;
  }

}
