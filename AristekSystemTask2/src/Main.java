import java.io.IOException;

// Доделать - убрать все пробелы из текста который включаем на обработку + сделать нормальный вывод по  заданному количеству строк.

public class Main
{
    public static void main(String[] args) throws IOException {
        Methods methods = new Methods();

        methods.MakeArrrayOfFilesInStringArray();

        System.out.println(methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray())[16]);
        methods.MakeArrayNamesFromFileNames(methods.MakeArrrayOfFilesInStringArray());

        System.out.println("***********************************");
        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no").length; i++)
            System.out.println(methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no")[i]);

        // Вывод всего текста в один String файл.
        String allTextData = "";

        for(int i = 0; i <methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no").length; i++)
        {
            allTextData += methods.GetStringArrayFromFilename(methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no")[i]);
        }

        //считаем индекс повторения каждого слова в тексте одного из исполнителей
       // methods.CreateArrayIndexing(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData));

        methods.DataOutput(methods.CreateArrayIndexing(methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData)),methods.CleanFromTrashAndSmallWordsAndCreateArrayOfWords(allTextData),10);

    }
}
