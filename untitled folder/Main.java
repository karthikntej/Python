/* Save this in a file called Main.java to compile and test it */

/* 
   Example file showing how to write a program that reads
   input from `input.txt` in the current directory
   and writes output to `output.txt` in the current directory
*/

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */


public class Main {
    
    class ApiObj {
        String apiName;
        String appName;
        int oldestVersion;
        boolean multipleVersions = false;
        
        ApiObj(String appName, String apiName, int oldestVersion ) {
            this.appName = appName;
            this.apiName = apiName;
            this.oldestVersion = oldestVersion;
        }
    }

    
    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        
        HashMap<String, Main.ApiObj> map = new HashMap<String, Main.ApiObj>();
        int currentVersion = 0;
        Main.ApiObj oldestObj = new Main().new ApiObj("None", "None", Integer.MAX_VALUE);
        
        
        int numLines = 0;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));

            /* Here we can read in the input file */
            /* In this example, we're reading all the lines of file
               `input.txt` and then ignoring them. 
               You should modify this part of the
               program to read and process the input as desired */
            while(in.hasNextLine()) {
                String line = in.nextLine();
                
                if (!line.isEmpty()){
                    
                    String[] arrOfVals = line.split(", ",0);
                    currentVersion = Integer.parseInt(arrOfVals[2].substring(1));
                    
                    Main.ApiObj presentObj = new Main().new ApiObj(arrOfVals[0], arrOfVals[1], currentVersion);
                    
                    if (map.containsKey(presentObj.apiName)) {
                        Main.ApiObj obj= map.get(presentObj.apiName);
                        if (obj.oldestVersion != presentObj.oldestVersion) {
                            presentObj.multipleVersions = true;
                            obj.multipleVersions = true;
                            
                        }

                        if (obj.oldestVersion > presentObj.oldestVersion) {
                            map.put(presentObj.apiName, presentObj);
                        }
                        
                    } else {
                        map.put(arrOfVals[1], presentObj);
                    }
                    
                    numLines++;
                }
            
            }
            
            for (String i : map.keySet()) {
                Main.ApiObj obj = map.get(i);
                if (obj.multipleVersions) {
                    if (oldestObj.oldestVersion > obj.oldestVersion) {
                        oldestObj = obj;
                    }
                }
                
            }
            
            System.out.println(oldestObj.appName);
            
            /* In this example, we're writing `num_lines` to
               the file `output.txt`.
               You should modify this part of the
               program to write the desired output */
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            output.println("" + oldestObj.appName);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
