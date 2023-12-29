import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Q2_WordCounter {
    static Q1_TreeMapByBST m_treemap = new Q1_TreeMapByBST();

    public void buildTreeMap(String filename) throws FileNotFoundException {
        Scanner scanner1 = new Scanner(new File(filename));
        while (scanner1.hasNext()) {
            String word = scanner1.next();
            word = word.replaceAll("[^a-zA-Z]", "");
            word = word.toLowerCase();
            if (!word.isEmpty()) {
                if (m_treemap.isEmpty()) {
                    m_treemap.put(word, 1);
                } else {
                    int freq = m_treemap.get(word);
                    if (freq == -1) {
                        freq = 0;
                    }
                    m_treemap.put(word, freq + 1);
                }
            }
            }
        scanner1.close();
    }

    public void printWordsAlphabetical() {
        ArrayList<String> for_printing = m_treemap.getKeysInAlphabeticalOrder();
        for (String element: for_printing) {
            System.out.println(element);
        }
    }
    public void outputResult(String filename) throws IOException {
        ArrayList<String> for_printing = m_treemap.getKeysInAlphabeticalOrder();
        try (Writer file_writer = new FileWriter(filename);
             BufferedWriter writer = new BufferedWriter(file_writer)) {
            writer.write(for_printing.size() + " words found in file: ");
            writer.newLine();
            writer.newLine();
            writer.write("List of words in alphabetical order (with counts in parentheses):");
            writer.newLine();
            writer.newLine();
            for (String element : for_printing) {
                int frequency = m_treemap.get(element);
                writer.write(element + " (" + frequency + ")");
                writer.newLine();
            }
            writer.flush();

            writer.newLine();
            writer.newLine();
            writer.write("List of words by frequency of occurence: ");
            writer.newLine();

                int arr_size = for_printing.size();
                for (int i = 0; i<arr_size-1; i++) {
                    for (int j = 0; j < arr_size - i - 1; j++) {
                        if (m_treemap.get(for_printing.get(j)) < (m_treemap.get(for_printing.get(j + 1)))) {
                            String temp = for_printing.get(j);
                            for_printing.set(j, for_printing.get(j + 1));
                            for_printing.set(j + 1, temp);
                        }
                    }
                }

                for (String element: for_printing) {
                    writer.write(element + " (" +  m_treemap.get(element) + ")");
                    writer.newLine();
                }
        }
    }

    public static void main(String[] args) throws IOException {
        Q2_WordCounter counter1 = new Q2_WordCounter();
        counter1.buildTreeMap("data/JingleBell.txt");
        counter1.printWordsAlphabetical();
        counter1.outputResult("data/Output.txt");
    }
}
