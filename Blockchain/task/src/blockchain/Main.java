package blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must starts with: ");
        int n = scanner.nextInt();


        Blockchain blockchain = new Blockchain();

        for (int i = 0; i < 5; i++) {
            blockchain.addBlock(n);
        }

        for (Blockchain.Block block : blockchain.getBlocks()) {
            System.out.println(block);
            System.out.println();
        }
    }
}

class Blockchain {

    private List<Block> blocks;
    private Block lastBlock;
    int currentId = 0;

    public List<Block> getBlocks() {
        return blocks;
    }

    public Blockchain() {
        blocks = new ArrayList<>();
    }

    public void addBlock(int zerosAmount) {

        Block block = new Block(++currentId, getHashOfLast(), zerosAmount);
        lastBlock = block;
        blocks.add(block);
    }

    public String getHashOfLast() {
        if (lastBlock == null) {
            return "0";
        } else {
            return lastBlock.hash;
        }
    }

    public boolean validate() {

        if (blocks.size() <= 1) {
            return true;
        }

        for (int i = 1; i < blocks.size(); i++) {
            if (blocks.get(i).hashOfPrevious != blocks.get(i - 1).hash) {
                return false;
            }
        }
        return true;
    }


    class Block {
        private int id;
        private long timeStamp = new Date().getTime();
        private String hashOfPrevious;
        private String hash;
        private int magicNumber;
        private int generatingTime;

        public Block(int id, String hashOfPrevious, int zerosAmount) {
            this.id = id;
            this.hashOfPrevious = hashOfPrevious;
            String prefix = "0".repeat(zerosAmount);
            do {
                magicNumber = (int) (Math.random() * Integer.MAX_VALUE);
                hash = StringUtil.applySha256("" + id + timeStamp + hashOfPrevious + magicNumber);

            } while (!hash.startsWith(prefix));
            generatingTime = (int) (new Date().getTime() - timeStamp) / 1000;
        }

        @Override
        public String toString() {
            return "Block:\n" +
                    "Id: " + id + "\n" +
                    "Timestamp: " + timeStamp + "\n" +
                    "Magic number: " + magicNumber + "\n" +
                    "Hash of the previous block:\n" +
                    hashOfPrevious + "\n" +
                    "Hash of the block:\n" +
                    hash + "\n" +
                    "Block was generating for " + generatingTime + " seconds";
        }
    }

}


