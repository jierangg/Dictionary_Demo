import Service.DictSearchService;
import bean.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            String[] temp1;
            String delimeter = "\\s+";  // 指定分割字符
            temp1 = str.split(delimeter); // 分割字符串
            for(String x :  temp1){
                printWords(x);
            }

        } while (!str.equals("end"));
    }

    public static void printWords(String word_name){
        DictSearchService dictSearchService=new DictSearchService();
        try {
            Word word=dictSearchService.searchWord(word_name);
            if (word==null){
                System.out.println("查询为空");
                throw new SQLException();
            }
            System.out.print("| "+word.getWord()+" |");
            System.out.print(" "+word.getAccent()+" |");
            System.out.print(" "+word.getMean_cn()+" |\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
