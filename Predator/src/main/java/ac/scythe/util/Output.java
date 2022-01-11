package ac.scythe.util;

import java.io.IOException;
import java.lang.reflect.Array;

public class Output {
    public static void clearWrite(String output) {
        for (int i = 0; i < 100; ++i) System.out.println();
        Logo.printLogo();
        System.out.println(output);
    }

    public static void clearMultiWrite(String[] outputs) {
        for (int i = 0; i < 100; ++i) System.out.println();
        Logo.printLogo();
        for(String output : outputs) {
            System.out.println(output);
        }
    }

    public  static void write(String output) {
        System.out.println(output);
    }

    public static void multiWrite(String[] outputs) {
        for(String output : outputs) {
            System.out.println(output);
        }
    }
}
