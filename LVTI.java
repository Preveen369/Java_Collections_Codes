import java.util.ArrayList;

public class LVTI {
    // 'var' can't be used as class name
    public static void main(String[] args) {
        // LOCAL VARIABLE TYPE INFERENCE (LVTI) using 'var' keyword
        // applicable only for local variables (variables inside the method)
        // 'var' keyword can't be used inside the class

        var obj = new ArrayList();
        int a = 10; // int type is defined statically
        var b = 20; // compiler automatically defines type
        int c;

        // Initialization of 'var' type variable is compulsory
        // var d; -> gives the error

        // var can be used as variable name (inside method)
        String var = "Preveen";

    }
}
