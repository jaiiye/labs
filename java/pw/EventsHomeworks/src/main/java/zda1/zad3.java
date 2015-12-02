package zda1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by blepa on 2015-12-02.
 */

/**
 * Proszę na podstawie powyższych przykładów zrobić program wczytujący linie tekstu i zamieniający je na małe/duże litery
 * Wskazówki:
 * Wczytywanie całych linii tekstu można zorganizować następująco
 * <p>
 * public static void main(String[] args) throws IOException{
 * String line = "";
 * InputStreamReader converter = new InputStreamReader(System.in);
 * BufferedReader in = new BufferedReader(converter);
 * while (!(line.equals("quit"))){
 * line = in.readLine();
 * ...
 * }
 * <p>
 * <p>
 * mamy metody toUpperCase i toLowerCase zamieniające wszystkie znaki w ciągu
 */
public class zad3 {
    public interface Converter {
        String convert(String src);
    }

    class Lower implements Converter {
        @Override
        public String convert(String src) {
            return src.toLowerCase();
        }
    }

    class Upper implements Converter {
        @Override
        public String convert(String src){
            return src.toUpperCase();
        }
    }

    public static void main(String[] args) throws IOException{
        zad3 z3 = new zad3();




        String line = "";
        String control = "";
        System.out.println("poczatek");
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        while (!(line.equals("quit"))){
            line = in.readLine();
            System.out.println("Na co chcesz zamienić U(UpperCase)/L(LowerCase)");
            InputStreamReader ct = new InputStreamReader(System.in);
            BufferedReader ctIn = new BufferedReader(ct);
            control = ctIn.readLine();

            if (control.equals("U")){
                System.out.println("UpperCase");
                Converter conv = z3.new Upper();
                System.out.println(conv.convert(line));
            }
            if (control.equals("L")){
                System.out.println("LowerCase");
                Converter conv = z3.new Lower();
                System.out.println(conv.convert(line));
            }
            if (!(control.equals("U")) && !(control.equals("L"))){
                System.out.println("Nieobslugiwana opcja!");
                System.exit(0);
            }
        }
        System.out.println("koniec");
    }
}


