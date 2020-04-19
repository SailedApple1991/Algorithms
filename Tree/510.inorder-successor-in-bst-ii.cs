/*
 * @lc app=leetcode id=510 lang=csharp
 *
 * [510] Inorder Successor in BST II
 */
/*
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
*/
//traverse
/*后继结点出现的位置大致可以分为两类，一类是在子孙结点中，另一类是在祖先结点中。
仔细观察例子不难发现，当某个结点存在右子结点时，其中序后继结点就在子孙结点中，
反之则在祖先结点中。这样我们就可以分别来处理，当右子结点存在时，我们需要找到右
子结点的最左子结点，这个不难，就用个 while 循环就行了。当右子结点不存在，我们
就要找到第一个比其值大的祖先结点，也是用个 while 循环去找即可，参见代码如下：

 */
public class Solution {
    public Node InorderSuccessor(Node x) {
        //in order left mid right
        if(x == null) return null;
        Node res = null;
        if(x.right == null){
            res = x.parent;
            while(res != null &&res.val < x.val){
                res = res.parent;
            }
        }
        if(x.right != null){
            res = x.right;
            while(res.left != null){
                res = res.left;
            }
        }
        return res;
    }
}

