import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class Methods
{


    //Новый !!!! Метод считывающий информацию из файла с заданныим именем файла
    public String GetStringArrayFromFilename(String fileName) throws IOException
    {
        //https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

        Path fileNamePath = Path.of("rap-battles/" + fileName);

        String data = Files.readString(fileNamePath);

        return data;
    }

    //Новый !!!! Метод выводящий список файлов из имени исполнителя
    public String[] GetNameArreysOfTheFilesFromAuthorNames(String authorName)
    {
        //Названия всех файлов
        String[] temp = new String[MakeArrrayOfFilesInStringArray().length];

        //Название всех файлов
        temp = MakeArrrayOfFilesInStringArray();

        HashSet<String> fileNames = new HashSet<>();

        //добавляем названия файлов определённого исполнителя
        for(int i = 0; i < temp.length; i++)
        {
            if (temp[i].startsWith(authorName)) fileNames.add(temp[i]);
        }

        String[] authorFileNames = new String[fileNames.size()];

        //https://beginnersbook.com/2014/08/converting-a-hashset-to-an-array/
        fileNames.toArray(authorFileNames);

        return authorFileNames;
    }

    //Метод считывающий названия из файлов
    //https://stackabuse.com/java-list-files-in-a-directory/
    public static String[] MakeArrrayOfFilesInStringArray()
    {
        String[] pathnames;
        File f = new File("rap-battles");

        pathnames = f.list();

        return  pathnames;
    }

    //Метод считывающий имена испольнителей из названия файлов
    public String[] MakeArrayNamesFromFileNames(String[] MakeArrrayOfFilesInStringArray)
    {
        int index = 0;
        HashSet<String> names = new HashSet<>();

        for(int i = 0; i < MakeArrrayOfFilesInStringArray.length; i++)
        {
            index = MakeArrrayOfFilesInStringArray[i].indexOf(" против");

            names.add(MakeArrrayOfFilesInStringArray[i].substring(0, index));
        }

        //https://beginnersbook.com/2014/08/converting-a-hashset-to-an-array/
        String[] arrayNames = new String[names.size()];
        names.toArray(arrayNames);

        return arrayNames;
    }
}
