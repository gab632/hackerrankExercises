package ip_address_validation;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Pattern ipv4Pattern = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.)(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.)(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.)([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$");

        Pattern ipv6Pattern = Pattern.compile("([0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]:[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F])");

        Matcher m;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String line;
        boolean matchFound = false;
        for(int i = 0; i < n; i++){
            line = sc.nextLine();
            m = ipv4Pattern.matcher(line);
            if(m.find()){
                System.out.println("IPv4");
                matchFound = true;
            }

            if(!matchFound){
                m = ipv6Pattern.matcher(line);
                if(m.find()){
                    System.out.println("IPv6");
                    matchFound = true;
                } else {
                    System.out.println("Neither");
                }
            }
            matchFound = false;
        }
        sc.close();
    }
}