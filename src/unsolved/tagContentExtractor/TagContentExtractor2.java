package unsolved.tagContentExtractor;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor2 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String content = "";
        Stack<String> tagStack = new Stack<>();
        String tag = "";
        boolean foundOneValidContent = false;
        while(testCases>0){
            String line = in.nextLine();
            if(!(line.contains("<") && line.contains(">")) || line.matches("[<>]+")){
                System.out.println("None");
            } else {

                for(int i = 0; i < line.length(); i++){
//                    System.out.println(i + " " + line.charAt(i));
                    if(line.charAt(i) == '<'){
                        tag = findTag(line.substring(i));
                        if(isEndTag(tag)){
                            if(!tagStack.isEmpty()){
                                if(matchTags(tagStack.peek(), tag)){
                                    if(tagStack.pop().matches("</?>")){
                                        i += tag.length() - 1;
                                        content = "";
                                        tag = "";
                                    } else {
                                        if(tagStack.isEmpty()){
                                            System.out.println(content);
                                            foundOneValidContent = true;
                                            content = "";
                                        }
                                    }

                                } else {
                                    tagStack.push(tag);
                                    i += tag.length() - 1;
//                                tag = "";
                                }
                            } else {
                                System.out.println(tag);
                                tagStack.push(tag);
                                i += tag.length() - 1;
//                            tag = "";
                            }

                        } else {
                            if(!tag.isEmpty()){

                                tagStack.push(tag);
                                i += tag.length() - 1;
                            } else {
                                i++;
                            }
                        }

                    } else {
                        content = findContent(line.substring(i));
                        if(i + content.length() == line.length()){
                            break;
                        } else {
                            i = (!content.isEmpty()) ?  i + content.length() - 1 : i++;
                        }
                    }

                } // inner for loop.
            }
            if(!tagStack.isEmpty() && !foundOneValidContent){
                System.out.println("None");
            }
            content = "";
            tagStack.clear();
            foundOneValidContent = false;

            testCases--;
        } // outer while loop.

    } // main

    public static String findTag(String line){
        Pattern tagPattern = Pattern.compile("</?.*?>");
        Matcher m;
        m = tagPattern.matcher(line);
        if(m.find()){
            return m.group();
        }
        return "";
    }

    public static boolean isEndTag(String line){
        return !line.isEmpty() && line.charAt(1) == '/';
    }

    public static String findContent(String line){
        // .*(?=<)
        Pattern contentPattern = Pattern.compile(".+?<");
        Matcher m = contentPattern.matcher(line);
        if(m.find()){
            return m.group().substring(0, m.group().length() - 1);
        }
        return "";
    }

    public static boolean matchTags(String startTag, String endTag){
        String matchingTag = endTag.replace("/", "");
        return startTag.equals(matchingTag);
    }

}
