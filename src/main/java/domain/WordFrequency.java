package domain;

public class WordFrequency implements Comparable<WordFrequency>{

    String word;
    int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public String toString() {
        return "WordFrequency {" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public int compareTo(WordFrequency o) {
        return Integer.valueOf(this.frequency).compareTo(o.frequency);
    }
}
