import java.util.Vector;

public class QJson {
    public Vector read(String object, String arrayName) {

        Vector error = new Vector();
        error.add("error");

        int nameIndex, fBracket, sBracket, array;

        nameIndex = object.indexOf("name:\"" + arrayName + "\"");
        if (nameIndex == -1) {

            return error;
        }

        array = object.indexOf("array", nameIndex);

        fBracket = object.indexOf("[", array + 1);
        sBracket = object.indexOf("]", fBracket + 1);
        String sub = "," + object.substring(fBracket + 1, sBracket) + ",";


        int first = -1, second = 0;
        Vector list = new Vector();


        while (sub.indexOf(",", second + 1) != -1) {
            first = sub.indexOf(",", first + 1);
            second = sub.indexOf(",", second + 1);
            list.add(sub.substring(first + 1, second));

        }


        return list;

    }
}
