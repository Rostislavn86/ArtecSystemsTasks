import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;

public class Methods
{
    //Сортируем текст и индекс для правильного вывода
    public void DataOutput(String[] words, int numberOfLines)
    {
        for (int i = 0; i < words.length; i++)
        {
            words[i] = words[i].trim();
        }

        // Формируем индексацию каждого слова
        int[] index = new int[words.length];

        for(int i=0;i<words.length;i++) //Outer loop for Comparison
        {
            index[i] += 1;
            // Убираем таким образом местоимения
            if (words[i].length() <= 5)
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

        for(int i = 0; i < 10; i++)
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

    public void MainMenu(String[] authorNames,String commandNameNumberOutPut, int NumberOutPut, String CommandAuthorName, String authorNamePut) throws IOException {

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

    public void MainMenu(String[] authorNames) throws IOException
    {
        System.out.println("Вы не ввели ни одной комманды - программа будет закрыта");

        System.exit(0);
    }

}
