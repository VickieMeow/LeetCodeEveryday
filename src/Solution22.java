import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        _generate(0, 0, n, "",result);
        return result;
    }
    private void _generate(int left, int right,int n , String s,List<String> result) {
        if(left == n && right == n) {
            result.add(s);
            return;
        }
        if(left < n) _generate(left + 1, right, n,s + "(",result);
        if(left > right) _generate(left, right + 1, n, s + ")",result);
    }

}
