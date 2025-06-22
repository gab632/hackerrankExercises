package solved;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectDomainName {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        TreeSet<String> domainSet = new TreeSet<>();

        Pattern p = Pattern.compile("https*://(ww[w2]\\.)*([\\w]+\\.)+[a-z]+\\W");
        String line = "";
        Matcher m;

        for(int i = 0; i < n; i++){
            System.out.println(i+1);
            line = scanner.nextLine();
            m = p.matcher(line);

            while(m.find()){
                String domain = m.group();

                if(domain.startsWith("http://www") || domain.startsWith("http://ww2")){
                    domain = domain.substring(11, m.group().length() - 1);
                } else if(domain.startsWith("https://www") || domain.startsWith("https://ww2")){
                    domain = domain.substring(12, m.group().length() - 1);
                } else if(domain.startsWith("https://")){
                    domain = domain.substring(8, m.group().length() - 1);
                } else {
                    domain = domain.substring(7, m.group().length() - 1);
                }
                domainSet.add(domain);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!domainSet.isEmpty()){
            sb.append(domainSet.pollFirst()).append(';');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        scanner.close();
    }
}
