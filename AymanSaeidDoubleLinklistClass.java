
import java.util.Random;

public class AymanSaeidDoubleLinklistClass {

    AymanSaeidNodeClass head;
    int maxsize = 15;
    int size;
    

    public void addLast(int data) {
        if (size > maxsize) {
            System.out.println("the list is full & your data will not be added to the list !!!  :  ");
            return;
        }
        size++;
        AymanSaeidNodeClass newNode = new AymanSaeidNodeClass(data);
        AymanSaeidNodeClass temp = head;

        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            if (size % 5 == 0) {
                temp.down = newNode;
            }
        }
    }

    public void printlist() {
        AymanSaeidNodeClass row = head;
        int count = 0;
        while (row != null) {
            AymanSaeidNodeClass column = row;
            while (column != null) {
                if (column.data == -1) {
                    System.out.print("-- ");
                } else {
                    System.out.print(column.data + " ");
                }
                column = column.next;
                count++;
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
            row = row.down;
        }
    }

    void convertintolist(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == -1) {
                    continue;
                }
                addLast(array[i][j]);
            }
        }
    }

    boolean Checknum(int num) {
        boolean found = false;
        AymanSaeidNodeClass row = head;
        while (row != null) {
            AymanSaeidNodeClass column = row;
            while (column != null) {
                    if (column.data == num) {
                        column.data = -1;
                        found = true;
                    }
                column = column.next;
            }
            row = row.down;
        }
        return found;
    }

 boolean checkBINGO() {
    AymanSaeidNodeClass row = head;
    int bingosize = 0;
    while (row != null) {
        AymanSaeidNodeClass column = row;
        boolean bingo = true;
        while (column != null) {
            if (column.data != -1) {
                bingo = false;
                break;
            }
            column = column.next;
        }
        if (bingo) {

            System.out.println("        B I N G O   ( Game End. ) ");
            
            return true;
        }
        row = row.down; 
    }
    return false;
}
    public static int[][] generateCard1() {
        Random random = new Random();
        int[][] card = new int[3][9];
        for (int i = 0; i < 3; i++) {         // fill the card with -1 .
            for (int j = 0; j < 9; j++) {
                card[i][j] = -1;
            }
        }
        for (int i = 0; i < 3; i++) {
            boolean[] selected = new boolean[90];
            int col = 0;
            while (col < 5) {
                int randomNumber = random.nextInt(90) + 1; //random number between 1 and 90
                if (!selected[randomNumber - 1]) { 
                    card[i][col] = randomNumber;
                    selected[randomNumber - 1] = true; 
                    col++;
                }
            }
        }
        return card;
    }
    
}
