package Zad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Permutacje <T>{
    private List<List<T>> result;
    private List<List<T>> data;

    public List<List<T>> permutate(List<List<T>> data) {
        this.data = data;
        this.result = new ArrayList<>();

        List<T> integers = new ArrayList<T>((Collection<? extends T>) Collections.nCopies(data.size(), 0));
        permutuj(0, data.size() - 1, (List<T>) integers);
        return result;
    }
    private void permutuj(int index, int maxIndex, List<T> output) {
        List<T> list = data.get(index);
        for (int i = 0; i < list.size(); i++) {
            output.set(index, list.get(i));
            if (index == maxIndex) {
                result.add(new ArrayList<>(output));
            } else {
                permutuj(index + 1, maxIndex, output);
            }
        }
    }
}