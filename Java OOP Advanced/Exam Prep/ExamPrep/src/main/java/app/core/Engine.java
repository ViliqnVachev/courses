package app.core;

import app.contracts.Battlefield;
import app.contracts.Reader;
import app.contracts.Writer;

import java.io.IOException;

import java.util.Arrays;

public class Engine implements app.contracts.Engine {
    private Reader reader;
    private Writer writer;
    private Battlefield battleField;


    public Engine(Reader reader, Writer writer, Battlefield battleField) {
        this.reader = reader;
        this.writer = writer;
        this.battleField = battleField;
    }

    @Override
    public void run() throws IOException {
        for (String line = this.reader.readLine(); !line.equals("Peace"); line = this.reader.readLine()) {
            String[] lineTokens = line.split("\\s+");

           switch (lineTokens[0].toLowerCase()) {
                case "createparticipant":
                    this.battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;

                case "createaction":
                    this.battleField.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;

                case "statparticipants":
                    this.battleField.reportParticipants();
                    break;

                case "statactions":
                    this.battleField.reportActions();
                    break;

                case "createspecial":
                   this.battleField.createSpecial(lineTokens[1], lineTokens[2]);
                    break;

                default:
                    this.writer.writeLine("Invalid command");
                    break;
            }
        }
    }
}
