package edu.hw2.Task3;

public class Main {
    public static void main(String[] args) {
        var PCM = new PopularCommandExecutor(new FaultyConnectionManager(2), 1);
        try{
            PCM.updatePackages();
        }catch(Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}
