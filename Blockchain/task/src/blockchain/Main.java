package blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        for (int i = 0; i < 5; i++) {
            blockchain.addBlock();
        }

        for (Blockchain.Block block : blockchain.getBlocks()) {
            System.out.println(block);
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

    public void addBlock() {

        Block block = new Block(++currentId, getHashOfLast());
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

        if (blocks.size()<=1) {
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

        public Block(int id, String hashOfPrevious) {
            this.id = id;
            this.hashOfPrevious = hashOfPrevious;
            hash = StringUtil.applySha256("" + id + timeStamp + hashOfPrevious);
        }

        @Override
        public String toString() {
            return "Block:\n" +
                    "Id: " + id + "\n" +
                    "Timestamp: " + timeStamp +"\n" +
                    "Hash of the previous block:\n"
                    + hashOfPrevious + "\n" +
                    "Hash of the block:\n"
                    + hash + "\n";
        }
    }

}


