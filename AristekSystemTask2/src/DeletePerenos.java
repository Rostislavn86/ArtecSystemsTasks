import java.io.IOException;
import java.util.Locale;

public class DeletePerenos
{
    public static void main(String[] args) throws IOException {
        Methods methods = new Methods();

        CleanFromTrashAndSmallWordsAndCreateArrayOfWords(methods.GetStringArrayFromFilename(methods.GetStringArrayFromFilename(methods.GetNameArreysOfTheFilesFromAuthorNames("Dom1no")[0])));
    }

    //Очищаем строку от мусора (запятых местоимений) и создаём новый массив
    public static String[] CleanFromTrashAndSmallWordsAndCreateArrayOfWords(String allText)
    {
        allText = allText.toLowerCase(Locale.ROOT);
        allText = allText.trim();

        allText = allText.replaceAll("\\n", "-");
        //убираем все знаки из текста
        allText = allText.replaceAll("[,.!?:;»«()‘’]", " ");

        //allText = allText.replaceAll("  ", " ");

        //allText = allText.replaceAll("\n", "-");

        //allText = allText.replaceAll("-", "");

        String[] allTextArray = allText.split(" ");

        return allTextArray;
    }
}
