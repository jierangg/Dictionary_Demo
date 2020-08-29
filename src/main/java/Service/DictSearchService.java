package Service;

import DatabaseUtils.SqliteUtils;
import bean.Word;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class DictSearchService {
    SqliteUtils sqliteUtils=new SqliteUtils();
    public Word searchWord(String word_name)throws SQLException {
        String sql="select * from dict_bcz where word=?";
        QueryRunner runner = new QueryRunner(sqliteUtils.getDataSource());
        Word word=runner.query(sql,new BeanHandler<Word>(Word.class),word_name);
        return word;
    }

}
