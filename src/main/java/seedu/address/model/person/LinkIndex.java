package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Internship's unique id in the address book to be linked.
 * Guarantees: immutable; is valid as declared in {@link #isValidId(String)} (String)}
 */
public class LinkIndex {
    public static final String MESSAGE_CONSTRAINTS =
            "Link Index must be a non-negative number, and it should not be blank";

    public final Integer index;

    /**
     * Constructs a {@code LinkIndex}.
     * Takes a string index and parses it into an Integer.
     *
     * @param index A valid index.
     */
    public LinkIndex(String index) {
        requireNonNull(index);
        checkArgument(isValidId(index), MESSAGE_CONSTRAINTS);
        this.index = Integer.parseInt(index);
    }

    /**
     * Constructs a {@code LinkIndex}.
     *
     * @param index A valid index.
     */
    public LinkIndex(Integer index) {
        requireNonNull(index);
        checkArgument(isValidId(index), MESSAGE_CONSTRAINTS);
        this.index = index;
    }

    /**
     * Returns true if the given String can be parsed into an Integer and is non-negative.
     */
    public static boolean isValidId(String test) {
        try {
            return isValidId(Integer.parseInt(test));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidId(Integer test) {
        return test >= 0;
    }

    @Override
    public String toString() {
        return index.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof LinkIndex // instanceof handles nulls
                && index.equals(((LinkIndex) other).index)); // state check
    }

    @Override
    public int hashCode() {
        return index.hashCode();
    }
}
