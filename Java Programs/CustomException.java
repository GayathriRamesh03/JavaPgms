class MoreThanOneDigitException extends Exception {
    public MoreThanOneDigitException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        int number = 12; 
        try {
            checkNumber(number);
        } catch (MoreThanOneDigitException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void checkNumber(int number) throws MoreThanOneDigitException {
        if (Math.abs(number) > 9) {
            throw new MoreThanOneDigitException("The number " + number + " has more than one digit.");
        } else {
            System.out.println("The number " + number + " has one digit.");
        }
    }
}
