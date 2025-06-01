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
            boolean firstEndingTagFound = false;
//            System.out.println(line.charAt(15));
            for(int i = 0; i < line.length(); i++){
//                System.out.println(i);
                if(line.charAt(i) == '<'){
//                    System.out.println("Tag found - index " + i);
                    tag = findTag(line, i);
//                    System.out.println(tag);
                    i = i + tag.length() - 1;

                    if(tag.charAt(1) == '/'){
                        firstEndingTagFound = true;
                        if(tags.isEmpty()){
                            content = "";
                            tag = "";
//                            break;

                        } else {
                            if(tags.peek().equals(tag.replace("/", ""))){
//                                System.out.printf("Equals %s, %s\n", tags.peek(), tag.replace("/", ""));
                                tags.pop();
                                if(tags.isEmpty()){
                                    System.out.println(content);
                                } else {
                                    tag = "";
//                                    break;
                                }
                            } else {
                                content = "";
                                tag = "";
//                                break;
                            }
                        }

                    } else {
                        tags.push(tag);
                        content = "";
                        tag = "";
//                        break;
                    }

                } else {
                    int nextTagIndex = line.indexOf('<', i + 1);
                    if(nextTagIndex == -1) {
                        content = "";
                        tag = "";
                        i = line.length();
                        System.out.println("None");
                    } else {
                        if(firstEndingTagFound){
                            i = line.indexOf('<', i + 1) - 1;

                        } else {
    //                    System.out.println("index: " + i + " - next tag index:" + nextTagIndex);
                            content = line.substring(i, nextTagIndex);
                            i = nextTagIndex - 1;
                            //                        System.out.println("i as next tag index: " + i);
                            //                        break;

                        }
                    }

                }
            }

            testCases--;
        }

    }

    public static String findTag(String text, int i){
        Pattern p = Pattern.compile("</?[\\w\\s]*>");
        Matcher m = p.matcher(text);
            String tag = m.group();
            return tag;
    }




}



