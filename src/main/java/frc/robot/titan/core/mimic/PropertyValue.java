package frc.robot.titan.core.mimic;

public interface PropertyValue<R> {
    public PropertyType getType();

    public Object get(final R robot);
}
