package Service;

import bean.ReviewWord;
import utils.DateUtils;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteMarkDownService {
    public static void createMarkDown(){
       try {
           Date date=new Date();
           System.out.println("Today is "+new SimpleDateFormat("yyyy-MM-dd").format(date));
           List<Date> reviewDateList= DateUtils.getReviewDate(date);
           File destFile =new File("C:/Users/BrokenRain/Desktop/Review.md");
           if(destFile.exists()){
               destFile.delete();
           }
           //copy file to desktop
           //copyFileUsingJava7Files(new File("src/main/resources/ReviewTableTittle.md"),destFile);
           for (Date reviewDate:reviewDateList
                ) {
               writeMd(new SimpleDateFormat("yyyy-MM-dd").format(reviewDate),destFile);
           }

           }catch (Exception e){
           e.printStackTrace();
       }
    }
    private static void writeMd(String reviewDate,File destFile){
        try {
            ArrayList<ReviewWord> reviewWordArrayList=new ReviewService().searchReviewWordByDate(reviewDate);
            System.out.println(reviewWordArrayList.size());
            if (reviewWordArrayList==null|reviewWordArrayList.size()==0){

                return;
            }
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/ReviewTableTittle.md"));
            String str;
            FileWriter fileWriter = new FileWriter(destFile.getPath(),true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write("## "+reviewDate+"\n");
            while ((str = in.readLine()) != null) {
                bufferWriter.write(str+"\n");
            }
            for (ReviewWord reviewWord:reviewWordArrayList
            ) {
                bufferWriter.write("|"+reviewWord.getWord_spelling()+"|"+reviewWord.getWord_accent()+"|"+reviewWord.getWord_mean()+"|\n");
            }
            bufferWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void copyFileUsingJava7Files(File source, File dest)
            throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

}
