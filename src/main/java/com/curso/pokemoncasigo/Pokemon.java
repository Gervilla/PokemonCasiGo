/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.pokemoncasigo;

import java.util.Random;

/**
 * Class that defines a Pokemon
 * @author pgervill
 */
public class Pokemon {
    private int number;
    private String name;
    private Type type;
    private int level;
    private int evolved;
    private float power;
    private boolean prepared;
    private int evolveTo;
    private boolean legendary;
    
    private Random r = new Random();
    /**
     * Constructor for the Pokemons.
     * @param number Pokemon number.
     * @param name Pokemon name.
     * @param type Pokemon type.
     */
    public Pokemon(int number, String name, Type type){
        this.number = number;
        this.name = name;
        this.type = type;
        this.legendary = false;
        this.evolveTo = 0;
        this.level = 1;
        this.evolved = 1;
        this.prepared = true;
        this.power = 1;
    }
    /**
     * Constructor for the Pokemons that can evolve to other.
     * @param number Pokemon number.
     * @param name Pokemon name.
     * @param type Pokemon type.
     * @param evolveTo Pokemon to evolve.
     */
    public Pokemon(int number, String name, Type type, int evolveTo){
        this(number, name, type);
        this.evolveTo = evolveTo;
    }
    /**
     * Constructor for the legendary Pokemons.
     * @param number Pokemon number.
     * @param name Pokemon name.
     * @param type Pokemon type.
     * @param legendary true for set the Pokemon legendary.
     */
    public Pokemon(int number, String name, Type type, boolean legendary){
        this(number, name, type);
        this.legendary = legendary;
        this.power *= 2;
    }
    /**
     * Copy constructor for a Pokemon.
     * @param p Pokemon to copy.
     */
    public Pokemon(Pokemon p){
        this.number = p.number;
        this.name = p.name;
        this.type = p.type;
        this.level = p.level;
        this.power = p.power;
        this.prepared = p.prepared;
        this.evolveTo = p.evolveTo;
        this.evolved = p.evolved;
        this.legendary = p.legendary;
    }
    /**
     * Increases the level in one and the power in one and a bit. 
     * @return this Pokemon.
     */
    public Pokemon train(){
        ++level;
        power += 1 + r.nextFloat();
        return this;
    }
    /**
     * Fight with another Pokemon.
     * @param challenger Pokemon
     * @return 
     */
    public boolean fight(Pokemon challenger){
        boolean win = false;
        float myPower = this.power;
        float challengerPower = challenger.power;
        
        int p = checkTypeAdvantage(this.type, challenger.type);
        int c = checkTypeAdvantage(challenger.type, this.type);
        int advantage = checkTypeAdvantage(this.type, challenger.type) - checkTypeAdvantage(challenger.type, this.type);
        System.out.println(p+", "+c+" = "+advantage);
        //Multiply the power according to his type advantage
        if(advantage < 0){
            challengerPower *= 1.5*Math.abs(advantage);
        }else if(advantage > 0)
            myPower *= 1.5*Math.abs(advantage);
        //Add a random increment to their powers   
        myPower += r.nextFloat(power/2);
        challengerPower += r.nextFloat(power/2);
        //LETS FIGHT!!!
        if (myPower >= challengerPower){
            win = true;
            level += 2;
            power += 2 + r.nextFloat(2);
        }
        return win;
    }
    /**
     * Check if this Pokemon can evolve.
     * @return if this Pokemon can evolve.
     */
    public boolean canEvolve(){
        boolean canEvolve = false;
        if(evolveTo > 0){
            if(level/(15*evolved) == 1)
                canEvolve = true;
        }
        return canEvolve;
    }
    /**
     * Evolve this Pokemon to his next evolution.
     * @param evolution Pokemon to evolve.
     * @return this Pokemon Evolved.
     */
    public Pokemon evolve(Pokemon evolution){
        this.number = evolution.number;
        this.name = evolution.name;
        this.power += 2 + r.nextFloat();
        this.evolveTo = evolution.evolveTo;
        this.evolved++;
        return this;
    }
    /**
     * Check the advantage between types.
     * @param a type of the first pokemon.
     * @param b type of the second Pokemon.
     * @return the advantage of the a type opposite the type b.
     */
    public int checkTypeAdvantage(Type a, Type b){
        int winnerType = 0;//1= a advantage, -1= b advantage, 0= nothing.
        switch (a){
            case NORMAL -> { 
                //Strong Against: none
                if(b == Type.FIGHTING)
                    winnerType = -1;
            }
            case ROCK -> {
                if(b == Type.ICE || b == Type.BUG || b == Type.FIRE || b == Type.FLYING)
                    winnerType = 1;
                else if(b == Type.FIGHTING || b == Type.GROUND || b == Type.WATER || b == Type.GRASS)
                    winnerType = -1;
            }
            case WATER -> {
                if(b == Type.GROUND || b == Type.ROCK || b == Type.FIRE)
                    winnerType = 1;
                else if(b == Type.GRASS || b == Type.ELECTRIC)
                    winnerType = -1;
            }
            case ELECTRIC -> {
                if(b == Type.WATER || b == Type.FLYING)
                    winnerType = 1;
                else if(b == Type.GROUND)
                    winnerType = -1;
            }
            case BUG -> {
                if(b == Type.GRASS || b == Type.PSYCHIC)
                    winnerType = 1;
                else if(b == Type.FLYING || b == Type.ROCK || b == Type.FIRE)
                    winnerType = -1;
            }
            case DRAGON -> {
                //Strong Against: Dragon
                if(b == Type.DRAGON || b == Type.ICE)
                    winnerType = -1;
            }
            case FIGHTING -> {
                if(b == Type.NORMAL || b == Type.ROCK || b == Type.ICE)
                    winnerType = 1;
                else if(b == Type.FLYING || b == Type.PSYCHIC)
                    winnerType = -1;
            }
            case FIRE -> {
                if(b == Type.BUG || b == Type.GRASS || b == Type.ICE)
                    winnerType = 1;
                else if(b == Type.GROUND || b == Type.ROCK || b == Type.WATER)
                    winnerType = -1;
            }
            case FLYING -> {
                if(b == Type.FIGHTING || b == Type.BUG || b == Type.GRASS)
                    winnerType = 1;
                else if(b == Type.ROCK || b == Type.ELECTRIC || b == Type.ICE)
                    winnerType = -1;
            }
            case GHOST -> {
                if(b == Type.GHOST || b == Type.PSYCHIC)
                    winnerType = 1;
                //Vulnerable To: Ghost
            }
            case GRASS -> {
                if(b == Type.GROUND || b == Type.ROCK || b == Type.WATER)
                    winnerType = 1;
                else if(b == Type.FLYING || b == Type.POISON || b == Type.BUG || b == Type.FIRE || b == Type.ICE)
                    winnerType = -1;
            }
            case GROUND -> {
                if(b == Type.ROCK || b == Type.POISON || b == Type.ELECTRIC || b == Type.FIRE)
                    winnerType = 1;
                else if(b == Type.ICE || b == Type.GRASS || b == Type.WATER)
                    winnerType = -1;
            }
            case ICE -> {
                if(b == Type.NORMAL || b == Type.ROCK || b == Type.ICE)
                    winnerType = 1;
                else if(b == Type.FLYING || b == Type.PSYCHIC)
                    winnerType = -1;
            }
            case POISON -> {
                if(b == Type.GRASS)
                    winnerType = 1;
                else if(b == Type.GROUND || b == Type.PSYCHIC)
                    winnerType = -1;
            }
            case PSYCHIC -> {
                if(b == Type.FIGHTING || b == Type.POISON)
                    winnerType = 1;
                else if(b == Type.BUG || b == Type.GHOST)
                    winnerType = -1;
            }
        }
        return winnerType;
    }
    /**
     * Set the level 
     * @param level 
     */
    public void setLevelPower(int level){
        this.level = level;
        this.power = level + r.nextFloat(level);
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumber(){
        return number;
    }
    
    public Type getType(){
        return type;
    }
    
    public int getNextEvolution(){
        return evolveTo;
    }
    
    public boolean isLegendary(){
        return legendary;
    }
    
    public void batter(){
        prepared = false;
    }
    
    public boolean isPrepared(){
        return prepared;
    }
    
    public void prepare(){
        prepared = true;
    }
    
    public int getLevel(){
        return level;
    }
    
    public float getPower(){
        return power;
    }
    
    @Override
    public String toString(){
        String m = "\n-----------------------------------------------\n"
                +"* "+number+"\t Nombre: "+name;
        if (!prepared)
            m += "\tApaleado";
        m += "\n*\t Tipo: "+type+"\n"
                + "*\t Nivel: "+level+"\t Fuerza: "+power+"\n";
                if(legendary)
                    m += "* LEGENDARY\n";
                m += "-----------------------------------------------";
        return m;
    }
}
