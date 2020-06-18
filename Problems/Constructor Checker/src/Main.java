import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Check whether the class declares public parameterless constructor
 */
class ConstructorChecker {

    public boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        // Add implementation here
        return Arrays.stream(clazz.getDeclaredConstructors())
                .anyMatch(constructor -> constructor.getParameterCount() == 0
                        && Modifier.isPublic(constructor.getModifiers()));
    }

}