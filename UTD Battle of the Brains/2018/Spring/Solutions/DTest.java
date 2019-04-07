import java.io.*;
import java.util.*;

public class DTest {
    public static void main(String[] args) throws Exception {
        // this is not a part of the solution, this is just to get the file path of the
        // input and/or output
        String currentDirectory = System.getProperty("user.dir");
        String testDataPath = currentDirectory.substring(0, currentDirectory.lastIndexOf("\\") + 1) + "Test Data\\";
        String inputFilePath = testDataPath + "D.txt";
        String outputFilePath = testDataPath + "D.out";

        // BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream(outputFilePath)));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean worked = true;

        int cases = Integer.parseInt(sc.readLine());
        for (int x = 0; x < cases; x++) {
            // reads the number of elements and queries
            String[] init = sc.readLine().split(" ");
            int size = Integer.parseInt(init[0]);
            BST bst = new BST(size);
            // reads the elements in the array
            for (String s : sc.readLine().split(" ")) {
                bst.insert(Integer.parseInt(s));
            }
            int i = 1;
            // reads the queries
            for (String s : sc.readLine().split(" ")) {
                String actualAnswer = check.readLine();
                String myAnswer = (i++) + " " + bst.query[Integer.parseInt(s)];
                boolean passed = myAnswer.equals(actualAnswer);
                if (!passed)
                    dc.write("FAIL -> " + myAnswer + " | " + actualAnswer);
                worked = worked && passed;
            }
        }

        dc.write(worked + "\n"); // true if passed all
        dc.close();
        sc.close();
        check.close();
    }

    private static class BST {
        private Node root;
        private int[] query;
        private int index;

        public BST(int size) {
            root = null;
            query = new int[size];
            index = 0;
        }

        public void insert(int num) {
            root = insertRec(root, num, 0);
        }

        public Node insertRec(Node root, int num, int count) {
            if (root == null) {
                root = new Node(num);
                query[index++] = count;
                return root;
            }
            if (num < root.data) {
                root.valuesToLeft++;
                root.left = insertRec(root.left, num, count);
            } else if (num > root.data)
                root.right = insertRec(root.right, num, root.duplicates + root.valuesToLeft + count + 1);
            else if (num == root.data) {
                query[index++] = root.valuesToLeft + count;
                root.duplicates++;
            }
            return root;
        }

        public class Node {
            private int data, valuesToLeft, duplicates;
            private Node left, right;

            public Node(int data) {
                this.data = data;
                valuesToLeft = 0;
                duplicates = 0;
                left = null;
                right = null;
            }
        }
    }
}