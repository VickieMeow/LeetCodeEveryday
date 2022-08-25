package algorithm;

/**
 * 滑动窗口问题模板及说明
 * @author miaomeiqi
 */
public class SlidingWindow {

    public void coreThought() {
        int left = 0, right = 0;

        while (right < s.size()) {
            // 增大窗口
            window.add(s[right]);
            right++;

            while (window needs shrink) {
                // 缩小窗口
                window.remove(s[left]);
                left++;
            }
        }
    }
    //问题在于 如何向窗口中添加新元素，如何缩小窗口，在窗口滑动的哪个阶段更新结果

    /* 滑动窗口算法框架 */
    void slidingWindow(String s) {
        unordered_map<Character, Integer> window;

        int left = 0, right = 0;
        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
        ...

            /*** debug 输出的位置 ***/
            printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗口是否要收缩
            while (window needs shrink) {
                // d 是将移出窗口的字符
                char d = s[left];
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
            ...
            }
        }
    }



}
