import java.util.ArrayList;
import java.util.List;

public class Solution151 {

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords2("the sky is blue"));

    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        int wordStart = 0;
        int wordEnd = 0;
        int maxIndex = s.length();
        while(maxIndex > 0 && s.charAt(maxIndex-1) == ' ') {
            maxIndex--;
        }

        while (wordEnd < maxIndex){
            while (wordStart < maxIndex && s.charAt(wordStart) == ' ') {
                wordStart++;
            }
            wordEnd = wordStart;
            while (wordEnd < maxIndex && s.charAt(wordEnd) != ' '){
                wordEnd++;
            }
            stringList.add(s.substring(wordStart, wordEnd));
            wordStart = wordEnd;
        }
        for (int i = stringList.size()-1; i >= 0; i--) {
            sb.append(stringList.get(i));
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    public String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        deleteStartAndEndEmptyChar(sb);
        reverseString(sb, 0 ,sb.length()-1);
        System.out.println("/"+sb.toString() + "/");

        int wordStartPivot = 0;
        int curPivot = 0;
        while (curPivot <= sb.length()-1){
            while (curPivot <= sb.length()-1 && sb.charAt(curPivot) != ' '){
                curPivot++;
            }
            reverseString(sb, wordStartPivot, curPivot-1);
            curPivot++;
            wordStartPivot = curPivot;
            while (curPivot <= sb.length()-1 && sb.charAt(wordStartPivot) == ' '){
                sb.replace(wordStartPivot, wordStartPivot+1, "");
            }
            curPivot = wordStartPivot;
        }
        return "/"+ sb.toString()+ "/";
    }

    public StringBuilder reverseString(StringBuilder sb, int start, int end){
        while (start < end){
            String temp = String.valueOf(sb.charAt(start));
            sb.replace(start, start+1, sb.substring(end, end+1));
            sb.replace(end, end+1, temp);
            start++;
            end--;
        }
        return sb;
    }

    public StringBuilder deleteStartAndEndEmptyChar(StringBuilder sb){
        int startIndex = 0;
        while(sb.charAt(startIndex) == ' '){
            sb.replace(startIndex, startIndex+1, "");
        }
        int endIndex = sb.length() - 1;
        while (sb.charAt(endIndex) == ' ') {
            sb.replace(endIndex, endIndex+1, "");
            endIndex = sb.length() - 1;
        }
        System.out.println("/"+sb.toString()+"/");
        return sb;
    }
}
