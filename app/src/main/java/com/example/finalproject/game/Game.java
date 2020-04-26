package com.example.finalproject.game;


import java.util.HashMap;

public class Game {
    private String player;

    public String getName() {
        return name;
    }

    private String name;

    public String getImageId() {
        return imageId;
    }

    private String imageId;

    public Game(String n, String imageId){
        this.name = n;
        this.imageId = imageId;
    }

    public static HashMap<String, Game> getGames() {
        HashMap<String, Game> gameList = new HashMap<>(

        );
        gameList.put("Math", new Game("Math", "https://cdn2.iconfinder.com/data/icons/the-joy-of-dark-pi-maths-game/100/Maths-2-11-512.png"));
        gameList.put("Vocab", new Game("Vocab", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR1UpMBGxb7SFMHUdSoVGInY6tsrz7xKH2Gk8tUhPzU1qyckzrO&usqp=CAU"));
        return gameList;
    }

    public String getPlayer() {
        return player;
    }
    public void setPlayer(String name) {
        this.player = name;
    }
}
