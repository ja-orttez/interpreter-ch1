package frontend;

public class MainParser {
   
    public static void main(String[] args) {
        try {
            // from standard input
            if (args.length == 0)
                new frontend.generated.RamParser(System.in).Goal();
            else {
                java.io.InputStream is = new java.io.FileInputStream(new java.io.File(args[0]));
                new frontend.generated.RamParser(is).Goal();
            }

            System.out.println("Parsing successful!");
        } catch (frontend.generated.ParseException e) {
            System.err.println("Parser Error : \n" + e.toString());
            return;
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File Not Found: " + e);
            return;
        }
    }
}
