import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter {

    private HashMap<String,Integer> wordCounter = new HashMap<String,Integer>();

    public void count(String dataFile) throws IOException
    {
        Scanner scan = new Scanner(new File(dataFile));

        while(scan.hasNext())
        {
            String currentWord = scan.next();
            if(this.wordCounter.containsKey(currentWord))
            {
                int count = this.wordCounter.get(currentWord) + 1;
                this.wordCounter.put(currentWord, count);
            }else
            {
                this.wordCounter.put(currentWord, 1);
            }
        }
        scan.close();
    }

    public void write(String outputFile) throws IOException
    {
        File output = new File(outputFile);

        if(!output.exists())
            output.createNewFile();

        FileOutputStream counterList = new FileOutputStream(outputFile);
        PrintWriter outputWriter = new PrintWriter(counterList);
        Set<String> words = this.wordCounter.keySet();
        Iterator<String> itrWords = words.iterator();

        while(itrWords.hasNext())
        {
            String word = itrWords.next();
            int count = this.wordCounter.get(word);
            outputWriter.println(word + " occurs " + count + " times.");
        }
        outputWriter.flush();
        counterList.close();
    }
}
