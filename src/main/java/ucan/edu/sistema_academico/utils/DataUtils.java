package ucan.edu.sistema_academico.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

public class DataUtils {
    public static LocalDate escolherAleatoriamenteDataNascimento(int minAge, int maxAge) {
        Random random = new Random();
        int year = LocalDate.now().getYear() - (minAge + random.nextInt(maxAge - minAge + 1));

        // Ensure the date is valid by using a valid month and day
        int month = random.nextInt(12) + 1;
        int day = generateValidDay(year, month);

        return LocalDate.of(year, month, day);
    }

    private static int generateValidDay(int year, int month) {
        switch (month) {
            case 2:
                return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
                        ? 1 + new Random().nextInt(29)
                        : 1 + new Random().nextInt(28);
            case 4: case 6: case 9: case 11:
                return 1 + new Random().nextInt(30);
            default:
                return 1 + new Random().nextInt(31);
        }
    }
}