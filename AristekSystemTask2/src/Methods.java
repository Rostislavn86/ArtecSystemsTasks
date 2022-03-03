import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Locale;

public class Methods
{
    // Переделать вывод используя код TestRepWords - то есть тут идекс не нужен !!!
    //Сортируем текст и индекс для правильного вывода
    public void DataOutput(String[] words, int numberOfLines)
    {
        for (int i = 0; i < words.length; i++)
        {
            words[i] = words[i].trim();
        }

        // Формируем индексацию каждого слова
        //String[] words=input.split(" ");  //Split the word from String
        int[] index = new int[words.length];    //Variable for getting Repeated word count

        for(int i=0;i<words.length;i++) //Outer loop for Comparison
        {
            index[i] += 1;
            // Убираем таким образом местоимения
            if (words[i].length() <= 4)
            {
                index[i] = 0;
                continue;
            }
            for(int j=i+1;j<words.length;j++) //Inner loop for Comparison
            {
                if(words[i].equals(words[j]))  //Checking for both strings are equal
                {
                    index[i]=index[i]+1;    //if equal increment the count
                    words[j]="0"; //Replace repeated words by zero
                }
            }
            //if(words[i]!="0")
            //    System.out.println(words[i]+"--"+index[i]); //Printing the word along with count
        }

        //Сортировка
        boolean isSorted = false;

        int bufInt;
        String bufStr;

        String[] arrayTotalOutPut = new String[words.length];

        while(!isSorted)
        {
            isSorted = true;
            for (int i = 0; i < index.length-1; i++)
            {
                if(index[i] < index[i+1])
                {
                    isSorted = false;

                    bufInt = index[i];
                    index[i] = index[i+1];
                    index[i+1] = bufInt;

                    bufStr = words[i];
                    words[i] = words[i+1];
                    words[i+1] = bufStr;
                }
            }
        }

        for(int i = 0; i < arrayTotalOutPut.length; i++)
        {
            // пропускаем вывод местоимений
            if (index[i] == 0) continue;
            arrayTotalOutPut[i] = words[i] + " - " + index[i] + " раз ";
            System.out.println(arrayTotalOutPut[i]);
        }

    }

    //Очищаем строку от мусора и создаём новый массив
    public String[] CleanFromTrashAndSmallWordsAndCreateArrayOfWords(String allText)
    {
        allText = allText.toLowerCase(Locale.ROOT);
        allText = allText.trim();

        allText = allText.replaceAll("\\n", "");
        //убираем все знаки из текста
        allText = allText.replaceAll("[,.!?:;»«()‘’]", " ");

        String[] allTextArray = allText.split(" ");

        return allTextArray;
    }

    //Новый !!!! Метод считывающий информацию из файла с заданныим именем файла
    public String GetStringArrayFromFilename(String fileName) throws IOException
    {
        //https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

        Path fileNamePath = Path.of("rap-battles/" + fileName);

        String data = Files.readString(fileNamePath);

        //data = data.replaceAll("\s", " ");

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
    public String[] MakeArrrayOfFilesInStringArray()
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
