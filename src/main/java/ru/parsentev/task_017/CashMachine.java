package ru.parsentev.task_017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // отсортируем в обратном порядке массив номиналов
        Arrays.sort(values);
        int container = 0;
        int lastValueIdx = values.length - 1;
        for (int i = 0; i < values.length / 2; i++) {
            container = values[lastValueIdx - i];
            values[lastValueIdx - i] = values[i];
            values[i] = container;
        }
        for (int i = 0; i < values.length; i++) {
            int coinSize = values[i];
            int whole = note / coinSize;
            int mod = note % coinSize;
            List<Integer> coins = new ArrayList<Integer>(Collections.nCopies(whole, coinSize));
            // если купюра делится самым крупным номиналом монеты нацело
            if (mod == 0) {
                // то добавим создадим вариант размена купюры набором из монет этого номинала
                result.add(coins);
            } else {
                // иначе попробуем остаток поделить номиналом монеты следующего (меньшего) размера
                coinSize = values[i + 1];
                whole = mod / coinSize;
                mod = mod % coinSize;
                // делаем вариант размена монетами предыдущего номинала и текущего
                coins = new ArrayList<Integer>(coins);
                coins.addAll(Collections.nCopies(whole, coinSize));
                if (mod == 0) {
                    result.add(coins);
                } else {
                    // TODO кажется здесь используется рекурсия.
                }
            }
        }
        return result;
    }
}
