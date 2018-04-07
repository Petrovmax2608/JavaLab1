import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Num {

    private double value;
    private String dimension;
    private static Pattern pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)([а-яa-z]+)");

    Num(double value, String dimension) {
        this.value = value;
        this.dimension = dimension;
    }

    Num(String values) {
        Matcher matcher = pattern.matcher(values);
        if (matcher.find()) {
            this.value = Double.parseDouble(matcher.group(1));
            this.dimension = matcher.group(2);
        }
    }

    private void equalsDimension(Num other) {
        if (!this.dimension.equals(other.dimension)) throw new IllegalArgumentException("Invalid dimension");
    }

    public Num plus(Num other) {
        this.equalsDimension(other);
        return new Num(this.value + other.value, this.dimension);
    }

    public Num minus(Num other) {
        this.equalsDimension(other);
        return new Num(this.value - other.value, this.dimension);
    }

    public Num times(Num other) {
        this.equalsDimension(other);
        return new Num(this.value * other.value, this.dimension);
    }

    public Num times(double other) {
        return new Num(this.value * other, this.dimension);
    }

    public Num division(Num other) {
        this.equalsDimension(other);
        return new Num(this.value / other.value, this.dimension);
    }

    public Num division(double other) {
        return new Num(this.value / other, this.dimension);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num num = (Num) o;
        return Double.compare(num.value, value) == 0 &&
                Objects.equals(dimension, num.dimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, dimension);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value) + this.dimension;
    }

    public double getValue() {
        return value;
    }

    public String getDimension() {
        return dimension;
    }
}