package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        return Arrays.stream(Data.baseTownsArray)
                .map(s -> s.replaceAll("\\s", ""))
                .map(s -> s.split(DATA_SEPARATOR))
                .map(townAttr -> new Town(townAttr[0], new ArrayList<String>(Arrays.asList(townAttr[1], townAttr[2]))))
                .toList();
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        return Arrays.stream(Data.dlcTownsArray)
                .map(s -> s.replaceAll("\\s", ""))
                .map(s -> s.split(DATA_SEPARATOR))
                .map(townAttr -> new Town(townAttr[0], new ArrayList<String>(Arrays.asList(townAttr[1], townAttr[2]))))
                .toList();
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        return Arrays.stream(Data.baseCharactersArray)
                .map(s -> s.replaceAll("\\s", ""))
                .map(s -> s.split(DATA_SEPARATOR))
                .map(heroAttr -> new Hero(heroAttr[0], heroAttr[1])).distinct().collect(Collectors.toSet());
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        return Arrays.stream(Data.dlcCharactersArray)
                .map(s -> s.replaceAll("\\s", ""))
                .map(s -> s.split(DATA_SEPARATOR)).
                map(heroAttr -> new Hero(heroAttr[0], heroAttr[1])).collect(Collectors.toSet());
    }
}
