import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.math.*;


public class MineSweeper {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Harita boyutu kaça kaç olsun !");
        System.out.print("boy değeri giriniz :");
        int a = scan.nextInt();
        System.out.print("en değeri giriniz :");

        int b = scan.nextInt();
        int indis= (a*b)/4;
        int denemesayisi=(a*b)-(a*b)/4;
       // System.out.println(indis); Mayın sayısı
        Random rand=new Random();


       String[][] tablo = new String[a][b];
        String[][] tablo1 = new String[a][b]; // mayınların görünmediği harita

        for (int i = 0; i < a; i++) {       // tablomuzu "-" işaretleriyle doldurduk
            for (int j = 0; j < b; j++) {
                tablo[i][j] ="-";
                tablo1[i][j] ="-";


            }
        }for (int k=0;k < indis; k++){   // rastgele secilen sayıları tabloya mayın olarak ekledik
            int x= rand.nextInt(a-1);
            int y= rand.nextInt(b-1);
          //  System.out.println(k+":"+"x ="+x+" "+"y = "+y); Rastgele seçilen noktalar
            if (tablo[x][y] !="*") {

                tablo[x][y] ="*";
            } else k--;
        }
        System.out.println("mayınlı harita");
        for (String[] row : tablo) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();

        }
        System.out.println("===========");
        for (String[] row : tablo1) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();

        } for (int i=0;i<denemesayisi;i++) {   // matrisdeki toplam nokta sayısından mayınlı alanı çıkarıp deneme sayısını bulduk
            int sayac=0;                       // büyükçe bir sayıda yazılabilirdi illa deneme sayısı bulmak şart degil
            System.out.print("Satır giriniz :");
            int satir = scan.nextInt();
            if (satir>a){
                System.out.println("gecersiz bir deger girdiniz"); // girilen satır ve sutun sayıları matrisden büyükse-
                i--;
                continue;                                           //- hata vermeyip tekrar sayı alınmasını sağladık
            }

            System.out.print("Sütun giriniz :");
            int sutun = scan.nextInt();
            if (sutun>b) {
                System.out.println("gecersiz bir deger girdiniz");
                i--;
                continue;
            }
            System.out.println("===================");
            if (tablo[satir][sutun] =="*") {
                System.out.println("oyunu kaybettiniz");
                break;
            } else if (satir==0 && sutun==0){           // girilen satır ve sütun sayılarının 1'er eksik ve fazlasını taratarak
                                                        // etrafındaki indislerin taranmasını ve mayın varsa sayacın arttırılmasını sağladık
                for (int e=0;e<=1;e++){
                    for (int f=0;f<=1;f++){
                       if (tablo[e][f]=="*"){
                           sayac++;
                       }}}}
            else if ((satir>0 || satir<a-1) && sutun==0){
                for (int e=satir-1;e<satir+1;e++){
                    if (tablo[e][0] == "*") {
                        sayac++;
                    }
                    if (tablo[e][1] == "*") {
                        sayac++;
                    }
                }}
            else if (satir==0 && sutun <b-1){
                for (int e=satir;e<=satir+1;e++){
                    for (int f=sutun-1;f<sutun+1;f++)
                        if (tablo[e][f] == "*") {
                            sayac++;
                        }
                }}
            else if (satir==0 && sutun ==b-1){
                for (int e=satir;e<=satir+1;e++){
                    for (int f=sutun-1;f<sutun;f++)
                        if (tablo[e][f] == "*") {
                            sayac++;
                        }
                }}

            else if (satir==a-1 && sutun==b-1){
                for (int e=satir-1;e<=satir;e++){
                    for (int f=sutun-1;f<=sutun;f++){
                        if (tablo[e][f]=="*"){
                            sayac++;
                        }}}}
            else if ((satir-1>0||satir < a-1) && sutun==b-1){
                for (int e=satir-1;e<=satir+1;e++){
                    for (int f=sutun-1;f<=sutun;f++){
                        if (tablo[e][f]=="*"){
                            sayac++;
                        }}}}

            else if (satir<a-1 && sutun<b-1){
                for (int e=satir-1;e<=satir+1;e++){
                    for (int f=sutun-1;f<=sutun+1;f++){
                        if (tablo[e][f]=="*"){
                            sayac++;
                        }}}}
            else if (satir==a-1 && sutun<b-1){
                for (int e=satir-1;e<satir+1;e++){
                    for (int f=sutun-1;f<=sutun+1;f++){
                        if (tablo[e][f]=="*"){
                            sayac++;
                        }}}}





                tablo1[satir][sutun]=String.valueOf(sayac);
            for (String[] row : tablo1) {
                for (String col : row) {
                    System.out.print(col);
                }
                System.out.println();
            }}}}

