/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.pokemoncasigo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pgervill
 */
public class PokemonCasiGo {

    static Pokedex pokedex = Pokedex.getPokedexInstance();
    static ArrayList<Pokemon> team = new ArrayList<>();
    static Pokemon teammate;
    static Pokemon challenger;
    static String UI;
    static boolean keepPlaying = true;
    static String playerText;
    static int playerNumber;
    static Scanner scanner = new Scanner (System.in);
    static Random r = new Random();
    
    public static void main(String[] args) {
        
        //Inicio (escoger pokemon)
        UI="""
           ¡Hola!
           Soy El profesor Benemérito, estudioso de los Pokemons y graduado en el master de Pokemonologia avanzada.
           Antes de embarcarte en tu innecesaria aventura de violencia animal, necesitas tu propio Pokemon.
           ¡Elige sabiamente!:
                * 1: Bulbasaur
                * 2: Charmander
                * 3: Squirtle
                * 4: LA CAJA""";
        
        System.out.println(UI);
        playerNumber = scanner.nextInt();
        while(playerNumber < 1 || playerNumber > 4){
            playerNumber = scanner.nextInt();
            System.out.println("eeeh, ¿Que?");
        }
        scanner.nextLine();//This catch the \n of the previous scanner.nextInt.
        
        if(playerNumber == 4)
            teammate = pokedex.getRandomPokemon(1);
        else
            teammate = pokedex.getPokemon(playerNumber*3-2, 1);//Get initials Pokemons, 1 -> 1, 2 -> 4, 3 -> 7.
        pokedex.newSpottedPokemon(teammate);
        
        System.out.println("Tu Pokemon es:");
        System.out.println(teammate);
        team.add(teammate);
        System.out.println("¡Que comience tu aventura!");
        
        while(keepPlaying){
            UI="""
            ******************************
            *¿Que quieres hacer?:        *
            *     º 1: Explorar          *
            *     º 2: Entrenar          *
            *     º 3: Estado            *
            *     º 4: Gestionar Equipo  *
            *     º 5: Consultar Pokedex *
            *     º 6: Salir             *
            ******************************""";
            System.out.println(UI);
            
            playerNumber = scanner.nextInt();
            scanner.nextLine();//This catch the \n of the previous scanner.nextInt.
            switch(playerNumber){
                case 1:
                    if(teammate.isPrepared())
                        explore();
                    else
                        System.out.println("Tu pokemon esta en la chusta, no esta como para salir de paseo a pegar palizas."
                                + "\nCambia de Pokemon antes de salir a explorar o curalo.");
                    break;
                case 2:
                    if(teammate.isPrepared()){
                        System.out.println("Tu Pokemon se ha hecho unas dominadas y ahora esta mamadisimo.");
                        System.out.println(teammate.train());
                        checkEvolution();
                    }else
                        System.out.println("Como que no le apetece entrenar a tu Pokemon con la de leches que lleva encima."
                                + "\nCambia de pokemon antes o curalo.");
                    break;
                case 3:
                    System.out.println(teammate);
                    if(!teammate.isPrepared()){
                        System.out.println("¿Tu pokemon esta malito, quieres curarlo?");
                        System.out.println("Si, No");
                        playerText = scanner.nextLine();
                        if("si".equals(playerText.toLowerCase())){
                            teammate.prepare();
                            System.out.println(teammate.getName()+" se ha tomado unos Pokeparacetamoles y ahora esta fresco como una lechuga.");
                        }
                    }
                    break;
                case 4:
                    manageTeam();
                    break;
                case 5:
                    System.out.println(pokedex);
                    break;
                case 6:
                    keepPlaying = false;
                    break;
            }
            if (pokedex.youWin()){
                keepPlaying = false;
                System.out.println("¡WOW! Por alguna razon que no entiendo, has jugado lo suficiente como para completar la pokedex de los Pokemons avistados.\n"
                        + "¿Enhorabuena?");
            }
        }
    }
    
    public static void explore(){
        System.out.println("¡VAMONOS DE AVENTURA!");
        challenger = pokedex.getRandomPokemon(teammate.getLevel());
        System.out.print("Ha aparecido");
        if (pokedex.newSpottedPokemon(challenger))
            System.out.print(" por primera vez");
        System.out.println(" un "+challenger.getName()+" salvaje, ¿Quieres inflarlo a palos?");
        System.out.println(challenger+"\nVS\n"+teammate.getName()+"\tTipo: "+teammate.getType()+"\tNivel: "+teammate.getLevel()+"\tFuerza: "+teammate.getPower());
        System.out.println("Si, No");
        playerText = scanner.nextLine();
        
        if("si".equals(playerText.toLowerCase())){
            if(teammate.fight(challenger)){
                challenger.batter();
                System.out.println("Tu pokemon ha pisoteado hasta la hunillación a "+challenger.getName()+" y ha subido de nivel");
                capture();
                checkEvolution();
            }else{
                teammate.batter();
                System.out.println("Has perdido, "+challenger.getName()+" te ha cagado a piñas y tu poquemon esta moribundo.");
            }   
        }   
    }
    
    public static void checkEvolution(){
        if (teammate.canEvolve()){
            System.out.print("¡"+teammate.getName());
            if (teammate.getNumber() == 133)
                teammate.evolve(pokedex.getPokemon(r.nextInt(3) + teammate.getNextEvolution(), 1));
            else
                teammate.evolve(pokedex.getPokemon(teammate.getNextEvolution(), 1));
            System.out.println(" ha evolucionado a "+teammate.getName()+"!");
        }
    }
    
    public static void capture(){
        int captureProbability = 2;
        if(challenger.isLegendary()){
            System.out.println("Ahora que "+challenger.getName()+" esta en la mierda, puedes INTENTAR capturarlo.\n"
                    + "(Es legendario, no te emociones mucho"+"\n¿Capturar?\tSi, No");
            captureProbability = 5;
        }else
            System.out.println("Ahora que "+challenger.getName()+" esta en la mierda, puedes capturarlo.");
        
        System.out.println("Si, No");
        playerText = scanner.nextLine();
        if ("si".equals(playerText.toLowerCase())){
            if (r.nextInt(captureProbability) == 1){
                team.add(challenger);
                System.out.println("¡ENHORABUENA! Has capturado a "+challenger.getName()+
                        ", ahora forma parte de tu equipo. (Pero sigue apaleado)");
            }else
                System.out.println("Mala suerte, "+challenger.getName()+" ha escapado arrastrandose de esa prisión esférica a la que llamas Pokeball.");
        }
    }
    
    public static void manageTeam(){
        for(Pokemon p: team){
            if (teammate == p)
                System.out.print(p.toString().replaceFirst("--------", "EQUIPADO"));
            else
                System.out.print(p.toString());
        }
        System.out.println("");
        if(team.size() > 1){
            System.out.println("¿Quieres cambiar de compañero pokemon?:\nEscribe su numero para elegirlo o 0 para no cambiar.");
            playerNumber = scanner.nextInt();
            scanner.nextLine();//This catch the \n of the previous scanner.nextInt.

            if(playerNumber > 0 && playerNumber < 156){
                Optional<Pokemon> newTeammate = team.stream().filter(obj -> obj.getNumber() == playerNumber).findFirst();
                if(newTeammate.isPresent()){
                    teammate = newTeammate.get(); 
                    System.out.println("Ahora "+teammate.getName()+" es tu nuevo compitrueno.");
                }    
            }
        }else
            System.out.println("Solo tienes un Pokemon, no puedes hacer mas que mirarlo con desprecio.");
    }
    
}
