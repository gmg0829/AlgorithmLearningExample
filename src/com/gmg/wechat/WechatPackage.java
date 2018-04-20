package wechat;

import java.util.Random;

/**
 * Created by gmg on 2017/11/30.
 */
public class WechatPackage {

    public static double getRandomMoney(RedPackage _redPackage) {
        //首先public一个class，也就是整个分手气红包的过程
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1) {
            //如果只剩最后一个红包
            _redPackage.remainSize--;
            //剩余红包个数减一
            return (double) Math.round(_redPackage.remainMoney * 100) / 100;
            //返回double型的值，也就是最后一个红包的面额（换算成元）
        }
        //若剩余红包不止一个
        Random r     = new Random();
        //定义了一个随机数 r
        //（这里他妈有个坑，谁知道JAVA的随机数是不是伪随机数）先不管，一会再说。
        double min   = 0.01;
        // 定义红包最小面额是一分钱
        //也就是我抢的最多的那个面额
        double max   = _redPackage.remainMoney / _redPackage.remainSize * 2;
        //定义红包的最大面额是 剩余平均值X2
        double money = r.nextDouble() * max;
        //定义你抢到的钱（money）= 随机数r X 最大值
        //r是 Random 类型的，所以r.nextDouble是一个随机数
        money = money <= min ? 0.01: money;
        //若这个数特么的居然小于0.01，那只能给你一分咯
        //说明你人品可能比你想象的还差
        money = Math.floor(money * 100) / 100;
        //Math.floor的意思是取小于这个浮点数最接近整数
        //这就是你抢到的钱
        _redPackage.remainSize--;
        //红包个数减一
        _redPackage.remainMoney -= money;
        //总钱数扣除
        return money;
        //小手一抖，红包我有
    }


    public static void main(String[] args) {
        RedPackage redPackage=new RedPackage();
        redPackage.setRemainMoney(30);
        redPackage.setRemainSize(100);
        System.out.println(getRandomMoney(redPackage));
    }
}
