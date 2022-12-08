import domain.WordFrequency;
import java.util.List;
import service.WordFrequencyAnalyzer;
import service.WordFrequencyAnalyzerImpl;

public class Main {

    public static void main(String[] args) {
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        String text1 = "The sun shines over the lake";
        String text2 = "The sun shines over tHE lake";
        String text3 = "The.sun/shines;over!!the||lake";
        String text4 = "The sun shines over over over over over over the lake and then shines even more.";
        String text5 = "   ";

        calculateAndPrint(wordFrequencyAnalyzer, text1);
        calculateAndPrint(wordFrequencyAnalyzer, text2);
        calculateAndPrint(wordFrequencyAnalyzer, text3);
        calculateAndPrint(wordFrequencyAnalyzer, text4);
        calculateAndPrint(wordFrequencyAnalyzer, text5);
    }

    private static void calculateAndPrint(WordFrequencyAnalyzer wordFrequencyAnalyzer, String text) {
        int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(text);
        int frequencyForWord = wordFrequencyAnalyzer.calculateFrequencyForWord(text, "the");
        List<WordFrequency> lwf = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, 5);

        System.out.println("The highest frequency for a word is: " + highestFrequency);
        System.out.println("The frequency for the word 'the' is: " + frequencyForWord);
        System.out.println(lwf.toString());
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
