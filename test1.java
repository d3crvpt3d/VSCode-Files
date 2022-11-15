import java.util.Arrays;

/*
Radix sort from Scratch
by Yoel-Carl Mansfeld (239110)
*/
public class test1{
    public static void main(String[] args){

        int laenge = 1000; //für sehr hohe zahlen am besten ARRAY PRINT auskommentieren (10000000 max,da java heap space)

        int[] array = new int[laenge];

        //array befüllen
        for(int i=0;i<laenge;i++){
            array[i] = (int)(Math.random()*(99999));//durch Integer.MAXVALUE beschänkt :(
        }

        test1 var = new test1();


        long start = System.nanoTime();//start Time
        var.method(array);
        long end = System.nanoTime();//End Time
        System.out.println("DONE!");


        int[] s_arr = var.method(array);
        System.out.println("Array:");

        System.out.println(Arrays.toString(var.method(array))); //ARRAY PRINT
        
        //überprüfung
        boolean sorted = false;
        for(int i=0;i<s_arr.length;i++){
            if(s_arr[i]<=s_arr[i++]){
                sorted = true;
            }
        }

        if(sorted){
            System.out.println("Sorted!");
        }else{
            System.out.println("LOL, das kann nicht passieren aka. nicht sortiert");
        }

        //adaptive zeitausgabe(für längere zeiten wird eine nicht so präzise Einheit gewählt)
        if(String.valueOf((end-start)).length() > 8){
            System.out.println("Time: "+(end-start)/1000000000.0+" seconds");
        }else if(String.valueOf((end-start)).length() > 5){
            System.out.println("Time: "+(end-start)/1000000.0+" milliseconds");
        }else if(String.valueOf((end-start)).length() > 2){
            System.out.println("Time: "+(end-start)/1000.0+" microseconds");
        }else{
            System.out.println("Time: "+(end-start)+" nanoseconds");
        }
    }

    public int[] method(int[] array){
        int arr_length = array.length;
        int[] new_array = array;
        int maxdigits = maxOfBox(new_array, arr_length);
        return iterateStep(new_array, maxdigits, arr_length);
    }

    //returns max digits of the highest number in the array //DONE
    public int maxOfBox(int[] array_b, int arr_length){
        int tmp = 0;
        for(int i=0; i < arr_length; i++){
            int len = Integer.toString(array_b[i]).length();
            if(len > tmp){
                tmp = len;
            }
        }
        return tmp;
    }

    //sort with array and iterate input
    public int[] iterateStep(int[] new_array, int maxdigits, int arr_length){
        int tmp_dig;
        for(int m = 0; m<maxdigits;m++){
            int[][] cache = new int[10][arr_length];//cache für die zahlen
            int[] p = {0,0,0,0,0,0,0,0,0,0};//postiton for each insert
            for(int x=0;x<arr_length;x++){
                tmp_dig = (new_array[x]/(int)Math.pow(10, m))%10;//calculates the n-last digit of current number
                if(tmp_dig == 0){
                    cache[0][p[0]] = new_array[x];
                    p[0]++;
                    
                }else if(tmp_dig == 1){
                    cache[1][p[1]] = new_array[x];
                    p[1]++;
                    
                }else if(tmp_dig == 2){
                    cache[2][p[2]] = new_array[x];
                    p[2]++;
                    
                }else if(tmp_dig == 3){
                    cache[3][p[3]] = new_array[x];
                    p[3]++;
                    
                }else if(tmp_dig == 4){
                    cache[4][p[4]] = new_array[x];
                    p[4]++;
                    
                }else if(tmp_dig == 5){
                    cache[5][p[5]] = new_array[x];
                    p[5]++;
                    
                }else if(tmp_dig == 6){
                    cache[6][p[6]] = new_array[x];
                    p[6]++;
                    
                }else if(tmp_dig == 7){
                    cache[7][p[7]] = new_array[x];
                    p[7]++;
                    
                }else if(tmp_dig == 8){
                    cache[8][p[8]] = new_array[x];
                    p[8]++;
                    
                }else if(tmp_dig == 9){
                    cache[9][p[9]] = new_array[x];
                    p[9]++;
                    
                }else{
                    System.out.println(new_array[x]+": Input nicht 0-9!");
                }
            }
            int o = 0;//counter for out_arr insertion
                for(int k = 0; k < 10;k++){
                    for(int j=0; j < p[k]; j++){
                        new_array[o] = cache[k][j];
                        o++;
                    }
                }
        }
        return new_array;
    }
}
