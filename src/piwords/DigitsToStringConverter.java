package piwords;

public class DigitsToStringConverter {
    /**
     * Given a list of digits, a base, and a mapping of digits of that base to
     * chars, convert the list of digits into a character string by applying the
     * mapping to each digit in the input.
     * 
     * For example, let digits = {1,0,2,0}, base = 3, and alphabet = {'a','j','v'};
     * then covertDigitsToString returns "java".
     *
     * @param digits The array of digits to encode. This object is not mutated.
     * @param base The base the digits are encoded in. Must equal alphabet.length.
     *             Must be a valid numerical base.
     * @param alphabet An array mapping digits to chars; a digit d
     *                 will be represented in the output as the
     *                 character alphabet[d]. This object is not
     *                 mutated. Must be of length equal to base.
     * @return A String that encodes the input digits using the provided alphabet.
     * @throws IllegalArgumentException if any value in digits is not
     *            a valid digit in the given base, i.e. digits[i] < 0
     *            or digits[i] >= base.
     */
    public static String convertDigitsToString(int[] digits, int base,
                                               char[] alphabet) throws IllegalArgumentException {
        // TODO: Implement (Problem 3.b)
        throw new RuntimeException("not implemented");
    }
}
