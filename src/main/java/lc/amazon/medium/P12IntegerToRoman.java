package lc.amazon.medium;

public class P12IntegerToRoman {
  public String intToRoman(int num) {

    StringBuilder sb = new StringBuilder();

    int m = num / 1000;

    if (m > 0) {
      num -= m * 1000;
      sb.append(a(m, "M", "", ""));
    }


    m = num / 100;

    if (m > 0) {
      num -= m * 100;
      sb.append(a(m, "C", "D", "M"));
    }

    m = num / 10;

    if (m > 0) {
      num -= m * 10;
      sb.append(a(m, "X", "L", "C"));
    }

    if (num > 0) {
      sb.append(a(num, "I", "V", "X"));
    }

    return sb.toString();
  }

  private String a(int digit, String one, String five, String ten) {
    String s = null;
    switch (digit) {
      case 1:
        s = one;
        break;
      case 2:
        s = one + one;
        break;
      case 3:
        s = one + one + one;
        break;
      case 4:
        s = one + five;
        break;
      case 5:
        s = five;
        break;
      case 6:
        s = five + one;
        break;
      case 7:
        s = five + one + one;
        break;
      case 8:
        s = five + one + one + one;
        break;
      case 9:
        s = one + ten;
        break;
      default:
        s = "";
        break;
    }

    return s;
  }

  public static void main(String[] args) {
    P12IntegerToRoman p = new P12IntegerToRoman();
    System.out.println(p.intToRoman(1993));
  }

}
