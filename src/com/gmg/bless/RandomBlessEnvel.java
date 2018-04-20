package com.gmg.bless;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gmg on on 2018-01-17 11:54.
 */
public class RandomBlessEnvel {
    public static void main(String[] args) {

        double amount = randomAmount4Rand(10, 100);
        System.out.println(amount);

    }

    private static double randomAmount4Rand(int intNumber, double totalAmount) {
        if (intNumber == 0 || totalAmount == 0) {
            throw new RuntimeException("数量或金额参数不正确");
        }

        double bvPerAmount;

        DecimalFormat dcmFmt = new DecimalFormat("0.00");

        if (intNumber == 1) {  //最后一个福包
            bvPerAmount = Double.valueOf(dcmFmt.format(totalAmount));
        } else {
            Double randomMoney = new Random().nextDouble() * (totalAmount / 3 - 0.01) + 0.01;//生成0.01到总金额三分之一的随机数
            bvPerAmount = Double.valueOf(dcmFmt.format(randomMoney));
            while (bvPerAmount == 0) {
                //不合法，重新生成
                bvPerAmount = randomAmount4Rand(intNumber, totalAmount);
            }
        }
        return bvPerAmount;
    }
}

