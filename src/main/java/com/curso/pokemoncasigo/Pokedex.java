/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.pokemoncasigo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author pgervill
 */
public class Pokedex {
    
    private static Pokedex pokedex;
    private ArrayList<Pokemon> list = new ArrayList<>();
    
    private Random r = new Random();
    private HashSet<Pokemon> collection = new HashSet<>();
    
    private Pokedex(){
        list.add(new Pokemon(1, "Bulbasaur", Type.GRASS, 2));
        list.add(new Pokemon(2, "Ivysaur", Type.GRASS, 3));
        list.add(new Pokemon(3, "Venusaur", Type.GRASS));
        
        list.add(new Pokemon(4, "Charmander", Type.FIRE, 5));
        list.add(new Pokemon(5, "Charmeleon", Type.FIRE, 6));
        list.add(new Pokemon(6, "Charizard", Type.FIRE));
        
        list.add(new Pokemon(7, "Squirtle", Type.WATER, 8));
        list.add(new Pokemon(8, "Wartortle", Type.WATER, 9));
        list.add(new Pokemon(9, "Blastoise", Type.WATER));
        
        list.add(new Pokemon(10, "Caterpie", Type.BUG, 11));
        list.add(new Pokemon(11, "Metapod", Type.BUG, 12));
        list.add(new Pokemon(12, "Butterfree", Type.BUG));
        
        list.add(new Pokemon(13, "Weedle", Type.BUG, 14));
        list.add(new Pokemon(14, "Kakuna", Type.BUG, 15));
        list.add(new Pokemon(15, "Beedrill", Type.BUG));
        
        list.add(new Pokemon(16, "Pidgey", Type.FLYING, 17));
        list.add(new Pokemon(17, "Pidgeotto", Type.FLYING, 18));
        list.add(new Pokemon(18, "Pidgeot", Type.FLYING));
        
        list.add(new Pokemon(19, "Rattata", Type.NORMAL, 20));
        list.add(new Pokemon(20, "Raticate", Type.NORMAL));
        
        list.add(new Pokemon(21, "Spearow", Type.FLYING, 22));
        list.add(new Pokemon(22, "Fearow", Type.FLYING));
        
        list.add(new Pokemon(23, "Ekans", Type.POISON, 24));
        list.add(new Pokemon(24, "Arbok", Type.POISON));
        
        list.add(new Pokemon(25, "Pikachu", Type.ELECTRIC, 26));
        list.add(new Pokemon(26, "Raichu", Type.ELECTRIC));
        
        list.add(new Pokemon(27, "Sandshrew", Type.GROUND, 28));
        list.add(new Pokemon(28, "Sandslash", Type.GROUND));
        
        list.add(new Pokemon(29, "Nidoran♀", Type.POISON, 30));
        list.add(new Pokemon(30, "Nidorina", Type.POISON, 31));
        list.add(new Pokemon(31, "Nidoqueen", Type.POISON));
        
        list.add(new Pokemon(32, "Nidoran♂", Type.POISON, 33));
        list.add(new Pokemon(33, "Nidorino", Type.POISON, 34));
        list.add(new Pokemon(34, "Nidoking", Type.POISON));
        
        list.add(new Pokemon(35, "Clefairy", Type.NORMAL, 36));
        list.add(new Pokemon(36, "Clefable", Type.NORMAL));
        
        list.add(new Pokemon(37, "Vulpix", Type.FIRE, 38));
        list.add(new Pokemon(38, "Ninetales", Type.FIRE));
        
        list.add(new Pokemon(39, "Jigglypuff", Type.NORMAL, 40));
        list.add(new Pokemon(40, "Wigglytuff", Type.NORMAL));
        
        list.add(new Pokemon(41, "Zubat", Type.FLYING, 42));
        list.add(new Pokemon(42, "Golbat", Type.FLYING));
        
        list.add(new Pokemon(43, "Oddish", Type.GRASS, 44));
        list.add(new Pokemon(44, "Gloom", Type.GRASS, 45));
        list.add(new Pokemon(45, "Vileplume", Type.GRASS));
        
        list.add(new Pokemon(46, "Paras", Type.BUG, 47));
        list.add(new Pokemon(47, "Parasect", Type.BUG));
        
        list.add(new Pokemon(48, "Venonat", Type.BUG, 49));
        list.add(new Pokemon(49, "Venomoth", Type.BUG));
        
        list.add(new Pokemon(50, "Diglett", Type.GROUND, 51));
        list.add(new Pokemon(51, "Dugtrio", Type.GROUND));
        
        list.add(new Pokemon(52, "Meowth", Type.NORMAL, 53));
        list.add(new Pokemon(53, "Persian", Type.NORMAL));
        
        list.add(new Pokemon(54, "Psyduck", Type.WATER, 55));
        list.add(new Pokemon(55, "Golduck", Type.WATER));
        
        list.add(new Pokemon(56, "Mankey", Type.FIGHTING, 57));
        list.add(new Pokemon(57, "Primeape", Type.FIGHTING));
        
        list.add(new Pokemon(58, "Growlithe", Type.FIRE, 59));
        list.add(new Pokemon(59, "Arcanine", Type.FIRE));
        
        list.add(new Pokemon(60, "Poliwag", Type.WATER, 61));
        list.add(new Pokemon(61, "Poliwhirl", Type.WATER, 62));
        list.add(new Pokemon(62, "Poliwrath", Type.WATER));
        
        list.add(new Pokemon(63, "Abra", Type.PSYCHIC, 64));
        list.add(new Pokemon(64, "Kadabra", Type.PSYCHIC, 65));
        list.add(new Pokemon(65, "Alakazam", Type.PSYCHIC));
        
        list.add(new Pokemon(66, "Machop", Type.FIGHTING, 67));
        list.add(new Pokemon(67, "Machoke", Type.FIGHTING, 68));
        list.add(new Pokemon(68, "Machamp", Type.FIGHTING));
        
        list.add(new Pokemon(69, "Bellsprout", Type.GRASS, 70));
        list.add(new Pokemon(70, "Weepinbell", Type.GRASS, 71));
        list.add(new Pokemon(71, "Victreebel", Type.GRASS));
        
        list.add(new Pokemon(72, "Tentacool", Type.WATER, 73));
        list.add(new Pokemon(73, "Tentacruel", Type.WATER));
        
        list.add(new Pokemon(74, "Geodude", Type.ROCK, 75));
        list.add(new Pokemon(75, "Graveler", Type.ROCK, 76));
        list.add(new Pokemon(76, "Golem", Type.ROCK));
        
        list.add(new Pokemon(77, "Ponyta", Type.FIRE, 78));
        list.add(new Pokemon(78, "Rapidash", Type.FIRE));
        
        list.add(new Pokemon(79, "Slowpoke", Type.WATER, 80));
        list.add(new Pokemon(80, "Slowbro", Type.WATER));
        
        list.add(new Pokemon(81, "Magnemite", Type.ELECTRIC, 82));
        list.add(new Pokemon(82, "Magneton", Type.ELECTRIC));
        
        list.add(new Pokemon(83, "Farfetch’d", Type.FLYING));
        
        list.add(new Pokemon(84, "Doduo", Type.FLYING, 85));
        list.add(new Pokemon(85, "Dodrio", Type.FLYING, 152));
        
        list.add(new Pokemon(86, "Seel", Type.WATER, 87));
        list.add(new Pokemon(87, "Dewgong", Type.WATER));
        
        list.add(new Pokemon(88, "Grimer", Type.POISON, 89));
        list.add(new Pokemon(89, "Muk", Type.POISON));
        
        list.add(new Pokemon(90, "Shellder", Type.WATER, 91));
        list.add(new Pokemon(91, "Cloyster", Type.WATER));
        
        list.add(new Pokemon(92, "Gastly", Type.GHOST, 93));
        list.add(new Pokemon(93, "Haunter", Type.GHOST, 94));
        list.add(new Pokemon(94, "Gengar", Type.GHOST));
        
        list.add(new Pokemon(95, "Onix", Type.ROCK));
        
        list.add(new Pokemon(96, "Drowzee", Type.PSYCHIC, 97));
        list.add(new Pokemon(97, "Hypno", Type.PSYCHIC));
        
        list.add(new Pokemon(98, "Krabby", Type.WATER, 99));
        list.add(new Pokemon(99, "Kingler", Type.WATER));
        
        list.add(new Pokemon(100, "Voltorb", Type.ELECTRIC, 101));
        list.add(new Pokemon(101, "Electrode", Type.ELECTRIC));
        
        list.add(new Pokemon(102, "Exeggcute", Type.GRASS, 103));
        list.add(new Pokemon(103, "Exeggutor", Type.GRASS));
        
        list.add(new Pokemon(104, "Cubone", Type.GROUND, 105));
        list.add(new Pokemon(105, "Marowak", Type.GROUND));
        
        list.add(new Pokemon(106, "Hitmonlee", Type.FIGHTING, 107));
        list.add(new Pokemon(107, "Hitmonchan", Type.FIGHTING));
        
        list.add(new Pokemon(108, "Lickitung", Type.NORMAL));
        
        list.add(new Pokemon(109, "Koffing", Type.POISON, 110));
        list.add(new Pokemon(110, "Weezing", Type.POISON));
        
        list.add(new Pokemon(111, "Rhyhorn", Type.ROCK, 112));
        list.add(new Pokemon(112, "Rhydon", Type.ROCK));
        
        list.add(new Pokemon(113, "Chansey", Type.NORMAL));
        
        list.add(new Pokemon(114, "Tangela", Type.GRASS));
        
        list.add(new Pokemon(115, "Kangaskhan", Type.NORMAL));
        
        list.add(new Pokemon(116, "Horsea", Type.WATER, 117));
        list.add(new Pokemon(117, "Seadra", Type.WATER));
        
        list.add(new Pokemon(118, "Goldeen", Type.WATER, 119));
        list.add(new Pokemon(119, "Seaking", Type.WATER));
        
        list.add(new Pokemon(120, "Staryu", Type.WATER, 121));
        list.add(new Pokemon(121, "Starmie", Type.WATER));
        
        list.add(new Pokemon(122, "Mr. Mime", Type.PSYCHIC));
        
        list.add(new Pokemon(123, "Scyther", Type.WATER));
        
        list.add(new Pokemon(124, "Jynx", Type.PSYCHIC));
        
        list.add(new Pokemon(125, "Electabuzz", Type.ELECTRIC));
        
        list.add(new Pokemon(126, "Magmar", Type.FIRE));
        
        list.add(new Pokemon(127, "Pinsir", Type.BUG));
        
        list.add(new Pokemon(128, "Tauros", Type.NORMAL));
        
        list.add(new Pokemon(129, "Magikarp", Type.WATER, 130));
        list.add(new Pokemon(130, "Gyarados", Type.WATER));
        
        list.add(new Pokemon(131, "Lapras", Type.WATER));
        
        list.add(new Pokemon(132, "Ditto", Type.NORMAL));
        
        list.add(new Pokemon(133, "Eevee", Type.NORMAL, 134));
        list.add(new Pokemon(134, "Vaporeon", Type.WATER));
        list.add(new Pokemon(135, "Jolteon", Type.ELECTRIC));
        list.add(new Pokemon(136, "Flareon", Type.FIRE));
        
        list.add(new Pokemon(137, "Porygon", Type.NORMAL));
        
        list.add(new Pokemon(138, "Omanyte", Type.ROCK, 139));
        list.add(new Pokemon(139, "Omastar", Type.ROCK));
        
        list.add(new Pokemon(140, "Kabuto", Type.ROCK, 141));
        list.add(new Pokemon(141, "Kabutops", Type.ROCK));
        
        list.add(new Pokemon(142, "Aerodactyl", Type.FLYING));
        
        list.add(new Pokemon(143, "Snorlax", Type.NORMAL));
        
        list.add(new Pokemon(144, "Articuno", Type.ICE, true));
        list.add(new Pokemon(145, "Zapdos", Type.ELECTRIC, true));
        list.add(new Pokemon(146, "Moltres", Type.FIRE, true));
        
        list.add(new Pokemon(147, "Dratini", Type.DRAGON, 148));
        list.add(new Pokemon(148, "Dragonair", Type.DRAGON, 149));
        list.add(new Pokemon(149, "Dragonite", Type.DRAGON));
        
        list.add(new Pokemon(150, "Mewtwo", Type.PSYCHIC, true));
        list.add(new Pokemon(151, "Mew", Type.PSYCHIC, true));
        
        list.add(new Pokemon(152, "Doquatrio", Type.FLYING, 153));
        list.add(new Pokemon(153, "Doquintrio", Type.FLYING, 154));
        list.add(new Pokemon(154, "Dohydra", Type.FLYING));
        list.add(new Pokemon(155, "Caballo Anatomicamente Perfecto", Type.DRAGON, true));
    }
    /**
     * Get the instance of the Pokedex Singleton.
     * @return The instance of Pokedex.
     */
    public static Pokedex getPokedexInstance() {
        if (pokedex == null)
            pokedex = new Pokedex();
        else
            System.out.println("No puedes tener mas de una Pokedex, avaricioso");
        return pokedex;
    }
    /**
     * Return a copy of a Pokemon according to his number.
     * @param number of the Pokemon in the pokedex.
     * @param level level for the new Pokemon.
     * @return that Pokemon.
     */
    public Pokemon getPokemon(int number, int level){
        Pokemon pokemon = new Pokemon(list.get(number-1));
        pokemon.setLevelPower(r.nextInt(1,(level+level/2) +1));
        return pokemon;
    }
    /**
     * Return a random copy of a Pokemon.
     * @param level level for the new Pokemon.
     * @return a random Pokemon.
     */
    public Pokemon getRandomPokemon(int level){
        return getPokemon(r.nextInt(1, 156), level);
    }
    
    public boolean newSpottedPokemon(Pokemon newPokemon){
        return collection.add(newPokemon);
    }
    
    public boolean youWin(){
        return collection.size() == list.size();
    }
    
    @Override
    public String toString(){
        String lista = "";
        for (Pokemon p: collection){
            lista += p.getNumber()+": "+p.getName()+"\t"+p.getType()+"\n";
        }
        return lista;
    }
}
