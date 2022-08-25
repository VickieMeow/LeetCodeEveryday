import java.util.HashMap;
import java.util.Map;

class Solution65 {

    public boolean isNumber2(String s) {
        int n = s.length();
        // 数字标识，点标识，e标识
        boolean numFlag = false, dotFlag = false, eFlag = false;
        for (int i = 0; i < n; i++) {
            char curCh = s.charAt(i);
            // 数字标识为true
            if (curCh >= '0' && curCh <= '9') {
                numFlag = true;
            }
            // s[i]为'.'，需要点未出现过且e未出现过
            else if (curCh == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            }
            // s[i]为e，需要e未出现过且之前有数字
            else if ((curCh == 'e' || curCh == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;
            }
            // s[i]为+-，只能出现在首位或者e之后
            else if ((curCh == '+' || curCh == '-') && (i == 0 || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')) {
                continue;
            }
            else {
                return false;
            }
        }
        return numFlag;

    }


    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    /**
     * 状态
     */
    enum State {
        //初始状态
        STATE_INITIAL,
        //符号位
        STATE_INT_SIGN,
        //整数部分
        STATE_INTEGER,
        //小数点（左有整数）
        STATE_POINT,
        //小数点（左无整数）
        STATE_POINT_WITHOUT_INT,
        //小数部分
        STATE_FRACTION,
        //字符e
        STATE_EXP,
        //指数符号
        STATE_EXP_SIGN,
        //指数数字
        STATE_EXP_NUMBER,
        STATE_END
    }

    /**
     * 字符类型
     */
    enum CharType {
        //数字类型
        CHAR_NUMBER,
        //e字符
        CHAR_EXP,
        //小数点字符
        CHAR_POINT,
        //+-号
        CHAR_SIGN,
        //非法字符
        CHAR_ILLEGAL
    }
}
