import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class TestGenerator {

    public static void generator() throws IOException{
        int n = 1;
        long k = 1;
        Random random = new Random();

        while (n != 51) {
            Set<Integer> set = new HashSet<>();
            long bound = k;
            FileWriter nfile = new FileWriter("src/test/java/FilesForTests/FILE" + n + ".txt");
            while (set.size() != bound) {
                int generatedNum = random.nextInt(10000) + 1000;
                if (set.add(generatedNum)) {
                    nfile.write("" + generatedNum);
                    nfile.write("\n");
                }
            }
            n ++;
            k += 200;
            nfile.close();
        }
    }


    public static HashMap<Integer,List<Integer>> getData() throws IOException {
        HashMap<Integer,List<Integer>> allData = new HashMap<>();
        for (int i = 1; i < 51; i++) {
            File file = new File("src/test/java/FilesForTests/FILE" + i + ".txt");
            Scanner scanner = new Scanner(file);
            List<Integer> data = new ArrayList<>();
            while ((scanner.hasNext() != false)) {
                Integer n = Integer.parseInt(scanner.next());
                data.add(n);
            }
            allData.put(i, data);
        }
        return allData;
    }


    public static List<Long> resultsInsert(HashMap<Integer,List<Integer>> allData) {
        List<Long> results = new ArrayList<>();
        for (int i = 1; i < allData.size(); i++) {
            RedBlackTree tree = new RedBlackTree();
            List<Integer> list = allData.get(i);
            long start = System.nanoTime();
            for (int j = 0; j < list.size(); j++) {
                tree.insertNode(list.get(j));
            }
            long t = System.nanoTime() - start;
            results.add(t);
        }
        return results;
    }


    public static List<Long> resultsDelete(HashMap<Integer,List<Integer>> allData){
        List<Long> results = new ArrayList<>();
        for (int i = 1; i < allData.size(); i++) {
            RedBlackTree tree = new RedBlackTree();
            List<Integer> list = allData.get(i);
            for (int j = 0; j < list.size(); j++) {
                tree.insertNode(list.get(j));
            }
            long start = System.nanoTime();
            for (int j = 0; j < list.size(); j++) {
                tree.deleteNode(list.get(j));
            }
            long t = System.nanoTime() - start;
            results.add(t);
        }
        return results;
    }


    public static List<Long> resultsSearch(HashMap<Integer,List<Integer>> allData){
        List<Long> results = new ArrayList<>();
        for (int i = 1; i < allData.size(); i++) {
            RedBlackTree tree = new RedBlackTree();
            List<Integer> list = allData.get(i);
            for (int j = 0; j < list.size(); j++) {
                tree.insertNode(list.get(j));
            }
            long start = System.nanoTime();
            for (int j = 0; j < list.size(); j++) {
                tree.searchNode(list.get(j));
            }
            long t = System.nanoTime() - start;
            results.add(t);
        }
        return results;
    }


    public static void creatSheet(List<Long> list, String nameSheet){
        String FILE_NAME = "src/test/java/FilesForTests/ "+ nameSheet + ".xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        int rowNum = 0;
        int colNum1 = 0;
        int colNum2 = 1;
        int k = 1;
        System.out.println("Creating excelList" + nameSheet);
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(colNum1);
            Cell cell2 = row.createCell(colNum2);

            cell1.setCellValue(list.get(i));
            cell2.setCellValue(k);
            k += 200;
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }


    public static void main(String[] args) throws IOException {
//        generator();
//        creatSheet(resultsInsert(getData()),"resultsInsert");
//        creatSheet(resultsDelete(getData()),"resultsDelete");
//        creatSheet(resultsSearch(getData()),"resultsSearch");
    }
}

