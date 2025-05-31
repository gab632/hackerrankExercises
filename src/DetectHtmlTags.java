import java.io.*;
import java.util.*;

public class DetectHtmlTags {

    public static void main(String[] args) throws IOException {
        File file = new File("src/test_input2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        TreeSet<String> tags = new TreeSet<>();

        String line;
        while((line = reader.readLine()) != null){
            if(line.contains("<")){

            String[] lineTags = line.split(">[\\n.[^<>]]*</?");
            for(int i = 0; i < lineTags.length; i++){

                if(lineTags[i].startsWith("<!--")){
                    lineTags[i] = "";
                }

                if(lineTags[i].startsWith("<")){
                   lineTags[i] = lineTags[i].substring(1);

               }
                if(lineTags[i].startsWith("/")){
                    lineTags[i] = lineTags[i].substring(1);
                }
                if(lineTags[i].endsWith(">")){
                    lineTags[i] = lineTags[i].substring(0, lineTags[i].length() - 1);
                }
                if(lineTags[i].contains(" ")){
                    lineTags[i] = lineTags[i].substring(0, lineTags[i].indexOf(" "));
                }
            }
            tags.addAll(Arrays.asList(lineTags));

            System.out.println("# Tags: " + lineTags.length + " ");
            Arrays.stream(lineTags).forEach(System.out::println);
            System.out.println("----------------------------------------");
            }
        }
        String uniqueTagsLine = "";
        tags.remove("");
        for(String tag : tags){
            uniqueTagsLine = uniqueTagsLine.concat(tag + ";");
        }
        System.out.print(uniqueTagsLine.substring(0, uniqueTagsLine.length() - 1));


//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();

//        for(int i = 0; i < n; i++){
//            String line = scanner.nextLine();
//            System.out.println(line.contains());
//            System.out.println(line.matches("</?[^!]\\s*[^<>\\s]+\\s*.*"));





    }
}
