import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public static void convertTemperature(double value, String unit) {
        unit = unit.toLowerCase();
        if (unit.equals("celsius") || unit.equals("c")) {
            System.out.printf("%.2f°C is %.2f°F and %.2fK\n", value, celsiusToFahrenheit(value), celsiusToKelvin(value));
        } else if (unit.equals("fahrenheit") || unit.equals("f")) {
            System.out.printf("%.2f°F is %.2f°C and %.2fK\n", value, fahrenheitToCelsius(value), fahrenheitToKelvin(value));
        } else if (unit.equals("kelvin") || unit.equals("k")) {
            System.out.printf("%.2fK is %.2f°C and %.2f°F\n", value, kelvinToCelsius(value), kelvinToFahrenheit(value));
        } else {
            System.out.println("Invalid unit. Please enter Celsius, Fahrenheit, or Kelvin.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the temperature value: ");
            double value = scanner.nextDouble();
            System.out.print("Enter the unit (Celsius, Fahrenheit, Kelvin): ");
            String unit = scanner.next();
            convertTemperature(value, unit);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numeric temperature value.");
        } finally {
            scanner.close();
        }
    }
}