import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserItem {

    public Item parceData(String userItem) throws ExceptionCountItems, ExceptionFormatItems {
        String[] arrayObject = userItem.split(" ");
        if (arrayObject.length != Item.CountItem) {
            throw new ExceptionCountItems("Количество полей задано неверно");
        }

        Item object = new Item();
        object.setFamily(parseFIO(arrayObject[0]));
        object.setName(parseFIO(arrayObject[1]));
        object.setOtchestvo(parseFIO(arrayObject[2]));
        object.setDateOfBirth(parseDR(arrayObject[3]));
        object.setPhone(parsePhone(arrayObject[4]));
        object.setSex(parseSex(arrayObject[5]));

        return object;
    }

    private String parseFIO(String object) throws ExceptionFormatItems {
        if (object == null || object.isEmpty()) {
            throw new ExceptionFormatItems("Некорректные данные - ФИО.");
        }

        String result = stringFIO(object);
        return result;
    }

    private String parseDR(String object) throws ExceptionFormatItems {
        final String baseErrorMessage = "Некорректные данные - Дата рождения. Формат даты не соответствует dd.mm.yyyy";

        try {
            DateFormat dr = new SimpleDateFormat("dd.MM.yyyy");
            dr.setLenient(false);
            dr.parse(object);

            return object;
        } catch (Exception e) {
            throw new ExceptionFormatItems(baseErrorMessage);
        }
    }

    private Integer parsePhone(String object) {
        return Integer.parseInt(object);
    }

    private String parseSex(String object) throws ExceptionFormatItems {
        List<String> allowSymbol = new ArrayList<String>(Arrays.asList(new String[] { "f", "m" }));
        if (!allowSymbol.contains(object)) {
            throw new ExceptionFormatItems("Некорректные данные - пол.");
        }

        return object;
    }

    private String stringFIO(String object) {
        String partFIO1 = object.substring(0, 1);
        String partFIO2 = object.substring(1, object.length());
        String result = partFIO1.toUpperCase() + partFIO2.toLowerCase();
        return result;
    }
}
