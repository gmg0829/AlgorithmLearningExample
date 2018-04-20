package com.gmg.bless;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gmg on on 2018-01-17 10:30.
 */
public class GradeBlessEnvel
{
    public static void main(String[] args) {
        //等级福包
        List<Bless> list=new ArrayList<>();
        Bless bless1=new Bless(10,5);
        Bless bless2=new Bless(20,20);
        Bless bless3=new Bless(30,10);
        list.add(bless1);
        list.add(bless2);
        list.add(bless3);
        int weightSum = 0;
        for (Bless b : list) {
            weightSum += b.getCount();
        }

        Random random = new Random();

        Integer n = random.nextInt(weightSum); // n in [0, weightSum)
        Integer m = 0;

        Double univalence = new Double("0");
        int count = 0;
        double amount=0;

        Bless beg4Update = new Bless();
        for (Bless beg : list) {
            if (m <= n && n < m + beg.getCount()) {

                univalence = beg.getAmount();
                count = beg.getCount();

                beg4Update = beg;

                break;
            }
            m += beg.getCount();
        }

        amount = univalence.doubleValue();//获取福包金额
//        beg4Update.setCount(count - 1);
        System.out.println(amount);
    }
}
