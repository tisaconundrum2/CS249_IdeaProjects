import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by User on 4/29/2015.
 */
public class GenerateCsv
{
    static FileWriter writer;
    public static void generateCsvFile(String sFileName)
    {
        try
        {
            writer = new FileWriter(sFileName);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void addData(long data){
        String str = "" + data;
        try {
            writer.append(str);writer.append(',');writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(){
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
