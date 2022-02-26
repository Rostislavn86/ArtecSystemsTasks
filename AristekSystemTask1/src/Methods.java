import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods
{
    // Метод подсчитывающий количество нецензурных слов в тексте определённогоо автора
    public static int CountBadWordsAllText(String authorName) throws IOException
    {
        String[] allTextOfTheAuthor = CollectAllTextOfTheAuthor(authorName);
        String[] allBadWords = GetBadWordsFromFile();

        int count = 0;

        for(int i = 0; i < allTextOfTheAuthor.length; i++)
        {
            for(int j = 0; j < allBadWords.length; j++)
            {
                if (allTextOfTheAuthor[i].toLowerCase().contains(allBadWords[j].toLowerCase()))
                    count++;
            }
        }
        return count;
    }

    //Метод собирающий все текста одного исполнителя
    public static String[] CollectAllTextOfTheAuthor(String authorName)
    {
        String[] fileNames = MakeArrrayOfFilesInStringArray();
        String collectAllText = "";

        for(int i = 0; i < fileNames.length; i++)
        {
            if (fileNames[i].startsWith(authorName))
            {
            collectAllText += GetStringArrayFromFilename(fileNames[i]);
            }
        }

        String[] collectAllTextArray = collectAllText.split(" ");

        return collectAllTextArray;
    }

    //Метод подсчитывающий количество батлов каждого исоплнителя
    public static int CountNamberOfTheBattles(String authorName)
    {
        MakeArrrayOfFilesInStringArray();

        int count = 0;

        for(int i = 0; i < MakeArrrayOfFilesInStringArray().length; i++)
        {
            if (MakeArrrayOfFilesInStringArray()[i].startsWith(authorName))
                count++;
        }
        return count;
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
    public static String[] MakeArrayNamesFromFileNames(String[] MakeArrrayOfFilesInStringArray)
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

    //Метод считывающий информацию из файла с заданныим именем файла
    public static String GetStringArrayFromFilename(String fileName)
    {
        File apath = new File("rap-battles/" + fileName);

        String data = "";

        try {
            Scanner myReader = new Scanner(apath);
            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return data;
    }

    //Метод считывающий плохие слова из файла (словарь плохих слов)
    //https://github.com/Rostislavn86/IntroductionToJava/tree/master/src/StringsAndBasicsOfTextProcessing/WorkingWithRegularExpressionsPatternMatcher/Task2
    public static String[] GetBadWordsFromFile() throws IOException
    {
        String contents = new String(Files.readAllBytes(Paths.get("BadWordsFile.xml")));

        final Pattern pattern = Pattern.compile("<description>(.+?)</description>", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(contents);
        matcher.find();

        String words =matcher.group();

        words = words.trim();

        words = words.replace("<description>","");
        words = words.replace("</description>","");

        String[] wordsArray = words.split(" ");

        for (int i = 0; i < wordsArray.length; i++)
        {
            wordsArray[i] = wordsArray[i].replace(",","");
        }

        return  wordsArray;
    }

    //Метод выводящий всю информацию по исполнителю
    public void OutputAndSortAllInformation(String command,String countOfMosBadPoets) throws IOException
    {
        if (!command.equals("-top-bad-words"))
        {
            System.out.println("Комманда не найдена и будет закрыта");
            System.exit(0);
        }

        String[] artistName = new String[MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray()).length];
        Integer[] numberOfBattles = new Integer[artistName.length];
        Integer[] theNumberOfBadWordsInAllTextsOfTheAuthor = new Integer[numberOfBattles.length];
        Float[] awergeNumbersOfObsceneWords = new Float[theNumberOfBadWordsInAllTextsOfTheAuthor.length];

        for(int i = 0; i < MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray()).length; i++)
        {
            artistName[i] = MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i];
            numberOfBattles[i] = CountNamberOfTheBattles(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i]);
            theNumberOfBadWordsInAllTextsOfTheAuthor[i] = CountBadWordsAllText(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i]);
            awergeNumbersOfObsceneWords[i] = (float)CountBadWordsAllText(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i])/CountNamberOfTheBattles(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i]);
        }

        //Сортируем все массивы по количеству плохих слов

        /*
            artistName[i] = MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i];
            numberOfBattles[i] = CountNamberOfTheBattles(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i]);
            theNumberOfBadWordsInAllTextsOfTheAuthor[i] = CountBadWordsAllText(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i]);
            awergeNumbersOfObsceneWords[i] = (float)CountBadWordsAllText(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i])/CountNamberOfTheBattles(MakeArrayNamesFromFileNames(MakeArrrayOfFilesInStringArray())[i]);
         */

        //Сортировка
        boolean isSorted = false;

        int bufInt;
        String bufStr;
        float floatbuf;

        while(!isSorted)
        {
            isSorted = true;
            for (int i = 0; i < theNumberOfBadWordsInAllTextsOfTheAuthor.length-1; i++) {
                if(theNumberOfBadWordsInAllTextsOfTheAuthor[i] < theNumberOfBadWordsInAllTextsOfTheAuthor[i+1]){
                    isSorted = false;

                    bufStr = artistName[i];
                    artistName[i] = artistName[i+1];
                    artistName[i+1] = bufStr;

                    bufInt = numberOfBattles[i];
                    numberOfBattles[i] = numberOfBattles[i+1];
                    numberOfBattles[i+1] = bufInt;

                    bufInt = theNumberOfBadWordsInAllTextsOfTheAuthor[i];
                    theNumberOfBadWordsInAllTextsOfTheAuthor[i] = theNumberOfBadWordsInAllTextsOfTheAuthor[i+1];
                    theNumberOfBadWordsInAllTextsOfTheAuthor[i+1] = bufInt;

                    floatbuf = awergeNumbersOfObsceneWords[i];
                    awergeNumbersOfObsceneWords[i] = awergeNumbersOfObsceneWords[i+1];
                    awergeNumbersOfObsceneWords[i+1] = floatbuf;
                }
            }
        }

        int countOfMosBadPoetsInt = Integer.parseInt(countOfMosBadPoets);

        for(int i = 0; i < countOfMosBadPoetsInt; i++)
        {
            System.out.println(artistName[i]
                    + "      | "
                    + numberOfBattles[i] + " батлов | "
                    + theNumberOfBadWordsInAllTextsOfTheAuthor[i]
                    + " нецензурных слова  | "
                    + awergeNumbersOfObsceneWords[i] + " слова на батл " );
        }

    }

}
