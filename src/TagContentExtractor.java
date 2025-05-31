import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            //Write your code here
            Stack<String> tags = new Stack<>();
            String content = "";
            String tag = "";

            for(int i = 0; i < line.length(); i++){

                if(line.charAt(i) == '<'){
                    tag = findTag(line, i);
                    i = i + tag.length();

                    if(tag.charAt(1) == '/'){

                        if(tags.isEmpty()){
                            content = "";
                            tag = "";
                            break;

                        } else {
                            if(tags.peek().equals(tag.replace("/", ""))){
                                tags.pop();
                                if(tags.isEmpty()){
                                    System.out.println(content);
                                } else {
                                    tag = "";
                                    break;
                                }



                            } else {
                                content = "";
                                tag = "";
                                break;
                            }

                        }

                    } else {
                        tags.push(tag);
                        content = "";
                        tag = "";
                        break;
                    }

                } else {

                    StringBuilder sb = new StringBuilder();
                    sb.append(line.charAt(i));
                    int nextTagIndex = line.indexOf('<');
                    if(nextTagIndex == -1){
                        content = "";
                        tag= "";
                        i = line.length();
                        break;
                    } else {
                        content = line.substring(i, nextTagIndex + 1);
                        i = nextTagIndex;
                        break;
                    }
                }
            }

            testCases--;
        }
    }

    public static String findTag(String text, int i){
        String substring = text.substring(i);
        Pattern p = Pattern.compile("</?[\\w\\s]*>");
        Matcher m = p.matcher(substring);
        return m.group();

    }



}



