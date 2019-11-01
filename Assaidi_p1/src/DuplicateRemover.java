import java.io.*;
import java.util.*;

public class DuplicateRemover {

    private Set<String> uniqueWords = new HashSet<String>();

    public void remove(String dataFile) throws IOException
    {
        Scanner scan = new Scanner(new File(dataFile));

        while(scan.hasNext())
        {
            String currentWord = scan.next();
            this.uniqueWords.add(currentWord);
        }

        scan.close();
    }

    public void write(String outputFile) throws IOException
    {
        File output = new File(outputFile);

        if(output.exists())
            output.createNewFile();

        FileOutputStream uniqueList = new FileOutputStream(outputFile);
        PrintWriter outputWriter = new PrintWriter(uniqueList);
        Iterator<String> words = this.uniqueWords.iterator();

        while (words.hasNext()) {
            outputWriter.println(words.next());
        }
        outputWriter.flush();
        uniqueList.close();
    }
}
