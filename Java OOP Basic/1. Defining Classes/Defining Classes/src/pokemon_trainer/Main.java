package pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Pokemon>> pokemons = new LinkedHashMap<>();
        List<Trainer> trainers = new ArrayList<>();

        String line = reader.readLine();
        while (!"Tournament".equals(line)) {
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int healthPokemon = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, healthPokemon);
            if (!pokemons.containsKey(name)) {
                pokemons.put(name, new ArrayList<>());
            }
            pokemons.get(name).add(pokemon);
            line = reader.readLine();
        }


        for (Map.Entry<String, List<Pokemon>> entry : pokemons.entrySet()) {
            String trainerName = entry.getKey();
            List<Pokemon> pokemon = entry.getValue();
            Trainer trainer = new Trainer(trainerName, pokemon);
            trainers.add(trainer);
        }
        System.out.println();

        line = reader.readLine();
        while (!"End".equals(line)) {
            for (Trainer trainer : trainers) {
                if (trainer.isPokemonGetElement(line)) {
                    int badges = trainer.getNumberOfBadges() + 1;
                    trainer.setNumberOfBadges(badges);
                } else {
                    trainer.changedHealthOfPokemons();
                }
            }
            line = reader.readLine();
        }
        trainers.stream().sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges())).forEach(System.out::println);

    }
}
