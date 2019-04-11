package mercuryTours.POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SplitArray {
	static String filepath = "C://UTILITY//SearchHack//TestData.xlsx";
	String user;
	static FileInputStream fis ;
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	 XSSFRow row;
	 
	public static void main(String[] args) throws IOException {
		List<String> arrVar = new ArrayList<>();
		 try {
				fis = new FileInputStream(filepath);
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			}
		 workbook = new XSSFWorkbook(fis);
		  sheet = workbook.getSheet("Sheet1");
		  for(int i = 0; i <=sheet.getLastRowNum(); i++) {
			  //System.out.println(sheet.getRow(i).getCell(0).toString());
			  arrVar.add(sheet.getRow(i).getCell(0).toString());
		  }
		 List<List<String>> str = splitArray(arrVar , 30);
		 Iterator<List<String>> itertr = str.iterator();
		while(itertr.hasNext()) {
			List<String> k = itertr.next();
			System.out.println(k);
		}
		  
	}
	
	public static List<List<String>> splitArray(List<String> arrayToSplit, int chunkSize){
		if(chunkSize<=0){
            return null;  // just in case :)
        }
        // first we have to check if the array can be split in multiple 
        // arrays of equal 'chunk' size
       int rest = arrayToSplit.size() % chunkSize;  // if rest>0 then our last array will have less elements than the others 
        // then we check in how many arrays we can split our input array
        int chunks = arrayToSplit.size() / chunkSize + (rest > 0 ? 1 : 0); // we may have to add an additional array for the 'rest'
        // now we know how many arrays we need and create our result array
        List<String> arrays = new  ArrayList<String>();
        List<List<String>> testobj = new ArrayList<List<String>>();
        // we create our resulting arrays by copying the corresponding 
        // part from the input array. If we have a rest (rest>0), then
        // the last array will have less elements than the others. This 
        // needs to be handled separately, so we iterate 1 times less.
        for(int i = 0; i < (rest > 0 ? chunkSize - 1 : chunkSize); i++){
            // this copies 'chunk' times 'chunkSize' elements into a new array
            //arrays[i] = Arrays.copyOfRange(arrayToSplit, i * chunkSize, i * chunkSize + chunkSize);
            arrays = arrayToSplit.subList((i * chunks),(i * chunks + chunks));
            testobj.add(arrays);
            
            
        }
        if(rest > 0){ // only when we have a rest
            // we copy the remaining elements into the last chunk
            //arrays = arrayToSplit.subList(((chunks - 1) * chunkSize), ((chunks - 1) * chunkSize + rest));  
        	arrays = arrayToSplit.subList((chunks*(chunkSize-1)), arrayToSplit.size());

            testobj.add(arrays);
        }
        return testobj; // that's it

	}

}

