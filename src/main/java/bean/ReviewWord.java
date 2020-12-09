package bean;

public class ReviewWord {
    String word_id;
    String word_spelling;
    String word_accent;
    String word_mean;
    String learn_time;
    int review_count;

    public String getWord_id() {
        return word_id;
    }

    public void setWord_id(String word_id) {
        this.word_id = word_id;
    }

    public String getWord_spelling() {
        return word_spelling;
    }

    public void setWord_spelling(String word_spelling) {
        this.word_spelling = word_spelling;
    }

    public String getWord_accent() {
        return word_accent;
    }

    public void setWord_accent(String word_accent) {
        this.word_accent = word_accent;
    }

    public String getWord_mean() {
        return word_mean;
    }

    public void setWord_mean(String word_mean) {
        this.word_mean = word_mean;
    }

    public String getLearn_time() {
        return learn_time;
    }

    public void setLearn_time(String learn_time) {
        this.learn_time = learn_time;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }
}
