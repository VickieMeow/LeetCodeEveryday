import java.util.*;

public class Solution236 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {val = x;}
    }

    //1.递归法
    private TreeNode ans;
    public Solution_236(){
        this.ans = new TreeNode(0);
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.traverseTree(root,p,q);
        return this.ans;
    }
    public Boolean traverseTree(TreeNode currNode,TreeNode p,TreeNode q) {
        if(currNode == null) return false;
        int left = traverseTree(currNode.left,p,q) ? 1 : 0;
        int right = traverseTree(currNode.right,p,q) ? 1 : 0;
        int mid = (currNode == p || currNode == q) ? 1 : 0;
        if(left + mid + right >= 2) this.ans = currNode;
        return (left + right + mid > 0);
    }

    //2.递归精简
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null || root == p || root ==q ) return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        if(left == null && right == null) return null;
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
    //3.迭代法-有父节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //用于遍历的辅助栈
        Stack<TreeNode> stack = new Stack<>();
        //使用hashmap保存每一个节点和其对应的父节点
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root,null);
        stack.push(root);

        //不断迭代直到我们的hashmap中保存了p和q及其对应父节点
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            //不断在map中保存当前节点的父节点
            if(node.left != null){
                parent.put(node.left,node);
                stack.push(node.left);
            }
            if(node.right != null) {
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }
        //构建p节点的祖先节点集合
        Set<TreeNode> ancestors = new HashSet<>();
        //向p节点的祖先节点集合中添加元素
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        //在p节点的祖先节点集合中出现的第一个q的祖先即为他们的公共祖先
        while(!ancestors.contains(q)) q = parent.get(q);
        return q;
    }







}
