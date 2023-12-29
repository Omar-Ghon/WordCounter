import mutils.BinarySearchTree;
import java.util.ArrayList;
import java.util.Stack;

public class Q1_TreeMapByBST {
    BinarySearchTree m_bst = new BinarySearchTree();

    public int size() {
        return getKeysInAlphabeticalOrder().size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public int get(String key) {
        mutils.Node runner = m_bst.root;

        while (runner != null) {
            if (runner.data.equals(key)) {
                System.out.println(runner.data + " " + runner.freq);
                return runner.freq;
            } else if (runner.data.compareTo(key) < 0) {
                runner = runner.right;
            } else {
                runner = runner.left;
            }
        }
        return -1;
    }

    public void put(String key, int value) {
        if (get(key) == -1) {
            mutils.Node new_node = new mutils.Node(key, value);
            m_bst.insert(new_node);
        } else {
            mutils.Node runner = m_bst.root;

            while (runner != null) {
                if (runner.data.equals(key)) {
                    runner.freq = value;
                    break;
                } else if (runner.data.compareTo(key) < 0) {
                    runner = runner.right;
                } else {
                    runner = runner.left;
                }
            }
        }
    }

    public ArrayList<String> getKeysInAlphabeticalOrder(){
        ArrayList<String> key_list = new ArrayList<>();
        Stack<mutils.Node> node_stack = new Stack<>();
        if (m_bst.root == null) {
            return key_list;
        }
        mutils.Node runner = m_bst.root;
        while (true) {
            if (runner != null) {
                node_stack.push(runner);
                runner = runner.left;
            } else {
                if (node_stack.isEmpty()) {
                    break;
                }
                runner = node_stack.pop();
                key_list.add(runner.data);
                runner = runner.right;
            }
        }
        return key_list;
    }
}
