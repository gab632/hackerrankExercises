package solved;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectDomainNameTest {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();

        TreeSet<String> domainSet = new TreeSet<>();

        File file = new File("src/domain_detection_test_set.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));


        Pattern p = Pattern.compile("https*://(ww[w2]\\.)*([\\w]+\\.){2,}[a-z]+\\W");
        //                                 https*://(ww[w2]\\.)*([\\w]+\\.)+[a-z]+\\W
        String line = "";
        Matcher m = p.matcher(line);

//        int n = scanner.nextInt();
//        scanner.nextLine();

        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++){
            line = reader.readLine();
//            line = scanner.nextLine();
            m = p.matcher(line);
//            System.out.println(line);
            while(m.find()){
//                System.out.println(m.group());
                String domain = m.group();

                if(domain.equals("ishare.rediff")) {
                    System.out.println(domain + "  - line " + (i + 1));
                    System.out.println(line);
                    System.out.println("--------------------------------");
                }

                if(domain.startsWith("http://www") || domain.startsWith("http://ww2")){
                    domain = domain.substring(11, m.group().length() - 1);
                } else if(domain.startsWith("https://www") || domain.startsWith("https://ww2")){
                    domain = domain.substring(12, m.group().length() - 1);
                } else if(domain.startsWith("https://")){
                    domain = domain.substring(8, m.group().length() - 1);
                } else {
                    domain = domain.substring(7, m.group().length() - 1);
                }
//                System.out.println(domain);
                if(domain.equals("ishare.rediff")) {
                    System.out.println(domain + "  - line " + (i + 1));
                    System.out.println(line);
                    System.out.println("--------------------------------");
                }

                domainSet.add(domain);

            }
        }

        StringBuilder sb = new StringBuilder();
//        System.out.println(domainSet.size());

        String expected = "b.scorecardresearch.com;books.rediff.com;careers.rediff.com;clients.rediff.com;datastore.rediff.com;datastore01.rediff.com;datastore04.rediff.com;datastore05.rediff.com;dealhojaye.rediff.com;hosting.rediff.com;ia.rediff.com;im.rediff.com;imshopping.rediff.com;imworld.rediff.com;investor.rediff.com;ishare.rediff.com;loc.rediff.com;login.rediff.com;mail.rediff.com;metric.ind.rediff.com;money.rediff.com;mypage.rediff.com;n01.rcdn.in;news.rediff.com;pages.rediff.com;realtime.rediff.com;rediff.com;register.rediff.com;search.rediff.com;shopping.rediff.com;simg.rcdn.in;simg03.rcdn.in;track.rediff.com;w3.org;zarabol.rediff.com";
//        System.out.println(finalResult.equals("b.scorecardresearch.com;books.rediff.com;careers.rediff.com;clients.rediff.com;datastore.rediff.com;datastore01.rediff.com;datastore04.rediff.com;datastore05.rediff.com;dealhojaye.rediff.com;hosting.rediff.com;ia.rediff.com;im.rediff.com;imshopping.rediff.com;imworld.rediff.com;investor.rediff.com;ishare.rediff.com;loc.rediff.com;login.rediff.com;mail.rediff.com;metric.ind.rediff.com;money.rediff.com;mypage.rediff.com;n01.rcdn.in;news.rediff.com;pages.rediff.com;realtime.rediff.com;rediff.com;register.rediff.com;search.rediff.com;shopping.rediff.com;simg.rcdn.in;simg03.rcdn.in;track.rediff.com;w3.org;zarabol.rediff.com"));
//        System.out.println(expected.length);
//

        while(!domainSet.isEmpty()){
            sb.append(domainSet.pollFirst()).append(';');
        }
        sb.deleteCharAt(sb.length() - 1);

        String result = sb.toString();
        System.out.println(expected.equals(result));
        System.out.println();
//        String[] finalResult = sb.toString().split(";");
//        System.out.println(sb);
//        System.out.println();
//        System.out.println(finalResult.length);
//        for(String s : finalResult){
//            if(!expected.contains(s)){
//                System.out.println("Does not contain :" + s);
//            } else {
//                System.out.println("Contains :" + s);
//            }
//
//        }
//        scanner.close();
    }
}
