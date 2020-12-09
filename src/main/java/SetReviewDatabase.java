import Service.DictSearchService;
import Service.ReviewService;
import bean.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SetReviewDatabase {

public static void main(String args[]) throws IOException, SQLException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    System.out.println("Enter lines of text.");
    System.out.println("Enter 'end' to quit.");
    do {
        str = br.readLine();
        String[] temp1;
        String delimiter = ",";  // 指定分割字符
        temp1 = str.split(delimiter); // 分割字符串
        for(String x :  temp1){
            insertReviewWords(x);
        }
    } while (!str.equals("end"));
}

    public static void insertReviewWords(String word_name){
        DictSearchService dictSearchService=new DictSearchService();
        ReviewService reviewService= new ReviewService();
        try {
            Word word=dictSearchService.searchWord(word_name);
            if (word==null){
                throw new SQLException("单词： "+word_name+" 查询为空");
            }
            System.out.println(reviewService.insertReviewWord(word));
            System.out.println("单词："+word.getWord()+"  插入成功; 意思： "+word.getMean_cn());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
