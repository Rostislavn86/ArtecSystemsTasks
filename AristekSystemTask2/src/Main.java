import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        Methods methods = new Methods();

        //System.out.println(methods.MakeArrrayOfFilesInStringArray()[0]);

        /*
        //Спсиок всех участников
        for(int i = 0; i <methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray()).length; i++)
        {
            System.out.println(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray())[i]);
        }
        /*

        /*
        for(int i = 0; i <methods.CollectAllTextOfTheAuthor("Гнойный").length; i++)
        {
            System.out.println(methods.CollectAllTextOfTheAuthor("Гнойный").length);

            System.out.println(methods.GetStringArrayFromFilename("Марины Кацубы"));

        }
        */


        //methods.CollectAllTextOfTheAuthor("Rickey F");

        System.out.println("***********************************");
        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Гнойный").length; i++)
            System.out.println(methods.GetNameArreysOfTheFilesFromAuthorNames("Гнойный")[i]);

        // Вывод всего текста в один String файл.
        String allTextData = "";

        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Гнойный").length; i++)
        {
            //allTextData += methods.GetNameArreysOfTheFilesFromAuthorNames("Гнойный")[i];
            allTextData += methods.GetStringArrayFromFilename(methods.GetNameArreysOfTheFilesFromAuthorNames("Гнойный")[i]);
        }

        System.out.println(allTextData);

    }
}
