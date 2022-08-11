public class Main {
    public static void main(String[] args){
        Item tv = new Item(2699.99,"Electronics", "Samsung 4KUDHD 65\"");
        Item tv2 = new Item(1699.99,"Electronics","LG 4KUDHD 55\"");
        Item tv3 = new Item(699.99,"Electronics","Samsung 1080P 42\"");
        Item tv4 = new Item(399.99,"Electronics","Samsung 720p 32\"");
        Item tv5 = new Item(99.99,"Electronics", "Samsung CRT 27\"");

        Item[] items = {tv,tv2,tv3,tv4,tv5};

        // 1
        for(int index = 0; index < items.length; index ++){
            if(items[index].getPrice() >= 500 && items[index].getPrice() <= 1000){
                System.out.println("$500-$1000 > " + items[index].getName());
            }
        }
        System.out.println("");
        // 2
        for(int index = 0; index < items.length; index ++){
            if(items[index].getName().indexOf("Samsung") != -1){
                System.out.println("Samsung Product > " + items[index].getName());
            }
        }
        System.out.println("");
        // 3
        for(int index = 0; index < items.length; index ++){
            Item LoopItem = items[index];
            String StringHeight = LoopItem.getName().substring(LoopItem.getName().length()-3);
            int Height = Integer.parseInt(StringHeight.substring(0,2));
            if(Height > 40){
                System.out.println("Larger than 40\" > " + LoopItem.getName());
            }
        }
        System.out.println("");
        // 3b
        for(int index = 0; index < items.length; index ++){
            Item LoopItem = items[index];
            String StringHeight = LoopItem.getName().substring(LoopItem.getName().lastIndexOf(" ") + 1);
            int Height = Integer.parseInt(StringHeight.substring(0,StringHeight.length()-1));
            if(Height > 40){
                System.out.println("Larger than 40\" > " + LoopItem.getName());
            }
        }
    }
}