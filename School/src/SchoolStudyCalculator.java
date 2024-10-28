import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolStudyCalculator {

    public static void main(String[] args) {
        List<Map<String, Object>> gradeData = new ArrayList<>();
        List<Map<String, Object>> uniData = new ArrayList<>();
        List<Map<String, Object>> newGradeData = new ArrayList<>();
        List<Map<String, Object>> newUniData = new ArrayList<>();

        // Define the start and end dates for each grade
        LocalDate[][] gradeDates = {
            {LocalDate.of(1978, 9, 1), LocalDate.of(1979, 5, 31)},
            {LocalDate.of(1979, 9, 1), LocalDate.of(1980, 5, 31)},
            {LocalDate.of(1980, 9, 1), LocalDate.of(1981, 5, 31)}
        };
        
        LocalDate[][] gradeDatesMiddle = {
            {LocalDate.of(1981, 9, 1), LocalDate.of(1982, 5, 31)},
            {LocalDate.of(1982, 9, 1), LocalDate.of(1983, 5, 31)},
            {LocalDate.of(1983, 9, 1), LocalDate.of(1984, 5, 31)},
            {LocalDate.of(1984, 9, 1), LocalDate.of(1985, 5, 31)},
            {LocalDate.of(1985, 9, 1), LocalDate.of(1986, 5, 31)}
        };

        LocalDate[][] gradeDatesHigh = {
            {LocalDate.of(1986, 9, 1), LocalDate.of(1987, 5, 31)},
            {LocalDate.of(1987, 9, 1), LocalDate.of(1988, 5, 31)}
        };

        LocalDate[][] univercityIx = {
            {LocalDate.of(1988, 9, 1), LocalDate.of(1989, 5, 31)},
            {LocalDate.of(1989, 9, 1), LocalDate.of(1990, 5, 31)},
            {LocalDate.of(1990, 9, 1), LocalDate.of(1991, 5, 31)},
            {LocalDate.of(1991, 9, 1), LocalDate.of(1992, 5, 31)},
            {LocalDate.of(1992, 9, 1), LocalDate.of(1993, 5, 31)}
        };

        LocalDate[][] newGenerationGrades = {
            {LocalDate.of(2006, 9, 1), LocalDate.of(2007, 5, 31)},
            {LocalDate.of(2007, 9, 1), LocalDate.of(2008, 5, 31)},
            {LocalDate.of(2008, 9, 1), LocalDate.of(2009, 5, 31)},
            {LocalDate.of(2009, 9, 1), LocalDate.of(2010, 5, 31)},
            {LocalDate.of(2010, 9, 1), LocalDate.of(2011, 5, 31)}
        };

        LocalDate[][] newGenerationHighGrades = {
            {LocalDate.of(2011, 9, 1), LocalDate.of(2012, 5, 31)},
            {LocalDate.of(2012, 9, 1), LocalDate.of(2013, 5, 31)},
            {LocalDate.of(2013, 9, 1), LocalDate.of(2014, 5, 31)},
            {LocalDate.of(2014, 9, 1), LocalDate.of(2015, 5, 31)},
            {LocalDate.of(2015, 9, 1), LocalDate.of(2016, 5, 31)},
            {LocalDate.of(2016, 9, 1), LocalDate.of(2017, 5, 31)},
            {LocalDate.of(2017, 9, 1), LocalDate.of(2018, 5, 31)}
        };

        LocalDate[][] newUniver = {
            {LocalDate.of(2018, 9, 1), LocalDate.of(2019, 5, 31)},
            {LocalDate.of(2019, 9, 1), LocalDate.of(2020, 5, 31)},
            {LocalDate.of(2020, 9, 1), LocalDate.of(2021, 5, 31)},
            {LocalDate.of(2021, 9, 1), LocalDate.of(2022, 5, 31)}
        };

        // Calculate grade data
        calculateStudiedTime(gradeDates, 3, 1, 3, gradeData);
        calculateStudiedTime(gradeDatesMiddle, 4.15, 1, 5, gradeData); // fixed to fit the length of the array
        calculateStudiedTime(gradeDatesHigh, 4.5, 1, 2, gradeData); // fixed to fit the length of the array
        
        // Print grade data
        System.out.println("Grade Data:");
        printData(gradeData);

        // Calculate university data
        calculateStudiedTimeUnivercity(univercityIx, 4.5, 1, 5, uniData); // fixed to fit the length of the array
        
        // Print university data
        System.out.println("\nUniversity Data:");
        printData(uniData);

        // Calculate new generation grade data
        calculateStudiedTime(newGenerationGrades, 2, 1, 5, newGradeData);
        calculateStudiedTime(newGenerationHighGrades, 3.5, 1, 7, newGradeData); // fixed to fit the length of the array

        // Print new grade data
        System.out.println("\nNew Generation Grade Data:");
        printData(newGradeData);

        // Calculate new university data
        calculateStudiedTimeUnivercity(newUniver, 4.5, 1, 4, newUniData); // fixed to fit the length of the array
        
        // Print new university data
        System.out.println("\nNew University Data:");
        printData(newUniData);
    }

    public static long calculateWorkingDays(LocalDate startDate, LocalDate endDate) {
        long workingDays = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek().getValue() < 6) { // Monday to Friday
                workingDays++;
            }
        }
        return workingDays;
    }

    public static void calculateStudiedTime(LocalDate[][] gradeDates, double hoursPerDay, int startIndex, int endIndex, List<Map<String, Object>> gradeData) {
        // Ensure endIndex doesn't exceed array length
        endIndex = Math.min(endIndex, gradeDates.length); // adjust endIndex to prevent ArrayIndexOutOfBounds
        for (int i = startIndex - 1; i < endIndex; i++) {
            LocalDate startDate = gradeDates[i][0];
            LocalDate endDate = gradeDates[i][1];
            long workingDays = calculateWorkingDays(startDate, endDate);
            long totalStudiedMinutes = (long) (workingDays * hoursPerDay * 60);

            Map<String, Object> data = new HashMap<>();
            data.put("Анги", (i + 1) + " Анги");
            data.put("Эхлэх жил", startDate.toString());
            data.put("Төгсөх жил", endDate.toString());
            data.put("Сурсан цаг (минут)", totalStudiedMinutes);
            data.put("Ажлын өдөр", workingDays);

            gradeData.add(data);
        }
    }

    public static void calculateStudiedTimeUnivercity(LocalDate[][] gradeDates, double hoursPerDay, int startIndex, int endIndex, List<Map<String, Object>> uniData) {
        // Ensure endIndex doesn't exceed array length
        endIndex = Math.min(endIndex, gradeDates.length); // adjust endIndex to prevent ArrayIndexOutOfBounds
        for (int i = startIndex - 1; i < endIndex; i++) {
            LocalDate startDate = gradeDates[i][0];
            LocalDate endDate = gradeDates[i][1];
            long workingDays = calculateWorkingDays(startDate, endDate);
            long totalStudiedMinutes = (long) (workingDays * hoursPerDay * 60);

            Map<String, Object> data = new HashMap<>();
            data.put("Курс", (i + 1) + " Курс");
            data.put("Эхлэх жил", startDate.toString());
            data.put("Төгсөх жил", endDate.toString());
            data.put("Сурсан цаг (минут)", totalStudiedMinutes);
            data.put("Ажлын өдөр", workingDays);

            uniData.add(data);
        }
    }

    public static void printData(List<Map<String, Object>> dataList) {
        for (Map<String, Object> data : dataList) {
            System.out.println(data);
        } 

        public static void printData(List<Map<String, Object>> dataList) {
            for (Map<String, Object> data : dataList) {
                System.out.println(data);
    }
}
