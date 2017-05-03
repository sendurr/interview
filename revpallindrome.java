class pallinclass{

    public int reveNum(int n){
        int a, b=0;
        while(n!=0){
            a=n/10;
            b=b*10 + (n%10);
            n=a;
        }
        return b;
    }
    
    public void checkrevpali(int n){
        int nRev =  reveNum(n);
        if(n == nRev){
            System.out.println(n);
            System.out.println(nRev);
            System.out.println("The number is already a rev pallin");
        }else{
            while(n!=nRev){
                System.out.println(n);
                System.out.println(nRev);
                System.out.println();
                n = n + nRev;
                nRev =  reveNum(n);
            }
            System.out.println("The rev pallin is " + n);
        }
    }
}

class revpallindrome{
    public static void main(String args[]){
        pallinclass b = new pallinclass();
        b.checkrevpali(7325);
    }
}