import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class Methods
{
    //Сортируем текст и индекс для правильного вывода
    public void DataOutput(int[] index, String[] words, int numberOfLines)
    {
        //Что бы убрать повторяющиеся слова - которая я не понимаю как но появляться - воспользумесяц HashSet<String> fileNames = new HashSet<>();

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
            arrayTotalOutPut[i] = words[i] + " - " + index[i] + " раз ";
        //    System.out.println(arrayTotalOutPut[i]);
        }

        String[] outPutArray = new String[arrayTotalOutPut.length];

        //https://www.geeksforgeeks.org/print-distinct-elements-given-integer-array/
        // Вывод

                for (int i = 0; i < arrayTotalOutPut.length; i++)
                {
                int j;
                for (j = 0; j < i; j++)
                    //if ((arrayTotalOutPut[i].equals(arrayTotalOutPut[j]) || ((arrayTotalOutPut[i].contains(arrayTotalOutPut[j])))))
                    if ((((arrayTotalOutPut[i].contains(arrayTotalOutPut[j])))))
                        break;
                // If not printed earlier,
                // then print it
                if (i == j)
               {
                   outPutArray[i] = arrayTotalOutPut[i];
               //    System.out.println(i + " : " + arrayTotalOutPut[i]);
               }
                else
                {
                    outPutArray[i] = "empty";
                }
               }

                for(int i = 0; i < outPutArray.length; i++)
                {

                    if (outPutArray[i].equals("empty")) continue;
                    //if (outPutArray[i].contains("-")) continue;

                    System.out.println(outPutArray[i]);
                }
    }

    //Убираем повторяющееся слова в массиве слов из текста
    public String[] DeleteDublicateFromText(String[] wordsFromTextArray)
    {
        HashSet<String> wordsNotDublicated = new HashSet<>();

        for(int i = 0; i < wordsFromTextArray.length; i++)
        {
            wordsNotDublicated.add(wordsFromTextArray[i]);
        }

        //https://beginnersbook.com/2014/08/converting-a-hashset-to-an-array/
        String[] arrayNames = new String[wordsNotDublicated.size()];
        wordsNotDublicated.toArray(arrayNames);

        return arrayNames;
    }



    //Создаём проиндесированный массив повторяющехся элементов
    public int[] CreateArrayIndexing(String[] wordsFromTextArray)
    {

        int[] indexArray = new int[wordsFromTextArray.length];

        for(int i = 0; i < wordsFromTextArray.length; i++)
        {
            // +1 так как слово в тексте в любом случае встречается один раз
            indexArray[i]++;

            // Исключаю из обработки пустые строки
            if (wordsFromTextArray[i].equals(" "))
            {
                indexArray[i] = 0 ;
                continue;
            }
            //Здесь я как бы убираю местоименя
            if (wordsFromTextArray[i].length() <= 5)
            {
                indexArray[i] = 0 ;
                continue;
            }

            for(int j = 0; j < wordsFromTextArray.length; j++)
            {
                if (wordsFromTextArray[i].equals(wordsFromTextArray[j]) && (i != j))
                {
                    indexArray[i] += 1;
                }
            }
        }



        return indexArray;

    }


    //Очищаем строку от мусора (запятых местоимений) и создаём новый массив
    public String[] CleanFromTrashAndSmallWordsAndCreateArrayOfWords(String allText)
    {
        allText = allText.toLowerCase(Locale.ROOT);
        allText = allText.trim();

        allText = allText.replaceAll("\n", "-");
        //убираем все знаки из текста
        allText = allText.replaceAll("[,.!?:;»«()]", " ");

        allText = allText.replaceAll("  ", " ");

        //allText = allText.replaceAll("\n", "-");

        //allText = allText.replaceAll("-", "");

        String[] allTextArray = allText.split(" ");

        return allTextArray;
    }


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
