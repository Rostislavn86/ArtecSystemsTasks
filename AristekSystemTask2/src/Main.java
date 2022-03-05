import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        /*
        Methods methods = new Methods();

        // Спсиок всех исполнителей
        for(int i = 0; i < methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()).length; i++ )
        System.out.println(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray())[i]);

        //*************************
        // Вывод списка всех исполнителей
        System.out.println("***********************************");
        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Guf").length; i++)
            System.out.println(methods.GetNameArreysOfTheFilesFromAuthorNames("Guf")[i]);

        // Вывод всего текста в один String файл.
        String allTextData = "";

        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Oxxxymiron").length; i++)
        {
            allTextData += methods.GetStringArrayFromFilename(methods.GetNameArreysOfTheFilesFromAuthorNames("Oxxxymiron")[i]);
        }
        //*************************

        // вывод
        //methods.DataOutput(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData),10);


         */

        Methods methods = new Methods();

        methods.MainMenu(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()),"-top-words", 30, "-name", "Династ");

    }
}
