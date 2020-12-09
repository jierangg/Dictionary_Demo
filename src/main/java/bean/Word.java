package bean;

public class Word {
    int topic_id;
    String word;
    String accent;
    String mean_cn;

    public Word(int topic_id, String word, String accent, String mean_cn) {
        this.topic_id = topic_id;
        this.word = word;
        this.accent = accent;
        this.mean_cn = mean_cn;
    }

    public Word(String word, String accent, String mean_cn) {
        this.word = word;
        this.accent = accent;
        this.mean_cn = mean_cn;
    }

    public Word() {
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getAccent() {
        return accent;
    }

    public void setAccent(String accent) {
        this.accent = accent;
    }

    public String getMean_cn() {
        return mean_cn;
    }

    public void setMean_cn(String mean_cn) {
        this.mean_cn = mean_cn;
    }
}
