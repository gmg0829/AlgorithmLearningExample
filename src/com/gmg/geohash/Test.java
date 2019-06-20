package com.gmg.geohash;

/**
 * @author gmg
 * @title: Test
 * @projectName AlgorithmLearningExample
 * @description: TODO
 * @date 2019/6/20 16:40
 */

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class Test {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://132.97.**.**/test?"
                + "user=***&password=****&useUnicode=true&characterEncoding=UTF8";

        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
            sql = "select * from retailersinfotable limit 1,10";
            ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            double lon1=109.0145193757;
            double lat1=34.236080797698;
            System.out.println("当前位置：");
            int i=0;
            String[][] array = new String[10][3];
            while (rs.next()){
                //从数据库取出地理坐标
                double lon2=Double.parseDouble(rs.getString("Longitude"));
                double lat2=Double.parseDouble(rs.getString("Latitude"));

                //根据地理坐标，生成geohash编码
                Geohash geohash = new Geohash();
                String geocode=geohash.encode(lat2, lon2).substring(0, 9);

                //计算两点间的距离
                int dist=(int) Distance.GetDistance(lon1, lat1, lon2, lat2);

                array[i][0]=String.valueOf(i);
                array[i][1]=geocode;
                array[i][2]=Integer.toString(dist);

                i++;

                //	System.out.println(lon2+"---"+lat2+"---"+geocode+"---"+dist);	
            }

            array=Test.getOrder(array); //二维数组排序
            Test.showArray(array);        //打印数组




        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }
    /*
     * 二维数组排序，比较array[][2]的值，返回二维数组
     * */
    public static String[][] getOrder(String[][] array){
        for (int j = 0; j < array.length ; j++) {
            for (int bb = 0; bb < array.length - 1; bb++) {
                String[] ss;
                int a1=Integer.valueOf(array[bb][2]);  //转化成int型比较大小
                int a2=Integer.valueOf(array[bb+1][2]);
                if (a1>a2) {
                    ss = array[bb];
                    array[bb] = array[bb + 1];
                    array[bb + 1] = ss;

                }
            }
        }
        return array;
    }

    /*打印数组*/
    public static void showArray(String[][] array){
        for(int a=0;a<array.length;a++){
            for(int j=0;j<array[0].length;j++)
                System.out.print(array[a][j]+" ");
            System.out.println();
        }
    }

}