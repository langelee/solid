package solid.converters;

import java.util.List;

import solid.functions.SolidFunc1;
import solid.stream.Copy;

public class ToPrimitiveDoubleArray implements SolidFunc1<Iterable<Double>, double[]> {

    private static final SolidFunc1<Iterable<Double>, double[]> TO_PRIMITIVE_DOUBLE_ARRAY = new ToPrimitiveDoubleArray();

    /**
     * Returns a method that can be used with {@link solid.stream.Stream#collect(SolidFunc1)}
     * to convert an iterable stream of {@link Double} type into a primitive double[] array.
     *
     * @return a method that converts an iterable stream of {@link Double} type into a primitive double[] array.
     */
    public static SolidFunc1<Iterable<Double>, double[]> toPrimitiveDoubleArray() {
        return TO_PRIMITIVE_DOUBLE_ARRAY;
    }

    @Override
    public double[] call(Iterable<Double> value) {
        List<Double> objects = new Copy<>(value).collect(ToList.<Double>toList());
        double[] primitives = new double[objects.size()];
        int i = 0;
        for (Double object : objects)
            primitives[i++] = object;
        return primitives;
    }
}
