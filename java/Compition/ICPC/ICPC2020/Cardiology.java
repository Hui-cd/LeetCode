package Compition.ICPC.ICPC2020;

/**
 * A spectator secretly selects a number between 1 and 21,
 * inclusive, after which Cardoni deals the 21 cards, face-up, row by row in order from 1 to 21, into a 3-column grid.
 * The spectator then indicates which of the three columns contains the selected card,
 * at which point the magician picks up the cards by columns,
 * picking up the specified column second (the order of collecting the other two columns is unimportant).
 * Cards are collected face up,
 * beginning with the top card in each column and placing each succeeding card immediately beneath the previously collected card.
 * The cards are then redealt by rows into a 3-column grid, starting from the top of the face-up deck.
 * The process is repeated two more times; each time, the column indicated by the spectator is the second column picked up by the magician.
 * After three such iterations, Cardoni announces, “I have penetrated to the heart of your mind; your card lies at the heart of this display.
 * ” And it’s true—the selected card is located at the “heart” of the array (row four, column two).
 * Moreover, the selected card will always remain in this stable location for any further iterations of the column indication and card redealing process.
 */

/**
 *
 * The input consists of a single line with two integers r and c (2 ≤ r, c ≤ 106), the number of rows and columns used in the trick. The cards are numbered from 1 to r · c and are initially dealt row by row in increasing order.
 * Output a line containing four integers p, i, j, and s, where:
 * • the column indicated by the spectator should be picked up as the pth column,
 * • using this value of p causes all cards to eventually end up in the stable location at row i column j, and
 * • s is the maximum number of iterations required for any card to reach the stable location.
 */
public class Cardiology {

    public void cardTransfer(int r, int c){
        int s1=-1;
        int i =-1;
        int j =-1;
        int s2=0;
        for (int p=0;p<c;p++){
            for (int x = 0,y=0;x!=j ||y!=i;s1++){
                i =x;
                j = y;
                x =(y + p*r) % c;
                y =(y + p*r) / c;
            }
            if (i > 0 && j == 0 || i < r-1 && j == c-1) continue;
            for (int x = c-1, y = r-1; x != j || y != i; s2++) {
                x = (y + p*r) % c;
                y = (y + p*r) / c;
            }
            int d = Math.min(Math.abs((c-1)/2 - j),(c/2 - j)) + Math.min(Math.abs((r-1)/2 - i), Math.abs(r/2 - i));

        }

    }

}
