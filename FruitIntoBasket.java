package SlidingWindow;

import java.util.HashMap;

public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> basket = new HashMap<>(); //fruit type - > freq
        int left = 0;
        int totalFruits = 0;

        for(int right = 0; right < fruits.length; right++){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while(basket.size() > 2){
                basket.put(fruits[left], basket.get(fruits[left]) - 1);

                if(basket.get(fruits[left]) == 0){
                    basket.remove(fruits[left]);
                }

                left++;
            }

            totalFruits = Math.max(totalFruits, right - left  + 1);
        }
        return totalFruits;
    }
}