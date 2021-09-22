package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.factory.ActionFactoryImpl;
import app.factory.TargetFactory;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = new ConsoleReader();

        Writer writer = new ConsoleWriter();

        TargetableFactory targetableFactory = new TargetFactory();

        ActionFactory actionFactory = new ActionFactoryImpl();



        Battlefield battleField = new BattlefieldImplementation(writer, targetableFactory, actionFactory);



        Engine engine = new app.core.Engine(reader, writer, battleField);

        engine.run();

    }
}
