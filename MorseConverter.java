
import java.io.*;
import java.util.*;

public class MorseConverter {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, String> map = new HashMap<>();
    static String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                    ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    public static void main(String[] args) throws IOException {
        for (int i = 'a', j = 0; i <= 'z'; i++, j++) add((char) i, morse[j]);
        System.out.println("This convertor only supports 'a-zA-Z.- /'");
        System.out.println("Enter '1' to convert from morse to letters, '2' to convert from letters to morse, and anything else to exit.\n");
        while (true){
            String in = readLine();
            if (in.equals("1")) mtl();
            else if (in.equals("2")) ltm();
            else return;
        }
    }
    public static void add(char ch, String m){
        String u = Character.toString(('A' - 'a' + ch));
        String c = Character.toString(ch);
        map.put(c, m);
        map.put(u, m);
        map.put(m, u);
    }
    public static void mtl(){
        try{
        System.out.println("Send your properly formatted input in one line.\n");
        String in = readLine();
        String[] words = in.split(" / ");
        for (String cur : words){
            String[] letters = cur.split(" ");
            for (String let : letters) System.out.print(map.get(let));
            System.out.print(" ");
        }
        System.out.println();
        }
        catch (Exception e){
            System.out.println("You did something wrong lol");
        }
    }
    public static void ltm(){
        try{
        System.out.println("Send your properly formatted input in one line.\n");
        String in = readLine();
        String[] words = in.split(" ");
        for (String cur : words){
            String[] letters = cur.split("");
            for (String let : letters) {
                System.out.print(map.get(let));
                System.out.print(" ");
            }
            System.out.print("/ ");
        }
        System.out.println();
        }
        catch (Exception e){
            System.out.println("You did something wrong lol");
        }
        
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {st = new StringTokenizer(br.readLine().trim());}
        return st.nextToken();}
    static long readLong() throws IOException {return Long.parseLong(next());}
    static int readInt() throws IOException {return Integer.parseInt(next());}
    static double readDouble() throws IOException {return Double.parseDouble(next());}
    static char readCharacter() throws IOException {return next().charAt(0);}
    static String readLine() throws IOException {return br.readLine().trim();}
}
