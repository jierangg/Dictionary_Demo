package Service;

import DatabaseUtils.MysqlUtils;
import bean.ReviewWord;
import bean.Word;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewService {
    MysqlUtils mysqlUtils=new MysqlUtils();
    public int insertReviewWord(Word word) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(mysqlUtils.getDataSource());
        String sql="insert into review_word(word_spelling,word_accent,word_mean)values(?,?,?)";
        Object[] params = {word.getWord(),word.getAccent(),word.getMean_cn()};
        int row = queryRunner.update(sql, params);
        return row;
    }
    public ArrayList<ReviewWord> searchReviewWord()throws SQLException {
        String sql="select * from review_word where to_days(learn_time) <= to_days(now());";
        QueryRunner runner = new QueryRunner(mysqlUtils.getDataSource());
        ArrayList<ReviewWord> wordList= (ArrayList<ReviewWord>) runner.query(sql,new BeanListHandler<ReviewWord>(ReviewWord.class));
        return wordList;
    }
    public ArrayList<ReviewWord> searchReviewWordByDate(String learn_time)throws SQLException {
        String sql="select * from review_word where Date(learn_time) = '"+learn_time+"';";
        QueryRunner runner = new QueryRunner(mysqlUtils.getDataSource());
        ArrayList<ReviewWord> wordList= (ArrayList<ReviewWord>) runner.query(sql,new BeanListHandler<ReviewWord>(ReviewWord.class));
        return wordList;
    }
}
