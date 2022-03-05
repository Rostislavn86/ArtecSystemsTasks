import java.io.IOException;
import java.util.Random;

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

        // Спсиок всех исполнителей
        for(int i = 0; i < methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()).length; i++ )
            System.out.println(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray())[i]);

        methods.MainMenu(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()),"-top-words", 30, "-name", "Династ");

       // MainMenu(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()), "-top-words", 30,"-name","Гнойный");

    }

    public static void MainMenu(String[] authorNames,String commandNameNumberOutPut, int NumberOutPut, String CommandAuthorName, String authorNamePut) throws IOException {

        Methods methods = new Methods();

        // Вывод всего текста в один String файл.
        String allTextData = "";

        if (!commandNameNumberOutPut.equals("-top-words") || (!CommandAuthorName.equals("-name")))
        {
            System.out.println("Комманда введена не верно - повторите ввод ");
            System.exit(0);
        }

        for(int i = 0; i < authorNames.length; i++)
        {
            if (authorNamePut.equals(authorNames[i]))
            {

                for(int k = 0; k <methods.GetNameArreysOfTheFilesFromAuthorNames(authorNamePut).length; k++)
                {
                    allTextData += methods.GetStringArrayFromFilename(methods.GetNameArreysOfTheFilesFromAuthorNames(authorNamePut)[k]);
                }

                // вывод
                methods.DataOutput(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData),NumberOutPut);

                System.exit(0);

            }
        }

        for(int i = 0; i < authorNames.length; i++)
        {
            System.out.println("Рэпер " + authorNamePut + " не известен мне. Зато мне известны :  ");
            for(int j = 0; j < 3; j++)
            {
                Random random = new Random();
                int rand = random.nextInt(authorNames.length);

                System.out.println(authorNames[rand]);
            }

            System.exit(0);
        }

    }

}
