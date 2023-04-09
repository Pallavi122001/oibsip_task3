
package com.mycompany.collection;
import java.util.ArrayList;

public class ArrayListDemo {
   
    public static void main(String[] args) {
        
       ArrayList<Integer> arrayList = new ArrayList<>(10);
       
       for(int i=1;i<=5;i++){
           arrayList.add(i);
       }
       System.out.println(arrayList);
    }
    }

