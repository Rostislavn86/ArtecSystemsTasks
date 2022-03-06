import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        Methods methods = new Methods();

        /*
        System.out.println("Список всех исполнителей");

        for(int i = 0; i < methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()).length; i++ )
            System.out.println(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray())[i]);
        */

        methods.MainMenu(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()),args[0], args[1], args[2], args[3]);

    }
}
