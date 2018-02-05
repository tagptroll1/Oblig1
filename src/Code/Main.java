package Code;

public class Main {
    public static void main(String[] args) {
        /*Code.ArrayBag<Code.Coin> coinBag = new Code.ArrayBag<>();
        coinBag.add(new Code.Coin(20,1996));

        //Meh way?
        Object[] objectArray = coinBag.toArray();
        Code.Coin aCoin = (Code.Coin) objectArray[0];
        System.out.println(aCoin.getValue());

        //Ok way?
        Code.Coin[] coinArray = coinBag.toArray(new Code.Coin[0]);
        System.out.println(coinArray[0].getValue());*/
    }

    public static void countDown(int i){
        System.out.println(i + "");
        if (i > 1){
            countDown(i - 1);
        }
        System.out.println("Done!");
    }
}
