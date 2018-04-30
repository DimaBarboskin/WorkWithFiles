package workWithFiles;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorkWithFiles {
    public static void main(String[] args){
        try {
            readFile();
            System.out.println("----------------------");
            sortAlphabetOrder(fillMap());
            System.out.println("----------------------");
            System.out.println(fillMap());
            System.out.println("----------------------");
            findMaxRepeat(fillMap());
        } catch (FileNotFoundException e) {
            System.err.println("There isn't any file");
        }
    }

    public static void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Text.txt"));
            while (scanner.hasNext()) {
                String word = scanner.useDelimiter("\\s").next();
                System.out.print(word + " ");
            }
        System.out.println();
        scanner.close();
    }

    public static void sortAlphabetOrder(Map<String, Integer> map) {
        TreeMap<Object, Object> change = new TreeMap<>(map);
        System.out.println(change.keySet());
    }

    public static Map<String,Integer> fillMap() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Text.txt"));
        Map<String, Integer> statistics = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s").next();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
        }
        scanner.close();
        return statistics;
    }

    public static void findMaxRepeat(Map<String,Integer> map){
        Integer max =0;
        String maxStr = "";
        for(Map.Entry pair: map.entrySet()){
            if(max < (int) pair.getValue()){
                max = (int) pair.getValue();
                maxStr = (String) pair.getKey();
            }
        }
        System.out.println(maxStr + " = " + max);
    }
}

