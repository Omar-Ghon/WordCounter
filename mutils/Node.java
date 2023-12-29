package mutils;

public class Node {
    //instance variable of Node class
    public String data;
    public Integer freq;
    public Node left;
    public Node right;

    //constructor
    public Node(String _word, int _freq) {
        data = _word;
        freq = _freq;
        left = null;
        right = null;
    }

    // comparing method by alphabetical order
    public int compareTo(Node another_node) {
        return data.compareTo(another_node.data);
    }

}