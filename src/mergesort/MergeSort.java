/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dr.Abuzant
 */
public class MergeSort {
  static void merge(ArrayList<Integer> A,int last,ArrayList<Integer> T){
      
        if(last>=A.size()){
            for(int i=0;i<A.size();i++){
                A.set(i, T.get(i));
            }
            return;
        }
        if(last==1)
        for(int i=0;i<=last;i++){
            T.add(i,A.get(i));
        }   
        else{
            T.add(A.get(last));
        }
        int j=last;
        for(int i=last;i>0;i--){
            if(T.get(j)<T.get(i-1)){
                int swap = T.get(j);
                T.set(j,T.get(i-1));
                T.set(i-1,swap);
                j=i-1;
            }
        }
        

        merge(A,last+1,T);
        
  }
  
    public static void main(String[] args) {
        int numOfElements;
        ArrayList<Integer> TempR= new ArrayList<>();
          ArrayList<Integer> TempL= new ArrayList<>();
        ArrayList<Integer>bRight= new ArrayList<>();
        ArrayList<Integer>bLeft= new ArrayList<>();
        ArrayList<Integer> elementsint=new ArrayList<>();
        Scanner read= new Scanner(System.in);
        numOfElements= read.nextInt();
        for (int i=0 ;i < numOfElements;i++)
        {
         elementsint.add(read.nextInt());
        }
        for(int i=0;i<(numOfElements/2);i++){
            bLeft.add(elementsint.get(i));
        }
        for(int i=numOfElements/2;i<numOfElements;i++){
            bRight.add(elementsint.get(i));
        }
        
      merge(bRight,1,TempR);
      merge (bLeft,1,TempL);
      System.out.println(bRight);
      System.out.println(bLeft);
      elementsint.clear();
      for(int i=0;i<bRight.size();){
           if(bLeft.isEmpty()){
                 elementsint.add(bRight.get(i));
                 break;
              }
          for(int j=0;j<bLeft.size();j++){
                if(bRight.get(i)<bLeft.get(j)){
                   elementsint.add(bRight.get(i));
                   i++;
                   break;   
                }
                else if(bLeft.get(j)<bRight.get(i)){
                    elementsint.add(bLeft.get(j));
                    bLeft.remove(j);
                   break;
                }
          }
      }
        if(!(bLeft.isEmpty())){
            for(int k=0;k<bLeft.size();k++){
              elementsint.add(bLeft.get(k));
                    
            }
           }
      System.out.print("[");
          for(int i=0;i<numOfElements;i++){
              if(i==numOfElements-1){
                  System.out.print(elementsint.get(i));
              }
              else{
               System.out.print(elementsint.get(i)+",");
              }
          }
            System.out.print("]");
    }
    
}
