package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person() {
        this.company = new Company();
        this.car = new Car();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChildren(Children children) {
        this.children.add(children);
    }

    public void addPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company: ").append(System.lineSeparator())
                .append(this.company.toString())
                .append("Car: ").append(System.lineSeparator())
                .append(this.car.toString())
                .append("Pokemon: ").append(System.lineSeparator());
        if (this.pokemons.size() > 0) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }
        sb.append("Parents: ").append(System.lineSeparator());
        if (this.parents.size() > 0) {
            for (Parent parent : parents) {
                sb.append(parent.toString());
            }
        }
        sb.append("Children: ").append(System.lineSeparator());
        if (this.children.size() > 0) {
            for (Children children : children) {
                sb.append(children.toString());
            }
        }
        return sb.toString();
    }
}

