import java.io.*;

public class Application {
    public static void main(String [] args) throws IOException {
        DuplicateRemover test = new DuplicateRemover();
        test.remove("problem1.txt");
        test.write("unique_words.txt");
    }
}
