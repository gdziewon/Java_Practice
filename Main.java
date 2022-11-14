import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

class AmazningNumbers {
    public static String arrToProp(int prop) {
        switch (prop) {
            case 0:
                return "EVEN";
            case 1:
                return "ODD";
            case 2:
                return "BUZZ";
            case 3:
                return "DUCK";
            case 4:
                return "PALINDROMIC";
            case 5:
                return "GAPFUL";
            case 6:
                return "SPY";
            case 7:
                return "SQUARE";
            case 8:
                return "SUNNY";
            case 9:
                return "JUMPING";
            case 10:
                return "HAPPY";
            case 11:
                return "SAD";
        }
        return "ERROR";
    }
    public static boolean ifNumberGoodSwitch(long input, int prop) {
        switch (prop) {
            case 0:
                if (!ifEven(input)) {
                    return false;
                }
                break;
            case 1:
                if (ifEven(input)) {
                    return false;
                }
                break;
            case 2:
                if (!ifBuzz(input)) {
                    return false;
                }
                break;
            case 3:
                if (!ifDuck(input)) {
                    return false;
                }
                break;
            case 4:
                if (!ifPali(input)) {
                    return false;
                }
                break;
            case 5:
                if (!ifGap(input)) {
                    return false;
                }
                break;
            case 6:
                if (!ifSpy(input)) {
                    return false;
                }
                break;
            case 7:
                if (!ifSquare(input)) {
                    return false;
                }
                break;
            case 8:
                if (!ifSquare(input + 1)) {
                    return false;
                }
                break;
            case 9:
                if (!ifJump(input)) {
                    return false;
                }
                break;
            case 10:
                if (!ifHappy(input)) {
                    return false;
                }
                break;
            case 11:
                if (ifHappy(input)) {
                    return false;
                }
                break;
        }
        return true;
    }
    public static boolean exclusiveProps(int[] props) {
        for(int i = 0; i < 12; i++) {
            if (props[i] == -1) {
                System.out.printf("The request contains mutually exclusive properties: [%s, -%s]%n",arrToProp(i),arrToProp(i));
                return true;
            }
        }
        if (props[0] == 1 && props[1] == 1) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]");
            return true;
        }
        if (props[0] == -2 && props[1] == -2) {
            System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]");
            return true;
        }
        if (props[3] == 1 && props[6] == 1) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
            return true;
        }
        if (props[3] == -2 && props[6] == -2) {
            System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]");
            return true;
        }
        if (props[7] == 1 && props[8] == 1) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            return true;
        }
        if (props[7] == -2 && props[8] == -2) {
            System.out.println("The request contains mutually exclusive properties: [-SQUARE, -SUNNY]");
            return true;
        }
        if (props[10] == 1 && props[11] == 1) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]");
            return true;
        }
        if (props[10] == -2 && props[11] == -2) {
            System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]");
            return true;
        }
        return false;
    }
    public static boolean ifNumberGood(long input, int[] props) {
        for (int i = 0; i < 12; i++) {
            if (props[i] == 1) {
                if(!ifNumberGoodSwitch(input, i)) {
                    return false;
                }
            }
            if (props[i] == -2) {
                if(ifNumberGoodSwitch(input, i)) {
                    return false;
                };
            }
        }
        return true;
    }
    public static void printBadProps(String[] prop, int[] props) {
        int ifComma = 0;
        for (int i = 0; i < 12; i++) {
            if(props[i] > 1) {
                if(ifComma > 0) {
                    System.out.print(", ");
                }
                System.out.print(prop[i + 2].toUpperCase());
                ifComma++;
            }
        }
    }
    public static int goodProperties(int[] props) {
        int howManyBad = 0;
        for(int i = 0; i < 12; i++) {
            if(props[i] > 1) {
                System.out.print("hii");
                howManyBad++;
            }
        }
        return howManyBad;
    }
    public static int[] propertiesArr(String[] prop, int[] props) {
        for(int i = 2; i < prop.length; i ++) {

            switch (prop[i].toLowerCase()) {
                case "even":
                    props[0]+= props[0] < 1? 1 : 0;;
                    break;
                case "odd":
                    props[1]+= props[1] < 1? 1 : 0;;
                    break;
                case "buzz":
                    props[2]+= props[2] < 1? 1 : 0;;
                    break;
                case "duck":
                    props[3]+= props[3] < 1? 1 : 0;;
                    break;
                case "palindromic":
                    props[4]+= props[4] < 1? 1 : 0;;
                    break;
                case "gapful":
                    props[5]+= props[5] < 1? 1 : 0;;
                    break;
                case "spy":
                    props[6]+= props[6] < 1? 1 : 0;;
                    break;
                case "square":
                    props[7] += props[7] < 1? 1 : 0;
                    break;
                case "sunny":
                    props[8]+= props[8] < 1? 1 : 0;;
                    break;
                case "jumping":
                    props[9]+= props[9] < 1? 1 : 0;;
                    break;
                case "happy":
                    props[10]+= props[10] < 1? 1 : 0;
                    break;
                case "sad":
                    props[11]+= props[11] < 1? 1 : 0;;
                    break;
                case "-even":
                    props[0] -= props[0] > -2? 2 : 0;
                    break;
                case "-odd":
                    props[1] -= props[1] > -2? 2 : 0;
                    break;
                case "-buzz":
                    props[2] -= props[2] > -2? 2 : 0;
                    break;
                case "-duck":
                    props[3] -= props[3] > -2? 2 : 0;
                    break;
                case "-palindromic":
                    props[4] -= props[4] > -2? 2 : 0;
                    break;
                case "-gapful":
                    props[5] -= props[5] > -2? 2 : 0;
                    break;
                case "-spy":
                    props[6] -= props[6] > -2? 2 : 0;
                    break;
                case "-square":
                    props[7] -= props[7] > -2? 2 : 0;
                    break;
                case "-sunny":
                    props[8] -= props[8] > -2? 2 : 0;
                    break;
                case "-jumping":
                    props[9] -= props[9] > -2? 2 : 0;
                    break;
                case "-happy":
                    props[10] -= props[10] > -2? 2 : 0;
                    break;
                case "-sad":
                    props[11] -= props[11] > -2? 2 : 0;
                    break;
                default:
                    props[i - 2] = 120;
            }
        }
        return props;
    }

    public static void oneNumber(long input) {
        System.out.println("Properties of " + input);
        System.out.println("        buzz: " + ifBuzz(input));
        System.out.println("        duck: " + ifDuck(input));
        System.out.println(" palindromic: " + ifPali(input));
        System.out.println("      gapful: " + ifGap(input));
        System.out.println("         spy: " + ifSpy(input));
        System.out.println("      square: " + ifSquare(input));
        System.out.println("       sunny: " + ifSquare(input + 1));
        System.out.println("     jumping: " + ifJump(input));
        System.out.println("       happy: " + ifHappy(input));
        System.out.println("         sad: " + !ifHappy(input));
        System.out.println("        even: " + ifEven(input));
        System.out.println("         odd: " + !ifEven(input));
    }

    public static void twoNumbersOutput(long input) {
        System.out.print(input + " is");
        if (ifBuzz(input)) {
            System.out.print(" buzz,");
        }
        if (ifDuck(input)) {
            System.out.print(" duck,");
        }
        if (ifPali(input)) {
            System.out.print(" palindromic,");
        }
        if (ifGap(input)) {
            System.out.print(" gapful,");
        }
        if (ifSpy(input)) {
            System.out.print(" spy,");
        }
        if (ifSquare(input)) {
            System.out.print(" square,");
        }
        if (ifSquare(input + 1)) {
            System.out.print(" sunny,");
        }
        if (ifJump(input)) {
            System.out.print(" jumping,");
        }
        if (ifHappy(input)) {
            System.out.print(" happy,");
        }
        if (!ifHappy(input)) {
            System.out.print(" sad,");
        }
        if (ifEven(input)) {
            System.out.print(" even\n");
        } else {
            System.out.print(" odd\n");
        }
        System.out.println();
    }

    public static boolean checkingNumbers(String[] numbers) {
        int which = 0;
        for (String s : numbers) {
            if (!s.matches("[0-9]+") && which < 2) {
                if (which == 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else {
                    System.out.println("The second parameter should be a natural number.");
                }
                return true;
            }
            if (which == 1 && "0".equals(s)) {
                System.out.println("The second parameter should be a natural number.");
                return true;
            }
            which++;
        }
        return false;
    }

    public static void instructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.\n");
    }

    public static boolean ifHappy(long input) {
        long sum = 0;
        long temp = input;
        for (int i = 0; i < 20; i++) {
            while (temp != 0) {
                sum += (temp % 10) * (temp % 10);
                temp = (temp - (temp % 10)) / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (sum == input) {
                return false;
            }
            temp = sum;
            sum = 0;
        }
        return false;
    }
    public static boolean ifJump(long input) {
        long digitBefore = input % 10;
        long ifGood = 0;
        while(input >= 10) {
            ifGood = ((input - digitBefore) / 10) % 10 - digitBefore;
            if(!(ifGood == 1 || ifGood == -1)) {
                return false;
            }
            digitBefore = ((input - digitBefore) / 10) % 10;
            input = (input - (input % 10)) / 10;
        }
        return true;
    }
    public static boolean ifSquare(long input) {
        double squareRoot = Math.sqrt(input);
        if(squareRoot % 1 == 0) {
            return true;
        }
        return false;
    }

    public static boolean ifSpy(long input) {
        long temp = input;
        long product = 1;
        long sum = 0;
        while(temp != 0) {
            sum += temp % 10;
            product *= temp % 10;
            temp = (temp - (temp % 10)) / 10;
        }
        if (product == sum) {
            return true;
        }
        return false;
    }

    public static boolean ifGap(long input) {
        if (input <= 99) {
            return false;
        }
        long first = 1;
        long last = input % 10;
        long temp = input;
        while (temp != 0) {
            first = temp % 10;
            temp = (temp - (temp % 10)) / 10;
        }
        if(input % (first * 10 + last) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ifPali(long input) {
        long reverse = 0;
        long temp = input;
        do {
            reverse = reverse * 10 + input % 10;
            input = (input - input % 10) / 10;
        } while (input != 0);
        return reverse == temp;
    }

    public static boolean ifEven(long input) {
        if (input % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ifDuck(long input) {
        if (input % 10 == 0) {
            return true;
        } else if (input >= 10) {
            return ifDuck(input / 10);
        } else {
            return false;
        }
    }


    public static boolean ifBuzz(long input) {
        if (input % 10 == 7 || input % 7 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString;
        String[] numbers;
        int[] props = new int[12];
        long inputLong = 1;
        long inputAmount = 0;
        System.out.println("Welcome to Amazing Numbers!\n");
        instructions();
        do {
            Arrays.fill(props, 0);
            System.out.print("Enter a request: ");
            inputString = scan.nextLine();

            if ("".equals(inputString)) {
                instructions();
                continue;
            }
            numbers = inputString.split(" ");

            if (checkingNumbers(numbers)) {
                continue;
            }
            inputLong = Long.parseLong(numbers[0]);

            if (inputLong == 0) {
                System.out.println("Goodbye!\n");
                break;
            }
            switch (numbers.length) {
                case 1:
                    oneNumber(inputLong);
                    break;
                case 2:
                    inputAmount = Long.parseLong(numbers[1]);
                    for(int i = 0; i < inputAmount; i++) {
                        twoNumbersOutput(inputLong + i);
                    }
                    break;
                default:
                    if (numbers.length > 10) {
                        System.out.println("Too much input!");
                        break;
                    }
                    props = propertiesArr(numbers, props);
                    int howManyBad = goodProperties(props);
                    if(howManyBad > 0) {
                        if(howManyBad == 1) {
                            System.out.print("The property [");
                            printBadProps(numbers, props);
                            System.out.println("] is wrong.");
                        } else {
                            System.out.print("The properties [");
                            printBadProps(numbers, props);
                            System.out.println("] are wrong.");
                        }
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                        break;
                    }
                    if(exclusiveProps(props)) {
                        System.out.println("There are no numbers with these properties.");
                        break;
                    }
                    inputAmount = Long.parseLong(numbers[1]);
                    for(int i = 0; inputAmount > 0; i++) {
                        if (ifNumberGood(inputLong + i, props)) {
                            twoNumbersOutput(inputLong + i);
                            inputAmount--;
                        }
                    }
                    break;
            }
        } while (inputLong != 0);
    }
}