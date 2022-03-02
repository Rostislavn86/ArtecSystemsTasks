import java.io.IOException;

// Доделать - убрать все пробелы из текста который включаем на обработку + сделать нормальный вывод по  заданному количеству строк.

public class Main
{
    public static void main(String[] args) throws IOException {
        Methods methods = new Methods();


        methods.MakeArrrayOfFilesInStringArray();

        System.out.println(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray())[16]);
        methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray());
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
        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no").length; i++)
            System.out.println(methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no")[i]);

        // Вывод всего текста в один String файл.
        String allTextData = "";

        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no").length; i++)
        {
            //allTextData += methods.GetNameArreysOfTheFilesFromAuthorNames("Гнойный")[i];
            allTextData += methods.GetStringArrayFromFilename(methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no")[i]);
        }

        for(int i = 0; i < methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData).length; i++)
        {
        //    System.out.println(i + "[" +  methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData)[i] + "]");
         //   System.out.println(methods.CleanFromTrashAndSmallWords(allTextData)[6381].length());
        }

        //считаем индекс повторения каждого слова в тексте одного из исполнителей
        methods.CreateArrayIndexing(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData));


        //methods.CreateArrayIndexing(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData));

        //System.out.println("[" +  methods.CleanFromTrashAndSmallWords(allTextData)[5744] + "]");

        methods.DataOutput(methods.CreateArrayIndexing(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData)),methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData),10);

    }
}
