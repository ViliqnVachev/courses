package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.InvocationTargetException;

public class TargetFactory implements TargetableFactory {
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clzz = Class.forName("app.models.participants.heroes." + className);
        return (Targetable) clzz.getConstructor(String.class).newInstance(name);
    }
}
