import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());

        int n = Integer.parseInt(br.readLine());
        String command;
        int cursor = s.length();

        for(int i=0; i<n; i++){
            command = br.readLine();

            if(command.charAt(0) == 'P'){
                s.insert(cursor, command.charAt(2));
                cursor++;
            }
            else if(command.charAt(0) == 'L'){
                if(cursor != 0) cursor--;
            }
            else if(command.charAt(0) == 'D'){
                if(cursor != s.length()) cursor++;
            }
            else if(command.charAt(0) == 'B'){
                if(cursor != 0) {
                    s.delete(cursor-1, cursor);
                    cursor--;
                }
            }
        }

        System.out.print(s.toString());
    }
}